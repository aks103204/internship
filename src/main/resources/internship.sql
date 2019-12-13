-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.7.17-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 tramnasys 的数据库结构
CREATE DATABASE IF NOT EXISTS `tramnasys` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tramnasys`;


-- 导出  视图 tramnasys.admin_view 结构
-- 创建临时表以解决视图依赖性错误
CREATE TABLE `admin_view` (
	`ano` VARCHAR(20) NOT NULL COLLATE 'utf8_general_ci',
	`psd` VARCHAR(100) NOT NULL COLLATE 'utf8_general_ci',
	`name` VARCHAR(100) NULL COLLATE 'utf8_general_ci',
	`phone` VARCHAR(100) NULL COLLATE 'utf8_general_ci',
	`qq` VARCHAR(100) NULL COLLATE 'utf8_general_ci'
) ENGINE=MyISAM;


-- 导出  视图 tramnasys.allstudent_studyplace_view 结构
-- 创建临时表以解决视图依赖性错误
CREATE TABLE `allstudent_studyplace_view` (
	`city` VARCHAR(20) NULL COLLATE 'utf8_general_ci',
	`tno` VARCHAR(20) NOT NULL COLLATE 'utf8_general_ci'
) ENGINE=MyISAM;


-- 导出  视图 tramnasys.class_view 结构
-- 创建临时表以解决视图依赖性错误
CREATE TABLE `class_view` 
) ENGINE=MyISAM;


-- 导出  事件 tramnasys.event_remind_status 结构
DELIMITER //
CREATE DEFINER=`root`@`localhost` EVENT `event_remind_status` ON SCHEDULE EVERY 1 SECOND STARTS '2019-01-12 14:18:17' ON COMPLETION PRESERVE ENABLE DO begin  
call update_task_status();  
end//
DELIMITER ;


-- 导出  视图 tramnasys.file_view 结构
-- 创建临时表以解决视图依赖性错误
CREATE TABLE `file_view` (
	`fno` INT(11) NOT NULL,
	`filename` VARCHAR(100) NULL COLLATE 'utf8_general_ci',
	`filetype` VARCHAR(30) NULL COLLATE 'utf8_general_ci',
	`time` VARCHAR(200) NULL COLLATE 'utf8_general_ci',
	`task_no` INT(11) NULL,
	`owe_perNo` VARCHAR(200) NULL COLLATE 'utf8_general_ci'
) ENGINE=MyISAM;


-- 导出  视图 tramnasys.registration_view 结构
-- 创建临时表以解决视图依赖性错误
CREATE TABLE `registration_view` (
	`rno` VARCHAR(50) NOT NULL COLLATE 'utf8_general_ci',
	`province` VARCHAR(20) NULL COLLATE 'utf8_general_ci',
	`city` VARCHAR(20) NULL COLLATE 'utf8_general_ci',
	`company` VARCHAR(50) NULL COLLATE 'utf8_general_ci',
	`linkman` VARCHAR(30) NULL COLLATE 'utf8_general_ci',
	`linkmanphone` VARCHAR(30) NULL COLLATE 'utf8_general_ci'
) ENGINE=MyISAM;


-- 导出  视图 tramnasys.student_view 结构
-- 创建临时表以解决视图依赖性错误
CREATE TABLE `student_view` 
) ENGINE=MyISAM;


-- 导出  表 tramnasys.task 结构
CREATE TABLE IF NOT EXISTS `task` (
  `task_no` int(11) NOT NULL AUTO_INCREMENT,
  `task_name` varchar(100) DEFAULT NULL,
  `tno` varchar(24) DEFAULT NULL,
  `task_content` varchar(1000) DEFAULT NULL,
  `submit` tinyint(1) DEFAULT '0',
  `start_time` datetime DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`task_no`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- 正在导出表  tramnasys.task 的数据：~12 rows (大约)
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` (`task_no`, `task_name`, `tno`, `task_content`, `submit`, `start_time`, `end_time`, `create_time`) VALUES
	(5, '作业一', '10001', '1.       作业内容：\r\n\r\n制作一个个人展示网站，内容自定，网站采用DIV+CSS布局。基于JSP或者Model 1（JSP + Java Bean）的方式在第2次作业的基础上添加相关信息（信息内容自定）的增、删、改（有数据校验）、查（组合查询、可分页）等功能，\r\n\r\n \r\n\r\n2.       作业要求：\r\n\r\n（1）       班级内每位同学的网站均不相同并且必须自行完成，不得从网上下载，禁止拷贝。\r\n\r\n（2）       要求在该网站中必须使用到HTML、CSS、JavaScript、JSP、Java Bean、JDBC等Web技术；数据在增加、修改时必须有基本的数据校验；数据库中的表格应当有主键字段；数据库文件统一放置在"d:\\temp\\db"目录下。\r\n\r\n（3）       网站制作完成后给出一个简要的说明（不少于500字），内容包括：数据库结构，每个类与每个JSP页面的功能与作用，制作过程中遇到的问题以及解决办法（不少于200字）。\r\n\r\n（4）       代码的排版必须缩进对齐，并有关键性的注释。\r\n\r\n\r\n3.       提交内容：\r\n\r\n（1）       附件内应当包含工程的源代码与SQL脚本以及网站制作说明。\r\n\r\n（2）       要求war文件与数据库文件均以学号命名，并统一提交给学委后再交给助教。\r\n                    ', 0, '2019-01-15 00:00:00', '2019-01-15 12:12:00', '2019-01-15 21:37:38'),
	(6, '作业二', '10001', '从下面四个类别中任选一个来写一篇科技论文：\r\n1.黑盒测试技术综述\r\n2.白盒测试技术综述\r\n3.面向对象测试技术综述\r\n4.Web测试技术综述\r\n\r\n具体题目自拟\r\n\r\n（1）建议结合我们的课程内容来写这篇课程论文（每人一份），要求字数3000-5000，格式要求见“格式要求”附件\r\n\r\n（2）每名同学做一份论文内容摘要的PPT（主要讲解论文的主要内容概要，答辩用，时间控制在五分钟以内）\r\n上交时间：最后一次课程之前（最后一次课程安排部分同学以PPT方式陈述论文内容）\r\n\r\n上交方式：论文采用word编辑，将Word文档命名为“学号-姓名-课程论文”，ppt采用powerpoint编辑，将ppt文件命名为“学号-姓名-答辩ppt”，不要压缩，以附件形式发送到超星系统。\r\n                    \r\n\r\n                    ', 1, '2017-06-30 13:30:00', '2019-01-16 16:59:00', '2019-01-15 21:40:31'),
	(7, '任务三', '10001', '测试文房\r\n                    ', 1, '2019-01-15 11:01:00', '2019-01-15 22:22:00', '2019-01-15 21:49:59'),
	(8, '任务4', '10001', '做足偶都速度搜啊读书\r\n                    ', 1, '2019-01-15 00:00:00', '2019-01-19 00:00:00', '2019-01-15 22:26:59'),
	(11, '任务100', '10001', '何文勇写作业\r\n                    ', 1, '2019-01-16 00:00:00', '2019-01-16 11:46:00', '2019-01-16 11:44:46'),
	(12, '任务199999', '10001', '14:02的测试任务\r\n                    \r\n\r\n                    ', 1, '2017-06-30 13:30:00', '2019-01-16 14:11:00', '2019-01-16 14:02:35'),
	(13, '任务1888', '10001', '东方红积分会尽快发货就爱开发商实际\r\n                    ', 1, '2019-01-16 00:00:00', '2019-01-16 14:19:00', '2019-01-16 14:17:55'),
	(14, '任务12', '10001', '我是谁，我从哪里来\r\n                    ', 1, '2019-01-16 00:00:00', '2019-01-16 14:49:00', '2019-01-16 14:46:12'),
	(15, '任务789', NULL, '我问哈咖啡机哈空间和巴萨时看见\r\n                    ', 0, '2019-01-16 00:00:00', '2019-01-16 15:00:00', '2019-01-16 14:53:53'),
	(16, '任务789', '10001', '法伤结果哈萨克1\r\n                    ', 1, '2019-01-16 00:00:00', '2019-01-16 15:00:00', '2019-01-16 14:55:10'),
	(17, '任务98745631', '10001', '16:08\r\n                    ', 1, '2019-01-16 00:00:00', '2019-01-16 16:20:00', '2019-01-16 16:09:00'),
	(18, '任务150000', '10001', '发哈空间发噶会计法\r\n                    ', 1, '2019-01-16 00:00:00', '2019-01-16 17:12:00', '2019-01-16 17:07:40');
