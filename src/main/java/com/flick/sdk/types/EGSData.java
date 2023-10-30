package com.flick.sdk.types;

import java.util.List;

public class EGSData {
    private String vat_name;
    private String vat_number;
    private List<Device> devices;

    // Getter and Setter methods for each field
    public String getVatName() {
        return vat_name;
    }

    public void setVatName(String vat_name) {
        this.vat_name = vat_name;
    }

    public String getVatNumber() {
        return vat_number;
    }

    public void setVatNumber(String vat_number) {
        this.vat_number = vat_number;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public static class Device {
        private String device_name;
        private String city;
        private String city_subdiv;
        private String street;
        private String plot;
        private String building;
        private String postal;
        private String branch_name;
        private String branch_industry;
        private String otp;

        // Getter and Setter methods for each field
        public String getDeviceName() {
            return device_name;
        }

        public void setDeviceName(String device_name) {
            this.device_name = device_name;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCitySubdiv() {
            return city_subdiv;
        }

        public void setCitySubdiv(String city_subdiv) {
            this.city_subdiv = city_subdiv;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getPlot() {
            return plot;
        }

        public void setPlot(String plot) {
            this.plot = plot;
        }

        public String getBuilding() {
            return building;
        }

        public void setBuilding(String building) {
            this.building = building;
        }

        public String getPostal() {
            return postal;
        }

        public void setPostal(String postal) {
            this.postal = postal;
        }

        public String getBranchName() {
            return branch_name;
        }

        public void setBranchName(String branch_name) {
            this.branch_name = branch_name;
        }

        public String getBranchIndustry() {
            return branch_industry;
        }

        public void setBranchIndustry(String branch_industry) {
            this.branch_industry = branch_industry;
        }

        public String getOtp() {
            return otp;
        }

        public void setOtp(String otp) {
            this.otp = otp;
        }
    }
}
