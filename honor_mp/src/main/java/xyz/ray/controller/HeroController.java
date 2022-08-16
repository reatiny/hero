package xyz.ray.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.ray.pojo.Hero;
import xyz.ray.service.HeroService;

import java.util.List;

@RestController
@RequestMapping("/hero")
public class HeroController {
    @Autowired
    private HeroService heroService;

    @GetMapping
    public Result selectAll() {
        List<Hero> heroes = heroService.list();
        Integer code = heroes != null ? Code.GET_OK : Code.GET_ERR;
        String msg = heroes != null ? "查询全部 成功" : "查询全部 失败";
        return new Result(code, heroes, msg);
    }

    @PostMapping
    public Result add(@RequestBody Hero hero) {
        Boolean flag = heroService.save(hero);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @DeleteMapping()
    public Result deleteByIds(@RequestBody List<Integer> ids) {
        Boolean flag = heroService.removeByIds(ids);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public Result selectByPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        IPage<Hero> page = new Page<>(currentPage, pageSize);
        heroService.page(page);
        Integer code = page != null ? Code.GET_OK : Code.GET_ERR;
        String msg = page != null ? "分页查询 成功" : "分页查询 失败";
        return new Result(code, page, msg);
    }

    @PostMapping("/{currentPage}/{pageSize}")
    public Result selectByPageAndCondition(@PathVariable int currentPage, @PathVariable int pageSize, @RequestBody Hero hero) {
        IPage<Hero> page = new Page<>(currentPage, pageSize);

        LambdaQueryWrapper<Hero> lqw = new LambdaQueryWrapper<Hero>();
        lqw.like(null != hero.getHeroName(), Hero::getHeroName, hero.getHeroName())
                .like(null != hero.getRole() ,Hero::getRole, hero.getRole())
                        .eq(null != hero.getStatus(), Hero::getStatus, hero.getStatus());

        heroService.page(page, lqw);
        Integer code = page != null ? Code.GET_OK : Code.GET_ERR;
        String msg = page != null ? "分页条件查询 成功" : "分页条件查询 失败";
        return new Result(code, page, msg);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        Boolean flag = heroService.removeById(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @PutMapping
    public Result update(@RequestBody Hero hero) {
        Boolean flag = heroService.updateById(hero);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }
}
