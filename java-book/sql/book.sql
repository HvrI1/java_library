

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books`  (
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `author` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `statm` int(0) NOT NULL,
  `id` int(0) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('《百年孤独》', '加西亚·马尔克斯', 0, 7);
INSERT INTO `books` VALUES ('《1984》', '乔治·奥威尔', 0, 8);
INSERT INTO `books` VALUES ('《追风筝的人》', '卡勒德·胡赛尼', 0, 9);
INSERT INTO `books` VALUES ('《简爱》', '夏洛蒂·勃朗特', 0, 10);
INSERT INTO `books` VALUES ('《傲慢与偏见》', '简·奥斯汀', 0, 11);
INSERT INTO `books` VALUES ('《红与黑》', '司汤达', 0, 12);
INSERT INTO `books` VALUES ('《安娜·卡列尼娜》', '列夫·托尔斯泰', 0, 13);
INSERT INTO `books` VALUES ('《麦田里的守望者》', 'J.D.塞林格', 0, 14);
INSERT INTO `books` VALUES ('《小王子》', '安托万·德·圣-埃克苏佩里', 0, 15);
INSERT INTO `books` VALUES ('《霍乱时期的爱情》', '加西亚·马尔克斯', 0, 16);
INSERT INTO `books` VALUES ('《了不起的盖茨比》', 'F.斯科特·菲茨杰拉德', 0, 17);
INSERT INTO `books` VALUES ('《局外人》', '阿尔贝·加缪', 0, 18);
INSERT INTO `books` VALUES ('《罪与罚》', '陀思妥耶夫斯基', 0, 19);
INSERT INTO `books` VALUES ('《局外人》', '阿尔贝·加缪', 0, 20);
INSERT INTO `books` VALUES ('《1984》', '乔治·奥威尔', 0, 21);


-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `statm` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'aa', '11', 1);
INSERT INTO `user` VALUES (2, 'ss', '22', 0);
INSERT INTO `user` VALUES (3, 'bb', '44', 0);

-- ----------------------------
-- Table structure for user_books
-- ----------------------------
DROP TABLE IF EXISTS `user_books`;
CREATE TABLE `user_books`  (
  `uid` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `bid` int(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_books
-- ----------------------------
INSERT INTO `user_books` VALUES ('1', 1);

SET FOREIGN_KEY_CHECKS = 1;
