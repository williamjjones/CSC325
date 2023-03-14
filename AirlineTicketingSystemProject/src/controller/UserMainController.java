package controller;


import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Flight;
import model.FlightTreeSet;

@SuppressWarnings("unused")
public class UserMainController {
	FlightTreeSet flightSet = FlightTreeSet.getGlobalSet();
	
	@FXML
	private TableView<Flight> table;
	
	@FXML
	private TableColumn<Flight, Integer> flightNumberColumn;
	
	@FXML
	private TableColumn<Flight, String> originColumn;
	
	@FXML
	private TableColumn<Flight, String> destinationColumn;
	
	@FXML
	private TableColumn<Flight, String> departureColumn;
	
	@FXML
	private TableColumn<Flight, String> arrivalColumn;
	
	
	public UserMainController() {
	flightNumberColumn = new TableColumn<>("Flight Number");
	flightNumberColumn.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
	
	
	FilteredList<Flight> filteredData = new FilteredList<>(FXCollections.observableArrayList(flightSet.displayInFlight()));
	table.setItems((ObservableList) flightSet);
	}
}
