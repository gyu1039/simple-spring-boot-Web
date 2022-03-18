package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService service;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerGET(BoardVO board, Model model) throws Exception {

        logger.info("register get .......");

        return "/board/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception {

        logger.info("regist post .......");
        logger.info(board.toString());

        service.regist(board);

        rttr.addFlashAttribute("result", "SUCCESS");

        return "redirect:/board/listAll";
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public String listAll(Model model) throws Exception {

        logger.info("show all list....");
        model.addAttribute("list", service.listAll());

        return "/board/listAll";
    }

    @GetMapping("/read")
    public String read(@RequestParam("bno") int bno, Model model) throws Exception {

        model.addAttribute(service.read(bno));

        return "/board/read";
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) throws Exception {

        service.remove(bno);

        rttr.addFlashAttribute("result", "SUCCESS");

        return "redirect:/board/listAll";
    }

    @GetMapping("/modify")
    public String modifyGET(int bno, Model model) throws Exception {

        model.addAttribute(service.read(bno));

        return "/board/modify";
    }

    @PostMapping("/modify")
    public String modifyPOST(BoardVO board, RedirectAttributes rttr) throws Exception {

        logger.info("mod post...");

        service.modify(board);
        rttr.addFlashAttribute("result", "SUCCESS");

        return "redirect:/board/listAll";
    }
}
