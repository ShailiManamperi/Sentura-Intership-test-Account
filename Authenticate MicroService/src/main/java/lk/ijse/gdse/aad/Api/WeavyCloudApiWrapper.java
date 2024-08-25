package lk.ijse.gdse.aad.Api;

import lk.ijse.gdse.aad.Config.WeavyCloudApiClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weavy-cloud")
public class WeavyCloudApiWrapper {

    private final WeavyCloudApiClient weavyCloudApiClient;

    public WeavyCloudApiWrapper(WeavyCloudApiClient weavyCloudApiClient) {
        this.weavyCloudApiClient = weavyCloudApiClient;
    }

    @GetMapping("/user")
    public ResponseEntity<String> getSomeData() {
        try {
            String result = weavyCloudApiClient.getSomeData();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            // Log the exception for debugging
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching data from Weavy cloud");
        }
    }
}

