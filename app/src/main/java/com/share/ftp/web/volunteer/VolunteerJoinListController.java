package com.share.ftp.web.volunteer;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.join.JoinDTO;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;

//@WebServlet("/volunteer/join/list")
public class VolunteerJoinListController extends HttpServlet {

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

    try {
      int volNo = Integer.parseInt(request.getParameter("no"));

      List<VolunteerRequestDTO> volunteerList = volunteerDao.findAllJoin(volNo); 


      if (volunteerList == null) {
        throw new Exception("해당 참여자가 없습니다.");
      }

      List<JoinDTO> members = volunteerList.get(volNo - 1).getMembers();

      request.setAttribute("members", members);
      request.setAttribute("volNo", volNo);
      request.setAttribute("volunteerList", volunteerList);
      request.getRequestDispatcher("/volunteer/VolunteerJoin.jsp").forward(request, response);


    } catch (Exception e) {

      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }

  }






}
//  @Override
//  public void execute(CommandRequest request) throws Exception {
//    System.out.println();
//    System.out.println("[  봉사 참여자 목록  ]");
//    System.out.println();
//    System.out.println(" ▶ 참여인원을 확인하고 싶은 봉사번호를 입력해주세요.");
//    System.out.println();
//
//    int volNo = (int) request.getAttribute("volNo");
//    System.out.println();
//
//    VolunteerRequestDTO volunteer = volunteerDao.findByApprovedVolunteerNo(volNo); 
//
//    if (volunteer == null) {
//      System.out.println("해당 봉사가 없습니다.");
//      return;
//    }
//
//
//    System.out.printf("봉사제목: %s\n현재 봉사인원: %d명 / 총 봉사인원: %d명\n\n주최자명: %s(%s)\n\n           [  봉사자명  ]\n\n%s\n",
//        volunteer.getTitle(),
//        volunteer.getCurrentNum(),
//        volunteer.getLimitNum(),
//        volunteer.getOwner().getId(), // 주최자 아이디
//        volunteer.getOwner().getName(), // 주최자 이룸
//        volunteer.getMemberNames());
//  }


