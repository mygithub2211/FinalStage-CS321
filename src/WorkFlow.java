/**
 * @author Shevyn Buhary
 * This a class that represents the main WorkFlow object.
 */

public class WorkFlow {
    
    /**
     * A variable to represent the id.
     */
    private int id;

    /**
     * Variable to represent a user object.
     */
    private User nextUser;

    /**
     * This is a method that checks the id and returns as a string object who the id belongs to.
     * @param id - the id that we are checking.
     * @return a String object telling us whether we are dealing with "Applicant" or an "Approver".
     */
    public String checkID(int id){
        return "Approver";
    }

    /**
     * Setter for the id of the Workflow.
     * @param ID - the id that the WorkFlow object will have
     */
    public void setID(int ID){
        this.id = ID;
    }

    /**
     * Getter for the id of the WorkFlow object.
     * @return the ID for the WorkFlow object.
     */
    public int getID(){
        return this.id;
    }
    
    /**
     * This method assigns the next user.
     */
    public void assignedUser(){
        return;
    }
}
