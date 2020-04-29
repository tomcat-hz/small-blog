/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.19 : Database - blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blog` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `blog`;

/*Table structure for table `blog` */

DROP TABLE IF EXISTS `blog`;

CREATE TABLE `blog` (
  `id` int NOT NULL AUTO_INCREMENT,
  `original` int DEFAULT NULL COMMENT '0表示转载,1表示原创',
  `commentable` int DEFAULT NULL COMMENT '0表示不开启评论,1表示开启评论',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `flag` int DEFAULT '1' COMMENT '逻辑删除1存在,0删除',
  `appreciate` int DEFAULT NULL COMMENT '0表示不可以赞赏,1表示可以赞赏',
  `type_id` int DEFAULT NULL COMMENT '博客类型的id',
  `title` varchar(20) DEFAULT NULL COMMENT '博客的标题',
  `outline` varchar(200) DEFAULT NULL COMMENT '概要',
  `content` longtext COMMENT '博客内容',
  `avatar` varchar(100) DEFAULT '/static/img/back.jpg' COMMENT '博客封面',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `blog` */

insert  into `blog`(`id`,`original`,`commentable`,`create_time`,`update_time`,`flag`,`appreciate`,`type_id`,`title`,`outline`,`content`,`avatar`) values (1,1,1,'2020-04-27 21:56:52','2020-04-27 21:56:52',1,1,1,'Java开发','卡片式面板面板通常用于非白色背景色的主体内 从而映衬出边框投影卡片式面板面板通常用于非白色背景色的主体内 从而映衬出边框投影卡片式面板面板通常用于非白色背景色的主体内 从而映衬出边框投影卡片式面板面板通常用于非白色背景色的主体内 从而映衬出边框投影','内容如下','/static/img/back.jpg'),(2,1,1,'2020-04-27 21:56:55','2020-04-27 21:56:55',1,1,1,'Java开发','卡片式面板面板通常用于非白色背景色的主体内 从而映衬出边框投影卡片式面板面板通常用于非白色背景色的主体内 从而映衬出边框投影卡片式面板面板通常用于非白色背景色的主体内 从而映衬出边框投影卡片式面板面板通常用于非白色背景色的主体内 从而映衬出边框投影','内容如下','/static/img/back.jpg'),(3,1,1,'2020-04-27 21:56:56','2020-04-27 21:56:56',1,1,1,'Java开发','卡片式面板面板通常用于非白色背景色的主体内 从而映衬出边框投影卡片式面板面板通常用于非白色背景色的主体内 从而映衬出边框投影卡片式面板面板通常用于非白色背景色的主体内 从而映衬出边框投影卡片式面板面板通常用于非白色背景色的主体内 从而映衬出边主体内 从而映衬出边框投影','内容如下','/static/img/back.jpg'),(4,1,1,'2020-04-27 22:45:09','2020-04-27 22:45:09',1,0,0,'ssm','卡片式面板面板通常用于非 从而映衬出边框投影卡片式面板面板通常用于非白色背景色的主体内 从而映衬出边框投影卡片式面板面板通常用于非白色背景色的主体内 从而映衬出边框投影','内容如下','/static/img/back.jpg'),(5,0,0,'2020-04-27 22:47:25','2020-04-27 22:47:25',0,0,0,'sb','卡片式面板面板通常用于非 从而映衬出边框投影卡片式面板面板通常用于非白色背景色的主体内 从而映衬出边框投影卡片式面板面板通常用于非白色背景色的主体内 从而映衬出边框投影','内容如下','/static/img/back.jpg'),(6,1,1,'2020-04-27 22:47:50','2020-04-27 22:47:50',1,1,1,'sc','卡片式面板面板通常用于非 从而映衬出边框投影卡片式面板面板通常用于非白色背景色的主体内 从而映衬出边框投影卡片式面板面板通常用于非白色背景色的主体内 从而映衬出边框投影','内容如下','/static/img/back.jpg'),(9,1,1,'2020-04-28 11:18:11','2020-04-28 11:18:11',1,1,16,'docker的基本使用','Docker 是一个开源的应用容器引擎，让开发者可以打包他们的应用以及依赖包到一个可移植的镜像中，然后发布到任何流行的 Linux或Windows 机器上，也可以实现虚拟化。容器是完全使用沙箱机制，相互之间不会有任何接口。─────来自百度百科','### 1.docker是什么?\n- Docker 是一个开源的应用容器引擎，让开发者可以打包他们的应用以及依赖包到一个可移植的镜像中，然后发布到任何流行的 Linux或Windows 机器上，也可以实现虚拟化。容器是完全使用沙箱机制，相互之间不会有任何接口。─────来自百度百科\n### 2.容器和镜像的概念\n- 镜像简单来说相当于安装包,而且这个安装包可以安装多次.\n- 容器就是安装包安装好了,镜像安装时可以指定端口号和名字等等.\n- docker 安装镜像生成容器:docker run -d -p 80:80 --name testname 镜像id (参数说明,run表示安装的动作,-d作用是让容器后台可以运行,-p是指定端口号80:80,第一个80是访问容器的端口号,第二个相当于一个标识,--name是给容器起一个名字,镜像id是选择对应的镜像进行安装)\n- docker搜索jdk镜像:  docker search  jdk\n- docker查看下载的镜像: docker images\n- docker下载jdk镜像:  docker  pull  ascdc/jdk8\n- docker查看运行中的容器: docker ps\n- docker查看所有容器: docker ps -a\n![](http://q9hljz6bo.bkt.clouddn.com/5%25G%5B%254IH9%28JH%40GX6ROX7%283D.png)\n\n![](http://q9hljz6bo.bkt.clouddn.com/CQ6%2437%7BRURIMQRR7%298DIT8T.png)\n\n### 3.容器id和镜像id的作用\n- id起到一个唯一标识的作用,当我们要删除某个镜像,或者停止和删除容器时可以id来选择需要删除的容器或者镜像.name属性也可以作为选择的条件\n- 删除镜像: docker rmi 镜像的id或者镜像的名字\n- 删除容器必须之前先停止容器: docker stop 容器id或者容器name\n- docker rm 容器id或者容器name\n### 4.其他操作\n- 重启docker: systemctl restart docker\n- 最好用的命令: docker --help\n- 进入容器内部(拿mysql来说): docker exec -it mysql容器的id或name bash','http://q9hljz6bo.bkt.clouddn.com/b462227dcee54b63aa52c29f3f5efd73'),(10,1,1,'2020-04-29 06:31:48','2020-04-29 06:31:48',1,1,3,'java web中的域对象','http是一个简单的请求-响应协议，它通常运行在TCP之上。它指定了客户端可能发送给服务器什么样的消息以及得到什么样的响应。请求和响应消息的头以ASCII码形式给出；而消息内容则具有一个类似MIME的格式。这个简单模型是早期Web成功的有功之臣，因为它使得开发和部署是那么的直截了当。─────来自百度百科','### 1.什么是http协议?\n- http是一个简单的请求-响应协议，它通常运行在TCP之上。它指定了客户端可能发送给服务器什么样的消息以及得到什么样的响应。请求和响应消息的头以ASCII码形式给出；而消息内容则具有一个类似MIME的格式。这个简单模型是早期Web成功的有功之臣，因为它使得开发和部署是那么的直截了当。─────来自百度百科\n- http协议是无状态的,每次只能产生一次请求和响应.所以不能很好的保存数据需要域对象来帮忙\n1. request对象它是一个域对象,所有的域对象都有三种方法set get remove即设置,获得和移除值,域对象都有作用域,request的作用域是一次请求和响应.\n2. page域对象它的作用域是在当前网页有效,它的作用域比request小,一般用不上吧\n3. session域对象的作用域是一次会话有效,一次会话简单理解就是浏览器关闭和打开,关闭浏览器session就失效了.保持浏览器的打开会话就存在,session的默认有效时间是30分钟如果我们放任浏览器不管,30分钟后session也会失效,但是如果我们时不时点一下,session的有效时间就会得到刷新\n4. context这个域对象的作用域是服务级别的,只要web应用没有关闭或重启域对象中的值就可以通过get方法去获取\n### 2.转发和重定向\n- java通过request对象进行转发,request域对象中的值依然有效,即转发是一次请求和响应\n- java通过response.sendRedirect(\"路径\")进行重定向,request中的值也会失效,同时url的地址也会改变\n未完待续............','http://q9hljz6bo.bkt.clouddn.com/b3768f7cd0b04e4b9315f58f3ee2a3f0');

/*Table structure for table `blog_comment` */

DROP TABLE IF EXISTS `blog_comment`;

CREATE TABLE `blog_comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `flag` int DEFAULT '1' COMMENT '逻辑删除1存在,0删除',
  `blog_id` int DEFAULT NULL COMMENT '关联的博客',
  `comment_id` int DEFAULT NULL COMMENT '关联的评论id,没有表示是第一条回复,有表示是子级回复',
  `content` varchar(200) DEFAULT NULL COMMENT '评论内容',
  `user_id` int DEFAULT NULL COMMENT '评论者的用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `blog_comment` */

