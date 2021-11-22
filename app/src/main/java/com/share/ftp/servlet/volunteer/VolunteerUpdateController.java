package com.share.ftp.servlet.volunteer;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;

@WebServlet("/volunteer/update")
public class VolunteerUpdateController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  VolunteerDao volunteerDao;
  //  GeneralDao generalDao;
  SqlSession sqlSession;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    volunteerDao = (VolunteerDao) 웹애플리케이션공용저장소.getAttribute("volunteerDao");
    //    generalDao = (GeneralDao) 웹애플리케이션공용저장소.getAttribute("generalDao");
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      int volNo = Integer.parseInt(request.getParameter("no"));

      VolunteerRequestDTO volunteer = volunteerDao.findByVolunteerNo(volNo);

      if (volunteer == null) {
        throw new Exception("해당 번호의 봉사가 없습니다");
      } 


      volunteer.setTitle(request.getParameter("title"));
      //      volunteer.setCategory(new GeneralHelper(generalDao).promptCategory());
      volunteer.setTel(request.getParameter("tel"));
      volunteer.setEmail(request.getParameter("email"));  
      volunteer.setStartDate(Date.valueOf(request.getParameter("startDate")));
      volunteer.setEndDate(Date.valueOf(request.getParameter("endDate"))); 
      volunteer.setStartTime(request.getParameter("startTime")); 
      volunteer.setEndTime(request.getParameter("endTime")); 
      volunteer.setLimitNum(Integer.parseInt(request.getParameter("limitNum")));
      volunteer.setContent(request.getParameter("content")); 
      //    volunteerRequestDTO.setFileUpload(GeneralHelper.promptFileUpload()); 




      volunteerDao.update(volunteer);
      sqlSession.commit();

      response.sendRedirect("list");


    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);

      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}







