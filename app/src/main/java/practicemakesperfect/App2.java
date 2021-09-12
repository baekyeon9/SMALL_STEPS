package com.share.ftp;

// create메뉴 내파트
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.share.ftp.AppTest.MenuItem;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.domain.admin.QuestionDTO;
import com.share.ftp.domain.guest.JoinDTO;
import com.share.ftp.domain.personal.ApproveOrgDTO;
import com.share.ftp.domain.personal.CommBoardDTO;
import com.share.ftp.domain.personal.CommReviewDTO;
import com.share.ftp.domain.personal.DonationBoardDTO;
import com.share.ftp.domain.personal.DonationRegisterDTO;
import com.share.ftp.domain.personal.MyChallengeQuestionDTO;
import com.share.ftp.domain.personal.MyChallengeReviewDTO;
import com.share.ftp.domain.personal.MyProfileDTO;
import com.share.ftp.domain.personal.MyQuestionListDTO;
import com.share.ftp.domain.personal.OrgRequestDTO;
import com.share.ftp.domain.personal.PersonalRequestApplyDTO;
import com.share.ftp.domain.personal.PersonalRequestDTO;
import com.share.ftp.domain.personal.PersonalRequestRejectDTO;
import com.share.ftp.domain.personal.VolListDTO;
import com.share.ftp.handler.Command;
import com.share.ftp.handler.admin.AdminChallengeDeleteHandler;
import com.share.ftp.handler.admin.AdminChallengeDetailHandler;
import com.share.ftp.handler.admin.AdminChallengeListHandler;
import com.share.ftp.handler.admin.AdminChallengeUpdateHandler;
import com.share.ftp.handler.admin.AdminMemberDeleteHandler;
import com.share.ftp.handler.admin.AdminMemberListHandler;
import com.share.ftp.handler.admin.AdminNoticeAddHandler;
import com.share.ftp.handler.admin.AdminNoticeDeleteHandler;
import com.share.ftp.handler.admin.AdminNoticeDetailHandler;
import com.share.ftp.handler.admin.AdminNoticeListHandler;
import com.share.ftp.handler.admin.AdminNoticeUpdateHandler;
import com.share.ftp.handler.admin.AdminQuestionAddHandler;
import com.share.ftp.handler.admin.AdminQuestionDeleteHandler;
import com.share.ftp.handler.admin.AdminQuestionDetailHandler;
import com.share.ftp.handler.admin.AdminQuestionHandler;
import com.share.ftp.handler.admin.AdminQuestionListHandler;
import com.share.ftp.handler.admin.AdminQuestionUpdateHandler;
import com.share.ftp.handler.join.AuthChangeUserInfoHandler;
import com.share.ftp.handler.join.AuthDisplayUserInfoHandler;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.ftp.handler.join.AuthLogoutHandler;
import com.share.ftp.handler.join.JoinAddHandler;
import com.share.ftp.handler.join.JoinDetailHandler;
import com.share.ftp.handler.join.JoinListHandler;
import com.share.ftp.handler.join.JoinSearchIdHandler;
import com.share.ftp.handler.join.JoinSearchPasswordHandler;
import com.share.ftp.handler.join.MyPageDelete;
import com.share.ftp.handler.join.MyPageInfoHandler;
import com.share.ftp.handler.personal.challenge.ChallengeBoardHandler;
import com.share.ftp.handler.personal.challenge.ChallengeListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionAddHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionDeleteHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionDetailHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionSearchHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionUpdateHandler;
//import com.share.ftp.handler.personal.challenge.ChallengeReviewAddHandler;
//import com.share.ftp.handler.personal.challenge.ChallengeReviewDeleteHandler;
//import com.share.ftp.handler.personal.challenge.ChallengeReviewDetailHandler;
//import com.share.ftp.handler.personal.challenge.ChallengeReviewListHandler;
//import com.share.ftp.handler.personal.challenge.ChallengeReviewSearchHandler;
//import com.share.ftp.handler.personal.challenge.ChallengeReviewUpdateHandler;
import com.share.ftp.handler.personal.challenge.RankingHandler;
import com.share.ftp.handler.personal.community.CommBoardAddHandler;
import com.share.ftp.handler.personal.community.CommBoardDeleteHandler;
import com.share.ftp.handler.personal.community.CommBoardDetailHandler;
import com.share.ftp.handler.personal.community.CommBoardListHandler;
import com.share.ftp.handler.personal.community.CommBoardUpdateHandler;
import com.share.ftp.handler.personal.community.CommReviewAddHandler;
import com.share.ftp.handler.personal.community.CommReviewDeleteHandler;
import com.share.ftp.handler.personal.community.CommReviewListHandler;
import com.share.ftp.handler.personal.community.CommReviewUpdateHandler;
import com.share.ftp.handler.personal.donation.DonationBoardHandler;
import com.share.ftp.handler.personal.donation.DonationRegisterHandler;
import com.share.ftp.handler.personal.mypage.MyBoardListHandler;
import com.share.ftp.handler.personal.mypage.MyDonationHandler;
import com.share.ftp.handler.personal.mypage.MyPointHandler;
import com.share.ftp.handler.personal.mypage.MyProfileHandler;
import com.share.ftp.handler.personal.mypage.WithdrawMemberHandler;
import com.share.ftp.handler.personal.support.NoticeListHandler;
import com.share.ftp.handler.personal.support.QuestionAddHandler;
import com.share.ftp.handler.personal.support.QuestionDeleteHandler;
import com.share.ftp.handler.personal.support.QuestionDetailHandler;
import com.share.ftp.handler.personal.support.QuestionListHandler;
import com.share.ftp.handler.personal.support.QuestionUpdateHandler;
import com.share.ftp.handler.personal.volunteer.ApproveOrgHandler;
import com.share.ftp.handler.personal.volunteer.OrgVolRequestHandler;
import com.share.ftp.handler.personal.volunteer.PersonalVolRequestHandler;
import com.share.ftp.handler.personal.volunteer.VolApprovedHandler;
import com.share.ftp.handler.personal.volunteer.VolListHandler;
import com.share.menu.Menu;
import com.share.menu.MenuGroup;
import com.share.util.Prompt;

