package GUI_COMPONENTS;

import Classes.Database;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.sql.ResultSet;

public class ViewTeachers extends Application  {
    Database database = new Database();
    ResultSet resultSet1 , resultSet2;
    int counter=0;
    int rowcounter=2;

    ViewTeachers( ){

    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        GridPane grid3 = new GridPane();
        grid3.setAlignment(Pos.CENTER);
        grid3.setHgap(10);
        grid3.setVgap(10);
        grid3.setPadding(new Insets(25, 25, 25, 25));

        Scene ViewStudents = new Scene(grid3, 1400, 800);
        Text Viewtitle = new Text("Teachers Database");
        Viewtitle.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        Viewtitle.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Viewtitle, 3, 0, 1, 1);

        Text ID = new Text("Teacher's ID");
        ID.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        ID.setTextAlignment(TextAlignment.CENTER);
        grid3.add(ID, 0, 1);

        Text Name = new Text("Teacher's Name");
        Name.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Name.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Name, 1, 1);

        Text Gender = new Text("Teacher's Gender");
        Gender.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Gender.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Gender, 2, 1);

        Text Age = new Text("Teacher's Age");
        Age.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Age.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Age, 3, 1);


        Text Semester = new Text("Teacher's Qualification");
        Semester.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Semester.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Semester, 4, 1);


        Text Coursesopted = new Text("Teacher's Courses");
        Coursesopted.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Coursesopted.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Coursesopted, 5, 1);



        Button Back1 = new Button("Back");
        HBox Backbtn1 = new HBox(10);
        Backbtn1.setAlignment(Pos.CENTER);
        Backbtn1.getChildren().add(Back1);
        Back1.setOnAction(e ->
        { TeacherMenu teacherMenu = new TeacherMenu();
            teacherMenu.start(primaryStage);
        });

        grid3.add(Backbtn1, 1, 23);


            try {
                resultSet1 = database.Get_Teachers();
                Text[] fields = new Text[100];
                while (resultSet1.next()){
                    fields[counter] = new Text(resultSet1.getString(1));
                    grid3.add(fields[counter], 0, ++rowcounter);
                    counter++;
                    fields[counter] = new Text(resultSet1.getString(2));
                    grid3.add(fields[counter], 1, rowcounter);
                    counter++;
                    fields[counter] = new Text(resultSet1.getString(3));
                    grid3.add(fields[counter], 2, rowcounter);
                    counter++;
                    fields[counter] = new Text(resultSet1.getString(4));
                    grid3.add(fields[counter], 3, rowcounter);
                    counter++;
                    fields[counter] = new Text(resultSet1.getString(5));
                    grid3.add(fields[counter], 4, rowcounter);
                    counter++;
                    resultSet2 = database.Get_TeachersCourses_Where(resultSet1.getInt(1));
                    while (resultSet2.next()){
                            fields[counter] = new Text(database.Get_Courses_Where(resultSet2.getInt(1)).getString(2));
                            grid3.add(fields[counter], 5, rowcounter++);
                            counter++;

                    }
                    }

            } catch (Exception exep) {
                System.out.println(exep);
            }




        primaryStage.setScene(ViewStudents);
    }
}