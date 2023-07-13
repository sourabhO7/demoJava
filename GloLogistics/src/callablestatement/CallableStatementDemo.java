package callablestatement;

import java.sql.*;

public class CallableStatementDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/glologisticsdb";
        String username = "root";
        String password = "test";

        String call = "{CALL get_supplier_count(?, ?)}";

        Connection con = null;
        CallableStatement callableStatement = null;

        try{
            con = DriverManager.getConnection(url, username, password);
            //create call
            callableStatement = con.prepareCall(call);

            //set input parameter
            callableStatement.setString(1, "Bangalore");

            //set output parameter
            callableStatement.registerOutParameter(2, Types.INTEGER);

            callableStatement.execute();

            //output of the statement
            int supplierCount = callableStatement.getInt(2);

            System.out.println("Supplier count in Bangalore: " + supplierCount);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}

