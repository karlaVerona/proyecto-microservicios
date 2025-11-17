package com.adb.fx.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

import org.json.JSONObject;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

public class PerfilAdminController {

    // ========== NAVBAR ==========
    @FXML private Label lblNombreAdmin;

    // ========== ESTADÍSTICAS ==========
    @FXML private Label lblTotalUsuarios;
    @FXML private Label lblTotalTorneos;
    @FXML private Label lblPartidosHoy;
    @FXML private Label lblSolicitudesPendientes;

    // ========== TABS ==========
    @FXML private Button btnTabUsuarios;
    @FXML private Button btnTabTorneos;
    @FXML private Button btnTabPartidos;
    @FXML private Button btnTabSolicitudes;
    @FXML private Button btnTabInscripciones;
    @FXML private Button btnTabReglas;
    @FXML private Button btnTabEquipos;

    // ========== SECCIONES ==========
    @FXML private VBox seccionUsuarios;
    @FXML private VBox seccionTorneos;
    @FXML private VBox seccionPartidos;
    @FXML private VBox seccionSolicitudes;
    @FXML private VBox seccionInscripciones;
    @FXML private VBox seccionReglas;
    @FXML private VBox seccionEquipos;

    // ========== USUARIOS ==========
    @FXML private TextField txtBuscarUsuario;
    @FXML private TableView<Usuario> tablaUsuarios;
    @FXML private TableColumn<Usuario, Integer> colUsuarioId;
    @FXML private TableColumn<Usuario, String> colUsuarioNombre;
    @FXML private TableColumn<Usuario, String> colUsuarioCorreo;
    @FXML private TableColumn<Usuario, String> colUsuarioRFC;
    @FXML private TableColumn<Usuario, String> colUsuarioRol;
    @FXML private TableColumn<Usuario, String> colUsuarioDeporte;
    @FXML private TableColumn<Usuario, String> colUsuarioFecha;
    @FXML private TableColumn<Usuario, Void> colUsuarioAcciones;

    // ========== TORNEOS ==========
    @FXML private ComboBox<String> cmbFiltroDeporteTorneo;
    @FXML private TableView<Torneo> tablaTorneos;
    @FXML private TableColumn<Torneo, Integer> colTorneoId;
    @FXML private TableColumn<Torneo, String> colTorneoNombre;
    @FXML private TableColumn<Torneo, String> colTorneoDeporte;
    @FXML private TableColumn<Torneo, String> colTorneoFechaInicio;
    @FXML private TableColumn<Torneo, String> colTorneoFechaFin;

    // ========== PARTIDOS ==========
    @FXML private DatePicker dpFiltroFecha;
    @FXML private TableView<?> tablaPartidos;
    @FXML private TableColumn<?, Integer> colPartidoId;
    @FXML private TableColumn<?, String> colPartidoTorneo;
    @FXML private TableColumn<?, String> colPartidoEquipo1;
    @FXML private TableColumn<?, String> colPartidoEquipo2;
    @FXML private TableColumn<?, String> colPartidoFecha;
    @FXML private TableColumn<?, String> colPartidoLugar;
    @FXML private TableColumn<?, String> colPartidoEstado;
    @FXML private TableColumn<?, Void> colPartidoAcciones;

    // ========== SOLICITUDES ==========
    @FXML private ComboBox<String> cmbFiltroTipoSolicitud;
    @FXML private ComboBox<String> cmbFiltroEstadoSolicitud;
    @FXML private Label lblContadorSolicitudes;
    @FXML private TableView<?> tablaSolicitudes;
    @FXML private TableColumn<?, Integer> colSolicitudId;
    @FXML private TableColumn<?, String> colSolicitudUsuario;
    @FXML private TableColumn<?, String> colSolicitudTipo;
    @FXML private TableColumn<?, String> colSolicitudRazon;
    @FXML private TableColumn<?, String> colSolicitudFecha;
    @FXML private TableColumn<?, String> colSolicitudEstado;
    @FXML private TableColumn<?, Void> colSolicitudAcciones;

