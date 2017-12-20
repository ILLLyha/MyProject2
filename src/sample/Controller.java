package sample;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sun.java2d.loops.DrawParallelogram;
import sun.java2d.pipe.DrawImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.WIWDW.*;


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

    @FXML
    private TextField figutHeight;

    @FXML
    private TextField figutWeight;


    // For onSaveAs
    private final FileChooser fileChooser = new FileChooser();

    // For onOpen
    private final FileChooser openFileChooser = new FileChooser();

    // For setBrushBrush and setBrushPencil
    private boolean isBrushBrush;


    private Dimension screenSize;

    public void initialize() {

    }

    public void setBrushBrush() {
        isBrushBrush = true;
        brushSelectButton.setText("Кисть");
    }

    public void setBrushPencil() {
        isBrushBrush = false;
        brushSelectButton.setText("Карандаш");
    }


    public void onClear() {
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.clearRect(0, 0, 10000, 10000);

    }


    public Stage supportStage;

    public void onSup(ActionEvent actionEvent) throws IOException {

        supportStage.show();


    }

    public Stage aboutStage;

    public void onAb(ActionEvent actionEvent) throws IOException {
        aboutStage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setBrushBrush();

        Dimension screenSize = getScreenSize();
        double screenWidth = screenSize.getWidth();
        double screenHeight = screenSize.getHeight();
        canvas.setHeight(screenHeight / 1.5);
        canvas.setWidth(screenWidth / 1.5);

       canvas.setStyle("-fx-background-color: rgba(255, 255, 255, 1);");

        GraphicsContext g = canvas.getGraphicsContext2D();
        canvas.setOnMouseDragged(e -> { MouseDragged(e);});
        canvas.setOnMouseClicked(e -> MouseClicked(e));
        canvas.setOnMouseClicked(e -> OnCircle(e));

    }





    public void onSave(ActionEvent actionEvent) {
        try {

            Image snapshot = canvas.snapshot(null, null);
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", new File("paint.png"));


        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);

        }
    }

    public void onSaveAs(ActionEvent actionEvent) {
        Stage stage = new Stage(StageStyle.UTILITY);
        fileChooser.setTitle("Сохранить картинку как...");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PNG files", "*.png");
        fileChooser.getExtensionFilters().add(extFilter);
        try {

            Image snapshot = canvas.snapshot(null, null);
            File file = fileChooser.showSaveDialog(stage);
            String filepath = file.getAbsolutePath();


            if (file != null) {
                ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", file);

            } else {

            }
        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);

        }
    }

    public void onOpen(ActionEvent actionEvent) {
        GraphicsContext g = canvas.getGraphicsContext2D();

        Stage stage = new Stage(StageStyle.UTILITY);
        openFileChooser.setTitle("Открыть картинку");

        FileChooser.ExtensionFilter pngFilter = new FileChooser.ExtensionFilter("PNG files", "*.png");
        openFileChooser.getExtensionFilters().add(pngFilter);


        FileChooser.ExtensionFilter jpegFilter = new FileChooser.ExtensionFilter("JPG files", "*.jpeg, *.jpg");
        openFileChooser.getExtensionFilters().add(jpegFilter);
        try {
            File openImageFile = openFileChooser.showOpenDialog(stage);
            InputStream fileStream = new FileInputStream(openImageFile);
            javafx.scene.image.Image openImage = new Image(fileStream);
            String filepath = openImageFile.getAbsolutePath();

            if (openImageFile != null) {
                g.drawImage(openImage, 0, 0);

            } else {

            }
        } catch (Exception e) {

        }
    }

    public void onExit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void MouseClicked(MouseEvent e) {
        double size = Double.parseDouble(brushSize.getText());
        double x = e.getX() - size / 2;
        double y = e.getY() - size / 2;

        GraphicsContext g = canvas.getGraphicsContext2D();

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
    }

    public void MouseDragged(MouseEvent e) {
        double size = Double.parseDouble(brushSize.getText());
        double x = e.getX() - size / 2;
        double y = e.getY() - size / 2;

        GraphicsContext g = canvas.getGraphicsContext2D();

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
    }

 /*   public void Figures(MouseEvent e){

    }*/

    public void OnCircle(MouseEvent e) {
        GraphicsContext context = canvas.getGraphicsContext2D();
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(colorPicker.getValue());
        // context.setFill(Color.BLUE);
        double figHg = Double.parseDouble(figutHeight.getText());
        double figWg = Double.parseDouble(figutWeight.getText());
        double x = e.getX() - figWg / 2;
        double y = e.getY() - figHg / 2;
        context.fillOval(x, y, figWg, figHg);
    }

}