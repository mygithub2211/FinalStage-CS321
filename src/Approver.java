public class Approver extends User {

    private String name;

    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return this.name;
    }

    public DataEntry LoadWF(){
        return null;
    }
}
