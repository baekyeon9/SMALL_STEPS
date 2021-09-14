package com.share.ftp;


import java.awt.Menu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import com.share.ftp.domain.personal.PersonalRequestDTO;
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
import com.share.ftp.handler.admin.AdminQuestionListHandler;
import com.share.ftp.handler.admin.AdminQuestionUpdateHandler;
import com.share.ftp.handler.join.AuthChangeUserInfoHandler;
import com.share.ftp.handler.join.AuthDisplayUserInfoHandler;
import com.share.ftp.handler.join.AuthLoginHandler;
import com.share.ftp.handler.join.AuthLogoutHandler;
import com.share.ftp.handler.join.JoinAddHandler;
import com.share.ftp.handler.join.JoinDetailHandler;
import com.share.ftp.handler.join.JoinListHandler;
import com.share.ftp.handler.join.JoinSearchEmailIdHandler;
import com.share.ftp.handler.join.JoinSearchPasswordHandler;
import com.share.ftp.handler.join.JoinSearchTelIdHandler;
import com.share.ftp.handler.join.MyPageDelete;
import com.share.ftp.handler.join.MyPageInfoHandler;
import com.share.ftp.handler.org.MyVolApplyListHandler;
import com.share.ftp.handler.org.MyVolApproveListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeJoinHandler;
import com.share.ftp.handler.personal.challenge.ChallengeJoinListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionAddHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionDeleteHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionDetailHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionSearchHandler;
import com.share.ftp.handler.personal.challenge.ChallengeQuestionUpdateHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewAddHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewDeleteHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewDetailHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewListHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewSearchHandler;
import com.share.ftp.handler.personal.challenge.ChallengeReviewUpdateHandler;
import com.share.ftp.handler.personal.challenge.MyRankingHandler;
import com.share.ftp.handler.personal.challenge.RankingHandler;
import com.share.ftp.handler.personal.challenge.ShowChallengeDetailHandler;
import com.share.ftp.handler.personal.community.CommBestDetailHandler;
import com.share.ftp.handler.personal.community.CommBestListHandler;
import com.share.ftp.handler.personal.community.CommBoardAddHandler;
import com.share.ftp.handler.personal.community.CommBoardDeleteHandler;
import com.share.ftp.handler.personal.community.CommBoardDetailHandler;
import com.share.ftp.handler.personal.community.CommBoardListHandler;
import com.share.ftp.handler.personal.community.CommBoardUpdateHandler;
import com.share.ftp.handler.personal.community.CommReviewAddHandler;
import com.share.ftp.handler.personal.community.CommReviewDeleteHandler;
import com.share.ftp.handler.personal.community.CommReviewListHandler;
import com.share.ftp.handler.personal.community.CommReviewUpdateHandler;
import com.share.ftp.handler.personal.donation.DonationBoardAcceptApplyHandler;
import com.share.ftp.handler.personal.donation.DonationBoardAppliedListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyCompleteListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyDetailHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyHandler;
import com.share.ftp.handler.personal.donation.DonationBoardApplyListHandler;
import com.share.ftp.handler.personal.donation.DonationBoardRejectApplyHandler;
import com.share.ftp.handler.personal.donation.DonationRegisterAddHandler;
import com.share.ftp.handler.personal.donation.DonationRegisterParticipationHandler;
import com.share.ftp.handler.personal.donation.DonationRegisterTotalMoneyHandler;
import com.share.ftp.handler.personal.mypage.MyBoardDeleteHandler;
import com.share.ftp.handler.personal.mypage.MyBoardDetailHandler;
import com.share.ftp.handler.personal.mypage.MyBoardListHandler;
import com.share.ftp.handler.personal.mypage.MyBoardUpdateHandler;
import com.share.ftp.handler.personal.mypage.MyDonationHandler;
import com.share.ftp.handler.personal.mypage.MyPointHandler;
import com.share.ftp.handler.personal.support.NoitceListHandler;
import com.share.ftp.handler.personal.support.NoticeAddHandler;
import com.share.ftp.handler.personal.support.NoticeDeleteHandler;
import com.share.ftp.handler.personal.support.NoticeDetailHandler;
import com.share.ftp.handler.personal.support.NoticeUpdateHandler;
import com.share.ftp.handler.personal.support.QuestionAddHandler;
import practicemakesperfect.util.Prompt;

