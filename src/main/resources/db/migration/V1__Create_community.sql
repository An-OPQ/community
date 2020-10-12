/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : community

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 12/10/2020 09:48:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for advert
-- ----------------------------
DROP TABLE IF EXISTS `advert`;
CREATE TABLE `advert`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createId` bigint(20) DEFAULT NULL,
  `pictureAddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `advertURL` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `advertName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `createTime` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `advert_userinfo_id_fk`(`createId`) USING BTREE,
  CONSTRAINT `advert_userinfo_id_fk` FOREIGN KEY (`createId`) REFERENCES `userinfo` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of advert
-- ----------------------------
INSERT INTO `advert` VALUES (1, 29, 'ea26abdb-b6ef-4ac2-9391-175c0735bfee.png', 'www.alibabagroup.com/cn/global/home', 'Alibaba', '2020-09-22 11:15:49');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `creatorId` bigint(11) NOT NULL,
  `questionId` bigint(11) NOT NULL,
  `commentDescription` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `commentDate` datetime(0) DEFAULT NULL,
  `likeCount` int(11) DEFAULT 0,
  `commentCount` int(11) DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `creatorId`(`creatorId`) USING BTREE,
  INDEX `questionId`(`questionId`) USING BTREE,
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`creatorId`) REFERENCES `userinfo` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`questionId`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 29, 1, '哈哈，瞧瞧你。傻样！ 技术太菜，业务代码还写不利索，别说算法了。', '2020-09-06 00:00:00', 2, 6);
INSERT INTO `comment` VALUES (2, 29, 3, '这样真的行吗\n', '2020-09-08 00:00:00', 0, 0);
INSERT INTO `comment` VALUES (3, 29, 3, '我也不知道', '2020-09-08 00:00:00', 0, 0);
INSERT INTO `comment` VALUES (4, 29, 2, '慢慢写，', '2020-09-08 00:00:00', 0, 0);
INSERT INTO `comment` VALUES (5, 29, 2, '星际争霸真好玩', '2020-09-08 00:00:00', 0, 0);
INSERT INTO `comment` VALUES (8, 29, 1, '测试用例', '2020-09-13 00:00:00', 0, 0);
INSERT INTO `comment` VALUES (9, 29, 1, '测试', '2020-09-13 00:00:00', 0, 0);
INSERT INTO `comment` VALUES (17, 29, 25, '是啊，AI现在都挺强大了', '2020-09-22 00:00:00', 0, 0);
INSERT INTO `comment` VALUES (18, 29, 25, '对', '2020-09-22 00:00:00', 0, 0);
INSERT INTO `comment` VALUES (20, 29, 1, '测试', '2020-09-24 00:00:00', 0, 0);
INSERT INTO `comment` VALUES (22, 39, 1, '是的学习啊啊', '2020-10-06 00:00:00', 0, 0);
INSERT INTO `comment` VALUES (24, 39, 28, '个人喜欢的书籍有 平凡的世界，邓小平时代', '2020-10-07 00:00:00', 0, 0);
INSERT INTO `comment` VALUES (25, 29, 28, '喜欢', '2020-10-08 11:22:30', 0, 0);

-- ----------------------------
-- Table structure for comment_multi
-- ----------------------------
DROP TABLE IF EXISTS `comment_multi`;
CREATE TABLE `comment_multi`  (
  `com_multi_id` int(11) NOT NULL AUTO_INCREMENT,
  `com_multi_user_id` bigint(20) NOT NULL,
  `com_id` bigint(11) NOT NULL,
  `com_multi_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `com_multi_time` datetime(0) DEFAULT NULL,
  `like_count` int(11) DEFAULT NULL,
  `comment_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`com_multi_id`) USING BTREE,
  INDEX `com_multi_user_id`(`com_multi_user_id`) USING BTREE,
  INDEX `com_id`(`com_id`) USING BTREE,
  CONSTRAINT `comment_multi_ibfk_1` FOREIGN KEY (`com_multi_user_id`) REFERENCES `userinfo` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `comment_multi_ibfk_2` FOREIGN KEY (`com_id`) REFERENCES `comment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment_multi
