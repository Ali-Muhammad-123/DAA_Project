package GUI_COMPONENTS;

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

public class MainMenuScene extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage)  {



        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10);
        grid2.setVgap(10);
        grid2.setPadding(new Insets(25, 25, 25, 25));

        Scene MainMenuScene = new Scene(grid2, 600, 550);
        Text MenuTitle = new Text("Main Menu");
        MenuTitle.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        MenuTitle.setTextAlignment(TextAlignment.CENTER);
        grid2.add(MenuTitle, 0, 0, 2, 1);

        Button Menu1 = new Button("Student Menu");
        HBox MenuBtn1 = new HBox(10);
        MenuBtn1.setAlignment(Pos.CENTER);
        MenuBtn1.getChildren().add(Menu1);
        grid2.add(MenuBtn1, 0, 1);

        Button Menu2 = new Button("Teacher Menu");
        HBox MenuBtn2 = new HBox(10);
        MenuBtn2.setAlignment(Pos.CENTER);
        MenuBtn2.getChildren().add(Menu2);
        grid2.add(MenuBtn2, 1, 1);

        Button Menu3 = new Button("Course Menu");
        HBox MenuBtn3 = new HBox(10);
        MenuBtn3.setAlignment(Pos.CENTER);
        MenuBtn3.getChildren().add(Menu3);
        grid2.add(MenuBtn3, 0, 2,2,1);


        Menu1.setOnAction(e ->{
            StudentMenu studentMenu = new StudentMenu();
            studentMenu.start(primaryStage);
        });
        Menu2.setOnAction(e ->{
           TeacherMenu teacherMenu = new TeacherMenu();
           teacherMenu.start(primaryStage);
        });

        Menu3.setOnAction(e ->{
            CourseMenu courseMenu = new CourseMenu();
            courseMenu.start(primaryStage);
        });

        primaryStage.setScene(MainMenuScene);

    }
}
