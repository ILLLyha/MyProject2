package sample;

import com.sun.org.apache.bcel.internal.generic.GOTO;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sun.security.action.OpenFileInputStreamAction;

import javax.swing.event.TreeModelEvent;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import static sample.WIWNW.getScreenSize;

public class Controller implements Initializable {


@FXML
private Canvas canvas;

@FXML
private ColorPicker colorPicker;

@FXML
private TextField brushSize;

@FXML
private CheckBox eraser;

@FXML
private MenuButton brushSelectButton;

// For onSaveAs
private final FileChooser fileChooser = new FileChooser();

// For onOpen
private final FileChooser openFileChooser = new FileChooser();

// For setBrushBrush and setBrushPencil
private boolean isBrushBrush;
private Dimension screenSize;



    //private Controller children;
    //private Controller parent;

    public void initialize() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        setBrushBrush();

        Dimension screenSize = getScreenSize();
        double screenWidth = screenSize.getWidth();
        double screenHeight = screenSize.getHeight();
        canvas.setHeight(screenHeight / 1.5);
        canvas.setWidth(screenWidth / 1.5);

        canvas.setStyle("-fx-background-color: rgba(255, 255, 255, 1);");

        canvas.setOnMouseDragged(e -> {
            double size = Double.parseDouble(brushSize.getText());
            double x = e.getX() - size / 2;
            double y = e.getY() - size / 2;

            if (eraser.isSelected()) {
                g.clearRect(x, y, size, size);
            } else {

                g.setFill(colorPicker.getValue());
                if (isBrushBrush) {
                    g.fillOval(x, y, size, size);
                } else {
                    g.fillRect(x, y, size, size);
                }
            }
        });

        canvas.setOnMouseClicked(e -> {
            double size = Double.parseDouble(brushSize.getText());
            double x = e.getX() - size / 2;
            double y = e.getY() - size / 2;

            if (eraser.isSelected()) {
                g.clearRect(x, y, size, size);
            } else {
                g.setFill(colorPicker.getValue());
                if (isBrushBrush) {
                    g.fillOval(x, y, size, size);
                } else {
                    g.fillRect(x, y, size, size);
                }
            }
        });
    }

    public void setBrushBrush(){
        isBrushBrush  = true;
        brushSelectButton.setText("Кисть");
    }



    public void setBrushPencil(){
        isBrushBrush  = false;
        brushSelectButton.setText("Карандаш");
    }



    public void onClear() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.clearRect(0, 0, 10000, 10000);

    }


    public void onExit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public Stage supportStage;

    public void onSup(ActionEvent actionEvent) throws IOException {

        supportStage.show();

       // System.out.println("Должно открыться новое окно");



        }

    public Stage aboutStage;

    public void onAb(ActionEvent actionEvent) throws IOException {
        aboutStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void OnDr(MouseEvent mouseEvent) {
        Canvas.setOnMouseDragged((MouseDragEvent) -> {
            if(rootLayoutEventController.pencil){
                gc.lineTo(MouseDragEvent.getX(), MouseDragEvent.getY());

                gc.stroke();
                gc.moveTo(MouseDragEvent.getX(), MouseDragEvent.getY());
            }
        });
    }
}
