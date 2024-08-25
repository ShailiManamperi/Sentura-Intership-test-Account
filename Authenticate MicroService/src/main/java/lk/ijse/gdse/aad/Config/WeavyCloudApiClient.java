package lk.ijse.gdse.aad.Config;

import okhttp3.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.io.IOException;

@CrossOrigin
@Controller
public class WeavyCloudApiClient {
    private static final String BASE_URL = "https://4f49804e1ffa4dd2b5d31ce26f56cb12.weavy.io/api";
    private final String apiKey = "wys_gQHOQp9r8sGv4YM8TB2g65nAruN8Xw3TN3tI";

    private final OkHttpClient client = new OkHttpClient();

    public String getSomeData() throws Exception {
        Request request = new Request.Builder()
                .url(BASE_URL + "/some-data")  // Corrected endpoint path
                .header("Authorization", "Bearer " + apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            return response.body().string();
        }
    }
}


