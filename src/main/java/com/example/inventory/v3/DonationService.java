package com.example.inventory.v3;

import org.apache.logging.log4j.LogManager;
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
import java.util.logging.Logger;


@Service
public class DonationService {

    private static final Logger LOGGER = Logger.getLogger(DonationService.class.getName());

    @Autowired
    DonorRepository donorRepository;

    public List<Donor> getAllDonors(){
        LOGGER.info("Entering getAllDonors() method");
//        System.out.println("Entering getAllDonors() method");
        List<Donor> donors = donorRepository.findAll();
        LOGGER.info("Found " + donors.size() + " donors");
        LOGGER.info("Exiting getAllDonors() method");
//        System.out.println("Found " + donors.size() + " donors");
//        System.out.println("Exiting getAllDonors() method");
        return donors;
    }

    public Donor saveDonor(Donor donor){
        LOGGER.info("Entering saveDonor() method");
//        System.out.println("Entering saveDonor() method");
        Donor savedDonor = donorRepository.save(donor);
//        System.out.println("Saved donor with name: " + savedDonor.getDonorName());
//        System.out.println("Exiting saveDonor() method");
        LOGGER.info("Saved donor with name: {}" + savedDonor.getDonorName());
        LOGGER.info("Exiting saveDonor() method");
        return savedDonor;
    }
}

