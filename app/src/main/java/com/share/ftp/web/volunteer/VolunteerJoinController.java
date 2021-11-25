package com.share.ftp.web.volunteer;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.dao.VolunteerJoinDao;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.volunteer.VolunteerJoinDTO;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;

@Controller
@RequestMapping("/volunteer/join")
public class VolunteerJoinController { 


  @Autowired VolunteerJoinDao volunteerJoinDao;
  @Autowired VolunteerDao VolunteerDao;
  @Autowired SqlSessionFactory sqlSessionFactory;



  @GetMapping("form")
  public ModelAndView form(int no) throws Exception {

    VolunteerRequestDTO volunteer = VolunteerDao.findByVolunteerNo(no);

    //    List<Category> categorys = generalDao.findAllCategory();

    ModelAndView mv = new ModelAndView();
    mv.addObject("pageTitle", "함께해요 : 봉사참여");
    mv.addObject("volunteer", volunteer);
    mv.addObject("contentUrl", "volunteer/join/VolunteerJoinForm.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @PostMapping("add")
  public ModelAndView add(
      VolunteerRequestDTO volunteerRequestDTO,
      VolunteerJoinDTO volunteerJoinDTO, 
      HttpSession session, 
      int no) throws Exception {

    volunteerRequestDTO.setNo(no);
    volunteerJoinDTO.setVolunteer(volunteerRequestDTO);
    volunteerJoinDTO.setJoinUser((JoinDTO) session.getAttribute("loginUser"));


    volunteerJoinDao.insert(volunteerJoinDTO);
    sqlSessionFactory.openSession().commit();

    ModelAndView mv = new ModelAndView();
    mv.setViewName("redirect:../list");
    return mv;
  }

  @GetMapping("list")
  public ModelAndView list(int no) throws Exception {

    List<VolunteerJoinDTO> volunteerList = volunteerJoinDao.findAllNo(no);

    ModelAndView mv = new ModelAndView();
    mv.addObject("volunteerList", volunteerList);
    mv.addObject("pageTitle", "함께해요 : 봉사참여자목록");
    mv.addObject("contentUrl", "volunteer/join/VolunteerJoinMember.jsp");
    mv.setViewName("template1");
    return mv;
  }

  @GetMapping("detail")
  public ModelAndView detail(int no) throws Exception {

    List<VolunteerJoinDTO> volunteerList = volunteerJoinDao.findAllNo(no);

    ModelAndView mv = new ModelAndView();
    mv.addObject("volunteerList", volunteerList);
    mv.addObject("pageTitle", "함께해요 : 봉사참여");
    mv.addObject("contentUrl", "volunteer/join/VolunteerJoin1.jsp");
    mv.setViewName("template1");
    return mv;
  }

}










//  @PostMapping("/volunteer/join/add")
//  public ModelAndView add(VolunteerRequestDTO volunteerRequestDTO, HttpSession session) throws Exception {
//
//    JoinDTO user = (JoinDTO) session.getAttribute("loginUser");
//
//    volunteerRequestDTO.setUserNo(user.getNo());
//
//
//    volunteerDao.insert(volunteerRequestDTO);
//    sqlSessionFactory.openSession().commit();
//
//    ModelAndView mv = new ModelAndView();
//    mv.addObject(mv);
//    mv.setViewName("redirect:list");
//    return mv;
//  }
//
//  request.setAttribute("volunteer", volunteer); 
//  request.setAttribute("pageTitle", "함께해요 : 봉사참여");
//  request.setAttribute("contentUrl", "/volunteer/VolunteerJoinCalendarTest.jsp");
//  request.getRequestDispatcher("/template1.jsp").forward(request, response);


//    if (AuthLoginHandler.getLoginUser().getType() == GROUP || 
//        AuthLoginHandler.getLoginUser().getType() == ORG) {
//      System.out.println("개인회원만 참여할 수 있습니다!");
//      return;
//    }
//
//    //샘플 회원 
//    PersonalDTO loginUser = new PersonalDTO();
//    loginUser.setNo(15);
//    loginUser.setName("testUser");
//    loginUser.setStatus(1);
//    loginUser.setLevel("천콩이");
//
//
//
//  int volNo = Integer.parseInt(request.getParameter("no"));
//
//  try {
//    VolunteerRequestDTO volunteer = volunteerDao.findByApprovedVolunteerNo(volNo);
//    //
//      if (volunteer == null) {
//        throw new Exception("해당 번호의 봉사가 없습니다.");
//      }
//
//      //주최자 유효성검사
//      if (volunteer.getOwner().getId().equals(loginUser.getId())) {
//        throw new Exception("당신은 이미 주최자입니다!");
//      }
//
//      // 봉사인원 유효성 검사
//      if (volunteer.getCurrentNum() == volunteer.getLimitNum()) {
//        throw new Exception("[ 정원이 초과하였습니다! 다음에 참여해주세요! ]");
//      }
//
//
//      if (volunteerRequestDTO.getMemberNames().contains(loginUser.getId())) {
//        System.out.println("이미 봉사참여를 하셨습니다!");
//        return;
//      } 
//
//
//      Date applyDate = Prompt.inputDate("참여일(yyyy-mm-dd) ▶ ");
//
//      GeneralHelper.promptVolunteerTime(volunteerRequestDTO);
//
//
//
//      String input = Prompt.inputString("해당 봉사활동을 참가하시겠습니까?(y/N) ▶ ");
//      if (!input.equals("y") || input.length() == 0) {
//        System.out.println("[  해당 봉사신청 참여를 취소하였습니다. ]");
//        return;
//      }
//
//
//
//      volunteer.setUserNo(1);
//      volunteer.setVolNo(volunteer.getNo());
//      volunteer.setApplyOwner(loginUser);
//      volunteer.setApplyDate(applyDate);
//      volunteer.setApplyStatus(APPLIED);
//
//      // 출력할 멤버 list에 추가시킨다
//      volunteerRequestDTO.addMembers(loginUser);
//      // 주최자 이름이 멤버 출력하는데 포함되어 있다면 제거
//      if (volunteerRequestDTO.getMembers().contains(volunteerRequestDTO.getOwner())) {
//        volunteerRequestDTO.getMembers().remove(volunteerRequestDTO.getOwner());
//      }
//      loginUser.setPoint(loginUser.getPoint() + VOLUNTEER_POINT);
//
//      // 총 참여 인원(주최자1명 포함)을 누적시킨다.
//      int count = volunteerRequestDTO.getCurrentNum();
//      volunteerRequestDTO.setCurrentNum(count += 1); 
//
//      volunteerDao.insertUser(volunteerRequestDTO);
//
//      System.out.println("[  ✔️ 봉사참여가 완료되었습니다. ]");

//    request.setAttribute("volunteer", volunteer); 
//    request.setAttribute("pageTitle", "함께해요 : 봉사참여");
//    request.setAttribute("contentUrl", "/volunteer/VolunteerJoinCalendarTest.jsp");
//    request.getRequestDispatcher("/template1.jsp").forward(request, response);



//  } catch (Exception e) {
//    request.setAttribute("error", e);
//  }
//
//
//
//}
//}

//  
//  @Override
//  public void execute(CommandRequest request) throws Exception {
//    System.out.println();
//    System.out.println("[  봉사 참여  ]");
//    System.out.println();
//
//    if (AuthLoginHandler.getLoginUser().getType() == GROUP || 
//        AuthLoginHandler.getLoginUser().getType() == ORG) {
//      System.out.println("개인회원만 참여할 수 있습니다!");
//      return;
//    }
//
//    PersonalDTO loginUser = (PersonalDTO) AuthLoginHandler.getLoginUser();
//
//    int volNo = (int) request.getAttribute("volNo");
//
//    VolunteerRequestDTO volunteerRequestDTO = volunteerDao.findByApprovedVolunteerNo(volNo);
//
//    //    VolunteerJoinDTO volunteerJoinDTO = new VolunteerJoinDTO();
//
//    // 주최자 유효성검사
//    if (volunteerRequestDTO.getOwner().getId().
//        equals(loginUser.getId())) {
//      System.out.println("당신은 이미 주최자입니다!");
//      return;
//    }
//
//    // 봉사인원 유효성 검사
//    if (volunteerRequestDTO.getCurrentNum() == volunteerRequestDTO.getLimitNum()) {
//      System.out.println("[ 정원이 초과하였습니다! 다음에 참여해주세요! ]");
//      return;
//    }
//
//
//    if (volunteerRequestDTO.getMemberNames().contains(loginUser.getId())) {
//      System.out.println("이미 봉사참여를 하셨습니다!");
//      return;
//    } 
//
//
//    Date applyDate = Prompt.inputDate("참여일(yyyy-mm-dd) ▶ ");
//
//    GeneralHelper.promptVolunteerTime(volunteerRequestDTO);
//
//
//
//    String input = Prompt.inputString("해당 봉사활동을 참가하시겠습니까?(y/N) ▶ ");
//    if (!input.equals("y") || input.length() == 0) {
//      System.out.println("[  해당 봉사신청 참여를 취소하였습니다. ]");
//      return;
//    }
//
//
//
//    volunteerRequestDTO.setUserNo(loginUser.getNo());
//    volunteerRequestDTO.setVolNo(volunteerRequestDTO.getNo());
//    volunteerRequestDTO.setApplyOwner(AuthLoginHandler.getLoginUser());
//    volunteerRequestDTO.setApplyDate(applyDate);
//    volunteerRequestDTO.setApplyStatus(APPLIED);
//
//    // 출력할 멤버 list에 추가시킨다
//    volunteerRequestDTO.addMembers(loginUser);
//    // 주최자 이름이 멤버 출력하는데 포함되어 있다면 제거
//    if (volunteerRequestDTO.getMembers().contains(volunteerRequestDTO.getOwner())) {
//      volunteerRequestDTO.getMembers().remove(volunteerRequestDTO.getOwner());
//    }
//    loginUser.setPoint(loginUser.getPoint() + VOLUNTEER_POINT);
//
//    // 총 참여 인원(주최자1명 포함)을 누적시킨다.
//    int count = volunteerRequestDTO.getCurrentNum();
//    volunteerRequestDTO.setCurrentNum(count += 1); 
//
//    volunteerDao.insertUser(volunteerRequestDTO);
//
//    System.out.println("[  ✔️ 봉사참여가 완료되었습니다. ]");
//  }
