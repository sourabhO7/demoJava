package rowset.jdbcrowset;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class GloLogisticsJdbcRowSetDelete {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/glologisticsdb";
        String username = "root";
        String password = "test";

        RowSetFactory rowSetFactory = null;
        JdbcRowSet rowSet = null;

        try {
            rowSetFactory = RowSetProvider.newFactory();
            rowSet = rowSetFactory.createJdbcRowSet();

            // Set the connection properties
            rowSet.setUrl(url);
            rowSet.setUsername(username);
            rowSet.setPassword(password);

            // Set the command and query to read data
            rowSet.setCommand("SELECT * FROM supplier");

            // Execute the insert query
            rowSet.execute();

            // Find the desired row for deletion
            while (rowSet.next()) {
                if (rowSet.getString("supId").equals("S1001")) {
                    // Delete the current row
                    rowSet.deleteRow();
                    System.out.println("Supplier deleted successfully.");
                    break;
                }
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
