package controladores.control;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.Person;
import java.io.File;
import java.util.prefs.Preferences;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Person> personData = FXCollections.observableArrayList();


    /**
     * Constructor
     */
    public MainApp() {
        // Add some sample data
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
    }
    public ObservableList<Person> getPersonData(File file) {
        return personData;
    }
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");
        this.primaryStage.getIcons().add(new Image("file:resources/images/img.jpg"));


        showPersonOverviewController();
    }

    private void showPersonOverviewController() {
    }

    public void initRootLayout() {
    try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("Visual.example.javafx.RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
           Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
       }
    }

    /**
     * Shows the person overview inside the root layout.
     */
    public void showPersonOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("Visual.com.example.javafx.PersonOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getPersonFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    public boolean showPersonEditDialog(Person person) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("Visual.example.javafx.PersonEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Person");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            PersonEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public void setPersonFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            // Update the stage title.
            primaryStage.setTitle("AddressApp - " + file.getName());
        } else {
            prefs.remove("filePath");

            // Update the stage title.
            primaryStage.setTitle("AddressApp");
        }
    }

    /**
     * Loads person data from the specified file. The current person data will
     * be replaced.
     *
     * @param
     */




    /**
     * Opens a dialog to show birthday statistics.
     *
     * @return
     */
    public <Agenda> List<Agenda> showBirthdayStatistics() throws SQLException {
        try {
            // Load the fxml file and create a new stage for the popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/BirthdayStatistics.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Birthday Statistics");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the persons into the controller.
            BirthdayStatisticsController controller = loader.getController();
            controller.setPersonData(personData);

            dialogStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Object Agenda;
        java.lang.Object agenda1 = Agenda;
        {
            String url = "jdbc:mysql://localhost:3306/alumnos";
            String user = "root";
            String pass = "";

            List<Agenda> agenda = new ArrayList<>();

            try (Connection conexion = DriverManager.getConnection(url, user, pass)) {
                Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM Agenda");

                while (rs.next()) {
                    String nombre = rs.getString("Nombre");
                    String apellido = rs.getString("Apellidos");
                    String calle = rs.getString("Calle");
                    String ciudad = rs.getString("Ciudad");
                    String codPostal = rs.getString("CodPostal");
                    String cumpleaños = rs.getString("Cumpleaños");

                    Agenda agenda = new Agenda(nombre, apellido, calle, ciudad, codPostal, cumpleaños);
                    Agenda = null;
                    agenda.wait((Long) Agenda);
                }

                rs.close();
                st.close();
            } catch (SQLException e) {
                throw new SQLException("Error al obtener los alumnos de la base de datos", e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return agenda;
        }

        public void putAgenda Object List = null;
        Iterable<? extends Agenda> agenda;
        agenda = null;
        !(Agenda <= List) > agenda throws{
            String url = "jdbc:mysql://localhost:3306/Agenda";
            String user = "root";
            String pass = "";

            try (Connection conexion = DriverManager.getConnection(url, user, pass)) {
                Statement stmnt = conexion.createStatement();
                stmnt.executeUpdate("DELETE Agenda");
                stmnt.close();

                String query = "INSERT INTO agenda (nombre, apellido, calle, ciudad, codPostal) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement pst = conexion.prepareStatement(query);

                for (Agenda agenda : agenda) {
                    pst.setString(1, agenda.getnombre());
                    pst.setString(2, agenda.getapellido());
                    pst.setString(3, agenda.getcalle());
                    pst.setString(4, agenda.getciudad());
                    pst.setString(5, agenda.getcodPostal());
                    pst.setString(5, agenda.getcumple());
                    pst.executeUpdate();
                }

                pst.close();
            } catch (SQLException e) {
                throw new SQLException("Error al insertar los Dato en la base de datos de Agenda", e);
            }
        }
    }

}