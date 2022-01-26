package ch.ictbz.dynamischverketteteliste.dynamischverketteteliste;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

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
}