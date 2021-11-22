package com.share.ftp.servlet.volunteer;

//import com.share.ftp.handler.Command;
//
//public class VolunteerBoardSearchController implements Command {

//  VolunteerBoardDao volunteerBoardDao;
//
//  public VolunteerBoardSearchController(VolunteerBoardDao volunteerBoardDao) {
//    this.volunteerBoardDao =  volunteerBoardDao;
//  }
//
//  @Override
//  public void execute(CommandRequest request) throws Exception {
//    System.out.println("[ 게시글 검색 ]");
//
//    String input = Prompt.inputString("검색어?  ");
//
//    Collection<VolunteerBoardDTO> volunteerBoardDTOList = volunteerBoardDao.findByKeyword(input);
//
//    for(VolunteerBoardDTO volunteerBoardDTO : volunteerBoardDTOList) {
//      if(!volunteerBoardDTO.getTitle().contains(input) &&
//          !volunteerBoardDTO.getContent().contains(input) &&
//          !volunteerBoardDTO.getOwner().getId().contains(input)) {
//        continue;
//      }
//
//      System.out.printf("작성자 ▶ %s\n", volunteerBoardDTO.getOwner().getId());
//      System.out.printf("제목 ▶ %s\n", volunteerBoardDTO.getTitle());
//      System.out.printf("내용 ▶ %s\n", volunteerBoardDTO.getContent());
//      System.out.printf("작성일 ▶ %s\n", volunteerBoardDTO.getRegisteredDate());
//      System.out.printf("조회수 ▶ %d\n", volunteerBoardDTO.getViewCount());
//
//      System.out.println();
//    }
//  }
//}
