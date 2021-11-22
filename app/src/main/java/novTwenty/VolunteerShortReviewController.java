package com.share.ftp.web.volunteer;

import java.util.Collection;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.VolunteerShortReviewDao;
import com.share.ftp.domain.community.VolunteerShortReviewDTO;
import com.share.ftp.domain.join.JoinDTO;

@Controller
public class VolunteerShortReviewController {

  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired VolunteerShortReviewDao volunteerShortReviewDao;
  @Autowired ServletContext sc;

  //  @GetMapping("/volunteer/reviewForm")
  //  public ModelAndView form() {
  //    ModelAndView mv = new ModelAndView();
  //    mv.addObject("pageTitle", "새 글");
  //    mv.addObject("contentUrl", "volunteer/VolunteerShortReviewForm.jsp");
  //    mv.setViewName("template1");
  //    return mv;
  //  }

  @PostMapping("/volunteer/reviewAdd")
  public ModelAndView add(VolunteerShortReviewDTO volunteerShortReviewDTO, HttpSession session) throws Exception {

    volunteerShortReviewDTO.setOwner((JoinDTO) session.getAttribute("loginUser"));

    volunteerShortReviewDao.insert(volunteerShortReviewDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:reviewList");
    return mv;
  }

  @RequestMapping("/volunteer/reviewList")
  public ModelAndView list() throws Exception {
    Collection<VolunteerShortReviewDTO> volunteerShortReviewList = volunteerShortReviewDao.findAll();

    ModelAndView mv = new ModelAndView();
    mv.addObject("volunteerShortReviewList", volunteerShortReviewList);
    mv.addObject("pageTitle", "후기 목록");
    mv.addObject("contentUrl", "volunteer/VolunteerShortReviewList.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @RequestMapping("/volunteer/reviewUpdate")
  public ModelAndView update(VolunteerShortReviewDTO volunteerShortReviewDTO) throws Exception {

    VolunteerShortReviewDTO oldBoard = volunteerShortReviewDao.findByNo(volunteerShortReviewDTO.getNo());
    if (oldBoard == null) {
      throw new Exception("해당 번호의 댓글이 없습니다.");
    } 

    volunteerShortReviewDao.update(volunteerShortReviewDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:reviewList");
    return mv;
  }

  @RequestMapping("/volunteer/reviewDelete")
  public ModelAndView delete(int no) throws Exception {

    VolunteerShortReviewDTO volunteerShortReviewDTO = volunteerShortReviewDao.findByNo(no);
    if (volunteerShortReviewDTO == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }

    volunteerShortReviewDao.delete(no);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:reviewList");
    return mv;
  }


}
