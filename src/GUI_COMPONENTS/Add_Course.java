package GUI_COMPONENTS;

import Classes.Courses;
import Classes.Database;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Classes.Student;

import java.sql.SQLException;


public class Add_Course extends Application {
    Courses courses = new Courses();
    Database database = new Database();
    Add_Course(){ }
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage)  {
        GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.CENTER);
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.setPadding(new Insets(25, 25, 25, 25));


        Scene studentinfo = new Scene(grid1, 700, 600);
        Text studentinfotitle = new Text("Course Form");
        studentinfotitle.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        grid1.setAlignment(Pos.TOP_CENTER);
        grid1.add(studentinfotitle, 0, 0, 2, 1);

        Label student_id = new Label("Course ID:");
        grid1.add(student_id, 0, 1);
        TextField student_idTextField = new TextField();
        grid1.add(student_idTextField, 1, 1);

        Label studentName = new Label("Course Name:");
        grid1.add(studentName, 0, 2);

        TextField studentNameTextField = new TextField();
        grid1.add(studentNameTextField, 1, 2);

        Label Credit_Hours = new Label("Credit Hours:");
        grid1.add(Credit_Hours, 0, 3);
        TextField Credit_HoursTextField = new TextField();
        grid1.add(Credit_HoursTextField, 1, 3);


        Button Back = new Button("Back");
        HBox Backbtn = new HBox(10);
        Backbtn.setAlignment(Pos.CENTER);
        Backbtn.getChildren().add(Back);
        grid1.add(Backbtn, 0, 8);

        Back.setOnAction(e ->
        { StudentMenu studentMenu = new StudentMenu();
            studentMenu.start(primaryStage);
        });


        Button btn3 = new Button("Submit");
        HBox hbBtn3 = new HBox(10);
        hbBtn3.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn3.getChildren().add(btn3);
        grid1.add(hbBtn3, 2, 7);
        btn3.setOnAction(e ->
        {
            courses = new Courses(Integer.parseInt(student_idTextField.getText()),studentNameTextField.getText() , Integer.parseInt(Credit_HoursTextField.getText()));

            try {
                database.Insert_Course(courses.getCourse_ID(),courses.getCourse_Name(),courses.getCredit_Hours());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            MainMenuScene mainMenuScene = new MainMenuScene();
            mainMenuScene.start(primaryStage);
        } );

        primaryStage.setScene(studentinfo);
    }}
