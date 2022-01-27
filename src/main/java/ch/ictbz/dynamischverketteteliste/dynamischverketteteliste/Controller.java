package ch.ictbz.dynamischverketteteliste.dynamischverketteteliste;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    @FXML
    private TextField numberTextField;
    @FXML
    private RadioButton ascendingRadio;
    @FXML
    private RadioButton descendingRadio;
    @FXML
    private TextField outputTextField;

    private Zahlenspeicher zahlenspeicher;
    public void initiate() {
        zahlenspeicher = new Zahlenspeicher();
    }

    public void onButtonAdd() {
        zahlenspeicher.add(Integer.parseInt(numberTextField.getText()));
    }

    public void onButtonGet() {
        String output = "";
        if (ascendingRadio.isSelected())
            output = zahlenspeicher.get(SortOrder.ASCENDING);
        else if (descendingRadio.isSelected())
            output = zahlenspeicher.get(SortOrder.DESCENDING);
        outputTextField.setText(output);
    }

    public void onButtonClear() {
        zahlenspeicher.clear();
        outputTextField.setText("");
    }

    public void onButtonContains() {
        String inputNumber = numberTextField.getText();
        boolean containsNumber = zahlenspeicher.contains(Integer.parseInt(numberTextField.getText()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Contains");
        alert.setHeaderText(String.valueOf(containsNumber));
        String contentText = containsNumber ? "Die Zahl " + inputNumber + " ist enthalten." : "Die Zahl " + inputNumber + " ist nicht enthalten";
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}