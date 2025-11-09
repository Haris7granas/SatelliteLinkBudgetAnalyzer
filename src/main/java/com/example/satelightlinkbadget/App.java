package com.example.satelightlinkbadget;
/**
*
* @author Charalampos Gkranas
*/
import com.example.satelightlinkbadget.Models.Model;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Model.getInstance().getViewFactory().showClientWindow();
    }



}
