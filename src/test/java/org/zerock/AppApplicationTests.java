package org.zerock;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;
import org.zerock.persistence.MemberDAO;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
@MapperScan(value={"org.zerock.mapper"})
class AppApplicationTests {

	@Autowired
	private DataSource ds;

	@Autowired
	private SqlSessionFactory sqlSession;

	@Autowired
	private MemberMapper mapper;

	@Autowired
	private MemberDAO dao;

	@Test
	public void testTime() throws Exception {

		System.out.println(dao.getTime());
	}

	@Test
	public void testInsertMember() throws Exception {

		MemberVO vo = new MemberVO();
		vo.setUserid("user00");
		vo.setUserpw("user00");
		vo.setUsername("USER00");
		vo.setEmail("user00@aaa.com");

		dao.insertMember(vo);
	}

	@Test
	public void testConnection() throws Exception {

		System.out.println("ds = " + ds);

		Connection con = ds.getConnection();

		System.out.println("con = " + con);

		con.close();
	}

	@Test
	public void testSqlSession() throws Exception {

		System.out.println(sqlSession);
	}

	@Test
	public void testInsert() throws Exception {

		MemberVO vo = new MemberVO();

		vo.setUserid("user543");
		vo.setUserpw("user543");
		vo.setUsername("Billy Kang");
		vo.setEmail("zerockcode@gmail.com");

		mapper.create(vo);
	}

	@Test
	public void testLogin() throws Exception {
		MemberVO vo = mapper.login("user543", "user543");

		System.out.println("vo = " + vo);

	}


	@Test
	void contextLoads() {
	}



}
