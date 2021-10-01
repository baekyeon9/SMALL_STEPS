package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.domain.personal.CommBoardReplyDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractCommBoardHandler implements Command {

  protected List<CommBoardDTO> commBoardDTOList;
  protected List<CommBoardReplyDTO> commBoardReplyDTOList;

  public AbstractCommBoardHandler(
      List<CommBoardDTO> commBoardDTOList, 
      List<CommBoardReplyDTO> commBoardReplyDTOList) {
    this.commBoardDTOList = commBoardDTOList;
    this.commBoardReplyDTOList = commBoardReplyDTOList;
  }

  protected CommBoardDTO findByNo(int no) {
    for(CommBoardDTO commBoardDTO : commBoardDTOList) {
      if (commBoardDTO.getCommNo() == no) {
        return commBoardDTO;
      }
    }
    return null;
  }

  protected int getNextNum() {
    if (commBoardDTOList.size() > 0) {
      return commBoardDTOList.get(commBoardDTOList.size() - 1).getCommNo() + 1;
    } else {
      return 1;
    }
  }
}
