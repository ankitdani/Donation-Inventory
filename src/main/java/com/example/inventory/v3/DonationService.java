package com.example.inventory.v3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
//public class DonationService {
//    @Autowired
//    DonorRepository donorRepository;
//    public List<Donor> getAllDonors(){
//        return donorRepository.findAll();
//    }
//    public Donor saveDonor(Donor donor){
//        return donorRepository.save(donor);
//    }
//}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationService {

    @Autowired
    DonorRepository donorRepository;

    public List<Donor> getAllDonors(){
        System.out.println("Entering getAllDonors() method");
        List<Donor> donors = donorRepository.findAll();
        System.out.println("Found " + donors.size() + " donors");
        System.out.println("Exiting getAllDonors() method");
        return donors;
    }

    public Donor saveDonor(Donor donor){
        System.out.println("Entering saveDonor() method");
        Donor savedDonor = donorRepository.save(donor);
        System.out.println("Saved donor with name: " + savedDonor.getDonorName());
        System.out.println("Exiting saveDonor() method");
        return savedDonor;
    }
}

