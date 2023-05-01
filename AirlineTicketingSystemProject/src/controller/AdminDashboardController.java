/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import application.Main;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.TreeSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.Airport;
import model.AirportTreeSet;
import model.Flight;
import model.FlightTreeSet;
import model.User;
import model.UserTreeSet;
import utils.BackupRestoreTools;

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
    
    @FXML
    private TextField apCodeField;
    
    @FXML
    private TextField apNameField;
    
    @FXML
    private TextField apPhoneField;
    
    @FXML
    private TextField apStateField;
    
    @FXML
    private TextField destinationAirportField;

    @FXML
    private TextField arrivalTimeField;
    
    @FXML
    private TextField departureTimeField;
    
    @FXML
    private TextField originAirportField;
    
    @FXML
    private TextField flightNumberField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Add event listener to the customerListView selection model
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
        
        // Add event listener to the airportListView selection model
        airportListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Handle selection event
            if (newValue != null) {
                System.out.println("Selected item: " + newValue);
                selectedAirport = newValue;
                Airport airport = AirportTreeSet.getGlobalSet().findAirport(newValue);
                
                apCodeField.setText(airport.getApCode());
                apNameField.setText(airport.getApName());
                apPhoneField.setText(airport.getApPhone());
                apStateField.setText(airport.getState());
            }
        });
        
        // Add event listener to the flightListView selection model
        flightListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Handle selection event
            if (newValue != null) {
                System.out.println("Selected item: " + newValue);
                selectedFlight = newValue;
                Flight flight = FlightTreeSet.getGlobalSet().findFlight(Integer.parseInt(newValue));
                
                originAirportField.setText(flight.getOrigin().getApCode());
                destinationAirportField.setText(flight.getDestination().getApCode());
                departureTimeField.setText(flight.getDepartureTime());
                arrivalTimeField.setText(flight.getArrivalTime());
                flightNumberField.setText(Integer.toString(flight.getFlightNumber()));
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
            arr = userTreeSet.getUsernames();
        } else {
            arr = userTreeSet.getUsernames(customerSearchText.getText());
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
        
        BackupRestoreTools.backupUsersTreeSet(UserTreeSet.getGlobalSet());
        System.out.println("Information saved!");
    }
    
    @FXML
    void airportSearchButtonClicked(ActionEvent event) {
        airportListView.getSelectionModel().clearSelection();
        airportListView.getItems().clear();
        // Populate the list with entries

        AirportTreeSet airportTreeSet = AirportTreeSet.getGlobalSet();
        ArrayList<String> arr;
        if (airportSearchText.getText().isBlank()) {
            arr = airportTreeSet.returnApCodes();
        } else {
            arr = airportTreeSet.returnApCodes(airportSearchText.getText());
        }

        airportListView.getItems().addAll(arr);
    }

    @FXML
    void airportSaveButtonClicked(ActionEvent event) {
        Airport airport = AirportTreeSet.getGlobalSet().findAirport(selectedAirport);
        
        airport.setApCode(apCodeField.getText());
        airport.setApName(apNameField.getText());
        airport.setApPhone(apPhoneField.getText());
        airport.setState(apStateField.getText());
        
        airportListView.getSelectionModel().clearSelection();
        
        BackupRestoreTools.backupAirportHistory(AirportTreeSet.getGlobalSet());
        System.out.println("Information saved!");
    }
    
    @FXML
    void flightSearchButtonClicked(ActionEvent event) {
        flightListView.getSelectionModel().clearSelection();
        flightListView.getItems().clear();
        // Populate the list with entries

        FlightTreeSet flightTreeSet = FlightTreeSet.getGlobalSet();
        ArrayList<String> arr;
        if (flightSearchText.getText().isBlank()) {
            arr = flightTreeSet.returnFlightNums();
        } else {
            arr = flightTreeSet.returnFlightNums(flightSearchText.getText());
        }

        flightListView.getItems().addAll(arr);
    }

    @FXML
    void flightSaveButtonClicked(ActionEvent event) {
        Flight flight = FlightTreeSet.getGlobalSet().findFlight(Integer.parseInt(selectedFlight));
        
        try{
            Airport originAirport = AirportTreeSet.getGlobalSet().findAirport(originAirportField.getText());
            if(originAirport == null) {
                throw new Exception("Unknown origin airport, try again.");
            }
            flight.setOrigin(originAirport);
            
            Airport destinationAirport = AirportTreeSet.getGlobalSet().findAirport(destinationAirportField.getText());
            if(destinationAirport == null) {
                throw new Exception("Unknown destination airport, try again.");
            }
            flight.setDestination(destinationAirport);
            
            flight.setFlightNumber(Integer.parseInt(flightNumberField.getText()));
            flight.setDepartureTime(departureTimeField.getText());
            flight.setArrivalTime(arrivalTimeField.getText());
            
            flightListView.getSelectionModel().clearSelection();
        
            BackupRestoreTools.backupFlightHistory(FlightTreeSet.getGlobalSet());
            System.out.println("Information saved!");
            
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Save failed!");
            alert.setHeaderText(null);
            
            alert.setContentText(e.getMessage());

            ButtonType okButton = new ButtonType("OK");
            alert.getButtonTypes().setAll(okButton);

            alert.showAndWait();
        }
    }

    @FXML
    void logoutButtonClicked(ActionEvent event) {
        System.out.println("LOGOUT TEST");
        try {
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/SignInPane.fxml"));
				Scene scene = new Scene((Parent) root,800,600);
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				Main.getPrimaryStage().setTitle("Airport Ticketing System Sign-In Page!");
				Main.getPrimaryStage().setScene(scene);
				Main.getPrimaryStage().show();
			} catch(Exception e) {
				e.printStackTrace();
			}
    }

}
