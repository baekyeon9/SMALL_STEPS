package com.share.ftp.web.volunteer;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.share.ftp.dao.GeneralDao;
import com.share.ftp.dao.JoinDao;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.Category;


//@WebServlet("/volunteer/form")
public class VolunteerFormController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  VolunteerDao volunteerDao;
  GeneralDao generalDao;
  JoinDao joinDao;

  @Override
  public void init() {
    ServletContext 웹애플리케이션공용저장소 = getServletContext();
    volunteerDao = (VolunteerDao) 웹애플리케이션공용저장소.getAttribute("volunteerDao");
    generalDao = (GeneralDao) 웹애플리케이션공용저장소.getAttribute("generalDao");
    joinDao = (JoinDao) 웹애플리케이션공용저장소.getAttribute("joinDao");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      //      List<JoinDTO> user = joinDao.findAll();
      List<Category> categorys = generalDao.findAllCategory();

      //      request.setAttribute("user", user);
      request.setAttribute("categorys", categorys);

      request.setAttribute("pageTitle", "함께해요 : 봉사신청");
      request.setAttribute("contentUrl", "/volunteer/VolunteerForm.jsp");
      request.getRequestDispatcher("/template1.jsp").forward(request, response);


    } catch (Exception e) {
      request.setAttribute("error", e);
    }
  }
}







