package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Airport;
import model.Flight;
import model.FlightTreeSet;
import model.User;
import model.UserTreeSet;
import utils.BackupRestoreTools;

public class UserDBController implements Initializable {
	private User signedInUser = UserTreeSet.getStoredUser();
	
	@FXML
	private Button bookFlights;
	
	@FXML
	private Button myProfile;
	
	@FXML
	private TableView<Flight> table;
	
	@FXML
	private TableColumn<Flight, Integer> flightNumColumn;
	
	@FXML
	private TableColumn<Flight, Airport> originColumn;
	
	@FXML
	private TableColumn<Flight, Airport> destinationColumn;
	
	@FXML
	private TableColumn<Flight, String> departureColumn;
	
	@FXML
	private TableColumn<Flight, String> arrivalColumn;
	
	@FXML
	private TextField flightNumField;
	
	@FXML
	private TextField originField;
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb){
		FlightTreeSet flightSet = FlightTreeSet.getGlobalSet();
		
		System.out.println(signedInUser);
		
		flightNumColumn.setCellValueFactory(new PropertyValueFactory<Flight,Integer>("flightNumber"));
		
		originColumn.setCellValueFactory(new PropertyValueFactory<Flight,Airport>("origin"));
		
		destinationColumn.setCellValueFactory(new PropertyValueFactory<Flight,Airport>("destination"));
		
		departureColumn.setCellValueFactory(new PropertyValueFactory<Flight,String>("departureTime"));
		
		arrivalColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("arrivalTime"));
	
		FilteredList<Flight> filteredData;
		 filteredData = new FilteredList<>(FXCollections.observableArrayList(flightSet.displayInFlight()));
		
		
		table.setItems(filteredData);
		
		System.out.println("TEst");
		
//		flightNumField.textProperty().addListener((observable, oldValue, newValue) ->
//		filteredData.setPredicate(Flight.flightNumPredicate(newValue))
//				);
//		
		
//		MultipleSelectionModel<Flight> lvSelModel = table.getSelectionModel();
//		
//		lvSelModel.setSelectionMode(SelectionMode.SINGLE);
//		
//		lvSelModel.selectedItemProperty().addListener(new ChangeListener<Flight>() {
//
//			
//
//			@Override
//			public void changed(ObservableValue<? extends Flight> changed, Flight oldValue, Flight newValue) {
//				
//				flightNumField.setText(String.valueOf(newValue.getFlightNumber()));
//				originField.setText(String.valueOf(newValue.getOrigin().getApCode()));
//			
//			}
//
//			
//			
//		});
		
	}
	
	@FXML
	protected void myProfileButtonClicked(ActionEvent event) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/UpdateProfile.fxml"));
			Scene scene = new Scene((Parent) root,850,600);
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			Main.getPrimaryStage().setTitle("Update your Profile - " + signedInUser.getUserName());
			Main.getPrimaryStage().setScene(scene);
			Main.getPrimaryStage().show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
