package com.zessh.jumbo.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class KeycloakService {

    @Value("${info.keycloak.client.id}")
    private String clientId;

    @Value("${info.keycloak.grant.type}")
    private String grant_type;

    @Value("${info.keycloak.get.token.user}")
    private String urlGetToken;

    @Value("${info.keycloak.admin.client.id}")
    private String adminClientId;

    @Value("${info.keycloak.admin.username}")
    private String adminUserName;

    @Value("${info.keycloak.admin.password}")
    private String adminPassword;

    @Value("${info.keycloak.admin.url.token}")
    private String adminUrlToken;

    @Value("${info.keycloak.get.id.user}")
    private String urlGetIdUser;

    @Value("${info.keycloak.get.id.roles}")
    private String urlGetRoles;

    @Value("${info.keycloak.url.user}")
    private String urlUser;

    public ResponseEntity<String> getToken(String username, String password){
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", clientId);
        formData.add("username", username.trim());
        formData.add("password", password.trim());
        formData.add("grant_type", grant_type);

        HttpEntity<MultiValueMap<String, String>> entity
                = new HttpEntity<MultiValueMap<String,String>>(formData, headers);

        var result = rt.postForEntity(urlGetToken, entity, String.class);

        return result;
    }



    public String getTokenAdmin() throws JsonProcessingException {
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("client_id", adminClientId);
        formData.add("username", adminUserName);
        formData.add("password", adminPassword);
        formData.add("grant_type", grant_type);

        HttpEntity<MultiValueMap<String, String>> entity
                = new HttpEntity<MultiValueMap<String,String>>(formData, headers);

        ResponseEntity<String> response  = rt.postForEntity(adminUrlToken, entity, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(response.getBody());

        String accessToken = root.get("access_token").asText();

        return accessToken;
    }

    public String getUserId(String userName) throws JsonProcessingException {
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        String url = urlGetIdUser + userName;

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + getTokenAdmin());

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = rt.exchange(url, HttpMethod.GET, entity, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(response.getBody());
        ObjectMapper mapper = new ObjectMapper();
        List<JsonNode> nodeList = mapper.readValue(root.toString(), new TypeReference<List<JsonNode>>() {});

        return nodeList.get(0).get("id").asText();

    }

    public String getRelmId(String realmName) throws JsonProcessingException {
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        String roleID = null;
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + getTokenAdmin());

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = rt.exchange(urlGetRoles, HttpMethod.GET, entity, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode roles = objectMapper.readTree(response.getBody());
        for (JsonNode role : roles) {
            if (realmName.equals(role.get("name").asText())) {
                roleID = role.get("id").asText();
                break;
            }
        }

        return roleID;
    }
    public void createUser(String username, String firstName, String lastName, String email, String password  ) throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + getTokenAdmin());

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("username", username);
        requestBody.put("firstName", firstName);
        requestBody.put("lastName", lastName);
        requestBody.put("email", email);
        requestBody.put("enabled", true);

        Map<String, Object> credentials = new HashMap<>();
        credentials.put("type", "password");
        credentials.put("value", password);
        credentials.put("temporary", false);

        requestBody.put("credentials", new Object[]{credentials});

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(urlUser, requestEntity, String.class);

        if (response.getStatusCode() == HttpStatus.CREATED) {

            HttpHeaders headersForRole = new HttpHeaders();
            headersForRole.setContentType(MediaType.APPLICATION_JSON);
            headersForRole.set("Authorization", "Bearer " + getTokenAdmin());

            String userLocationHeader = response.getHeaders().getLocation().toString();
            String[] segments = userLocationHeader.split("/");

            String userId = segments[segments.length - 1];

            Map<String, Object> role = Map.of("id", getRelmId("USER"), "name", "USER");

            String assignRoleUrl = urlUser+"/"+userId+"/role-mappings/realm";

            HttpEntity<Object> request = new HttpEntity<>(Collections.singletonList(role), headers);

            ResponseEntity<String> roleAssignmentResponse = restTemplate.postForEntity(assignRoleUrl, request, String.class);
            System.out.println(roleAssignmentResponse);
        } else {
            System.out.println("Falha ao criar o usuário. Resposta: " + response.getBody());
        }
    }
    public void updatePassword(String userId, String newPassword) throws JsonProcessingException {

        String updatePasswordUrl = urlUser+"/" + userId + "/reset-password";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + getTokenAdmin());

        String newPasswordJson = "{\"type\":\"password\",\"temporary\":false,\"value\":\"" + newPassword + "\"}";

        HttpEntity<String> requestEntity = new HttpEntity<>(newPasswordJson, headers);

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.put(updatePasswordUrl, requestEntity);
    }


}
