package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.AirportTreeSet;
import model.FlightTreeSet;
import model.UserTreeSet;
import utils.BackupRestoreTools;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	static Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		
		this.primaryStage = primaryStage;
		BackupRestoreTools.restoreUsersTreeSet();
		UserTreeSet userSet = UserTreeSet.getGlobalSet();
		
		BackupRestoreTools.restoreAirportTreeSet();
		AirportTreeSet airportSet = AirportTreeSet.getGlobalSet();
		
		BackupRestoreTools.restoreFlightTreeSet();
		FlightTreeSet flightSet = FlightTreeSet.getGlobalSet();
		
		
		
		userSet.display();
		airportSet.display();
		flightSet.display();
		
		
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/UserMain.fxml"));
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Main.getPrimaryStage().setTitle("Airport Ticketing System Sign-In Page!");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
}
