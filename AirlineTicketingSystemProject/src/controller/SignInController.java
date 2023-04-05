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

public class SignInController {
	
	@FXML
	private TextField userNameField;
	
	@FXML
	private TextField passWordField;
	
	@FXML
	private Button signInButton;
	
	@FXML
	private Button signUpButton;
	
	@FXML
	private Label signInLabel;
	
	@FXML
	protected void signInButtonClicked(ActionEvent event) throws InterruptedException {
		
		String username = userNameField.getText();
		String password = passWordField.getText();
		
		if(UserTreeSet.getGlobalSet().isSignInCorrect(username, password)) {
			signInLabel.setText("Signed in Successfully!");
			UserTreeSet.setStoredUser(UserTreeSet.getGlobalSet().findUser(username));
			try {
				AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/UserMain.fxml"));
				Scene scene = new Scene((Parent) root,1050,700);
				scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				User signedInUser = UserTreeSet.getGlobalSet().findUser(username);
				Main.getPrimaryStage().setTitle("Welcome to the Flight Dashboard, " + signedInUser.getFirstName() + " " + signedInUser.getLastName() );
				Main.getPrimaryStage().setScene(scene);
				Main.getPrimaryStage().show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		
		} else {
			signInLabel.setText("Login Failed!");
		}
		
	}
	
	@FXML
	protected void signUpButtonClicked(ActionEvent event) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/SignUp.fxml"));
			Scene scene = new Scene((Parent) root,850,600);
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			Main.getPrimaryStage().setTitle("Airport Ticketing System Sign-Up Page!");
			Main.getPrimaryStage().setScene(scene);
			Main.getPrimaryStage().show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
