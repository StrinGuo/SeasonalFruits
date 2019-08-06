package unit18;

import java.util.List;

public interface HeroOperatable {
    /**
     * 查询所有数据
     * @return  将所有数据封装到集合中返回
     */
    List<Hero>  findAllHero();

    /**
     * 根据用户名模糊查找，按升序排列，并分页显示
     * @param userName 用户名
     * @param currPage 当前页
     * @param pageSize 每页数量
     * @return 将所有数据封装到集合中返回
     */
    List<Hero> indByUserNameLikeOrderLimit(String userName,int currPage, int pageSize);
    /**
     * 根据用户名升序排列并返回排列结果集
     */
    List<Hero> findOrderByUserName();
    /**
     * 根据用户名模糊查询
     * @param userName 用户名
     * @return 将所有数据封装到集合中返回
     */
    List<Hero> findByUserNameLike(String userName);
    /**
     * 修改信息
     * @param hero 待修改的对象
     * @return 执行sql后，受影响的行数
     */
    int updateHeroById(Hero hero);

    /**
     * 添加数据
     * @param hero
     * @return 执行sql后，受影响的行数
     */
    int insertHero(Hero hero);

    /**
     * 根据id删除
     * @param id
     * @return 执行sql后，受影响的行数
     */
    int deleteHeroById(int id);

}
