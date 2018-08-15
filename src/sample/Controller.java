package sample;


import javafx.
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.scene.Node;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.geometry.HPos;
import javafx.geometry.VPos;

public class Controller implements Initializable {
    @FXML
    private Button move;
    @FXML
    private TextField url;
    @FXML
    private Region web;
    @FXML
    private CheckBox check;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        web=new Browser();
        Browser b=(Browser)web;
        url.setText(b.webEngine.getLocation());
        move.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                b.move(url.getText());
            }
        });
        url.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER) {
                    b.move(url.getText());
                }
            }
        });
        web.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                url.setText(b.webEngine.getLocation());
            }
        });
        web.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                url.setText(b.webEngine.getLocation());
            }
        });
    }
}
