package com.share.ftp.web.volunteer;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;

//@WebServlet("/volunteer/delete")
public class VolunteerDeleteController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  VolunteerDao volunteerDao;
  SqlSession sqlSession;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    volunteerDao = (VolunteerDao) 웹애플리케이션공용저장소.getAttribute("volunteerDao");
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

      volunteerDao.delete(volunteer);
      sqlSession.commit();

      response.sendRedirect("list");


    } catch (Exception e) {
      request.setAttribute("error", e);

      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}







