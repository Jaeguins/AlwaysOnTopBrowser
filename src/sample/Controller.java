package sample;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.stage.Stage;

public class Controller implements Initializable {
    @FXML
    private AnchorPane anchor;
    @FXML
    private Button move;
    @FXML
    private TextField url;
    @FXML
    private Browser web;
    @FXML
    private CheckBox check;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        web=new Browser();
        Browser b= web;
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
        check.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
                CheckBox chk = (CheckBox) event.getSource();
                System.out.println("Action performed on checkbox " + chk.getText());
                Stage w=(Stage)anchor.getScene().getWindow();
                if(chk.isSelected()){
                    w.setAlwaysOnTop(true);
                }else{
                    w.setAlwaysOnTop(false);
                }
            }
        });
    }
}
