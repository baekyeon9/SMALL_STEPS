package com.share.ftp.servlet.volunteer;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerBoardCommentDao;
import com.share.ftp.domain.community.VolunteerBoardCommentDTO;

@WebServlet("/volunteer/commentDelete")
public class VolunteerBoardCommentDeleteController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  VolunteerBoardCommentDao volunteerBoardCommentDao;
  SqlSession sqlSession;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    volunteerBoardCommentDao = (VolunteerBoardCommentDao) 웹애플리케이션공용저장소.getAttribute("volunteerBoardCommentDao");  
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      int commentNo = Integer.parseInt(request.getParameter("no"));
      VolunteerBoardCommentDTO volunteerBoardcommentDTO = volunteerBoardCommentDao.findByNo(commentNo);
      if (volunteerBoardcommentDTO == null) {
        throw new Exception("해당 번호의 게시글이 없습니다.");
      }

      volunteerBoardCommentDao.delete(volunteerBoardcommentDTO.getNo());
      sqlSession.commit();

      response.sendRedirect("commentList?volBoardNo=" + Integer.parseInt(request.getParameter("volBoardNo")));

    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }
}

