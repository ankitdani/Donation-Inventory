package com.example.inventory.v3;

import jakarta.persistence.SequenceGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DonationServiceTest {
    @Mock
    private DonorRepository donorRepository;

    @InjectMocks
    private DonationService donationService;

    @Captor
    private ArgumentCaptor<Donor> donorCaptor;

    @Test
    public void testSaveDonor(){
        Donor donor = new Donor("Test user", "Money", "100", new Date());

        when(donorRepository.save(donor)).thenReturn(donor);

        Donor savedDonor = donationService.saveDonor(donor);

        assertEquals("Test user", savedDonor.getDonorName());
        assertEquals("Money", savedDonor.getDonationType());
        assertEquals("100", savedDonor.getQuantity());
        verify(donorRepository, times(1)).save(donorCaptor.capture());
        assertEquals(donor.getDonationDate(), donorCaptor.getValue().getDonationDate());


    }

}
