package rowset.jdbcrowset;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class GloLogisticsJdbcRowSetUpdate {
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
