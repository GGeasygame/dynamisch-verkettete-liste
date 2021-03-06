package ch.ictbz.dynamischverketteteliste.dynamischverketteteliste;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Dynamisch verkettete Liste");
        stage.setScene(scene);
        stage.show();
        Controller controller = fxmlLoader.getController();
        controller.initiate();
    }

    public static void main(String[] args) {
        launch();
    }
}