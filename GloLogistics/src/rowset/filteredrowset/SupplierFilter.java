package rowset.filteredrowset;

import javax.sql.RowSet;
import javax.sql.rowset.Predicate;
import java.sql.SQLException;

public class SupplierFilter implements Predicate {
    @Override
    public boolean evaluate(RowSet rs) {
        try {
            String supType = rs.getString("supType");
            return supType != null && supType.equals("Manufacturer"); // Filter criteria
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean evaluate(Object value, int column) throws SQLException {
        return false;
    }

    @Override
    public boolean evaluate(Object value, String columnName) throws SQLException {
        return false;
    }
}
