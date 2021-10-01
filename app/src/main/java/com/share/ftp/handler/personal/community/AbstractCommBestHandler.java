package com.share.ftp.handler.personal.community;

import java.util.List;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.handler.Command;

public abstract class AbstractCommBestHandler implements Command {

  protected List<CommBoardDTO> commBoardDTOList;

  public AbstractCommBestHandler(List<CommBoardDTO> commBoardDTOList) {
    this.commBoardDTOList = commBoardDTOList;




  }
}










