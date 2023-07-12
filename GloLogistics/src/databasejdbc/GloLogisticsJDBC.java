package databasejdbc;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GloLogisticsJDBC {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/glologdb", "root", "test");
        connection.setAutoCommit(false);

        RowSetFactory rowSetFactory = RowSetProvider.newFactory();
        CachedRowSet cachedRowSet = rowSetFactory.createCachedRowSet();
        cachedRowSet.setCommand("SELECT * FROM supplier");
        cachedRowSet.execute(connection);

        addSupplier(cachedRowSet);
    }

    //supplier is added
    private static void addSupplier(CachedRowSet cachedRowSet) throws SQLException {
        cachedRowSet.moveToInsertRow();
        cachedRowSet.updateInt("id",3);
        cachedRowSet.updateString("name","bunny");
        cachedRowSet.updateString("category","hardware");
        cachedRowSet.updateString("location","kolkata");
        cachedRowSet.insertRow();

        cachedRowSet.moveToCurrentRow();

        cachedRowSet.acceptChanges();
        cachedRowSet.beforeFirst();

        showSupplier(cachedRowSet);
    }

    //fetching the supplier
    private static void showSupplier(CachedRowSet cachedRowSet) throws SQLException {
        while(cachedRowSet.next()){
            System.out.println(cachedRowSet.getInt(1)+"\t"+cachedRowSet.getString(2)+"\t"+cachedRowSet.getFloat(3)+"\t"+cachedRowSet.getString(4));
        }
    }
}
