import org.apache.ibatis.session.SqlSession;
import util.SqlSessionFactoryUtil;

class MybatisTest {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionFactoryUtil.getSqlSessionFactory().openSession();

    }
}

