package rowset.cachedrowset;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GloLogisticsCachedRowSetRead {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/glologisticsdb";
        String username = "root";
        String password = "test";

        RowSetFactory rowSetFactory = null;
        CachedRowSet rowSet = null;
        Connection con = null;

        try {
            con = DriverManager.getConnection(url, username, password);
            con.setAutoCommit(false);
            rowSetFactory = RowSetProvider.newFactory();
            rowSet = rowSetFactory.createCachedRowSet();

            // Set the command and query to read data
            rowSet.setCommand("SELECT * FROM supplier");

            // Execute the insert query
            rowSet.execute(con);

            // Iterate over the rows and retrieve data
            while (rowSet.next()) {
                String supId = rowSet.getString("supId");
                String supName = rowSet.getString("supName");
                String supType = rowSet.getString("supType");
                String supCity = rowSet.getString("supCity");
                String supEmail = rowSet.getString("supEmail");

                // Process the retrieved data
                System.out.println("Supplier ID: " + supId);
                System.out.println("Supplier Name: " + supName);
                System.out.println("Supplier Type: " + supType);
                System.out.println("Supplier City: " + supCity);
                System.out.println("Supplier Email: " + supEmail);
                System.out.println("-------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rowSet!=null){
                try {
                    rowSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
