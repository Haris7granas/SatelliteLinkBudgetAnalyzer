module com.example.satelightlinkbadget {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;


    opens com.example.satelightlinkbadget to javafx.fxml;
    exports com.example.satelightlinkbadget;
    exports com.example.satelightlinkbadget.Controllers.Client;
    exports com.example.satelightlinkbadget.Models;
    exports com.example.satelightlinkbadget.Views;
}