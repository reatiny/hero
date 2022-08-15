package xyz.ray.service;

import xyz.ray.pojo.Hero;
import xyz.ray.pojo.PageBean;

import java.util.List;

public interface HeroService {
    /**
     * 查询所有
     */
    List<Hero> selectAll();

    /**
     * 新增数据
     * @param hero
     */
    void add(Hero hero);

    /**
     * 批量删除
     * @param ids
     */
    void deleteByIds(int[] ids);

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
    void deleteById(int id);

    /**
     * 修改数据
     */
    void update(Hero hero);
}
