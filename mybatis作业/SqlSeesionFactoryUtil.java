package day.daymybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSeesionFactoryUtil {
    private static final Class<SqlSeesionFactoryUtil> LOCK = SqlSeesionFactoryUtil.class;
    /**
     * SqlSession工厂类变量，只要拥有一个就行了
     */
    static volatile SqlSessionFactory sqlSessionFactory = null; //防止指令重排序

    public static void initFatory() {
        if (null == sqlSessionFactory) {
            synchronized (LOCK) {
                if (null == sqlSessionFactory) {
                    createFactory();
                }
            }
        }
    }

    public static void createFactory() {

        String path = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(path);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //SqlSessionFactory ->SqlSession ->相当于数据库中的Connection

    public static SqlSession getSqlSession() {
        initFatory();
        return sqlSessionFactory.openSession();
    }

}
