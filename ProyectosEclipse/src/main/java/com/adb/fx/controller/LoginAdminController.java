package com.adb.fx.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

public class LoginAdminController {

    @FXML private TextField txtUsuarioAdmin;
    @FXML private PasswordField txtPasswordAdmin;
    @FXML private CheckBox chkRecordarAdmin;

    /**
     * Inicia sesión como administrador
     */
    @FXML
    private void iniciarSesionAdmin() {
        String correo = txtUsuarioAdmin.getText().trim();
        String contrasena = txtPasswordAdmin.getText().trim();

        // Validación de campos
        if (correo.isEmpty() || contrasena.isEmpty()) {
            mostrarAlerta("Por favor completa todos los campos", Alert.AlertType.WARNING);
            return;
        }


        try {
            // Endpoint de login (ajustar según tu backend)
            String urlString = "http://localhost:8083/usuarios/login";
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            // JSON con credenciales
            JSONObject json = new JSONObject();
            json.put("correo", correo);
            json.put("contrasena", contrasena);

            // Enviar petición
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = json.toString().getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == 200) {
                // Login exitoso
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8)
                );
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();

                JSONObject adminData = new JSONObject(response.toString());
                
                // Verificar que es admin
                String rol = adminData.optString("rol", "");
                if (!rol.contains("Administrador")) {
                    mostrarAlerta("❌ Acceso Denegado\n\nEste usuario no tiene privilegios administrativos", 
                                 Alert.AlertType.ERROR);
                    return;
                }

                System.out.println("✅ Admin autenticado: " + adminData.toString());

                // Redirigir al panel de admin
                irAPanelAdmin(adminData);

            } else {
                // Error de autenticación
                BufferedReader errorReader = new BufferedReader(
                    new InputStreamReader(con.getErrorStream(), StandardCharsets.UTF_8)
                );
                StringBuilder errorMsg = new StringBuilder();
                String errorLine;
                while ((errorLine = errorReader.readLine()) != null) {
                    errorMsg.append(errorLine);
                }
                errorReader.close();

                mostrarAlerta("❌ Credenciales Incorrectas\n\n" + 
                            "Usuario o contraseña no válidos.\n" +
                            "Verifica tus datos e intenta nuevamente.", 
                            Alert.AlertType.ERROR);
            }

        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error de conexión: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    /**
     * Redirige al panel administrativo
     */
    private void irAPanelAdmin(JSONObject adminData) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/PerfilAdmin.fxml"));
            Parent root = loader.load();

            PerfilAdminController controller = loader.getController();
            controller.setAdminData(adminData);

            Stage stage = (Stage) txtUsuarioAdmin.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Nexus Deportivo - Panel Administrativo");
            stage.setMaximized(true);
            stage.show();

            mostrarAlerta("✅ Bienvenido, Administrador\n\nAcceso concedido al panel de control", 
                         Alert.AlertType.INFORMATION);

        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error al cargar el panel: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    /**
     * Vuelve al login regular
     */
    @FXML
    private void volverALogin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login.fxml"));
            Parent root = loader.load();
            
            Stage stage = (Stage) txtUsuarioAdmin.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Nexus Deportivo - Iniciar Sesión");
            stage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra alertas
     */
    private void mostrarAlerta(String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(tipo == Alert.AlertType.ERROR ? "Error" : 
                      tipo == Alert.AlertType.WARNING ? "Advertencia" : "Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}