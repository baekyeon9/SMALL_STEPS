package com.share.ftp.handler.personal.community;

import com.share.ftp.dao.CommunityDao;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.CommandRequest;

public class CommBestListHandler implements Command {

  CommunityDao communityDao;

  public CommBestListHandler(CommunityDao communityDao) {
    this.communityDao =  communityDao;

  }

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println();
    System.out.println("[  나눔이야기 BEST 목록  ]");

    // Prompt.printBestRank(commBoardDTOList);

  }
}




//    BestTest.getUserPointList(commBoardDTOList);
//    int add = 1;
//    ArrayList<Integer> rank = new ArrayList<>();
//    rank.add(add);
//    rank.add(add);
//    rank.add(add);
//
//    int maxNo = commBoardDTOList.get(0).getCommNo();
//    int max = commBoardDTOList.get(0).getViewCount();
//    CommBoardDTO commBoardDTO = commBoardDTOList.get(0);
//
//    for (int i = 0; i < commBoardDTOList.size(); i++) {
//      //      rank.set(i,1);
//      for (int j = 0; j < commBoardDTOList.size(); j++) {
//
//        if (commBoardDTOList.get(i).getViewCount() < commBoardDTOList.get(j).getViewCount()) {  
//          rank.set(i,add++);
//          max = commBoardDTOList.get(i).getViewCount();
//          //         max = commBoardDTOList.get(i).getViewCount();
//          //         maxNo = commBoardDTOList.get(i).getCommNo();
//          //         commBoardDTO = commBoardDTOList.get(i);
//        }
//        System.out.println("등수" + rank.get(i));
//        System.out.println("가장 높은 조회수는? : " + max);
//      }
//
//
//    }
//
//    for (int i = 0; i < commBoardDTOList.size(); i++) {
//      System.out.println("등수" + rank.get(i));
//    }
//





//
//    int max =  commBoardDTOList.get(0).getViewCount();
//
//    for (int i = 0; i < commBoardDTOList.size(); i++) {
//      if (max < commBoardDTOList.get(i).getViewCount()) {
//        max = commBoardDTOList.get(i).getViewCount();
//      }
//    }
//    System.out.println("최대 조회수는? = " + max);

//  System.out.println("[소통해요/나눔이야기Best/목록]");


//  List<CommBoardDTO> commBoardDTOList;

//    
//    for (CommBoardDTO commBoardDTO : commBoardDTOList) {
//      System.out.printf("%d번 게시글 조회수 : %d\n", commBoardDTO.getCommNo(), commBoardDTO.getViewCount());
//      // 조회수가 높은 것부터 순서대로 출력(내림차순 정렬)
//      // 1. 조회수가 가장 높은 것을 뽑는다.;
//      
//    }
//   1   6     10










//        Comparator<CommBoardDTO> comparator = Comparator.comparing(CommBoardDTO::getViewCount);
//        //CommBoardDTO minObject = commBoardDTOList.stream().min(comparator).get();
//        CommBoardDTO maxObject = commBoardDTOList.stream().max(comparator).get();
//        System.out.println("가장높은조회수 " + maxObject);
//     System.out.println("Min Object " + minObject);



//  Collections.sort(commBoardDTOList);
//
//
//
//    for(CommBoardDTO commBoardDTO : commBoardDTOList) {
//
//
//      System.out.printf("%d, %s, %s, %s, %s, %s, %d\n", 
//          // AuthLoginHandler.loginUser.getId(),
//          commBoardDTO.getNo(), 
//          commBoardDTO.getOwner().getId(),
//          commBoardDTO.getTitle(), 
//          commBoardDTO.getContent(),
//          commBoardDTO.getFileUpload(),
//          //commBoardDTO.getPassword(),
//          commBoardDTO.getRegisteredDate(), 
//          commBoardDTO.getViewCount());
//
//        @Override
//        public int compareTo(CommBoardDTO o) {
//      
//          return commBoardDTO.getViewCount()-o.getViewCount;
//        }
