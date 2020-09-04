import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;
public class DruidDemo {

    public static void main(String[] args) throws Exception{
        //1.加载配置文件
        Properties properties = new Properties();
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("application.properties");

        properties.load(is);
        //2.获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(properties);
        //3.获取连接
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
