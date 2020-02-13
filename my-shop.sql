/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.5.62-log : Database - my-shop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`my-shop` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `my-shop`;

/*Table structure for table `tb_content` */

DROP TABLE IF EXISTS `tb_content`;

CREATE TABLE `tb_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category_id` bigint(20) DEFAULT NULL COMMENT '分类id',
  `title` varchar(32) DEFAULT NULL COMMENT '主标题',
  `sub_title` varchar(32) DEFAULT NULL COMMENT '子标题',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `url` varchar(225) DEFAULT NULL COMMENT '路径',
  `picture` varchar(225) DEFAULT NULL COMMENT '图片',
  `info` text COMMENT '内容',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='内容表';

/*Data for the table `tb_content` */

insert  into `tb_content`(`id`,`category_id`,`title`,`sub_title`,`description`,`url`,`picture`,`info`,`createTime`,`updateTime`) values (6,5,'大广告标题','大广告子标题','描述','无','/static/upload/576a9b08-8d72-45b4-bcbd-d9a581887973.jpg','<p><img src=\"http://img.t.sinajs.cn/t4/appstyle/expression/ext/normal/40/pcmoren_tian_org.png\" alt=\"[舔屏]\" data-w-e=\"1\"></p>','2019-10-16 19:12:10','2019-10-16 19:12:10'),(7,6,'小广告标题','小广告子标题','描述','无','http://img95.699pic.com/photo/50153/1912.jpg_wh300.jpg','hello','2019-12-26 20:34:25','2019-12-26 20:34:30');

/*Table structure for table `tb_content_category` */

DROP TABLE IF EXISTS `tb_content_category`;

CREATE TABLE `tb_content_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` int(11) DEFAULT NULL COMMENT '父类目id',
  `name` varchar(32) DEFAULT NULL COMMENT '类目名',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `sort_order` int(11) DEFAULT NULL COMMENT '排序序号',
  `is_parent` tinyint(1) DEFAULT NULL COMMENT '是否为父级',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='类目表';

/*Data for the table `tb_content_category` */

insert  into `tb_content_category`(`id`,`parent_id`,`name`,`status`,`sort_order`,`is_parent`,`createTime`,`updateTime`) values (1,0,'shop',1,1,1,'2019-09-20 21:11:32','2019-09-20 21:11:38'),(2,1,'首页',1,1,1,'2019-09-20 21:12:05','2019-09-20 21:12:10'),(3,1,'列表页面',1,1,1,'2019-09-20 21:12:48','2019-09-20 21:12:52'),(4,1,'详细页面',1,1,1,'2019-09-20 21:13:16','2019-09-20 21:13:19'),(5,2,'大广告',1,1,0,'2019-09-20 21:15:56','2019-09-20 21:15:59'),(6,2,'小广告',1,1,0,'2019-09-20 21:16:02','2019-09-20 21:16:04'),(7,2,'中广告',1,1,0,'2019-09-20 21:16:07','2019-09-20 21:16:09'),(8,2,'商城快报',1,1,0,'2019-09-20 21:17:10','2019-09-20 21:17:13'),(9,3,'边栏广告',1,1,0,'2019-09-20 21:17:59','2019-09-20 21:18:02'),(10,3,'页头广告',1,1,0,'2019-09-20 21:18:43','2019-09-20 21:18:46'),(11,3,'页脚广告',1,1,0,'2019-09-20 21:19:07','2019-09-20 21:19:09'),(12,4,'边栏广告',1,1,0,'2019-09-20 21:20:54','2019-09-20 21:20:56'),(13,4,'滚动广告',1,1,0,'2019-09-20 21:20:58','2019-09-20 21:21:00'),(14,0,'底栏页面',NULL,1,1,'2019-12-07 17:02:28','2019-12-07 17:02:28'),(16,2,'中广告',NULL,2,0,'2019-12-07 17:04:37','2019-12-07 17:04:37'),(17,2,'小广告',NULL,2,0,'2019-12-07 17:05:16','2019-12-07 17:05:16'),(18,2,'中广告',NULL,3,0,'2019-12-07 17:06:39','2019-12-07 17:06:39');

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `phone` varchar(32) DEFAULT NULL COMMENT '电话',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `tb_user` */

insert  into `tb_user`(`id`,`email`,`username`,`password`,`phone`,`createTime`,`updateTime`) values (1,'18896820691@163.com','wuchao','YWRtaW4=','18896820691','2020-02-02 13:19:42','2020-02-02 13:19:45'),(16,'mrwu@qq.com','wu123','YWRtaW5fd3U=','13944344358','2019-09-19 22:45:45','2019-11-27 20:40:16'),(19,'sweet@163.com','cast21321','YWRtaW4=','18796853064','2019-09-25 20:12:19','2019-09-25 20:12:19'),(20,'zs@123.com','zsadmin','YWRtaW4=','15645790743','2019-09-25 20:32:49','2019-09-25 20:32:49'),(21,'ls@qq.com','lsadmin','YWRtaW4=','15435454342','2019-09-25 20:33:23','2019-09-25 20:33:23'),(22,'zhaoliu@163.com','zhaoliu','YWRtaW4=','14234543433','2019-09-25 20:34:05','2019-09-25 20:34:05'),(23,'xyz13232@123.com','xyaw122323','YWRtaW4=','16579344033','2019-09-25 20:34:58','2019-09-25 20:34:58'),(24,'zhenxin@567.com','zhenxin','YWRtaW4=','15523509943','2019-09-25 20:35:35','2019-09-25 20:35:35'),(25,'hello123@github.com','hello123','YWRtaW4=','15446433444','2019-09-25 20:36:28','2019-09-25 20:36:28'),(26,'cyj@123.com','cyj123','YWRtaW4=','16445453345','2019-09-25 20:37:13','2019-09-25 20:37:13'),(28,'itheima@qq.com','itheima','YWRtaW4=','15435632445','2019-09-25 20:38:31','2019-09-25 20:38:31'),(29,'adsd@qq.com','ququaa','YWRtaW4=','15879254885','2020-02-05 15:17:06','2020-02-05 15:17:09');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
