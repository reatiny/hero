package xyz.ray.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.ray.mapper.HeroMapper;
import xyz.ray.pojo.Hero;
import xyz.ray.service.HeroService;

@Service
public class HeroServiceImpl extends ServiceImpl<HeroMapper, Hero> implements HeroService {
}
