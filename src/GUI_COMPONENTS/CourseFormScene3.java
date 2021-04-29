package GUI_COMPONENTS;

import Classes.Database;
import Classes.Lab_instructor;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Classes.Courses;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseFormScene3 extends Application {

    Lab_instructor lab_instructor;
    ResultSet resultSet;
    Database database;

    CourseFormScene3(){}


    public static void main(String[] args) {
        launch(args);
    }



    public void start(Stage primaryStage) {
        Courses courses[] = new Courses[50];
        int i = 0 ;
        try {
            resultSet = database.Get_Courses();

            while (resultSet.next()){
                courses[i] = new Courses(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
                i++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Courses SelectedCourses[] = new Courses[i];

        GridPane grid4 = new GridPane();
        grid4.setAlignment(Pos.CENTER);
        grid4.setHgap(10);
        grid4.setVgap(10);
        grid4.setPadding(new Insets(25, 25, 25, 25));


        Scene Courses = new Scene(grid4, 900, 600);
        Text Courseinfotitle = new Text("Course Form");
        Courseinfotitle.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        grid4.setAlignment(Pos.TOP_CENTER);
        grid4.add(Courseinfotitle, 0, 0, 2, 1);

        Text Instructions = new Text("Select the courses that The Lab instructor would would be teaching (max 1)  :");
        grid4.add(Instructions, 0, 1);

        RadioButton[] coursebuttons = new RadioButton[i];
        i=0;
        try {
            resultSet = database.Get_Courses();

            while (resultSet.next()){
                coursebuttons[i] = new RadioButton(resultSet.getString(2));
                grid4.add(coursebuttons[i], 0, i+2);
                i++;
                if (resultSet.next()) {
                    coursebuttons[i] = new RadioButton(resultSet.getString(2));
                    grid4.add(coursebuttons[i], 2, i+2);
                    i++;}
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Button CourseSubmit = new Button("Submit");
        HBox hbCourseSubmit = new HBox(10);
        hbCourseSubmit.setAlignment(Pos.BOTTOM_RIGHT);
        hbCourseSubmit.getChildren().add(CourseSubmit);
        grid4.add(CourseSubmit, 2, 7);


        int finalI = i;
        CourseSubmit.setOnAction(e ->
        {
            for (int j = 0; j< finalI; j++){
                if (coursebuttons[j].isSelected()){
                    SelectedCourses[j] = courses[j];
                }
            }
            try{
                lab_instructor.Assign_Courses(SelectedCourses);}
            catch (Exception ex){
                throw ex;
            }
            try{
                for (Courses Course: lab_instructor.getCourses()) {
                    database.Insert_Courses_Teachers(lab_instructor.getID() , Course.getCourse_ID());
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }

            TeacherMenu teacherMenu = new TeacherMenu();
            teacherMenu.start(primaryStage);
        });

        primaryStage.setScene(Courses);
    }
}