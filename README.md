# Community
> 这是一个基于Springboot的BBS项目

### 使用的技术
1. flyway（数据库版本控制）
2. git（项目管理工具）


### 项目的各项版本
1. JDK 8
2. mysql 5.7
3. IDEA 

### 启动
1. 首先修改yml文件中的数据库配置
2. 首先创建mysql 数据库。
（运行sql脚本也行）
``CREATE DATABASE `community` CHARACTER SET 'utf8mb4';
``

3.使用idea的Terminal运行命令
``mvn flyway:migrate
``
