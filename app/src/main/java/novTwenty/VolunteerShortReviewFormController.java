package com.share.ftp.web.volunteer;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerShortReviewDao;


@WebServlet("/volunteer/reviewForm")
public class VolunteerShortReviewFormController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  VolunteerShortReviewDao volunteerShortReviewDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    volunteerShortReviewDao = (VolunteerShortReviewDao) 웹애플리케이션공용저장소.getAttribute("VolunteerBoardAdd.jsp");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 출력을 담당할 뷰를 호출한다.
    request.getRequestDispatcher("VolunteerShortReviewForm.jsp").forward(request, response);

    try {
    } catch (Exception e) {

      e.printStackTrace();

      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }

  }
}








