package com.example.satelightlinkbadget.Controllers.Client;
/**
 *
 * @author Charalampos Gkranas
 */
import com.example.satelightlinkbadget.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.time.Year;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.net.URL;

import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public TextField distance_up;
    public TextField elevation_up;
    public TextField txeirp_up;
    public TextField polar_loss_up;
    public TextField fspl_up;
    public TextField rainatt_up;
    public TextField recisotropicpower_up;
    public TextField cno_up;
    public TextField cn_up;
    public TextField recebno_up;
    public TextField margin_up;
    public TextField distance_down;
    public TextField elevation_down;
    public TextField txeirp_down;
    public TextField polar_loss_down;
    public TextField fspl_down;
    public TextField rainatt_down;
    public TextField recisotropicpower_down;
    public TextField cno_down;
    public TextField cn_down;
    public TextField recebno_down;
    public TextField margin_down;
    public ComboBox<String> combobox = new ComboBox<>();
    public NumberAxis y = new NumberAxis();
    public NumberAxis x = new NumberAxis();
    public LineChart chart = new LineChart<>(x,y);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        distance_up.setEditable(false);
        elevation_up.setEditable(false);
        txeirp_up.setEditable(false);
        polar_loss_up.setEditable(false);
        fspl_up.setEditable(false);
        rainatt_up.setEditable(false);
        recisotropicpower_up.setEditable(false);
        cno_up.setEditable(false);
        cn_up.setEditable(false);
        recebno_up.setEditable(false);
        margin_up.setEditable(false);
        distance_down.setEditable(false);
        elevation_down.setEditable(false);
        txeirp_down.setEditable(false);
        polar_loss_down.setEditable(false);
        fspl_down.setEditable(false);
        rainatt_down.setEditable(false);
        recisotropicpower_down.setEditable(false);
        cno_down.setEditable(false);
        cn_down.setEditable(false);
        recebno_down.setEditable(false);
        margin_down.setEditable(false);
        combobox.getItems().addAll("fspl/distance UPLINK","fspl/distance DOWNLINK","fspl/frequency UPLINK","fspl/frequency DOWNLINK","Margin/Implementation Loss");
        combobox.setOnAction(e -> {
            if(combobox.getValue() == "fspl/distance UPLINK"){
                onFsplDistance();
            }
            if(combobox.getValue() == "fspl/distance DOWNLINK"){
                onRainMargin();
            }
            if(combobox.getValue() == "fspl/frequency UPLINK"){
                onfreqUPFSPL();
            }
            if(combobox.getValue() == "fspl/frequency DOWNLINK"){
                onfreqDOWNFSPL();
            }
            if(combobox.getValue() == "Margin/Implementation Loss"){
                margindown();
            }



        });
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().addListener((observableValue, oldValue, newValue) -> {
            if (newValue.equals("Calculate")) {
                setDistanceUP();
                setTxEIRP_UP();
                setFspl_up();
                setPolar_loss_up();
                setRecisotropicpower_up();
                setCno_up();
                setCn_up();
                setRecebno_up();
                setMargin_up();
                setRainatt_up();
                setDistanceDOWN();
                setTxEIRP_DOWN();
                setPolar_loss_down();
                setFspl_down();
                setRainatt_down();
                setRecisotropicpower_down();
                setCno_down();
                setCn_down();
                setRecebno_down();
                setMargin_down();

            }

        });

    }

    public void onfreqUPFSPL(){
        chart.getData().clear();
        x.setLabel("Frequency (GHz)");
        y.setLabel("FSPL (dB)");
        XYChart.Series s = new XYChart.Series();
        XYChart.Series s1 = new XYChart.Series();
        try {
            for (double i = 1; i < 100; i += 5) {
                double x = Model.getInstance().getViewFactory().fspl_upFreq(i);
                s.getData().add(new XYChart.Data(i, x));
            }
            chart.getData().add(s);
            chart.setLegendVisible(false);
        }catch (NumberFormatException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Some TextFields are empty ");
            alert.showAndWait();
        }
    }
    public void margindown(){
        chart.getData().clear();
        y.setLabel("Margin (dB)");
        x.setLabel("Implementation Loss (dB)");
        XYChart.Series s = new XYChart.Series();
        XYChart.Series s1 = new XYChart.Series();
        try {
            for (double i = 1; i < 100; i += 5.5) {
                double x = Model.getInstance().getViewFactory().marginCHART(i);
                s.getData().add(new XYChart.Data(i, x));
            }
            chart.getData().add(s);
            chart.setLegendVisible(false);
        }catch (NumberFormatException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Some TextFields are empty ");
            alert.showAndWait();
        }
    }
    public void onfreqDOWNFSPL(){
        chart.getData().clear();
        x.setLabel("Frequency (GHz)");
        y.setLabel("FSPL (dB)");
        XYChart.Series s = new XYChart.Series();
        XYChart.Series s1 = new XYChart.Series();
        try {
            for (double i = 1; i < 100; i += 5) {
                double x = Model.getInstance().getViewFactory().fspl_downFreq(i);
                s.getData().add(new XYChart.Data(i, x));
            }
            chart.getData().add(s);
            chart.setLegendVisible(false);
        }catch (NumberFormatException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Some TextFields are empty ");
            alert.showAndWait();
        }
    }

    public void onRainMargin(){
        chart.getData().clear();
        x.setLabel("Distance (km)");
        y.setLabel("FSPL (dB)");
        XYChart.Series s = new XYChart.Series();
        XYChart.Series s1 = new XYChart.Series();
        try {
            for (double i = 0.1; i < 100; i += 6.5) {
                double y= Model.getInstance().getViewFactory().fspl2(i);
                s1.getData().add(new XYChart.Data(i,y));
            }
            //chart.getData().add(s);
            chart.getData().add(s1);
            chart.setLegendVisible(false);
        }catch (NumberFormatException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Some TextFields are empty ");
            alert.showAndWait();
        }
    }
    public void onFsplDistance(){
        chart.getData().clear();
        x.setLabel("Distance (km)");
        y.setLabel("FSPL (dB)");
        XYChart.Series s = new XYChart.Series();
        XYChart.Series s1 = new XYChart.Series();
        try {
            for (double i = 0.1; i < 100; i += 6.5) {
                double x = Model.getInstance().getViewFactory().fspl(i);
                double y= Model.getInstance().getViewFactory().fspl2(i);
                s.getData().add(new XYChart.Data(i, x));
                s1.getData().add(new XYChart.Data(i,y));

            }
            chart.getData().add(s);
            //chart.getData().add(s1);
            chart.setLegendVisible(false);
        }catch (NumberFormatException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Some TextFields are empty ");
            alert.showAndWait();
        }
    }


    public void setDistanceUP() {
        double[] distance = Model.getInstance().getViewFactory().distance_up();
        distance_up.setText(Double.toString(distance[0]));
        elevation_up.setText(Double.toString(distance[1]));
    }
    public void setDistanceDOWN(){
        double[] distance = Model.getInstance().getViewFactory().distance_up();
        distance_down.setText(Double.toString(distance[0]));
        elevation_down.setText(Double.toString(distance[1]));
    }

    public void setTxEIRP_UP(){
        double txEIRP = Model.getInstance().getViewFactory().txEIRP_up();
        txeirp_up.setText(Double.toString(txEIRP));
    }
    public void setTxEIRP_DOWN(){
        double txEIRP = Model.getInstance().getViewFactory().txEIRP_down();
        txeirp_down.setText(Double.toString(txEIRP));
    }
    public void setFspl_up(){
        double fspl = Model.getInstance().getViewFactory().fspl_up();
        fspl_up.setText(Double.toString(fspl));
    }
    public void setFspl_down(){
        double fspl = Model.getInstance().getViewFactory().fspl_down();
        fspl_down.setText(Double.toString(fspl));
    }
    public void setPolar_loss_up(){
        double polarMismatch = Model.getInstance().getViewFactory().polarizationLoss_up();
        polar_loss_up.setText(Double.toString(polarMismatch));
    }
    public void setPolar_loss_down(){
        double polarMismatch = Model.getInstance().getViewFactory().polarizationLoss_down();
        polar_loss_down.setText(Double.toString(polarMismatch));
    }
    public void setRecisotropicpower_up(){
        double received_isotropic_power = Model.getInstance().getViewFactory().rec_isotropic_power();
        recisotropicpower_up.setText(Double.toString(received_isotropic_power));
    }
    public void setRecisotropicpower_down(){
        double received_isotropic_power = Model.getInstance().getViewFactory().rec_isotropic_powerdown();
        recisotropicpower_down.setText(Double.toString(received_isotropic_power));
    }

    public void setCno_up(){
        double CbyNo = Model.getInstance().getViewFactory().CbyNo();
        cno_up.setText(Double.toString(CbyNo));
    }
    public void setCno_down(){
        double CbyNo = Model.getInstance().getViewFactory().CbyNodown();
        cno_down.setText(Double.toString(CbyNo));
    }


    public void setCn_up(){
        double CbyN = Model.getInstance().getViewFactory().CbyN();
        cn_up.setText(Double.toString(CbyN));
    }
    public void setCn_down(){
        double CbyN = Model.getInstance().getViewFactory().CbyNdown();
        cn_down.setText(Double.toString(CbyN));
    }

    public void setRecebno_up(){
        double rec_CbyNo = Model.getInstance().getViewFactory().Received_EbNo();
        recebno_up.setText(Double.toString(rec_CbyNo));
    }
    public void setRecebno_down(){
        double rec_CbyNo = Model.getInstance().getViewFactory().Received_EbNodown();
        recebno_down.setText(Double.toString(rec_CbyNo));
    }
    public void setMargin_up(){
        double margin = Model.getInstance().getViewFactory().margin();
        margin_up.setText(Double.toString(margin));
    }
    public void setMargin_down(){
        double margin = Model.getInstance().getViewFactory().margindown();
        margin_down.setText(Double.toString(margin));
    }

    public void setRainatt_up() {
        double rainAtt = Model.getInstance().getViewFactory().rainAtt_up();
        this.rainatt_up.setText(Double.toString(rainAtt));
    }

    public void setRainatt_down() {
        double rainAtt = Model.getInstance().getViewFactory().rainAtt_down();
        this.rainatt_down.setText(Double.toString(rainAtt));
    }
}
