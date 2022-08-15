package xyz.ray.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.ray.pojo.Hero;

import java.util.List;

@Mapper
public interface HeroMapper {
    /**
     * 查询所有
     */
    List<Hero> selectAll();

    /**
     * 新增
     */
    void add(Hero hero);

    /**
     * 批量删除
     */
    void deleteByIds(@Param("ids") int[] ids);

    /**
     * 分页查询
     */
    List<Hero> selectByPage(@Param("begin") int begin, @Param("size") int size);

    /**
     * 查询总记录数
     */
    int selectTotalCount();

    /**
     * 分页条件查询
     */
    List<Hero> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("hero") Hero hero);

    /**
     * 根据条件查询记录总数
     */
    int selectTotalCountByCondition(Hero hero);

    /**
     * 根据ID删除记录
     */
    void deleteById(Integer id);

    /**
     * 修改记录
     */
    void update(Hero hero);
}
