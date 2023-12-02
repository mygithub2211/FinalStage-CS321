//Testing Package
package com.example;

//Non-static imports
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.*;
import javafx.stage.Window;
import javafx.scene.layout.GridPane;
import javafx.application.Platform;
import javafx.stage.Stage;
import com.example.Approver;
import org.junit.*;
import java.io.IOException;

//Static imports
import static org.junit.Assert.*;

public class ApproverTest {
    // Private variables that will be used for testing
    private Approver approve;
    private Stage stage;

    // Setter methods that will be used for testing
    protected void setApprover(Approver app) {
        approve = app;
    }

    protected void setStage(Stage st) {
        stage = st;
    }

    // Getter methods that will be used for testing
    protected Approver getApprover() {
        return approve;
    }

    protected Stage getStage() {
        return stage;
    }

    @Test
    public void testShowLogOnScreenWithValidCredentials()
            throws IOException, InterruptedException {
        setApprover(new Approver());
        try {
            setStage(new Stage());
            getApprover().start(getStage());

            TextField userText = (TextField) getApprover().getPane().lookup("#userText");
            TextField passwordText = (TextField) getApprover().getPane().lookup("#passwordText");
            Button loginButton = (Button) getApprover().getPane().lookup("#login");

            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    userText.setText("approver");
                    passwordText.setText("123");
                    loginButton.fire();
                }
            });

            // Delay for JavaFX to process events
            Thread.sleep(1000);

            assertEquals("Approver action page", getApprover().getMainStage().getTitle());
        } catch (ExceptionInInitializerError e) {
            System.err.println(e.getStackTrace());
        } catch (NoClassDefFoundError e) {
            System.err.println(e.getStackTrace());
        }
    }

    @Test
    public void testShowLogOnScreenWithInvalidCredentials() throws IOException, InterruptedException {
        setApprover(new Approver());
        try {
            setStage(new Stage());
            getApprover().start(getStage());
            TextField userText = (TextField) getApprover().getPane().lookup("#userText");
            TextField passwordText = (TextField) getApprover().getPane().lookup("#passwordText");
            Button loginButton = (Button) getApprover().getPane().lookup("#login");

            Platform.runLater(() -> {
                userText.setText("invalidUser");
                passwordText.setText("invalidPass");
                loginButton.fire();
            });

            // Delay for JavaFX to process events
            Thread.sleep(1000);

            Text errorMessage = (Text) getApprover().getPane().lookup("#errorMessage");
            assertNotNull(errorMessage);
            assertEquals("User login or password is not recognized. Please try entering your login info again.", errorMessage.getText());
        } catch (NoClassDefFoundError e) {
            System.err.println(e.getStackTrace());
        } catch (ExceptionInInitializerError e){
            System.err.println(e.getStackTrace());
        }
    }

    // Add more test cases for other methods as needed
    @Test
    public void testOnApproveButtonClick() throws IOException, InterruptedException {
        setApprover(new Approver());
        try {
            setStage(new Stage());
            getApprover().start(getStage());
            TextField userText = (TextField) getApprover().getPane().lookup("#userText");
            TextField passwordText = (TextField) getApprover().getPane().lookup("#passwordText");
            Button loginButton = (Button) getApprover().getPane().lookup("#login");

            Platform.runLater(() -> {
                userText.setText("approver");
                passwordText.setText("123");
                loginButton.fire();
            });
            // Delay for JavaFX to process events
            Thread.sleep(1000);
        } catch (NoClassDefFoundError e) {
            System.err.println(e.getStackTrace());
        } catch (ExceptionInInitializerError e){
            System.err.println(e.getStackTrace());
        }
    }
}