    // ========== INSCRIPCIONES ==========
    @FXML private ComboBox<String> cmbFiltroTorneoInscripcion;
    @FXML private Label lblContadorInscripciones;
    @FXML private TableView<?> tablaInscripciones;
    @FXML private TableColumn<?, Integer> colInscripcionId;
    @FXML private TableColumn<?, String> colInscripcionUsuario;
    @FXML private TableColumn<?, String> colInscripcionTorneo;
    @FXML private TableColumn<?, String> colInscripcionRFC;
    @FXML private TableColumn<?, String> colInscripcionRFCValido;
    @FXML private TableColumn<?, String> colInscripcionAntecedentes;
    @FXML private TableColumn<?, String> colInscripcionFecha;
    @FXML private TableColumn<?, String> colInscripcionEstado;
    @FXML private TableColumn<?, Void> colInscripcionAcciones;

    // ========== REGLAS ==========
    @FXML private ComboBox<String> cmbDeporteReglas;
    @FXML private TableView<?> tablaReglas;
    @FXML private TableColumn<?, Integer> colReglaId;
    @FXML private TableColumn<?, String> colReglaDeporte;
    @FXML private TableColumn<?, String> colReglaTitulo;
    @FXML private TableColumn<?, String> colReglaDescripcion;
    @FXML private TableColumn<?, String> colReglaFecha;
    @FXML private TableColumn<?, Void> colReglaAcciones;

    // ========== EQUIPOS ==========
    @FXML private TextField txtBuscarEquipo;
    @FXML private TableView<Equipo> tablaEquipos;
    @FXML private TableColumn<Equipo, Integer> colEquipoId;
    @FXML private TableColumn<Equipo, String> colEquipoNombre;
    @FXML private TableColumn<Equipo, Integer> colEquipoNumJugadores;
    @FXML private TableColumn<Equipo, String> colEquipoTorneo;
    @FXML private TableColumn<Equipo, String> colEquipoEstado;

    // ========== DATOS ==========
    private JSONObject adminData;
    private ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();
    private ObservableList<Equipo> listaEquipos = FXCollections.observableArrayList();
    private ObservableList<Torneo> listaTorneos = FXCollections.observableArrayList();

    // ========== CLASES INTERNAS ==========
    
    // Clase interna para Usuario
    public static class Usuario {
        private Integer idUsuario;
        private String nombre;
        private String apellido;
        private String correo;
        private String rfc;
        private String rol;
        private String deporte;
        private String fechaRegistro;

        public Usuario(Integer idUsuario, String nombre, String apellido, String correo, 
                      String rfc, String rol, String deporte, String fechaRegistro) {
            this.idUsuario = idUsuario;
            this.nombre = nombre;
            this.apellido = apellido;
            this.correo = correo;
            this.rfc = rfc;
            this.rol = rol;
            this.deporte = deporte;
            this.fechaRegistro = fechaRegistro;
        }

        public Integer getIdUsuario() { return idUsuario; }
        public String getNombre() { return nombre; }
        public String getApellido() { return apellido; }
        public String getCorreo() { return correo; }
        public String getRfc() { return rfc; }
        public String getRol() { return rol; }
        public String getDeporte() { return deporte; }
        public String getFechaRegistro() { return fechaRegistro; }
        public String getNombreCompleto() { return nombre + " " + apellido; }
    }

    // Clase interna para Equipo
    public static class Equipo {
        private Integer idEquipo;
        private String nombreEquipo;
        private String deporte;
        private String capitan;
        private Integer numJugadores;
        private String torneo;
        private String fechaCreacion;
        private String estado;

        public Equipo(Integer idEquipo, String nombreEquipo, String deporte, String capitan,
                      Integer numJugadores, String torneo, String fechaCreacion, String estado) {
            this.idEquipo = idEquipo;
            this.nombreEquipo = nombreEquipo;
            this.deporte = deporte;
            this.capitan = capitan;
            this.numJugadores = numJugadores;
            this.torneo = torneo;
            this.fechaCreacion = fechaCreacion;
            this.estado = estado;
        }

        public Integer getIdEquipo() { return idEquipo; }
        public String getNombreEquipo() { return nombreEquipo; }
        public String getDeporte() { return deporte; }
        public String getCapitan() { return capitan; }
        public Integer getNumJugadores() { return numJugadores; }
        public String getTorneo() { return torneo; }
        public String getFechaCreacion() { return fechaCreacion; }
        public String getEstado() { return estado; }
    }

