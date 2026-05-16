/**
 * Isaac St Hubert 05/16/2026 Module 10.2
 * This program creates a JavaFX application that connects to a MySQL database
 * and allows the user to display and update fan records.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;

public class FanDatabase extends Application {

    private static final String URL =
            "jdbc:mysql://localhost:3306/databasedb";

    private static final String USER = "student1";
    private static final String PASSWORD = "pass";

    // GUI Components
    private TextField idField = new TextField();
    private TextField firstNameField = new TextField();
    private TextField lastNameField = new TextField();
    private TextField favoriteTeamField = new TextField();

    private Button displayButton = new Button("Display");
    private Button updateButton = new Button("Update");

    private Label statusLabel = new Label();

    /**
     * This method creates all interface components and assigns buttons for displaying and updating records
     *
     * @param primaryStage The main window for the application.
     */
    @Override
    public void start(Stage primaryStage) {

        // Layout
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(15));
        pane.setHgap(10);
        pane.setVgap(10);

        pane.add(new Label("ID:"), 0, 0);
        pane.add(idField, 1, 0);

        pane.add(new Label("First Name:"), 0, 1);
        pane.add(firstNameField, 1, 1);

        pane.add(new Label("Last Name:"), 0, 2);
        pane.add(lastNameField, 1, 2);

        pane.add(new Label("Favorite Team:"), 0, 3);
        pane.add(favoriteTeamField, 1, 3);

        pane.add(displayButton, 0, 4);
        pane.add(updateButton, 1, 4);

        pane.add(statusLabel, 0, 5, 2, 1);

        // Buttons
        displayButton.setOnAction(e -> displayRecord());
        updateButton.setOnAction(e -> updateRecord());

        Scene scene = new Scene(pane, 400, 250);

        primaryStage.setTitle("Fan Database");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to connect to database
    private Connection connectToDatabase() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /** 
     * Display record based on ID
     *
     * If the record does not exist, the method clears
     * the text fields and displays an error message.
     *
     * The method also validates that the ID entered
     * is an integer value.
     */
    private void displayRecord() {

        String sql = "SELECT * FROM fans WHERE ID = ?";

        try (
                Connection connection = connectToDatabase();
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            int id = Integer.parseInt(idField.getText());

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {

                firstNameField.setText(
                        resultSet.getString("firstname"));

                lastNameField.setText(
                        resultSet.getString("lastname"));

                favoriteTeamField.setText(
                        resultSet.getString("favoriteteam"));

                statusLabel.setText("Record displayed.");

            } else {

                statusLabel.setText("Record not found.");

                firstNameField.clear();
                lastNameField.clear();
                favoriteTeamField.clear();
            }

        } catch (NumberFormatException ex) {

            statusLabel.setText("ID must be an integer.");

        } catch (SQLException ex) {

            statusLabel.setText("Database error.");
            ex.printStackTrace();
        }
    }

    /** 
     * Updates record based on ID
     *
     * If the record exists, the database is updated and a confirmation message appears.
     * If no record exists, an error message appears.
     *
     */
    private void updateRecord() {

        String sql =
                "UPDATE fans " +
                "SET firstname = ?, lastname = ?, favoriteteam = ? " +
                "WHERE ID = ?";

        try (
                Connection connection = connectToDatabase();
                PreparedStatement statement =
                        connection.prepareStatement(sql)
        ) {

            int id = Integer.parseInt(idField.getText());

            statement.setString(1, firstNameField.getText());
            statement.setString(2, lastNameField.getText());
            statement.setString(3, favoriteTeamField.getText());
            statement.setInt(4, id);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {

                statusLabel.setText("Record updated.");

            } else {

                statusLabel.setText("Record not found.");
            }

        } catch (NumberFormatException ex) {

            statusLabel.setText("ID must be an integer.");

        } catch (SQLException ex) {

            statusLabel.setText("Database error.");
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}