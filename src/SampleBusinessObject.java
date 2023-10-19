public class SampleBusinessObject{

    private int id;

    private SampleBusinessObject(int ID){
        setID(ID);
    }

    public static SampleBusinessObject createBO(int ID){
        return new SampleBusinessObject(ID);
    }
    private void setID(int ID){
        this.id = ID;
    }
    public int getID(){
        return this.id;
    }
}
