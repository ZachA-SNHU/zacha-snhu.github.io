/*****************************
 * Name: Zachary Abbe
 * Class: CS320
 * Date: 04/12/2025
 * Desc: This contains the Task object containing the id, name and desc
 ****************************/



public class Task {

    private String uniqId;
    private String fullName;
    private String desc;

    // constructor for the object
    public Task(String Id, String name, String desc){
        setID(Id);
        setFullName(name);
        setDesc(desc);

    }

    //setters for the object
    private void setID(String id){
        if (id == null || id.isEmpty() || id.length() >10){
            throw new IllegalArgumentException("Invalid ID");
        }
        this.uniqId=id;
    }

    public void setFullName(String name){
        if (name==null || name.isEmpty() || name.length() > 20){

            throw new IllegalArgumentException("Invalid name");
        }
        this.fullName = name;
    }

    public void setDesc(String desc1) {
        if (desc1 == null || desc1.isEmpty() || desc1.length() > 50) {

            throw new IllegalArgumentException("Invalid desc");
        }
        this.desc = desc1;
    }
    //getters
    public String getUniqId(){
        return uniqId;
    }
    public String getFullName(){
        return fullName;
    }
    public String getDesc(){
        return desc;
    }

}