-- ----------------------------
INSERT INTO `comment_multi` VALUES (1, 29, 1, '建议呢，还是找人一起学习。一个人学习太无聊了。', '2020-10-08 10:35:09', NULL, NULL);
INSERT INTO `comment_multi` VALUES (2, 39, 1, '我也同意', '2020-10-08 10:37:44', NULL, NULL);
INSERT INTO `comment_multi` VALUES (3, 29, 1, '附议', '2020-10-08 10:38:57', NULL, NULL);
INSERT INTO `comment_multi` VALUES (4, 39, 1, '附议', '2020-10-08 10:39:23', NULL, NULL);

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_id` bigint(20) DEFAULT NULL,
  `notice_content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `create_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `create_id`(`create_id`) USING BTREE,
  CONSTRAINT `notice_ibfk_1` FOREIGN KEY (`create_id`) REFERENCES `userinfo` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, 29, '<p><span style=\"font-weight: bold;\">系统维护通知：<br></span><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本系统将于2020年9月24日17:00至2020年9月26日24:00区间内，进行系统升级。届时本系统线上服务渠道的业务将暂停提供服务，恢复使用时间为 2020年9月27日 00:00。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;对此给您造成的不便，我们深表歉意，敬请谅解。<br></p><div>&nbsp; &nbsp; &nbsp; &nbsp; 望周知。</div><div style=\"text-align: right;\">&nbsp; &nbsp;&nbsp;<span style=\"text-align: left;\">求知论坛管理中心</span></div><div style=\"text-align: right;\">&nbsp; &nbsp;2020年9月24日</div>', '2020-09-22 14:00:03');
INSERT INTO `notice` VALUES (5, 29, '<p><span style=\"font-weight: bold;\">系统维护通知：<br></span><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本系统将于2020年9月24日17:00至2020年9月26日24:00区间内，进行系统升级。届时本系统线上服务渠道的业务将暂停提供服务，恢复使用时间为 2020年9月27日 00:00。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;对此给您造成的不便，我们深表歉意，敬请谅解。<br></p><div>&nbsp; &nbsp; &nbsp; &nbsp; 望周知。</div><div style=\"text-align: right;\">&nbsp; &nbsp;&nbsp;<span style=\"text-align: left;\">求知论坛管理中心</span></div><div style=\"text-align: right;\">&nbsp; &nbsp;2020年9月24日</div>', '2020-09-22 14:00:03');
INSERT INTO `notice` VALUES (6, 29, '<p><span style=\"font-weight: bold;\">系统维护通知：<br></span><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本系统将于2020年9月24日17:00至2020年9月26日24:00区间内，进行系统升级。届时本系统线上服务渠道的业务将暂停提供服务，恢复使用时间为 2020年9月27日 00:00。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;对此给您造成的不便，我们深表歉意，敬请谅解。<br></p><div>&nbsp; &nbsp; &nbsp; &nbsp; 望周知。</div><div style=\"text-align: right;\">&nbsp; &nbsp;&nbsp;<span style=\"text-align: left;\">求知论坛管理中心</span></div><div style=\"text-align: right;\">&nbsp; &nbsp;2020年9月24日</div>', '2020-09-22 14:00:03');
INSERT INTO `notice` VALUES (9, 29, '<p><span style=\"font-weight: bold;\">系统维护通知：<br></span><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本系统将于2020年9月24日17:00至2020年9月26日24:00区间内，进行系统升级。届时本系统线上服务渠道的业务将暂停提供服务，恢复使用时间为 2020年9月27日 00:00。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;对此给您造成的不便，我们深表歉意，敬请谅解。<br></p><div>&nbsp; &nbsp; &nbsp; &nbsp; 望周知。</div><div style=\"text-align: right;\">&nbsp; &nbsp;&nbsp;<span style=\"text-align: left;\">求知论坛管理中心</span></div><div style=\"text-align: right;\">&nbsp; &nbsp;2020年9月24日</div>', '2020-09-22 14:00:03');
INSERT INTO `notice` VALUES (10, NULL, '<p><span style=\"font-weight: bold;\">广大缴存单位及职工：<br></span> <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我中心将于2020年7月24日17:00至2020年7月26日24:00区间内，进行系统升级。届时，中心网站、网厅、APP、微信、城市服务和12329等线上服务渠道的业务将暂停提供服务，恢复使用时间为 2020年7月27日 00:00。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;对此给您造成的不便，我们深表歉意，敬请谅解。<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;望周知。<br>&nbsp; &nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;长春市住房公积金管理中心<br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;2020年7月24日</p>', '2020-09-21 11:40:50');
INSERT INTO `notice` VALUES (11, 29, '<p><span style=\"font-weight: bold;\">系统维护通知：<br></span><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本系统将于2020年9月24日17:00至2020年9月26日24:00区间内，进行系统升级。届时本系统线上服务渠道的业务将暂停提供服务，恢复使用时间为 2020年9月27日 00:00。<br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;对此给您造成的不便，我们深表歉意，敬请谅解。<br></p><div>&nbsp; &nbsp; &nbsp; &nbsp; 望周知。</div><div style=\"text-align: right;\">&nbsp; &nbsp;&nbsp;<span style=\"text-align: left;\">求知论坛管理中心</span></div><div style=\"text-align: right;\">&nbsp; &nbsp;2020年9月24日</div>', '2020-09-22 14:00:03');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(75) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `creatorid` bigint(20) NOT NULL,
  `typeid` int(11) DEFAULT NULL,
  `commentCount` int(11) DEFAULT 0,
  `viewCount` int(11) DEFAULT 0,
  `likeCount` int(11) DEFAULT 0,
  `createDate` date DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `question_userinfo_id_fk`(`creatorid`) USING BTREE,
  INDEX `typeid`(`typeid`) USING BTREE,
  CONSTRAINT `question_ibfk_1` FOREIGN KEY (`typeid`) REFERENCES `question_type` (`type_id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `question_userinfo_id_fk` FOREIGN KEY (`creatorid`) REFERENCES `userinfo` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (1, '数据库第二次重构的第一条帖子', '<p><span style=\"font-weight: bold;\"><span style=\"font-style: italic;\">还是得学习好软件工程，不然UML建模都不会&nbsp;</span>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;</span></p><p><span style=\"font-weight: bold;\">&nbsp;</span><span style=\"background-color: rgb(241, 241, 241); color: inherit; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; font-size: inherit; white-space: pre-wrap;\">@PostMapping(\"/loginCheck\")</span></p><pre><code>    public Object loginCheck(@RequestBody UserInfo userInfo, HttpServletResponse response, HttpServletRequest request) {<br>        userInfo = MD5.encode(userInfo);<br>        boolean falg = managementService.loginCheck(userInfo);<br>        updateTokenByCookie.updateTokenByCookie(falg, userInfo, response, request);<br>        return falg;<br>    }</code></pre><p><br></p>', 29, 1, 7, 803, 1, '2020-09-24');
