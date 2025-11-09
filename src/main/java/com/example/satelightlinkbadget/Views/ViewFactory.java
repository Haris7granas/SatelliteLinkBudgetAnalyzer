package com.example.satelightlinkbadget.Views;
/**
 *
 * @author Charalampos Gkranas
 */
import com.example.satelightlinkbadget.Controllers.Client.ClientController;
import com.example.satelightlinkbadget.Models.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class ViewFactory {
    public static final double BOLTZMANN_CONSTANT = 1.380649e-23;
    private final StringProperty clientSelectedMenuItem;
    private final SimpleStringProperty satelliteAltitude;
    private final SimpleStringProperty satelliteLongitude;
    private final SimpleStringProperty satelliteLatitude;
    private final SimpleStringProperty sat_intrloss_rec;
    private final SimpleStringProperty sat_rxgt_rec;
    private final SimpleStringProperty satr_txfeederloss_rec;
    private final SimpleStringProperty sat_otherloss_rec;
    private final SimpleStringProperty sat_txfeederloss_tra;
    private final SimpleStringProperty sat_othertxloss_tra;
    private final SimpleStringProperty sat_hpspower_tra;
    private final SimpleStringProperty sat_hpaobo_tra;
    private final SimpleStringProperty sat_antennagain_tra;
    private final SimpleStringProperty earth1_lat;
    private final SimpleStringProperty earth1_lon;
    private final SimpleStringProperty earth1_alt;
    private final SimpleStringProperty earth1_txfeederloss;
    private final SimpleStringProperty earth1_othertxlosses;
    private final SimpleStringProperty earth1_txhpapower;
    private final SimpleStringProperty earth1_txhpaobo;
    private final SimpleStringProperty earth1_txantennagain;
    private  final SimpleStringProperty earth2_interloss;
    private  final SimpleStringProperty earth2_irxgt;
    private  final SimpleStringProperty earth2_rxfeederloss;
    private  final SimpleStringProperty earth2_otherrxlosses;
    private final SimpleStringProperty propUp_frequency;
    private final SimpleStringProperty  propUp_bandwith;
    private final SimpleStringProperty  propUp_bitrate;
    private final SimpleStringProperty  propUp_requiredebno;
    private final SimpleStringProperty  propUp_polarmish;
    private final SimpleStringProperty  propUp_implemloss;
    private final SimpleStringProperty  propUp_antennamispoint;
    private final SimpleStringProperty  propUp_radomeloss;
    private final SimpleStringProperty propDown_frequency;
    private final SimpleStringProperty propDown_bandwith;
    private final SimpleStringProperty propDown_bitrate;
    private final SimpleStringProperty propDown_requiredebno;
    private final SimpleStringProperty propDown_polarmish;
    private final SimpleStringProperty propDown_implemloss;
    private final SimpleStringProperty propDown_antennamispoint;
    private final SimpleStringProperty propDown_radomeloss;
    private final SimpleStringProperty availability_up;
    private final SimpleStringProperty availability_down;



    private AnchorPane satelliteView;
    private AnchorPane earthStationView;
    private AnchorPane propagationView;
    public AnchorPane dashboardView;

    public ViewFactory(){

        this.clientSelectedMenuItem = new SimpleStringProperty("");
        this.availability_up = new SimpleStringProperty("");
        this.availability_down = new SimpleStringProperty("");
        this.satelliteLongitude = new SimpleStringProperty("");
        this.satelliteAltitude = new SimpleStringProperty("");
        this.satelliteLatitude = new SimpleStringProperty("");
        this.sat_intrloss_rec = new SimpleStringProperty("");
        this.sat_rxgt_rec = new SimpleStringProperty("");
        this.satr_txfeederloss_rec = new SimpleStringProperty("");
        this.sat_otherloss_rec = new SimpleStringProperty("");
        this.sat_txfeederloss_tra = new SimpleStringProperty("");
        this.sat_othertxloss_tra = new SimpleStringProperty("");
        this.sat_hpspower_tra = new SimpleStringProperty("");
        this.sat_hpaobo_tra = new SimpleStringProperty("");
        this.sat_antennagain_tra = new SimpleStringProperty("");
        this.earth1_lat = new SimpleStringProperty("");
        this.earth1_lon = new SimpleStringProperty("");
        this.earth1_alt = new SimpleStringProperty("");
        this.earth1_txfeederloss = new SimpleStringProperty("");
        this.earth1_othertxlosses = new SimpleStringProperty("");
        this.earth1_txhpapower = new SimpleStringProperty("");
        this.earth1_txhpaobo = new SimpleStringProperty("");
        this.earth1_txantennagain = new SimpleStringProperty("");
        this.earth2_interloss = new SimpleStringProperty("");
        this.earth2_irxgt = new SimpleStringProperty("");
        this.earth2_rxfeederloss = new SimpleStringProperty("");
        this.earth2_otherrxlosses = new SimpleStringProperty("");
        this.propUp_frequency = new SimpleStringProperty("");
        this.propUp_bandwith = new SimpleStringProperty("");
        this.propUp_bitrate = new SimpleStringProperty("");
        this.propUp_requiredebno = new SimpleStringProperty("");
        this.propUp_polarmish = new SimpleStringProperty("");
        this.propUp_implemloss = new SimpleStringProperty("");
        this.propUp_antennamispoint = new SimpleStringProperty("");
        this.propUp_radomeloss = new SimpleStringProperty("");
        this.propDown_frequency = new SimpleStringProperty("");
        this.propDown_bandwith = new SimpleStringProperty("");
        this.propDown_bitrate = new SimpleStringProperty("");
        this.propDown_requiredebno = new SimpleStringProperty("");
        this.propDown_polarmish = new SimpleStringProperty("");
        this.propDown_implemloss = new SimpleStringProperty("");
        this.propDown_antennamispoint = new SimpleStringProperty("");
        this.propDown_radomeloss = new SimpleStringProperty("");
    }

    public SimpleStringProperty getAvailability_up(){return  availability_up;}
    public SimpleStringProperty getAvailability_down(){return  availability_down;}
    public SimpleStringProperty getPropUp_frequency() {return propUp_frequency;}
    public SimpleStringProperty getPropUp_bandwith() {return propUp_bandwith;}
    public SimpleStringProperty getPropUp_bitrate() {return propUp_bitrate;}
    public SimpleStringProperty getPropUp_requiredebno() {return propUp_requiredebno;}
    public SimpleStringProperty getPropUp_polarmish() {return propUp_polarmish;}
    public SimpleStringProperty getPropUp_implemloss() {return propUp_implemloss;}
    public SimpleStringProperty getPropUp_antennamispoint() {return propUp_antennamispoint;}
    public SimpleStringProperty getPropUp_radomeloss() {return propUp_radomeloss;}
    public SimpleStringProperty getPropDown_frequency() {return propDown_frequency;}
    public SimpleStringProperty getPropDown_bandwith() {return propDown_bandwith;}
    public SimpleStringProperty getPropDown_bitrate() {return propDown_bitrate;}
    public SimpleStringProperty getPropDown_requiredebno() {return propDown_requiredebno;}
    public SimpleStringProperty getPropDown_polarmish() {return propDown_polarmish;}
    public SimpleStringProperty getPropDown_implemloss() {return propDown_implemloss;}
    public SimpleStringProperty getPropDown_antennamispoint() {return propDown_antennamispoint;}
    public SimpleStringProperty getPropDown_radomeloss() {return propDown_radomeloss;}
    public SimpleStringProperty getEarth2_interloss() {return earth2_interloss;}
    public SimpleStringProperty getEarth2_irxgt() {return earth2_irxgt;}
    public SimpleStringProperty getEarth2_rxfeederloss() {return earth2_rxfeederloss;}
    public SimpleStringProperty getEarth2_otherrxlosses() {return earth2_otherrxlosses;}
    public SimpleStringProperty getEarth1_lat(){return earth1_lat;}
    public SimpleStringProperty getEarth1_lon(){return earth1_lon;}
    public SimpleStringProperty getEarth1_alt(){return earth1_alt;}
    public SimpleStringProperty getEarth1_txfeederloss(){return earth1_txfeederloss;}
    public SimpleStringProperty getEarth1_othertxlosses(){return earth1_othertxlosses;}
    public SimpleStringProperty getEarth1_txhpapower(){return earth1_txhpapower;}
    public SimpleStringProperty getEarth1_txhpaobo(){return earth1_txhpaobo;}
    public SimpleStringProperty getEarth1_txantennagain(){return earth1_txantennagain;}
    public SimpleStringProperty getSat_antennagain_tra(){return sat_antennagain_tra;}
    public SimpleStringProperty getSat_hpaobo_tra(){return sat_hpaobo_tra;}
    public SimpleStringProperty getSat_hpspower_tra(){return sat_hpspower_tra;}
    public SimpleStringProperty getSat_othertxloss_tra(){return sat_othertxloss_tra;}
    public SimpleStringProperty getSat_txfeederloss_tra(){return sat_txfeederloss_tra;}
    public SimpleStringProperty getSat_otherloss_rec(){return sat_otherloss_rec;}
    public SimpleStringProperty getSatr_txfeederloss_rec(){return satr_txfeederloss_rec;}
    public SimpleStringProperty getSat_rxgt_rec(){return sat_rxgt_rec;}
    public SimpleStringProperty getSat_intrloss_rec(){return sat_intrloss_rec;}
    public SimpleStringProperty getSatelliteLatitude(){return satelliteLatitude;}

    public SimpleStringProperty getSatelliteAltitude() {
        return satelliteAltitude;
    }
    public SimpleStringProperty getSatelliteLongitude() {
        return satelliteLongitude;
    };
    public void loadFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load File");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Sat Files", "*.sat"));

        File file = fileChooser.showOpenDialog(null);

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            ArrayList<String> textfield_content = (ArrayList<String>) in.readObject();
            satelliteAltitude.set(textfield_content.get(0));
            satelliteLongitude.set(textfield_content.get(1));
            satelliteLatitude.set(textfield_content.get(2));
            sat_intrloss_rec.set(textfield_content.get(3));
            sat_rxgt_rec.set(textfield_content.get(4));
            satr_txfeederloss_rec.set(textfield_content.get(5));
            sat_otherloss_rec.set(textfield_content.get(6));
            sat_txfeederloss_tra.set(textfield_content.get(7));
            sat_othertxloss_tra.set(textfield_content.get(8));
            sat_hpspower_tra.set(textfield_content.get(9));
            sat_hpaobo_tra.set(textfield_content.get(10));
            sat_antennagain_tra.set(textfield_content.get(11));
            earth1_lat.set(textfield_content.get(12));
            earth1_lon.set(textfield_content.get(13));
            earth1_alt.set(textfield_content.get(14));
            earth1_txfeederloss.set(textfield_content.get(15));
            earth1_othertxlosses.set(textfield_content.get(16));
            earth1_txhpapower.set(textfield_content.get(17));
            earth1_txhpaobo.set(textfield_content.get(18));
            earth1_txantennagain.set(textfield_content.get(19));
            earth2_interloss.set(textfield_content.get(20));
            earth2_irxgt.set(textfield_content.get(21));
            earth2_rxfeederloss.set(textfield_content.get(22));
            earth2_otherrxlosses.set(textfield_content.get(23));
            propUp_frequency.set(textfield_content.get(24));
            propUp_bandwith.set(textfield_content.get(25));
            propUp_bitrate.set(textfield_content.get(26));
            propUp_requiredebno.set(textfield_content.get(27));
            propUp_polarmish.set(textfield_content.get(28));
            propUp_implemloss.set(textfield_content.get(29));
            propUp_antennamispoint.set(textfield_content.get(30));
            propUp_radomeloss.set(textfield_content.get(31));
            propDown_frequency.set(textfield_content.get(32));
            propDown_bandwith.set(textfield_content.get(33));
            propDown_bitrate.set(textfield_content.get(34));
            propDown_requiredebno.set(textfield_content.get(35));
            propDown_polarmish.set(textfield_content.get(36));
            propDown_implemloss.set(textfield_content.get(37));
            propDown_antennamispoint.set(textfield_content.get(38));
            propDown_radomeloss.set(textfield_content.get(39));
            availability_up.set(textfield_content.get(40));
            availability_down.set(textfield_content.get(41));
        } catch (IOException | ClassNotFoundException | NullPointerException ignored) {
        }
    }

    public void saveToFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Sat Files", "*.sat"));
        //dimiourgia listas keimenou me to periexomeno twn textfield
        ArrayList<String> textfield_content = new ArrayList<>();
        textfield_content.add(satelliteAltitude.get());
        textfield_content.add(satelliteLongitude.get());
        textfield_content.add(satelliteLatitude.get());
        textfield_content.add(sat_intrloss_rec.get());
        textfield_content.add(sat_rxgt_rec.get());
        textfield_content.add(satr_txfeederloss_rec.get());
        textfield_content.add(sat_otherloss_rec.get());
        textfield_content.add(sat_txfeederloss_tra.get());
        textfield_content.add(sat_othertxloss_tra.get());
        textfield_content.add(sat_hpspower_tra.get());
        textfield_content.add(sat_hpaobo_tra.get());
        textfield_content.add(sat_antennagain_tra.get());
        textfield_content.add(earth1_lat.get());
        textfield_content.add(earth1_lon.get());
        textfield_content.add(earth1_alt.get());
        textfield_content.add(earth1_txfeederloss.get());
        textfield_content.add(earth1_othertxlosses.get());
        textfield_content.add(earth1_txhpapower.get());
        textfield_content.add(earth1_txhpaobo.get());
        textfield_content.add(earth1_txantennagain.get());
        textfield_content.add(earth2_interloss.get());
        textfield_content.add(earth2_irxgt.get());
        textfield_content.add(earth2_rxfeederloss.get());
        textfield_content.add(earth2_otherrxlosses.get());
        textfield_content.add(propUp_frequency.get());
        textfield_content.add(propUp_bandwith.get());
        textfield_content.add(propUp_bitrate.get());
        textfield_content.add(propUp_requiredebno.get());
        textfield_content.add(propUp_polarmish.get());
        textfield_content.add(propUp_implemloss.get());
        textfield_content.add(propUp_antennamispoint.get());
        textfield_content.add(propUp_radomeloss.get());
        textfield_content.add(propDown_frequency.get());
        textfield_content.add(propDown_bandwith.get());
        textfield_content.add(propDown_bitrate.get());
        textfield_content.add(propDown_requiredebno.get());
        textfield_content.add(propDown_polarmish.get());
        textfield_content.add(propDown_implemloss.get());
        textfield_content.add(propDown_antennamispoint.get());
        textfield_content.add(propDown_radomeloss.get());
        textfield_content.add(availability_up.get());
        textfield_content.add(availability_down.get());


        File file = fileChooser.showSaveDialog(null);
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                out.writeObject(textfield_content);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("File Saved!!");

                alert.showAndWait();
            } catch (NullPointerException | IOException ex) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("The save method cancelled");
                alert.showAndWait();
            }
    }
    public  double[] distance_up(){
        double lat2=Double.parseDouble(getSatelliteLatitude().get());
        double lon2=Double.parseDouble(getSatelliteLongitude().get());
        double alt2=Double.parseDouble(getSatelliteAltitude().get())*1e3;
        double lat=Double.parseDouble(getEarth1_lat().get());
        double lon=Double.parseDouble(getEarth1_lon().get());
        double alt=Double.parseDouble(getEarth1_alt().get());

        double[] arr1 = {0,0,0};
        double[] arr2 = {0,0,0};
        arr1=geodetic2ITRF( lat, lon, alt);
        arr2=geodetic2ITRF( lat2, lon2, alt2);


        double lat1rad=lat*Math.PI/180;
        double lon1rad=lon*Math.PI/180;
        double coslat=Math.cos(lat1rad);
        double sinlat=Math.sin(lat1rad);
        double coslon=Math.cos(lon1rad);
        double sinlon=Math.sin(lon1rad);
        double[][] R={
                {-sinlat*coslon,-sinlat*sinlon,coslat},
                {-sinlon,coslon,0},
                {-coslat*coslon,-coslat*sinlon,-sinlat}
        };
        double[] dianisma={arr2[0]-arr1[0],arr2[1]-arr1[1],arr2[2]-arr1[2]};
        double p1=(R[0][0]*dianisma[0]+R[0][1]*dianisma[1]+R[0][2]*dianisma[2]);
        double p2=(R[1][0]*dianisma[0]+R[1][1]*dianisma[1]+R[1][2]*dianisma[2]);
        double p3=(R[2][0]*dianisma[0]+R[2][1]*dianisma[1]+R[2][2]*dianisma[2]);
        double[] deltaNED={p1,p2,p3};
        double r=norm(deltaNED);
        double distance=r*1E-3;
        double elevation=Math.asin(-deltaNED[2]/r)*180/Math.PI;
        double [] disele={distance,elevation};
        //System.out.println(distance+" "+elevation);
        return disele;
    }
    public static double[] geodetic2ITRF(double lat, double lon,double alt){
        double x,y,z;
        double latRad= lat*Math.PI/180;
        double lonRad= lon*Math.PI/180;
        double eqtRadius=6378137;
        double e2=0.0066943799;
        double v=eqtRadius/Math.sqrt(1-e2*Math.pow(Math.sin(latRad),2));
        x=(v+alt)*Math.cos(latRad)*Math.cos(lonRad);
        y=(v+alt)*Math.cos(latRad)*Math.sin(lonRad);
        z=((1-e2)*v+alt)*Math.sin(latRad);
        double[]arr={x,y,z};
        //System.out.println(x);
        return arr;
    }
    public static double norm(double[] arr){
        double result=0;
        for(int i=0;i<arr.length;i++)
            result+=Math.pow(arr[i],2);
        result=Math.sqrt(result);
        return result;
    }

    public double txEIRP_up(){
        double PT1=Double.parseDouble(getSatr_txfeederloss_rec().get());
        double PT2=Double.parseDouble(getEarth1_othertxlosses().get());
        double PT3=Double.parseDouble(getEarth1_txhpapower().get());
        double PT4=Double.parseDouble(getEarth1_txhpaobo().get());
        double PT5=Double.parseDouble(getEarth1_txantennagain().get());
        double PL8=Double.parseDouble(getPropUp_radomeloss().get());

        return PT3-PT4-PT1-PT2+PT5-PL8;
    }

    public double txEIRP_down(){
        double PT1=Double.parseDouble(getSat_txfeederloss_tra().get());
        double PT2=Double.parseDouble(getSat_othertxloss_tra().get());
        double PT3=Double.parseDouble(getSat_hpspower_tra().get());
        double PT4=Double.parseDouble(getSat_hpaobo_tra().get());
        double PT5=Double.parseDouble(getSat_antennagain_tra().get());
        double PL8=Double.parseDouble(getPropDown_radomeloss().get());

        return PT3-PT4-PT1-PT2+PT5-PL8;
    }

    public double fspl_up(){
        double c=300000000;
        double frequency = Double.parseDouble(propUp_frequency.get())*1e9;
        double lambda= c/frequency;
        double[] dist=distance_up();
        double r=dist[0]*1E3;
        return (20*Math.log10((4*Math.PI*r)/lambda));
    }
    public double fspl_down(){
        double c=300000000;
        double frequency = Double.parseDouble(propDown_frequency.get())*1e9;
        double lambda= c/frequency;
        double[] dist=distance_up();
        double r=dist[0]*1E3;
        return (20*Math.log10((4*Math.PI*r)/lambda));
    }
    public double fspl_upFreq(double fre){
        double c=300000000;
        double frequency = fre*1e9;
        double lambda= c/frequency;
        double[] dist=distance_up();
        double r=dist[0]*1E3;
        return (20*Math.log10((4*Math.PI*r)/lambda));
    }
    public double fspl_downFreq(double fre){
        double c=300000000;
        double frequency = fre*1e9;
        double lambda= c/frequency;
        double[] dist=distance_up();
        double r=dist[0]*1E3;
        return (20*Math.log10((4*Math.PI*r)/lambda));
    }
    public double fspl(double dist){
        double c=300000000;
        double frequency = Double.parseDouble(propUp_frequency.get())*1e9;
        double lambda= c/frequency;
        double r= (dist*1E3);
        return (20*Math.log10((4*Math.PI*r)/lambda));
    }
    public double fspl2(double dist){
        double c=300000000;
        double frequency = Double.parseDouble(propDown_frequency.get())*1e9;
        double lambda= c/frequency;
        double r= (dist*1E3);
        return (20*Math.log10((4*Math.PI*r)/lambda));
    }

    public double polarizationLoss_up(){
        double polarMismatch = Double.parseDouble(propUp_polarmish.get());
        return 20*Math.abs(Math.log10(Math.cos(Math.toRadians(polarMismatch))));
    }

    public double polarizationLoss_down(){
        double polarMismatch = Double.parseDouble(propDown_polarmish.get());
        return 20*Math.abs(Math.log10(Math.cos(Math.toRadians(polarMismatch))));
    }
    public double rec_isotropic_power(){
        double PR1 = Double.parseDouble(getSat_intrloss_rec().get());
        double PL7 = Double.parseDouble(getPropUp_antennamispoint().get());
        double N3 = txEIRP_up();
        double N4 = polarizationLoss_up();
        double N5 = fspl_up();
        return N3-N4-N5-PR1-PL7;
    }
    public double rec_isotropic_powerdown(){
        double PR1 = Double.parseDouble(getEarth2_interloss().get());
        double PL7 = Double.parseDouble(getPropDown_antennamispoint().get());
        double N3 = txEIRP_down();
        double N4 = polarizationLoss_down();
        double N5 = fspl_down();
        return N3-N4-N5-PR1-PL7;
    }
    public double CbyNo(){
        double N6 = rec_isotropic_power();
        double PR2 = Double.parseDouble(getSat_rxgt_rec().get());
        double PR3 = Double.parseDouble(getSatr_txfeederloss_rec().get());
        double PR4 = Double.parseDouble(getSat_otherloss_rec().get());

        return N6 + PR2 - 10*Math.log10(BOLTZMANN_CONSTANT) - PR3 - PR4;
    }
    public double CbyNodown(){
        double N6 = rec_isotropic_powerdown();
        double PR2 = Double.parseDouble(getEarth2_irxgt().get());
        double PR3 = Double.parseDouble(getEarth2_rxfeederloss().get());
        double PR4 = Double.parseDouble(getEarth2_otherrxlosses().get());

        return N6 + PR2 - 10*Math.log10(BOLTZMANN_CONSTANT) - PR3 - PR4;
    }
    public double CbyN(){
        double N7 = CbyNo();
        double PL2 = Double.parseDouble(propUp_bandwith.get());

        return N7 - 10*Math.log10(PL2) - 60;
    }
    public double CbyNdown(){
        double N7 = CbyNodown();
        double PL2 = Double.parseDouble(propDown_bandwith.get());

        return N7 - 10*Math.log10(PL2) - 60;
    }
    public double Received_EbNo(){
        double N7 = CbyNo();
        double PL3 = Double.parseDouble(propUp_bitrate.get());

        return N7 - 10*Math.log10(PL3) - 60;
    }
    public double Received_EbNodown(){
        double N7 = CbyNodown();
        double PL3 = Double.parseDouble(propDown_bitrate.get());

        return N7 - 10*Math.log10(PL3) - 60;
    }

    public double margin(){
        double N9 = Received_EbNo();
        double PL4 = Double.parseDouble(propUp_requiredebno.get());
        double PL6 = Double.parseDouble(propUp_implemloss.get());

        return N9 - PL4 - PL6;
    }
    public double margindown(){
        double N9 = Received_EbNodown();
        double PL4 = Double.parseDouble(propDown_requiredebno.get());
        double PL6 = Double.parseDouble(propDown_implemloss.get());

        return N9 - PL4 - PL6;
    }

    public double marginCHART(double i){
        double N9 = Received_EbNodown();
        double PL4 = Double.parseDouble(propDown_requiredebno.get());
        double PL6 = i;

        return N9 - PL4 - PL6;
    }

    //For rain attenuation
    public double rainAtt_up(){
        double latitude =Double.parseDouble(getEarth1_lat().get());//in deg
        double longitude =Double.parseDouble(getEarth1_lon().get());;// in deg
        double altitude = Double.parseDouble(getEarth1_alt().get());//in m
        double[] elev=distance_up();
        double elevAngle=elev[1];
        double f = Double.parseDouble(propUp_frequency.get());//In GHz
        double Re = 8500;//In km
        double hs= altitude/1000;//in km
        double tau =Double.parseDouble(propUp_polarmish.get());;
        //double latitude = Math.toRadians(42.3), logitude=Math.toRadians(-71.35);// latitude and longitude in rad
        //step 1
        double h0 = h0Return(longitude,latitude);
        double hR = h0 + 0.36;// energo ypsos vroxis se km
        double Ap,Ls,Lg,R001,gammaR,r001,zeta,LR,x,v001,LE,A001,p=100 - Double.parseDouble(getAvailability_up().get()),beta;
        //step 2
        // upologismos tou mikous epiklinous diadromis
        if (hR - hs <= 0){
            Ap=0;
        } else{
            if(elevAngle >= 5 ){
                Ls = (hR - hs)/Math.sin(Math.toRadians(elevAngle));
            }else {
                Ls = (2*(hR - hs))/(Math.pow((Math.pow(Math.sin(Math.toRadians(elevAngle)),2))+(2*(hR - hs))/Re,1/2)+Math.sin(Math.toRadians(elevAngle)));
            }
            //step 3
            //Ypologismos tis orizontias provolis tou mikous epiklinous diadromis
            Lg = Ls * Math.cos(Math.toRadians(elevAngle));
            //step 4
            //calculation of R001
            R001 = Rreturn(longitude,latitude);
            //step 5
            //calculation of specific attenuation
            gammaR=gammaR(elevAngle,R001,f,tau);
            // step 6
            //Calculation of the horizontal reduction factor
            r001 = 1/(1 + 0.78*Math.sqrt(Lg*gammaR/f) - 0.38*(1 - Math.exp(-2*Lg)));
            //step 7
            // Ypologismos tou paragonta katakorifhs prosarmoghs gia to 0.01% toy xronou enos typikou etous
            zeta = Math.toDegrees(Math.atan((hR - hs)/(Lg*r001)));
            if (zeta > elevAngle){
                LR = (Lg*r001)/(Math.cos(Math.toRadians(elevAngle)));
            }else {
                LR = (Lg*r001)/(Math.sin(Math.toRadians(elevAngle)));
            }
            if(Math.abs(latitude) < 36){
                x = 36 - Math.abs(latitude);
            }else {
                x=0;
            }
            v001 = 1 / (1 + Math.sqrt(Math.sin(Math.toRadians(elevAngle)))* (31*(1 - Math.exp(-(elevAngle/(1+x))))*Math.sqrt(LR*gammaR) / Math.pow(f,2) - 0.45));
            //step 8
            // ypologismo gia to energo mukos diadromis
            LE = LR *v001;
            //step 9
            A001 = LE * gammaR;
            //step 10
            if (p>=1 || Math.abs(latitude)>=36){
                beta = 0;
            }else if (p<1 && Math.abs(latitude) <36 && elevAngle >=25){
                beta = -0.005*(Math.abs(latitude)-36);
            }else {
                beta = -0.005*(Math.abs(latitude)-36) + 1.8-4.25*Math.sin(Math.toRadians(elevAngle));
            }

            Ap = A001*Math.pow(p/0.01,-(0.655+0.033*Math.log(p)-0.045*Math.log(A001)-beta*(1-p)*Math.sin(Math.toRadians(elevAngle))));

        }
        return Ap;
    }
    public double rainAtt_down(){
        double latitude =Double.parseDouble(getEarth1_lat().get());//in deg
        double longitude =Double.parseDouble(getEarth1_lon().get());;// in deg
        double altitude =Double.parseDouble(getEarth1_alt().get());//in m
        double[] elev=distance_up();
        double elevAngle=elev[1];
        double f = Double.parseDouble(propDown_frequency.get());//In GHz
        double Re = 8500;//In km
        double hs= altitude/1000;//in km
        double tau =Double.parseDouble(propDown_polarmish.get());;
        //double latitude = Math.toRadians(42.3), logitude=Math.toRadians(-71.35);// latitude and longitude in rad
        //step 1
        double h0 = h0Return(longitude,latitude);
        double hR = h0 + 0.36;// energo ypsos vroxis se km
        double Ap,Ls,Lg,R001,gammaR,r001,zeta,LR,x,v001,LE,A001,p=100 - Double.parseDouble(getAvailability_down().get()),beta;
        //step 2
        // upologismos tou mikous epiklinous diadromis
        if (hR - hs <= 0){
            Ap=0;
        } else{
            if(elevAngle >= 5 ){
                Ls = (hR - hs)/Math.sin(Math.toRadians(elevAngle));
            }else {
                Ls = (2*(hR - hs))/(Math.pow((Math.pow(Math.sin(Math.toRadians(elevAngle)),2))+(2*(hR - hs))/Re,1/2)+Math.sin(Math.toRadians(elevAngle)));
            }
            //step 3
            //Ypologismos tis orizontias provolis tou mikous epiklinous diadromis
            Lg = Ls * Math.cos(Math.toRadians(elevAngle));
            //step 4
            //calculation of R001
            R001 = Rreturn(longitude,latitude);
            //step 5
            //calculation of specific attenuation
            gammaR=gammaR(elevAngle,R001,f,tau);
            // step 6
            //Calculation of the horizontal reduction factor
            r001 = 1/(1 + 0.78*Math.sqrt(Lg*gammaR/f) - 0.38*(1 - Math.exp(-2*Lg)));
            //step 7
            // Ypologismos tou paragonta katakorifhs prosarmoghs gia to 0.01% toy xronou enos typikou etous
            zeta = Math.toDegrees(Math.atan((hR - hs)/(Lg*r001)));
            if (zeta > elevAngle){
                LR = (Lg*r001)/(Math.cos(Math.toRadians(elevAngle)));
            }else {
                LR = (Lg*r001)/(Math.sin(Math.toRadians(elevAngle)));
            }
            if(Math.abs(latitude) < 36){
                x = 36 - Math.abs(latitude);
            }else {
                x=0;
            }
            v001 = 1 / (1 + Math.sqrt(Math.sin(Math.toRadians(elevAngle)))* (31*(1 - Math.exp(-(elevAngle/(1+x))))*Math.sqrt(LR*gammaR) / Math.pow(f,2) - 0.45));
            //step 8
            // ypologismo gia to energo mukos diadromis
            LE = LR *v001;
            //step 9
            A001 = LE * gammaR;
            //step 10
            if (p>=1 || Math.abs(latitude)>=36){
                beta = 0;
            }else if (p<1 && Math.abs(latitude) <36 && elevAngle >=25){
                beta = -0.005*(Math.abs(latitude)-36);
            }else {
                beta = -0.005*(Math.abs(latitude)-36) + 1.8-4.25*Math.sin(Math.toRadians(elevAngle));
            }

            Ap = A001*Math.pow(p/0.01,-(0.655+0.033*Math.log(p)-0.045*Math.log(A001)-beta*(1-p)*Math.sin(Math.toRadians(elevAngle))));

        }
        return Ap;
    }
    public static  double h0Return(double longitude,double latitude){
        double[][] longitudeData =readFile("Lon.txt");
        double[][] latitudeData =readFile("Lat.txt");
        double[][] h0Data =  readFile("h0.txt");
        double q11=0,q12 = 0,q21=0,q22=0,R1=0,R2=0,x2x=0,x1x=0,y1y=0,y2y=0,P=0;
        if(longitude<0){
            longitude = longitude + 360;
        }

        double[] posValueLon= findClosestValueLongitude(longitudeData, longitude, (byte) 1);
        double[] posValueLat = findClosestValueLatitude(latitudeData, 1, latitude);
        double valueLon=posValueLon[0];
        int posLon=(int)posValueLon[1]-1;
        //System.out.println(valueLon+" "+posLon);
        double valueLat=posValueLat[0];
        int posLat=(int)posValueLat[1];
        //System.out.println(valueLat+" "+posLat);
        if (valueLon==longitude && valueLat==latitude){
            return h0Data[posLat][posLon];
        }
        if (valueLon<longitude){
            q11 = h0Data[posLat][posLon];
            q21 = h0Data[posLat][posLon+1];
            x1x =Math.abs(valueLon - longitude);
            x2x =Math.abs(longitude -longitudeData[0][(int)posValueLon[1]+1]);
            R1 = q11*(x2x/1.5)+q21*(x1x/1.5);
            if (valueLat<latitude){
                q12 = h0Data[posLat-1][posLon];
                q22 = h0Data[posLat-1][posLon+1];
                y1y = Math.abs(valueLat - latitude);
                y2y = Math.abs(latitudeData[(int)posValueLat[1]-1][1]-latitude);
                R2 = q12*(x2x/1.5)+q22*(x1x/1.5);
                P = R1*(y2y/1.5)+R2*(y1y/1.5);
                //System.out.println(P);
            } else if (valueLat>latitude) {
                q12 = h0Data[posLat+1][posLon];
                q22 = h0Data[posLat+1][posLon+1];
                y1y = Math.abs(valueLat - latitude);
                y2y = Math.abs(latitudeData[(int)posValueLat[1]+1][1]-latitude);
                R2 = q12*(x2x/1.5)+q22*(x1x/1.5);
                P = R1*(y2y/1.5)+R2*(y1y/1.5);
            } else if (valueLat == latitude) {
                P=R1;
            }
        }
        if (valueLon>longitude){
            q11 = h0Data[posLat][posLon-1];
            q21 = h0Data[posLat][posLon];
            x2x =Math.abs(valueLon-longitude);
            x1x = Math.abs(longitude -longitudeData[0][(int)posValueLon[1]-1]);
            R1 = q11*(x2x/1.5)+q21*(x1x/1.5);
            if (valueLat<latitude){
                q12 = h0Data[posLat-1][posLon-1];
                q22 = h0Data[posLat-1][posLon];
                y1y = Math.abs(valueLat - latitude);
                y2y = Math.abs(latitudeData[(int)posValueLat[1]-1][1]-latitude);
                R2 = q12*(x2x/1.5)+q22*(x1x/1.5);
                P = R1*(y2y/1.5)+R2*(y1y/1.5);
            } else if (valueLat>latitude) {
                q12 = h0Data[posLat+1][posLon-1];
                q22 = h0Data[posLat+1][posLon];
                y1y = Math.abs(valueLat - latitude);
                y2y = Math.abs(latitudeData[(int)posValueLat[1]+1][1]-latitude);
                R2 = q12*(x2x/1.5)+q22*(x1x/1.5);
                P = R1*(y2y/1.5)+R2*(y1y/1.5);
            } else if (valueLat == latitude) {
                P=R1;
            }
        }

        if(valueLon == longitude && valueLat != latitude){
            q11=h0Data[posLat][posLon];
            if (valueLat < latitude) {
                q12 = h0Data[posLat - 1][posLon];
                y1y = Math.abs(valueLat - latitude);
                y2y = Math.abs(latitudeData[(int)posValueLat[1]-1][1]-latitude);
                P = q11*(y2y/1.5)+q12*(y1y/1.5);
            }else if (valueLat > latitude){
                q12 = h0Data[posLat + 1][posLon];
                y1y = Math.abs(valueLat - latitude);
                y2y = Math.abs(latitudeData[(int)posValueLat[1]+1][1]-latitude);
                P = q11*(y2y/1.5)+q12*(y1y/1.5);
            }
        }

        return P;
    }
    public static double[] findClosestNumberLonR001(double[][] matrix, double target) {
        double closest = Double.MAX_VALUE;
        int closestRow = -1;
        int closestColumn = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                double currentNumber = matrix[i][j];
                double difference = Math.abs(target - currentNumber);

                if (difference < Math.abs(target - closest)) {
                    closest = currentNumber;
                    closestRow = i;
                    closestColumn = j;
                }
            }
        }

        return new double[] {closest, closestColumn };
    }
    public static double[] findClosestValueLatitude(double[][] array, int columnIndex, double targetValue) {
        double closestValue = array[0][columnIndex];
        double closestPosition = 0;
        double minDifference = Math.abs(closestValue - targetValue);

        for (int row = 1; row < array.length; row++) {
            double currentValue = array[row][columnIndex];
            double difference = Math.abs(currentValue - targetValue);

            if (difference < minDifference) {
                minDifference = difference;
                closestValue = currentValue;
                closestPosition = row;
            }
        }

        return new double[]{closestValue, closestPosition};
    }
    public static double[] findClosestValueLongitude(double[][] array, double targetValue,byte x) {
        if (targetValue<0){
            targetValue+=360.0;
        }
        double[] firstRow = array[0];
        double closestValue = firstRow[0]; // Initialize to the first value
        int columnIndex = 0;
        if (x==1){
            columnIndex = 1;
        }
        else {
            columnIndex = 0;
        }
        double minDifference = Math.abs(closestValue - targetValue);

        for (int col = 1; col < firstRow.length; col++) {
            double currentValue = firstRow[col];
            double difference = Math.abs(currentValue - targetValue);

            if (difference < minDifference) {
                minDifference = difference;
                closestValue = currentValue;
                columnIndex = col;
            }
        }

        return new double[]{closestValue, columnIndex};
    }
    public static double[][] readFile(String filename) {

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            long numLines = br.lines().count();
            br.close();

            BufferedReader newBr = new BufferedReader(new FileReader(filename));

            // Read the first line to infer the number of columns
            String firstLine = newBr.readLine();
            String[] parts = firstLine.split("\\s+");
            int numCols = parts.length;

            // Reset the reader to the beginning of the file
            newBr.close();
            newBr = new BufferedReader(new FileReader(filename));

            double[][] dataArray = new double[(int) numLines][numCols];

            String line;
            int row = 0;
            while ((line = newBr.readLine()) != null) {
                parts = line.split("\\s+");
                if (parts.length >= numCols) {
                    for (int col = 0; col < numCols; col++) {
                        if (!parts[col].isEmpty()) {
                            dataArray[row][col] = Double.parseDouble(parts[col]);
                        }
                    }
                    row++;
                }
            }

            // Resize the array to remove unused rows (if any)
            double[][] trimmedArray = new double[row][numCols];
            System.arraycopy(dataArray, 0, trimmedArray, 0, row);

            return trimmedArray;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static  double Rreturn(double longitude,double latitude){
        double[][] LonR001 = readFile("LON_R001.TXT");
        double[][] LatR001 = readFile("Lat_R001.TXT");
        double[][] R001 = readFile("R001.TXT");
        double q11=0,q12 = 0,q21=0,q22=0,R1=0,R2=0,x2x=0,x1x=0,y1y=0,y2y=0,P=0;

        double[] posValueLon= findClosestNumberLonR001(LonR001,longitude);
        double[] posValueLat = findClosestValueLatitude(LatR001, 0, latitude);
        double valueLon=posValueLon[0];
        int posLon=(int)posValueLon[1];
        double valueLat=posValueLat[0];
        int posLat=(int)posValueLat[1];
        if (valueLon==longitude && valueLat==latitude){
            return R001[posLat][posLon];
        }
        if (valueLon<longitude){
            q11 = R001[posLat][posLon];
            q21 = R001[posLat][posLon+1];
            x1x =Math.abs(valueLon - longitude);
            x2x =Math.abs(longitude -LonR001[0][(int)posValueLon[1]+1]);
            R1 = q11*(x2x/0.125)+q21*(x1x/0.125);
            if (valueLat<latitude){
                q12 = R001[posLat+1][posLon];
                q22 = R001[posLat+1][posLon+1];
                y1y = Math.abs(valueLat - latitude);
                y2y = Math.abs(LatR001[(int)posValueLat[1]+1][1]-latitude);
                R2 = q12*(x2x/0.125)+q22*(x1x/0.125);
                P = R1*(y2y/0.125)+R2*(y1y/0.125);
            } else if (valueLat>latitude) {
                q12 = R001[posLat-1][posLon];
                q22 = R001[posLat-1][posLon-1];
                y1y = Math.abs(valueLat - latitude);
                y2y = Math.abs(LatR001[(int)posValueLat[1]-1][1]-latitude);
                R2 = q12*(x2x/0.125)+q22*(x1x/0.125);
                P = R1*(y2y/0.125)+R2*(y1y/0.125);
            } else if (valueLat == latitude) {
                P=R1;
            }
        }
        if (valueLon>longitude){
            q11 = R001[posLat][posLon-1];
            q21 = R001[posLat][posLon];
            x2x =Math.abs(valueLon-longitude);
            x1x = Math.abs(longitude -LonR001[0][(int)posValueLon[1]-1]);
            R1 = q11*(x2x/0.125)+q21*(x1x/0.125);
            if (valueLat<latitude){
                q12 = R001[posLat+1][posLon+1];
                q22 = R001[posLat+1][posLon];
                y1y = Math.abs(valueLat - latitude);
                y2y = Math.abs(LatR001[(int)posValueLat[1]+1][1]-latitude);
                R2 = q12*(x2x/0.125)+q22*(x1x/0.125);
                P = R1*(y2y/0.125)+R2*(y1y/0.125);
            } else if (valueLat>latitude) {
                q12 = R001[posLat-1][posLon+1];
                q22 = R001[posLat-1][posLon];
                y1y = Math.abs(valueLat - latitude);
                y2y = Math.abs(LatR001[(int)posValueLat[1]-1][1]-latitude);
                R2 = q12*(x2x/0.125)+q22*(x1x/0.125);
                P = R1*(y2y/0.125)+R2*(y1y/0.125);
            } else if (valueLat == latitude) {
                P=R1;
            }
        }

        if(valueLon == longitude && valueLat != latitude){
            q11=R001[posLat][posLon];
            if (valueLat < latitude) {
                q12 = R001[posLat + 1][posLon];
                y1y = Math.abs(valueLat - latitude);
                y2y = Math.abs(LatR001[(int)posValueLat[1]+1][1]-latitude);
                P = q11*(y2y/0.125)+q12*(y1y/0.125);
            }else if (valueLat > latitude){
                q12 = R001[posLat - 1][posLon];
                y1y = Math.abs(valueLat - latitude);
                y2y = Math.abs(LatR001[(int)posValueLat[1]-1][1]-latitude);
                P = q11*(y2y/0.125)+q12*(y1y/0.125);
            }
        }
        return P;
    }
    public static double gammaR(double theta,double Rp,double f,double tau){
        double[] a ={-5.33980, -0.35351, -0.23789, -0.94158};
        double[] b ={-0.10008,  1.26970,  0.86036,  0.64552};
        double[] c ={1.13098,  0.45400,  0.15354,  0.16817};
        double mk = -0.18961;
        double ck = 0.71147;
        double kH = a[0]*Math.exp(-Math.pow((Math.log10(f)-b[0])/c[0],2))+a[1]*Math.exp(-Math.pow((Math.log10(f)-b[1])/c[1],2))+a[2]*Math.exp(-Math.pow((Math.log10(f)-b[2])/c[2],2))+a[3]*Math.exp(-Math.pow((Math.log10(f)-b[3])/c[3],2))+mk*Math.log10(f)+ck;
        kH=Math.pow(10,kH);
        //System.out.println(kH);
        double[] a1={-3.80595, -3.44965, -0.39902, 0.50167};
        double[] b1={ 0.56934, -0.22911, 0.73042, 1.07319};
        double[] c1={0.81061, 0.51059, 0.11899, 0.27195};
        double mk1=-0.16398;
        double ck1=0.63297;
        double kV;
        kV=a1[0]*Math.exp(-Math.pow((Math.log10(f)-b1[0])/c1[0],2))+a1[1]*Math.exp(-Math.pow((Math.log10(f)-b1[1])/c1[1],2))+a1[2]*Math.exp(-Math.pow((Math.log10(f)-b1[2])/c1[2],2))+a1[3]*Math.exp(-Math.pow((Math.log10(f)-b1[3])/c1[3],2))+mk1*Math.log10(f)+ck1;
        kV=Math.pow(10,kV);
        //System.out.println(kV);
        double[] a2={-0.14318,0.29591,0.32177,-5.37610,16.1721};
        double[] b2={1.82442, 0.77564, 0.63773,-0.96230,-3.29980};
        double[] c2={-0.55187, 0.19822, 0.13164, 1.47828, 3.43990};
        double ma=0.67849;
        double ca= -1.95537;
        double aH;
        aH=a2[0]*Math.exp(-Math.pow((Math.log10(f)-b2[0])/c2[0],2))+a2[1]*Math.exp(-Math.pow((Math.log10(f)-b2[1])/c2[1],2))+a2[2]*Math.exp(-Math.pow((Math.log10(f)-b2[2])/c2[2],2))+a2[3]*Math.exp(-Math.pow((Math.log10(f)-b2[3])/c2[3],2))+a2[2]*Math.exp(-Math.pow((Math.log10(f)-b2[2])/c2[2],2))+a2[4]*Math.exp(-Math.pow((Math.log10(f)-b2[4])/c2[4],2))+ma*Math.log10(f)+ca;
        //System.out.println(aH);
        double[] a3={-0.07771,0.56727, -0.20238,-48.2991,48.5833};
        double[] b3={2.33840,0.95545,1.14520,0.791669,0.791459};
        double[] c3={-0.76284,0.54039,0.26809,0.116226,0.116479};
        double ma1=-0.053739;
        double ca1= 0.83433;
        double aV;
        aV=a3[0]*Math.exp(-Math.pow((Math.log10(f)-b3[0])/c3[0],2))+a3[1]*Math.exp(-Math.pow((Math.log10(f)-b3[1])/c3[1],2))+a3[2]*Math.exp(-Math.pow((Math.log10(f)-b3[2])/c3[2],2))+a3[3]*Math.exp(-Math.pow((Math.log10(f)-b3[3])/c3[3],2))+a3[4]*Math.exp(-Math.pow((Math.log10(f)-b3[4])/c3[4],2))+ma1*Math.log10(f)+ca1;
        //System.out.println(aV);
        //k = (kH + kV + (kH - kV).*((cosd(theta)).^2).*(cosd(2.*tau))) ./ 2;
        double k =(kH+kV+(kH-kV)*Math.pow(Math.cos(Math.toRadians(theta)), 2)*Math.cos(Math.toRadians(2*tau)))/2;
        //System.out.println(k);
        double aa=(kH*aH+kV*aV+(kH*aH-kV*aV)*Math.pow(Math.cos(Math.toRadians(theta)),2)*Math.cos(Math.toRadians(2*tau)))/(2*k);
        // System.out.println(aa);
        //double Rr=1;//edo theloume to R0.01
        double gamma_R=k*Math.pow(Rp,aa);
        //System.out.println(gamma_R);
        return  gamma_R;
    }


    public StringProperty getClientSelectedMenuItem() {
        return clientSelectedMenuItem;
    }

    public AnchorPane getDashboardView() {
        if (dashboardView == null){
            try {
                dashboardView = new  FXMLLoader(getClass().getResource("/Fxml/Client/Dashboard.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return dashboardView;
    }

    public AnchorPane getEarthStationView() {
        if (earthStationView == null){
            try {
                earthStationView = new  FXMLLoader(getClass().getResource("/Fxml/Client/EarthStation.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return earthStationView;
    }

    public AnchorPane getPropagationView() {
        if (propagationView == null){
            try {
                propagationView = new  FXMLLoader(getClass().getResource("/Fxml/Client/Propagations.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return propagationView;
    }

    public AnchorPane getSatelliteView() {
        if (satelliteView == null){
            try {
                satelliteView = new  FXMLLoader(getClass().getResource("/Fxml/Client/Satellite.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return satelliteView;
    }

    public void showClientWindow(){
        System.out.println("here");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/Client.fxml"));
        ClientController clientController = new ClientController();
        loader.setController(clientController);
        createStage(loader);
    }

    private void createStage(FXMLLoader loader){
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        }catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/satellite_btn.png"))));
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("SatelliteLinkBudgetAnalyzer");
        stage.show();
    }

    public void closeStage(Stage stage){
        stage.close();
    }
}
