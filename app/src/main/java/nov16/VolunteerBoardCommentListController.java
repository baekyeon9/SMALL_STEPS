package com.share.ftp.web.volunteer;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import com.share.ftp.dao.VolunteerBoardCommentDao;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.VolunteerBoardCommentDTO;
import com.share.ftp.domain.community.VolunteerBoardDTO;

@WebServlet("/volunteer/commentList")
public class VolunteerBoardCommentListController extends GenericServlet {
  private static final long serialVersionUID = 1L;

  VolunteerBoardDao volunteerBoardDao;
  VolunteerBoardCommentDao volunteerBoardCommentDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    volunteerBoardDao = (VolunteerBoardDao) 웹애플리케이션공용저장소.getAttribute("volunteerBoardDao");
    volunteerBoardCommentDao = (VolunteerBoardCommentDao) 웹애플리케이션공용저장소.getAttribute("volunteerBoardCommentDao");
  }

  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    try {
      int volBoardNo = Integer.parseInt(request.getParameter("volBoardNo"));
      VolunteerBoardDTO volunteerBoardDTO = volunteerBoardDao.findByNo(volBoardNo);

      Collection<VolunteerBoardCommentDTO> volunteerBoardCommentList = volunteerBoardCommentDao.findAllNo(volBoardNo);
      request.setAttribute("volunteerBoardDTO", volunteerBoardDTO);
      request.setAttribute("volunteerBoardCommentList", volunteerBoardCommentList);

      request.setAttribute("contentUrl", "/volunteer/VolunteerBoardCommentList.jsp");
      request.getRequestDispatcher("/template1.jsp").forward(request, response);

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);

      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }
  }
}