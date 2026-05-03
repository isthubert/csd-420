/**
 * Isaac St Hubert 05/03/2026 Module 8.2
 * This program uses three threads to generate letters, digits, and symbols.
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * ThreeThreads program.
 */
public class IsaacThreeThreads extends Application {

    private TextArea textArea = new TextArea();
    private final int COUNT = 10000;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts JavaFX application.
     */
    @Override
    public void start(Stage primaryStage) {
        textArea.setWrapText(true);

        BorderPane pane = new BorderPane();
        pane.setCenter(textArea);

        Scene scene = new Scene(pane, 600, 400);

        primaryStage.setTitle("Isaac Three Threads");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Test methods
        testRandomMethods();

        startThreads();
    }

    /**
     * Starts the three threads.
     */
    public void startThreads() {

        Thread letterThread = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                char ch = getRandomLetter();

                Platform.runLater(() ->
                        textArea.appendText(String.valueOf(ch)));

                sleepThread();
            }
        });

        Thread digitThread = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                char ch = getRandomDigit();

                Platform.runLater(() ->
                        textArea.appendText(String.valueOf(ch)));

                sleepThread();
            }
        });

        Thread symbolThread = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                char ch = getRandomSymbol();

                Platform.runLater(() ->
                        textArea.appendText(String.valueOf(ch)));

                sleepThread();
            }
        });

        letterThread.start();
        digitThread.start();
        symbolThread.start();
    }

    /**
     * Generates a random lowercase letter.
     *
     * @return random letter
     */
    public char getRandomLetter() {
        return (char) ('a' + (int)(Math.random() * 26));
    }

    /**
     * Generates a random digit.
     *
     * @return random digit
     */
    public char getRandomDigit() {
        return (char) ('0' + (int)(Math.random() * 10));
    }

    /**
     * Generates a random symbol.
     *
     * @return random symbol
     */
    public char getRandomSymbol() {
        char[] symbols = {'!', '@', '#', '$', '%', '&', '*', '^'};
        return symbols[(int)(Math.random() * symbols.length)];
    }

    /**
     * Pauses thread briefly so the output is more mixed
     */
    public void sleepThread() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests all random generator methods.
     */
    public void testRandomMethods() {
        System.out.println("Letter test: " + getRandomLetter());
        System.out.println("Digit test: " + getRandomDigit());
        System.out.println("Symbol test: " + getRandomSymbol());
        System.out.println("All methods tested successfully.");
    }
}