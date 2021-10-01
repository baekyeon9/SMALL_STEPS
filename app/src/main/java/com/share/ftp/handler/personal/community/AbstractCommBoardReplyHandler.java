package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.domain.personal.CommBoardReplyDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractCommBoardReplyHandler implements Command {

  protected List<CommBoardDTO> commBoardDTOList;
  protected List<CommBoardReplyDTO> commBoardReplyDTOList;

  public AbstractCommBoardReplyHandler(
      List<CommBoardDTO> commBoardDTOList, 
      List<CommBoardReplyDTO> commBoardReplyDTOList) {
    this.commBoardDTOList = commBoardDTOList;
    this.commBoardReplyDTOList = commBoardReplyDTOList;
  }

  protected CommBoardReplyDTO findByReplyNo(int no, CommBoardDTO commBoardNo) {
    for (CommBoardReplyDTO commBoardReplyDTO : commBoardReplyDTOList) {
      if (commBoardNo.getCommNo() == commBoardReplyDTO.getCommNo()) {
        if (commBoardReplyDTO.getCommReplyNo() == no) {
          return commBoardReplyDTO;
        }
      }
    }
    return null;
  }

  protected CommBoardReplyDTO findByReplyNo(int no) {
    for(CommBoardReplyDTO commBoardReplyDTO : commBoardReplyDTOList) {
      if (commBoardReplyDTO.getCommReplyNo() == no) {
        return commBoardReplyDTO;
      }
    }
    return null;
  }

  protected CommBoardDTO findByCommBoardNo(int no) {
    for(CommBoardDTO commBoardDTO : commBoardDTOList) {
      if (commBoardDTO.getCommNo() == no) {
        return commBoardDTO;
      }
    }
    return null;
  }
  protected int getNextNum() {
    if (commBoardReplyDTOList.size() > 0) {
      return commBoardReplyDTOList.get(commBoardReplyDTOList.size() - 1).getCommReplyNo() + 1;
    } else {
      return 1;
    }
  }

  protected int getNextReplyNum(CommBoardDTO commBoardDTO) {
    if (commBoardReplyDTOList.size() > 0) {
      return commBoardDTO.getReplyCount() + 1;
    } else {
      return 1;
    }
  }
}
