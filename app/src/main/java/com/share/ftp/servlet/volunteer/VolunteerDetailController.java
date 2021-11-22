package com.share.ftp.servlet.volunteer;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.share.ftp.dao.VolunteerDao;
import com.share.ftp.domain.volunteer.VolunteerRequestDTO;

@WebServlet("/volunteer/detail")
public class VolunteerDetailController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  VolunteerDao volunteerDao;
  //  GeneralDao generalDao;

  @Override
  public void init(ServletConfig config) throws ServletException {
    ServletContext 웹애플리케이션공용저장소 = config.getServletContext();
    volunteerDao = (VolunteerDao) 웹애플리케이션공용저장소.getAttribute("volunteerDao");
    //    generalDao = (GeneralDao) 웹애플리케이션공용저장소.getAttribute("generalDao");
  }

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {

      int volNo = Integer.parseInt(request.getParameter("no"));

      VolunteerRequestDTO volunteer = volunteerDao.findByApprovedVolunteerNo(volNo);
      //      List<Category> category = generalDao.findAllCategory();
      String totalDate = volunteerDao.totalDate(volNo).getTotalDate();
      String remainDate = volunteerDao.remainDate(volNo).getRemainDate();

      Map<String,Object> volunteerDate = new HashMap<>();
      volunteerDate.put("totalDate", totalDate);
      volunteerDate.put("remainDate", remainDate);


      // 첨부파일을 위한 리스트
      List<VolunteerRequestDTO> volunteerList = volunteerDao.findAll();

      if (volunteer == null) {
        throw new Exception("해당 번호의 봉사가 없습니다.");
      }

      // 뷰 컴포넌트가 준비한 데이터를 사용할 수 있도록 저장소에 보관한다.
      request.setAttribute("volunteer", volunteer); 
      //      request.setAttribute("category", category); 
      request.setAttribute("volunteerList", volunteerList);
      request.setAttribute("volunteerDate", volunteerDate);
      request.getRequestDispatcher("VolunteerDetail.jsp").forward(request, response);

    } catch (Exception e) {
      e.printStackTrace();

      request.setAttribute("error", e);
      request.getRequestDispatcher("/Error.jsp").forward(request, response);
    }
  }









  //
  //  @Override
  //  public void execute(CommandRequest request) throws Exception {
  //    System.out.println();
  //    System.out.println("[ 봉사 상세보기 ]");
  //
  //    int volNo = (int) request.getAttribute("no");
  //
  //    VolunteerRequestDTO volunteerRequestDTO = volunteerDao.findByApprovedVolunteerNo(volNo);
  //
  //    if (volunteerRequestDTO == null) {
  //      System.out.println("해당 번호의 봉사가 없습니다.");
  //      return;
  //    }
  //
  //    request.setAttribute("volNo", volNo); 
  //
  //
  //    System.out.println();
  //    System.out.printf("봉사번호: %d\n"
  //        + "봉사제목: %s\n"
  //        + "주최자: %s\n"
  //        + "봉사분류: %s\n"
  //        + "전화번호: %s\n"
  //        + "이메일: %s\n"
  //        + "봉사시작기간: %s\n"
  //        + "봉사종료기간: %s\n"
  //        + "봉사시작시간: %s\n"
  //        + "봉사종료시간: %s\n"
  //        + "총 봉사기간: %s일\n"
  //        + "남은봉사기간: %s일\n"
  //        + "봉사인원: %d명 / %d명\n"
  //        + "봉사내용: %s\n\n",
  //
  //        volunteerRequestDTO.getNo(),      
  //        volunteerRequestDTO.getTitle(),     
  //        volunteerRequestDTO.getOwner().getId(), 
  //        volunteerRequestDTO.getCategory().getTitle(), 
  //        volunteerRequestDTO.getTel(),
  //        volunteerRequestDTO.getEmail(),
  //        volunteerRequestDTO.getStartDate(),
  //        volunteerRequestDTO.getEndDate(),
  //        volunteerRequestDTO.getStartTime(),
  //        volunteerRequestDTO.getEndTime(),
  //        volunteerDao.totalDate(volNo).getTotalDate(),
  //        volunteerDao.remainDate(volNo).getRemainDate(),
  //        //        GeneralHelper.getRemainTime(volunteerRequestDTO.getEndDate().getTime() - System.currentTimeMillis()),
  //        volunteerRequestDTO.getCurrentNum(),
  //        volunteerRequestDTO.getLimitNum(),
  //        volunteerRequestDTO.getContent()
  //        );
  //
  //    while (true) {
  //      System.out.println();
  //      System.out.println("1번 ▶ 참여하기(개인)");
  //      System.out.println("2번 ▶ 참여하기(단체)");
  //      System.out.println("3번 ▶ 참여자 목록");
  //      System.out.println("4번 ▶ 문의하기");
  //      System.out.println("5번 ▶ 찜하기🎈");
  //      System.out.println("0번 ▶ 이전");
  //      int input = Prompt.inputInt("번호 입력 ▶ ");
  //      switch (input) {
  //        case 1: request.getRequestDispatcher("/volJoin/add").forward(request); return;
  //        case 2: request.getRequestDispatcher("/volJoin/groupAdd").forward(request); return;
  //        case 3: request.getRequestDispatcher("/volJoin/list").forward(request); return;
  //        case 4: request.getRequestDispatcher("/volQuestion/list").forward(request); return;
  //        case 5: request.getRequestDispatcher("/vol/wish").forward(request); return;
  //        case 0: return;
  //        default:
  //          System.out.println("명령어가 올바르지 않습니다!");
  //      }
  //    }
  //}





}
