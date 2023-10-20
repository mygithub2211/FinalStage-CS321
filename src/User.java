public class User {

    private String name;
    private WorkFlow nextWorkFlow;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public WorkFlow loadWorkFlow(){
        return nextWorkFlow;
    }
    
}
