package calc3docs.example.calc3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import calc3docs.example.calc3.Operaciones;
import calc3docs.example.calc3.Persona;


public class OperacionesController implements Initializable {

//public class HelloController {
    @FXML
    private Button plsbtn;
    @FXML
    private Button addbtn;
    @FXML
    private Button lessbtn;
    @FXML
    private Button divbtn;
    @FXML
    private Button perbtn;
    @FXML
    ComboBox per1;
    @FXML
    ComboBox per2;
    @FXML
    ComboBox Provincias;
    @FXML
    TextField name;
    @FXML
    TextField age;
    @FXML
    TextField result;
    int contador = 0;
    int[] edades = new int[4];

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Provincias.getItems().addAll("San Jose","Alajuela","Cartago","Heredia","Guanacaste","Puntarenas","Limon");
    }
    @FXML
    private void AgregarPersona(ActionEvent event){
        try{
            if (contador < 4) {
                Persona per = new Persona();
                String nombre = this.name.getText();
                String provincia = Provincias.getValue().toString();
                int edad = Integer.parseInt(this.age.getText());
                per.setNombre(nombre);
                per.setEdad(edad);
                per.setProvincia(provincia);
                if (contador>=1){
                    if(per.getNombre()==nombre){
                        per.setNombre(nombre +" #"+ contador+"");
                    }
                }
                    else {
                        per.setNombre(nombre);
                    }

                per1.getItems().add(per.getNombre());
                per2.getItems().add(per.getNombre());
                edades[contador] = per.getEdad();
                contador++;



            } else {
                // Alerta de error
                Alert alert = new Alert(Alert.AlertType.ERROR);
                //alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Numero maximo de personas");
                alert.showAndWait();
            }
        }
        catch (NumberFormatException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }

    }
    @FXML
    private void suma(ActionEvent event) {

        try {
            // Obtengo los parametros
            int op1 = edades[per1.getItems().indexOf(per1.getValue())];
            int op2 = edades[per2.getItems().indexOf(per2.getValue())];

            // Creo una instancia del modelo
            Operaciones o = new Operaciones(op1, op2);

            // Realizo la suma
            int resultado = o.suma();

            // Muestro el resultado
            this.result.setText(resultado + "");

        }
        catch (NumberFormatException e) {
            // Alerta de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }

    }
    @FXML
    private void resta(ActionEvent event) {
        try {
            // Obtengo los parametros
            int op1 = edades[per1.getItems().indexOf(per1.getValue())];
            int op2 = edades[per2.getItems().indexOf(per2.getValue())];
            System.out.println(op1);
            System.out.println(op2);

            // Creo una instancia del modelo
            Operaciones o = new Operaciones(op1, op2);

            // Realizo la suma
            int resultado = o.resta();

            // Muestro el resultado
            this.result.setText(resultado + "");

        }
        catch (NumberFormatException e) {
            // Alerta de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }
    }
    @FXML
    private void multiplicacion(ActionEvent event) {
        try {
            // Obtengo los parametros
            int op1 = edades[per1.getItems().indexOf(per1.getValue())];
            int op2 = edades[per2.getItems().indexOf(per2.getValue())];
            System.out.println(op1);
            System.out.println(op2);

            // Creo una instancia del modelo
            Operaciones o = new Operaciones(op1, op2);

            // Realizo la suma
            int resultado = o.mult();

            // Muestro el resultado
            this.result.setText(resultado + "");

        }
        catch (NumberFormatException e) {
            // Alerta de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }
    }
    @FXML
    private void division(ActionEvent event) {
        try {
            // Obtengo los parametros
            int op1 = edades[per1.getItems().indexOf(per1.getValue())];
            int op2 = edades[per2.getItems().indexOf(per2.getValue())];
            System.out.println(op1);
            System.out.println(op2);

            // Creo una instancia del modelo
            Operaciones o = new Operaciones(op1, op2);

            // Realizo la suma
            double resultado = o.division();
            if (op2 == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("El operando 2 no puede ser 0");
                alert.showAndWait();
            } else {
                // Muestro el resultado
                this.result.setText(resultado + "");
            }


        } catch (NumberFormatException e) {
            // Alerta de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }
    }

}