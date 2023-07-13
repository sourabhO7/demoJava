package preparedstatement;

import java.sql.*;

public class GloLogisticsCreatePrepared {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/glologisticsdb";
        String username = "root";
        String password = "test";

        String insertQuery = "INSERT INTO supplier (supId, supName, supType, supCity, supEmail) VALUES (?, ?, ?, ?, ?)";

        Connection con = null;
        PreparedStatement preStmnt = null;

        try {
            //database connection
            con = DriverManager.getConnection(url, username, password);

            //prepared statement insert operation
            preStmnt = con.prepareStatement(insertQuery);

            preStmnt.setString(1, "S101");
            preStmnt.setString(2, "Sam Suppliers");
            preStmnt.setString(3, "Memory devices");
            preStmnt.setString(4, "Bangalore");
            preStmnt.setString(5, "sam@gmail.com");

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
