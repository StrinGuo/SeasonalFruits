package unit18;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DemoTest {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        HeroOperatable he = new HeroOperator();
        List<Hero> list = new ArrayList<>(10);
        list = he.findByUserNameLike("张");
        list.forEach(System.out::println);
        System.out.println();
        list = he.findOrderByUserName();
        list.forEach(System.out::println);
        System.out.println();
        list = he.indByUserNameLikeOrderLimit("张", 2, 2);
        list.forEach(System.out::println);
    }
}
