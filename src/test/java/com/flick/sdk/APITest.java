package com.flick.sdk;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;


public class APITest {

    private FlickSDK api = new FlickSDK(FlickSDK.ENVIRONMENT_SANDBOX, "");

    @Test
    public void testOnboardEGS() {
        assertThat(api.onboardEGS("").toString(), containsString("Hello"));
    }

    @Test
    public void testGenerateInvoice() {
        assertThat(api.generateInvoice("").toString(), containsString("Hello"));
    }

    @Test
    public void testDoComplianceCheck() {
        assertThat(api.doComplianceCheck("").toString(), containsString("Hello"));
    }

}