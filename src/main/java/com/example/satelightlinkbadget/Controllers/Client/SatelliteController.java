package com.example.satelightlinkbadget.Controllers.Client;
/**
 *
 * @author Charalampos Gkranas
 */
import com.example.satelightlinkbadget.Models.Model;
import javafx.beans.property.StringProperty;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class SatelliteController implements Initializable {

    public TextField latitude_sat_textfield;
    public TextField longitude_sat_textfield;
    public TextField altitude_sat_textfield;
    public TextField intrloss_rec_textfield;
    public TextField rxgt_rec_textfield;
    public TextField rxfeederloss_rec_textfield;
    public TextField otherloss_rec_textfield;
    public TextField txfeederloss_tra_textfield;
    public TextField othertxloss_tra_textfield;
    public TextField hpspower_tra_textfield;
    public TextField hpaobo_tra_textfield;
    public TextField antennagain_tra_textfield;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().addListener((observableValue, oldValue, newValue) -> {
            if (newValue.equals("Data")){
                setFileAltitude();
                setFileLongitude();
                setFileLatitude();
                setFileintrloss_rec();
                setFilerxgt_rec();
                setFilerxfeederloss_rec();
                setFileotherloss_rec();
                setFiletxfeederloss_tra();
                setFileothertxloss_tra();
                setFilehpspower_tra();
                setFilehpaobo_tra();
                setFileantennagain_tra();
            }
        });
    }
    public void setFileAltitude(){
        altitude_sat_textfield.setText(Model.getInstance().getViewFactory().getSatelliteAltitude().get());
    }
    public  void setFileLongitude(){
        longitude_sat_textfield.setText(Model.getInstance().getViewFactory().getSatelliteLongitude().get());
    }
    public  void setFileintrloss_rec(){
        intrloss_rec_textfield.setText(Model.getInstance().getViewFactory().getSat_intrloss_rec().get());
    }
    public  void setFilerxgt_rec(){
        rxgt_rec_textfield.setText(Model.getInstance().getViewFactory().getSat_rxgt_rec().get());
    }
    public  void setFilerxfeederloss_rec(){
        rxfeederloss_rec_textfield.setText(Model.getInstance().getViewFactory().getSatr_txfeederloss_rec().get());
    }
    public  void setFileotherloss_rec(){
        otherloss_rec_textfield.setText(Model.getInstance().getViewFactory().getSat_otherloss_rec().get());
    }
    public  void setFiletxfeederloss_tra(){
        txfeederloss_tra_textfield.setText(Model.getInstance().getViewFactory().getSat_txfeederloss_tra().get());
    }
    public  void setFileothertxloss_tra(){
        othertxloss_tra_textfield.setText(Model.getInstance().getViewFactory().getSat_othertxloss_tra().get());
    }
    public  void setFilehpspower_tra(){
        hpspower_tra_textfield.setText(Model.getInstance().getViewFactory().getSat_hpspower_tra().get());
    }
    public  void setFilehpaobo_tra(){
        hpaobo_tra_textfield.setText(Model.getInstance().getViewFactory().getSat_hpaobo_tra().get());
    }
    public  void setFileantennagain_tra(){
        antennagain_tra_textfield.setText(Model.getInstance().getViewFactory().getSat_antennagain_tra().get());
    }
    public  void setFileLatitude(){
        latitude_sat_textfield.setText(Model.getInstance().getViewFactory().getSatelliteLatitude().get());
    }
    private void addListeners(){
            altitude_sat_textfield.focusedProperty().addListener(event -> getAltitude_sat_textfield());
            longitude_sat_textfield.focusedProperty().addListener(event -> getLongitude_sat_textfield());
            intrloss_rec_textfield.focusedProperty().addListener(event -> getIntrloss_rec_textfield());
            rxgt_rec_textfield.focusedProperty().addListener(event -> getRxgt_rec_textfield());
            rxfeederloss_rec_textfield.focusedProperty().addListener(event -> getRxfeederloss_rec_textfield());
            otherloss_rec_textfield.focusedProperty().addListener(event -> getOtherloss_rec_textfield());
            txfeederloss_tra_textfield.focusedProperty().addListener(event -> getTxfeederloss_tra_textfield());
            othertxloss_tra_textfield.focusedProperty().addListener(event -> getOthertxloss_tra_textfield());
            hpspower_tra_textfield.focusedProperty().addListener(event -> getHpspower_tra_textfield());
            hpaobo_tra_textfield.focusedProperty().addListener(event -> getHpaobo_tra_textfield());
            latitude_sat_textfield.focusedProperty().addListener(event -> getLatitude_sat_textfield());
            antennagain_tra_textfield.focusedProperty().addListener(event -> getAntennagain_tra_textfield());
    }
    public void getAltitude_sat_textfield() {
         Model.getInstance().getViewFactory().getSatelliteAltitude().set(altitude_sat_textfield.getText());
    }

    public void getLongitude_sat_textfield() {
       Model.getInstance().getViewFactory().getSatelliteLongitude().set(longitude_sat_textfield.getText());
    }

    public void getLatitude_sat_textfield() {
        Model.getInstance().getViewFactory().getSatelliteLatitude().set(latitude_sat_textfield.getText());
    }

    public void getAntennagain_tra_textfield() {
        Model.getInstance().getViewFactory().getSat_antennagain_tra().set(antennagain_tra_textfield.getText());
    }

    public void getHpaobo_tra_textfield() {
        Model.getInstance().getViewFactory().getSat_hpaobo_tra().set(hpaobo_tra_textfield.getText());
    }

    public void getHpspower_tra_textfield() {
        Model.getInstance().getViewFactory().getSat_hpspower_tra().set(hpspower_tra_textfield.getText());
    }

    public void getIntrloss_rec_textfield() {
        Model.getInstance().getViewFactory().getSat_intrloss_rec().set(intrloss_rec_textfield.getText());
    }

    public void getOtherloss_rec_textfield() {
        Model.getInstance().getViewFactory().getSat_otherloss_rec().set(otherloss_rec_textfield.getText());
    }

    public void getOthertxloss_tra_textfield() {
        Model.getInstance().getViewFactory().getSat_othertxloss_tra().set(othertxloss_tra_textfield.getText());
    }

    public void getRxfeederloss_rec_textfield() {
        Model.getInstance().getViewFactory().getSatr_txfeederloss_rec().set(rxfeederloss_rec_textfield.getText());
    }

    public void getRxgt_rec_textfield() {
        Model.getInstance().getViewFactory().getSat_rxgt_rec().set(rxgt_rec_textfield.getText());
    }

    public void getTxfeederloss_tra_textfield() {
        Model.getInstance().getViewFactory().getSat_txfeederloss_tra().set(txfeederloss_tra_textfield.getText());
    }
    public void loadFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load File");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Sat Files", "*.sat"));

        File file = fileChooser.showOpenDialog(null);

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            ArrayList<String> textfield_content = (ArrayList<String>) in.readObject();
            altitude_sat_textfield.setText(textfield_content.get(0));



        } catch (IOException | ClassNotFoundException ex) {
        }
    }

}
