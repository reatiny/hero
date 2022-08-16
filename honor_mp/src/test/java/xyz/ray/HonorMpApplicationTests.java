package xyz.ray;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.ray.mapper.HeroMapper;
import xyz.ray.pojo.Hero;
import xyz.ray.service.HeroService;

import java.util.Collections;
import java.util.List;

@SpringBootTest
class HonorMpApplicationTests {

	@Autowired
	private HeroMapper heroMapper;
	@Autowired
	private HeroService heroService;

	@Test
	public void testSelect() {
		System.out.println(("----- selectAll method test ------"));
		List<Hero> heroList = heroMapper.selectList(null);
		heroList.forEach(System.out::println);
	}

	@Test
	public void testSelectPage() {
		IPage<Hero> page = new Page<>(1,5);
		heroMapper.selectPage(page, null);

		System.out.println("当前页码值："+page.getCurrent());
		System.out.println("每页显示数："+page.getSize());
		System.out.println("一共多少页："+page.getPages());
		System.out.println("一共多少条数据："+page.getTotal());
		System.out.println("数据："+page.getRecords());
	}

	@Test
	public void testList() {
		List<Hero> heroes = heroService.list();
		System.out.println(heroes);
	}
}
