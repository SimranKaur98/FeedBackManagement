package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class FeedBackDao {

    int tId;
    int sId;
    int farray[] = new int[5];
    String grade;

    String query;

    Connection con = null;

    PreparedStatement ps = null;

    ResultSet rs = null;

    public int feedBackInsert(FeedBack f) {

        tId = f.tId;
        sId = f.getsId();
        farray = f.getFb();
        query = "insert into fback values (?,?,?,?,?,?,?)";
        int j = 0;

        try {

            con = MySqlConnection.getConnection();

            ps = con.prepareStatement(query);

            ps.setInt(1, tId);

            ps.setInt(2, sId);

            ps.setInt(3, farray[0]);

            ps.setInt(4, farray[1]);

            ps.setInt(5, farray[2]);

            ps.setInt(6, farray[3]);

            ps.setInt(7, farray[4]);

            j = ps.executeUpdate();

            if (j > 0) {
                System.out.println("Data is saved");

            }
          

        } catch (Exception e) {
            System.out.println("FeedBackDao Exception : " + e);
        }

        return j;
    }

    public LinkedList cg(FeedBack f) {

        tId = f.gettId();

        query = "select avg(f1),avg(f2),avg(f3),avg(f4),avg(f5) from fback where t_id = ?;";

        LinkedList l = new LinkedList();

        try {
            con = MySqlConnection.getConnection();

            ps = con.prepareStatement(query);

            ps.setInt(1, tId);

            rs = ps.executeQuery();
            
            rs.next();

            float f1 = rs.getInt("avg(f1)");
            float f2 = rs.getInt("avg(f2)");
            float f3 = rs.getInt("avg(f3)");
            float f4 = rs.getInt("avg(f4)");
            float f5 = rs.getInt("avg(f5)");
            l.add(f1);
            l.add(f2);
            l.add(f3);
            l.add(f4);
            l.add(f5);

         

        } catch (Exception e) {
            System.out.println("FeedBackDao Exception : " + e);

        }
        return l;

    }

}
