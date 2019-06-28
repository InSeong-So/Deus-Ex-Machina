package DeusExMachina.biz.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * Program Name : sessionDAO
 * Description : 세션 데이터 접근객체
 * Author : 소인성
 * History : 2019-06-28 컨버전
 * A.K.A : DAO
 **/

@Repository
public class sessionDAO implements SessionDaoInterface
{
    @Resource(name = "sqlSession")
    SqlSession session;
    
    @Override
    public Object call(HashMap<String, Object> param)
    {
        
        String sql = param.get("sql").toString();
        String sqlType = param.get("sqlType").toString();
        
        if ("selectOne".equals(sql))
        {
            return session.selectOne(sqlType, param);
        }
        else if ("selectList".equals(sql))
        {
            return session.selectList(sqlType, param);
        }
        else if ("update".equals(sql))
        {
            return session.update(sqlType, param);
        }
        else if ("insert".equals(sql))
        {
            return session.insert(sqlType, param);
        }
        
        return null;
    }
}
