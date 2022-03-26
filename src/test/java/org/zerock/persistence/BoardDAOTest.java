package org.zerock.persistence;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import java.util.List;


@SpringBootTest
@MapperScan(value={"org.zerock.mapper"})
class BoardDAOTest {

    @Autowired
    private BoardDAO dao;

    private Logger logger = LoggerFactory.getLogger("BoardDAOTest.class");


    @Test
    public void testListPage() throws Exception {
        int page = 0;

        List<BoardVO> list = dao.listPage(page);

        for (BoardVO boardVO : list) {
            logger.info(boardVO.getBno() + ": " + boardVO.getTitle());
        }
    }

    @Test
    public void testListCriteria() throws Exception {

        Criteria cri = new Criteria();
        cri.setPage(2);
        cri.setPerPageNum(20);

        List<BoardVO> list = dao.listCriteria(cri);

        for(BoardVO boardVO : list) {
            logger.info(boardVO.getBno() + ": " + boardVO.getTitle());
        }
    }

}