/*Table structure for table `blog_type` */

DROP TABLE IF EXISTS `blog_type`;

CREATE TABLE `blog_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `flag` int DEFAULT '1' COMMENT '逻辑删除1存在,0删除',
  `type_name` varchar(20) DEFAULT NULL COMMENT '类型的名称',
  `num` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `blog_type` */

insert  into `blog_type`(`id`,`create_time`,`update_time`,`flag`,`type_name`,`num`) values (1,'2020-04-27 20:39:27','2020-04-27 13:36:02',1,'java基础上',0),(2,'2020-04-27 20:39:27','2020-04-27 13:36:06',1,'java基础下',0),(3,'2020-04-27 20:39:27','2020-04-27 20:39:27',1,'java web',0),(4,'2020-04-27 20:39:27','2020-04-27 20:39:27',1,'java高级',0),(5,'2020-04-27 20:39:27','2020-04-27 20:39:27',1,'html',0),(6,'2020-04-27 20:39:27','2020-04-27 20:39:27',1,'css',0),(7,'2020-04-27 21:04:01','2020-04-27 21:04:01',1,'ssm',0),(8,'2020-04-27 21:04:13','2020-04-27 21:04:13',1,'spring boot',0),(9,'2020-04-27 21:05:24','2020-04-27 21:05:24',1,'spring cloud',0),(10,'2020-04-27 21:05:24','2020-04-27 21:05:24',1,'elasticsearch',0),(11,'2020-04-27 21:05:24','2020-04-27 21:05:24',1,'solr',0),(12,'2020-04-27 21:05:24','2020-04-27 21:05:24',1,'sso',0),(13,'2020-04-27 21:05:24','2020-04-27 21:05:24',1,'log',0),(15,'2020-04-28 10:21:38','2020-04-28 10:21:38',1,'网站的搭建',0),(16,'2020-04-28 10:33:45','2020-04-28 10:33:45',1,'docker',0);

/*Table structure for table `comments` */

DROP TABLE IF EXISTS `comments`;

CREATE TABLE `comments` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nickname` varchar(20) DEFAULT NULL,
  `image` varchar(50) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `email` varchar(20) DEFAULT NULL,
  `comment_parent_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `comments` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usename` varchar(20) DEFAULT 'java小白' COMMENT '用户昵称',
  `email` varchar(20) DEFAULT NULL COMMENT '注册邮箱',
  `pass` varchar(50) DEFAULT NULL COMMENT '密码',
  `avatar` varchar(50) DEFAULT '/static/img/index.jpg' COMMENT '头像',
  `age` int DEFAULT NULL COMMENT '年龄',
  `address` varchar(50) DEFAULT NULL COMMENT '住址',
  `job` varchar(20) DEFAULT NULL COMMENT '职业',
  `level` int DEFAULT NULL COMMENT '经验等级',
  `user_type` int DEFAULT NULL COMMENT '用户类型0表示管理员,1表示普通用户',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  `online` int DEFAULT '0' COMMENT '是否在线0不在,1在',
  `flag` int DEFAULT '1' COMMENT '逻辑删除1存在,0删除',
  `logined` int DEFAULT '0' COMMENT '是否签到过',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`usename`,`email`,`pass`,`avatar`,`age`,`address`,`job`,`level`,`user_type`,`create_time`,`update_time`,`online`,`flag`,`logined`) values (1,'何正','2218359849@qq.com','666666','/static/img/index.jpg',25,'湖北省孝感市','java开发',NULL,0,'2020-04-28 12:30:02','2020-04-28 12:30:02',0,1,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
