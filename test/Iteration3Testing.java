import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

/**
 * This is the testing class.
 * @author Group 23 (Phat Tran and Shevyn Buhary)
 */
public class Iteration3Testing{
    /**
     * Applicant test object.
     */
    private Applicant applicant;

    /**
     * Approver test object.
     */
    private Approver approver;

    /**
     * The Data Entry test object.
     */
    private DataEntry dataEntry;

    /**
     * Approval test object.
     */
    private Approval approval;

    /**
     * A variable to use as a WorkFlow test object.
     */
    WorkFlow workFlow;

    /**
     * Id variable that will be used to test throughout.
     */
    int workFlowId;


    //NOW TEST

    /**
     * This will test the WorkFlow name.
     */
    @Test
    public void testName(){
        
       applicant = new Applicant();
       approver = new Approver();
       
       //checking if name is not null
       assertNotNull(applicant.getName());
       assertNotNull(approver.getName());

       //checking if the name contains letters only
       assertTrue(applicant.getName().matches("^[a-zA-Z]*$"));
       assertTrue(approver.getName().matches("^[a-zA-Z]*$"));
        
    }

    /**
     * This method is used to test the LoadWF() method which loads next step to the work flow table.
     */
    @Test
    public void testWF(){
        
        dataEntry = new DataEntry();
        approval = new Approval();
        applicant = new Applicant();
        approver = new Approver();

        //test if LoadWF()returns DataEntry object
        assertEquals(applicant.LoadWF().getClass(), dataEntry.getClass());
        //test if LoadWF() returns Approval object
        assertEquals(approver.LoadWF().getClass(), approval.getClass());
        
    }

    /**
     * Testing method that will execute the tests for checkID method.
     */
    @Test
    void checkIDTests(){

        workFlowId = 123456;
        workFlow = new WorkFlow();
        workFlow.setID(workFlowId);
        assertEquals(workFlow.checkID(workFlowId), "Approver");

        workFlowId = 321567;
        workFlow = new WorkFlow();
        workFlow.setID(workFlowId);
        assertEquals(workFlow.checkID(workFlowId), "Applicant");

        workFlowId = 456789;
        workFlow = new WorkFlow();
        workFlow.setID(workFlowId);
        assertEquals(workFlow.checkID(workFlowId), "Approver");

        workFlowId = 123459;
        workFlow = new WorkFlow();
        workFlow.setID(workFlowId);
        assertEquals(workFlow.checkID(workFlowId), "Applicant");
        
    }

    /**
     * Testing method that will execute all of the tests for the getID() method.
     */
    @Test
    void getIDTests(){
        
        workFlow = new WorkFlow();
        workFlowId = 394797;
        workFlow.setID(workFlowId);
        assertEquals(workFlow.getID(), workFlowId);

        workFlow = new WorkFlow();
        workFlowId = 389727;
        workFlow.setID(workFlowId);
        assertEquals(workFlow.getID(), workFlowId);

        workFlow = new WorkFlow();
        workFlowId = 459082;
        workFlow.setID(workFlowId);
        assertEquals(workFlow.getID(), workFlowId);
        
    }
}
