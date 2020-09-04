package dataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidConnect {
    private static Properties properties = null;
    private static DataSource dataSource = null;
    private volatile static DruidConnect instance = null;
    private static Connection connection = null;

    private DruidConnect() {}

    static {
        try {
            properties = new Properties();
            InputStream inputStream = DruidConnect.class.getClassLoader().getResourceAsStream("application.properties");
            properties.load(inputStream);
            dataSource = createDataSource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取一个连接对象
     * @return DruidConnect
     */
    public static DruidConnect getInstance() {
        if (instance == null) {
            synchronized (DruidConnect.class) {
                if (instance == null) {
                    instance = new DruidConnect();
                }
            }
        }
        return instance;
    }

    /**
     * 加载数据源
     * @return DataSource
     */
    private static DataSource createDataSource() {
        if (dataSource == null) {
            try {
                dataSource = DruidDataSourceFactory.createDataSource(properties);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public Connection getConnection() {
        try {
            connection = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
