package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class StudentDao {

    String query;

    FeedBackDao fbd = null;

    Connection con = null;

    PreparedStatement ps = null;

    ResultSet rs = null;

    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    public int signUpStudent(Student s) {
        int roll;
        int password;
        int id;
        String name;
        String program;
        String section;

        roll = s.getRoll();

        try {
            String q = "select roll from student where roll <> ?";

            con = MySqlConnection.getConnection();

            ps = con.prepareStatement(q);

            ps.setInt(1, roll);

            rs = ps.executeQuery();

            System.out.println("Loading...");

        } catch (Exception e) {

            System.out.println("Roll no. already exists." + e);
        }
        password = s.getPassword();
        id = s.getId();
        name = s.getName();
        program = s.getProgram();
        section = s.getSection();

        query = "insert into student values (?,?,?,?,?,?);";

        int i = 0;

        try {

            con = MySqlConnection.getConnection();

            ps = con.prepareStatement(query);

            ps.setInt(1, roll);

            ps.setInt(2, password);

            ps.setInt(3, id);

            ps.setString(4, name);

            ps.setString(5, program);

            ps.setString(6, section);

            i = ps.executeUpdate();

            if (i > 0) {

                System.out.println("Account is created.");
            }

        } catch (Exception e) {
            System.out.println("Student Dao Exception : Account can't be created. " + e);
        }
        return i;

    }

    //============================================================================================================================================
    //                                                             LOGIN
    //=============================================================================================================================================
    public LinkedList<Student> logInStudent(Student s) {
        int roll;
        int password;
        int id;
        String name;
        String program;
        String section;

        roll = s.getRoll();
        password = s.getPassword();

        query = "select id,name,program,section from student where roll = ? and password = ?";

        LinkedList<Student> al = new LinkedList<>();

        try {

            con = MySqlConnection.getConnection();

            ps = con.prepareStatement(query);

            ps.setInt(1, roll);

            ps.setInt(2, password);

            rs = ps.executeQuery(); // insert / update /delete

            while (rs.next()) {

                s.id = rs.getInt("id");
                s.name = rs.getString("name");
                s.program = rs.getString("program");
                s.section = rs.getString("section");
                System.out.println(rs.getInt("id"));
                al.add(new Student(roll, password, s.id, s.name, s.program, s.section));

            }

        } catch (Exception e) {
            System.out.println("Student Dao Exception : " + e);

        }
        return al;
    }

//==============================================================================================================================
    //                                      UPDATE PASSWORD
    //==========================================================================================================================
    public void updateStudentPassword(Student s) {
        int roll;
        int password;
        int id;
        String name;
        String program;
        String section;
        
        id = s.getId();

        password = s.getPassword();

        query = "update student set password = ? where id = ?";

        try {

            con = MySqlConnection.getConnection();

            ps = con.prepareStatement(query);

            ps.setInt(1, password);

            int i = ps.executeUpdate();

            if (i > 0) {
                System.out.println("Password is updated.");
            }

        } catch (Exception e) {

            System.out.println("Student Dao Exception : " + e);

        }
    }

    //===========================================================================================================
    //                                      DELETE ACCOUNT
    //===========================================================================================================
    public void deleteStudentAccount(Student s) {
        int roll;
        int password;
        int id;
        String name;
        String program;
        String section;

        roll = s.getRoll();

        query = "delete from student where roll = ?;";

        try {

            con = MySqlConnection.getConnection();

            ps = con.prepareStatement(query);

            int i = ps.executeUpdate();

            if (i > 0) {
                System.out.println("Account is deleted.");
            }
            con.close();
        } catch (Exception e) {

            System.out.println("Student Dao Exception : Account can't  be deleted." + e);

        }

    }

    public LinkedList<Student> viewStudent(Student s) {
        int roll;
        int password;
        int id;
        String name;
        String program;
        String section;

        id = s.getId();

        query = "select roll,password,id,name,program,section from student where id = ?";
        System.out.println("view student");

        LinkedList<Student> l = new LinkedList<>();

        try {

            con = MySqlConnection.getConnection();

            ps = con.prepareStatement(query);

            ps.setInt(1, id);

            rs = ps.executeQuery(); // insert / update /delete

            rs.next();
            roll = rs.getInt("roll");
            password = rs.getInt("password");
            id = rs.getInt("id");
            name = rs.getString("name");
            program = rs.getString("program");
            section = rs.getString("section");
            System.out.println(rs.getInt("id"));
            l.add(new Student(roll, password, id, name, program, section));
            return l;

        } catch (Exception e) {
            System.out.println("Student Dao Exception : " + e);

        }
        return l;

    }

}
