package Classes;
import java.sql.*;

public class Database {
    String dbURL = "jdbc:oracle:thin:hr/hr@Ali-Muhammad:1521/orclpdb";
    Connection conn = null;
    public Database(){
        try {
            conn = DriverManager.getConnection(dbURL);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (conn != null) {
            System.out.println("Connected");
        }
    }

    public void Insert_Teacher(int ID, String Name, String Gender,int Age , String Qualification , String Lab_instructor) throws SQLException {
        Statement stmt=conn.createStatement();
        stmt.executeUpdate("insert into TEACHERS Values (" + ID + ",'" + Name.replace(" " , "_") + "','" + Gender + "'," +Age + ",'" +Qualification + ",'" +Lab_instructor + "' +)");
    }


    public void Insert_Courses_Teachers(int T_ID, int C_ID ) throws SQLException {
        Statement stmt=conn.createStatement();
        stmt.executeUpdate("insert into Teacher_Courses Values (" + T_ID + "," + C_ID + ")");
    }

    public void Insert_Courses_Students(int C_ID, int S_ID ) throws SQLException {
        Statement stmt=conn.createStatement();
        stmt.executeUpdate("insert into Student_Courses Values (" + C_ID+ "," + S_ID  + ")");
    }

    public void Insert_Student(int ID, String Name, String Gender,int Age , String Semester , String Programme) throws SQLException {
        Statement stmt=conn.createStatement();
        stmt.executeUpdate("insert into STUDENTS Values (" + ID + ",'" + Name + "','" + Gender + "'," +Age + ",'" +Semester +"','" + Programme + "')");
    }

    public void Insert_Course(int CourseId, String Course_name, int Credit_hours ) throws SQLException {
        Statement stmt=conn.createStatement();
        stmt.executeUpdate("insert into Courses Values (" + CourseId + ",'" + Course_name + "',"+ Credit_hours + ")");
    }

    public ResultSet Get_Students() throws SQLException {
        Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=stmt.executeQuery("select * from Students ORDER BY Student_ID");
        return  rs;
    }

    public ResultSet Get_Teachers() throws SQLException {
        Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=stmt.executeQuery("select * from Teachers ORDER BY Teacher_ID");
        return rs;
    }

    public ResultSet Get_Courses() throws SQLException {
        Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=stmt.executeQuery("select * from Courses ORDER BY Course_ID");
        return rs;
    }

    public ResultSet Get_TeachersCourses_Where(int Teacher_Id) throws SQLException {
        Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=stmt.executeQuery("select * from TEACHER_COURSES Where Teacher_id = " + Teacher_Id);
        return rs;
    }

    public ResultSet Get_Courses_Where(int Course_ID) throws SQLException{
        Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=stmt.executeQuery("select * from Courses Where Course_id = " + Course_ID);
        return rs;
    }

    public ResultSet Get_StudentsCourses_Where(int Student_id) throws SQLException {
        Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=stmt.executeQuery("select * from STUDENT_COURSES Where Student_id = " + Student_id);
        return rs;
    }

    public int Get_NumberOfCoursesStudent_Where(int Student_id) throws SQLException {
        Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=stmt.executeQuery("select * from STUDENT_COURSES Where Student_id = " + Student_id);
        int i = 0;
        while (rs.next()){
            i++;
        }
        return i;
    }

    public int Get_NumberOfCoursesTeachers_Where(int Teacher_Id) throws SQLException {
        Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        ResultSet rs=stmt.executeQuery("select * from TEACHER_COURSES Where Teacher_id = " + Teacher_Id);
        int i = 0;
        while (rs.next()){
            i++;
        }
        return i;
    }

    public void Delete_Teacher_Where(int Teacher_ID) throws SQLException {
        Statement stmt=conn.createStatement();
        stmt.executeUpdate("Delete From Teachers Where TEACHER_ID = "+ Teacher_ID + "");
    }

    public void Delete_Course_Where(int Course_ID) throws SQLException {
        Statement stmt=conn.createStatement();
        stmt.executeUpdate("Delete From Courses Where Course_ID = " + Course_ID + "");
    }

    public void Delete_Student_Where(int Student_ID) throws SQLException {
        Statement stmt=conn.createStatement();
        stmt.executeUpdate("Delete From Students Where STUDENT_ID = "+ Student_ID + "");
    }


}
