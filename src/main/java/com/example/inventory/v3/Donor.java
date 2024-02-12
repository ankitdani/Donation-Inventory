package com.example.inventory.v3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String DonorName;

    private String DonationType;

    private String Quantity;

    private Date DonationDate;


    public Donor() {
    }

    public Donor(String donorName, String donationType, String quantity, Date donationDate) {
        DonorName = donorName;
        DonationType = donationType;
        Quantity = quantity;
        DonationDate = donationDate;
    }

    public String getDonorName() {
        return DonorName;
    }

    public void setDonorName(String donorName) {
        DonorName = donorName;
    }

    public String getDonationType() {
        return DonationType;
    }

    public void setDonationType(String donationType) {
        DonationType = donationType;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public Date getDonationDate() {
        return DonationDate;
    }

    public void setDonationDate(Date donationDate) {
        DonationDate = donationDate;
    }
}
