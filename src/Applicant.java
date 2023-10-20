/**
 * This is the class repsonsible to handle the Applicant objection.
 */
public class Applicant extends User {

    /**
     * Name variable.
     */
    private String name;

    /**
     * Setter for the name.
     */
    @Override
    public void setName(String name){
        this.name = name;
    }

    /**
     * Getter for the name.
     */
    @Override
    public String getName(){
        return this.name;
    }

    /**
     * This is the LoadWF method.
     * @return the DataEnty object
     */
    public DataEntry LoadWF(){
        return null;
    }

}
