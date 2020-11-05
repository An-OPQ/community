# Community
> 这是一个基于Springboot的BBS项目
> 这是个人用于毕业设计所开发的系统，技术尚不成熟。仅供学习，大佬请绕道。

``如需帮助 邮箱 liuxian0728@foxmail.com``

### 使用的技术
1. flyway（数据库版本控制）
2. git（项目管理工具）


### 项目的各项版本
1. JDK 8
2. mysql 5.7
3. IDEA 

### 启动
1. 首先修改yml文件中的数据库配置,以及pom.xml中的flyway的数据库配置
2. 首先创建名为 “community” 的mysql 数据库。
（运行sql脚本也行）
``CREATE DATABASE `community` CHARACTER SET 'utf8mb4';
``

3. 使用idea的Terminal运行命令
``mvn flyway:migrate
``
> 运行成功后flyway 就自动完成了数据库的迁移。

另：
> yml中的配置图片访问的虚拟路径，需要自行修改。个人电脑为DeepinV20（linux）系统，所以
>修改为你电脑的本地文件夹（preread.uploadPath）。

### 说明
1. showImage 文件夹为图片展示（项目无用）可删除
##### login.html
![image](https://github.com/An-OPQ/community/blob/master/showImage/login.png)
##### main.html
![image](https://github.com/An-OPQ/community/blob/master/showImage/main.png)
##### contentManager.html
![image](https://github.com/An-OPQ/community/blob/master/showImage/manager.png)

