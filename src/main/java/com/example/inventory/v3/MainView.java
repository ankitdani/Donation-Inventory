package com.example.inventory.v3;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Route("")
public class MainView extends VerticalLayout {

    TextField donorNameField = new TextField("Enter donor name:");
    DatePicker donationDateField = new DatePicker("Enter donation date:");

    DonationService donationService;

    Grid<Donor> grid = new Grid<>(Donor.class);
    public MainView(DonationService donationService) {
        this.donationService = donationService;
        addDonorForm();
        setGrid();
    }

    public void addDonorForm(){
        donorNameField.setPlaceholder("Firstname Lastname");
        donationDateField.setPlaceholder("Pacific Standard Time");
        Button saveButton = new Button("Save", event -> saveDonor());
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(donorNameField, saveButton);
        add(donationDateField, saveButton);
    }

    public void saveDonor() {
        Donor donor = new Donor();
        donor.setDonorName(donorNameField.getValue());
        donationService.saveDonor(donor);
        // Convert LocalDate to Date
        LocalDate localDate = donationDateField.getValue();
        Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        donor.setDonationDate(date);
        donationService.saveDonor(donor);
    }

    public void setGrid() {
//        grid.addColumn(Donor::getDonorName).setHeader("Donor Name");
        List<Donor> donors = donationService.getAllDonors();
        System.out.println("Donors: " + donationService.getAllDonors());
        grid.setItems(donors);
        grid.getDataProvider().refreshAll();
        add(grid);
    }

}


