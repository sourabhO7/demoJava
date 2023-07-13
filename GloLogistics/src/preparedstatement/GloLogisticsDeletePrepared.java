package preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GloLogisticsDeletePrepared {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/glologisticsdb";
        String username = "root";
        String password = "test";

        String deleteQuery = "DELETE FROM supplier WHERE supId = ?";

        Connection con = null;
        PreparedStatement preStmnt = null;

        try {
            //database connection
            con = DriverManager.getConnection(url, username, password);

            //prepared statement update operation
            preStmnt = con.prepareStatement(deleteQuery);

            preStmnt.setString(1,"S101");

            int rowsAffected = preStmnt.executeUpdate();

            if(rowsAffected>0)
                System.out.println("Data deleted succesfully: "+rowsAffected);
            else
                System.out.println("Data deletion failed: "+rowsAffected);

        }catch (SQLException e){
            System.out.println(e);
        }finally {
            try {
                if(con!=null && preStmnt!=null) {
                    con.close();
                    preStmnt.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
