package com.share.ftp.servlet.volunteer;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerBoardCommentDao;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.VolunteerBoardCommentDTO;
import com.share.ftp.domain.join.JoinDTO;

@WebServlet("/volunteer/commentAdd")
public class VolunteerBoardCommentAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  VolunteerBoardDao volunteerBoardDao;
  VolunteerBoardCommentDao volunteerBoardCommentDao;
  SqlSession sqlSession;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    volunteerBoardDao = (VolunteerBoardDao) 웹애플리케이션공용저장소.getAttribute("volunteerBoardDao");
    volunteerBoardCommentDao = (VolunteerBoardCommentDao) 웹애플리케이션공용저장소.getAttribute("volunteerBoardCommentDao");
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    VolunteerBoardCommentDTO volunteerBoardCommentDTO = new VolunteerBoardCommentDTO();

    JoinDTO owner = new JoinDTO();
    owner.setNo(Integer.parseInt(request.getParameter("owner")));

    volunteerBoardCommentDTO.setCommentContent(request.getParameter("commentContent")); 
    volunteerBoardCommentDTO.setOwner(owner);

    //  for (VolunteerBoardAttachedFile volunteerAttachedFile : volunteerBoardDTO.getFileUpload()) {
    //        volunteerBoardDao.insertFile(volunteerBoardDTO.getNo(), volunteerAttachedFile.getFilepath());
    //      }

    try {
      volunteerBoardCommentDTO.setVolBoardNo(Integer.parseInt(request.getParameter("volBoardNo")));
      volunteerBoardCommentDao.insert(volunteerBoardCommentDTO);
      sqlSession.commit();
      response.setHeader("Refresh", "1;url=commentList?volBoardNo=" + Integer.parseInt(request.getParameter("volBoardNo")));
      request.getRequestDispatcher("VolunteerBoardCommentAdd.jsp").forward(request, response);

    } catch (Exception e) {
      e.printStackTrace();  
      request.setAttribute("error", e);

      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }
  }
}
