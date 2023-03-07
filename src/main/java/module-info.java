module calc3docs.example.calc3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jetbrains.annotations;


    opens calc3docs.example.calc3 to javafx.fxml;
    exports calc3docs.example.calc3;
}