package com.example.inventory.v3;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("")
public class MainView extends VerticalLayout {

    TextField donorNameField = new TextField("Enter donor name:");

    DonationService donationService;

    Grid<Donor> grid = new Grid<>(Donor.class);
    public MainView(DonationService donationService) {
        this.donationService = donationService;
        addDonorForm();
        setGrid();
    }

    public void addDonorForm(){
        donorNameField.setPlaceholder("Firstname Lastname");
        Button saveButton = new Button("Save", event -> saveDonor());
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(donorNameField, saveButton);
    }

    public void saveDonor() {
        Donor donor = new Donor();
        donor.setDonorName(donorNameField.getValue());
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


