package rowset.webrowset;

import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class GloLogisticsWebRowSetXmlReadWrite {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/glologisticsdb";
        String username = "root";
        String password = "test";

        RowSetFactory rowSetFactory = null;
        WebRowSet rowSet = null;
        Connection con = null;

        try{
            rowSetFactory = RowSetProvider.newFactory();
            rowSet = rowSetFactory.createWebRowSet();

            con = DriverManager.getConnection(url, username, password);
            con.setAutoCommit(false);
            rowSetFactory = RowSetProvider.newFactory();
            rowSet = rowSetFactory.createWebRowSet();

            // Set the command and query to read data
            rowSet.setCommand("SELECT * FROM supplier");

            // Execute the insert query
            rowSet.execute(con);

            //reading the data from the supplier xml file
            // modify the tag in the xml file and update it as insertRow
            FileReader fr = new FileReader("/home/sourabh/Documents/supplier.xml");
            rowSet.readXml(fr);

            //saving the data to the database
            rowSet.moveToCurrentRow();
            rowSet.acceptChanges();

            System.out.println("Suppier data stored in the database successfully!....");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
