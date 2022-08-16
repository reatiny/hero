/*
 Navicat Premium Data Transfer

 Source Server         : mysql_root
 Source Server Type    : MySQL
 Source Server Version : 80029 (8.0.29)
 Source Host           : localhost:3306
 Source Schema         : hok

 Target Server Type    : MySQL
 Target Server Version : 80029 (8.0.29)
 File Encoding         : 65001

 Date: 16/08/2022 20:29:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_hero
-- ----------------------------
DROP TABLE IF EXISTS `tb_hero`;
CREATE TABLE `tb_hero` (
  `id` int NOT NULL AUTO_INCREMENT,
  `hero_name` varchar(20) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tb_hero
-- ----------------------------
BEGIN;
INSERT INTO `tb_hero` (`id`, `hero_name`, `role`, `age`, `description`, `status`) VALUES (1, '阿骨朵', '坦克', 16, '被魔种抚养长大的少女，在人类军团中作战的山孩', 1);
INSERT INTO `tb_hero` (`id`, `hero_name`, `role`, `age`, `description`, `status`) VALUES (2, '亚瑟', '坦克', 30, '传说他是国王尤瑟之子，因拔出岩石中相传只有“英格兰之王”才能拔出的“石中剑”而称王', 1);
INSERT INTO `tb_hero` (`id`, `hero_name`, `role`, `age`, `description`, `status`) VALUES (3, '盾山', '坦克', 35, '他似乎在研究怎么启动自己。', 1);
INSERT INTO `tb_hero` (`id`, `hero_name`, `role`, `age`, `description`, `status`) VALUES (4, '钟无艳', '坦克', 28, '钟无艳，史称钟离春，后世以无盐之名称世', 1);
INSERT INTO `tb_hero` (`id`, `hero_name`, `role`, `age`, `description`, `status`) VALUES (5, '司空震', '战士', 29, '以雷霆击碎黑暗', 1);
INSERT INTO `tb_hero` (`id`, `hero_name`, `role`, `age`, `description`, `status`) VALUES (6, '马超', '战士', 27, '马超，字孟起，扶风茂陵人，年少时以“健勇”成名，勇力善战，曹操曾多次招揽马超入朝为官，但都被马超拒绝', 1);
INSERT INTO `tb_hero` (`id`, `hero_name`, `role`, `age`, `description`, `status`) VALUES (7, '老夫子', '战士', 59, '老夫子的历史原型为儒家学派创始人孔子', 1);
INSERT INTO `tb_hero` (`id`, `hero_name`, `role`, `age`, `description`, `status`) VALUES (8, '夏洛特', '战士', 27, '夏洛特是日落海久负盛名的贵族家族中，最为优秀的继承者。', 1);
INSERT INTO `tb_hero` (`id`, `hero_name`, `role`, `age`, `description`, `status`) VALUES (9, '李白', '刺客', 18, '李白，字太白，号青莲居士，他既是后世所誉“诗仙”', 1);
INSERT INTO `tb_hero` (`id`, `hero_name`, `role`, `age`, `description`, `status`) VALUES (10, '韩信', '刺客', 29, '胯下之辱经历者', 1);
INSERT INTO `tb_hero` (`id`, `hero_name`, `role`, `age`, `description`, `status`) VALUES (11, '橘右京', '刺客', 25, '楼gay楼gay', 1);
INSERT INTO `tb_hero` (`id`, `hero_name`, `role`, `age`, `description`, `status`) VALUES (12, '元哥', '刺客', 26, '他逐渐沉浸于制作傀儡的机关，曾经的自卑依靠精致的傀儡脱胎换骨。', 1);
INSERT INTO `tb_hero` (`id`, `hero_name`, `role`, `age`, `description`, `status`) VALUES (13, '沈梦溪', '法师', 17, '沈梦溪也摆上简陋的摊位，出售自己制造的爆弹，却无人问津。', 1);
INSERT INTO `tb_hero` (`id`, `hero_name`, `role`, `age`, `description`, `status`) VALUES (14, '安琪拉', '法师', 15, '小女孩安琪拉发现了玩偶。她拾取来看了又看，爱不释手。这时，附着在玩偶上的魔法发动了：灵魂交换。', 1);
INSERT INTO `tb_hero` (`id`, `hero_name`, `role`, `age`, `description`, `status`) VALUES (15, '甄姬', '法师', 25, '自幼聪明貌美，颇有才华。先嫁袁绍之子袁熙，袁绍败后，被曹丕收纳，曹丕登基称帝后不久，即失宠，被赐死。', 1);
INSERT INTO `tb_hero` (`id`, `hero_name`, `role`, `age`, `description`, `status`) VALUES (16, '杨玉环', '法师', 28, '安史之乱中，随唐玄宗李隆基流亡，在马嵬坡唐玄宗为解除禁军哗变将她赐死。', 1);
INSERT INTO `tb_hero` (`id`, `hero_name`, `role`, `age`, `description`, `status`) VALUES (17, '马可波罗', '射手', 29, '马可波罗，中古时期的威尼斯商人。', 1);
INSERT INTO `tb_hero` (`id`, `hero_name`, `role`, `age`, `description`, `status`) VALUES (18, '李元芳', '射手', 28, '秘密的密，探案的探', 1);
INSERT INTO `tb_hero` (`id`, `hero_name`, `role`, `age`, `description`, `status`) VALUES (19, '瑶', '辅助', 14, '鹿女阿瑶年幼时不小心闯入东神之城的边缘地带，受到那里村民的围攻。村民想杀掉她，同供品一起献祭给东神', 1);
INSERT INTO `tb_hero` (`id`, `hero_name`, `role`, `age`, `description`, `status`) VALUES (20, '张飞', '辅助', 35, '张飞，字翼德，三国时蜀汉的名将。', 1);
INSERT INTO `tb_hero` (`id`, `hero_name`, `role`, `age`, `description`, `status`) VALUES (21, '鲁班七号', '射手', 11, '借你们肉体试验下新发明的威力', 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
