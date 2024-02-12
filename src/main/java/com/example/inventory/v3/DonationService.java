package com.example.inventory.v3;

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
        List<Donor> donors = donorRepository.findAll();
        LOGGER.info("Found " + donors.size() + " donors");
        LOGGER.info("Exiting getAllDonors() method");
        return donors;
    }

    public Donor saveDonor(Donor donor){
        LOGGER.info("Entering saveDonor() method");
        Donor savedDonor = donorRepository.save(donor);
        LOGGER.info("Saved donor with name: {}" + savedDonor.getDonorName());
        LOGGER.info("Exiting saveDonor() method");
        return savedDonor;
    }
}

