package com.study.jdbc.entity;

public class Address extends IdEntity {

    private String city;
    private String country;
    private Long   userId;

    public Address(String city, String country, Long userId) {
        this.city = city;
        this.country = country;
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", userId=" + userId +
                '}';
    }
}
