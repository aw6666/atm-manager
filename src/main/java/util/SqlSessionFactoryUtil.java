package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {
    private static volatile SqlSessionFactory sqlSessionFactory;

    private SqlSessionFactoryUtil(){

    }
    public static SqlSessionFactory getSqlSessionFactory(){
        if(sqlSessionFactory==null){
            synchronized (SqlSessionFactoryUtil.class){
                if (sqlSessionFactory==null){
                    String source ="mybatis-config.xml";
                    try {
                        InputStream in  = Resources.getResourceAsStream(source);
                        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return sqlSessionFactory;
    }
}

