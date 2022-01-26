module ch.ictbz.dynamischverketteteliste.dynamischverketteteliste {
    requires javafx.controls;
    requires javafx.fxml;


    opens ch.ictbz.dynamischverketteteliste.dynamischverketteteliste to javafx.fxml;
    exports ch.ictbz.dynamischverketteteliste.dynamischverketteteliste;
}