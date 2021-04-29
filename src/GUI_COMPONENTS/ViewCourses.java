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

public class ViewCourses extends Application  {
    Database database = new Database();
    ResultSet resultSet1 , resultSet2 , resultSet3;
    int counter=0;
    int rowcounter=2;
    ViewCourses( ){    }

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
        Text Viewtitle = new Text("Courses Database");
        Viewtitle.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        Viewtitle.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Viewtitle, 0, 0, 3, 1);

        Text ID = new Text("Course ID");
        ID.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        ID.setTextAlignment(TextAlignment.CENTER);
        grid3.add(ID, 0, 1);

        Text Name = new Text("Course Name");
        Name.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Name.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Name, 1, 1);

        Text Gender = new Text("Credit Hours");
        Gender.setFont(Font.font("Verdana", FontWeight.NORMAL, 15));
        Gender.setTextAlignment(TextAlignment.CENTER);
        grid3.add(Gender, 2, 1);


        Button Back1 = new Button("Back");
        HBox Backbtn1 = new HBox(10);
        Backbtn1.setAlignment(Pos.CENTER);
        Backbtn1.getChildren().add(Back1);
        Back1.setOnAction(e -> {
                    CourseMenu courseMenu = new CourseMenu();
                    courseMenu.start(primaryStage);
                }
        );

        grid3.add(Backbtn1, 1, 23);


        try {
            resultSet1 = database.Get_Courses();
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
            }

        } catch (Exception exep) {
            exep.printStackTrace();
        }

        primaryStage.setScene(ViewStudents);
    }
}