package com.student.mongodemo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {

    private String country;
    private String city;
    private String postCode;

    // public Address(String country, String city, String postCode) {
    //     this.country = country;
    //     this.city = city;
    //     this.postCode = postCode;
    // }

    @Override
    public String toString() {
        return "Address [city=" + city + ", country=" + country + ", postCode=" + postCode + "]";
    }

}
