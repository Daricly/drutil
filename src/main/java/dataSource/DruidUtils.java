package dataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class DruidUtils {
    private static Connection connection = null;

    public static DataSource getDataSource() {
        return DruidConnect.getInstance().getDataSource();
    }

    public static Connection getConnection() {
        return DruidConnect.getInstance().getConnection();
    }
}
