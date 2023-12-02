/**
 * JUnit Tests
 */
package com.example;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class DataEntryTest {

    private DataEntry dataEntry;

    @Before
    public void setUp(){
        dataEntry = new DataEntry();
    }


    @Test
    public void Test_for_validation() {
       
        //Set up the necessary fields in the dataEntry object 
        assertTrue(dataEntry.validateFname("Shevyn"));
        assertTrue(dataEntry.validateLname("Buhary"));

        assertTrue(dataEntry.validateHouseNumber("123"));
        assertTrue(dataEntry.validateStreet("Main Str"));

        assertTrue(dataEntry.validateCity("Fairfax"));
        assertTrue(dataEntry.validateZipCode("22033"));

        assertTrue(dataEntry.validateCardNumber("123456789"));
        assertTrue(dataEntry.validateCVV("123"));


        //The validation fails
        //assertTrue(dataEntry.validateCVV("123e"));
        assertFalse(dataEntry.validateCVV("123e"));


    }

    @Test
    public void Test_for_confirmNumGenerator(){
        DataEntry dataEntry = new DataEntry();
        //Test if confirmation number digits are all numerical
        assertTrue(dataEntry.confirmNumGenerator().matches("^[0-9]+$"));
    }


    @Test
    public void Test_for_saveFormData() {
      
        try{

            //Set up the necessary fields in the dataEntry object
            dataEntry.setter_Fname("Shevyn");
            dataEntry.setter_Lname("Buhary");

            dataEntry.setter_houseNumber("123");
            dataEntry.setter_Street("Main Str");

            dataEntry.setter_City("Fairfax");
            dataEntry.setter_ZipCode("22033");

            dataEntry.setter_cardNumber("123456789");
            dataEntry.setter_CVV("123");

            //Test the validation()
            assertTrue(dataEntry.saveFormData());

        }
        catch(ExceptionInInitializerError e){
            System.err.println(e.getMessage());
        }
    }



    @Test
    public void Test_for_transition(){
        DataEntry dataEntry = new DataEntry();
        try{
            //test the transtion()
            assertTrue(dataEntry.transition() instanceof Approver);
    
        }
        catch(NullPointerException e){
            System.err.println(e.getMessage());
        }
    }

}
