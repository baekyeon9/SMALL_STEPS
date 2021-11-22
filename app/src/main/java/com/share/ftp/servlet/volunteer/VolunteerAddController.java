package com.share.ftp.servlet.volunteer;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.Category;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.volunteer.VolunteerAttachedFile;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;

@WebServlet("/volunteer/add")
public class VolunteerAddController extends HttpServlet { 
  private static final long serialVersionUID = 1L;

  VolunteerDao volunteerDao;
  SqlSession sqlSession;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    volunteerDao = (VolunteerDao) 웹애플리케이션공용저장소.getAttribute("volunteerDao");


  }


  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    VolunteerRequestDTO volunteerRequestDTO = new VolunteerRequestDTO();

    Category category = new Category();
    category.setNo(Integer.parseInt(request.getParameter("category")));

    JoinDTO owner = new JoinDTO();
    owner.setNo(Integer.parseInt(request.getParameter("owner")));

    //    volunteerRequestDTO.setUserNo(Integer.parseInt(request.getParameter("owner")));
    volunteerRequestDTO.setOwner(owner);
    volunteerRequestDTO.setCategory(category);
    volunteerRequestDTO.setTitle(request.getParameter("title"));
    volunteerRequestDTO.setContent(request.getParameter("content")); 
    //    volunteerRequestDTO.setCategory(new GeneralHelper(generalDao).promptCategory());
    volunteerRequestDTO.setTel(request.getParameter("tel"));
    volunteerRequestDTO.setEmail(request.getParameter("email"));  
    volunteerRequestDTO.setStartDate(Date.valueOf(request.getParameter("startDate")));
    volunteerRequestDTO.setEndDate(Date.valueOf(request.getParameter("endDate"))); 
    volunteerRequestDTO.setStartTime(request.getParameter("startTime")); 
    volunteerRequestDTO.setEndTime(request.getParameter("endTime")); 
    volunteerRequestDTO.setLimitNum(Integer.parseInt(request.getParameter("limitNum")));
    //    volunteerRequestDTO.setFileUpload(GeneralHelper.promptFileUpload()); 
    volunteerRequestDTO.setStatus(Integer.parseInt(request.getParameter("status")));


    try {
      volunteerDao.insert(volunteerRequestDTO);
            for (VolunteerAttachedFile volunteerAttachedFile : volunteerRequestDTO.getFileUpload()) {
              volunteerDao.insertFile(volunteerRequestDTO.getNo(), volunteerAttachedFile.getFilepath());
            }
      sqlSession.commit();
      response.sendRedirect("list");


    } catch (Exception e) {
      sqlSession.rollback();
      request.setAttribute("error", e);
      e.printStackTrace();

      RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Error.jsp");
      requestDispatcher.forward(request, response);
    }
  }
}















//
//  @Override
//  public void execute(CommandRequest request) throws Exception {
//    System.out.println();
//    System.out.println("[  봉사신청서 양식  ]");
//
//    JoinDTO joinDTO = AuthLoginHandler.getLoginUser();
//
//    if (joinDTO.getType() == 1) {
//      System.out.println("개인 회원은 신청서를 작성할 수 없습니다!");
//      return;
//    }
//
//
//    if (joinDTO == null) {
//      System.out.println("[  ⛔ 로그인 후 사용가능합니다 ⛔  ]");
//      return;
//    }
//    while (true) {
//      try {
//
//        VolunteerRequestDTO volunteerRequestDTO = new VolunteerRequestDTO();
//
//        while (true) {
//          System.out.println(" ▶ 번호를 선택해주세요");
//          System.out.println();
//          System.out.println(" ▶ 1. 단체봉사신청");
//          System.out.println(" ▶ 2. 기관봉사신청");
//          System.out.println();
//
//          int num = Prompt.inputInt("번호입력 ▶ ");
//
//          switch (num) {
//            case 1: volunteerRequestDTO.setMemberType(GROUP);             break;
//            case 2: volunteerRequestDTO.setMemberType(ORG);               break;
//            default: System.out.println("올바를 숫자를 입력해주세요."); continue;
//          }
//
//          if (AuthLoginHandler.getLoginUser().getType() != volunteerRequestDTO.getMemberType()) {
//            System.out.println("당신은 해당 유형봉사를 신청 할 수 없습니다.");
//            System.out.println("단체회원인지 기관회원인지 확인하세요!");
//            continue;
//          }
//          break;
//        }
//
//        volunteerRequestDTO.setUserNo(AuthLoginHandler.getLoginUser().getNo());
//        volunteerRequestDTO.setTitle(Prompt.inputString("제목 ▶ "));
//
//        if (volunteerRequestDTO.getMemberType() == GROUP) {
//          GroupDTO groupUser = (GroupDTO) joinDTO;
//          volunteerRequestDTO.setOwner(groupUser);
//
//        } else if (volunteerRequestDTO.getMemberType() == ORG) {
//          OrgDTO orgUser = (OrgDTO) joinDTO;
//          volunteerRequestDTO.setOwner(orgUser);
//        }
//
//        volunteerRequestDTO.setCategory(new GeneralHelper(generalDao).promptCategory());
//        volunteerRequestDTO.setTel(Prompt.inputString("전화번호 ▶ "));
//        volunteerRequestDTO.setEmail(Prompt.inputString("이메일 ▶ ")); 
//        volunteerRequestDTO.setStartDate(Prompt.inputDate("봉사시작기간(yyyy-mm-dd) ▶ "));
//        volunteerRequestDTO.setEndDate(Prompt.inputDate("봉사종료기간(yyyy-mm-dd) ▶ ")); 
//        volunteerRequestDTO.setStartTime(Prompt.inputString("봉사시작시간(hh:mm) ▶ ")); 
//        volunteerRequestDTO.setEndTime(Prompt.inputString("봉사종료시간(hh:mm) ▶ ")); 
//        volunteerRequestDTO.setLimitNum(Prompt.inputInt("봉사인원 ▶ "));
//        volunteerRequestDTO.setContent(Prompt.inputString("내용 ▶ ")); 
//        volunteerRequestDTO.setFileUpload(GeneralHelper.promptFileUpload()); 
//        volunteerRequestDTO.setStatus(WAITING);
//
//        try {
//          volunteerDao.insert(volunteerRequestDTO);
//          for (VolunteerAttachedFile volunteerAttachedFile : volunteerRequestDTO.getFileUpload()) {
//            volunteerDao.insertFile(volunteerRequestDTO.getNo(), volunteerAttachedFile.getFilepath());
//          }
//          sqlSession.commit();
//
//        } catch (Exception e) {
//          sqlSession.rollback();
//        }
//
//      } catch (NumberFormatException e) {
//        System.out.println("--------------------------------------------------------------");
//        System.out.println("올바른 숫자를 입력하세요");
//        System.out.println("--------------------------------------------------------------");
//        continue; // 나중에 설정할거
//
//      } catch (Exception e) {
//        System.out.println("--------------------------------------------------------------");
//        //      System.out.printf("오류 발생: %s\n", e.getClass().getName());
//        System.out.println("다시 입력 바랍니다.");
//        System.out.println("--------------------------------------------------------------");
//        continue;
//      }
//      break;
//    }
//    System.out.println("[  ✔️ 봉사신청이 정상적으로 완료되었습니다. ]");
//  }
