module AirlineTicketingSystemProject {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
    requires javafx.base;
    requires javafx.media;
    requires javafx.swing;
    requires javafx.web;
    requires javafx.swt;
	
	opens application to javafx.graphics, javafx.fxml, javafx.base;
	opens controller to javafx.graphics, javafx.fxml, javafx.base;
	opens model to javafx.base;
}
