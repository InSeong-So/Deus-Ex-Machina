package DeusExMachina.biz.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class DemDAO
{
    @Resource(name = "SqlSession")
    SqlSession sqlSession;
    
    protected void printQueryId(String queryId)
    {
        if (log.isDebugEnabled())
        {
            log.debug("\t QueryId \t: " + queryId);
        }
    }
    
    public Object insert(String queryId, Object params)
    {
        printQueryId(queryId);
        return sqlSession.insert(queryId, params);
    }
    
    public Object update(String queryId, Object params)
    {
        printQueryId(queryId);
        return sqlSession.update(queryId, params);
    }
    
    public Object delete(String queryId, Object params)
    {
        printQueryId(queryId);
        return sqlSession.delete(queryId, params);
    }
    
    public Object selectOne(String queryId)
    {
        printQueryId(queryId);
        return sqlSession.selectOne(queryId);
    }
    
    public Object selectOne(String queryId, Object params)
    {
        printQueryId(queryId);
        return sqlSession.selectOne(queryId, params);
    }
    
    @SuppressWarnings("rawtypes")
    public List selectList(String queryId)
    {
        printQueryId(queryId);
        return sqlSession.selectList(queryId);
    }
    
    @SuppressWarnings("rawtypes")
    public List selectList(String queryId, Object params)
    {
        printQueryId(queryId);
        return sqlSession.selectList(queryId, params);
    }
}