public class App100 {

  // 회원가입 도메인(값)
  List<JoinDTO> joinDTOList = new ArrayList<>();

  // 함께해요 도메인(값)
  List<VolListDTO> volListDTOList = new ArrayList<>();

  // 개인 봉사신청 관련 도메인
  List<PersonalRequestDTO> personalRequestDTOList = new ArrayList<>();
  List<PersonalRequestDTO> personalRequestApplyDTOList = new ArrayList<>();
  List<PersonalRequestDTO> personalRequestRejectDTOList = new ArrayList<>();

  // 기관 봉사신청 관련 도메인
  List<OrgRequestDTO> orgRequestDTOList = new ArrayList<>();
  List<OrgRequestDTO> orgRequestDTOApplyList = new ArrayList<>();
  List<OrgRequestDTO> orgRequestDTORejectList = new ArrayList<>();

  // 소통해요 도메인(값)
  List<CommBoardDTO> commBoardDTOList = new ArrayList<>();
  List<CommReviewDTO> commReviewDTOList = new ArrayList<>();

  // 챌린지 도메인(값)
  List<MyChallengeQuestionDTO> myChallengeQuestionDTOList = new ArrayList<>();
  List<MyChallengeReviewDTO> myChallengeReviewDTOList = new ArrayList<>();

  // 모금함 개설 신청 관련 도메인(값)
  List<DonationBoardDTO> donationBoardDTOList = new ArrayList<>();
  List<DonationBoardDTO> donationBoardApplyDTOList = new ArrayList<>();
  List<DonationBoardDTO> donationBoardRejectDTOList = new ArrayList<>();

  // 기부 도메인(값)
  List<DonationRegisterDTO> donationRegisterDTOList = new ArrayList<>();

  // 마이페이지 도메인(값)
  List<MyProfileDTO> myProfileDTOList = new ArrayList<>();
  List<MyQuestionListDTO> myQuestionListDTOList = new ArrayList<>();

  // 관리자 도메인(값)
  List<ChallengeDTO> challengeDTOList = new ArrayList<>();
  List<NoticeDTO> noticeDTOList = new ArrayList<>();
  List<QuestionDTO> questionDTOList = new ArrayList<>();
  List<ApproveOrgDTO> approveOrgDTOList = new ArrayList<>();

  // 메뉴 객체 컨트롤(Map)
  HashMap<String,Command> commands = new HashMap<>();

  class MenuItem extends Menu {

    String menuId;

    public MenuItem(String title, String menuId) {
      this(title, Menu.ENABLE_ALL, menuId);
      this.menuId = menuId;
    }

    public MenuItem(String title, int enableState, String menuId) {
      super(title, enableState);
      this.menuId = menuId;
    }
    @Override
    public void execute() {
      Command command = commands.get(menuId);
      command.execute();
    }
  }


  public static void main(String[] args) {

    App100 app = new App100(); 
    app.service();
  }

