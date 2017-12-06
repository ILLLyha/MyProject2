package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;

public class Support {
    public void onClose(ActionEvent actionEvent) {
        Platform.exit();
    }


    public void onSend(ActionEvent actionEvent) {
        //создаем новое окно, отправляем текст
    }
}
