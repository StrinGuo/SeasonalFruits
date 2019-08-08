package day.daymybatis;

import java.util.List;

public interface RoleMapper {
    /**
     * 查找所有的role信息
     *
     * @return
     */
    List<Role> findAllRole();

    /**
     * 根据ID查找role信息
     *
     * @return
     */
    Role findRoleById(int id);

    /**
     * 插入Role中的数据
     * @param role
     * @return
     */
    int insertRole(Role role);

    /**
     * 更新操作
     * @param role
     * @return
     */
    int updateRole(Role role);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteById(int id);
}
