package org.zerock.persistence;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zerock.domain.MemberVO;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberDAOImpl implements MemberDAO {

    @Autowired
    private SqlSession sqlSession;

    private static final String namespace = "org.zerock.mapper.MemberMapper";

    @Override
    public String getTime() {
        return sqlSession.selectOne(namespace + ".getTime");
    }

    @Override
    public void insertMember(MemberVO vo) {
        sqlSession.insert(namespace + ".insertMember", vo);
    }

    @Override
    public MemberVO readMember(String userid) throws Exception {
        return (MemberVO) sqlSession.selectOne(namespace + ".selectMember", userid);
    }

    @Override
    public MemberVO readWithPw(String userid, String userpw) throws Exception {

        Map<String, Object> paramMap = new HashMap<>();

        paramMap.put("userid", userid);
        paramMap.put("userpw", userpw);

        return sqlSession.selectOne(namespace + ".readWithPw", paramMap);

    }
}
