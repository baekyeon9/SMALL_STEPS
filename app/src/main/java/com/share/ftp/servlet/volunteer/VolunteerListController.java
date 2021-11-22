package com.share.ftp.servlet.volunteer;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;

@WebServlet("/volunteer/list")
public class VolunteerListController extends HttpServlet { 

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

      List<VolunteerRequestDTO> volunteerList = volunteerDao.findAllApproved();

      request.setAttribute("volunteerList", volunteerList);
      request.getRequestDispatcher("VolunteerList.jsp").forward(request, response);


    } catch (Exception e) {
      e.printStackTrace();

      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }

  }

  //  @Override
  //  public void execute(CommandRequest request) throws Exception {
  //    System.out.println();
  //    System.out.println("[ 봉사 목록 ]");
  //
  //
  //
  //    if (volunteerList.isEmpty()) {
  //      System.out.println("[  현재 승인된 봉사목록이 없습니다. ]");
  //      return;
  //    }
  //
  //    for (VolunteerRequestDTO volunteerRequestDTO : volunteerList) {
  //      System.out.printf("%d, %s, %s, %s, %s, %s, %s, %s, %s, %s, %d, %s", 
  //          volunteerRequestDTO.getNo(),      
  //          volunteerRequestDTO.getTitle(),     
  //          volunteerRequestDTO.getOwner().getId(), 
  //          volunteerRequestDTO.getCategory().getTitle(), 
  //          volunteerRequestDTO.getTel(),
  //          volunteerRequestDTO.getEmail(),
  //          volunteerRequestDTO.getStartDate(),
  //          volunteerRequestDTO.getEndDate(),
  //          volunteerRequestDTO.getStartTime(),
  //          volunteerRequestDTO.getEndTime(),
  //          volunteerRequestDTO.getLimitNum(),
  //          volunteerRequestDTO.getContent() 
  //          );
  //
  //      for (VolunteerAttachedFile file : volunteerRequestDTO.getFileUpload()) {
  //        System.out.printf(", %s", file.getFilepath());
  //      }
  //      System.out.println();
  //    } 
  //
  //    System.out.println();
  //
  //    int no = Prompt.inputInt("상세보기 할 봉사 번호를 입력해주세요(이전 0번) ▶ ");
  //    if (no == 0) {
  //      return;
  //    }
  //
  //    request.setAttribute("no", no); 
  //    request.getRequestDispatcher("/vol/detail").forward(request);

  //}
}
