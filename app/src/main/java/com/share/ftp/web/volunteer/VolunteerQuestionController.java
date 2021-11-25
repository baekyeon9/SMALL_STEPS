package com.share.ftp.web.volunteer;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.dao.VolunteerQuestionDao;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.volunteer.VolunteerQuestionDTO;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;

@Controller
@RequestMapping("/volunteer/question")
public class VolunteerQuestionController { 

  private static final Logger logger = LogManager.getLogger(VolunteerQuestionController.class);

  @Autowired VolunteerQuestionDao volunteerQuestionDao;
  @Autowired GeneralDao generalDao;
  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired ServletContext sc;

  @PostMapping("add")
  public ModelAndView add(VolunteerQuestionDTO volunteerQuestionDTO, int volNo, HttpSession session) throws Exception {

    volunteerQuestionDTO.setJoinUser((JoinDTO) session.getAttribute("loginUser"));

    VolunteerRequestDTO volunteer = new VolunteerRequestDTO();
    volunteer.setNo(volNo);
    volunteerQuestionDTO.setVolunteer(volunteer);


    System.out.println("유저번호"+ volunteerQuestionDTO.getJoinUser().getNo());
    System.out.println("봉사번호"+ volunteerQuestionDTO.getVolunteer().getNo());

    volunteerQuestionDao.insert(volunteerQuestionDTO);  
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:../detail?no=" + volNo);
    return mv;
  }


  @GetMapping("list")
  public ModelAndView list(int no) throws Exception {

    List<VolunteerQuestionDTO> volunteerQuestionList = volunteerQuestionDao.findAllNo(no);

    ModelAndView mv = new ModelAndView();
    mv.addObject("volunteerList", volunteerQuestionList);
    mv.addObject("pageTitle", "함께해요 : 봉사문의목록");
    mv.addObject("contentUrl", "volunteer/question/VolunteerQuestionList.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @PostMapping("update")
  public ModelAndView update(VolunteerQuestionDTO volunteerQuestionDTO, int volNo) throws Exception {

    VolunteerRequestDTO volunteer = new VolunteerRequestDTO();
    volunteer.setNo(volNo);
    volunteerQuestionDTO.setVolunteer(volunteer);

    VolunteerQuestionDTO volunteerQuestion = volunteerQuestionDao.findByNo(volunteerQuestionDTO);

    if (volunteerQuestion == null) {
      throw new Exception("해당 번호의 봉사댓글이 없습니다");
    }

    volunteerQuestion.setContent(volunteerQuestionDTO.getContent());

    volunteerQuestionDao.update(volunteerQuestion);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:../detail?no="+ volNo);
    return mv;
  }

  @GetMapping("delete")
  public ModelAndView delete(VolunteerQuestionDTO volunteerQuestionDTO, int volunteerNo) throws Exception {

    VolunteerRequestDTO volunteer = new VolunteerRequestDTO();
    volunteer.setNo(volunteerNo);
    volunteerQuestionDTO.setVolunteer(volunteer);

    VolunteerQuestionDTO volunteerQuestion = volunteerQuestionDao.findByNo(volunteerQuestionDTO);

    if (volunteerQuestion == null) {
      throw new Exception("해당 번호의 봉사댓글이 없습니다");
    }

    volunteerQuestionDao.delete(volunteerQuestion);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:../detail?no="+ volunteerNo);
    return mv;
  }

}

