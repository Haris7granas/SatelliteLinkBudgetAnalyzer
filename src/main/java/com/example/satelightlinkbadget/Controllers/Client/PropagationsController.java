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

public class PropagationsController implements Initializable {
    public TextField frequency_up_txf;
    public TextField bandwith_up_txf;
    public TextField bitrate_up_txf;
    public TextField requiredebno_up_txf;
    public TextField polarmish_up_txf;
    public TextField implemloss_up_txf;
    public TextField antennamispoint_up_txf;
    public TextField radomeloss_up_txf;
    public TextField frequency_down_txf;
    public TextField bandwith_down_txf;
    public TextField bitrate_down_txf;
    public TextField requiredebno_down_txf;
    public TextField polarmish_down_txf;
    public TextField implemloss_down_txf;
    public TextField antennamispoint_down_txf;
    public TextField radomeloss_down_txf;
    public TextField availability_up;
    public TextField availability_down;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().addListener((observableValue, oldValue, newValue) -> {
            if (newValue.equals("Data")) {
                setFrequency_up();
                setBandwith_up();
                setbitrate_up();
                setrequiredebno_up();
                setpolarmish_up();
                setimplemloss_up_up();
                setantennamispoint_up();
                setradomeloss_up();
                setfrequency_down();
                setbandwith_down();
                setbitrate_down();
                setrequiredebno_down();
                setpolarmish_down();
                setimplemloss_down();
                setantennamispoint_down();
                setradomeloss_down();
                setavailability_up();
                setavailability_down();
            }
        });
    }

    private void addListeners(){
            frequency_up_txf.focusedProperty().addListener(event -> getFrequency_up_txf());
            bandwith_up_txf.focusedProperty().addListener(event -> getBandwith_up_txf());
            bitrate_up_txf.focusedProperty().addListener(event -> getBitrate_up_txf());
            requiredebno_up_txf.focusedProperty().addListener(event -> getRequiredebno_up_txf());
            polarmish_up_txf.focusedProperty().addListener(event -> getPolarmish_up_txf());
            implemloss_up_txf.focusedProperty().addListener(event -> getImplemloss_up_txf());
            antennamispoint_up_txf.focusedProperty().addListener(event -> getAntennamispoint_up_txf());
            radomeloss_up_txf.focusedProperty().addListener(event -> getRadomeloss_up_txf());
            frequency_down_txf.focusedProperty().addListener(event -> getFrequency_down_txf());
            bandwith_down_txf.focusedProperty().addListener(event -> getBandwith_down_txf());
            bitrate_down_txf.focusedProperty().addListener(event -> getBitrate_down_txf());
            requiredebno_down_txf.focusedProperty().addListener(event -> getRequiredebno_down_txf());
            polarmish_down_txf.focusedProperty().addListener(event -> getPolarmish_down_txf());
            implemloss_down_txf.focusedProperty().addListener(event -> getImplemloss_down_txf());
            antennamispoint_down_txf.focusedProperty().addListener(event -> getAntennamispoint_down_txf());
            radomeloss_down_txf.focusedProperty().addListener(event -> getRadomeloss_down_txf());
            availability_up.focusedProperty().addListener(event -> getAvailability_up());
            availability_down.focusedProperty().addListener(event -> getAvailability_down());
    }

    public void setFrequency_up() {
        frequency_up_txf.setText(Model.getInstance().getViewFactory().getPropUp_frequency().get());
    }
    public void setBandwith_up() {
        bandwith_up_txf.setText(Model.getInstance().getViewFactory().getPropUp_bandwith().get());

    }
    public void setbitrate_up() {
        bitrate_up_txf.setText(Model.getInstance().getViewFactory().getPropUp_bitrate().get());

    }
    public void setrequiredebno_up() {
        requiredebno_up_txf.setText(Model.getInstance().getViewFactory().getPropUp_requiredebno().get());
    }
    public void setpolarmish_up() {
        polarmish_up_txf.setText(Model.getInstance().getViewFactory().getPropUp_polarmish().get());

    }
    public void setimplemloss_up_up() {
        implemloss_up_txf.setText(Model.getInstance().getViewFactory().getPropUp_implemloss().get());

    }
    public void setantennamispoint_up() {
        antennamispoint_up_txf.setText(Model.getInstance().getViewFactory().getPropUp_antennamispoint().get());

    }
    public void setradomeloss_up() {
        radomeloss_up_txf.setText(Model.getInstance().getViewFactory().getPropUp_radomeloss().get());

    }
    public void setfrequency_down() {
        frequency_down_txf.setText(Model.getInstance().getViewFactory().getPropDown_frequency().get());

    }
    public void setbandwith_down() {
        bandwith_down_txf.setText(Model.getInstance().getViewFactory().getPropDown_bandwith().get());

    }
    public void setbitrate_down() {
        bitrate_down_txf.setText(Model.getInstance().getViewFactory().getPropDown_bitrate().get());

    }
    public void setrequiredebno_down() {
        requiredebno_down_txf.setText(Model.getInstance().getViewFactory().getPropDown_requiredebno().get());
    }
    public void setpolarmish_down() {
        polarmish_down_txf.setText(Model.getInstance().getViewFactory().getPropDown_polarmish().get());
    }
    public void setimplemloss_down() {
        implemloss_down_txf.setText(Model.getInstance().getViewFactory().getPropDown_implemloss().get());
    }
    public void setantennamispoint_down() {
        antennamispoint_down_txf.setText(Model.getInstance().getViewFactory().getPropDown_antennamispoint().get());
    }
    public void setradomeloss_down() {
        radomeloss_down_txf.setText(Model.getInstance().getViewFactory().getPropDown_radomeloss().get());
    }
    public void setavailability_up() {
        availability_up.setText(Model.getInstance().getViewFactory().getAvailability_up().get());
    }
    public void setavailability_down() {
        availability_down.setText(Model.getInstance().getViewFactory().getAvailability_down().get());
    }
    public void getFrequency_up_txf() {
        Model.getInstance().getViewFactory().getPropUp_frequency().set(frequency_up_txf.getText());
    }
    public void getBandwith_up_txf() {
        Model.getInstance().getViewFactory().getPropUp_bandwith().set(bandwith_up_txf.getText());
    }
    public void getBitrate_up_txf() {
        Model.getInstance().getViewFactory().getPropUp_bitrate().set(bitrate_up_txf.getText());
    }
    public void getRequiredebno_up_txf() {
        Model.getInstance().getViewFactory().getPropUp_requiredebno().set(requiredebno_up_txf.getText());
    }
    public void getPolarmish_up_txf() {
        Model.getInstance().getViewFactory().getPropUp_polarmish().set(polarmish_up_txf.getText());
    }
    public void getImplemloss_up_txf() {
        Model.getInstance().getViewFactory().getPropUp_implemloss().set(implemloss_up_txf.getText());
    }
    public void getAntennamispoint_up_txf() {
        Model.getInstance().getViewFactory().getPropUp_antennamispoint().set(antennamispoint_up_txf.getText());
    }
    public void getRadomeloss_up_txf() {
        Model.getInstance().getViewFactory().getPropUp_radomeloss().set(radomeloss_up_txf.getText());
    }
    public void getFrequency_down_txf() {
        Model.getInstance().getViewFactory().getPropDown_frequency().set(frequency_down_txf.getText());
    }
    public void getBandwith_down_txf() {
        Model.getInstance().getViewFactory().getPropDown_bandwith().set(bandwith_down_txf.getText());
    }
    public void getBitrate_down_txf() {
        Model.getInstance().getViewFactory().getPropDown_bitrate().set(bitrate_down_txf.getText());
    }
    public void getRequiredebno_down_txf() {
        Model.getInstance().getViewFactory().getPropDown_requiredebno().set(requiredebno_down_txf.getText());
    }
    public void getPolarmish_down_txf() {
        Model.getInstance().getViewFactory().getPropDown_polarmish().set(polarmish_down_txf.getText());
    }
    public void getImplemloss_down_txf() {
        Model.getInstance().getViewFactory().getPropDown_implemloss().set(implemloss_down_txf.getText());
    }
    public void getAntennamispoint_down_txf() {
        Model.getInstance().getViewFactory().getPropDown_antennamispoint().set(antennamispoint_down_txf.getText());
    }
    public void getRadomeloss_down_txf() {
        Model.getInstance().getViewFactory().getPropDown_radomeloss().set(radomeloss_down_txf.getText());
    }

    public void getAvailability_up() {
          Model.getInstance().getViewFactory().getAvailability_up().set(availability_up.getText());;
    }

    public void getAvailability_down() {
        Model.getInstance().getViewFactory().getAvailability_down().set(availability_down.getText());
    }
}