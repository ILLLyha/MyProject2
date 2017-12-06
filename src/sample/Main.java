package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        primaryStage.setTitle("PochtiPaint");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();

        Stage supportStage = new Stage();
        Parent supportLoader = FXMLLoader.load(getClass().getResource("support.fxml"));
        supportStage.setTitle("PochtiPaint");
        supportStage.setScene(new Scene(supportLoader));
        supportStage.setResizable(false);
        controller.supportStage = supportStage;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
