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
        primaryStage.setTitle("SIE");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new javafx.scene.image.Image("https://im0-tub-ru.yandex.net/i?id=515c704a3876b3a520ec48782fbc1779-l&n=13"));
        primaryStage.show();


        Stage aboutStage = new Stage();
        Parent aboutLoader = FXMLLoader.load(getClass().getResource("about.fxml"));
        aboutStage.setTitle("О нас");
        aboutStage.setScene(new Scene(aboutLoader));
        aboutStage.setResizable(false);
        controller.aboutStage = aboutStage;


    }


    public static void main(String[] args) {
        launch(args);
    }
}
