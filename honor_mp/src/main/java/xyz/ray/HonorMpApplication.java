package xyz.ray;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("xyz.ray.mapper")
public class HonorMpApplication {

	public static void main(String[] args) {
		SpringApplication.run(HonorMpApplication.class, args);
	}

}
