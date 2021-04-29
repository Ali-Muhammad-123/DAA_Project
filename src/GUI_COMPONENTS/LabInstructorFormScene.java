package GUI_COMPONENTS;

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
        import Classes.*;

        import java.sql.SQLException;

public class LabInstructorFormScene extends Application {
    Database database = new Database();
    Lab_instructor lab_instructor;
    LabInstructorFormScene(Lab_instructor lab_instructor){
        this.lab_instructor = lab_instructor;
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


        Scene TeacherFormScene = new Scene(grid1, 700, 600);
        Text TeacherFormtitle = new Text("Teacher Form");
        TeacherFormtitle.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        grid1.setAlignment(Pos.TOP_CENTER);
        grid1.add(TeacherFormtitle, 0, 0, 2, 1);

        Label teacher_id = new Label("Teacher ID:");
        grid1.add(teacher_id, 0, 1);
        TextField teacher_idTextField = new TextField();
        grid1.add(teacher_idTextField, 1, 1);

        Label teacherName = new Label("Name:");
        grid1.add(teacherName, 0, 2);

        TextField teacherNameTextField = new TextField();
        grid1.add(teacherNameTextField, 1, 2);

        Label teacherQualification = new Label("Qualification:");
        grid1.add(teacherQualification, 0, 3);
        TextField teacherQualificationTextField = new TextField();
        grid1.add(teacherQualificationTextField, 1, 3);

        Label TeacherAge = new Label("Age:");
        grid1.add(TeacherAge, 0, 5);
        TextField TeacherAgeTextField = new TextField();
        grid1.add(TeacherAgeTextField, 1, 5);


        String[] genderchoices = {"Male" , "Female" , "Unspecified"};
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
        { TeacherMenu teacherMenu = new TeacherMenu();
            teacherMenu.start(primaryStage);
        });


        Button btn3 = new Button("Submit");
        HBox hbBtn3 = new HBox(10);
        hbBtn3.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn3.getChildren().add(btn3);
        grid1.add(hbBtn3, 2, 7);
        btn3.setOnAction(e ->
        {
            lab_instructor = new Lab_instructor(teacherNameTextField.getText() ,  choice[0]  ,teacherQualificationTextField.getText());
            try{
                lab_instructor.setID(Integer.parseInt(teacher_idTextField.getText()));
                lab_instructor.setAge(Integer.parseInt(TeacherAgeTextField.getText()));
            }
            catch (Exception ex){
                throw ex;
            }
            try {
                database.Insert_Teacher(lab_instructor.getID(),lab_instructor.getName(),lab_instructor.getGender(),lab_instructor.getAge(),lab_instructor.getQualification() , "TRUE");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            CourseFormScene3 courseFormScene = new CourseFormScene3();
            courseFormScene.start(primaryStage);
        } );

        primaryStage.setScene(TeacherFormScene);
    }
}
