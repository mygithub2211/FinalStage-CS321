import java.io.Serializable;
import java.time.LocalDate;

/*The data will be saved here*/
public class Form implements Serializable {
    private String fname;
    private String lname;
    private LocalDate dob;
    private String houseNumber;
    private String street;
    private String city;
    private String zipcode;
    private String reasons;
    private String cardNumber;
    private String cvv;
    private String expiration;

    //ALL SETTERS
    public void setFname(String first_name){
        fname = first_name;
    }

    public void setLname(String last_name){
        lname = last_name;
    }

    public void setDob(LocalDate date_of_birth){
        dob = date_of_birth;
    }

    public void setHouseNumber(String house_number){
        houseNumber = house_number;
    }

    public void setStreet(String street_name){
        street = street_name;
    }

    public void setCity(String city_name){
        city = city_name;
    }

    public void setZipcode(String zip_code){
        zipcode = zip_code;
    }

    public void setReasons(String reason){
        reasons = reason;
    }

    public void setCardNumber(String card_number){
        cardNumber = card_number;
    }

    public void setCvv(String CVV){
        cvv = CVV;
    }

    public void setExpiration(String Expiration){
        expiration = Expiration;
    }


    //ALL GETTERS
    public String getFname(){
        return fname;
    }

    public String getLname(){
        return lname;
    }

    public LocalDate getDob(){
        return dob;
    }

    public String getHouseNumber(){
        return houseNumber;
    }

    public String getStreet(){
        return street;
    }

    public String getCity(){
        return city;
    }

    public String getZipcode(){
        return zipcode;
    }

    public String getReasons(){
        return reasons;
    }

    public String getCardNumber(){
        return cardNumber;
    }

    public String getCvv(){
        return cvv;
    }

    public String getExpiration(){
        return expiration;
    }

}