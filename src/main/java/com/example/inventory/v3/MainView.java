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
import java.util.logging.Logger;

@Route("")
public class MainView extends VerticalLayout {

    private static final Logger LOGGER = Logger.getLogger(MainView.class.getName());

    TextField donorNameField = new TextField("Enter donor name:");
    DatePicker donationDateField = new DatePicker("Enter donation date:");
    TextField quantityField = new TextField("Enter quantity:");

    TextField donationTypeField = new TextField("Enter donation type:");
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
        quantityField.setPlaceholder("$$");
        donationTypeField.setPlaceholder("Money, clothes");
        Button saveButton = new Button("Save", event -> saveDonor());
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(donorNameField, saveButton);
        add(donationDateField, saveButton);
        add(quantityField, saveButton);
        add(donationTypeField, saveButton);
    }

    public void saveDonor() {
        Donor donor = new Donor();
        donor.setDonorName(donorNameField.getValue());
        donationService.saveDonor(donor);

//        converts a LocalDate object to a Date object.
        Date date = Date.from(donationDateField.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        donor.setDonationDate(date);

        donor.setQuantity(quantityField.getValue());
        donationService.saveDonor(donor);

        donor.setDonationType(donationTypeField.getValue());
        donationService.saveDonor(donor);

        LOGGER.info("Donor saved: " + donor);

    }

    public void setGrid() {
        List<Donor> donors = donationService.getAllDonors();
        LOGGER.info("Donors in grid: " + donors);
        grid.setItems(donors);
        grid.getDataProvider().refreshAll();
        add(grid);
    }

}