    // Clase interna para Torneo
    public static class Torneo {
        private Integer idTorneo;
        private String nombreYClasificacion;
        private String deporte;
        private String fechaInicio;
        private String fechaFin;
        private String reglasTorneo;

        public Torneo(Integer idTorneo, String nombreYClasificacion, String deporte, 
                      String fechaInicio, String fechaFin, String reglasTorneo) {
            this.idTorneo = idTorneo;
            this.nombreYClasificacion = nombreYClasificacion;
            this.deporte = deporte;
            this.fechaInicio = fechaInicio;
            this.fechaFin = fechaFin;
            this.reglasTorneo = reglasTorneo;
        }

        public Integer getIdTorneo() { return idTorneo; }
        public String getNombreYClasificacion() { return nombreYClasificacion; }
        public String getDeporte() { return deporte; }
        public String getFechaInicio() { return fechaInicio; }
        public String getFechaFin() { return fechaFin; }
        public String getReglasTorneo() { return reglasTorneo; }
    }

    // Clase auxiliar para el ComboBox de torneos
    private static class TorneoItem {
        private final int id;
        private final String nombre;
        
        public TorneoItem(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }
        
        public int getId() {
            return id;
        }
        
        @Override
        public String toString() {
            return nombre;
        }
    }

    // ========== INICIALIZACIÓN ==========

    @FXML
    public void initialize() {
        configurarTablas();
        configurarCombos();
        cargarEstadisticas();
        mostrarUsuarios();
    }

