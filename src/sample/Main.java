package sample;
/*
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
*/

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;


public class Main extends Application {
    private Scene scene;

    @Override
    public void start(Stage stage) {
        // create the scene
        stage.setTitle("Web View");
        GridPane grid=new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(5,5,5,5));
        scene=new Scene(grid,300,275);
        Button btn=new Button();
        TextField urlField=new TextField();
        grid.add(btn,9,0,1,1);
        grid.add(urlField,0,0,9,1);
        grid.add(new Browser(),0,1,10,10);
        //scene = new Scene(new Browser(), 750, 500, Color.web("#666970"));

        stage.setScene(scene);
        //scene.getStylesheets().add("webviewsample/BrowserToolbar.css");
        stage.setAlwaysOnTop(true);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Browser extends Region {

    final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();

    public Browser() {
        //apply the styles
        getStyleClass().add("browser");
        // load the web page
        webEngine.load("https://youtube.com");
        //add the web view to the scene
        getChildren().add(browser);

    }

    private Node createSpacer() {
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        return spacer;
    }

    @Override
    protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();
        layoutInArea(browser, 0, 0, w, h, 0, HPos.CENTER, VPos.CENTER);
    }

    @Override
    protected double computePrefWidth(double height) {
        return 750;
    }

    @Override
    protected double computePrefHeight(double width) {
        return 500;
    }
}