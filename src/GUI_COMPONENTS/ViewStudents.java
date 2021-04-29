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

public class ViewStudents extends Application  {
    Database database = new Database();
    ResultSet resultSet1 , resultSet2 , resultSet3;
    int counter=0;
    int rowcounter=2;
    ViewStudents( ){    }

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
        Text Viewtitle = new Text("Students Database");
        Viewtitle.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        Viewtitle.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Viewtitle, 3, 0, 1, 1);

        Text ID = new Text("Student's ID");
        ID.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        ID.setTextAlignment(TextAlignment.CENTER);
        grid3.add(ID, 0, 1);

        Text Name = new Text("Student's Name");
        Name.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Name.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Name, 1, 1);

        Text Gender = new Text("Student's Gender");
        Gender.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Gender.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Gender, 2, 1);

        Text Age = new Text("Student's Age");
        Age.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Age.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Age, 3, 1);


        Text Semester = new Text("Student's Semester");
        Semester.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Semester.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Semester, 4, 1);

        Text Programme = new Text("Student's Programme");
        Programme.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Programme.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Programme, 5, 1);

        Text Coursesopted = new Text("Student's Courses");
        Coursesopted.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Coursesopted.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Coursesopted, 6, 1);



        Button Back1 = new Button("Back");
        HBox Backbtn1 = new HBox(10);
        Backbtn1.setAlignment(Pos.CENTER);
        Backbtn1.getChildren().add(Back1);
        Back1.setOnAction(e -> {
            StudentMenu studentMenu = new StudentMenu();
            studentMenu.start(primaryStage);
                }
        );

        grid3.add(Backbtn1, 1, 23);


            try {
                resultSet1 = database.Get_Students();
                Text[] fields = new Text[100];
                while (resultSet1.next()) {
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
                    fields[counter] = new Text(resultSet1.getString(6));
                    grid3.add(fields[counter], 5, rowcounter);
                    counter++;
                    resultSet2 = database.Get_StudentsCourses_Where(resultSet1.getInt(1));
                    while (resultSet2.next()){
                        resultSet3 = database.Get_Courses_Where(resultSet2.getInt(1));
                        resultSet3.next();
                            fields[counter] = new Text(resultSet3.getString(2));
                            grid3.add(fields[counter], 6, rowcounter++);
                            counter++;
                    }
                }

            } catch (Exception exep) {
                exep.printStackTrace();
            }

    primaryStage.setScene(ViewStudents);
    }
}