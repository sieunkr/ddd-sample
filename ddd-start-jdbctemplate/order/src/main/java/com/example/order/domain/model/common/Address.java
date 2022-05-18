package com.example.order.domain.model.common;


public class Address {

    private String zipCode;

    private String address1;

    private String address2;

    public Address() {
    }

    public Address(String zipCode, String address1, String address2) {
        this.zipCode = zipCode;
        this.address1 = address1;
        this.address2 = address2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }
}
