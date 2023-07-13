package basicoperation;

import java.sql.*;

public class GloLogisticsRead {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/glologisticsdb";
        String username = "root";
        String password = "test";

        String selectQuery = "SELECT * FROM supplier";

        Connection con = null;
        Statement stmnt = null;


        try {
            //database connection
            con = DriverManager.getConnection(url, username, password);
            stmnt = con.createStatement();
            ResultSet resultSet = stmnt.executeQuery(selectQuery);

            //read operation
            while (resultSet.next()) {
                System.out.println("supId: "+resultSet.getString(1)+"\t"+"supName: "+resultSet.getString(2)
                                    +"\t"+"supType: "+resultSet.getString(3)+"\t"+"supCity: "+resultSet.getString(4)
                                    +"\t"+"supEmail: "+resultSet.getString(5)
                );
            }
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
