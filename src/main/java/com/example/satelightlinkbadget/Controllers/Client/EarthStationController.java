package com.example.satelightlinkbadget.Controllers.Client;
/**
 *
 * @author Charalampos Gkranas
 */
import com.example.satelightlinkbadget.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class EarthStationController implements Initializable {
    public TextField lat_tra_txf;
    public TextField lon_tra_txf;
    public TextField alt_tra_txf;
    public TextField txfeederloss_tra_txf;
    public TextField othertxlosses_tra_txf;
    public TextField txhpapower_tra_txf;
    public TextField txhpaobo_tra_txf;
    public TextField txantennagain_tra_txf;
    public TextField interloss_rec_txf;
    public TextField rxgt_rec_txf;
    public TextField rxfeederloss_rec_txf;
    public TextField otherrxlosses_rec_txf;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().addListener((observableValue, oldValue, newValue) -> {
            if (newValue.equals("Data")) {
                setFileLat_tra();
                setFileLon_tra();
                setFileAlt_tra();
                setFiletxfeederloss_tra();
                setFileothertxlosses_tra();
                setFiletxhpapower_tra();
                setFiletxhpaobo_tra();
                setFiletxantennagain_tra();
                setFileInterloss_rec();
                setFileIrxgt_rec();
                setFileRxfeederlossr_rec();
                setFileOtherrxlosses_rec();
            }
        });
    }
    private void addListeners(){
            lat_tra_txf.focusedProperty().addListener(event -> getEarth1_lat());
            lon_tra_txf.focusedProperty().addListener(event -> getEarth1_lon());
            alt_tra_txf.focusedProperty().addListener(event -> getEarth1_alt());
            txfeederloss_tra_txf.focusedProperty().addListener(event -> getEarth1_txfeederloss_tra_txf());
            othertxlosses_tra_txf.focusedProperty().addListener(event -> getEarth1_othertxlosses_tra_txf());
            txhpapower_tra_txf.focusedProperty().addListener(event -> getEarth1_txhpapower());
            txhpaobo_tra_txf.focusedProperty().addListener(event -> getEarth1_txhpaobo());
            txantennagain_tra_txf.focusedProperty().addListener(event -> getEarth1_txantennagain());
            interloss_rec_txf.focusedProperty().addListener(event -> getEarth2_interloss());
            rxgt_rec_txf.focusedProperty().addListener(event -> getEarth2_rxgt_rec_txf());
            rxfeederloss_rec_txf.focusedProperty().addListener(event -> getEarth2_rxfeederloss());
            otherrxlosses_rec_txf.focusedProperty().addListener(event -> getEarth2_otherrxlosses());
    }
    public void setFileLat_tra(){lat_tra_txf.setText(Model.getInstance().getViewFactory().getEarth1_lat().get());}
    public void setFileLon_tra(){lon_tra_txf.setText(Model.getInstance().getViewFactory().getEarth1_lon().get());}
    public void setFileAlt_tra(){alt_tra_txf.setText(Model.getInstance().getViewFactory().getEarth1_alt().get());}
    public void setFiletxfeederloss_tra(){txfeederloss_tra_txf.setText(Model.getInstance().getViewFactory().getEarth1_txfeederloss().get());}
    public void setFileothertxlosses_tra(){othertxlosses_tra_txf.setText(Model.getInstance().getViewFactory().getEarth1_othertxlosses().get());}
    public void setFiletxhpapower_tra(){txhpapower_tra_txf.setText(Model.getInstance().getViewFactory().getEarth1_txhpapower().get());}
    public void setFiletxhpaobo_tra(){txhpaobo_tra_txf.setText(Model.getInstance().getViewFactory().getEarth1_txhpaobo().get());}
    public void setFiletxantennagain_tra(){txantennagain_tra_txf.setText(Model.getInstance().getViewFactory().getEarth1_txantennagain().get());}
    //receivers
    public void setFileInterloss_rec(){interloss_rec_txf.setText(Model.getInstance().getViewFactory().getEarth2_interloss().get());}
    public void setFileIrxgt_rec(){rxgt_rec_txf.setText(Model.getInstance().getViewFactory().getEarth2_irxgt().get());}
    public void setFileRxfeederlossr_rec(){rxfeederloss_rec_txf.setText(Model.getInstance().getViewFactory().getEarth2_rxfeederloss().get());}
    public void setFileOtherrxlosses_rec(){otherrxlosses_rec_txf.setText(Model.getInstance().getViewFactory().getEarth2_otherrxlosses().get());}

    public void getEarth1_lat() {
        Model.getInstance().getViewFactory().getEarth1_lat().set(lat_tra_txf.getText());
    }
    public void getEarth1_lon() {
        Model.getInstance().getViewFactory().getEarth1_lon().set(lon_tra_txf.getText());
    }
    public void getEarth1_alt() {
        Model.getInstance().getViewFactory().getEarth1_alt().set(alt_tra_txf.getText());
    }
    public void getEarth1_txfeederloss_tra_txf() {
        Model.getInstance().getViewFactory().getEarth1_txfeederloss().set(txfeederloss_tra_txf.getText());
    }
    public void getEarth1_othertxlosses_tra_txf() {
        Model.getInstance().getViewFactory().getEarth1_othertxlosses().set(othertxlosses_tra_txf.getText());
    }
    public void getEarth1_txhpapower() {
        Model.getInstance().getViewFactory().getEarth1_txhpapower().set(txhpapower_tra_txf.getText());
    }
    public void getEarth1_txhpaobo() {
        Model.getInstance().getViewFactory().getEarth1_txhpaobo().set(txhpaobo_tra_txf.getText());
    }
    public void getEarth1_txantennagain() {
        Model.getInstance().getViewFactory().getEarth1_txantennagain().set(txantennagain_tra_txf.getText());
    }
    public void getEarth2_interloss() {
        Model.getInstance().getViewFactory().getEarth2_interloss().set(interloss_rec_txf.getText());
    }
    public void getEarth2_rxgt_rec_txf() {
        Model.getInstance().getViewFactory().getEarth2_irxgt().set(rxgt_rec_txf.getText());
    }
    public void getEarth2_rxfeederloss() {
        Model.getInstance().getViewFactory().getEarth2_rxfeederloss().set(rxfeederloss_rec_txf.getText());
    }
    public void getEarth2_otherrxlosses() {
        Model.getInstance().getViewFactory().getEarth2_otherrxlosses().set(otherrxlosses_rec_txf.getText());
    }

}
