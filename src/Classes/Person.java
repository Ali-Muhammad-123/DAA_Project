package Classes;

import java.io.Serializable;

abstract public class Person implements Serializable  {
    private String Name;
    private int ID;
    private String Gender;
    private int Age;

    Person(){}

    Person(String Name,String Gender){
        this.Name = Name;
        this.Gender = Gender; }

    public void setAge(int age) throws  IllegalArgumentException {
        if (age >17){
        this.Age = age;}
        else {
            throw new IllegalArgumentException("The age must be greater than 17");
        }
    }

    public void setID(int ID) throws ArithmeticException {
        if (String.valueOf(ID).length() < 4){
        this.ID = ID;}
        else {
            throw new ArithmeticException("The length of ID cannot exceed 4");
        }
    }


    abstract public void Assign_Courses(Courses[] course);
    abstract public int Count_Courses();


    public String getGender() {
        return Gender;
    }

    public String getName() {
        return Name;
    }

    public int getID() {
        return ID;
    }
    public int getAge() {
        return Age;
    }


}
