package network.flick.sdk.types;

import java.util.ArrayList;
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
    public Double total_tax;
    public List<LineItem> lineitems;

    public String getEgsUuid() {
        return egs_uuid;
    }

    public void setEgsUuid(String egs_uuid) {
        this.egs_uuid = egs_uuid;
    }

    public String getInvoiceRefNumber() {
        return invoice_ref_number;
    }

    public void setInvoiceRefNumber(String invoice_ref_number) {
        this.invoice_ref_number = invoice_ref_number;
    }

    public String getIssueDate() {
        return issue_date;
    }

    public void setIssueDate(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getIssueTime() {
        return issue_time;
    }

    public void setIssueTime(String issue_time) {
        this.issue_time = issue_time;
    }

    public PartyDetails getPartyDetails() {
        return party_details;
    }

    public void setPartyDetails(PartyDetails party_details) {
        this.party_details = party_details;
    }

    public String getDocType() {
        return doc_type;
    }

    public void setDocType(String doc_type) {
        this.doc_type = doc_type;
    }

    public Boolean getHasAdvance() {
        return has_advance;
    }

    public void setHasAdvance(Boolean has_advance) {
        this.has_advance = has_advance;
    }

    public AdvanceDetails getAdvanceDetails() {
        return advance_details;
    }

    public void setAdvanceDetails(AdvanceDetails advance_details) {
        this.advance_details = advance_details;
    }

    public String getInvType() {
        return inv_type;
    }

    public void setInvType(String inv_type) {
        this.inv_type = inv_type;
    }

    public int getPaymentMethod() {
        return payment_method;
    }

    public void setPaymentMethod(int payment_method) {
        this.payment_method = payment_method;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getTotalTax() {
        return total_tax;
    }

    public void setTotalTax(Double total_tax) {
        this.total_tax = total_tax;
    }

    public List<LineItem> getLineItems() {
        return lineitems;
    }

    public void setLineItems(List<LineItem> lineitems) {
        this.lineitems = lineitems;
    }

    public static class PartyDetails {
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

        public String getPartyNameAr() {
            return party_name_ar;
        }

        public void setPartyNameAr(String party_name_ar) {
            this.party_name_ar = party_name_ar;
        }

        public String getPartyNameEn() {
            return party_name_en;
        }

        public void setPartyNameEn(String party_name_en) {
            this.party_name_en = party_name_en;
        }

        public String getPartyVat() {
            return party_vat;
        }

        public void setPartyVat(String party_vat) {
            this.party_vat = party_vat;
        }

        public PartyAddId getPartyAddId() {
            return party_add_id;
        }

        public void setPartyAddId(PartyAddId party_add_id) {
            this.party_add_id = party_add_id;
        }

        public String getCityAr() {
            return city_ar;
        }

        public void setCityAr(String city_ar) {
            this.city_ar = city_ar;
        }

        public String getCityEn() {
            return city_en;
        }

        public void setCityEn(String city_en) {
            this.city_en = city_en;
        }

        public String getCitySubdivisionAr() {
            return city_subdivision_ar;
        }

        public void setCitySubdivisionAr(String city_subdivision_ar) {
            this.city_subdivision_ar = city_subdivision_ar;
        }

        public String getCitySubdivisionEn() {
            return city_subdivision_en;
        }

        public void setCitySubdivisionEn(String city_subdivision_en) {
            this.city_subdivision_en = city_subdivision_en;
        }

        public String getStreetAr() {
            return street_ar;
        }

        public void setStreetAr(String street_ar) {
            this.street_ar = street_ar;
        }

        public String getStreetEn() {
            return street_en;
        }

        public void setStreetEn(String street_en) {
            this.street_en = street_en;
        }

        public String getPlotIdentification() {
            return plot_identification;
        }

        public void setPlotIdentification(String plot_identification) {
            this.plot_identification = plot_identification;
        }

        public String getBuilding() {
            return building;
        }

        public void setBuilding(String building) {
            this.building = building;
        }

        public String getPostalZone() {
            return postal_zone;
        }

        public void setPostalZone(String postal_zone) {
            this.postal_zone = postal_zone;
        }
    }

    public static class PartyAddId {
        public int crn;

        public int getCrn() {
            return crn;
        }

        public void setCrn(int crn) {
            this.crn = crn;
        }
    }

    public static class AdvanceDetails {
        public double advance_amount;
        public double total_amount;
        public List<AdvanceInvoice> advance_invoices = new ArrayList<>();;

        public double getAdvanceAmount() {
            return advance_amount;
        }

        public void setAdvanceAmount(double advance_amount) {
            this.advance_amount = advance_amount;
        }

        public double getTotalAmount() {
            return total_amount;
        }

        public void setTotalAmount(double total_amount) {
            this.total_amount = total_amount;
        }

        public List<AdvanceInvoice> getAdvanceInvoices() {
            return advance_invoices;
        }

        public void setAdvanceInvoices(List<AdvanceInvoice> advance_invoices) {
            this.advance_invoices = advance_invoices;
        }
    }

    public static class AdvanceInvoice {
        public String tax_category;
        public double tax_percentage;
        public double taxable_amount;
        public double tax_amount;
        public List<Invoice> invoices = new ArrayList<>();;

        public String getTaxCategory() {
            return tax_category;
        }

        public void setTaxCategory(String tax_category) {
            this.tax_category = tax_category;
        }

        public double getTaxPercentage() {
            return tax_percentage;
        }

        public void setTaxPercentage(double tax_percentage) {
            this.tax_percentage = tax_percentage;
        }

        public double getTaxableAmount() {
            return taxable_amount;
        }

        public void setTaxableAmount(double taxable_amount) {
            this.taxable_amount = taxable_amount;
        }

        public double getTaxAmount() {
            return tax_amount;
        }

        public void setTaxAmount(double tax_amount) {
            this.tax_amount = tax_amount;
        }

        public List<Invoice> getInvoices() {
            return invoices;
        }

        public void setInvoices(List<Invoice> invoices) {
            this.invoices = invoices;
        }
    }

    public static class Invoice {
        public String id;
        public String issue_date;
        public String issue_time;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIssueDate() {
            return issue_date;
        }

        public void setIssueDate(String issue_date) {
            this.issue_date = issue_date;
        }

        public String getIssueTime() {
            return issue_time;
        }

        public void setIssueTime(String issue_time) {
            this.issue_time = issue_time;
        }
    }

    public static class LineItem {
        public String name_ar;
        public String name_en;
        public double quantity;
        public String tax_category;
        public double tax_exclusive_price;
        public double tax_percentage;

        public String getNameAr() {
            return name_ar;
        }

        public void setNameAr(String name_ar) {
            this.name_ar = name_ar;
        }

        public String getNameEn() {
            return name_en;
        }

        public void setNameEn(String name_en) {
            this.name_en = name_en;
        }

        public double getQuantity() {
            return quantity;
        }

        public void setQuantity(double quantity) {
            this.quantity = quantity;
        }

        public String getTaxCategory() {
            return tax_category;
        }

        public void setTaxCategory(String tax_category) {
            this.tax_category = tax_category;
        }

        public double getTaxExclusivePrice() {
            return tax_exclusive_price;
        }

        public void setTaxExclusivePrice(double tax_exclusive_price) {
            this.tax_exclusive_price = tax_exclusive_price;
        }

        public double getTaxPercentage() {
            return tax_percentage;
        }

        public void setTaxPercentage(double tax_percentage) {
            this.tax_percentage = tax_percentage;
        }
    }

}
