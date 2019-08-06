package unit18;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroOperator implements HeroOperatable {
    @Override
    public List<Hero> findAllHero() {
        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement = null;
        ResultSet rs = null;
        List<Hero> heroList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            String sql = "select * from hero";
            rs = statement.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt(1);
                String sno = rs.getString(2);
                String sname = rs.getString("sname");
                String ssex = rs.getString("ssex");
                int sage = rs.getInt(5);
                Hero hero = new Hero();
                hero.setId(id);
                hero.setSname(sname);
                hero.setSsex(ssex);
                hero.setSno(sno);
                hero.setSage(sage);
                heroList.add(hero);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return heroList;
    }

    @Override
    public List<Hero> indByUserNameLikeOrderLimit(String userName, int currPage, int pageSize) {
        Connection connection = JdbcUtil.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "select * from hero where sname like ? ORDER BY sname limit ?,?";//SQL语句
        ResultSet rs = null;//保存结果集
        List<Hero> heroList = new ArrayList<>(10);//返回对象列表
        try {
            preparedStatement = connection.prepareStatement(sql);//Connection对象绑定SQL语句
            userName = "%" + userName + "%";//两侧加%模糊查询
            preparedStatement.setString(1, userName);
            preparedStatement.setInt(2, (currPage - 1) * 2);
            preparedStatement.setInt(3, pageSize);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String sno = rs.getString(2);
                String sname = rs.getString("sname");
                String ssex = rs.getString("ssex");
                int sage = rs.getInt(5);
                Hero hero = new Hero();
                hero.setId(id);
                hero.setSname(sname);
                hero.setSsex(ssex);
                hero.setSno(sno);
                hero.setSage(sage);
                heroList.add(hero);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(preparedStatement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return heroList;
    }

    @Override
    public List<Hero> findOrderByUserName() {
        Connection connection = JdbcUtil.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "select * from hero ORDER BY sname";//SQL语句
        ResultSet rs = null;//保存结果集
        List<Hero> heroList = new ArrayList<>(10);//返回对象列表
        try {
            preparedStatement = connection.prepareStatement(sql);//Connection对象绑定SQL语句
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String sno = rs.getString(2);
                String sname = rs.getString("sname");
                String ssex = rs.getString("ssex");
                int sage = rs.getInt(5);
                Hero hero = new Hero();
                hero.setId(id);
                hero.setSname(sname);
                hero.setSsex(ssex);
                hero.setSno(sno);
                hero.setSage(sage);
                heroList.add(hero);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(preparedStatement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return heroList;
    }

    @Override
    public List<Hero> findByUserNameLike(String userName) {
        Connection connection = JdbcUtil.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "select * from hero where sname like ?";//SQL语句
        ResultSet rs = null;//保存结果集
        List<Hero> heroList = new ArrayList<>(10);//返回对象列表
        try {
            preparedStatement = connection.prepareStatement(sql);//Connection对象绑定SQL语句
            userName = "%" + userName + "%";//两侧加%模糊查询
            preparedStatement.setString(1, userName);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String sno = rs.getString(2);
                String sname = rs.getString("sname");
                String ssex = rs.getString("ssex");
                int sage = rs.getInt(5);
                Hero hero = new Hero();
                hero.setId(id);
                hero.setSname(sname);
                hero.setSsex(ssex);
                hero.setSno(sno);
                hero.setSage(sage);
                heroList.add(hero);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(preparedStatement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return heroList;
    }

    @Override
    public int updateHeroById(Hero hero) {
        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("update hero set sname='");
            stringBuffer.append(hero.getSname());
            stringBuffer.append("',ssex='");
            stringBuffer.append(hero.getSsex());
            stringBuffer.append("',sage=");
            stringBuffer.append(hero.getSage());
            stringBuffer.append(" where sno='");
            stringBuffer.append(hero.getSno());
            stringBuffer.append("'");

            System.out.println(stringBuffer.toString());

            int affectedRows = statement.executeUpdate(stringBuffer.toString());

            return affectedRows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }


        return 0;
    }

    @Override
    public int insertHero(Hero hero) {
        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("insert into hero values(null,");
            stringBuffer.append("'");
            stringBuffer.append(hero.getSno());
            stringBuffer.append("','");
            stringBuffer.append(hero.getSname());
            stringBuffer.append("','");
            stringBuffer.append(hero.getSsex());
            stringBuffer.append("',");
            stringBuffer.append(hero.getSage());
            stringBuffer.append(")");

            System.out.println(stringBuffer.toString());

            int affectedRows = statement.executeUpdate(stringBuffer.toString());

            return affectedRows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }


        return 0;
    }

    @Override
    public int deleteHeroById(int id) {
        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("delete from hero where id=");
            stringBuffer.append(id);
            System.out.println(stringBuffer.toString());

            int affectedRows = statement.executeUpdate(stringBuffer.toString());

            return affectedRows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return 0;
    }
}
