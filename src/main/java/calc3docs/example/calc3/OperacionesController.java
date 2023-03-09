package calc3docs.example.calc3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;



/*
Se crea la clase principal para el controlador y se utiliza el Initializable
*/
public class OperacionesController implements Initializable {
    /*
    Se llaman los nodos que están siendo utilizados en el documento fxml
     */

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
    // Se crea una variable contador y un array de tipo entero
    int contador = 0;
    int[] edades = new int[4];

    /*
     Se inicializa y se agregan los datos de las provincias al ComboBox respectivo
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Provincias.getItems().addAll("San Jose","Alajuela","Cartago","Heredia","Guanacaste","Puntarenas","Limon");

    }
    /*
    A continuación se ecuentran todos los métodos que implementan lógica para desarrollar la calculadora
     */
    @FXML
    /*
     Se hace el método para agregar personas
     */
    private void AgregarPersona(ActionEvent event){
        try{
            //Verifica la cantidad de personas que hay agregadas
            if (contador < 4) {
                // Se instancia un objeto de la clase Persona y se asignan sus datos de los text field
                Persona per = new Persona();
                String nombre = this.name.getText();
                String provincia = Provincias.getValue().toString();
                int edad = Integer.parseInt(this.age.getText());
                per.setNombre(nombre);
                per.setEdad(edad);
                per.setProvincia(provincia);
                //agrega un número a las personas según el índice en el que están a partir del #1
                if (contador>=1){
                    if(per.getNombre()==nombre){
                        per.setNombre(nombre +" #"+ contador+"");
                    }
                }
                    else {
                        per.setNombre(nombre);
                    }
                //Agrega las personas a la ComboBox y las edades al array
                per1.getItems().add(per.getNombre());
                per2.getItems().add(per.getNombre());
                edades[contador] = per.getEdad();
                contador++;



            } else {
                // Alerta de error
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Numero maximo de personas");
                alert.showAndWait();
            }
        }
        catch (NumberFormatException e) {
            //Alerta de error
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }


    }
    /*
    Se crea el método suma, el cual toma los valores de edad indicados e implementa el método suma de la clase operaciones
     */
    @FXML
    private void suma(ActionEvent event) {

        try {
            // Obtengo los parámetros
            int op1 = edades[per1.getItems().indexOf(per1.getValue())];
            int op2 = edades[per2.getItems().indexOf(per2.getValue())];

            // Creo una instancia de la clase Operaciones
            Operaciones o = new Operaciones(Math.abs(op1), Math.abs(op2));

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
    /*
    Se crea el método resta, el cual toma los valores de edad indicados e implementa el método resta de la clase operaciones
     */
    @FXML
    private void resta(ActionEvent event) {
        try {
            // Obtengo los parámetros
            int op1 = edades[per1.getItems().indexOf(per1.getValue())];
            int op2 = edades[per2.getItems().indexOf(per2.getValue())];

            // Creo una instancia de la clase Operaciones
            Operaciones o = new Operaciones(Math.abs(op1), Math.abs(op2));

            // Realizo la resta
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
    /*
    Se crea el método multiplicación, el cual toma los valores de edad indicados e implementa el método mult de la clase operaciones
     */
    @FXML
    private void multiplicacion(ActionEvent event) {
        try {
            // Obtengo los parámetros
            int op1 = edades[per1.getItems().indexOf(per1.getValue())];
            int op2 = edades[per2.getItems().indexOf(per2.getValue())];

            // Creo una instancia de la clase Operaciones
            Operaciones o = new Operaciones(Math.abs(op1), Math.abs(op2));

            // Realizo la multiplicación
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
    /*
     Se crea el método division, el cual toma los valores de edad indicados e implementa el método division de la clase operaciones
     */
    @FXML
    private void division(ActionEvent event) {
        try {
            // Obtengo los parámetros
            int op1 = edades[per1.getItems().indexOf(per1.getValue())];
            int op2 = edades[per2.getItems().indexOf(per2.getValue())];

            // Creo una instancia de la clase Operaciones
            Operaciones o = new Operaciones(Math.abs(op1), Math.abs(op2));

            // Realizo la division
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