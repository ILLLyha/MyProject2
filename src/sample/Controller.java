package sample;

import com.sun.org.apache.bcel.internal.generic.GOTO;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sun.security.action.OpenFileInputStreamAction;

import javax.swing.event.TreeModelEvent;
import java.io.IOException;
import java.util.Set;

public class Controller {


    public void onExit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void onSup(ActionEvent actionEvent) {
        System.out.println("Должно открыться новое окно");



        }}
