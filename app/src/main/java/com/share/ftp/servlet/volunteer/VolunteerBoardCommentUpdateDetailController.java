package com.share.ftp.servlet.volunteer;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.share.ftp.dao.VolunteerBoardCommentDao;
import com.share.ftp.domain.community.VolunteerBoardCommentDTO;

@WebServlet("/volunteer/commentUpdateDetail")
public class VolunteerBoardCommentUpdateDetailController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  VolunteerBoardCommentDao volunteerBoardCommentDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    volunteerBoardCommentDao = (VolunteerBoardCommentDao) 웹애플리케이션공용저장소.getAttribute("volunteerBoardCommentDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      int commentNo = Integer.parseInt(request.getParameter("no"));
      VolunteerBoardCommentDTO volunteerBoardCommentDTO = volunteerBoardCommentDao.findByNo(commentNo);

      if (volunteerBoardCommentDTO == null) {
        throw new Exception("[  해당 게시글이 없습니다.  ]");
      }

      request.setAttribute("volunteerBoardCommentDTO", volunteerBoardCommentDTO);
      // 출력을 담당할 뷰를 호출한다.
      request.getRequestDispatcher("VolunteerBoardCommentUpdateDetail.jsp").forward(request, response);

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}





