package nov16;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.ibatis.session.SqlSession;
import com.share.ftp.dao.VolunteerBoardDao;
import com.share.ftp.domain.community.VolunteerBoardDTO;
import com.share.ftp.domain.join.JoinDTO;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/volunteer/boardAdd")
public class VolunteerBoardAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  SqlSession sqlSession;
  VolunteerBoardDao volunteerBoardDao;

  @Override
  public void init() {
    ServletContext 웹애플리케이션공용저장소 = getServletContext();
    sqlSession = (SqlSession) 웹애플리케이션공용저장소.getAttribute("sqlSession");
    volunteerBoardDao = (VolunteerBoardDao) 웹애플리케이션공용저장소.getAttribute("volunteerBoardDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {

      VolunteerBoardDTO volunteerBoardDTO = new VolunteerBoardDTO();

      JoinDTO owner = new JoinDTO();
      owner.setNo(Integer.parseInt(request.getParameter("owner")));

      volunteerBoardDTO.setOwner(owner);
      volunteerBoardDTO.setTitle(request.getParameter("title"));
      volunteerBoardDTO.setContent(request.getParameter("content"));
      //    volunteerBoardDTO.setFileUpload(request.getParameter("file"));

      Part photoPart = request.getPart("photo");
      if (photoPart.getSize() > 0) {
        String filename = UUID.randomUUID().toString();
        photoPart.write(getServletContext().getRealPath("/upload/volunteer") + "/" + filename);
        // volunteerBoardDTO.setPhoto(filename);

        Thumbnails.of(getServletContext().getRealPath("/upload/volunteer") + "/" + filename)
        .size(20, 20)
        .outputFormat("jpg")
        .crop(Positions.CENTER)
        .toFiles(new Rename() {
          @Override
          public String apply(String name, ThumbnailParameter param) {
            return name + "_20x20";
          }
        });

        Thumbnails.of(getServletContext().getRealPath("/upload/volunteer") + "/" + filename)
        .size(100, 100)
        .outputFormat("jpg")
        .crop(Positions.CENTER)
        .toFiles(new Rename() {
          @Override
          public String apply(String name, ThumbnailParameter param) {
            return name + "_100x100";
          }
        });
      }


      volunteerBoardDao.insert(volunteerBoardDTO);
      sqlSession.commit();

      //      for (VolunteerBoardAttachedFile volunteerAttachedFile : volunteerBoardDTO.getFileUpload()) {
      //        volunteerBoardDao.insertFile(volunteerBoardDTO.getNo(), volunteerAttachedFile.getFilepath());
      //      }
      response.setHeader("Refresh", "1;url=boardList");
      //request.setAttribute("pageTitle", "게시글목록");
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


