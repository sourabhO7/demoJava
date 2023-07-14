package rowset.cachedrowset;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GloLogisticsCachedRowSetDelete {
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

            // Move to the desired row for delete
            while (rowSet.next()) {
                if (rowSet.getString("supId").equals("S1001")) {
                    // Apply the updates
                    rowSet.deleteRow();
                    System.out.println("Supplier deleted successfully.");
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
