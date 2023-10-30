package com.flick.sdk;

import org.junit.Test;

import com.flick.sdk.types.EGSData;
import com.flick.sdk.types.EGSData.Device;
import com.flick.sdk.types.InvoiceData.*;
import com.flick.sdk.types.InvoiceData;
import com.google.gson.Gson;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;

public class APITest {

    private FlickSDK api = new FlickSDK(FlickSDK.ENVIRONMENT_SANDBOX, "");

    @Test
    public void testOnboardEGS() {

        EGSData egsData = new EGSData();
        egsData.setVatName("Test Co.");
        egsData.setVatNumber("300000000000003");

        // Create Device objects
        List<Device> devices = new ArrayList<>();

        EGSData.Device device1 = new Device();
        device1.setDeviceName("TestEGS1");
        device1.setCity("Riyadh");
        device1.setCitySubdiv("Test Dist.");
        device1.setStreet("Test St.");
        device1.setPlot("1234");
        device1.setBuilding("1234");
        device1.setPostal("12345");
        device1.setBranchName("Riyad Branch 1");
        device1.setBranchIndustry("Retail");
        device1.setOtp("123321");

        Device device2 = new Device();
        device2.setDeviceName("TestEGS2");
        device2.setCity("Riyadh");
        device2.setCitySubdiv("Test Dist.");
        device2.setStreet("Test St.");
        device2.setPlot("1234");
        device2.setBuilding("1234");
        device2.setPostal("12345");
        device2.setBranchName("Riyad Branch 2");
        device2.setBranchIndustry("Retail");
        device2.setOtp("321123");

        devices.add(device1);
        devices.add(device2);

        egsData.setDevices(devices);
        Gson gson = new Gson();
        assertThat(api.onboardEGS(gson.toJson(egsData)).toString(), containsString("Hello"));
    }

    @Test
    public void testGenerateInvoice() {

        InvoiceData invoiceData = new InvoiceData();
        invoiceData.setEgsUuid("7b9cc231-0e14-4bff-938c-4603fe10c4bc");
        invoiceData.setInvoiceRefNumber("INV-5");
        invoiceData.setIssueDate("2023-01-01");
        invoiceData.setIssueTime("01:40:40");

        // Create and set the partyDetails object
        PartyDetails partyDetails = new PartyDetails();
        partyDetails.setPartyNameAr("شركة اختبار");
        partyDetails.setPartyVat("300001111100003");

        PartyAddId partyAddId = new PartyAddId();
        partyAddId.setCrn(45463464);
        partyDetails.setPartyAddId(partyAddId);

        partyDetails.setCityAr("جدة");
        partyDetails.setCitySubdivisionAr("حي الشرفية");
        partyDetails.setStreetAr("شارع الاختبار");
        partyDetails.setPlotIdentification("1234");
        partyDetails.setBuilding("1234");
        partyDetails.setPostalZone("12345");

        invoiceData.setPartyDetails(partyDetails);

        invoiceData.setDocType("388");
        invoiceData.setInvType("standard");
        invoiceData.setPaymentMethod(10);
        invoiceData.setCurrency("SAR");
        invoiceData.setTotalTax(142.0);
        invoiceData.setHasAdvance(true);

        // Create and set the advanceDetails object
        AdvanceDetails advanceDetails = new AdvanceDetails();
        advanceDetails.setAdvanceAmount(575.0);
        advanceDetails.setTotalAmount(2875.0);

        // Create and set the advanceInvoices list
        AdvanceInvoice advanceInvoice = new AdvanceInvoice();
        advanceInvoice.setTaxCategory("S");
        advanceInvoice.setTaxPercentage(0.15);
        advanceInvoice.setTaxableAmount(500.0);
        advanceInvoice.setTaxAmount(75.0);

        // Create and set the invoices list
        Invoice invoice = new Invoice();
        invoice.setId("INV-1");
        invoice.setIssueDate("2022-12-10");
        invoice.setIssueTime("12:28:17");

        advanceInvoice.getInvoices().add(invoice);

        advanceDetails.getAdvanceInvoices().add(advanceInvoice);

        invoiceData.setAdvanceDetails(advanceDetails);

        // Create and set the lineItems list
        List<LineItem> lineItems = new ArrayList<>();
        LineItem lineItem1 = new LineItem();
        lineItem1.setNameAr("متحرك");
        lineItem1.setQuantity(1.0);
        lineItem1.setTaxCategory("S");
        lineItem1.setTaxExclusivePrice(750.0);
        lineItem1.setTaxPercentage(0.15);

        LineItem lineItem2 = new LineItem();
        lineItem2.setNameAr("حاسوب محمول");
        lineItem2.setQuantity(1.0);
        lineItem2.setTaxCategory("S");
        lineItem2.setTaxExclusivePrice(1750.0);
        lineItem2.setTaxPercentage(0.15);

        lineItems.add(lineItem1);
        lineItems.add(lineItem2);

        invoiceData.setLineItems(lineItems);

        Gson gson = new Gson();
        System.out.println(gson.toJson(invoiceData));
        assertThat(api.generateInvoice(gson.toJson(invoiceData)).toString(), containsString("Hello"));
    }

    @Test
    public void testDoComplianceCheck() {
        assertThat(api.doComplianceCheck("7b9cc231-0e14-4bff-938c-4603fe10c4bc").toString(), containsString("Hello"));
    }

}