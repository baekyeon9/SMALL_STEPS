package com.share.ftp.web.admin.volunteer.question;

import java.util.List;
import javax.servlet.ServletContext;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.dao.VolunteerQuestionDao;
import com.share.ftp.domain.volunteer.VolunteerQuestionDTO;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;

@Controller
//@RequestMapping("/admin/volunteer/question")
public class AdminVolunteerReplyController {

  private static final Logger logger = LogManager.getLogger(AdminVolunteerReplyController.class);

  @Autowired VolunteerDao volunteerDao;
  @Autowired VolunteerQuestionDao volunteerQuestionDao;
  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired ServletContext sc;

  @GetMapping("list")
  public ModelAndView list(int no) throws Exception {

    List<VolunteerQuestionDTO> volunteerQuestionList = volunteerQuestionDao.findAllNo(no);


    ModelAndView mv = new ModelAndView();
    //    mv.addObject("volunteerDTO", volunteerDTO);
    mv.addObject("volunteerQuestionList", volunteerQuestionList);
    mv.addObject("pageTitle", "HappyShare: 봉사 문의");
    mv.addObject("contentUrl", "admin/volunteer/AdminVolunteerQuestionList.jsp");
    mv.setViewName("template2");
    return mv;
  }

  @PostMapping("update")
  public ModelAndView update(VolunteerQuestionDTO volunteerQuestionDTO, int volNo) throws Exception {

    VolunteerRequestDTO volunteer = new VolunteerRequestDTO();
    volunteer.setNo(volNo);
    volunteerQuestionDTO.setVolunteer(volunteer);

    VolunteerQuestionDTO volunteerQuestion = volunteerQuestionDao.findByNo(volunteerQuestionDTO);


    if (volunteerQuestion == null) {
      throw new Exception("해당 번호의 문의가 없습니다.");
    } 

    volunteerQuestionDao.updateReply(volunteerQuestion);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:../../volunteer/detail?no=" + volNo);
    return mv;
  }

  //  @GetMapping("/admin/challenge/replyUpdateDetail")
  //  public ModelAndView detail(int questionNo) throws Exception {
  //    ChallengeQuestionDTO challengeQuestionDTO = challengeQuestionDao.findByNo(questionNo);
  //
  //    if (challengeQuestionDTO == null) {
  //      throw new Exception("해당 번호의 문의가 없습니다.");
  //    }
  //
  //    ModelAndView mv = new ModelAndView();
  //    mv.addObject("challengeQuestionDTO", challengeQuestionDTO);
  //    mv.addObject("pageTitle", "답변 등록&변경");
  //    mv.addObject("contentUrl", "admin/challenge/AdminChallengeReplyUpdateDetail.jsp");
  //    mv.setViewName("template2");
  //    return mv;
  //  }

  @PostMapping("delete")
  public ModelAndView replyDelete(VolunteerQuestionDTO volunteerQuestionDTO, int volunteerNo) throws Exception {

    VolunteerRequestDTO volunteer = new VolunteerRequestDTO();
    volunteer.setNo(volunteerNo);
    volunteerQuestionDTO.setVolunteer(volunteer);

    VolunteerQuestionDTO volunteerQuestion = volunteerQuestionDao.findByNo(volunteerQuestionDTO);

    if (volunteerQuestion == null) {
      throw new Exception("해당 번호의 봉사댓글이 없습니다");
    }

    volunteerQuestion.setReply(null);

    volunteerQuestionDao.updateReply(volunteerQuestion);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:../../volunteer/detail?no=" + volunteerNo);
    return mv;
  }
}







