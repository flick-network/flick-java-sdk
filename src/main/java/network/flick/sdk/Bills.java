package network.flick.sdk;

import okhttp3.Call;

public class Bills {
    private FlickSDK client;

    /**
     * @param environment : specify the type of environment type
     * @param apiKey      : API key goes here
     */
    public Bills(String environment, String apiKey) {
        this.client = new FlickSDK(environment, apiKey);
    }

    public Call onboardEGS(String egsDataJson) {

        return client.sendPostRequest("egs/onboard", egsDataJson);

    }

    public Call doComplianceCheck(String egsUuid) {

        return client.sendGetRequest("egs/compliance-check/" + egsUuid);

    }

    public Call generateInvoice(String invoiceDataJson) {

        return client.sendPostRequest("invoice/generate", invoiceDataJson);

    }
}
