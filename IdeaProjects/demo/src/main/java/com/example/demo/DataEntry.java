/**
 * This is Data Entry Workflow
 * which allows the Applicants to log in 
 * and filing Green Card Replacement form
 * 
 * Default username (applicant) and password (123)
 * 
 * Phat Tran
 */

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.Random;
import java.io.*;

public class DataEntry extends Application {

    /*Fields that will be using throughout this program*/
    private TextField First_Name_Field;
    private TextField Last_Name_Field;
    private TextField houseNumberField;

    private TextField streetField;
    private TextField cityField;
    private TextField zipcodeField;
    
    
    private TextField cardNumberField;
    private TextField cvvField;
    private TextField expirationField;
    
    private Stage stage;
    private File saveFile;
    private DatePicker dobPicker;
    private TextArea reasonsField;

    private Button payButton;
    private Button saveButton;
    private Button submitButton;
    private Button uploadButton;

    
    void setter_Fname(String x){
        First_Name_Field = new TextField();
        First_Name_Field.setText(x);

    }


    void setter_Lname(String x){
        Last_Name_Field = new TextField();
        Last_Name_Field.setText(x);
    }

    void setter_houseNumber(String x){
        houseNumberField = new TextField();
        houseNumberField.setText(x);

    }


    void setter_Street(String x){
        streetField = new TextField();
        streetField.setText(x);
    }

    void setter_City(String x){
        cityField = new TextField();
        cityField.setText(x);
    }


    void setter_ZipCode(String x){
        zipcodeField = new TextField();
        zipcodeField.setText(x);
    }

    void setter_cardNumber(String x){
        cardNumberField = new TextField();
        cardNumberField.setText(x);
    }


    void setter_CVV(String x){
        cvvField = new TextField();
        cvvField.setText(x);
    }




    public static void main(String[] args) {
        launch(args);
    }


    /*Validation methods for each field*/
    public boolean validateFname(String Fname) {
        String format = "^[A-Za-z\\s'-]+$";
        return Fname.matches(format);
    }


    public boolean validateLname(String Lname) {
        String format = "^[A-Za-z\\s'-]+$";
        return Lname.matches(format);
    }


    public boolean validateHouseNumber(String houseNumber) {
        String format = "^[0-9]+$";
        return houseNumber.matches(format);
    }


    public boolean validateStreet(String street) {
        String format = "^[A-Za-z\\s'-]+$";
        return street.matches(format);
    }


    public boolean validateCity(String city) {
        String format = "^[A-Za-z\\s'-]+$";
        return city.matches(format);
    }


    public boolean validateZipCode(String zipCode) {
        String format = "^[0-9]+$";
        return zipCode.matches(format);
    }


    public boolean validateCardNumber(String cardNumber) {
        String format = "^[0-9]+$";
        return cardNumber.matches(format);
    }


    public boolean validateCVV(String CVV) {
        String format = "^[0-9]+$";
        return CVV.matches(format);
    }


    /*Show an error message*/
    private void showErrorDialog(String message) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Error");
        dialog.setHeaderText(null);
        dialog.setContentText(message);

