package xyz.ray;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.ray.config.SpringConfig;
import xyz.ray.pojo.Hero;
import xyz.ray.service.HeroService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class HeroServiceTest {

    @Autowired
    private HeroService heroService;

    @Test
    public void testSelectAll() {
        List<Hero> heroes = heroService.selectAll();
        System.out.println(heroes);
    }
}
