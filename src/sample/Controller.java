package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    @FXML private RadioButton radioAdd = new RadioButton();
    @FXML private RadioButton radioSub;
    @FXML private RadioButton radioMult;
    @FXML private RadioButton radioDiv;
    @FXML private Label result;
    @FXML private TextField firstNum;
    @FXML private TextField secondNum;
    private String operation;

    ToggleGroup toggleGroup;

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        toggleGroup = new ToggleGroup();
        radioAdd.setToggleGroup(toggleGroup);
        radioSub.setToggleGroup(toggleGroup);
        radioMult.setToggleGroup(toggleGroup);
        radioDiv.setToggleGroup(toggleGroup);
        radioAdd.setSelected(true);
        operation = radioAdd.getText();
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (toggleGroup.getSelectedToggle() != null) {
                operation = ((RadioButton)newValue.getToggleGroup().getSelectedToggle()).getText();
            }
        });
        firstNum.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    firstNum.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        secondNum.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    secondNum.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

    }
    @FXML
    private void onCalculateBtnClick() {
        if(firstNum.getText() != null || secondNum.getText() != null) {
            Double firstVal = Double.parseDouble(firstNum.getText());
            Double secondVal = Double.parseDouble(secondNum.getText());

            if (operation.equals(radioAdd.getText())) {
                result.setText((firstVal + secondVal) + "");
            } else if (operation.equals(radioSub.getText())) {
                result.setText((firstVal - secondVal) + "");
            } else if (operation.equals(radioMult.getText())) {
                result.setText((firstVal * secondVal) + "");
            } else if (operation.equals(radioDiv.getText())) {
                result.setText((firstVal / secondVal) + "");
            }
        }
    }

}