INSERT INTO `question` VALUES (2, '代码写不完了啊', '<pre><code>.   ____          _            __ _ _<br> /\\\\ / ___\'_ __ _ _(_)_ __  __ _ \\ \\ \\ \\<br>( ( )\\___ | \'_ | \'_| | \'_ \\/ _` | \\ \\ \\ \\<br> \\\\/  ___)| |_)| | | | | || (_| |  ) ) ) )<br>  \'  |____| .__|_| |_|_| |_\\__, | / / / /<br> =========|_|==============|___/=/_/_/_/<br> :: Spring Boot ::       (v2.1.14.RELEASE)<br><br>2020-09-07 10:42:49.345  INFO 11117 --- [           main] edu.hniu.community.CommunityApplication  : Starting CommunityApplication on jerry-PC with PID 11117 (/home/jerry/Desktop/community/target/classes started by jerry in /home/jerry/Desktop/community)<br>2020-09-07 10:42:49.350  INFO 11117 --- [           main] edu.hniu.community.CommunityApplication  : No active profile set, falling back to default profiles: default<br>2020-09-07 10:42:50.345  INFO 11117 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)<br>2020-09-07 10:42:50.364  INFO 11117 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]<br>2020-09-07 10:42:50.364  INFO 11117 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.34]<br>2020-09-07 10:42:50.425  INFO 11117 --- [           main] o.a.c.c.C.[.[localhost].[/community]     : Initializing Spring embedded WebApplicationContext<br>2020-09-07 10:42:50.425  INFO 11117 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 1034 ms<br>2020-09-07 10:42:50.917  INFO 11117 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService \'applicationTaskExecutor\'<br>2020-09-07 10:42:51.078  INFO 11117 --- [           main] o.f.c.internal.license.VersionPrinter    : Flyway Community Edition 5.2.4 by Boxfuse<br>2020-09-07 10:42:51.219  INFO 11117 --- [           main] com.alibaba.druid.pool.DruidDataSource   : {dataSource-1} inited<br>2020-09-07 10:42:51.223  INFO 11117 --- [           main] o.f.c.internal.database.DatabaseFactory  : Database: jdbc:mysql://localhost:3306/community (MySQL 5.7)<br>2020-09-07 10:42:51.289  INFO 11117 --- [           main] o.f.core.internal.command.DbValidate     : Successfully validated 9 migrations (execution time 00:00.039s)<br>2020-09-07 10:42:51.298  INFO 11117 --- [           main] o.f.core.internal.command.DbMigrate      : Current version of schema `community`: 9<br>2020-09-07 10:42:51.299  INFO 11117 --- [           main] o.f.core.internal.command.DbMigrate      : Schema `community` is up to date. No migration necessary.<br>2020-09-07 10:42:51.389  INFO 11117 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path \'/community\'<br>2020-09-07 10:42:51.392  INFO 11117 --- [           main] edu.hniu.community.CommunityApplication  : Started CommunityApplication in 2.396 seconds (JVM running for 2.927)<br>2020-09-07 10:42:56.418  INFO 11117 --- [nio-8080-exec-1] o.a.c.c.C.[.[localhost].[/community]     : Initializing Spring DispatcherServlet \'dispatcherServlet\'<br>2020-09-07 10:42:56.419  INFO 11117 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet \'dispatcherServlet\'<br>2020-09-07 10:42:56.426  INFO 11117 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 7 ms<br>2020-09-07 10:42:56.664 DEBUG 11117 --- [nio-8080-exec-2] e.h.c.dao.UserInfoDao.getAccountName     : ==&gt;  Preparing: select accountName from userinfo where email=? <br>2020-09-07 10:42:56.674 DEBUG 11117 --- [nio-8080-exec-2] e.h.c.dao.UserInfoDao.getAccountName     : ==&gt; Parameters: (String)<br>2020-09-07 10:42:56.682 DEBUG 11117 --- [nio-8080-exec-2] e.h.c.dao.UserInfoDao.getAccountName     : &lt;==      Total: 0<br>2020-09-07 10:42:56.685 DEBUG 11117 --- [nio-8080-exec-4] e.h.c.d.P.getPublishMessage_COUNT        : ==&gt;  Preparing: SELECT count(0) FROM userinfo u RIGHT JOIN question q ON u.id = q.creatorid <br>2020-09-07 10:42:56.686 DEBUG 11117 --- [nio-8080-exec-4] e.h.c.d.P.getPublishMessage_COUNT        : ==&gt; Parameters: <br>2020-09-07 10:42:56.688 DEBUG 11117 --- [nio-8080-exec-4] e.h.c.d.P.getPublishMessage_COUNT        : &lt;==      Total: 1<br>2020-09-07 10:42:56.690 DEBUG 11117 --- [nio-8080-exec-4] e.h.c.dao.PublishDao.getPublishMessage   : ==&gt;  Preparing: SELECT u.icon,q.* FROM userinfo u right join question q on u.id=q.creatorid LIMIT ? <br>2020-09-07 10:42:56.691 DEBUG 11117 --- [nio-8080-exec-4] e.h.c.dao.PublishDao.getPublishMessage   : ==&gt; Parameters: 10(Integer)<br>2020-09-07 10:42:56.696 DEBUG 11117 --- [nio-8080-exec-4] e.h.c.dao.PublishDao.getPublishMessage   : &lt;==      Total: 1<br>2020-09-07 10:42:59.955 DEBUG 11117 --- [nio-8080-exec-8] e.h.c.dao.UserInfoDao.loginCheck         : ==&gt;  Preparing: select count(1) from userinfo WHERE email=? and password=? <br>2020-09-07 10:42:59.956 DEBUG 11117 --- [nio-8080-exec-8] e.h.c.dao.UserInfoDao.loginCheck         : ==&gt; Parameters: 1503021658@qq.com(String), e10adc3949ba59abbe56e057f20f883e(String)<br>2020-09-07 10:42:59.957 DEBUG 11117 --- [nio-8080-exec-8] e.h.c.dao.UserInfoDao.loginCheck         : &lt;==      Total: 1<br>2020-09-07 10:42:59.961 DEBUG 11117 --- [nio-8080-exec-8] e.h.c.dao.UserInfoDao.updateToken        : ==&gt;  Preparing: update userinfo SET token=? where email=? <br>2020-09-07 10:42:59.962 DEBUG 11117 --- [nio-8080-exec-8] e.h.c.dao.UserInfoDao.updateToken        : ==&gt; Parameters: 03e2139f-907c-4e58-8f9d-f89ef4b6e3ef(String), 1503021658@qq.com(String)<br>2020-09-07 10:42:59.965 DEBUG 11117 --- [nio-8080-exec-8] e.h.c.dao.UserInfoDao.updateToken        : &lt;==    Updates: 1<br>2020-09-07 10:43:00.118 DEBUG 11117 --- [nio-8080-exec-4] e.h.c.d.P.getPublishMessage_COUNT        : ==&gt;  Preparing: SELECT count(0) FROM userinfo u RIGHT JOIN question q ON u.id = q.creatorid <br>2020-09-07 10:43:00.118 DEBUG 11117 --- [nio-8080-exec-4] e.h.c.d.P.getPublishMessage_COUNT        : ==&gt; Parameters: <br>2020-09-07 10:43:00.120 DEBUG 11117 --- [nio-8080-exec-4] e.h.c.d.P.getPublishMessage_COUNT        : &lt;==      Total: 1<br>2020-09-07 10:43:00.123 DEBUG 11117 --- [nio-8080-exec-4] e.h.c.dao.PublishDao.getPublishMessage   : ==&gt;  Preparing: SELECT u.icon,q.* FROM userinfo u right join question q on u.id=q.creatorid LIMIT ? <br>2020-09-07 10:43:00.124 DEBUG 11117 --- [nio-8080-exec-4] e.h.c.dao.PublishDao.getPublishMessage   : ==&gt; Parameters: 10(Integer)<br>2020-09-07 10:43:00.127 DEBUG 11117 --- [nio-8080-exec-4] e.h.c.dao.PublishDao.getPublishMessage   : &lt;==      Total: 1<br>2020-09-07 10:43:00.130 DEBUG 11117 --- [io-8080-exec-10] e.h.c.dao.UserInfoDao.getAccountName     : ==&gt;  Preparing: select accountName from userinfo where email=? <br>2020-09-07 10:43:00.131 DEBUG 11117 --- [io-8080-exec-10] e.h.c.dao.UserInfoDao.getAccountName     : ==&gt; Parameters: 1503021658@qq.com(String)<br>2020-09-07 10:43:00.134 DEBUG 11117 --- [io-8080-exec-10] e.h.c.dao.UserInfoDao.getAccountName     : &lt;==      Total: 1<br>2020-09-07 10:43:07.471 DEBUG 11117 --- [nio-8080-exec-7] e.h.c.dao.UserInfoDao.getAccountName     : ==&gt;  Preparing: select accountName from userinfo where email=? <br>2020-09-07 10:43:07.474 DEBUG 11117 --- [nio-8080-exec-7] e.h.c.dao.UserInfoDao.getAccountName     : ==&gt; Parameters: 1503021658@qq.com(String)<br>2020-09-07 10:43:07.476 DEBUG 11117 --- [nio-8080-exec-7] e.h.c.dao.UserInfoDao.getAccountName     : &lt;==      Total: 1</code></pre><p><br></p>', 29, 1, 2, 14, 0, '2020-09-07');
INSERT INTO `question` VALUES (3, '论坛的主题功能基本已经OK了', '<p>来看看代码吧</p><p><span style=\"background-color: rgb(241, 241, 241); color: inherit; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; font-size: inherit; white-space: pre-wrap;\">用ajax获取登录态？？？</span></p><p><span style=\"background-color: rgb(241, 241, 241); color: inherit; font-family: Menlo, Monaco, Consolas, &quot;Courier New&quot;, monospace; font-size: inherit; white-space: pre-wrap;\">$(function () {</span></p><pre><code>        $.ajax({<br>            url: \"user/getSession\",<br>            type: \"GET\",<br>            contentType: \"application/json;charset=utf-8\",<br>            success: function (response) {<br>                email = response;<br>                refresh()<br>            }<br>        })<br>    })</code></pre><table border=\"0\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\"><tbody><tr><th>功能</th><th>实现</th></tr><tr><td>多个页面 获取登录态</td><td>&nbsp;。。。。。。。</td></tr></tbody></table><p><br></p>', 29, 1, 2, 8, 0, '2020-09-07');
INSERT INTO `question` VALUES (8, '你看过那些文学作品', '<p>我最爱的书籍是《平凡的世界》</p>', 29, 2, 1, 37, 0, '2020-09-18');
INSERT INTO `question` VALUES (11, '你期待校园文化节吗', '<p>校园文化节在每年的11月份或则12月份</p>', 29, 12, 0, 49, 0, '2020-09-18');
INSERT INTO `question` VALUES (22, '长沙有哪些好点旅游地点？来分享吧', '<p>我个人比较喜欢去岳麓山爬山啊，还有橘子洲啊。挺好的</p>', 29, 3, 1, 49, 0, '2020-09-18');
INSERT INTO `question` VALUES (24, '目前web的主流技术，有哪些？', '<p>例如Springboot，vue？</p>', 29, 1, 0, 31, 0, '2020-09-22');
INSERT INTO `question` VALUES (25, '现在的人工智能技术成熟到什么程度了？', '<p>人工智能AI例如：阿尔法狗碾压国际星际争霸高手</p>', 29, 1, 2, 13, 0, '2020-09-22');
INSERT INTO `question` VALUES (26, '这是一个测试用例', '<p>测试用例</p>', 29, 1, 0, 13, 0, '2020-09-24');
INSERT INTO `question` VALUES (28, '你热爱文学吗？', '<p>分享一下你喜欢的书籍吧！</p>', 29, 2, 2, 24, 0, '2020-09-24');
INSERT INTO `question` VALUES (29, '关于中国文学诺贝尔奖 莫言的故事', '<p>你所知道的关于莫言的故事快来分享一下吧！</p>', 29, 2, 0, 6, 0, '2020-09-24');
INSERT INTO `question` VALUES (30, '我们的校园文化有哪些？', '<p>大家可以分享一下啊</p>', 29, 12, 0, 9, 0, '2020-09-24');
INSERT INTO `question` VALUES (32, '我们的校园文化有哪些？', '<p>大家可以分享一下啊</p>', 29, 12, 0, 0, 0, '2020-09-24');
INSERT INTO `question` VALUES (33, '我们的校园文化有哪些？', '<p>大家可以分享一下啊</p>', 29, 12, 0, 1, 0, '2020-09-24');
INSERT INTO `question` VALUES (34, '我们的校园文化有哪些？', '<p>大家可以分享一下啊</p>', 29, 12, 0, 1, 0, '2020-09-24');
INSERT INTO `question` VALUES (36, '你喜欢旅游吗', '<p>你喜欢去哪个城市？</p>', 29, 3, 0, 2, 0, '2020-09-24');
INSERT INTO `question` VALUES (37, '我们的校园文化有哪些？', '<p>大家可以分享一下啊</p>', 29, 12, 0, 2, 0, '2020-09-24');
INSERT INTO `question` VALUES (38, '国庆节旅游攻略', '<p>国庆节旅游攻略：你喜欢去哪里玩？</p>', 29, 3, 0, 1, 0, '2020-09-24');
INSERT INTO `question` VALUES (39, '编码能力不行', '<p>技术成长是的花点时间1</p>', 29, 1, 0, 46, 1, '2020-10-08');
INSERT INTO `question` VALUES (40, '如何过好‘人生’？', '<p><span style=\"font-weight: bold;\">你看过那些形形色色的人？</span></p><p>&nbsp; &nbsp; &nbsp; &nbsp; 有人热爱学习，选择生活。有人厌倦学习，选择安逸。不同的活法，当然有着不同的人生。我仅走过21年时光，未曾见过世面，未曾设想过社会的险恶。未来虽恶，但愿指鹿为马，勇敢向前。未来可期，少年。<span style=\"font-weight: bold;\"><br></span></p>', 29, 2, 0, 6, 1, '2020-10-08');

