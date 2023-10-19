package com.flickpackage;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.MediaType;

public class FlickJavaSDK {
    private OkHttpClient client;
    private String baseUrl;
    private String apiKey;

    public FlickJavaSDK(String environment, String apiKey) {
        this.client = new OkHttpClient();
        this.apiKey = apiKey;
        this.baseUrl = getBaseUrl(environment);
    }

    private String getBaseUrl(String environment) {
        if ("sandbox".equals(environment)) {
            return "https://sandbox-api.flick.network";
        } else {
            return "https://api.flick.network";
        }
    }

    public Response onboardEGS(String egsDataJson) {
        RequestBody requestBody = RequestBody.create(egsDataJson, MediaType.get("application/json"));
        Request request = new Request.Builder()
                .url(baseUrl + "/egs/onboard")
                .addHeader("Authorization", "Bearer " + apiKey)
                .post(requestBody)
                .build();

        try {
            return client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Response doComplianceCheck(String egsUuid) {
        Request request = new Request.Builder()
                .url(baseUrl + "/egs/compliance-check/" + egsUuid)
                .addHeader("Authorization", "Bearer " + apiKey)
                .get()
                .build();

        try {
            return client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Response generateInvoice(String invoiceDataJson) {
        RequestBody requestBody = RequestBody.create(invoiceDataJson, MediaType.get("application/json"));
        Request request = new Request.Builder()
                .url(baseUrl + "/invoice/generate")
                .addHeader("Authorization", "Bearer " + apiKey)
                .post(requestBody)
                .build();

        try {
            return client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