        //Add an "OK" button to the dialog
        ButtonType okButton = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(okButton);
        dialog.initOwner(stage);
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.showAndWait();//Show the dialog non-blocking
    }


    /*to generate random numbers*/
    public String confirmNumGenerator() {
        Random random = new Random();
        StringBuilder confirmationNumber = new StringBuilder(10);

        for (int i = 0; i < 10; i++) {
            confirmationNumber.append(random.nextInt(10));
        }

        return confirmationNumber.toString();
    }

    /*To save form*/
    public boolean saveFormData() {
        //save all the fields inputs to the variables in Form class
        Form formData = new Form();
        formData.setFname(First_Name_Field.getText());
        formData.setLname(Last_Name_Field.getText());
        formData.setDob(dobPicker.getValue());

        formData.setHouseNumber(houseNumberField.getText());
        formData.setStreet(streetField.getText());
        formData.setCity(cityField.getText());

        formData.setZipcode(zipcodeField.getText());
        formData.setReasons(reasonsField.getText());
        formData.setCardNumber(cardNumberField.getText());

        formData.setCvv(cvvField.getText());
        formData.setExpiration(expirationField.getText());

        // Define the directory and file name where formData will be saved
        saveFile = new File("/Users/phattran/IdeaProjects/demo/src/main/java/com/example/demo/saving_form.ser");

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(saveFile))) {
            outputStream.writeObject(formData);//save the formData
        } 
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }


    /*To resume filing*/
    private void loadSavedFormData() {
        //open up the saving_form.ser
        saveFile = new File("/Users/phattran/IdeaProjects/demo/src/main/java/com/example/demo/saving_form.ser");
        if (saveFile.exists()) { //true if there is a file
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(saveFile))) {
                
                Form savedData = (Form) inputStream.readObject();
                
                First_Name_Field.setText(savedData.getFname());
                Last_Name_Field.setText(savedData.getLname());
                dobPicker.setValue(savedData.getDob());

                houseNumberField.setText(savedData.getHouseNumber());
                streetField.setText(savedData.getStreet());
                cityField.setText(savedData.getCity());

                zipcodeField.setText(savedData.getZipcode());  
                reasonsField.setText(savedData.getReasons());   
                cardNumberField.setText(savedData.getCardNumber());

                cvvField.setText(savedData.getCvv());
                expirationField.setText(savedData.getExpiration());

            } 
            catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            finally {
                // Delete the saved_form_data.ser file to clear the data
                saveFile.delete();
            }
        }
    }


   
    //help to validate. Called by submit button
    public boolean validation(){
        boolean valid = true;
        
        //Input Validation
        if (!validateFname(First_Name_Field.getText())) {
            showErrorDialog("Invalid First Name! First Name can't have numbers");
            valid = false; //Set the flag to false
        }

        if (!validateLname(Last_Name_Field.getText())) {
            showErrorDialog("Invalid Last Name! Last Name can't have numbers.");
            valid = false;
        }

        if (!validateHouseNumber(houseNumberField.getText())) {
            showErrorDialog("Invalid House Number! House Number can't have letters.");
            valid = false;
        }

        if (!validateStreet(streetField.getText())) {
            showErrorDialog("Invalid Street Name! Street Name can't have numbers.");
            valid = false;
        }

        if (!validateCity(cityField.getText())) {
            showErrorDialog("Invalid City Name! City Name can't have numbers.");
            valid = false;
        }

        if (!validateZipCode(zipcodeField.getText())) {
            showErrorDialog("Invalid Zip Code! Zip Code can't have letters.");
            valid = false;
        }

        if (!validateCardNumber(cardNumberField.getText())) {
            showErrorDialog("Invalid Card Number! Card Number can't have letters.");
            valid = false;
        }

        if (!validateCVV(cvvField.getText())) {
            showErrorDialog("Invalid CVV! CVV can't have letters.");
            valid = false;
        }

        //Passed all validations, valid = true
        if (valid) {
            return true;
            
        }
        return false;
    }


    /*Form Screen*/
    private void showGreenCardApplicationScreen() {
        VBox layout = new VBox(10);
        Scene scene = new Scene(layout, 500, 500);

        stage.setTitle("Apply for Green Card replacement");


        First_Name_Field = new TextField();
        Last_Name_Field = new TextField();
        houseNumberField = new TextField();

        streetField = new TextField();
        cityField = new TextField();
        zipcodeField = new TextField();
    
    
        cardNumberField = new TextField();
        cvvField = new TextField();
        expirationField = new TextField();

        reasonsField = new TextArea();
        dobPicker = new DatePicker();

        uploadButton = new Button("Upload Documents");
        payButton = new Button("Pay");
        saveButton = new Button("Save");
        submitButton = new Button("Submit");

        

        //This is the form layout
        VBox form = new VBox(
                new Label("First Name:"), First_Name_Field,
                new Label("Last Name: "), Last_Name_Field,
                new Label("Date of Birth:"), dobPicker,
                new Label("House Number:"), houseNumberField,
                new Label("Street:"), streetField,
                new Label("City:"), cityField,
                new Label("Zipcode:"), zipcodeField,
                new Label("Reasons for Request:"), reasonsField,
                new Label("Upload Document:"), uploadButton,
                new Label("Payment Information:"),
                new Label("Card Number:"), cardNumberField,
                new Label("CVV:"), cvvField,
                new Label("Expiration Date:"), expirationField,
                payButton,
                saveButton,
                submitButton
        );


        //load saved form if available
        loadSavedFormData();

        //when the upload button is clicked, it will have access to user's directory
        FileChooser fileChooser = new FileChooser();
        uploadButton.setOnAction(e -> {
            File selectedFile = fileChooser.showOpenDialog(stage);
            if (selectedFile != null) {
                System.out.println("Selected File: " + selectedFile.getName());
            }
        });


        //set action for saveButton
        saveButton.setOnAction(e -> saveFormData());


        //set action for submitButton
        //submit button will validate the input format
        //before submit the form (saving the form to Form then signal Approval Stage) 
        submitButton.setOnAction(e -> {
            
            
            if(validation()){
                //save form to database
                if(saveFormData()){
                    //Generate a random confirmation number
                    //And takes the user to the confirmation screen
                    showConfirmScreen(confirmNumGenerator());
                }
                
            }
        
        });


        //create the scroll
        ScrollPane scrollPane = new ScrollPane(form);
        layout.getChildren().addAll(scrollPane);

        stage.setScene(scene);
    }


    /*Confirmation Screen*/
    private void showConfirmScreen(String confirmationNumber) {
        VBox confirmationLayout = new VBox(10);
        Scene confirmationScene = new Scene(confirmationLayout, 500, 500);
        
        stage.setTitle("Confirmation");
        Text confirmText = new Text("\t\t\tThank You!\nYou have submitted an application.");
        Text confirmNumber = new Text("Your confirmation number is: " + confirmationNumber);
        Button okButton = new Button("OK");

        
        okButton.setOnAction(e -> transition());

        confirmationLayout.getChildren().addAll(confirmText, confirmNumber, okButton);
        confirmationLayout.setAlignment(Pos.CENTER);

        stage.setScene(confirmationScene);

    }

    /*Transition to Approval Stage*/
    public ApproverGUI transition(){
        ApproverGUI object = new ApproverGUI();

        //transition to Approver Stage
        try{
            object.start(stage);
            
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            return null;
           
        }
        return object;
    }



    /*Start Screen*/
    @Override
    public void start(Stage primaryStage) {
        //10 pixel gap between fields
        VBox layout = new VBox(10);
        Scene scene = new Scene(layout, 500, 500);

        TextField username = new TextField();
        TextField password = new TextField();

        Button loginButton = new Button("Log In");

        VBox loginScreen = new VBox(
                        new Label("Usersname: "), username,
                        new Label("Password: "), password,
                        loginButton
    
        );
    
        //set action for login button
        loginButton.setOnAction(e -> {

            //default username and password
            if(username.getText().equals("applicant")){
                if(password.getText().equals("123")){

                    showGreenCardApplicationScreen();
        
        
                }
            }
        });

        //application title
        primaryStage.setTitle("Green Card Application");
        //Icon
        primaryStage.getIcons().add(new Image("file:/Users/phattran/IdeaProjects/demo/src/main/java/com/example/demo/eagle.jpeg"));

        stage = primaryStage;
    
        //setting up layout
        layout.getChildren().addAll(loginScreen);
        layout.setAlignment(Pos.CENTER);//to place loginScreen in the middle of the screen

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}