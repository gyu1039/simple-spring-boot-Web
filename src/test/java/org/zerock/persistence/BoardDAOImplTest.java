package org.zerock.persistence;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.domain.BoardVO;

@SpringBootTest
@MapperScan(value={"org.zerock.mapper"})
class BoardDAOImplTest {

    @Autowired
    private BoardDAO dao;

    @Test
    public void testCreate() throws Exception {

        BoardVO board = new BoardVO();
        board.setTitle("새로운 글을 넣습니다");
        board.setContent("새로운 글을 넣습니다");
        board.setWriter("user00");
        dao.create(board);
    }

    @Test
    public void testRead() throws Exception {
        System.out.println(dao.read(1).toString());
    }

    @Test
    public void testUpdate() throws Exception {

        BoardVO board = new BoardVO();
        board.setBno(1);

        board.setTitle("수정된 글입니다");
        board.setContent("수정 테스트");
        dao.update(board);

    }

    @Test
    public void testDelete() throws Exception {

        dao.delete(1);
    }
}