/*!40000 ALTER TABLE `task` ENABLE KEYS */;


-- 导出  视图 tramnasys.task_view 结构
-- 创建临时表以解决视图依赖性错误
CREATE TABLE `task_view` (
	`task_no` INT(11) NOT NULL,
	`task_name` VARCHAR(100) NULL COLLATE 'utf8_general_ci',
	`tno` VARCHAR(24) NULL COLLATE 'utf8_general_ci',
	`task_content` VARCHAR(1000) NULL COLLATE 'utf8_general_ci',
	`submit` TINYINT(1) NULL,
	`start_time` DATETIME NULL,
	`end_time` DATETIME NULL,
	`create_time` DATETIME NULL
) ENGINE=MyISAM;


-- 导出  视图 tramnasys.tc_view 结构
-- 创建临时表以解决视图依赖性错误
CREATE TABLE `tc_view` (
	`cno` VARCHAR(30) NOT NULL COLLATE 'utf8_general_ci',
	`tno` VARCHAR(20) NOT NULL COLLATE 'utf8_general_ci'
) ENGINE=MyISAM;


-- 导出  视图 tramnasys.teacher_view 结构
-- 创建临时表以解决视图依赖性错误
CREATE TABLE `teacher_view` 
) ENGINE=MyISAM;


-- 导出  表 tramnasys.t_admin 结构
CREATE TABLE IF NOT EXISTS `t_admin` (
  `ano` varchar(20) NOT NULL,
  `psd` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `phone` varchar(100) DEFAULT NULL,
  `qq` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`ano`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  tramnasys.t_admin 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `t_admin` DISABLE KEYS */;
INSERT INTO `t_admin` (`ano`, `psd`, `name`, `phone`, `qq`) VALUES
	('1001', '123', '叶老师', '110123321', '123456333');
/*!40000 ALTER TABLE `t_admin` ENABLE KEYS */;


-- 导出  表 tramnasys.t_class 结构
CREATE TABLE IF NOT EXISTS `t_class` (
  `cno` varchar(20) NOT NULL,
  `cprofession` varchar(108) DEFAULT NULL,
  `totalPerson` int(11) DEFAULT NULL,
  PRIMARY KEY (`cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  tramnasys.t_class 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `t_class` DISABLE KEYS */;
INSERT INTO `t_class` (`cno`, `cprofession`, `totalPerson`) VALUES
	('162014', '软件', 4),
	('162015', '软件', 4);
/*!40000 ALTER TABLE `t_class` ENABLE KEYS */;


-- 导出  表 tramnasys.t_file 结构
CREATE TABLE IF NOT EXISTS `t_file` (
  `fno` int(11) NOT NULL AUTO_INCREMENT,
  `filename` varchar(100) DEFAULT NULL,
  `filetype` varchar(30) DEFAULT NULL,
  `time` varchar(200) DEFAULT NULL,
  `task_no` int(11) DEFAULT NULL,
  `owe_perNo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`fno`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- 正在导出表  tramnasys.t_file 的数据：~25 rows (大约)
/*!40000 ALTER TABLE `t_file` DISABLE KEYS */;
INSERT INTO `t_file` (`fno`, `filename`, `filetype`, `time`, `task_no`, `owe_perNo`) VALUES
	(1, 'tea.xlsx', 'xlsx', '2019-12-10 11:00:22', NULL, '10020'),
	(2, 'tea.xlsx', 'xlsx', '2019-12-10 11:11:30', NULL, '10020'),
	(3, 'tea.xlsx', 'xlsx', '2019-12-10 11:17:33', NULL, '10020'),
	(4, 'tea.xlsx', 'xlsx', '2019-12-10 11:20:20', NULL, '10020'),
	(5, 'tea.xlsx', 'xlsx', '2019-12-10 11:26:12', NULL, '10020'),
	(6, 'tea.xlsx', 'xlsx', '2019-12-10 11:28:20', NULL, '10020'),
	(7, 'tea.xlsx', 'xlsx', '2019-12-10 11:29:48', NULL, '10020'),
	(8, 'tea.xlsx', 'xlsx', '2019-12-10 11:32:15', NULL, '10020'),
	(9, 'tea.xlsx', 'xlsx', '2019-12-10 11:34:46', NULL, '10020'),
	(10, 'tea.xlsx', 'xlsx', '2019-12-10 11:36:33', NULL, '10020'),
	(11, 'tea.xlsx', 'xlsx', '2019-12-10 11:37:13', NULL, '10020'),
	(12, 'tea.xlsx', 'xlsx', '2019-12-10 11:44:04', NULL, '10020'),
	(13, 'tea.xlsx', 'xlsx', '2019-12-10 12:52:43', NULL, '10020'),
	(14, 'stu.xlsx', 'xlsx', '2019-12-10 12:53:25', NULL, '16201433'),
	(15, 'stu.xlsx', 'xlsx', '2019-12-10 12:56:58', NULL, '16201433'),
	(16, 'tea.xlsx', 'xlsx', '2019-12-10 13:53:55', NULL, '10020'),
	(17, 'stu.xlsx', 'xlsx', '2019-12-11 12:38:47', NULL, '16201445'),
	(18, 'stu.xlsx', 'xlsx', '2019-12-11 12:48:31', NULL, '16201445'),
	(19, 'stu.xlsx', 'xlsx', '2019-12-11 12:51:14', NULL, '16201445'),
	(20, 'stu.xlsx', 'xlsx', '2019-12-11 12:54:58', NULL, '16201445'),
	(21, 'stu.xlsx', 'xlsx', '2019-12-11 13:01:44', NULL, '16201445'),
	(22, 'stu.xlsx', 'xlsx', '2019-12-11 13:03:53', NULL, '16201445'),
	(23, 'stu.xlsx', 'xlsx', '2019-12-11 13:12:32', NULL, '16201445'),
	(24, 'stu.xlsx', 'xlsx', '2019-12-11 13:13:35', NULL, '16201445'),
	(25, 'stu.xlsx', 'xlsx', '2019-12-11 13:21:16', NULL, '16201425');
/*!40000 ALTER TABLE `t_file` ENABLE KEYS */;


-- 导出  表 tramnasys.t_registration 结构
CREATE TABLE IF NOT EXISTS `t_registration` (
  `rno` varchar(50) NOT NULL,
  `province` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `company` varchar(50) DEFAULT NULL,
  `linkman` varchar(30) DEFAULT NULL,
  `linkmanphone` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`rno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  tramnasys.t_registration 的数据：~40 rows (大约)
/*!40000 ALTER TABLE `t_registration` DISABLE KEYS */;
INSERT INTO `t_registration` (`rno`, `province`, `city`, `company`, `linkman`, `linkmanphone`) VALUES
	('16201401', '上海', '西安', '北京航空航天', '何文勇', '123421'),
	('16201402', '广东', '西安', '北京航空航天', '何文勇', '123421'),
	('16201403', '北京', '西安', '北京航空航天', '何文勇', '123421'),
	('16201404', '北京', '西安', '北京航空航天', '何文勇', '123421'),
	('16201405', '北京', '西安', '北京航空航天', '何文勇', '123421'),
	('16201406', '北京', '西安', '北京航空航天', '何文勇', '123421'),
	('16201407', '北京', '西安', '北京航空航天', '何文勇', '123421'),
	('16201408', '北京', '西安', '北京航空航天', '何文勇', '123421'),
	('16201409', '北京', '西安', '北京航空航天', '何文勇', '123421'),
	('16201410', '北京', '西安', '北京航空航天', '何文勇', '123421'),
	('16201411', '上海', '西安', '北京航空航天', '何文勇', '123421'),
	('16201412', '广东', '西安', '北京航空航天', '何文勇', '123421'),
	('16201413', '北京', '西安', '北京航空航天', '何文勇', '123421'),
	('16201414', '北京', '西安', '北京航空航天', '何文勇', '123421'),
	('16201415', '北京', '西安', '北京航空航天', '何文勇', '123421'),
	('16201416', '北京', '西安', '北京航空航天', '何文勇', '123421'),
	('16201417', '北京', '西安', '北京航空航天', '何文勇', '123421'),
	('16201418', '北京', '西安', '北京航空航天', '何文勇', '123421'),
	('16201419', '北京', '西安', '北京航空航天', '何文勇', '123421'),
	('16201420', '北京', '西安', '北京航空航天', '何文勇', '123421'),
	('16201501', '北京', '北京', '北京航空航天', '何文勇', '123421'),
	('16201502', '广东', '广州', '北京航空航天', '何文勇', '123421'),
	('16201503', '北京', '大连', '北京航空航天', '何文勇', '123421'),
	('16201504', '北京', '南宁', '北京航空航天', '何文勇', '123421'),
	('16201505', '北京', '西安', '北京航空航天', '何文勇', '123421'),
	('16201506', '北京', '拉萨', '北京航空航天', '何文勇', '123421'),
	('16201507', '北京', '长春', '北京航空航天', '何文勇', '123421'),
	('16201508', '北京', '包头', '北京航空航天', '何文勇', '123421'),
	('16201509', '北京', '重庆', '北京航空航天', '何文勇', '123421'),
	('16201510', '北京', '常州', '北京航空航天', '何文勇', '123421'),
	('16201511', '上海', '上海', '北京航空航天', '何文勇', '123421'),
	('16201512', '广东', '上海', '北京航空航天', '何文勇', '123421'),
	('16201513', '北京', '广州', '北京航空航天', '何文勇', '123421'),
	('16201514', '北京', '重庆', '北京航空航天', '何文勇', '123421'),
	('16201515', '北京', '西安', '北京航空航天', '何文勇', '123421'),
	('16201516', '北京', '西安', '北京航空航天', '何文勇', '123421'),
	('16201517', '北京', '西安', '北京航空航天', '何文勇', '123421'),
	('16201518', '北京', '重庆', '北京航空航天', '何文勇', '123421'),
	('16201519', '北京', '重庆', '北京航空航天', '何文勇', '123421'),
	('16201520', '北京', '重庆', '北京航空航天', '何文勇', '123421');
/*!40000 ALTER TABLE `t_registration` ENABLE KEYS */;


-- 导出  表 tramnasys.t_student 结构
CREATE TABLE IF NOT EXISTS `t_student` (
  `sno` varchar(50) NOT NULL,
  `cno` varchar(20) NOT NULL,
  `spsd` varchar(100) DEFAULT NULL,
  `sname` varchar(100) DEFAULT NULL,
  `sphone` varchar(100) DEFAULT NULL,
  `qq` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  tramnasys.t_student 的数据：~21 rows (大约)
/*!40000 ALTER TABLE `t_student` DISABLE KEYS */;
INSERT INTO `t_student` (`sno`, `cno`, `spsd`, `sname`, `sphone`, `qq`) VALUES
	('16201401', '162014', '123', '伊布拉希莫维奇', '18846142222', '123'),
	('16201402', '162014', '124', '加图索', '18846142223', '124'),
	('16201403', '161947', '125', '马尔蒂尼', '18846142224', '125'),
	('16201404', '161871', '126', 'bsa', '18846142225', '126'),
	('16201405', '161795', '127', 'yed', '18846142226', '127'),
	('16201406', '161719', '128', 'bsa', '18846142227', '128'),
	('16201407', '161643', '129', 'yed', '18846142228', '129'),
	('16201408', '161567', '130', 'bsa', '18846142229', '130'),
	('16201409', '161491', '131', 'yed', '18846142230', '131'),
	('16201410', '161415', '132', 'bsa', '18846142231', '132'),
	('16201411', '161339', '133', 'yed', '18846142232', '133'),
	('16201412', '161263', '134', 'bsa', '18846142233', '134'),
	('16201413', '161187', '135', 'yed', '18846142234', '135'),
	('16201414', '161111', '136', 'bsa', '18846142235', '136'),
	('16201415', '161035', '137', 'yed', '18846142236', '137'),
	('16201416', '160959', '138', 'bsa', '18846142237', '138'),
	('16201417', '160883', '139', 'yed', '18846142238', '139'),
	('16201418', '160807', '140', 'bsa', '18846142239', '140'),
	('16201419', '160731', '141', 'yed', '18846142240', '141'),
	('16201420', '160655', '142', 'bsa', '18846142241', '142'),
	('16201421', '160579', '143', 'yed', '18846142242', '143');
/*!40000 ALTER TABLE `t_student` ENABLE KEYS */;


-- 导出  表 tramnasys.t_tc 结构
CREATE TABLE IF NOT EXISTS `t_tc` (
  `cno` varchar(30) NOT NULL,
  `tno` varchar(20) NOT NULL,
  PRIMARY KEY (`cno`,`tno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  tramnasys.t_tc 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_tc` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_tc` ENABLE KEYS */;


-- 导出  表 tramnasys.t_teacher 结构
CREATE TABLE IF NOT EXISTS `t_teacher` (
  `tno` varchar(24) NOT NULL,
  `tpsd` varchar(108) NOT NULL,
  `tname` varchar(108) NOT NULL,
  `tphone` varchar(108) NOT NULL,
  `tqq` varchar(108) DEFAULT NULL,
  `tprofession` varchar(108) DEFAULT NULL,
  PRIMARY KEY (`tno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  tramnasys.t_teacher 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `t_teacher` DISABLE KEYS */;
INSERT INTO `t_teacher` (`tno`, `tpsd`, `tname`, `tphone`, `tqq`, `tprofession`) VALUES
	('10019', '111', '叶德利肯杰太', '18846142222', '123', '网络'),
	('10020', '123123', 'yedel', '18846142222', '123', '网络'),
	('10021', '111', '郭导', '18846142222', '123', '网络'),
	('10022', '234', '铅笔', '18846142222', '123', '网络'),
	('10025', '111', '叶德利', '18846142222', '123', '网络');
/*!40000 ALTER TABLE `t_teacher` ENABLE KEYS */;


-- 导出  表 tramnasys.t_ts 结构
CREATE TABLE IF NOT EXISTS `t_ts` (
  `sno` varchar(30) NOT NULL,
  `tno` varchar(20) NOT NULL,
  PRIMARY KEY (`sno`,`tno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  tramnasys.t_ts 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `t_ts` DISABLE KEYS */;
INSERT INTO `t_ts` (`sno`, `tno`) VALUES
	('16201401', '10022'),
	('16201401', '10025'),
	('16201402', '10025');
/*!40000 ALTER TABLE `t_ts` ENABLE KEYS */;


-- 导出  过程 tramnasys.update_task_status 结构
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `update_task_status`()
BEGIN  
    
IF exists (SELECT task.task_no from task where  SYSDATE()>=task.end_time) 
THEN  
            
update student_task set task_staus='已过期'  
            
where task_no in 
(SELECT task.task_no from task where  SYSDATE()>=task.end_time);  
    
END IF;  
END//
DELIMITER ;


-- 导出  触发器 tramnasys.update_student_task 结构
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';
DELIMITER //
CREATE TRIGGER `update_student_task` AFTER UPDATE ON `task` FOR EACH ROW begin    
     declare t_sno varchar(255);
     declare Done int DEFAULT 0;
     declare result cursor for select sno from t_student,t_tc where t_student.cno=t_tc.cno and t_tc.tno=new.tno;
     declare continue handler for not found set Done =1; 
     open  result;
     flag_loop:loop
     fetch  result into t_sno;
     if Done then leave flag_loop ; end if ;
     if (new.submit=1 and t_sno not in(select sno from student_task where task_no=new.task_no))
     then      
     insert into student_task(sno,task_no) values(t_sno,new.task_no);
     end if;
     if(new.submit=0 and t_sno in(select sno from student_task where task_no=new.task_no))
     then
     delete from  student_task where sno=t_sno and task_no=new.task_no;
     end if;
     end loop flag_loop;
     close result;
end//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;


-- 导出  视图 tramnasys.admin_view 结构
-- 移除临时表并创建最终视图结构
DROP TABLE IF EXISTS `admin_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `admin_view` AS select `t_admin`.`ano` AS `ano`,`t_admin`.`psd` AS `psd`,`t_admin`.`name` AS `name`,`t_admin`.`phone` AS `phone`,`t_admin`.`qq` AS `qq` from `t_admin`;


-- 导出  视图 tramnasys.allstudent_studyplace_view 结构
-- 移除临时表并创建最终视图结构
DROP TABLE IF EXISTS `allstudent_studyplace_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `allstudent_studyplace_view` AS select `t_registration`.`city` AS `city`,`t_tc`.`tno` AS `tno` from ((`t_student` join `t_tc`) join `t_registration`) where ((`t_student`.`cno` = `t_tc`.`cno`) and (`t_student`.`sno` = `t_registration`.`rno`));


-- 导出  视图 tramnasys.class_view 结构
-- 移除临时表并创建最终视图结构
DROP TABLE IF EXISTS `class_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `class_view` AS select `t_class`.`cno` AS `cno`,`t_class`.`profession` AS `profession`,`t_class`.`totalPerson` AS `totalPerson` from `t_class`;


-- 导出  视图 tramnasys.file_view 结构
-- 移除临时表并创建最终视图结构
DROP TABLE IF EXISTS `file_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `file_view` AS select `t_file`.`fno` AS `fno`,`t_file`.`filename` AS `filename`,`t_file`.`filetype` AS `filetype`,`t_file`.`time` AS `time`,`t_file`.`task_no` AS `task_no`,`t_file`.`owe_perNo` AS `owe_perNo` from `t_file`;


-- 导出  视图 tramnasys.registration_view 结构
-- 移除临时表并创建最终视图结构
DROP TABLE IF EXISTS `registration_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `registration_view` AS select `t_registration`.`rno` AS `rno`,`t_registration`.`province` AS `province`,`t_registration`.`city` AS `city`,`t_registration`.`company` AS `company`,`t_registration`.`linkman` AS `linkman`,`t_registration`.`linkmanphone` AS `linkmanphone` from `t_registration`;


-- 导出  视图 tramnasys.student_view 结构
-- 移除临时表并创建最终视图结构
DROP TABLE IF EXISTS `student_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `student_view` AS select `t_student`.`sno` AS `sno`,`t_student`.`cno` AS `cno`,`t_student`.`psd` AS `psd`,`t_student`.`name` AS `name`,`t_student`.`phone` AS `phone`,`t_student`.`qq` AS `qq` from `t_student`;


-- 导出  视图 tramnasys.task_view 结构
-- 移除临时表并创建最终视图结构
DROP TABLE IF EXISTS `task_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `task_view` AS select `task`.`task_no` AS `task_no`,`task`.`task_name` AS `task_name`,`task`.`tno` AS `tno`,`task`.`task_content` AS `task_content`,`task`.`submit` AS `submit`,`task`.`start_time` AS `start_time`,`task`.`end_time` AS `end_time`,`task`.`create_time` AS `create_time` from `task`;


-- 导出  视图 tramnasys.tc_view 结构
-- 移除临时表并创建最终视图结构
DROP TABLE IF EXISTS `tc_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `tc_view` AS select `t_tc`.`cno` AS `cno`,`t_tc`.`tno` AS `tno` from `t_tc`;


-- 导出  视图 tramnasys.teacher_view 结构
-- 移除临时表并创建最终视图结构
DROP TABLE IF EXISTS `teacher_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `teacher_view` AS select `t_teacher`.`tno` AS `tno`,`t_teacher`.`psd` AS `psd`,`t_teacher`.`name` AS `name`,`t_teacher`.`phone` AS `phone`,`t_teacher`.`qq` AS `qq`,`t_teacher`.`profession` AS `profession` from `t_teacher`;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