-- ----------------------------
-- Table structure for question_type
-- ----------------------------
DROP TABLE IF EXISTS `question_type`;
CREATE TABLE `question_type`  (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `type_createTime` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question_type
-- ----------------------------
INSERT INTO `question_type` VALUES (1, '科学技术', '2020-09-07 11:47:48');
INSERT INTO `question_type` VALUES (2, '文学', '2020-09-14 09:42:10');
INSERT INTO `question_type` VALUES (3, '旅游', '2020-09-13 16:39:59');
INSERT INTO `question_type` VALUES (12, '校园文化', '2020-09-13 16:55:41');

-- ----------------------------
-- Table structure for roleinfo
-- ----------------------------
DROP TABLE IF EXISTS `roleinfo`;
CREATE TABLE `roleinfo`  (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`roleid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of roleinfo
-- ----------------------------
INSERT INTO `roleinfo` VALUES (1, '超级管理员');
INSERT INTO `roleinfo` VALUES (2, '管理员');
INSERT INTO `roleinfo` VALUES (3, '用户');

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `accountName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `roleid` int(11) DEFAULT 3,
  `token` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sex` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `sginName` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `qq` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `WeChat` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `mobile` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `github` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `microblog` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_accountName_uindex`(`accountName`) USING BTREE,
  UNIQUE INDEX `user_email_uindex`(`email`) USING BTREE,
  INDEX `roleid`(`roleid`) USING BTREE,
  CONSTRAINT `userinfo_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `roleinfo` (`roleid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES (29, '1503021658@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '超级管理员', 1, '44dd28ae-932c-452c-a6b6-651c8186ca75', '男', '17ebea49-ddb0-43a6-8b1e-0b389da7c9ee.jpeg', '勇往直前', '1503021658', '15773425244', '10010', 'github', '无');
INSERT INTO `userinfo` VALUES (33, 'test31', 'e10adc3949ba59abbe56e057f20f883e', '测试用例31', 2, 'dfba8142-e706-456d-bb20-1117dc2d6ef8', NULL, '4c637c72-16af-4c2b-b960-6f0b04b4686f.png', NULL, NULL, NULL, '123456', NULL, NULL);
INSERT INTO `userinfo` VALUES (34, 'test3', 'e10adc3949ba59abbe56e057f20f883e', '测试用例3', 2, 'a886dbb2-0fd9-4e0a-a2ab-fb75e5306a32', NULL, '7411fd77-b8ed-4cfd-8b2f-1e0ce333c946.jpeg', NULL, NULL, NULL, '11', NULL, NULL);
INSERT INTO `userinfo` VALUES (35, 'test4', 'e10adc3949ba59abbe56e057f20f883e', '测试用例4', 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (36, 'test5', 'e10adc3949ba59abbe56e057f20f883e', '测试用例5', 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (37, 'test6', 'e10adc3949ba59abbe56e057f20f883e', '测试用例6', 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (39, 'test', 'e10adc3949ba59abbe56e057f20f883e', '测试用例8', 3, '9d51ee4a-5d09-4b79-be91-587bfda0caa3', NULL, 'dea35ded-dd49-49aa-bd14-e104b17a8690.png', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `userinfo` VALUES (40, 'test9', 'e10adc3949ba59abbe56e057f20f883e', '测试用例9', 3, NULL, NULL, NULL, NULL, NULL, NULL, '123456', NULL, NULL);
INSERT INTO `userinfo` VALUES (41, 'xiayu@163.com', 'e10adc3949ba59abbe56e057f20f883e', '夏雨', 3, NULL, NULL, NULL, NULL, NULL, NULL, '10010', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