public class App2 {

  MenuGroup personalCommunityMenu = new MenuGroup("소통해요");
  mainMenuGroup.add(personalCommunityMenu);

  personalCommunityMenu.add(createReviewMenu());
  personalCommunityMenu.add(createBestReviewMenu());
  personalCommunityMenu.add(createShortReviewMenu());

  return mainMenuGroup;
}

private Menu createReviewMenu() {
  MenuGroup reviewMenu = new MenuGroup("나눔 이야기");

  reviewMenu.add(new MenuItem("등록", Menu.ENABLE_MEMBER, "/commBoard/add"));
  reviewMenu.add(new MenuItem("목록","/commBoard/list"));
  reviewMenu.add(new MenuItem("상세보기","/commBoard/detail"));
  reviewMenu.add(new MenuItem("변경", Menu.ENABLE_MEMBER,"/commBoard/update"));
  reviewMenu.add(new MenuItem("삭제",Menu.ENABLE_MEMBER,"/commBoard/delete"));

  return reviewMenu;
}

private Menu createBestReviewMenu() {
  MenuGroup bestReviewMenu = new MenuGroup("나눔 이야기 BEST");

  bestReviewMenu.add(new MenuItem("목록",Menu.ENABLE_ALL, "/commBest/list"));
  bestReviewMenu.add(new MenuItem("상세보기",Menu.ENABLE_ALL,"/commBest/detail"));

  return bestReviewMenu;
}

private Menu createShortReviewMenu() {
  MenuGroup shortReviewMenu = new MenuGroup("한 줄 후기");

  shortReviewMenu.add(new MenuItem("등록", Menu.ENABLE_MEMBER, "/commReview/add"));
  shortReviewMenu.add(new MenuItem("목록", Menu.ENABLE_ALL, "/commReview/list")); 
  shortReviewMenu.add(new MenuItem("변경", Menu.ENABLE_MEMBER, "/commReview/update")); 
  shortReviewMenu.add(new MenuItem("삭제", Menu.ENABLE_MEMBER, "/commReview/delete")); 

  return shortReviewMenu;
}


}


