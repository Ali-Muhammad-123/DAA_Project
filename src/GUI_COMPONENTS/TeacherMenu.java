package GUI_COMPONENTS;

import Classes.Lab_instructor;
import Classes.Teacher;
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


public class TeacherMenu extends Application {
    Teacher teacher;
    Lab_instructor lab_instructor;
    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage primaryStage) {


        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25, 25, 25, 25));

        Scene TeacherMenu = new Scene(grid2, 600, 550);
        Text MenuTitle = new Text("Teacher Menu");
        MenuTitle.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        MenuTitle.setTextAlignment(TextAlignment.CENTER);
        grid2.add(MenuTitle, 0, 0, 2, 1);

        Button Menu1 = new Button("Hire New Teacher");
        HBox MenuBtn1 = new HBox(10);
        MenuBtn1.setAlignment(Pos.CENTER);
        MenuBtn1.getChildren().add(Menu1);
        grid2.add(MenuBtn1, 0, 1);

        Button Menu4 = new Button("Hire new Lab Instructor");
        HBox MenuBtn4 = new HBox(10);
        MenuBtn4.setAlignment(Pos.CENTER);
        MenuBtn4.getChildren().add(Menu4);
        grid2.add(MenuBtn4, 1, 1);

        Button Menu2 = new Button("View Teachers' info");
        HBox MenuBtn2 = new HBox(10);
        MenuBtn2.setAlignment(Pos.CENTER);
        MenuBtn2.getChildren().add(Menu2);
        grid2.add(MenuBtn2, 0, 2);

        Button Menu3 = new Button("Generate Payroll");
        HBox MenuBtn3 = new HBox(10);
        MenuBtn3.setAlignment(Pos.CENTER);
        MenuBtn3.getChildren().add(Menu3);
        grid2.add(MenuBtn3, 1, 2);

        Button Menu5 = new Button("Remove Teacher");
        HBox MenuBtn5 = new HBox(10);
        MenuBtn5.setAlignment(Pos.CENTER);
        MenuBtn5.getChildren().add(Menu5);
        grid2.add(MenuBtn5, 0, 3 , 2,1);



        Button Back = new Button("Back");
        HBox Backbtn = new HBox(10);
        Backbtn.setAlignment(Pos.CENTER);
        Backbtn.getChildren().add(Back);
        grid2.add(Backbtn, 0, 4 , 2 ,2);

        Back.setOnAction(e ->
        { MainMenuScene mainMenuScene = new MainMenuScene();
            mainMenuScene.start(primaryStage);
        });


        Menu1.setOnAction(e ->{
            TeacherFormScene teacherFormScene = new TeacherFormScene(teacher);
            teacherFormScene.start(primaryStage);
        });
        Menu2.setOnAction(e ->{
            ViewTeachers viewTeachers = new ViewTeachers();
            viewTeachers.start(primaryStage);

        });
        Menu3.setOnAction(e ->{
            TeacherSalaryScene teacherSalaryScene = new TeacherSalaryScene();
            teacherSalaryScene.start(primaryStage);
        });

        Menu5.setOnAction(e ->{
            DeleteTeachers deleteTeachers = new DeleteTeachers();
            deleteTeachers.start(primaryStage);
        });


        Menu4.setOnAction(e ->{
            LabInstructorFormScene labInstructorFormScene = new LabInstructorFormScene(lab_instructor);
            labInstructorFormScene.start(primaryStage);
        });



        primaryStage.setScene(TeacherMenu);
    }
}
