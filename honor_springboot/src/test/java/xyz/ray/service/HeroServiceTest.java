package xyz.ray.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.ray.pojo.Hero;

import java.util.List;

@SpringBootTest
public class HeroServiceTest {

    @Autowired
    private HeroService heroService;

    @Test
    public void testSelectAll() {
        List<Hero> heroes = heroService.selectAll();
        System.out.println(heroes);
    }
}
