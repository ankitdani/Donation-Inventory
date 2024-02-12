package com.example.inventory.v3;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DonationServiceTest {

    @Mock
    DonorRepository donorRepository;

    @InjectMocks
    DonationService donationService;
//
//    @Test
//    void testGetAllDonors() {
//        // Arrange
//        List<Donor> donors = new ArrayList<>();
//        donors.add(new Donor("John", "Cash", "100", new Date()));
//        when(donorRepository.findAll()).thenReturn(donors);
//
//        // Act
//        List<Donor> result = donationService.getAllDonors();
//
//        // Assert
//        assertEquals(1, result.size());
//        assertEquals("John", result.get(0).getDonorName());
//        verify(donorRepository, times(1)).findAll();
//    }
//
//    @Test
//    void testSaveDonor() {
//        // Arrange
//        Donor donor = new Donor("Alice", "Credit Card", "200", new Date());
//        when(donorRepository.save(donor)).thenReturn(donor);
//
//        // Act
//        Donor result = donationService.saveDonor(donor);
//
//        // Assert
//        assertEquals("Alice", result.getDonorName());
//        verify(donorRepository, times(1)).save(donor);
//    }
}
