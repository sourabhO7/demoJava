package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BasicJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/glologisticsdb";
        String username = "root";
        String password = "test";

        String insertQuery = "INSERT INTO supplier (supId, supName, supType, supCity, supEmail)\n" +
                    "VALUES ('S101', 'Sam Suppliers', 'Memory devices', 'Delhi', 'sam@gmail.com');\n";

        Connection con = null;
        Statement stmnt = null;

        try {
            //database connection
            con = DriverManager.getConnection(url, username, password);
            stmnt = con.createStatement();
            int rowsAffected = stmnt.executeUpdate(insertQuery);

            if(rowsAffected>0)
                System.out.println("Data inserted succesfully: "+rowsAffected);
            else
                System.out.println("Data insertion failed: "+rowsAffected);

            }catch (SQLException e){
                System.out.println(e);
            }finally {
                try {
                    if(con!=null && stmnt!=null) {
                        con.close();
                        stmnt.close();
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
    }
}
