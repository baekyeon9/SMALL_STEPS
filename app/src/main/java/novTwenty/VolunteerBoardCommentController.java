package com.share.ftp.web.volunteer;

import java.util.Collection;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.VolunteerBoardCommentDao;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.VolunteerBoardCommentDTO;
import com.share.ftp.domain.community.VolunteerBoardDTO;
import com.share.ftp.domain.join.JoinDTO;

@Controller
public class VolunteerBoardCommentController {
  //  private static final Logger logger = LogManager.getLogger(VolunteerBoardCommentController.class); 

  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired VolunteerBoardDao volunteerBoardDao;
  @Autowired VolunteerBoardCommentDao volunteerBoardCommentDao;

  //  @GetMapping("/volunteer/commentForm")
  //  public ModelAndView form(int volBoardNo) {
  //    ModelAndView mv = new ModelAndView();
  //    mv.addObject("volBoardNo", volBoardNo);
  //    mv.addObject("pageTitle", "새 댓글");
  //    mv.addObject("contentUrl", "volunteer/VolunteerBoardCommentForm.jsp");
  //    mv.setViewName("template1");
  //    return mv;
  //  }

  @PostMapping("/volunteer/commentAdd")
  public ModelAndView add(
      VolunteerBoardCommentDTO volunteerBoardCommentDTO, HttpSession session, int volBoardNo) throws Exception {

    volunteerBoardCommentDTO.setOwner((JoinDTO) session.getAttribute("loginUser"));
    //   volunteerBoardCommentDTO.setNo((Integer)session.getAttribute("volBoardNo"));   

    volunteerBoardCommentDao.insert(volunteerBoardCommentDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:boardDetail?no=" +volBoardNo);
    return mv;
  }

  @GetMapping("/volunteer/commentList")
  public ModelAndView list(int volBoardNo) throws Exception {

    VolunteerBoardDTO volunteerBoardDTO = volunteerBoardDao.findByNo(volBoardNo);
    Collection<VolunteerBoardCommentDTO> volunteerBoardCommentList = volunteerBoardCommentDao.findAllNo(volBoardNo);

    ModelAndView mv = new ModelAndView();
    mv.addObject("volunteerBoardDTO", volunteerBoardDTO);
    mv.addObject("volunteerBoardCommentList", volunteerBoardCommentList);
    mv.addObject("pageTitle", "Happy share: 참여인증&댓글");
    mv.addObject("contentUrl", "volunteer/VolunteerBoardCommentList.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @PostMapping("/volunteer/commentUpdateDetail")
  public ModelAndView updateDetail(int no) throws Exception {
    VolunteerBoardCommentDTO volunteerBoardCommentDTO = volunteerBoardCommentDao.findByNo(no);

    if (volunteerBoardCommentDTO == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }

    ModelAndView mv = new ModelAndView();
    mv.addObject("volunteerBoardCommentDTO", volunteerBoardCommentDTO);
    mv.addObject("pageTitle", "댓글 변경");
    mv.addObject("contentUrl", "volunteer/VolunteerBoardCommentUpdateDetail.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @PostMapping("/volunteer/commentUpdate")
  public ModelAndView update(
      VolunteerBoardCommentDTO volunteerBoardCommentDTO,
      HttpSession session) throws Exception {

    VolunteerBoardCommentDTO oldComment= volunteerBoardCommentDao.findByNo(volunteerBoardCommentDTO.getNo());

    if (oldComment == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    } 

    //    oldComment.setOwner((JoinDTO) session.getAttribute("loginUser"));


    //    if (oldComment == null) {
    //      throw new Exception("해당 번호의 게시글이 없습니다.");
    //    } 

    volunteerBoardCommentDao.update(volunteerBoardCommentDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:boardDetail?no=" + volunteerBoardCommentDTO.getVolBoardNo());
    return mv;
  }

  @GetMapping("/volunteer/commentDelete")
  public ModelAndView delete(int no) throws Exception {

    VolunteerBoardCommentDTO volunteerBoardCommentDTO = volunteerBoardCommentDao.findByNo(no);
    if (volunteerBoardCommentDTO == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }

    volunteerBoardCommentDao.delete(volunteerBoardCommentDTO.getNo());
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:commentList?volBoardNo=" + volunteerBoardCommentDTO.getVolBoardNo());
    return mv;
  }


}
