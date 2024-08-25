package lk.ijse.test.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeavyService {

    @Value("${weavy.api.url}")
    private String apiUrl;

    @Value("${weavy.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public WeavyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");
        return headers;
    }

    public ResponseEntity<String> createUser(String userJson) {
        String url = apiUrl + "/users";
        HttpEntity<String> requestEntity = new HttpEntity<>(userJson, createHeaders());
        return restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
    }

    public ResponseEntity<String> listUsers() {
        String url = apiUrl + "/users";
        HttpEntity<String> requestEntity = new HttpEntity<>(createHeaders());
        return restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
    }

    public ResponseEntity<String> getUserDetails(String userId) {
        String url = apiUrl + "/users/" + userId;
        HttpEntity<String> requestEntity = new HttpEntity<>(createHeaders());
        return restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
    }

    public ResponseEntity<String> updateUser(String userId, String userJson) {
        String url = apiUrl + "/users/" + userId;
        HttpEntity<String> requestEntity = new HttpEntity<>(userJson, createHeaders());
        return restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
    }

    public ResponseEntity<String> deleteUser(String userId) {
        String url = apiUrl + "/users/" + userId;
        HttpEntity<String> requestEntity = new HttpEntity<>(createHeaders());
        return restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class);
    }
}
