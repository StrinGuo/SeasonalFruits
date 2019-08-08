package day.daymybatis;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {

            sqlSession = SqlSeesionFactoryUtil.getSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            List<Role> roleList = roleMapper.findAllRole();
            roleList.forEach(System.out::println);
            Role role = new Role();
            role.setNote("aa");
            role.setRoleName("bb");
            role.setId(2);
            roleMapper.insertRole(role);
            roleMapper.updateRole(role);
            roleMapper.deleteById(1);

            //主动提交
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != sqlSession) {
                sqlSession.close();
            }
        }

    }
}
