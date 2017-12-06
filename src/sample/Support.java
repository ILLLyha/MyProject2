package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Support {
    public void onClose(ActionEvent actionEvent) {
        Platform.exit();
    }


    public void onSend(ActionEvent actionEvent) {
        //создаем новое окно, отправляем текст
    }
}
