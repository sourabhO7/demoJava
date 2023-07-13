package preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GloLogisticsUpdatePrepared {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/glologisticsdb";
        String username = "root";
        String password = "test";

        String updateQuery = "UPDATE supplier SET supName = ?, supType = ?, supCity = ?, supEmail = ? WHERE supId = ?";

        Connection con = null;
        PreparedStatement preStmnt = null;

        try {
            //database connection
            con = DriverManager.getConnection(url, username, password);

            //prepared statement update operation
            preStmnt = con.prepareStatement(updateQuery);

            preStmnt.setString(1, "Mike");
            preStmnt.setString(2, "Storage devices");
            preStmnt.setString(3, "Kolkata");
            preStmnt.setString(4, "mike@gmail.com");
            preStmnt.setString(5, "S101");

            int rowsAffected = preStmnt.executeUpdate();

            if(rowsAffected>0)
                System.out.println("Data inserted succesfully: "+rowsAffected);
            else
                System.out.println("Data insertion failed: "+rowsAffected);

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
