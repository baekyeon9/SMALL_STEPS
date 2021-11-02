package com.share.ftp;

import java.util.Comparator;

public class CommBestComparator implements Comparator<VolBoardDTO> {

  @Override
  public int compare(VolBoardDTO firstCommBoard, VolBoardDTO secondCommBoard) {
    int first = firstCommBoard.getLike();
    int second = secondCommBoard.getLike();

    if (first > second) {
      return -1;

    } else if (first < second) {
      return 1;

    } else {
      return 0;
    }
  }



}
