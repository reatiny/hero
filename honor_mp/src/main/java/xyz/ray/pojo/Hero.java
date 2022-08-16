package xyz.ray.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_hero")
public class Hero {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField(value="hero_name")
    private String heroName;
    private String role;
    private Integer age;
    private String description;
    private Integer status;
}
