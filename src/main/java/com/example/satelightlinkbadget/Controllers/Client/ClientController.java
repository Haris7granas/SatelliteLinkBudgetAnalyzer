package com.example.satelightlinkbadget.Controllers.Client;
/**
 *
 * @author Charalampos Gkranas
 */
import com.example.satelightlinkbadget.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    public BorderPane client_parent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().addListener((observableValue, oldValue, newValue) -> {
            switch (newValue) {
                case "Propagations" -> client_parent.setCenter(Model.getInstance().getViewFactory().getPropagationView());
                case "EarthStation" -> client_parent.setCenter(Model.getInstance().getViewFactory().getEarthStationView());
                case "Satellite" -> client_parent.setCenter(Model.getInstance().getViewFactory().getSatelliteView());
                case "Dashboard" -> client_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
                case "Data" -> Model.getInstance().getViewFactory().loadFile();
                case "Save" -> Model.getInstance().getViewFactory().saveToFile();
            }
        });

    }

}
