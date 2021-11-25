package com.share.ftp.web.volunteer;

import java.util.Collection;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
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
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

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
  public ModelAndView add(
      VolunteerBoardDTO volunteerBoardDTO, 
      HttpSession session,
      Part photoFile) throws Exception {

    if (photoFile.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      photoFile.write(sc.getRealPath("/upload/volunteer") + "/" + filename);
      volunteerBoardDTO.setPhoto(filename);

      Thumbnails.of(sc.getRealPath("/upload/volunteer") + "/" + filename)
      .size(20, 20)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_20x20";
        }
      });

      Thumbnails.of(sc.getRealPath("/upload/volunteer") + "/" + filename)
      .size(100, 100)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_100x100";
        }
      });

      Thumbnails.of(sc.getRealPath("/upload/volunteer") + "/" + filename)
      .size(500, 500)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_500x500";
        }
      });
    }

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
  public ModelAndView detail(int no, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
    VolunteerBoardDTO volunteerBoardDTO = volunteerBoardDao.findByNo(no);
    Collection<VolunteerBoardCommentDTO> volunteerBoardCommentList = volunteerBoardCommentDao.findAllNo(no);
    //    System.out.println("request IP ==================>  " + request.getRemoteAddr());
    //    System.out.println("request server name ==================>  " + request.getServerName());
    //    System.out.println("request context path ==================>  " + request.getContextPath());
    //    System.out.println("request no ==================>  " + request.getParameter("no"));
    //    System.out.println("request viewcount ==================>  " + request.getParameter("viewcount"));
    //
    //    // 저장된 쿠키 불러오기
    //    Cookie cookies[] = request.getCookies();
    //    Map mapCookie = new HashMap();
    //    if(request.getCookies() != null){
    //      for (int i = 0; i < cookies.length; i++) {
    //        System.out.println("cookies.length ============> " + cookies.length);
    //        Cookie obj = cookies[i];
    //        mapCookie.put(obj.getName(),obj.getValue());
    //        System.out.println("obj.getName ============> " + obj.getName());
    //        System.out.println("obj.getValue ============> " + obj.getValue());
    //      }
    //    }
    //
    //    // 저장된 쿠키중에 read_count 만 불러오기
    //    String cookie_read_count = (String) mapCookie.get("read_count");
    //    // 저장될 새로운 쿠키값 생성
    //    String new_cookie_read_count = "|" + no;
    //
    //    // 저장된 쿠키에 새로운 쿠키값이 존재하는 지 검사
    //    if (cookie_read_count.equals("") ) {
    //      // 없을 경우 쿠키 생성
    //      Cookie cookie = new Cookie("read_count", cookie_read_count + new_cookie_read_count);
    //      //cookie.setMaxAge(1000); // 초단위
    //      response.addCookie(cookie);
    //
    //      // 조회수 업데이트
    //      this.volunteerBoardDao.updateCount(no);
    //    }
    //
    //



    //    String jsession = request.getParameter("JSESSIONID");

    //    System.out.println("::JSESSIONID::: ===> " + jsession);

    /*
     * Cookie[] cookies = request.getCookies(); // System.out.println("cookies ============> " +
     * cookies);
     * 
     * String cookieKey = "JSESSIONID"; String cookieValue = "";
     * 
     * if (cookies != null) {
     * 
     * for(Cookie c: cookies){// c.setMaxAge(10 * 60); //10분 cookieValue = c.getValue();
     * 
     * if(!c.getValue().equals(cookieValue) ){ System.out.println("false =============> !!!!!");
     * volunteerBoardDao.updateCount(no); sqlSessionFactory.openSession().commit(); }
     * 
     * 
     * }
     * 
     * }
     */

    //    BoardDAO bDao=BoardDAO.getInstance();

    //    //쿠키변수를 만들어서 값을 저장. 쿠키변수에 값이 있으면 조회수 증가 실행 하지 않음
    //    boolean isGet=false;
    //    Cookie[] cookies=request.getCookies();
    //    if(cookies!=null){   
    //      for(Cookie c: cookies){//    
    //        //num쿠키가 있는 경우
    //        if(c.getName().equals(num)){
    //          isGet=true; 
    //        }
    //      }
    // num쿠키가 없는 경우
    //      if(!isGet) {
    //        volunteerBoardDao.updateCount(num);//조회수증가
    //        Cookie c1 = new Cookie(num, num);
    //        c1.setMaxAge(1*24*60*60);//하루저장
    //        response.addCookie(c1);    
    //      }
    //    }
    //
    //    //    bDao.updateReadCount(num);//조회수증가
    //    BoardVO bVo=bDao.selectOneBoardByNum(num);
    //
    //    request.setAttribute("board", bVo);
    //    RequestDispatcher dispatcher=request.getRequestDispatcher(url);
    //    dispatcher.forward(request, response);

    //
    //
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
  public ModelAndView update(VolunteerBoardDTO volunteerBoardDTO, Part photoFile) throws Exception {

    VolunteerBoardDTO oldBoard = volunteerBoardDao.findByNo(volunteerBoardDTO.getNo());
    if (oldBoard == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    } 

    volunteerBoardDTO.setPhoto(oldBoard.getPhoto());

    if (photoFile.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      photoFile.write(sc.getRealPath("/upload/volunteer") + "/" + filename);
      volunteerBoardDTO.setPhoto(filename);

      Thumbnails.of(sc.getRealPath("/upload/volunteer") + "/" + filename)
      .size(20, 20)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_20x20";
        }
      });

      Thumbnails.of(sc.getRealPath("/upload/volunteer") + "/" + filename)
      .size(100, 100)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_100x100";
        }
      });

      Thumbnails.of(sc.getRealPath("/upload/volunteer") + "/" + filename)
      .size(500, 500)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_500x500";
        }
      });
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
