package com.flick.sdk.types;

import java.util.List;

public class EGSData {
    public String vat_name;
    public String vat_number;
    public List<Device> devices;
}

class Device {
    public String device_name;
    public String city;
    public String city_subdiv;
    public String street;
    public String plot;
    public String building;
    public String postal;
    public String branch_name;
    public String branch_industry;
    public String otp;
}
