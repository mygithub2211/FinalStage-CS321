//List of all imports used
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



import java.io.*;


import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

public class ApproverGUI extends Application {//Start of class

    private Scene parentScreen;

    public void setStartScreen(Scene parent){
        parentScreen = parent;
    }

    public Scene getStartScreen(){
        return parentScreen;
    }
    protected void loadHomeScreen(Stage stage, Button homeButton){
        //What the home Button will do when clicked
        homeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //shows the initial stage
                stage.setScene(parentScreen);
            }
        });
    }

    protected void loadSendScreen(Stage stage, Button sendButton){
        //What the send button will do when clicked
        sendButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                GridPane pane = new GridPane();

                Text text = new Text();
                text.setText("Your email has been sent to the applicant successfully!");
                text.setFont(new Font(50));

                Button home = new Button("Home");

                pane.add(text, 27,27);
                pane.add(home, 27,28);
                pane.setAlignment(Pos.CENTER);

                loadHomeScreen(stage, home);

                Scene handlerScene = new Scene(pane);
                stage.setScene(handlerScene);
            }
        });
    }

    protected void onApproveButtonClick(Stage stage){
        //Creating a new screen for the email
        GridPane pane = new GridPane();

        //Introducing the features of the email using labels and text box
        Label labelFrom = new Label("From:");
        TextField fieldFrom = new TextField(); //for entering the "from" email address in a text field

        Label labelTo = new Label("To:");
        TextField fieldTo = new TextField(); //for entering the "to" email address in a text field

        TextArea text = new TextArea("Type email to the applicant here!");

        Button sendButton = new Button("Send");

        Button homeButton = new Button("Home");

        //Adding all the features of the email to the Window
        pane.add(labelFrom, 0, 0);
        pane.add(fieldFrom, 0, 1);
        pane.add(labelTo, 0,2);
        pane.add(fieldTo, 0,3);
        pane.add(text, 0, 6);
        pane.add(homeButton, 0,7);
        pane.add(sendButton, 1,7);

        //Alignment of all content to the center of the screen
        pane.setAlignment(Pos.CENTER);

        //What the send button will do when clicked
        loadSendScreen(stage, sendButton);
        //What the home Button will do when clicked
        loadHomeScreen(stage, homeButton);

        //Setting up the screen to be visible ot the user
        Scene scene = new Scene(pane);
        //Stage stage = new Stage();
        stage.setTitle("Approve Screen");
        stage.setScene(scene);
        //stage.setFullScreen(true); // set the new window to full screen

        //Show the new screen when the button is clicked
        //stage.show();
    }

    protected void onRejectButtonClick(Stage stage){
        //Creating a new screen for the email
        GridPane pane = new GridPane();

        //Introducing the features of the email using labels and text box
        Label labelFrom = new Label("From:");
        TextField fieldFrom = new TextField(); //for entering the "from" email address in a text field

        Label labelTo = new Label("To:");
        TextField fieldTo = new TextField(); //for entering the "to" email address in a text field

        TextArea text = new TextArea("Type changes to be made by reviewer here!");

        Button sendButton = new Button("Send");

        Button homeButton = new Button("Home");

        //Adding all the features of the email to the Window
        pane.add(labelFrom, 0, 0);
        pane.add(fieldFrom, 0, 1);
        pane.add(labelTo, 0,2);
        pane.add(fieldTo, 0,3);
        pane.add(text, 0, 6);
        pane.add(homeButton, 0,7);
        pane.add(sendButton, 1,7);

        //Alignment of all content of the screen to the center
        pane.setAlignment(Pos.CENTER);

        //What the send button will do when clicked
        loadSendScreen(stage, sendButton);

        //What the home Button will do when clicked
        loadHomeScreen(stage, homeButton);

        //Setting up the screen to be visible ot the user
        Scene scene = new Scene(pane);
        stage.setTitle("Reject Screen");
        stage.setScene(scene);
    }

    protected void showApproverScreen(Stage stage){
        //The initial screen that will show up
        GridPane pane = new GridPane();
        //Buttons that will appear in initial screen
        Button buttonApprove = new Button("Approve");
        Button buttonReject = new Button("Reject");
        Button saveButton = new Button("Save Application");

        //Addition of the buttons to the screen
        pane.add(buttonApprove, 0, 0);
        pane.add(buttonReject, 0, 1);
        pane.add(saveButton, 0, 7);

        //Alignment of all content on the screen to the center
        pane.setAlignment(Pos.CENTER);

        //The actions that will occur when the buttons on the main screen are clicked
        buttonApprove.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                onApproveButtonClick(stage);
            }
        });

        buttonReject.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                onRejectButtonClick(stage);
            }
        });

        saveButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Text text = new Text("Your edited application has been saved to the database!");
                pane.add(text, 1,7);
            }
        });

        parentScreen = new Scene(pane, 320, 240);

        //Setting the title of the window
        stage.setTitle("Approver action page");

        //Making the initial screen visible
        stage.setScene(parentScreen);
        stage.setFullScreen(true);
        stage.show();
    }

     


    private TextField FnameField;
    private TextField LnameField;
    
    private TextField houseNumberField;

    private TextField streetField;
    private TextField cityField;
    private TextField zipcodeField;

    private TextField cardNumberField;
    private TextField cvvField;
    private TextField expirationField;

    private Button checkButton;


    private TextArea reasonsField;
    private DatePicker dobPicker;

    private File saveFile;
    private Stage stage;


    private void loadSavedFormData() {
        VBox layout = new VBox(10);
        Scene scene = new Scene(layout, 500, 500);

        stage.setTitle("Applicant's Form");

        //Setting text boxes and buttons
        FnameField = new TextField();
        LnameField = new TextField();
        dobPicker = new DatePicker();
        houseNumberField = new TextField();
        streetField = new TextField();
        cityField = new TextField();
        zipcodeField = new TextField();
        reasonsField = new TextArea();
        cardNumberField = new TextField();
        cvvField = new TextField();
        expirationField = new TextField();
        checkButton = new Button("Check");
        


        //This is the form layout
        VBox form = new VBox(
                    new Label("First Name:"), FnameField,
                    new Label("Last Name: "), LnameField,
                    new Label("Date of Birth:"), dobPicker,
                    new Label("House Number:"), houseNumberField,
                    new Label("Street:"), streetField,
                    new Label("City:"), cityField,
                    new Label("Zipcode:"), zipcodeField,
                    new Label("Reasons for Request:"), reasonsField,
                    new Label("Payment Information:"),
                    new Label("Card Number:"), cardNumberField,
                    new Label("CVV:"), cvvField,
                    new Label("Expiration Date:"), expirationField,
                    checkButton
        );
     

        //open up the saving_form.ser
        //directory you want to save the form. Must be same directory with other workflow and form files
        saveFile = new File("/Users/phattran/IdeaProjects/demo/src/main/java/com/example/demo/saving_form.ser");
        if (saveFile.exists()) { //true if there is a file
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(saveFile))) {
                Form savedData = (Form) inputStream.readObject();
                
                FnameField.setText(savedData.getFname());
                LnameField.setText(savedData.getLname());
                
                dobPicker.setValue(savedData.getDob());
                houseNumberField.setText(savedData.getHouseNumber());
                streetField.setText(savedData.getStreet());

                cityField.setText(savedData.getCity());
                zipcodeField.setText(savedData.getZipcode());
                reasonsField.setText(savedData.getReasons());

                cardNumberField.setText(savedData.getCardNumber());
                cvvField.setText(savedData.getCvv());
                expirationField.setText(savedData.getExpiration());

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        checkButton.setOnAction(e -> showApproverScreen(stage));


        //create the scroll
        ScrollPane scrollPane = new ScrollPane(form);
        layout.getChildren().addAll(scrollPane);

        stage.setScene(scene);
    }



  
    @Override
    public void start(Stage primaryStage) throws IOException {

        VBox layout = new VBox(10);
        Scene scene = new Scene(layout, 500, 500);

        Button checkButton = new Button("Check");
        Text text = new Text("CHECK FORM! DING DING!");
        

        checkButton.setOnAction(e -> {
            //Log In Screen
            TextField username = new TextField();
            TextField password = new TextField();
            Button logInButton = new Button("Log In");


            VBox layout2 = new VBox(10);
            Scene scene2 = new Scene(layout2, 500, 500);

            VBox x = new VBox(
                    new Label("Username:"), username,
                    new Label("Password"), password,
                    logInButton
            );

            logInButton.setOnAction(f -> {
                
                //default username and password
                if(username.getText().equals("approver")){
                    if(password.getText().equals("123")){
                        loadSavedFormData();
                    }
                }

            });

            layout2.getChildren().addAll(x);
            layout2.setAlignment(Pos.CENTER);

            primaryStage.setScene(scene2);




        });
           

        stage = primaryStage;

        layout.getChildren().addAll(text, checkButton);
        layout.setAlignment(Pos.CENTER);

        primaryStage.setScene(scene);
        primaryStage.show();   

    }

    //Running the program to launch the screens
    public static void main(String[] args) {
        launch(args);
    }
} //End of class


  