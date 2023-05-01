package controller;

import application.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.Airport;
import model.Flight;
import model.FlightTreeSet;
import model.User;
import model.UserTreeSet;
import utils.BackupRestoreTools;


public class BookFlightController implements Initializable {

    private User signedInUser = UserTreeSet.getStoredUser();
    @FXML
    private Button bookflightbutton;
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
    private Button cancelButton;

    
    Integer index;
    private Integer flightNum;
    private Airport origin;
    private Airport destination;
    private String departureTime;
    private String arrivalTime;
    private Flight newFlight;
    @FXML
    private Text output;
   
    
   
    
    	@Override
	public void initialize(URL url, ResourceBundle rb){
	      
                FlightTreeSet flightSet = FlightTreeSet.getGlobalSet();
                
		
		flightNumColumn.setCellValueFactory(new PropertyValueFactory<Flight,Integer>("flightNumber"));
		
		originColumn.setCellValueFactory(new PropertyValueFactory<Flight,Airport>("origin"));
		
		destinationColumn.setCellValueFactory(new PropertyValueFactory<Flight,Airport>("destination"));
		
		departureColumn.setCellValueFactory(new PropertyValueFactory<Flight,String>("departureTime"));
		
		arrivalColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("arrivalTime"));
		
               FilteredList<Flight> filteredData;
	       filteredData = new FilteredList<>(FXCollections.observableArrayList(flightSet.displayInFlight()));
		
               table.setItems(filteredData);
		

		
        }
        
        
    @FXML
    protected void cancelButtonClicked(ActionEvent event) {
                try {
			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/UserMain.fxml"));
			Scene scene = new Scene(root,1050,700);
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			Main.getPrimaryStage().setTitle("Welcome to the Main Work Area!");
			Main.getPrimaryStage().setScene(scene);
			Main.getPrimaryStage().show();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }

    @FXML
    private void getItem(MouseEvent event) {
        
        index = table.getSelectionModel().getSelectedIndex();
        
        if (index <= -1) {
            
            return;
        }
        
        flightNum = flightNumColumn.getCellData(index);
        origin = originColumn.getCellData(index);
        destination = destinationColumn.getCellData(index);
        departureTime = departureColumn.getCellData(index);
        arrivalTime = arrivalColumn.getCellData(index);
        
  
        
 
        
    }

    @FXML
    private void bookFlightButtonClicked(ActionEvent event) {
        
       newFlight = new Flight(flightNum.intValue(), origin, destination, departureTime, arrivalTime);
        
        
        FlightTreeSet bogusTreeSet = signedInUser.getflightHistory();
        
        bogusTreeSet.insert(newFlight);
        
        BackupRestoreTools.backupUsersTreeSet(UserTreeSet.getGlobalSet());
        
        output.setText("Flight " + flightNum + " added!");
        
        bogusTreeSet.display();
        
    }

 

}
