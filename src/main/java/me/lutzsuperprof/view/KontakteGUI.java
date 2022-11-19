package me.lutzsuperprof.view;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import me.lutzsuperprof.model.Kontakt;

import java.net.URL;
import java.util.ResourceBundle;

public class KontakteGUI extends Application {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TableColumn<Kontakt, String> firstnameColumn;

    @FXML
    private TableColumn<Kontakt, String> lastnameColumn;
    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;
    @FXML
    private Button viewButton;

    @FXML
    private Button endButton;

    @FXML
    private TableView<Kontakt> tableView;

    @FXML
    void onAddButtonClicked(ActionEvent event) {

    }

    @FXML
    void onDeleteButtonClicked(ActionEvent event) {
        //delete current selection out of Kontakt.getKontakte()

        var selection = tableView.getSelectionModel().getSelectedItem();
        Kontakt.getKontakte().remove(selection);
        updateTable();
    }

    @FXML
    void onEndButtonClicked(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void onViewButtonClicked(ActionEvent event) {
        var selection = tableView.getSelectionModel().getSelectedItem();
        if (selection != null) {
            KontaktAnsehen kontaktAnsehen = new KontaktAnsehen(selection);
            kontaktAnsehen.showAndWait();
        }
    }

    @FXML
    void initialize() {
        assert addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file 'Kontakte.fxml'.";
        assert deleteButton != null : "fx:id=\"deleteButton\" was not injected: check your FXML file 'Kontakte.fxml'.";
        assert endButton != null : "fx:id=\"endButton\" was not injected: check your FXML file 'Kontakte.fxml'.";
        assert firstnameColumn != null : "fx:id=\"firstnameColumn\" was not injected: check your FXML file 'Kontakte.fxml'.";
        assert lastnameColumn != null : "fx:id=\"lastnameColumn\" was not injected: check your FXML file 'Kontakte.fxml'.";
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'Kontakte.fxml'.";

        firstnameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getVorname()));
        lastnameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));
        updateTable();
    }

    public static void start() {
        launch();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        //Ich habe eine Datei, die möchte ich gerne anzeigen lassen
        var loader = new FXMLLoader(getClass().getResource("/fxml/Kontakte.fxml"));
        loader.setController(this);
        Parent root = loader.load();
        //setze den Controller für die FXML Datei auf diese Klasse in java
        //Setze ein Titel für die Grafik und setze was angezeigt werden soll
        primaryStage.setTitle("Kontakte");
        var scene = new Scene(root);
        //make scene not resizable
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void updateTable() {
        tableView.getItems().clear();
        tableView.getItems().addAll(Kontakt.getKontakte());
    }
}
