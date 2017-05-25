# SpringBootDemo
## 1 创建数据库

使用MySQL客户端执行以下脚本即可创建工程需要的数据库

> [SpringBootDemo](https://github.com/sayaoailun/SpringBootDemo)/[demo](https://github.com/sayaoailun/SpringBootDemo/tree/master/demo)/[Backend](https://github.com/sayaoailun/SpringBootDemo/tree/master/demo/Backend)/[DB_Script](https://github.com/sayaoailun/SpringBootDemo/tree/master/demo/Backend/DB_Script)/**sql.sql**

## 2 使用Java IDE导入maven工程

导入工程`demo`和`Backend`

## 3 配置数据库

修改以下文件

> [SpringBootDemo](https://github.com/sayaoailun/SpringBootDemo)/[demo](https://github.com/sayaoailun/SpringBootDemo/tree/master/demo)/[Backend](https://github.com/sayaoailun/SpringBootDemo/tree/master/demo/Backend)/[src](https://github.com/sayaoailun/SpringBootDemo/tree/master/demo/Backend/src)/[main](https://github.com/sayaoailun/SpringBootDemo/tree/master/demo/Backend/src/main)/[resources](https://github.com/sayaoailun/SpringBootDemo/tree/master/demo/Backend/src/main/resources)/**application.properties**

```properties
druid.url=jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&useSSL=false
druid.username=root
druid.password=root
```
此三项配置改为实际的数据库配置

## 4 启动工程

Backend工程的入口为

> [SpringBootDemo](https://github.com/sayaoailun/SpringBootDemo)/[demo](https://github.com/sayaoailun/SpringBootDemo/tree/master/demo)/[Backend](https://github.com/sayaoailun/SpringBootDemo/tree/master/demo/Backend)/[src](https://github.com/sayaoailun/SpringBootDemo/tree/master/demo/Backend/src)/[main](https://github.com/sayaoailun/SpringBootDemo/tree/master/demo/Backend/src/main)/[java](https://github.com/sayaoailun/SpringBootDemo/tree/master/demo/Backend/src/main/java)/[com](https://github.com/sayaoailun/SpringBootDemo/tree/master/demo/Backend/src/main/java/com)/[dc](https://github.com/sayaoailun/SpringBootDemo/tree/master/demo/Backend/src/main/java/com/dc)/[springboot](https://github.com/sayaoailun/SpringBootDemo/tree/master/demo/Backend/src/main/java/com/dc/springboot)/[demo](https://github.com/sayaoailun/SpringBootDemo/tree/master/demo/Backend/src/main/java/com/dc/springboot/demo)/[backend](https://github.com/sayaoailun/SpringBootDemo/tree/master/demo/Backend/src/main/java/com/dc/springboot/demo/backend)/[main](https://github.com/sayaoailun/SpringBootDemo/tree/master/demo/Backend/src/main/java/com/dc/springboot/demo/backend/main)/**Main.java**

也可以通过pom文件打包成jar包，使用脚本启动

Backend工程的启动脚本为linux下的shell脚本，目录为

> [SpringBootDemo](https://github.com/sayaoailun/SpringBootDemo)/[demo](https://github.com/sayaoailun/SpringBootDemo/tree/master/demo)/[Backend](https://github.com/sayaoailun/SpringBootDemo/tree/master/demo/Backend)/**bin**/