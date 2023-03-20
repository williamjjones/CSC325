package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Airport;
import model.Flight;
import model.FlightTreeSet;
import model.User;
import model.UserTreeSet;
import utils.BackupRestoreTools;

public class UpdateProfileController implements Initializable {
	private User signedInUser = UserTreeSet.getStoredUser();
	
	@FXML
	private TextField firstNameField;
	
	@FXML
	private TextField lastNameField;
	
	@FXML
	private TextField userNameField;
	
	@FXML
	private TextField emailAddressField;
	
	@FXML
	private TextField passwordField;
	
	@FXML
	private Button cancelButton;
	
	@FXML
	private Label signUpMsgLabel;
	
	
	
	@Override
	public void initialize(URL url, ResourceBundle rb){
		
		System.out.println(signedInUser);
		
		firstNameField.setText(signedInUser.getFirstName());
		
		lastNameField.setText(signedInUser.getLastName());

		userNameField.setText(signedInUser.getUserName());
		
		emailAddressField.setText(signedInUser.getEmailAddress());

	
		passwordField.setText(signedInUser.getPassword());
		

		
	
		
		
	}
	
	@FXML
	protected void updateButtonClicked(ActionEvent event) {
		
		
		boolean isRightLength = User.rightLength(passwordField.getText());
		boolean hasOneCapital = User.hasMinimumOneCapital(passwordField.getText());
		boolean hasOneLowerCase = User.hasMinimumOneLowerCase(passwordField.getText());
		boolean hasOneDigit = User.hasMinOneDigit(passwordField.getText());
		
			if(firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty() || emailAddressField.getText().isEmpty() || userNameField.getText().isEmpty() ||  passwordField.getText().isEmpty()) {
				signUpMsgLabel.setText("You are missing information in one of the fields above");
			}
		
//			else if (UserTreeSet.getGlobalSet().isUserNameDuplicated(userNameField.getText())) {
//				signUpMsgLabel.setText("User Creation Failed due to duplicate username already exists. Please try a different username.");
//				userNameField.clear();
//			}
			
			else if (isRightLength != true || hasOneCapital != true  || hasOneLowerCase != true || hasOneDigit != true) {
				signUpMsgLabel.setText("User update failed due to password not meeting complexity requirements. Please make sure your password is 6 characters or longer, contains an uppercase, contains a lowercase, and a digit");
				passwordField.clear();
					
			}
			else {
				signedInUser.setFirstName(firstNameField.getText());
				signedInUser.setLastName(lastNameField.getText());
				signedInUser.setEmailAddress(emailAddressField.getText());
				signedInUser.setPassword(signedInUser, signedInUser, passwordField.getText());

				BackupRestoreTools.backupUsersTreeSet(UserTreeSet.getGlobalSet());
				try {
					AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/SignInPane.fxml"));
					Scene scene = new Scene((Parent) root,700,600);
					scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
					Main.getPrimaryStage().setTitle("Airport Ticketing System Sign-In Page!");
					Main.getPrimaryStage().setScene(scene);
					Main.getPrimaryStage().show();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
	}
	
	@FXML
	protected void cancelButtonClicked(ActionEvent event) {
		try {
			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/SignInPane.fxml"));
			Scene scene = new Scene(root,700,600);
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			Main.getPrimaryStage().setTitle("Welcome to the Flights App!");
			Main.getPrimaryStage().setScene(scene);
			Main.getPrimaryStage().show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
