import dataSource.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.KeyedHandler;

import java.sql.SQLException;
import java.util.Map;

public class app {
    public static void main(String[] args) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
            Map<String, Map<String, Object>> dataMap = queryRunner.query("select * from c_manually_lead_price", new KeyedHandler<String>());
            System.out.println(dataMap);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
