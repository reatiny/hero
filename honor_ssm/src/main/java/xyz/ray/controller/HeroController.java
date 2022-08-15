package xyz.ray.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.ray.pojo.Hero;
import xyz.ray.pojo.PageBean;
import xyz.ray.service.HeroService;

import java.util.List;

@RestController
@RequestMapping("/hero")
public class HeroController {
    @Autowired
    private HeroService heroService;

    @GetMapping
    public Result selectAll() {
        List<Hero> heroes = heroService.selectAll();
        Integer code = heroes != null ? Code.GET_OK : Code.GET_ERR;
        String msg = heroes != null ? "查询全部 成功" : "查询全部 失败";
        return new Result(code, heroes, msg);
    }

    @PostMapping
    public Result add(@RequestBody Hero hero) {
        Boolean flag = heroService.add(hero);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @DeleteMapping()
    public Result deleteByIds(@RequestBody int[] ids) {
        Boolean flag = heroService.deleteByIds(ids);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public Result selectByPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        PageBean<Hero> pageBean = heroService.selectByPage(currentPage, pageSize);
        Integer code = pageBean != null ? Code.GET_OK : Code.GET_ERR;
        String msg = pageBean != null ? "分页查询 成功" : "分页查询 失败";
        return new Result(code, pageBean, msg);
    }

    @PostMapping("/{currentPage}/{pageSize}")
    public Result selectByPageAndCondition(@PathVariable int currentPage, @PathVariable int pageSize, @RequestBody Hero hero) {
        PageBean<Hero> pageBean = heroService.selectByPageAndCondition(currentPage, pageSize, hero);
        Integer code = pageBean != null ? Code.GET_OK : Code.GET_ERR;
        String msg = pageBean != null ? "分页条件查询 成功" : "分页条件查询 失败";
        return new Result(code, pageBean, msg);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        Boolean flag = heroService.deleteById(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @PutMapping
    public Result update(@RequestBody Hero hero) {
        Boolean flag = heroService.update(hero);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }
}
