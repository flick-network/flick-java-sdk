package com.flickpackage.types;

import java.util.List;

public class InvoiceData {
    public String egs_uuid;
    public String invoice_ref_number;
    public String issue_date;
    public String issue_time;
    public PartyDetails party_details;
    public String doc_type;
    public Boolean has_advance;
    public AdvanceDetails advance_details;
    public String inv_type;
    public int payment_method;
    public String currency;
    public String total_tax;
    public List<LineItem> lineitems;
}

class PartyDetails {
    public String party_name_ar;
    public String party_name_en;
    public String party_vat;
    public PartyAddId party_add_id;
    public String city_ar;
    public String city_en;
    public String city_subdivision_ar;
    public String city_subdivision_en;
    public String street_ar;
    public String street_en;
    public String plot_identification;
    public String building;
    public String postal_zone;
}

class PartyAddId {
    public int crn;
}

class AdvanceDetails {
    public double advance_amount;
    public double total_amount;
    public List<AdvanceInvoice> advance_invoices;
}

class AdvanceInvoice {
    public String tax_category;
    public double tax_percentage;
    public double taxable_amount;
    public double tax_amount;
    public List<Invoice> invoices;
}

class Invoice {
    public String id;
    public String issue_date;
    public String issue_time;
}

class LineItem {
    public String name_ar;
    public String name_en;
    public double quantity;
    public String tax_category;
    public double tax_exclusive_price;
    public double tax_percentage;
}
