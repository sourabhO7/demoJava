package rowset.filteredrowset;

import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class GloLogisticsFilterRowSetOperation {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/glologisticsdb";
        String username = "root";
        String password = "test";

        RowSetFactory rowSetFactory = null;
        FilteredRowSet rowSet = null;

        try{
            rowSetFactory = RowSetProvider.newFactory();
            rowSet = rowSetFactory.createFilteredRowSet();

            // Set the connection properties
            rowSet.setUrl(url);
            rowSet.setUsername(username);
            rowSet.setPassword(password);

            // Set the command and query to read data
            rowSet.setCommand("SELECT * FROM supplier");

            // Execute the insert query
            rowSet.execute();

            rowSet.setFilter(new SupplierFilter());

            // Iterate over the filtered result set and retrieve data
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
