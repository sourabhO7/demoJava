package rowset.cachedrowset;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GloLogisticsCachedRowSetUpdate {
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

            // Move to the desired row for update
            while (rowSet.next()) {
                if (rowSet.getString("supId").equals("S1001")) {
                    // Update the desired columns
                    rowSet.updateString("supName", "Kailash");
                    rowSet.updateString("supType", "Stationary");
                    rowSet.updateString("supCity", "Kolkata");
                    rowSet.updateString("supEmail", "kailash@gmail.com");

                    // Apply the updates
                    rowSet.updateRow();
                    System.out.println("Supplier updated successfully.");
                    break;
                }
            }
            rowSet.moveToCurrentRow();
            rowSet.acceptChanges();
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
