# Flick Java SDK (Experimental)
![Platform](https://img.shields.io/badge/Java-8-blue)
[![Software License](https://img.shields.io/badge/license-MIT-brightgreen.svg)](LICENSE.md)


A java interface for interacting with the APIs of Flick.

- [Installation](#installation)
- [Getting Started](#getting-started)
- [Documentation](#documentation)
- [Examples](#examples)
- [Contribute to our SDK](#contributing)
- [License](#license)
- [Support](#support)

## Installation
To use the Flick Java SDK in your project, you can install it using :

```xml
<dependency>
    <groupId>network.flick.sdk</groupId>
    <artifactId>flick-java-sdk</artifactId>
    <version>0.0.1</version>
</dependency>
```
### Important Note

For the examples given in this readme and also on this repo you may also need to add [gson](https://github.com/google/gson) as a dependancy

```xml
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.10.1</version>
</dependency>
```


## Getting Started
Before using the package, you need to configure it with your API credentials. You should have an apiKey and specify whether you are using the 'sandbox' or 'production' environment.

Here's how you to initiate our SDK in your project:

```java
package test;

import network.flick.sdk.Bills;
import network.flick.sdk.FlickSDK;
import okhttp3.Response;

public class HelloController {

    public static void main(String[] args) {
        // Initailize the object
        Bills api = new Bills(FlickSDK.ENVIRONMENT_SANDBOX, "YOUR-API-KEY-GOES-HERE");
        
	
    }
}
```

## Documentation
To learn about available methods and their usage, please refer to the [official API documentation](https://docs.flick.network/).
Here's a glimpse to our Bills Module:

### Bills Client
The Bills client provides access to various functionalities for managing bills. You can interact with the following API endpoints:

#### Onboard EGS to ZATCA:

```java
// Initialize the api handler
Bills api = new Bills(FlickSDK.ENVIRONMENT_SANDBOX,"YOUR-API-KEY-GOES-HERE");
```

#### Compliance Check:

```java
Bills api = new Bills(FlickSDK.ENVIRONMENT_SANDBOX,"YOUR-API-KEY-GOES-HERE");

try {
  String egsUUID = "7b9cc231-0e14-4bff-938c-4603fe10c4bc";
  Response response = api.doComplianceCheck(egsUUID).execute();
  // Process the response
} catch (IOException e) {
  e.printStackTrace();
}
```

#### Generate E-Invoice for Phase-2 in Saudi Arabia:
```java

Bills api = new Bills(FlickSDK.ENVIRONMENT_SANDBOX,"YOUR-API-KEY-GOES-HERE");
EGSData egsData = new EGSData();
// Add data to egsData object

// Create Device objects
List<Device> devices = new ArrayList<>();

Device device1 = new Device();
Device device2 = new Device();

devices.add(device1);
devices.add(device2);

egsData.setDevices(devices);
Gson gson = new Gson();

try {
  Response response = api.onboardEGS(gson.toJson(egsData)).execute();
  // Process your response
} catch (IOException e) {
  e.printStackTrace();
}
```
You can also do callbacks
```java
api.generateInvoice(gson.toJson(invoiceData)).enqueue(new Callback() {
			@Override
			public void onFailure(final Call call, IOException e) {
				// Error
				e.printStackTrace();
			}

			@Override
			public void onResponse(Call call, final Response response) throws IOException {
				String res = response.body().string();
				// Do something with the response
				System.out.println(res);
			}
		});
```

## Examples

1. Here's an Example of how you can **onboard multiple EGS to ZATCA Portal** [If you are onboarding PoS devices or VAT-Group members, this comes handy].

2. Examples are included in the examples folder as well

```java
package test;

import network.flick.sdk.Bills;
import network.flick.sdk.types.InvoiceData;
import com.google.gson.Gson;

import okhttp3.Response;


public class HelloController {

    public static void main(String[] args) {
        Bills api = new Bills(FlickSDK.ENVIRONMENT_SANDBOX, "YOUR-API-KEY-GOES-HERE");
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
        try {
          Response response = api.onboardEGS(gson.toJson(egsData)).execute();
          // Process your response
        } catch (IOException e) {
          e.printStackTrace();
        }
    }
} 
```

2. Here's an Example of how you can **Genereate a ZATCA-Complied E-Invoice**.

```java
package test;

import network.flick.sdk.Bills;
import network.flick.sdk.types.InvoiceData;
import com.google.gson.Gson;

import okhttp3.Response;


public class HelloController {

    public static void main(String[] args) {
        Bills api = new Bills(FlickSDK.ENVIRONMENT_SANDBOX, "YOUR-API-KEY-GOES-HERE");
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
        try {
          Response response = api.generateInvoice(gson.toJson(invoiceData)).execute();;
          // Process your response
        } catch (IOException e) {
          e.printStackTrace();
        }
    }
}

```

## Contributing

We welcome contributions from the community. If you find issues or have suggestions for improvements, please open an issue or create a pull request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Support

If you encounter any issues or have questions, please contact our support team at support@flick.network

## Keywords 

einvoicing, e-invoicing, zatca, phase2, saudi, ksa, fatoora, saudiarabia, egs