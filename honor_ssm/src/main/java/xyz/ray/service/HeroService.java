package xyz.ray.service;

import org.springframework.transaction.annotation.Transactional;
import xyz.ray.pojo.Hero;
import xyz.ray.pojo.PageBean;

import java.util.List;

@Transactional
public interface HeroService {
    /**
     * 查询所有
     */
    List<Hero> selectAll();

    /**
     * 新增数据
     */
    Boolean add(Hero hero);

    /**
     * 批量删除
     */
    Boolean deleteByIds(int[] ids);

    /**
     * 分页查询
     */
    PageBean<Hero> selectByPage(int currentPage, int pageSize);

    /**
     * 分页条件查询
     */
    PageBean<Hero> selectByPageAndCondition(int currentPage, int pageSize, Hero hero);

    /**
     * 根据ID删除数据
     */
    Boolean deleteById(Integer id);

    /**
     * 修改数据
     */
    Boolean update(Hero hero);
}