  public App100() {
    //로그인, 로그아웃
    commands.put("/auth/login", new AuthLoginHandler(joinDTOList)); // 로그인
    commands.put("/auth/logout", new AuthLogoutHandler()); // 로그아웃
    commands.put("/auth/changeUserInfo", new AuthChangeUserInfoHandler()); // 마이페이지 나의정보
    commands.put("/auth/displayUserInfo", new AuthDisplayUserInfoHandler()); // 마이페이지 나의정보수정

    //회원가입
    commands.put("/join/add", new JoinAddHandler(joinDTOList)); // 회원가입
    commands.put("/join/searchTelId", new JoinSearchTelIdHandler(joinDTOList)); // 폰번호로 아이디 찾기
    commands.put("/join/searchEmailId", new JoinSearchEmailIdHandler(joinDTOList)); // 이메일로 아이디 찾기
    commands.put("/join/searchPassword", new JoinSearchPasswordHandler(joinDTOList)); // 비밀번호 찾기

    //함께해요 (개인) + 마이페이지
    commands.put("/volRequestPersonal/apply", new VolRequestPersonalApplyHandler(personalRequestDTOList));
    commands.put("/volRequestPersonal/applyList", new VolRequestPersonalApplyListHandler(personalRequestDTOList));
    commands.put("/volRequestPersonal/applyCompleteList", new VolRequestPersonalApplyCompleteListHandler(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList));
    commands.put("/volRequestPersonal/acceptApply", new VolRequestPersonalAcceptApplyHandler(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList));
    commands.put("/volRequestPersonal/rejectApply", new VolRequestPersonalRejectApplyHandler(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList));
    commands.put("/volRequestPersonal/appliedList", new VolRequestPersonalAppliedListHandler(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList));
    commands.put("/volRequestPersonal/rejectedList", new VolRequestPersonalRejectedListHandler(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList));
    commands.put("/volRequestPersonal/bookmark", new VolRequestPersonalBookmarkHandler(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList));
    commands.put("/volRequest/totalApprovedList", new VolRequestTotalApprovedListHandler(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList));

    // 소통해요 나눔이야기
    commands.put("/commBoard/add", new CommBoardAddHandler(commBoardDTOList));
    commands.put("/commBoard/list", new CommBoardListHandler(commBoardDTOList));
    commands.put("/commBoard/detail", new CommBoardDetailHandler(commBoardDTOList));
    commands.put("/commBoard/update", new CommBoardUpdateHandler(commBoardDTOList));
    commands.put("/commBoard/delete", new CommBoardDeleteHandler(commBoardDTOList));

    // 소통해요 한줄후기
    commands.put("/commBest/list", new CommBestListHandler(commBoardDTOList));
    commands.put("/commBest/detail", new CommBestDetailHandler(commBoardDTOList));

    commands.put("/commReview/add", new CommReviewAddHandler(commReviewDTOList));
    commands.put("/commReview/list", new CommReviewListHandler(commReviewDTOList));
    commands.put("/commReview/update", new CommReviewUpdateHandler(commReviewDTOList));
    commands.put("/commReview/delete", new CommReviewDeleteHandler(commReviewDTOList));

    // 챌린지
    commands.put("/showChallenge/detail", new ShowChallengeDetailHandler());  // 챌린지 상세정보(구현예정)
    commands.put("/challengeJoin/join", new ChallengeJoinHandler());  // 참여하기(구현예정)
    commands.put("/challengeJoin/list", new ChallengeJoinListHandler());  // 참여자목록(구현예정)

    // 챌린지 참여인증&댓글
    commands.put("/challengeReview/add", new ChallengeReviewAddHandler(myChallengeReviewDTOList));
    commands.put("/challengeReview/list", new ChallengeReviewListHandler(myChallengeReviewDTOList));
    commands.put("/challengeReview/detail", new ChallengeReviewDetailHandler(myChallengeReviewDTOList));
    commands.put("/challengeReview/update", new ChallengeReviewUpdateHandler(myChallengeReviewDTOList));
    commands.put("/challengeReview/delete", new ChallengeReviewDeleteHandler(myChallengeReviewDTOList));
    commands.put("/challengeReview/search", new ChallengeReviewSearchHandler(myChallengeReviewDTOList));

    // 챌린지 문의하기
    commands.put("/challengeQuestion/add", new ChallengeQuestionAddHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/list", new ChallengeQuestionListHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/detail", new ChallengeQuestionDetailHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/update", new ChallengeQuestionUpdateHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/delete", new ChallengeQuestionDeleteHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/search", new ChallengeQuestionSearchHandler(myChallengeQuestionDTOList));

    // 챌린지 랭킹
    commands.put("/ranking/list", new RankingHandler());  //전체랭킹(구현예정)
    commands.put("/myRanking/list", new MyRankingHandler()); //나의랭킹(구현예정)

    // 모금함

    // 모금함 (개설신청하기, 개설목록, 승인, 반려)
    commands.put("/donationBoard/apply", new DonationBoardApplyHandler(donationBoardDTOList));
    commands.put("/donationBoard/applyList", new DonationBoardApplyListHandler(donationBoardDTOList));
    commands.put("/donationBoard/applyCompleteList", new DonationBoardApplyCompleteListHandler(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList));
    commands.put("/donationBoard/appliedList", new DonationBoardAppliedListHandler(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList));
    commands.put("/donationBoard/acceptApply", new DonationBoardAcceptApplyHandler(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList));
    commands.put("/donationBoard/rejectApply", new DonationBoardRejectApplyHandler(donationBoardDTOList, donationBoardApplyDTOList, donationBoardRejectDTOList));
    commands.put("/donationBoard/applyDetail", new DonationBoardApplyDetailHandler(donationBoardDTOList));



    // 모금함 (기부하기)
    commands.put("/donationRegister/add", new DonationRegisterAddHandler(donationRegisterDTOList));
    commands.put("/donationRegister/participation", new DonationRegisterParticipationHandler(donationRegisterDTOList));
    commands.put("/donationRegister/totalMoney", new DonationRegisterTotalMoneyHandler(donationRegisterDTOList));

    // 고객센터 문의하기

    // 고객센터

    commands.put("/notice/add", new NoticeAddHandler(noticeDTOList));
    commands.put("/notice/list", new NoitceListHandler(noticeDTOList));
    commands.put("/notice/detail", new NoticeDetailHandler(noticeDTOList));
    commands.put("/notice/update", new NoticeUpdateHandler(noticeDTOList));
    commands.put("/notice/delete", new NoticeDeleteHandler(noticeDTOList));

    commands.put("/question/add", new QuestionAddHandler(myQuestionListDTOList));
    commands.put("/question/list", new QuestionListHandler(myQuestionListDTOList));
    commands.put("/question/detail", new QuestionDetailHandler(myQuestionListDTOList));
    commands.put("/question/update", new QuestionUpdateHandler(myQuestionListDTOList));
    commands.put("/question/delete", new QuestionDeleteHandler(myQuestionListDTOList));

    // 마이페이지
    commands.put("/MyPage/info", new MyPageInfoHandler(joinDTOList)); // 내정보 수정
    commands.put("/MyPage/delete", new MyPageDelete(joinDTOList)); // 회원탈퇴

    commands.put("/MyBoard/list", new MyBoardListHandler()); // 나의게시글 목록
    commands.put("/MyBoard/detail", new MyBoardDetailHandler()); // 나의게시글 목록
    commands.put("/MyBoard/update", new MyBoardUpdateHandler()); // 나의게시글 목록
    commands.put("/MyBoard/delete", new MyBoardDeleteHandler()); // 나의게시글 목록

    commands.put("MyPoint/list", new MyPointHandler()); // 나의포인트 

    commands.put("/OrgMyVol/apply", new MyVolApplyListHandler()); // 기관 마이페이지 승인신청 
    commands.put("/OrgMyVol/approve", new MyVolApproveListHandler()); // 기관 마이페이지 승인조회
    commands.put("/myDonation/list", new MyDonationHandler()); // 모금함

    // 관리자
    commands.put("/join/list", new JoinListHandler(joinDTOList)); // 관리자가 회원 목록을 조회
    commands.put("/join/detail", new JoinDetailHandler(joinDTOList)); // 가입회원 상세보기 (관리자연결)

    // 관리자 회원정보 조회
    commands.put("/adminMember/list", new AdminMemberListHandler());
    commands.put("/adminMember/delete", new AdminMemberDeleteHandler());

    // 관리자 공지사항
    commands.put("/adminNotice/add", new AdminNoticeAddHandler(noticeDTOList));
    commands.put("/adminNotice/list", new AdminNoticeListHandler(noticeDTOList));
    commands.put("/adminNotice/detail", new AdminNoticeDetailHandler(noticeDTOList));
    commands.put("/adminNotice/update", new AdminNoticeUpdateHandler(noticeDTOList));
    commands.put("/adminNotice/delete", new AdminNoticeDeleteHandler(noticeDTOList));

    // 관리자 문의사항
    commands.put("/adminQuestion/add", new AdminQuestionAddHandler(questionDTOList));
    commands.put("/adminQuestion/list", new AdminQuestionListHandler(questionDTOList));
    commands.put("/adminQuestion/detail", new AdminQuestionDetailHandler(questionDTOList));
    commands.put("/adminQuestion/update", new AdminQuestionUpdateHandler(questionDTOList));
    commands.put("/adminQuestion/delete", new AdminQuestionDeleteHandler(questionDTOList));

    // 관리자 챌린지
    commands.put("/adminChallenge/list", new AdminChallengeListHandler(challengeDTOList));
    commands.put("/adminChallenge/detail", new AdminChallengeDetailHandler(challengeDTOList));
    commands.put("/adminChallenge/update", new AdminChallengeUpdateHandler(challengeDTOList));
    commands.put("/adminChallenge/delete", new AdminChallengeDeleteHandler(challengeDTOList));

    // 챌린지 문의하기
    commands.put("/challengeQuestion/add", new ChallengeQuestionAddHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/list", new ChallengeQuestionListHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/detail", new ChallengeQuestionDetailHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/update", new ChallengeQuestionUpdateHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/delete", new ChallengeQuestionDeleteHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/search", new ChallengeQuestionSearchHandler(myChallengeQuestionDTOList));


    // 관리자
    commands.put("/join/list", new JoinListHandler(joinDTOList)); // 관리자가 회원 목록을 조회
    commands.put("/join/detail", new JoinDetailHandler(joinDTOList)); // 가입회원 상세보기 (관리자연결)

  }

  void service() {
    createMenu().execute();
    Prompt.close();
  }

  Menu createMenu() {

    MenuGroup mainMenuGroup = new MenuGroup("*행복하Share*");
    mainMenuGroup.setPrevMenuTitle("종료");

    mainMenuGroup.add(new MenuItem("로그인", Menu.ENABLE_LOGOUT, "/auth/login"));

    MenuGroup searchId = new MenuGroup("아이디찾기",  Menu.ENABLE_LOGOUT);
    mainMenuGroup.add(searchId);

    searchId.add(new MenuItem("휴대폰번호로아이디찾기", Menu.ENABLE_LOGOUT, "/join/searchTelId"));
    searchId.add(new MenuItem("이메일로아이디찾기", Menu.ENABLE_LOGOUT, "/join/searchEmailId"));

    mainMenuGroup.add(new MenuItem("비밀번호찾기", Menu.ENABLE_LOGOUT, "/join/searchPassword"));
    mainMenuGroup.add(new MenuItem("회원가입", Menu.ENABLE_LOGOUT, "/join/add"));
    mainMenuGroup.add(new MenuItem("로그아웃", Menu.ENABLE_LOGIN, "/auth/logout"));

    /////////////////////////////////////////////////////////////////////////////////////////



    MenuGroup doVolMenu = new MenuGroup("함께해요");
    mainMenuGroup.add(doVolMenu);

    doVolMenu.add(new MenuItem("개인봉사신청양식", Menu.ENABLE_PERSONAL,"/volRequestPersonal/apply"));
    //    doVolMenu.add(new MenuItem("기관봉사신청양식", Menu.ENABLE_ORG)); // 구현예정
    doVolMenu.add(new MenuItem("인증봉사리스트","/volRequestPersonal/appliedList")); // 개인만됨
    doVolMenu.add(new MenuItem("인증봉사세부사항",Menu.ENABLE_MEMBER,"/volRequestPersonal/appliedList"));
    doVolMenu.add(new MenuItem("찜하기",Menu.ENABLE_MEMBER,"/volRequestPersonal/bookmark")); // 구현예정

    ///////////////////////////////////////////////////////////////////////////////////////////




    MenuGroup personalCommunityMenu = new MenuGroup("소통해요");
    mainMenuGroup.add(personalCommunityMenu);

    MenuGroup reviewMenu = new MenuGroup("나눔 이야기");
    personalCommunityMenu.add(reviewMenu);

    reviewMenu.add(new MenuItem("등록", Menu.ENABLE_MEMBER, "/commBoard/add"));
    reviewMenu.add(new MenuItem("목록","/commBoard/list"));
    reviewMenu.add(new MenuItem("상세보기","/commBoard/detail"));
    reviewMenu.add(new MenuItem("변경", Menu.ENABLE_MEMBER,"/commBoard/update"));
    reviewMenu.add(new MenuItem("삭제",Menu.ENABLE_MEMBER,"/commBoard/delete"));

    MenuGroup bestReviewMenu = new MenuGroup("나눔 이야기 BEST");
    personalCommunityMenu.add(bestReviewMenu);
    bestReviewMenu.add(new MenuItem("목록","/commBest/list"));
    bestReviewMenu.add(new MenuItem("상세보기","/commBest/detail"));

    MenuGroup shortReviewMenu = new MenuGroup("한 줄 후기");
    personalCommunityMenu.add(shortReviewMenu);

    shortReviewMenu.add(new MenuItem("등록", Menu.ENABLE_MEMBER, "/commReview/add"));
    shortReviewMenu.add(new MenuItem("목록", "/commReview/list")); 
    shortReviewMenu.add(new MenuItem("수정", Menu.ENABLE_MEMBER, "/commReview/update")); 
    shortReviewMenu.add(new MenuItem("삭제", Menu.ENABLE_MEMBER, "/commReview/delete")); 

    /////////////////////////////////////////////////////////////////////////////////////////

    MenuGroup personalChallengeMenu = new MenuGroup("챌린지");
    mainMenuGroup.add(personalChallengeMenu);

    MenuGroup monthlyChallengeMenu = new MenuGroup("이달의 챌린지");
    personalChallengeMenu.add(monthlyChallengeMenu);

    MenuGroup monthlyChallengeDetail = new MenuGroup("챌린지 상세보기");
    monthlyChallengeMenu.add(monthlyChallengeDetail);
    monthlyChallengeDetail.add(new MenuItem("상세정보", "/showChallenge/detail"));  //챌린지 상세정보(구현예정)
    monthlyChallengeDetail.add(new MenuItem("참여하기", Menu.ENABLE_MEMBER, "/challengeJoin/join"));  //챌린지 참여하기(구현예정)
    monthlyChallengeDetail.add(new MenuItem("참여자 목록", Menu.ENABLE_MEMBER, "/challengeJoin/list"));  //챌린지 참여자목록(구현예정)

    MenuGroup ChallengeReview = new MenuGroup("참여인증&댓글");
    monthlyChallengeDetail.add(ChallengeReview);
    ChallengeReview.add(new MenuItem("참여인증&댓글 등록", Menu.ENABLE_MEMBER, "/challengeReview/add"));
    ChallengeReview.add(new MenuItem("참여인증&댓글 목록", Menu.ENABLE_ALL,"/challengeReview/list"));
    ChallengeReview.add(new MenuItem("참여인증&댓글 상세보기", Menu.ENABLE_MEMBER,"/challengeReview/detail"));
    ChallengeReview.add(new MenuItem("참여인증&댓글 수정", Menu.ENABLE_MEMBER,"/challengeReview/update"));
    ChallengeReview.add(new MenuItem("참여인증&댓글 삭제", Menu.ENABLE_MEMBER,"/challengeReview/delete"));
    ChallengeReview.add(new MenuItem("참여인증&댓글 검색", Menu.ENABLE_ALL, "/challengeReview/search"));


    MenuGroup ChallengeQuestion = new MenuGroup("문의하기");
    monthlyChallengeDetail.add(ChallengeQuestion);
    ChallengeQuestion.add(new MenuItem("문의 등록", Menu.ENABLE_MEMBER, "/challengeQuestion/add"));
    ChallengeQuestion.add(new MenuItem("문의 목록",  "/challengeQuestion/list"));
    ChallengeQuestion.add(new MenuItem("문의 상세보기",Menu.ENABLE_MEMBER,"/challengeQuestion/detail"));
    ChallengeQuestion.add(new MenuItem("문의 수정", Menu.ENABLE_MEMBER, "/challengeQuestion/update"));
    ChallengeQuestion.add(new MenuItem("문의 삭제", Menu.ENABLE_MEMBER, "/challengeQuestion/delete"));
    ChallengeQuestion.add(new MenuItem("문의 검색",  "/challengeQuestion/search"));


    MenuGroup monthlyRankingMenu = new MenuGroup("이달의 랭킹", Menu.ENABLE_ALL);
    personalChallengeMenu.add(monthlyRankingMenu);
    monthlyRankingMenu.add(new MenuItem("이달의 랭킹보기", "/ranking/list"));  //전체랭킹(구현예정)
    monthlyRankingMenu.add(new MenuItem("나의 랭킹보기", Menu.ENABLE_MEMBER, "/myRanking/list"));  //나의랭킹(구현예정)

    MenuGroup personalDonationMenu = new MenuGroup("모금함");
    mainMenuGroup.add(personalDonationMenu);

    personalDonationMenu.add(new MenuItem("전체 기부금 내역", "/donationRegister/totalMoney"));
    personalDonationMenu.add(new MenuItem("모금함 개설신청", Menu.ENABLE_ORG, "/donationBoard/apply"));


    MenuGroup donationList = new MenuGroup("모금함 목록");
    personalDonationMenu.add(donationList);


    MenuGroup donation = new MenuGroup("모금함 상세보기");
    personalDonationMenu.add(donation);

    donation.add(new MenuItem("기부하기", Menu.ENABLE_MEMBER, "/donationRegister/add"));
    donation.add(new MenuItem("참여내역", "/donationRegister/participation"));

    /////////////////////////////////////////////////////////////////////////////////////////

    MenuGroup support = new MenuGroup("고객센터");
    mainMenuGroup.add(support);

    MenuGroup notice = new MenuGroup("공지사항");
    support.add(notice);



    notice.add(new MenuItem("등록", Menu.ENABLE_ADMIN,"/notice/add"));
    notice.add(new MenuItem("목록", "/notice/list"));
    notice.add(new MenuItem("상세보기", "/notice/detail"));
    notice.add(new MenuItem("변경",Menu.ENABLE_ADMIN,"/notice/update"));
    notice.add(new MenuItem("삭제",Menu.ENABLE_ADMIN, "/notice/delete"));

    MenuGroup ask = new MenuGroup("문의하기");
    support.add(ask);

    ask.add(new MenuItem("등록", Menu.ENABLE_MEMBER,"/question/add"));
    ask.add(new MenuItem("목록", "/question/list"));
    ask.add(new MenuItem("상세보기", "/question/detail"));
    ask.add(new MenuItem("변경",Menu.ENABLE_MEMBER,"/question/update"));
    ask.add(new MenuItem("삭제",Menu.ENABLE_MEMBER, "/question/delete"));

    /////////////////////////////////////////////////////////////////////////////////////////

    // 마이페이지


    MenuGroup personalMyPage = new MenuGroup("마이페이지", Menu.ENABLE_MEMBER);
    mainMenuGroup.add(personalMyPage);


    MenuGroup myProfile = new MenuGroup("회원정보");
    personalMyPage.add(myProfile);

    myProfile.add(new MenuItem("내 정보", "/auth/displayUserInfo"));
    myProfile.add(new MenuItem("내 정보 수정", "/auth/changeUserInfo"));


    MenuGroup myVolunteer = new MenuGroup("나의 봉사",Menu.ENABLE_MEMBER);
    personalMyPage.add(myVolunteer);

    myVolunteer.add(new MenuItem("나의 봉사신청서 확인","/volRequestPersonal/applyCompleteList")); // 보완필요
    myVolunteer.add(new MenuItem("승인된 봉사내역","/volRequestPersonal/appliedList"));    
    myVolunteer.add(new MenuItem("반려된 봉사내역","/volRequestPersonal/rejectedList"));    
    myVolunteer.add(new MenuItem("찜한봉사","/volRequestPersonal/bookmark")); // 구현예정

    MenuGroup myDonation = new MenuGroup("나의 모금함");
    personalMyPage.add(myDonation);
    myDonation.add(new MenuItem("나의 모금함 개설신청서 확인", Menu.ENABLE_ORG, "/donationBoard/applyCompleteList")); 
    //    myDonation.add(new MenuItem("나의 기부내역", Menu.ENABLE_MEMBER, "/donationRegister/list")); // 구현예정


    myVolunteer.add(new MenuItem("찜한봉사","/volRequestPersonal/bookmark")); // 구현예정    


    MenuGroup myBoard = new MenuGroup("나의 게시글"); // 구현예정
    personalMyPage.add(myBoard);

    myBoard.add(new MenuItem("나의게시글 목록","/MyBoard/list"));
    myBoard.add(new MenuItem("나의게시글 상세보기","/MyBoard/detail"));
    myBoard.add(new MenuItem("나의게시글 수정","/MyBoard/update"));
    myBoard.add(new MenuItem("나의게시글 삭제","/MyBoard/delete"));


    MenuGroup myPoint = new MenuGroup("나의 포인트"); // 구현예정
    personalMyPage.add(myPoint);

    myPoint.add(new MenuItem("나의포인트확인","MyPoint/list"));


    MenuGroup organizationApprove = new MenuGroup("기관 승인 신청");
    personalMyPage.add(organizationApprove);

    organizationApprove.add(new MenuItem("승인 요청하기","/OrgMyVol/apply"));
    organizationApprove.add(new MenuItem("승인 현황보기","/OrgMyVol/approve"));


    personalMyPage.add(new MenuItem("탈퇴", Menu.ENABLE_MEMBER, "/MyPage/delete"));

    //////////////////////////////////////////////////////////////////////////////////////////////////////////    

    MenuGroup adminMenu = new MenuGroup("관리자",  Menu.ENABLE_ADMIN);
    mainMenuGroup.add(adminMenu);

    MenuGroup memberMenu = new MenuGroup("회원정보 관리");
    adminMenu.add(memberMenu);
    //
    memberMenu.add(new MenuItem("회원목록", "/join/list"));
    memberMenu.add(new MenuItem("가입회원 상세보기", "/join/detail"));
    memberMenu.add(new MenuItem("회원추방","/adminMember/list"));

    MenuGroup donationMenu = new MenuGroup("모금함 관리");
    adminMenu.add(donationMenu);

    donationMenu.add(new MenuItem("모금함 개설 신청내역 목록", "/donationBoard/applyList"));
    donationMenu.add(new MenuItem("모금함 개설 신청내역", "/donationBoard/applyList"));
    donationMenu.add(new MenuItem("모금함 개설 신청내역 상세보기", "/donationBoard/applyDetail"));
    donationMenu.add(new MenuItem("모금함 개설 승인하기", "/donationBoard/acceptApply"));
    donationMenu.add(new MenuItem("모금함 개설 반려하기", "/donationBoard/rejectApply"));


    MenuGroup volunteerMenu = new MenuGroup("봉사활동 관리");
    adminMenu.add(volunteerMenu);

    volunteerMenu.add(new MenuItem("개인봉사신청내역","/volRequestPersonal/applyList"));
    volunteerMenu.add(new MenuItem("기관봉사신청내역","/volRequestPersonal/bookmark")); // 구현예정
    volunteerMenu.add(new MenuItem("개인봉사승인하기","/volRequestPersonal/acceptApply"));
    volunteerMenu.add(new MenuItem("기관봉사승인하기","/volRequestPersonal/bookmark")); // 구현예정
    volunteerMenu.add(new MenuItem("개인봉사반려하기","/volRequestPersonal/rejectApply"));
    volunteerMenu.add(new MenuItem("기관봉사반려하기","/volRequestPersonal/bookmark")); // 구현예정

    MenuGroup noticeMenu = new MenuGroup("공지사항 관리");
    adminMenu.add(noticeMenu);

    noticeMenu.add(new MenuItem("공지사항 등록","/adminNotice/add"));
    noticeMenu.add(new MenuItem("공지사항 목록","/adminNotice/list"));
    noticeMenu.add(new MenuItem("공지사항 상세보기","/adminNotice/detail"));
    noticeMenu.add(new MenuItem("공지사항 변경","/adminNotice/update"));
    noticeMenu.add(new MenuItem("공지사항 삭제","/adminNotice/delete"));

    MenuGroup askInfo = new MenuGroup("문의사항 관리");
    adminMenu.add(askInfo);

    askInfo.add(new MenuItem("문의사항 등록","/adminQuestion/add"));
    askInfo.add(new MenuItem("문의사항 목록","/adminQuestion/add"));
    askInfo.add(new MenuItem("문의사항 상세보기","/adminQuestion/add"));
    askInfo.add(new MenuItem("문의사항 변경","/adminQuestion/add"));
    askInfo.add(new MenuItem("문의사항 삭제","/adminQuestion/add"));

    MenuGroup challengeInfo = new MenuGroup("챌린지 관리");
    adminMenu.add(challengeInfo);

    challengeInfo.add(new MenuItem("챌린지 등록","/adminChallenge/add"));
    challengeInfo.add(new MenuItem("챌린지 목록","/adminChallenge/add"));
    challengeInfo.add(new MenuItem("챌린지 상세보기","/adminChallenge/add"));
    challengeInfo.add(new MenuItem("챌린지 변경","/adminChallenge/add"));
    challengeInfo.add(new MenuItem("챌린지 삭제","/adminChallenge/add"));

    MenuGroup approveInfo = new MenuGroup("기관 승인");
    adminMenu.add(approveInfo);

    approveInfo.add(new MenuItem("기관승인신청 목록","/adminChallenge/list"));
    approveInfo.add(new MenuItem("기관승인신청 내용","/adminChallenge/detail"));
    approveInfo.add(new MenuItem("기관승인신청 변경","/adminChallenge/update"));
    approveInfo.add(new MenuItem("기관승인신청 삭제","/adminChallenge/delete"));

    return mainMenuGroup;
  }
}


