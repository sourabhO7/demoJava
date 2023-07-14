package rowset.joinrowset;

import javax.sql.rowset.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GloLogisticsJoinRowSetJoinOperation {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/glologisticsdb";
        String username = "root";
        String password = "test";

        RowSetFactory rowSetFactory = null;
        CachedRowSet supplierRowSet = null;
        CachedRowSet productsRowSet = null;
        Connection con = null;
        JoinRowSet joinRowSet = null;

        try {
            con = DriverManager.getConnection(url, username, password);
            con.setAutoCommit(false);
            rowSetFactory = RowSetProvider.newFactory();

            //supplier table data
            supplierRowSet = rowSetFactory.createCachedRowSet();
            supplierRowSet.setCommand("SELECT * FROM supplier");
            supplierRowSet.execute(con);

            //product table data
            productsRowSet =rowSetFactory.createCachedRowSet();
            productsRowSet.setCommand("SELECT * FROM products");
            productsRowSet.execute(con);

            //joined the data using one common column
            joinRowSet = rowSetFactory.createJoinRowSet();
            joinRowSet.addRowSet(supplierRowSet,1);
            joinRowSet.addRowSet(productsRowSet,4);

            // Iterate over the rows and retrieve data from the join result
            while (joinRowSet.next()) {
                String supId = joinRowSet.getString("supId");
                String supName = joinRowSet.getString("supName");
                String supType = joinRowSet.getString("supType");
                String supCity = joinRowSet.getString("supCity");
                String supEmail = joinRowSet.getString("supEmail");
                String productId = joinRowSet.getString("productId");
                String productName = joinRowSet.getString("productName");
                double price = joinRowSet.getDouble("price");

                // Process the retrieved data
                System.out.println("Supplier ID: " + supId);
                System.out.println("Supplier Name: " + supName);
                System.out.println("Supplier Type: " + supType);
                System.out.println("Supplier City: " + supCity);
                System.out.println("Supplier Email: " + supEmail);
                System.out.println("Product ID: " + productId);
                System.out.println("Product Name: " + productName);
                System.out.println("Product Price: " + price);
                System.out.println("-------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // Close the JoinRowSet, supplierRowSet, and productsRowSet in the finally block
            try {
                if (joinRowSet != null) {
                    joinRowSet.close();
                }
                if (supplierRowSet != null) {
                    supplierRowSet.close();
                }
                if (productsRowSet != null) {
                    productsRowSet.close();
                }
                if(joinRowSet != null){
                    joinRowSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
