#mybatis ATM 数据库实验
##mybatis配置文件
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/classwork"/>
                <property name="username" value="root"/>
                <property name="password" value="awaistt1314"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <!--        <mapper resource="org/mybatis/example/BlogMapper.xml"/>-->
        <mapper resource="atmDAO/TestMapper.xml"/>
    </mappers>
</configuration>
```
mappers 可以添加可以添加映射器，映射器是对应接口，sql语句要和java语句分开写，Mapper中写接口对应的sql语句
##Mapper.xml文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="DAO.UserDAO">
    <select id="getList" resultType="entity.Test">
        select * from test
    </select>
</mapper>
```
mapper文件中不同标签执行不同的sql语句
更新数据需要try finally 回滚