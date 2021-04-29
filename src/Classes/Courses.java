package Classes;

import java.io.Serializable;

public class Courses implements Serializable {
    private int Course_ID;
    private String Course_Name;
    int Credit_Hours;

    public Courses(){}
    public Courses(int Course_ID, String Course_Name, int Credit_Hours) {
        this.Course_ID = Course_ID;
        this.Course_Name=Course_Name;
        this.Credit_Hours=Credit_Hours;
    }


    public int getCourse_ID() {
        return Course_ID;
    }

    public int getCredit_Hours() {
        return Credit_Hours;
    }

    public String getCourse_Name() {
        return Course_Name;
    }
}

