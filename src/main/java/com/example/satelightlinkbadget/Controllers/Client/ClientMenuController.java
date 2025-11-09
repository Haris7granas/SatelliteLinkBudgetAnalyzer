package com.example.satelightlinkbadget.Controllers.Client;
/**
 *
 * @author Charalampos Gkranas
 */
import com.example.satelightlinkbadget.Models.Model;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientMenuController implements Initializable {
    public Button sat_menu_btn;
    public Button earth_st_menu_btn;
    public Button prop_btn;
    public Button result_btn;
    public Button calc_btn;
    public Button save_btn;
    public Button exit_btn;
    public Button data_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }
    private void addListeners(){
        sat_menu_btn.setOnAction(event -> onSatellite());
        earth_st_menu_btn.setOnAction(event -> onEarthStation());
        prop_btn.setOnAction(event -> onPropagation());
        result_btn.setOnAction(event -> onDashboard());
        calc_btn.setOnAction(event -> onCalculate());
        save_btn.setOnAction(event -> onSave() );
        exit_btn.setOnAction(event -> onExit());
        data_btn.setOnAction(event -> onData());
    }

    private void onDashboard() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Dashboard");
    }
    private  void onSatellite(){
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Satellite");
    }
    private void onPropagation(){
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Propagations");
    }
    private void onEarthStation(){
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("EarthStation");
    }
    private void onCalculate(){
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Calculate");
    }
    private void onSave(){
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Save");
    }
    private void onData(){Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Data");}
    private void onExit(){
        //Model.getInstance().getViewFactory().getClientSelectedMenuItem().set("Exit");
        Platform.exit();
    }
}