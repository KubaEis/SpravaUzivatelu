package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

public class HelloController {
    @FXML
    private TextField nameField, nicknameField, phoneField;
    @FXML
    private ListView<User> listViewUsers;
    @FXML
    private Button addContactButton, deleteButton, updateButton;
    @FXML
    private MenuItem oAplikaciMenuItem, napovedaMenuItem;
    @FXML
    private final ObservableList<User> listUsers = FXCollections.observableArrayList();

    @FXML
    protected void initialize() {
        listUsers.add(new User("Jan Novak","Honzi","888999111"));
        listUsers.add(new User("Ondra Musil","Kokot","123456789"));
        listViewUsers.setItems(listUsers);
    }

    @FXML
    protected void onAddContactButtonClick() {
        if (!nameField.getText().isEmpty() && !nicknameField.getText().isEmpty() && !phoneField.getText().isEmpty()) {
            listUsers.add(new User(nameField.getText(),nicknameField.getText(),phoneField.getText()));
            listViewUsers.setItems(listUsers);
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Informace");
            alert.setHeaderText("Dulezite upozorneni");
            alert.setContentText("Pro pridani kontaktu je nutne vyplnit vsechna pole.");
            alert.showAndWait();
        }
    }

    @FXML
    protected void onDeleteButtonClick() {
        User user = listViewUsers.getSelectionModel().getSelectedItem();
        if (user != null) {
            listViewUsers.getItems().remove(user);
        }
    }

    @FXML
    protected void onUpdateButtonClick() {
        User user = listViewUsers.getSelectionModel().getSelectedItem();
        if (user != null) {
            if (!nameField.getText().isEmpty() && !nicknameField.getText().isEmpty() && !phoneField.getText().isEmpty()) {
                user.setName(nameField.getText());
                user.setNickname(nicknameField.getText());
                user.setPhone(phoneField.getText());
                nameField.clear();
                nicknameField.clear();
                phoneField.clear();
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Informace");
                alert.setHeaderText("Dulezite upozorneni");
                alert.setContentText("Pro uprave kontaktu je nutne vyplnit vsechna pole.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    protected void onOAplikaciMenuButtonClick() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("O aplikaci");
        alert.setHeaderText("Informace o aplikaci");
        alert.setContentText("Aplikace pro spravu uzivatelu");
        alert.showAndWait();
    }

    @FXML
    protected void onNapovedaMenuButtonClick() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Napoveda");
        alert.setHeaderText("Napoveda pro spravu uzivatelu");
        alert.setContentText("Pridej a spravuj uzivatele");
        alert.showAndWait();
    }

    @FXML
    protected void onZavritMenuButtonClick() {
        System.exit(0);
    }
}
