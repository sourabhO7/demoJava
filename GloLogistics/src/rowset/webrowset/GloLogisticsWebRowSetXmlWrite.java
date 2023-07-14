package rowset.webrowset;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;



public class GloLogisticsWebRowSetXmlWrite {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/glologisticsdb";
        String username = "root";
        String password = "test";

        RowSetFactory rowSetFactory = null;
        WebRowSet rowSet = null;

        try {
            rowSetFactory = RowSetProvider.newFactory();
            rowSet = rowSetFactory.createWebRowSet();

            // Set the connection properties
            rowSet.setUrl(url);
            rowSet.setUsername(username);
            rowSet.setPassword(password);

            // Set the command to retrieve data from the database table
            rowSet.setCommand("SELECT * FROM supplier");

            // Execute the query and populate the WebRowSet
            rowSet.execute();

            FileWriter fw = new FileWriter("/home/sourabh/Documents/supplier.xml");

            // Write the data to the XML file
            // the tag in the xml file under which the data will be currentRow tag
            rowSet.writeXml(fw);

            System.out.println("Data written to XML file successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the WebRowSet in the finally block
            if (rowSet != null) {
                try {
                    rowSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
