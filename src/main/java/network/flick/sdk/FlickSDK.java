package network.flick.sdk;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Call;
import okhttp3.MediaType;


public class FlickSDK {
    private OkHttpClient client;
    private String baseUrl;
    private String apiKey;

    public static final String ENVIRONMENT_SANDBOX = "sandbox";
    public static final String ENVIRONMENT_PRODUCTION = "production";

    /**
     * @param environment : specify the type of environment type
     * @param apiKey      : API key goes here
     */
    public FlickSDK(String environment, String apiKey) {
        this.client = new OkHttpClient();
        this.baseUrl = getBaseUrl(environment);
        this.apiKey = apiKey;
    }

    private String getBaseUrl(String environment) {
        if (ENVIRONMENT_SANDBOX.equals(environment)) {
            return "https://sandbox-api.flick.network";
        } else if (ENVIRONMENT_PRODUCTION.equals(environment)) {
            return "https://api.flick.network";
        }
        throw new IllegalArgumentException(
                "Use either FlickSDK.ENVIRONMENT_SANDBOX or FlickSDK.ENVIRONMENT_PRODUCTION");
    }

    public Call sendGetRequest(String url) {
        Request request = new Request.Builder()
                .addHeader("Authorization", "Bearer " + apiKey)
                .url(baseUrl + "/" + (url.startsWith("/")?url.substring(1):url))
                .get()
                .build();

        return client.newCall(request);

    }

    public Call sendPostRequest(String url, String jsonBody) {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(jsonBody, JSON);

        Request request = new Request.Builder()
                .url(baseUrl + "/" + (url.startsWith("/")?url.substring(1):url))
                .addHeader("Authorization", "Bearer " + apiKey)
                .post(requestBody)
                .build();

        return client.newCall(request);

    }

}