    /**
     * Configura todas las tablas
     */
    private void configurarTablas() {
        // Tabla Usuarios
        colUsuarioId.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));
        colUsuarioNombre.setCellValueFactory(cellData -> 
            new javafx.beans.property.SimpleStringProperty(cellData.getValue().getNombreCompleto()));
        colUsuarioCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colUsuarioRFC.setCellValueFactory(new PropertyValueFactory<>("rfc"));
        colUsuarioRol.setCellValueFactory(new PropertyValueFactory<>("rol"));
        colUsuarioDeporte.setCellValueFactory(new PropertyValueFactory<>("deporte"));
        colUsuarioFecha.setCellValueFactory(new PropertyValueFactory<>("fechaRegistro"));
        
        // Botones de acción para usuarios
        colUsuarioAcciones.setCellFactory(param -> new TableCell<>() {
            private final Button btnEditar = new Button("✏️ Editar");
            private final Button btnEliminar = new Button("🗑️ Eliminar");
            private final HBox pane = new HBox(8, btnEditar, btnEliminar);

            {
                btnEditar.setStyle("-fx-background-color: #8B1538; -fx-text-fill: white; " +
                                  "-fx-font-size: 12px; -fx-cursor: hand; -fx-padding: 6 12;");
                btnEliminar.setStyle("-fx-background-color: #dc2626; -fx-text-fill: white; " +
                                    "-fx-font-size: 12px; -fx-cursor: hand; -fx-padding: 6 12;");
                pane.setAlignment(Pos.CENTER);
                
                btnEditar.setOnAction(event -> {
                    Usuario usuario = getTableView().getItems().get(getIndex());
                    editarUsuario(usuario);
                });
                
                btnEliminar.setOnAction(event -> {
                    Usuario usuario = getTableView().getItems().get(getIndex());
                    eliminarUsuario(usuario);
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : pane);
            }
        });

        tablaUsuarios.setItems(listaUsuarios);

        // Tabla Torneos
        colTorneoId.setCellValueFactory(new PropertyValueFactory<>("idTorneo"));
        colTorneoNombre.setCellValueFactory(new PropertyValueFactory<>("nombreYClasificacion"));
        colTorneoDeporte.setCellValueFactory(new PropertyValueFactory<>("deporte"));
        colTorneoFechaInicio.setCellValueFactory(new PropertyValueFactory<>("fechaInicio"));
        colTorneoFechaFin.setCellValueFactory(new PropertyValueFactory<>("fechaFin"));

        tablaTorneos.setItems(listaTorneos);

        // Tabla Equipos (OPTIMIZADA)
        colEquipoId.setCellValueFactory(new PropertyValueFactory<>("idEquipo"));
        colEquipoNombre.setCellValueFactory(new PropertyValueFactory<>("nombreEquipo"));
        colEquipoNumJugadores.setCellValueFactory(new PropertyValueFactory<>("numJugadores"));
        colEquipoTorneo.setCellValueFactory(new PropertyValueFactory<>("torneo"));
        colEquipoEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        tablaEquipos.setItems(listaEquipos);
    }

    /**
     * Configura los ComboBox
     */
    private void configurarCombos() {
        ObservableList<String> deportes = FXCollections.observableArrayList(
            "Todos", "Fútbol", "Baloncesto", "Voleibol", "Natación", "Tenis"
        );
        cmbFiltroDeporteTorneo.setItems(deportes);
        cmbDeporteReglas.setItems(deportes);

        ObservableList<String> tiposSolicitud = FXCollections.observableArrayList(
            "Todas", "Capitán", "Árbitro"
        );
        cmbFiltroTipoSolicitud.setItems(tiposSolicitud);

        ObservableList<String> estadosSolicitud = FXCollections.observableArrayList(
            "Todos", "Pendiente", "Aprobada", "Rechazada"
        );
        cmbFiltroEstadoSolicitud.setItems(estadosSolicitud);
    }

    /**
     * Establece los datos del administrador
     */
    public void setAdminData(JSONObject data) {
        this.adminData = data;
        String nombre = data.optString("nombre", "Admin");
        String apellido = data.optString("apellido", "");
        lblNombreAdmin.setText(nombre + " " + apellido);
        
        cargarDatosIniciales();
    }

    /**
     * Carga estadísticas generales
     */
    private void cargarEstadisticas() {
        try {
            // Total de usuarios
            String urlUsuarios = "http://localhost:8083/usuarios";
            String responseUsuarios = hacerPeticionGET(urlUsuarios);
            if (responseUsuarios != null) {
                JSONArray usuarios = new JSONArray(responseUsuarios);
                lblTotalUsuarios.setText(String.valueOf(usuarios.length()));
            }

            // Total de torneos
            String urlTorneos = "http://localhost:8080/torneos";
            String responseTorneos = hacerPeticionGET(urlTorneos);
            if (responseTorneos != null) {
                JSONArray torneos = new JSONArray(responseTorneos);
                lblTotalTorneos.setText(String.valueOf(torneos.length()));
            }

            // TODO: Implementar partidos de hoy y solicitudes pendientes
            lblPartidosHoy.setText("0");
            lblSolicitudesPendientes.setText("0");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al cargar estadísticas: " + e.getMessage());
        }
    }

    /**
     * Carga todos los datos iniciales
     */
    private void cargarDatosIniciales() {
        cargarUsuarios();
        cargarEstadisticas();
    }

    // ==================== NAVEGACIÓN ENTRE TABS ====================

    @FXML
    private void mostrarUsuarios() {
        cambiarTab(btnTabUsuarios, seccionUsuarios);
        cargarUsuarios();
    }

    @FXML
    private void mostrarTorneos() {
        cambiarTab(btnTabTorneos, seccionTorneos);
        cargarTorneos();
    }

    @FXML
    private void mostrarPartidos() {
        cambiarTab(btnTabPartidos, seccionPartidos);
    }

    @FXML
    private void mostrarSolicitudes() {
        cambiarTab(btnTabSolicitudes, seccionSolicitudes);
    }

    @FXML
    private void mostrarInscripciones() {
        cambiarTab(btnTabInscripciones, seccionInscripciones);
    }

    @FXML
    private void mostrarReglas() {
        cambiarTab(btnTabReglas, seccionReglas);
    }

    @FXML
    private void mostrarEquipos() {
        cambiarTab(btnTabEquipos, seccionEquipos);
        cargarEquipos();
    }

    /**
     * Cambia entre tabs
     */
    private void cambiarTab(Button tabActivo, VBox seccionActiva) {
        // Ocultar todas las secciones
        seccionUsuarios.setVisible(false);
        seccionTorneos.setVisible(false);
        seccionPartidos.setVisible(false);
        seccionSolicitudes.setVisible(false);
        seccionInscripciones.setVisible(false);
        seccionReglas.setVisible(false);
        seccionEquipos.setVisible(false);

        // Mostrar la sección activa
        seccionActiva.setVisible(true);

        // Actualizar estilos de tabs
        btnTabUsuarios.getStyleClass().clear();
        btnTabTorneos.getStyleClass().clear();
        btnTabPartidos.getStyleClass().clear();
        btnTabSolicitudes.getStyleClass().clear();
        btnTabInscripciones.getStyleClass().clear();
        btnTabReglas.getStyleClass().clear();
        btnTabEquipos.getStyleClass().clear();

        btnTabUsuarios.getStyleClass().add("tab-btn-admin");
        btnTabTorneos.getStyleClass().add("tab-btn-admin");
        btnTabPartidos.getStyleClass().add("tab-btn-admin");
        btnTabSolicitudes.getStyleClass().add("tab-btn-admin");
        btnTabInscripciones.getStyleClass().add("tab-btn-admin");
        btnTabReglas.getStyleClass().add("tab-btn-admin");
        btnTabEquipos.getStyleClass().add("tab-btn-admin");

        tabActivo.getStyleClass().clear();
        tabActivo.getStyleClass().add("tab-btn-admin-active");
    }

    // ==================== GESTIÓN DE USUARIOS ====================

    private void cargarUsuarios() {
        try {
            String urlString = "http://localhost:8083/usuarios";
            String response = hacerPeticionGET(urlString);
            
            if (response != null) {
                JSONArray arr = new JSONArray(response);
                listaUsuarios.clear();

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    
                    Usuario usuario = new Usuario(
                        obj.optInt("idUsuario"),
                        obj.optString("nombre", "N/A"),
                        obj.optString("apellido", "N/A"),
                        obj.optString("correo", "N/A"),
                        obj.optString("rfc", "N/A"),
                        obj.optString("rol", "Jugador"),
                        obj.optString("deporte", "N/A"),
                        obj.optString("fechaRegistro", "N/A")
                    );
                    
                    if(!usuario.rol.equals("Administrador")) {
                        listaUsuarios.add(usuario);
                    }
                }
                
                System.out.println("✅ Usuarios cargados: " + listaUsuarios.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error al cargar usuarios: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void buscarUsuarios() {
        String busqueda = txtBuscarUsuario.getText().trim().toLowerCase();
        
        if (busqueda.isEmpty()) {
            cargarUsuarios();
            return;
        }

        ObservableList<Usuario> usuariosFiltrados = FXCollections.observableArrayList();
        
        for (Usuario usuario : listaUsuarios) {
            String nombre = usuario.getNombreCompleto().toLowerCase();
            String correo = usuario.getCorreo().toLowerCase();
            String rfc = usuario.getRfc() != null ? usuario.getRfc().toLowerCase() : "";
            
            if (nombre.contains(busqueda) || correo.contains(busqueda) || rfc.contains(busqueda)) {
                usuariosFiltrados.add(usuario);
            }
        }
        
        tablaUsuarios.setItems(usuariosFiltrados);
        
        if (usuariosFiltrados.isEmpty()) {
            mostrarAlerta("No se encontraron usuarios con el criterio: " + busqueda, 
                         Alert.AlertType.INFORMATION);
        }
    }

    private void editarUsuario(Usuario usuario) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Editar Usuario");
        alert.setHeaderText("Editar información de: " + usuario.getNombreCompleto());
        alert.setContentText("ID: " + usuario.getIdUsuario() + "\n" +
                           "Correo: " + usuario.getCorreo() + "\n" +
                           "RFC: " + usuario.getRfc() + "\n" +
                           "Rol: " + usuario.getRol());
        alert.showAndWait();
    }

    private void eliminarUsuario(Usuario usuario) {
        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmar Eliminación");
        confirmacion.setHeaderText("¿Eliminar usuario?");
        confirmacion.setContentText("Usuario: " + usuario.getNombreCompleto() + "\n" +
                                   "Esta acción no se puede deshacer.");

        confirmacion.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    System.out.println("Eliminando usuario ID: " + usuario.getIdUsuario());
                    mostrarAlerta("✅ Usuario eliminado exitosamente", Alert.AlertType.INFORMATION);
                    cargarUsuarios();
                    cargarEstadisticas();
                } catch (Exception e) {
                    e.printStackTrace();
                    mostrarAlerta("Error al eliminar usuario: " + e.getMessage(), Alert.AlertType.ERROR);
                }
            }
        });
    }

    // ==================== GESTIÓN DE TORNEOS ====================

    private void cargarTorneos() {
        try {
            String urlString = "http://localhost:8080/torneos";
            String response = hacerPeticionGET(urlString);
            
            if (response != null) {
                JSONArray arr = new JSONArray(response);
                listaTorneos.clear();

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    
                    int idDeporte = obj.optInt("idDeporte", 0);
                    String nombreDeporte = obtenerNombreDeporte(idDeporte);
                    
                    Torneo torneo = new Torneo(
                        obj.optInt("idTorneo"),
                        obj.optString("nombreYClasificacion", "N/A"),
                        nombreDeporte,
                        obj.optString("fechaInicio", "N/A"),
                        obj.optString("fechaFin", "N/A"),
                        obj.optString("reglasTorneo", "Sin reglas")
                    );
                    
                    listaTorneos.add(torneo);
                }
                
                System.out.println("✅ Torneos cargados: " + listaTorneos.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error al cargar torneos: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private String obtenerNombreDeporte(int idDeporte) {
        switch (idDeporte) {
            case 1: return "Fútbol";
            case 2: return "Baloncesto";
            case 3: return "Voleibol";
            case 4: return "Natación";
            case 5: return "Tenis";
            default: return "Desconocido";
        }
    }

    @FXML
    private void abrirCrearTorneo() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Crear Nuevo Torneo");
        dialog.setHeaderText("🏆 Crear Nuevo Torneo");
        
        ButtonType btnCrear = new ButtonType("✅ Crear", ButtonBar.ButtonData.OK_DONE);
        ButtonType btnCancelar = new ButtonType("❌ Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().addAll(btnCrear, btnCancelar);
        
        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setPadding(new javafx.geometry.Insets(20, 20, 20, 20));
        
        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Nombre del torneo");
        txtNombre.setPrefWidth(300);
        
        ComboBox<String> cmbDeporte = new ComboBox<>();
        cmbDeporte.getItems().addAll("Fútbol", "Baloncesto", "Voleibol", "Natación", "Tenis");
        cmbDeporte.setPromptText("Selecciona deporte");
        cmbDeporte.setPrefWidth(300);
        
        DatePicker dpInicio = new DatePicker();
        DatePicker dpFin = new DatePicker();
        
        TextArea txtReglas = new TextArea();
        txtReglas.setPromptText("Reglas del torneo...");
        txtReglas.setPrefHeight(80);
        txtReglas.setWrapText(true);
        
        grid.add(new Label("Nombre:"), 0, 0);
        grid.add(txtNombre, 1, 0);
        grid.add(new Label("Deporte:"), 0, 1);
        grid.add(cmbDeporte, 1, 1);
        grid.add(new Label("Fecha Inicio:"), 0, 2);
        grid.add(dpInicio, 1, 2);
        grid.add(new Label("Fecha Fin:"), 0, 3);
        grid.add(dpFin, 1, 3);
        grid.add(new Label("Reglas:"), 0, 4);
        grid.add(txtReglas, 1, 4);
        
        dialog.getDialogPane().setContent(grid);
        
        grid.getChildren().stream()
            .filter(node -> node instanceof Label)
            .forEach(node -> ((Label) node).setStyle("-fx-font-weight: bold;"));
        
        dialog.showAndWait().ifPresent(response -> {
            if (response == btnCrear) {
                if (txtNombre.getText().isEmpty() || cmbDeporte.getValue() == null || 
                    dpInicio.getValue() == null || dpFin.getValue() == null) {
                    mostrarAlerta("⚠️ Completa todos los campos", Alert.AlertType.WARNING);
                    return;
                }
                
                JSONObject json = new JSONObject();
                json.put("idDeporte", obtenerIdDeporte(cmbDeporte.getValue()));
                json.put("nombreYClasificacion", txtNombre.getText());
                json.put("reglasTorneo", txtReglas.getText());
                json.put("fechaInicio", dpInicio.getValue().toString());
                json.put("fechaFin", dpFin.getValue().toString());
                
                if (enviarPOST("http://localhost:8080/torneos", json.toString())) {
                    mostrarAlerta("✅ Torneo creado exitosamente", Alert.AlertType.INFORMATION);
                    cargarEstadisticas();
                    cargarTorneos();
                } else {
                    mostrarAlerta("❌ Error al crear torneo", Alert.AlertType.ERROR);
                }
            }
        });
    }

    private int obtenerIdDeporte(String deporte) {
        switch (deporte) {
            case "Fútbol": return 1;
            case "Baloncesto": return 2;
            case "Voleibol": return 3;
            case "Natación": return 4;
            case "Tenis": return 5;
            default: return 1;
        }
    }

    // ==================== GESTIÓN DE EQUIPOS ====================

    private void cargarEquipos() {
        try {
            String urlString = "http://localhost:8088/equipos";
            String response = hacerPeticionGET(urlString);
            
            if (response != null) {
                JSONArray arr = new JSONArray(response);
                listaEquipos.clear();

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    
                    // Obtener nombre del torneo
                    String nombreTorneo = "Sin torneo";
                    int idTorneo = obj.optInt("idTorneo", 0);
                    if (idTorneo > 0) {
                        nombreTorneo = obtenerNombreTorneo(idTorneo);
                    }
                    
                    // Contar jugadores
                    int numJugadores = 0;
                    String listaJugadores = obj.optString("listaIdJugadores", "");
                    if (!listaJugadores.isEmpty() && !listaJugadores.equals("null")) {
                        numJugadores = listaJugadores.split(",").length;
                    }
                    
                    Equipo equipo = new Equipo(
                        obj.optInt("id"),
                        obj.optString("nombreEquipo", "N/A"),
                        "N/A", // deporte (se obtiene del torneo)
                        "N/A", // capitan (ya no se usa)
                        numJugadores,
                        nombreTorneo,
                        "N/A", // fechaCreacion
                        "Activo"
                    );
                    
                    listaEquipos.add(equipo);
                }
                
                System.out.println("✅ Equipos cargados: " + listaEquipos.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("Error al cargar equipos: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private String obtenerNombreTorneo(int idTorneo) {
        try {
            String response = hacerPeticionGET("http://localhost:8080/torneos/" + idTorneo);
            if (response != null) {
                JSONObject torneo = new JSONObject(response);
                return torneo.optString("nombreYClasificacion", "Torneo #" + idTorneo);
            }
        } catch (Exception e) {
            System.err.println("Error obteniendo nombre del torneo: " + e.getMessage());
        }
        return "Torneo #" + idTorneo;
    }

    @FXML
    private void abrirCrearEquipo() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Crear Nuevo Equipo");
        dialog.setHeaderText("👥 Crear Nuevo Equipo");
        
        ButtonType btnCrear = new ButtonType("✅ Crear", ButtonBar.ButtonData.OK_DONE);
        ButtonType btnCancelar = new ButtonType("❌ Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
        dialog.getDialogPane().getButtonTypes().addAll(btnCrear, btnCancelar);
        
        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setPadding(new javafx.geometry.Insets(20, 20, 20, 20));
        
        TextField txtNombreEquipo = new TextField();
        txtNombreEquipo.setPromptText("Ej: Tigres FC");
        txtNombreEquipo.setPrefWidth(300);
        
        ComboBox<TorneoItem> cmbTorneo = new ComboBox<>();
        cmbTorneo.setPromptText("Selecciona un torneo");
        cmbTorneo.setPrefWidth(300);
        
        cargarTorneosEnCombo(cmbTorneo);
        
        grid.add(new Label("Nombre del Equipo:"), 0, 0);
        grid.add(txtNombreEquipo, 1, 0);
        grid.add(new Label("Torneo:"), 0, 1);
        grid.add(cmbTorneo, 1, 1);
        
        dialog.getDialogPane().setContent(grid);
        
        grid.getChildren().stream()
            .filter(node -> node instanceof Label)
            .forEach(node -> ((Label) node).setStyle("-fx-font-weight: bold;"));
        
        dialog.showAndWait().ifPresent(response -> {
            if (response == btnCrear) {
                if (txtNombreEquipo.getText().trim().isEmpty() || cmbTorneo.getValue() == null) {
                    mostrarAlerta("⚠️ Completa todos los campos obligatorios", Alert.AlertType.WARNING);
                    return;
                }
                
                crearEquipoEnServidor(
                    txtNombreEquipo.getText().trim(),
                    cmbTorneo.getValue().getId()
                );
            }
        });
    }

    private void cargarTorneosEnCombo(ComboBox<TorneoItem> combo) {
        try {
            String response = hacerPeticionGET("http://localhost:8080/torneos");
            if (response != null) {
                JSONArray arr = new JSONArray(response);
                
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    int id = obj.optInt("idTorneo");
                    String nombre = obj.optString("nombreYClasificacion", "Sin nombre");
                    
                    combo.getItems().add(new TorneoItem(id, nombre));
                }
            }
        } catch (Exception e) {
            System.err.println("Error cargando torneos: " + e.getMessage());
        }
    }

    private void crearEquipoEnServidor(String nombreEquipo, int idTorneo) {
        try {
            JSONObject equipo = new JSONObject();
            equipo.put("nombreEquipo", nombreEquipo);
            equipo.put("idTorneo", idTorneo);
            equipo.put("listaIdJugadores", "");
            
            boolean exito = enviarPOST("http://localhost:8088/equipos", equipo.toString());
            
            if (exito) {
                mostrarAlerta("✅ Equipo creado exitosamente\n\nNombre: " + nombreEquipo, 
                             Alert.AlertType.INFORMATION);
                cargarEquipos();
            } else {
                mostrarAlerta("❌ Error al crear el equipo", Alert.AlertType.ERROR);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlerta("❌ Error: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    // ==================== GESTIÓN DE PARTIDOS ====================

    @FXML
    private void abrirCrearPartido() {
        mostrarAlerta("⚽ Función: Crear Partido\n\nEsta función abrirá un formulario para programar un nuevo partido.", 
                     Alert.AlertType.INFORMATION);
    }

    // ==================== GESTIÓN DE REGLAS ====================

    @FXML
    private void cargarReglasDeporte() {
        String deporte = cmbDeporteReglas.getValue();
        if (deporte != null && !deporte.equals("Todos")) {
            System.out.println("Cargando reglas de: " + deporte);
        }
    }

    @FXML
    private void agregarRegla() {
        String deporte = cmbDeporteReglas.getValue();
        if (deporte == null || deporte.isEmpty()) {
            mostrarAlerta("Primero selecciona un deporte", Alert.AlertType.WARNING);
            return;
        }

        mostrarAlerta("📜 Función: Agregar Regla\n\nDeporte: " + deporte + 
                     "\n\nEsta función abrirá un formulario para agregar una nueva regla.", 
                     Alert.AlertType.INFORMATION);
    }

    // ==================== UTILIDADES ====================

    private String hacerPeticionGET(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            int responseCode = con.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8)
                );
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();
                return response.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean enviarPOST(String urlString, String json) {
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(urlString).openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            
            con.getOutputStream().write(json.getBytes(StandardCharsets.UTF_8));
            
            return con.getResponseCode() == 200 || con.getResponseCode() == 201;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @FXML
    private void cerrarSesion() {
        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Cerrar Sesión Administrativa");
        confirmacion.setHeaderText("¿Estás seguro?");
        confirmacion.setContentText("¿Deseas cerrar la sesión administrativa?");

        confirmacion.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login.fxml"));
                    Parent root = loader.load();
                    
                    Stage stage = (Stage) lblNombreAdmin.getScene().getWindow();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Nexus Deportivo - Iniciar Sesión");
                    stage.show();
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void mostrarAlerta(String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(tipo == Alert.AlertType.ERROR ? "Error" : 
                      tipo == Alert.AlertType.WARNING ? "Advertencia" : "Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}