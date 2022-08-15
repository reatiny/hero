package xyz.ray.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import xyz.ray.mapper.HeroMapper;
import xyz.ray.pojo.Hero;
import xyz.ray.pojo.PageBean;
import xyz.ray.service.HeroService;
import xyz.ray.util.SqlSessionFactoryUtils;

import java.util.List;

public class HeroServiceImpl implements HeroService {
    //1. 创建SqlSessionFactory 工厂对象
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Hero> selectAll() {
        //2. 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //3. 获取HeroMapper
        HeroMapper mapper = sqlSession.getMapper(HeroMapper.class);
        //4. 调用方法
        List<Hero> heroes = mapper.selectAll();
        //5. 释放资源
        sqlSession.close();
        return heroes;
    }

    @Override
    public void add(Hero hero) {
        SqlSession sqlSession = factory.openSession();
        HeroMapper mapper = sqlSession.getMapper(HeroMapper.class);
        mapper.add(hero);
        // 增删改操作一定要提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteByIds(int[] ids) {
        SqlSession sqlSession = factory.openSession();
        HeroMapper mapper = sqlSession.getMapper(HeroMapper.class);
        mapper.deleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean<Hero> selectByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = factory.openSession();
        HeroMapper mapper = sqlSession.getMapper(HeroMapper.class);
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;

        List<Hero> heroes = mapper.selectByPage(begin, size);
        int totalCount = mapper.selectTotalCount();

        PageBean<Hero> pageBean = new PageBean<>();
        pageBean.setRows(heroes);
        pageBean.setTotalCount(totalCount);

        sqlSession.close();
        return pageBean;
    }

    @Override
    public PageBean<Hero> selectByPageAndCondition(int currentPage, int pageSize, Hero hero) {
        SqlSession sqlSession = factory.openSession();
        HeroMapper mapper = sqlSession.getMapper(HeroMapper.class);
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;

        String heroName = hero.getHeroName();
        if (heroName != null && heroName.length() > 0) {
            hero.setHeroName("%" + heroName + "%");
        }
        String role = hero.getRole();
        if (role != null && role.length() > 0) {
            hero.setRole("%" + role + "%");
        }

        List<Hero> heroes = mapper.selectByPageAndCondition(begin, size, hero);
        int totalCountByCondition = mapper.selectTotalCountByCondition(hero);


        PageBean<Hero> pageBean = new PageBean<>();
        pageBean.setRows(heroes);
        pageBean.setTotalCount(totalCountByCondition);

        sqlSession.close();
        return pageBean;
    }

    @Override
    public void deleteById(int id) {
        SqlSession sqlSession = factory.openSession();
        HeroMapper mapper = sqlSession.getMapper(HeroMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void update(Hero hero) {
        SqlSession sqlSession = factory.openSession();
        HeroMapper mapper = sqlSession.getMapper(HeroMapper.class);
        mapper.update(hero);
        sqlSession.commit();
        sqlSession.close();
    }

}
