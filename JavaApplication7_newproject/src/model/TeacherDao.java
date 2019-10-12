package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class TeacherDao {

    

    
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //===========================================================================================================
    //                                      SIGN UP
    //===========================================================================================================
    public int signUp(Teacher t){
        String user;
    String password;
    int id ;
    String name;
    String subject;

        user = t.getUser();
        password = t.getPassword();
        id = t.getId();
        name = t.getName();
        subject = t.getSubject();

        String query = "insert into teacher values (?,?,?,?,?)";
        int i = 0;
        try {

            con = MySqlConnection.getConnection();

            ps = con.prepareStatement(query);

            ps.setString(1, user);

            ps.setString(2, password);

            ps.setInt(3, id);

            ps.setString(4, name);

            ps.setString(5, subject);

            i = ps.executeUpdate();

            if (i > 0) {

                System.out.println("Account is created.");
            }
            
         

        }
        catch (Exception e) {
            System.out.println("Teacher Dao Exception : Account can't be created. " + e);
        }
        return i;
    }

    //===========================================================================================================
    //                                      LOGIN
    //===========================================================================================================
    public LinkedList<Teacher> logInTeacher(Teacher t) {
        String user;
    String password;
    int id ;
    String name;
    String subject;
        LinkedList<Teacher> l = new LinkedList<>();

        user = t.getUser();

        password = t.getPassword();
        System.out.println(user +"\n"+password);

        String query = "select id,name,subject from teacher where user = ? && password = ?;";
        
        try {

            con = MySqlConnection.getConnection();
            
             

            ps = con.prepareStatement(query);
            
            ps.setString(1, user);

            ps.setString(2, password);
            
            System.out.println(ps);
            
            rs = ps.executeQuery();
        
            while(rs.next()){
              
            t.id = rs.getInt("id");

            t.name = rs.getString("name");

           t.subject = rs.getString("subject");
            
            l.add(new Teacher(user,password,t.id,t.name,t.subject));
           
          System.out.println(t.id+t.name+t.subject); 
          System.out.println("login teacher end...."+l); 
            }
            return l;
        } 
        catch (Exception e) {
            System.out.println("Teacher Dao Exception : " + e);

        }
        System.out.println("returning l ie :"+l); 
        return l;
    }

//===========================================================================================================
    //                                      UPDATE PASSWORD
    //===========================================================================================================
    public void updatePassword(Teacher t) {
        String user;
    String password;
    int id = 0;
    String name;
    String subject;

        password = t.getPassword();

        String query = "update teacher set password = '?'";

        try {

            con = MySqlConnection.getConnection();

            ps = con.prepareStatement(query);

            int i = ps.executeUpdate();

            if (i > 0) {
                System.out.println("Password is updated.");
            }
        } catch (Exception e) {

            System.out.println("Teacher Dao Exception : " + e);

        }
    }

    //===========================================================================================================
    //                                      DELETE ACCOUNT
    //===========================================================================================================
    public void deleteAccount(Teacher t) {
        String user;
    String password;
    int id = 0;
    String name;
    String subject;

        user = t.getUser();

        String query = "delete from teacher where user = '?'";

        try {

            con = MySqlConnection.getConnection();

            ps = con.prepareStatement(query);

            int i = ps.executeUpdate();

            if (i > 0) {
                System.out.println("Account is deleted.");
            }
        } catch (Exception e) {

            System.out.println("Teacher Dao Exception : Account can't  be deleted." + e);

        }

    }

}
