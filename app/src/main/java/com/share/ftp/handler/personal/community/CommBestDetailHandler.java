package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommBestComparator;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.handler.CommandRequest;

public class CommBestDetailHandler extends AbstractCommBestHandler {

  public CommBestDetailHandler(List<CommBoardDTO> commBoardDTOList) {
    super(commBoardDTOList);
  }

  @Override
  public void execute(CommandRequest request) throws Exception {
    System.out.println();
    System.out.println("[  소통해요/나눔이야기Best/상세보기  ]");

    CommBestComparator commBestComparator = new CommBestComparator();




    //    //  전체 목록중에서 조회수가 가장 높은 3개
    //    CommBoardDTO[] arr = commBoardHandler.chooseBoard();
    //
    //    System.out.printf("%d, %s, %s, %s, %s, %d\n", 
    //        arr[0].getNo(), 
    //        arr[0].getTitle(), 
    //        arr[0].getContent(),
    //        arr[0].getFileUpload(),
    //        //this.commBoardsDTO[i].getPassword(),
    //        arr[0].getRegisteredDate(), 
    //        arr[0].getViewCount());
  }
}
