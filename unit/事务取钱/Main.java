package JDBC;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {
        try {
            drawMoney();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 事务取钱模型
     */
    public static void drawMoney() throws IOException {

        Connection connection = JdbcUtil.getConnection();
        PreparedStatement preparedStatement = null;
        try {

            connection.setAutoCommit(false);//关闭自动提交改为手动提交

            String sql = "update `user` set money=money+5 where `user`='小王'";//让小王的账户多5元
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

            String sql1 = "update bank set `count` = `count`-5 where `name`='小王'";//让小王的银行少5元
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();

            connection.commit();// 提交修改
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.closeResource(preparedStatement);
            JdbcUtil.closeResource(connection);
        }


    }

}

