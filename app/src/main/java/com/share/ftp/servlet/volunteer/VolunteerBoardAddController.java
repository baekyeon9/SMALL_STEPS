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
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.VolunteerBoardDTO;
import com.share.ftp.domain.join.JoinDTO;

@WebServlet("/volunteer/boardAdd")
public class VolunteerBoardAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  VolunteerBoardDao volunteerBoardDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    volunteerBoardDao = (VolunteerBoardDao) 웹애플리케이션공용저장소.getAttribute("volunteerBoardDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    VolunteerBoardDTO volunteerBoardDTO = new VolunteerBoardDTO();

    JoinDTO owner = new JoinDTO();
    owner.setNo(Integer.parseInt(request.getParameter("owner")));

    volunteerBoardDTO.setOwner(owner);
    volunteerBoardDTO.setTitle(request.getParameter("title"));
    volunteerBoardDTO.setContent(request.getParameter("content"));
    //    volunteerBoardDTO.setRegisteredDate(new Date(System.currentTimeMillis()));
    //    volunteerBoardDTO.setRegisteredDate(Date.valueOf(request.getParameter("date")));
    //    volunteerBoardDTO.setFileUpload(request.getParameter("file"));

    try {
      volunteerBoardDao.insert(volunteerBoardDTO);

      //      for (VolunteerBoardAttachedFile volunteerAttachedFile : volunteerBoardDTO.getFileUpload()) {
      //        volunteerBoardDao.insertFile(volunteerBoardDTO.getNo(), volunteerAttachedFile.getFilepath());
      //      }
      sqlSession.commit();
      response.setHeader("Refresh", "1;url=boardList");
      request.getRequestDispatcher("VolunteerBoardAdd.jsp").forward(request, response);

    } catch (Exception e) {
      // 오류를 출력할 때 사용할 수 있도록 예외 객체를 저장소에 보관한다.
      sqlSession.rollback();
      e.printStackTrace();
      request.setAttribute("error", e);

      // 오류가 발생하면, 오류 내용을 출력할 뷰를 호출한다.
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/Error.jsp");
      요청배달자.forward(request, response);
    }
  }
}


