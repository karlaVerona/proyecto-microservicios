package com.adb.fx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.net.http.*;
import java.net.URI;

public class RegistroController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblMensaje;

    @FXML
    private void registrar() {
        try {
            String json = String.format("{\"nombre\":\"%s\",\"username\":\"%s\",\"password\":\"%s\"}",
                    txtNombre.getText(), txtUsuario.getText(), txtPassword.getText());

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8081/usuarios"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 201) {
                lblMensaje.setText("Usuario registrado correctamente. Ahora inicia sesión.");
            } else {
                lblMensaje.setText("Error al registrar el usuario.");
            }
        } catch (Exception e) {
            lblMensaje.setText("Error de conexión con el servidor.");
            e.printStackTrace();
        }
    }

    @FXML
    private void irALogin() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Login.fxml"));
            Stage stage = (Stage) txtNombre.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Iniciar Sesión");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
