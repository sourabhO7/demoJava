package preparedstatement;

import java.sql.*;

public class GloLogisticsReadPrepared {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/glologisticsdb";
        String username = "root";
        String password = "test";

        String readQuery = "SELECT * FROM supplier";

        Connection con = null;
        PreparedStatement preStmnt = null;

        try {
            //database connection
            con = DriverManager.getConnection(url, username, password);

            preStmnt = con.prepareStatement(readQuery);

            //read operation using prepared statement
            ResultSet resultSet = preStmnt.executeQuery();

            while (resultSet.next()) {
                String supId = resultSet.getString("supId");
                String supName = resultSet.getString("supName");
                String supType = resultSet.getString("supType");
                String supCity = resultSet.getString("supCity");
                String supEmail = resultSet.getString("supEmail");

                // Print or process the retrieved data
                System.out.println("Supplier ID: " + supId);
                System.out.println("Supplier Name: " + supName);
                System.out.println("Supplier Type: " + supType);
                System.out.println("Supplier City: " + supCity);
                System.out.println("Supplier Email: " + supEmail);
                System.out.println("-------------------------");
            }
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
