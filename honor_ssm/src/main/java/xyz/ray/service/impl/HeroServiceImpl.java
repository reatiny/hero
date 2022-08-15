package xyz.ray.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ray.mapper.HeroMapper;
import xyz.ray.pojo.Hero;
import xyz.ray.pojo.PageBean;
import xyz.ray.service.HeroService;

import java.util.List;

@Service
public class HeroServiceImpl implements HeroService {
    @Autowired
    private HeroMapper heroMapper;

    @Override
    public List<Hero> selectAll() {
        List<Hero> heroes = heroMapper.selectAll();
        return heroes;
    }

    @Override
    public Boolean add(Hero hero) {
        heroMapper.add(hero);
        return true;
    }

    @Override
    public Boolean deleteByIds(int[] ids) {
        heroMapper.deleteByIds(ids);
        return true;
    }

    @Override
    public PageBean<Hero> selectByPage(int currentPage, int pageSize) {
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;

        List<Hero> heroes = heroMapper.selectByPage(begin, size);
        int totalCount = heroMapper.selectTotalCount();

        PageBean<Hero> pageBean = new PageBean<>();
        pageBean.setRows(heroes);
        pageBean.setTotalCount(totalCount);

        return pageBean;
    }

    @Override
    public PageBean<Hero> selectByPageAndCondition(int currentPage, int pageSize, Hero hero) {
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

        List<Hero> heroes = heroMapper.selectByPageAndCondition(begin, size, hero);
        int totalCountByCondition = heroMapper.selectTotalCountByCondition(hero);

        PageBean<Hero> pageBean = new PageBean<>();
        pageBean.setRows(heroes);
        pageBean.setTotalCount(totalCountByCondition);

        return pageBean;
    }

    @Override
    public Boolean deleteById(Integer id) {
        heroMapper.deleteById(id);
        return true;
    }

    @Override
    public Boolean update(Hero hero) {
        heroMapper.update(hero);
        return true;
    }

}
