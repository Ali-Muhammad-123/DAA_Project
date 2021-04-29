package GUI_COMPONENTS;

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


public class StudentFormScene extends Application {
    Student student1;
    Database database = new Database();
    StudentFormScene(Student student1){
        this.student1 = student1;
    }
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
        Text studentinfotitle = new Text("Student Form");
        studentinfotitle.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        grid1.setAlignment(Pos.TOP_CENTER);
        grid1.add(studentinfotitle, 0, 0, 2, 1);

        Label student_id = new Label("Student ID:");
        grid1.add(student_id, 0, 1);
        TextField student_idTextField = new TextField();
        grid1.add(student_idTextField, 1, 1);

        Label studentName = new Label("Name:");
        grid1.add(studentName, 0, 2);

        TextField studentNameTextField = new TextField();
        grid1.add(studentNameTextField, 1, 2);

        Label studentSemester = new Label("Semester:");
        grid1.add(studentSemester, 0, 3);
        TextField studentSemesterTextField = new TextField();
        grid1.add(studentSemesterTextField, 1, 3);

        Label studentProgramme = new Label("Programme:");
        grid1.add(studentProgramme, 0, 4);
        TextField studentProgrammeTextField = new TextField();
        grid1.add(studentProgrammeTextField, 1, 4);

        Label studentAge = new Label("Age:");
        grid1.add(studentAge, 0, 5);
        TextField studentAgeTextField = new TextField();
        grid1.add(studentAgeTextField, 1, 5);


        String[] genderchoices = {"Male" , "Female" , "Unspecifed"};
        String[] choice = new String[1];
        ChoiceBox Genderbox = new ChoiceBox(FXCollections.observableArrayList(genderchoices));

        Genderbox.getSelectionModel().selectedIndexProperty().addListener((ov, value, new_value) ->
                choice[0] = genderchoices[new_value.intValue()]);
        Label genderlabel = new Label("Gender:");
        grid1.add(genderlabel, 0, 6);
        grid1.add(Genderbox,1,6);

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
            student1 = new Student(studentNameTextField.getText() ,  choice[0]  ,studentSemesterTextField.getText(),studentProgrammeTextField.getText());
            try{
                student1.setID(Integer.parseInt(student_idTextField.getText()));
                student1.setAge( Integer.parseInt(studentAgeTextField.getText()));
            }
            catch (Exception ex){
                throw ex;
            }
            try {
                database.Insert_Student(student1.getID(),student1.getName(),student1.getGender(),student1.getAge(),student1.getSemester() , student1.getProgramme());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            CourseFormScene courseFormScene = new CourseFormScene(student1);
            courseFormScene.start(primaryStage);
        } );

        primaryStage.setScene(studentinfo);
    }}
