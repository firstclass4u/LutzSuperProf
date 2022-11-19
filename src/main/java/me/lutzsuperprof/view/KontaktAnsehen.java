package me.lutzsuperprof.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import me.lutzsuperprof.model.Kontakt;

import java.net.URL;
import java.util.ResourceBundle;

public class KontaktAnsehen {

    private Kontakt kontakt;

    public KontaktAnsehen(Kontakt kontakt) {
        this.kontakt = kontakt;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<String> emailView;

    @FXML
    private TextField firstnameText;

    @FXML
    private ImageView image;

    @FXML
    private TextField lastnameText;

    @FXML
    private Button saveButton;

    @FXML
    void onSaveButtonClicked(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert emailView != null : "fx:id=\"emailView\" was not injected: check your FXML file 'KontaktAnsehen.fxml'.";
        assert firstnameText != null : "fx:id=\"firstnameText\" was not injected: check your FXML file 'KontaktAnsehen.fxml'.";
        assert image != null : "fx:id=\"image\" was not injected: check your FXML file 'KontaktAnsehen.fxml'.";
        assert lastnameText != null : "fx:id=\"lastnameText\" was not injected: check your FXML file 'KontaktAnsehen.fxml'.";
        assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'KontaktAnsehen.fxml'.";
        TableColumn<String, String> emailColumn = new TableColumn<>("Emails");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("Emails"));
        emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        emailColumn.setOnEditCommit(this::onEditCommit);
        emailView.getColumns().add(emailColumn);
        emailView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        firstnameText.setText(kontakt.getVorname());
        lastnameText.setText(kontakt.getName());
        updateTable();
    }

    private void onEditCommit(TableColumn.CellEditEvent<String, String> kontaktStringCellEditEvent) {
        //get email
        var email = kontaktStringCellEditEvent.getNewValue();
        if(kontakt.checkEmail(email)){
        kontakt.getEmails().set(kontaktStringCellEditEvent.getTablePosition().getRow(), kontaktStringCellEditEvent.getNewValue());
        updateTable();
    }else{
            //create alert
            var alert= new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fehler");
            alert.setHeaderText("Fehlerhafte Eingabe");
            alert.setContentText("Die Eingabe ist keine gültige Email");
            alert.showAndWait();
        }
    }

    public void updateTable() {
        emailView.getItems().clear();
        emailView.getItems().addAll(kontakt.getEmails());
    }

    public void showAndWait() {
        var fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/KontaktAnsehen.fxml"));
        fxmlLoader.setController(this);
        try {
            var stage = new Stage();
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
