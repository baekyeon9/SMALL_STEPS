package com.share.ftp.handler.personal.community;

import java.util.Collection;
import com.share.ftp.dao.VolunteerShortReviewDao;
import com.share.ftp.domain.community.VolunteerShortReviewDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;
import com.share.util.Prompt;

public class VolunteerShortReviewSearchHandler implements Command {

  VolunteerShortReviewDao volunteerShortReviewDao;

  public VolunteerShortReviewSearchHandler(VolunteerShortReviewDao volunteerShortReviewDao) {
    this.volunteerShortReviewDao =  volunteerShortReviewDao;
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println("[ 게시글 검색 ]");

    String input = Prompt.inputString("[  검색어를 입력하세요.  ]");

    Collection<VolunteerShortReviewDTO> volunteerShortReviewDTOList = volunteerShortReviewDao.findByKeyword(input);

    for(VolunteerShortReviewDTO volunteerShortReviewDTO : volunteerShortReviewDTOList) {

      System.out.println();
      System.out.printf("작성자 ▶ %s\n", volunteerShortReviewDTO.getOwner().getId());
      System.out.printf("내용 ▶ %s\n", volunteerShortReviewDTO.getContent());
      System.out.printf("작성일 ▶ %s\n", volunteerShortReviewDTO.getRegisteredDate());
      System.out.println();
    }
  }
}











