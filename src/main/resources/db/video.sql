/*
 Navicat Premium Dump SQL

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80038 (8.0.38)
 Source Host           : localhost:3306
 Source Schema         : video

 Target Server Type    : MySQL
 Target Server Version : 80038 (8.0.38)
 File Encoding         : 65001

 Date: 04/11/2024 20:30:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
                              `id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
                              `uuid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户客户端的uuid',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Table structure for user_video
-- ----------------------------
DROP TABLE IF EXISTS `user_video`;
CREATE TABLE `user_video`  (
                               `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
                               `user_id` int NULL DEFAULT NULL COMMENT '用户id',
                               `video_id` int NULL DEFAULT NULL COMMENT '视频id',
                               `last_visited_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最近访问时间',
                               `duration` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '用户观看视频时间',
                               PRIMARY KEY (`id`) USING BTREE,
                               INDEX `user_video_video_info_id_fk`(`video_id` ASC) USING BTREE,
                               INDEX `user_video_user_info_id_fk`(`user_id` ASC) USING BTREE,
                               CONSTRAINT `user_video_user_info_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
                               CONSTRAINT `user_video_video_info_id_fk` FOREIGN KEY (`video_id`) REFERENCES `video_info` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;


-- ----------------------------
-- Table structure for video_info
-- ----------------------------
DROP TABLE IF EXISTS `video_info`;
CREATE TABLE `video_info`  (
                               `id` int NOT NULL AUTO_INCREMENT COMMENT '视频id',
                               `video_name` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '视频名称',
                               `video_type` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '视频类型',
                               `video_time` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '视频持续时间',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of video_info
-- ----------------------------
INSERT INTO `video_info` VALUES (1, 'loading.mp4', 'game', '8');
INSERT INTO `video_info` VALUES (2, 'sample_video.mp4', 'game', '2');
INSERT INTO `video_info` VALUES (3, 'LicenseScreen.mp4', 'game', '3');
INSERT INTO `video_info` VALUES (4, 'M09.mp4', 'animate', '6');
INSERT INTO `video_info` VALUES (5, 'M30.mp4', 'animate', '15');
INSERT INTO `video_info` VALUES (6, 'mp4.mp4', 'animate', '5');
INSERT INTO `video_info` VALUES (7, 'nasa.mp4', 'animate', '16');

SET FOREIGN_KEY_CHECKS = 1;
