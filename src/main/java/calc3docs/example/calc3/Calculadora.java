package calc3docs.example.calc3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;



//Se crea la clase main
public class Calculadora extends Application {
    // Se crea el start para el proyecto y se crea el Stage
    @Override
    public void start(Stage stage) throws IOException {
        // Se carga el archivo fmxl
        FXMLLoader fxmlLoader = new FXMLLoader(Calculadora.class.getResource("hello-view.fxml"));
        // Se carga el archivo anterior como scene
        Scene scene = new Scene(fxmlLoader.load(), 575, 410);
        // Se le asigna el titulo
        stage.setTitle("Calculator");
        // Se carga el scene
        stage.setScene(scene);
        stage.setMaxHeight(435);
        stage.setMaxWidth(575);
        // Se muestra el scene
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}