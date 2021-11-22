package com.share.ftp.servlet.volunteer;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.join.PersonalDTO;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;
import com.share.util.GeneralHelper;
import com.share.util.Prompt;

@WebServlet("/volunteer/join/add")
public class VolunteerJoinController extends HttpServlet { 

  private static final long serialVersionUID = 1L;

  VolunteerDao volunteerDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    volunteerDao = (VolunteerDao) 웹애플리케이션공용저장소.getAttribute("volunteerDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    //    if (AuthLoginHandler.getLoginUser().getType() == GROUP || 
    //        AuthLoginHandler.getLoginUser().getType() == ORG) {
    //      System.out.println("개인회원만 참여할 수 있습니다!");
    //      return;
    //    }

    //샘플 회원 
    PersonalDTO loginUser = new PersonalDTO();
    loginUser.setNo(15);
    loginUser.setName("testUser");
    loginUser.setStatus(1);
    loginUser.setLevel("천콩이");



    int volNo = Integer.parseInt(request.getParameter("no"));

    try {
      VolunteerRequestDTO volunteer = volunteerDao.findByApprovedVolunteerNo(volNo);

      if (volunteer == null) {
        throw new Exception("해당 번호의 봉사가 없습니다.");
      }

      //주최자 유효성검사
      if (volunteer.getOwner().getId().equals(loginUser.getId())) {
        throw new Exception("당신은 이미 주최자입니다!");
      }

      // 봉사인원 유효성 검사
      if (volunteer.getCurrentNum() == volunteer.getLimitNum()) {
        throw new Exception("[ 정원이 초과하였습니다! 다음에 참여해주세요! ]");
      }


      if (volunteerRequestDTO.getMemberNames().contains(loginUser.getId())) {
        System.out.println("이미 봉사참여를 하셨습니다!");
        return;
      } 


      Date applyDate = Prompt.inputDate("참여일(yyyy-mm-dd) ▶ ");

      GeneralHelper.promptVolunteerTime(volunteerRequestDTO);



      String input = Prompt.inputString("해당 봉사활동을 참가하시겠습니까?(y/N) ▶ ");
      if (!input.equals("y") || input.length() == 0) {
        System.out.println("[  해당 봉사신청 참여를 취소하였습니다. ]");
        return;
      }



      volunteer.setUserNo(1);
      volunteer.setVolNo(volunteer.getNo());
      volunteer.setApplyOwner(loginUser);
      volunteer.setApplyDate(applyDate);
      volunteer.setApplyStatus(APPLIED);

      // 출력할 멤버 list에 추가시킨다
      volunteerRequestDTO.addMembers(loginUser);
      // 주최자 이름이 멤버 출력하는데 포함되어 있다면 제거
      if (volunteerRequestDTO.getMembers().contains(volunteerRequestDTO.getOwner())) {
        volunteerRequestDTO.getMembers().remove(volunteerRequestDTO.getOwner());
      }
      loginUser.setPoint(loginUser.getPoint() + VOLUNTEER_POINT);

      // 총 참여 인원(주최자1명 포함)을 누적시킨다.
      int count = volunteerRequestDTO.getCurrentNum();
      volunteerRequestDTO.setCurrentNum(count += 1); 

      volunteerDao.insertUser(volunteerRequestDTO);

      System.out.println("[  ✔️ 봉사참여가 완료되었습니다. ]");

      request.setAttribute("volunteer", volunteer); 


    } catch (Exception e) {

      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }



  }
}

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
