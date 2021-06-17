package edu.bit.ex.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.bit.ex.service.BoardService;
import edu.bit.ex.vo.BoardVO;
import lombok.extern.log4j.Log4j;

//spring v4.0 이전버전 (@Controller + @ResponseBody )



// pom.xml 에 들어가서 json에있는두줄을 지워버리고 이렇게 코드를 만든후
// rest/before 로 들어간다
@Log4j
@Controller
public class RestBoardSpring4BeforeController {
   
   @Autowired
   private BoardService boardService;
   
   @ResponseBody //메서드의 리턴타입을 기존과 다르게 처리한다는것을 명시한다
   @GetMapping("/rest/before")
   // List<BoardVO> 이것은 자바의 객체이다.
   public List<BoardVO> restBefore( Model model) {
      log.info("restBefore()..");
      
      List<BoardVO> list = boardService.getList();
      
      model.addAttribute("list",list);
      
      return list;
   }
   
}