package statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GloLogisticsDelete {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/glologisticsdb";
        String username = "root";
        String password = "test";

        String updateQuery = "DELETE FROM supplier\n" +
                "WHERE supId = 'S101';\n";

        Connection con = null;
        Statement stmnt = null;

        try {
            //database connection
            con = DriverManager.getConnection(url, username, password);
            stmnt = con.createStatement();
            int rowsAffected = stmnt.executeUpdate(updateQuery);

            if(rowsAffected>0)
                System.out.println("Data deleted succesfully: "+rowsAffected);
            else
                System.out.println("Data deletion failed failed: "+rowsAffected);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (con != null && stmnt != null) {
                    con.close();
                    stmnt.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
