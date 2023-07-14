package rowset.jdbcrowset;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class GloLogisticsJdbcRowSetInsert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/glologisticsdb";
        String username = "root";
        String password = "test";

        RowSetFactory rowSetFactory = null;
        JdbcRowSet rowSet = null;

        try{
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

            // Move to the insert row
            rowSet.moveToInsertRow();

            // Set values for each column
            rowSet.updateString("supId", "S1001");
            rowSet.updateString("supName", "Rishi Suppliers");
            rowSet.updateString("supType", "Storage Devices");
            rowSet.updateString("supCity", "Delhi");
            rowSet.updateString("supEmail", "rishi@gmail.com");

            // Insert the new row
            rowSet.insertRow();

            rowSet.moveToCurrentRow();

            System.out.println("Supplier created successfully.");

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
