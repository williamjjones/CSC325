package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.User;
import model.UserTreeSet;
import utils.BackupRestoreTools;

public class SignUpController {
	
	@FXML
	private TextField firstNameField;
	
	@FXML
	private TextField lastNameField;
	
	@FXML
	private TextField userNameSignUpField;
	
	@FXML
	private TextField emailAddressField;
	
	@FXML
	private TextField passwordField;
	
	@FXML
	private Button cancelButton;
	
	@FXML
	private Label signUpMsgLabel;
	
	@FXML
	protected void finishSignUpButtonClicked(ActionEvent event) {
		
		
		boolean isRightLength = User.rightLength(passwordField.getText());
		boolean hasOneCapital = User.hasMinimumOneCapital(passwordField.getText());
		boolean hasOneLowerCase = User.hasMinimumOneLowerCase(passwordField.getText());
		boolean hasOneDigit = User.hasMinOneDigit(passwordField.getText());
		
			if(firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty() || emailAddressField.getText().isEmpty() || userNameSignUpField.getText().isEmpty() ||  passwordField.getText().isEmpty()) {
				signUpMsgLabel.setText("You are missing information in one of the fields above");
			}
		
			else if (UserTreeSet.getGlobalSet().isUserNameDuplicated(userNameSignUpField.getText())) {
				signUpMsgLabel.setText("User Creation Failed due to duplicate username already exists. Please try a different username.");
				userNameSignUpField.clear();
			}
			
			else if (isRightLength != true || hasOneCapital != true  || hasOneLowerCase != true || hasOneDigit != true) {
				signUpMsgLabel.setText("User creation failed due to password not meeting complexity requirements. Please make sure your password is 6 characters or longer, contains an uppercase, contains a lowercase, and a digit");
				passwordField.clear();
					
			}
			else {
				User newUser = new User(firstNameField.getText(), lastNameField.getText(), emailAddressField.getText(), userNameSignUpField.getText(), passwordField.getText());
				UserTreeSet.getGlobalSet().insert(newUser);
				BackupRestoreTools.backupUsersTreeSet(UserTreeSet.getGlobalSet());
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
	
	@FXML
	protected void cancelButtonClicked(ActionEvent event) {
		try {
			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/SignInPane.fxml"));
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			Main.getPrimaryStage().setTitle("Airport Ticketing System Sign-In Page!");
			Main.getPrimaryStage().setScene(scene);
			Main.getPrimaryStage().show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
