package statement;

import java.sql.*;

public class GloLogisticsUpdate {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/glologisticsdb";
        String username = "root";
        String password = "test";

        String updateQuery = "UPDATE supplier\n" +
                "SET supName = 'Mike supplier',\n" +
                "    supType = 'Storage devices',\n" +
                "    supCity = 'Kolkata',\n" +
                "    supEmail = 'mike@gmail.com'\n" +
                "WHERE supId = 'S101';\n";

        Connection con = null;
        Statement stmnt = null;

        try {
            //database connection
            con = DriverManager.getConnection(url, username, password);
            stmnt = con.createStatement();
            int rowsAffected = stmnt.executeUpdate(updateQuery);

            if(rowsAffected>0)
                System.out.println("Data updated succesfully: "+rowsAffected);
            else
                System.out.println("Data update failed: "+rowsAffected);
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
