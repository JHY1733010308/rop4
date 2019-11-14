package cn.itcast.until;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

//JDBC工具类
public class JDBCUntils {
    private static DataSource ds;

    static {
        try {

        //1.加载配置文件
        Properties pro = new Properties();
        InputStream is = JDBCUntils.class.getClassLoader().getResourceAsStream("driver.properties");

            pro.load(is);
            //2.出生连接池
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();

        }


    }


    //获取连接池对象
    public static DataSource getDataSource(){
        return ds;
    }
    //获取Connection
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
