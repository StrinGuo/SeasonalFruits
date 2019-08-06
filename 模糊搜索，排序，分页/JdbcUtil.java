package unit18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {

    private static final JdbcUtil JDBC_UTIL = new JdbcUtil();

    private JdbcUtil() {

    }

    public static JdbcUtil getInstance() {
        return JDBC_UTIL;
    }


    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hw?characterEncoding=utf-8", "root", "980502");//characterEncoding=utf-8解决中文乱码
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeResource(AutoCloseable autoCloseable) {
        if (null != autoCloseable) {
            try {
                autoCloseable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
