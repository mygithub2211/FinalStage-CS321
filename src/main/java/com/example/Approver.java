//Packages
package com.example;

//Imports
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.input.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Locale;

import javafx.scene.control.Label;

public class Approver extends Application {//Start of class

    private Stage mainEventStage; //the main stage to be used throughout the program
    private Scene parentScreen; //the start screen
    private GridPane pane; //the pane to be used when developing screens

    //Setter for the main stage
    protected void setMainStage(Stage mainEventStage){
        this.mainEventStage = mainEventStage;
        mainEventStage.setFullScreen(true);
        mainEventStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
    }

    //Getter for the main stage
    public Stage getMainStage(){
        return this.mainEventStage;
    }

    //Setter for the start screen
    protected void setStartScreen(Scene parentScreen){
        this.parentScreen = parentScreen;
    }

    //Getter for the start screen
    public Scene getStartScreen(){
        return parentScreen;
    }

    //Setter to initialize a pane used for a screen
    protected void setPane(GridPane pane){
        this.pane = pane;
    }

    //Getter to retrieve the pane used for a given screen
    public GridPane getPane(){
        return this.pane;
    }

    protected void addFeaturesToPane(GridPane pane, TextArea text, Label[] labels, TextField[] fields, Button[] buttons){
        pane.add(labels[0], 0, 0);
        pane.add(fields[0], 0, 1);
        pane.add(labels[1], 0, 2);
        pane.add(fields[1], 0, 3);
        pane.add(text, 0, 4);
        pane.add(buttons[0], 0, 5);
        pane.add(buttons[1], 1, 5);
        pane.setAlignment(Pos.CENTER);
    }

    //Method for transitioning to a different screen.
    protected void transition(Scene screen){
        getMainStage().setScene(screen);
        getMainStage().setFullScreen(true);
        getMainStage().setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
    }
    
    protected void loadHomeScreen(Button homeButton){
        homeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                transition(getStartScreen());
            }
        });
    }

    protected void loadThankYouScreen(Button sendButton){
        sendButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setPane(new GridPane());

                Text text = new Text();
                text.setText("Your email has been sent successfully!");
                text.setFont(new Font(50));

                Button home = new Button("Home");
                getPane().add(text, 27,27);
                getPane().add(home, 27,28);
                getPane().setAlignment(Pos.CENTER);
                
                loadHomeScreen(home);

                Scene handlerScene = new Scene(getPane());
                transition(handlerScene);
            }
        });
    }

    protected void onApproveButton(){
        setPane(new GridPane());

        Label[] arrayL = new Label[2];
        TextField[] arrayT = new TextField[2];
        Button[] arrayB = new Button[2];

        Label labelFrom = new Label("From:");
        TextField fieldFrom = new TextField();

        arrayL[0] = labelFrom;
        arrayT[0] = fieldFrom;

        Label labelTo = new Label("To:");
        TextField fieldTo = new TextField();

        arrayL[1] = labelTo;
        arrayT[1] = fieldTo;

        TextArea text = new TextArea("Type email to the applicant here!");

        Button sendButton = new Button("Send");
        Button homeButton = new Button("Home");

        arrayB[0] = sendButton;
        arrayB[1] = homeButton;

        addFeaturesToPane(getPane(), text, arrayL, arrayT, arrayB);

        //What the send and home buttons will do when clicked
        loadThankYouScreen(sendButton);
        loadHomeScreen(homeButton);

        //Setting up the screen to be visible to the user
        Scene scene = new Scene(getPane());
        getMainStage().setTitle("Approve Screen");
        transition(scene);
    }

    protected void onRejectButton(){
        setPane(new GridPane());

        Label labelFrom = new Label("From:");
        TextField fieldFrom = new TextField();

        Label labelTo = new Label("To:");
        TextField fieldTo = new TextField();

        TextArea text = new TextArea("Type email to the Reviewer here!");

        Button sendButton = new Button("Send");
        Button homeButton = new Button("Home");

        Label[] arrayL = new Label[2];
        TextField[] arrayT = new TextField[2];
        Button[] arrayB = new Button[2];

        arrayL[0] = labelFrom;
        arrayT[0] = fieldFrom;

        arrayL[1] = labelTo;
        arrayT[1] = fieldTo;

        arrayB[0] = sendButton;
        arrayB[1] = homeButton;

        addFeaturesToPane(pane, text, arrayL, arrayT, arrayB);

        //What the send and home buttons will do when clicked
        loadThankYouScreen(sendButton);
        loadHomeScreen(homeButton);

        //Setting up the screen to be visible to the user
        Scene scene = new Scene(getPane());
        getMainStage().setTitle("Reject Screen");
        transition(scene);
    }

    protected void showApproverScreen(){
        setPane(new GridPane());

        //Buttons that will appear in initial screen
        Button buttonApprove = new Button("Approve");
        Button buttonReject = new Button("Reject");
        Button saveButton = new Button("Save Application");

        //Addition of the buttons to the screen
        getPane().add(buttonApprove, 0, 0);
        getPane().add(buttonReject, 0, 1);
        getPane().add(saveButton, 0, 3);
        getPane().setAlignment(Pos.CENTER);

        //The actions that will occur when the buttons on the main screen are clicked
        buttonApprove.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                onApproveButton();
            }
        });
        buttonReject.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                onRejectButton();
            }
        });
        saveButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Text text = new Text("Your edited application has been saved to the database!");
                getPane().add(text, 1,7);
            }
        });

        //Initializing the main screen
        setStartScreen(new Scene(getPane(), 320, 240));

        //Setting the title of the window and making the initial screen visible
        getMainStage().setTitle("Approver action page");
        transition(getStartScreen());
    }

    protected void showLogOnScreen(){
        setPane(new GridPane());
        Label username = new Label("Username:");
        TextField userText = new TextField();

        Label password = new Label("Password:");
        TextField passwordText = new TextField();

        Button loginButton = new Button("login");

        getPane().add(username, 0, 0);
        getPane().add(userText, 0, 1);
        getPane().add(password, 0, 2);
        getPane().add(passwordText, 0, 3);
        getPane().add(loginButton, 0, 4);
        getPane().setAlignment(Pos.CENTER);

        loginButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            Label errorText = new Label();
            String error1 = "Both username and password are required! Please enter your login info :)";
            String error2 = "username and/or password is/are incorrect! Please try again :)";
            @Override
            public void handle(MouseEvent mouseEvent){
                if (userText.getText().equals("approver") && passwordText.getText().equals("123")){
                    errorText.setText("Access granted! Welcome :)");
                    showApproverScreen();
                }
                else if (userText.getText().isBlank() || passwordText.getText().isBlank()){
                    errorText.setText(error1);
                    getPane().add(errorText, 1,4);
                }
                else{
                    errorText.setText(error2);
                    getPane().add(errorText, 1,4);
                }
            }
        });

        Scene scene = new Scene(getPane(), 320, 240);

        getMainStage().setTitle("Login screen");
        getMainStage().setScene(scene);
        getMainStage().setFullScreen(true);
        getMainStage().setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        getMainStage().show();
    }
    
    @Override
    public void start(Stage stage) throws IOException {
        Locale.setDefault(Locale.ENGLISH);
        //Setting the main screen for the program
        setMainStage(stage);
        showLogOnScreen();
    }

    //Running the program and launching the start screen
    public static void main(String[] args) {
        launch(args);
    }
} //End of class
