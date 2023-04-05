/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.TreeSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.User;
import model.UserTreeSet;
import model.UserBag;

/**
 *
 * @author tomhaj
 */
public class AdminDashboardController implements Initializable {

    private static String selectedUser;
    private static String selectedAirport;
    private static String selectedFlight;
    
    @FXML
    private ListView<String> customerListView;

    @FXML
    private ListView<String> flightListView;

    @FXML
    private ListView<String> airportListView;

    @FXML
    private TextField customerSearchText;

    @FXML
    private TextField flightSearchText;

    @FXML
    private TextField airportSearchText;

    @FXML
    private ComboBox<String> customerSearchField;

    @FXML
    private ComboBox<String> flightSearchField;

    @FXML
    private ComboBox<String> airportSearchField;

    @FXML
    private Button logoutButton;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField firstNameField;

    @FXML
    private Button saveButton;

    @FXML
    private CheckBox isAdminCheckBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Add event listener to the ListView selection model
        customerListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Handle selection event
            if (newValue != null) {
                System.out.println("Selected item: " + newValue);
                selectedUser = newValue;
                User user = UserTreeSet.getGlobalSet().findUser(newValue);

                firstNameField.setText(user.getFirstName());
                lastNameField.setText(user.getLastName());
                usernameField.setText(user.getUserName());
                passwordField.setText(user.getPassword());
                emailField.setText(user.getEmailAddress());
                if (user.isAdmin()) {
                    isAdminCheckBox.selectedProperty().set(true);
                }
            }
        });
    }

    @FXML
    protected void customerSearchButtonClicked(ActionEvent event) {
        customerListView.getSelectionModel().clearSelection();
        customerListView.getItems().clear();
        // Populate the list with entries

        UserTreeSet userTreeSet = UserTreeSet.getGlobalSet();
        ArrayList<String> arr;
        if (customerSearchText.getText().isBlank()) {
            arr = userTreeSet.returnUsernames();
        } else {
            arr = userTreeSet.returnUsernames(customerSearchText.getText());
        }

        customerListView.getItems().addAll(arr);
    }
    
    @FXML
    void customerSaveButtonClicked(ActionEvent event) {
        User user = UserTreeSet.getGlobalSet().findUser(selectedUser);
        
        user.setFirstName(firstNameField.getText());
        user.setLastName(lastNameField.getText());
        user.setUserName(usernameField.getText());
        user.setPassword(passwordField.getText());
        user.setEmailAddress(emailField.getText());
        user.setAdmin(isAdminCheckBox.selectedProperty().get());
        
        customerListView.getSelectionModel().clearSelection();
        
        System.out.println("Information saved!");
    }

    @FXML
    protected void logoutButtonClicked(ActionEvent event) {
        System.out.println("LOGOUT TEST");
    }

    @FXML
    protected void airportListViewSelected(ActionEvent event) {
        System.out.println("AIRPORT SELECTED");
        // Populate with data from selected entry
    }

}
