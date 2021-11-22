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
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.dao.JoinDao;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.Category;


@WebServlet("/volunteer/form")
public class VolunteerFormController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  VolunteerDao volunteerDao;
  GeneralDao generalDao;
  JoinDao joinDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    volunteerDao = (VolunteerDao) 웹애플리케이션공용저장소.getAttribute("volunteerDao");
    generalDao = (GeneralDao) 웹애플리케이션공용저장소.getAttribute("generalDao");
    joinDao = (JoinDao) 웹애플리케이션공용저장소.getAttribute("joinDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      //      List<JoinDTO> user = joinDao.findAll();
      List<Category> categorys = generalDao.findAllCategory();

      //      request.setAttribute("user", user);
      request.setAttribute("categorys", categorys);
      request.getRequestDispatcher("VolunteerForm.jsp").forward(request, response);

    } catch (Exception e) {

      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }


  }
}







