package com.share.ftp.web.volunteer;

import java.util.Collection;
import javax.servlet.ServletContext;
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
public class VolunteerBoardController {

  @Autowired SqlSessionFactory sqlSessionFactory;
  @Autowired VolunteerBoardCommentDao volunteerBoardCommentDao;
  @Autowired VolunteerBoardDao volunteerBoardDao;
  @Autowired ServletContext sc;

  @GetMapping("/volunteer/boardForm")
  public ModelAndView form() {
    ModelAndView mv = new ModelAndView();
    mv.addObject("pageTitle", "새 글");
    mv.addObject("contentUrl", "volunteer/VolunteerBoardForm.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @PostMapping("/volunteer/boardAdd")
  public ModelAndView add(VolunteerBoardDTO volunteerBoardDTO, HttpSession session) throws Exception {

    //      if (photoFile.getSize() > 0) {
    //        String filename = UUID.randomUUID().toString();
    //        photoFile.write(sc.getRealPath("/upload/member") + "/" + filename);
    //        member.setPhoto(filename);
    //  
    //        Thumbnails.of(sc.getRealPath("/upload/member") + "/" + filename)
    //        .size(20, 20)
    //        .outputFormat("jpg")
    //        .crop(Positions.CENTER)
    //        .toFiles(new Rename() {
    //          @Override
    //          public String apply(String name, ThumbnailParameter param) {
    //            return name + "_20x20";
    //          }
    //        });
    //  
    //        Thumbnails.of(sc.getRealPath("/upload/member") + "/" + filename)
    //        .size(100, 100)
    //        .outputFormat("jpg")
    //        .crop(Positions.CENTER)
    //        .toFiles(new Rename() {
    //          @Override
    //          public String apply(String name, ThumbnailParameter param) {
    //            return name + "_100x100";
    //          }
    //        });
    //      }

    volunteerBoardDTO.setOwner((JoinDTO) session.getAttribute("loginUser"));

    volunteerBoardDao.insert(volunteerBoardDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:boardList");
    return mv;

  }

  @GetMapping("/volunteer/boardList")
  public ModelAndView list() throws Exception {
    Collection<VolunteerBoardDTO> volunteerBoardList = volunteerBoardDao.findAll();

    ModelAndView mv = new ModelAndView();
    mv.addObject("volunteerBoardList", volunteerBoardList);
    mv.addObject("pageTitle", "게시글목록");
    mv.addObject("contentUrl", "volunteer/VolunteerBoardList.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @GetMapping("/volunteer/boardDetail")
  public ModelAndView detail(int no) throws Exception {
    VolunteerBoardDTO volunteerBoardDTO = volunteerBoardDao.findByNo(no);
    Collection<VolunteerBoardCommentDTO> volunteerBoardCommentList = volunteerBoardCommentDao.findAllNo(no);

    volunteerBoardDao.updateCount(no);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.addObject("volunteerBoardDTO", volunteerBoardDTO);
    mv.addObject("volunteerBoardCommentList", volunteerBoardCommentList);
    mv.addObject("pageTitle", "게시글 상세보기");
    mv.addObject("contentUrl", "volunteer/VolunteerBoardDetail.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @PostMapping("/volunteer/boardUpdate")
  public ModelAndView update(VolunteerBoardDTO volunteerBoardDTO) throws Exception {

    VolunteerBoardDTO oldBoard = volunteerBoardDao.findByNo(volunteerBoardDTO.getNo());
    if (oldBoard == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    } 

    volunteerBoardDao.update(volunteerBoardDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:boardList");
    return mv;
  }

  @GetMapping("/volunteer/boardDelete")
  public ModelAndView delete(int no) throws Exception {

    VolunteerBoardDTO volunteerBoardDTO = volunteerBoardDao.findByNo(no);
    if (volunteerBoardDTO == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }

    volunteerBoardDao.deleteComment(no);
    volunteerBoardDao.deleteFile(volunteerBoardDTO);
    volunteerBoardDao.delete(no);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:boardList");
    return mv;
  }


}
