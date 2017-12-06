package sample;

import com.sun.org.apache.bcel.internal.generic.GOTO;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sun.security.action.OpenFileInputStreamAction;

import javax.swing.event.TreeModelEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

public class Controller implements Initializable {

    //private Controller children;
    //private Controller parent;


    public void onExit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public Stage supportStage;

    public void onSup(ActionEvent actionEvent) throws IOException {


        //FXMLLoader loader = new FXMLLoader();
        //loader.load(getClass().getResource("support.fxml"));
/*        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("support.fxml"));
        stage.setTitle("PochtiPaint");
        stage.setScene(new Scene(root));
        stage.setResizable(false);*/
        supportStage.show();

       // System.out.println("Должно открыться новое окно");



        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
