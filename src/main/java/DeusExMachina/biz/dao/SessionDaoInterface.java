package DeusExMachina.biz.dao;

import java.util.HashMap;

/**
 * Program Name : SessionDaoInterface
 * Description : 세션 데이터 접근객체 인터페이스
 * Author : 소인성
 * History : 2019-06-28 컨버전
 * A.K.A : DaoInterface
 **/

public interface SessionDaoInterface
{
    public Object call(HashMap<String, Object> param);
}
