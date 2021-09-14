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
//import com.share.ftp.handler.join.JoinSearchIdHandler;
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
import com.share.ftp.handler.personal.donation.DonationBoardHandler;
import com.share.ftp.handler.personal.donation.DonationRegisterHandler;
import com.share.ftp.handler.personal.mypage.MyBoardUpdateHandler;
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
import com.share.ftp.handler.personal.volunteer.VolApprovedHandler;
import com.share.ftp.handler.personal.volunteer.VolListHandler;
import com.share.menu.MenuGroup;
import practicemakesperfect.util.Prompt;

public class AppTestWORK {

  // 회원가입 도메인(값)
  List<JoinDTO> joinDTOList = new ArrayList<>();

  // 함께해요 도메인(값)
  List<VolListDTO> volListDTOList = new ArrayList<>();
  List<PersonalRequestApplyDTO> personalRequestApplyDTOList = new ArrayList<>();
  List<PersonalRequestDTO> personalRequestDTOList = new ArrayList<>();
  List<PersonalRequestRejectDTO> personalRequestRejectDTOList = new ArrayList<>();

  List<ApproveOrgDTO> approveOrgDTOList = new ArrayList<>();

  // 소통해요 도메인(값)
  List<CommBoardDTO> commBoardDTOList = new ArrayList<>();
  List<CommReviewDTO> commReviewDTOList = new ArrayList<>();

  // 챌린지 도메인(값)

  List<MyChallengeQuestionDTO> myChallengeQuestionDTOList = new ArrayList<>();
  List<MyChallengeReviewDTO> myChallengeReviewDTOList = new ArrayList<>();

  // 기부 도메인(값)
  List<DonationBoardDTO> donationBoardDTOList = new ArrayList<>();
  List<DonationRegisterDTO> donationRegisterDTOList = new ArrayList<>();

  // 마이페이지 도메인(값)
  List<MyProfileDTO> myProfileDTOList = new ArrayList<>();
  List<MyQuestionListDTO> myQuestionListDTOList = new ArrayList<>();
  List<OrgRequestDTO> orgRequestDTOList = new ArrayList<>();

  // 관리자 도메인(값)
  List<ChallengeDTO> challengeDTOList = new ArrayList<>();
  List<NoticeDTO> noticeDTOList = new ArrayList<>();
  List<QuestionDTO> questionDTOList = new ArrayList<>();


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


  // 함께해요 핸들러(기능)
  OrgVolRequestHandler orgVolRequestHandler = new OrgVolRequestHandler(); // 아직 List 변경 안함
  //  PersonalVolRequestHandler personalVolRequestHandler = new PersonalVolRequestHandler(orgVolRequestHandler); // 아직 List 변경 안함
  VolApprovedHandler volApprovedHandler = new VolApprovedHandler();
  VolListHandler volListHandler = new VolListHandler(personalVolRequestHandler,orgVolRequestHandler);


  // 소통해요 핸들러(기능)


  //  CommBoardAddHandler commBoardAddHandler = new CommBoardAddHandler(commBoardDTOList);
  //  CommBoardListHandler commBoardListHandler = new CommBoardListHandler(commBoardDTOList);
  //  CommBoardDetailHandler commBoardDetailHandler = new CommBoardDetailHandler(commBoardDTOList);
  //  CommBoardUpdateHandler commBoardUpdateHandler = new CommBoardUpdateHandler(commBoardDTOList);
  //  CommBoardDeleteHandler commBoardDeleteHandler = new CommBoardDeleteHandler(commBoardDTOList);

  //  CommReviewAddHandler commReviewAddHandler = new CommReviewAddHandler(commReviewDTOList);
  //  CommReviewListHandler commReviewListHandler = new CommReviewListHandler(commReviewDTOList);
  //  CommReviewUpdateHandler commReviewUpdateHandler = new CommReviewUpdateHandler(commReviewDTOList);
  //  CommReviewDeleteHandler commReviewDeleteHandler = new CommReviewDeleteHandler(commReviewDTOList);
  CommReviewAddHandler commReviewAddHandler = new CommReviewAddHandler(commReviewDTOList);
  CommReviewListHandler commReviewListHandler = new CommReviewListHandler(commReviewDTOList);
  CommReviewUpdateHandler commReviewUpdateHandler = new CommReviewUpdateHandler(commReviewDTOList);
  CommReviewDeleteHandler commReviewDeleteHandler = new CommReviewDeleteHandler(commReviewDTOList);

  //  CommBestHandler commBestHandler = new CommBestHandler(commBoardHandler);
  //  CommReviewHandler commReviewHandler = new CommReviewHandler(commReviewDTOList);


  //  // 챌린지 핸들러(기능)
  //  ChallengeHandler challengeHandler = new ChallengeHandler();
  //  ShowChallengeHandler showChallengeHandler = new ShowChallengeHandler();


  // 챌린지 핸들러(기능)
  ChallengeListHandler challengeListHandler = new ChallengeListHandler();
  ChallengeBoardHandler challengeBoardHandler = new ChallengeBoardHandler();
  RankingHandler rankingHandler = new RankingHandler();
  //  ChallengeReviewHandler challengeReviewHandler = new ChallengeReviewHandler(myChallengeReviewDTOList);


  // 모금함 관련 핸들러(기능)
  DonationRegisterHandler donationRegisterHandler = new DonationRegisterHandler(donationRegisterDTOList);
  //  DonationDetailHandler donationDetailHandler = new DonationDetailHandler(donationRegisterHandler);
  DonationBoardHandler donationBoardHandler = new DonationBoardHandler(donationBoardDTOList);


  // 마이 페이지 핸들러(기능)
  // MyPageHandler myVolHandler = new MyPageHandler();
  //QuestionHandler questionHandler = new QuestionHandler(myQuestionListDTOList);
  NoticeListHandler noticeListHandler = new NoticeListHandler();
  MyProfileHandler myProfileHandler = new MyProfileHandler(myProfileDTOList);
  MyBoardUpdateHandler myBoardListHandler = new MyBoardUpdateHandler();
  MyPointHandler myPointHandler = new MyPointHandler();
  MyDonationHandler myDonationHandler = new MyDonationHandler();
  ApproveOrgHandler approveOrgHandler = new ApproveOrgHandler(approveOrgDTOList);
  WithdrawMemberHandler withdrawMemberHandler = new WithdrawMemberHandler();



  // 고객센터 핸들러(기능)

  AdminQuestionHandler showQuestionHandler = new AdminQuestionHandler(questionDTOList);
  // SupportHandler supportHandler = new SupportHandler(questionHandler, noticeListHandler);
  //  SupportHandler supportHandler = new SupportHandler(questionHandler, noticeListHandler);




  // 관리자 페이지 핸들러(기능)
  //  ShowVolHandler showVolHandler = new ShowVolHandler(personalVolRequestHandler,orgVolRequestHandler);
  //  ShowMemberHandler showMemberHandler = new ShowMemberHandler();
  //  ShowChallengeHandler showChallengeHandler = new ShowChallengeHandler(); // 아직 List 변경 안함
  //  ShowOrgApproveHandler showOrgApproveHandler = new ShowOrgApproveHandler();
  //  ShowDonationHandler showDonationHandler = new ShowDonationHandler(donationBoardHandler);
  //  AdminMemberListHandler showMemberHandler = new AdminMemberListHandler();
  //  AdminChallengeHandler showChallengeHandler = new AdminChallengeHandler(); // 아직 List 변경 안함
  //  AdminOrgApproveAddHandler showOrgApproveHandler = new AdminOrgApproveAddHandler();
  //  MyProfileHandler myProfileHandler = new MyProfileHandler(myProfileDTOList);
  //  AdminPageHandler adminPageHandler = new AdminPageHandler(personalVolRequestHandler,showVolHandler, donationBoardHandler, showDonationHandler); 


  public static void main(String[] args) {

    AppTestWORK app = new AppTestWORK(); 
    app.service();

  }

  public AppTestWORK() {
    //로그인, 로그아웃
    commands.put("/auth/login", new AuthLoginHandler(joinDTOList)); // 로그인
    commands.put("/auth/logout", new AuthLogoutHandler()); // 로그아웃
    commands.put("/auth/changeUserInfo", new AuthChangeUserInfoHandler()); // 마이페이지 나의정보
    commands.put("/auth/displayUserInfo", new AuthDisplayUserInfoHandler()); // 마이페이지 나의정보수정


    //회원가입
    commands.put("/join/add", new JoinAddHandler(joinDTOList)); // 회원가입
    //    commands.put("/join/searchId", new JoinSearchIdHandler(joinDTOList)); // 아이디 찾기
    commands.put("/join/searchPassword", new JoinSearchPasswordHandler(joinDTOList)); // 비밀번호 찾기


    // 소통해요 나눔이야기
    commands.put("/commBoard/add", new CommBoardAddHandler(commBoardDTOList));
    commands.put("/commBoard/list", new CommBoardListHandler(commBoardDTOList));
    commands.put("/commBoard/detail", new CommBoardDetailHandler(commBoardDTOList));
    commands.put("/commBoard/update", new CommBoardUpdateHandler(commBoardDTOList));
    commands.put("/commBoard/delete", new CommBoardDeleteHandler(commBoardDTOList));

    commands.put("/commBest/list", new CommBestListHandler(commBoardDTOList));
    commands.put("/commBest/detail", new CommBestDetailHandler(commBoardDTOList));

    commands.put("/commReview/add ", new CommReviewAddHandler(commReviewDTOList));
    commands.put("/commReview/list ", new CommReviewListHandler(commReviewDTOList));
    commands.put("/commReview/update ", new CommReviewUpdateHandler(commReviewDTOList));
    commands.put("/commReview/delete ", new CommReviewDeleteHandler(commReviewDTOList));

    // 챌린지 참여인증&댓글
    //    commands.put("/challengeReview/add", new ChallengeReviewAddHandler(myChallengeReviewDTOList));
    //    commands.put("/challengeReview/list", new ChallengeReviewListHandler(myChallengeReviewDTOList));
    //    commands.put("/challengeReview/detail", new ChallengeReviewDetailHandler(myChallengeReviewDTOList));
    //    commands.put("/challengeReview/update", new ChallengeReviewUpdateHandler(myChallengeReviewDTOList));
    //    commands.put("/challengeReview/delete", new ChallengeReviewDeleteHandler(myChallengeReviewDTOList));
    //    commands.put("/challengeReview/search", new ChallengeReviewSearchHandler(myChallengeReviewDTOList));

    // 고객센터 문의하기
    commands.put("/question/add", new QuestionAddHandler(myQuestionListDTOList));
    commands.put("/question/list", new QuestionListHandler(myQuestionListDTOList));
    commands.put("/question/detail", new QuestionDetailHandler(myQuestionListDTOList));
    commands.put("/question/update", new QuestionUpdateHandler(myQuestionListDTOList));
    commands.put("/question/delete", new QuestionDeleteHandler(myQuestionListDTOList));


    // 마이페이지
    commands.put("/myProfile/update", new MyProfileHandler(myProfileDTOList));

    commands.put("/MyPage/delete", new MyPageDelete(joinDTOList)); // 회원탈퇴
    commands.put("/MyPage/info", new MyPageInfoHandler(joinDTOList)); // 내정보 수정


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

    // 마이페이지
    commands.put("/myProfile/update", new MyProfileHandler(myProfileDTOList));


    // 챌린지 문의하기
    commands.put("/challengeQuestion/add", new ChallengeQuestionAddHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/list", new ChallengeQuestionListHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/detail", new ChallengeQuestionDetailHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/update", new ChallengeQuestionUpdateHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/delete", new ChallengeQuestionDeleteHandler(myChallengeQuestionDTOList));
    commands.put("/challengeQuestion/search", new ChallengeQuestionSearchHandler(myChallengeQuestionDTOList));


    // 마이페이지
    commands.put("/MyPage/delete", new MyPageDelete(joinDTOList)); // 회원탈퇴
    commands.put("/MyPage/info", new MyPageInfoHandler(joinDTOList)); // 내정보 수정


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
    mainMenuGroup.add(new MenuItem("아이디찾기", Menu.ENABLE_LOGOUT, "/join/searchId"));
    mainMenuGroup.add(new MenuItem("비밀번호찾기", Menu.ENABLE_LOGOUT, "/join/searchPassword"));
    mainMenuGroup.add(new MenuItem("회원가입", Menu.ENABLE_LOGOUT, "/join/add"));
    mainMenuGroup.add(new MenuItem("로그아웃", Menu.ENABLE_LOGIN, "/auth/logout"));


    // 함께해요
    MenuGroup doVolMenu = new MenuGroup("함께해요");
    mainMenuGroup.add(doVolMenu);
    doVolMenu.add(new Menu("개인봉사신청양식", Menu.ENABLE_PERSONAL) {
      @Override
      public void execute() {
        personalVolRequestHandler.apply(); 
      }});

    doVolMenu.add(new Menu("기관봉사신청양식", Menu.ENABLE_ORG) {
      @Override
      public void execute() {
        orgVolRequestHandler.apply(); 
      }});
    doVolMenu.add(new Menu("인증봉사리스트(일단 개인만)") {
      @Override
      public void execute() {
        personalVolRequestHandler.appliedList(); 
      }});
    doVolMenu.add(new Menu("인증봉사세부사항",Menu.ENABLE_MEMBER) {
      @Override
      public void execute() {
        volApprovedHandler.approvedDetail(); 
      }});
    doVolMenu.add(new Menu("찜하기",Menu.ENABLE_MEMBER) {
      @Override
      public void execute() {
        volApprovedHandler.approvedDetail(); 
      }});


    // 소통해요
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


  //  MenuGroup personalChallengeMenu = new MenuGroup("챌린지");
  //  mainMenuGroup.add(personalChallengeMenu);
  //
  //  MenuGroup monthlyChallengeMenu = new MenuGroup("이달의 챌린지");
  //  personalChallengeMenu.add(monthlyChallengeMenu);
  //
  //  MenuGroup monthlyChallengeDetail = new MenuGroup("챌린지 상세보기");
  //  monthlyChallengeMenu.add(monthlyChallengeDetail);
  //
  //  monthlyChallengeDetail.add(new Menu("상세정보") {
  //    @Override
  //    public void execute() {
  //      challengeBoardHandler.showChallengeDetail(); 
  //    }});
  //  monthlyChallengeDetail.add(new Menu("참여하기", Menu.ENABLE_PERSONAL) {
  //    @Override
  //    public void execute() {
  //      challengeBoardHandler.join(); 
  //    }});
  //  monthlyChallengeDetail.add(new Menu("참여자 목록", Menu.ENABLE_MEMBER) {
  //    @Override
  //    public void execute() {
  //      challengeBoardHandler.showMemberList(); 
  //    }});
  //  MenuGroup ChallengeReview = new MenuGroup("참여인증&댓글");
  //  monthlyChallengeDetail.add(ChallengeReview);
  //  ChallengeReview.add(new MenuItem("참여인증&댓글 등록", Menu.ENABLE_LOGIN, "/challengeReview/add"));
  //  ChallengeReview.add(new MenuItem("참여인증&댓글 목록", Menu.ENABLE_ALL,"/challengeReview/list"));
  //  ChallengeReview.add(new MenuItem("참여인증&댓글 상세보기", Menu.ENABLE_ALL,"/challengeReview/detail"));
  //  ChallengeReview.add(new MenuItem("참여인증&댓글 수정", Menu.ENABLE_LOGIN,"/challengeReview/update"));
  //  ChallengeReview.add(new MenuItem("참여인증&댓글 삭제", Menu.ENABLE_LOGIN,"/challengeReview/delete"));
  //  ChallengeReview.add(new MenuItem("참여인증&댓글 검색", Menu.ENABLE_LOGIN, "/challengeReview/search"));
  //
  //
  //  MenuGroup ChallengeQuestion = new MenuGroup("문의하기");
  //  monthlyChallengeDetail.add(ChallengeQuestion);
  //  ChallengeQuestion.add(new MenuItem("문의 삭제", Menu.ENABLE_MEMBER, "/challengeQuestion/delete"));
  //  ChallengeQuestion.add(new MenuItem("문의 등록", Menu.ENABLE_MEMBER, "/challengeQuestion/add"));
  //  ChallengeQuestion.add(new MenuItem("문의 목록",  "/challengeQuestion/list"));
  //  ChallengeQuestion.add(new MenuItem("문의 상세보기",Menu.ENABLE_MEMBER,"/challengeQuestion/detail"));
  //  ChallengeQuestion.add(new MenuItem("문의 수정", Menu.ENABLE_MEMBER, "/challengeQuestion/update"));
  //  ChallengeQuestion.add(new MenuItem("문의 검색",  "/challengeQuestion/search"));
  //
  //
  //  MenuGroup monthlyRankingMenu = new MenuGroup("이달의 랭킹", Menu.ENABLE_ALL);
  //  personalChallengeMenu.add(monthlyRankingMenu);
  //
  //
  //  monthlyRankingMenu.add(new Menu("이달의 랭킹보기", Menu.ENABLE_ALL) {
  //    @Override
  //    public void execute() {
  //      rankingHandler.showTotalRanking(); 
  //    }});
  //
  //  monthlyRankingMenu.add(new Menu("나의 랭킹보기", Menu.ENABLE_PERSONAL) {
  //    @Override
  //    public void execute() {
  //      rankingHandler.showMyRanking(); 
  //    }});
  //
  //  MenuGroup personalDonationMenu = new MenuGroup("모금함");
  //  mainMenuGroup.add(personalDonationMenu);
  //
  //  MenuGroup donationList = new MenuGroup("모금함 목록");
  //  personalDonationMenu.add(donationList);
  //
  //  MenuGroup donation = new MenuGroup("모금함 상세보기");
  //  donationList.add(donation);
  //
  //  donation.add(new Menu("기부하기", Menu.ENABLE_MEMBER) {
  //    @Override
  //    public void execute() {
  //      donationRegisterHandler.add(); 
  //    }});
  //  donation.add(new Menu("기부내역") {
  //    @Override
  //    public void execute() {
  //      donationRegisterHandler.participationDonation(); 
  //    }});
  //
  //  MenuGroup donationTotal = new MenuGroup("전체 모금액");
  //  personalDonationMenu.add(donationTotal);
  //
  //  donationTotal.add(new Menu("총 기부내역") {
  //    @Override
  //    public void execute() {
  //      donationRegisterHandler.totalDonationMoney(); 
  //    }});
  //
  //  MenuGroup applyDonation = new MenuGroup("모금함 개설신청", Menu.ENABLE_ORG);
  //  personalDonationMenu.add(applyDonation);
  //
  //  applyDonation.add(new Menu("개설신청") {
  //    @Override
  //    public void execute() {
  //      donationBoardHandler.applyDonation(); 
  //    }});

  //  MenuGroup support = new MenuGroup("고객센터");
  //  mainMenuGroup.add(support);
  //
  //  MenuGroup notice = new MenuGroup("공지사항");
  //  support.add(notice);
  //
  //  notice.add(new Menu("목록") {
  //    @Override
  //    public void execute() {
  //      noticeListHandler.noticeList(); 
  //    }});
  //  notice.add(new Menu("상세보기") {
  //    @Override
  //    public void execute() {
  //      noticeListHandler.noticeDetail(); 
  //    }});

  //    MenuGroup faQ = new MenuGroup("FAQ");
  //    support.add(faQ);
  //
  //    faQ.add(new Menu("목록") {
  //      @Override
  //      public void execute() {
  //        boardHandler.list(); 
  //      }});
  //    faQ.add(new Menu("상세보기") {
  //      @Override
  //      public void execute() {
  //        boardHandler.detail(); 
  //      }});
  //
  //  MenuGroup ask = new MenuGroup("문의하기");
  //  support.add(ask);
  //
  //  ask.add(new MenuItem("등록", Menu.ENABLE_MEMBER,"/question/add"));
  //  ask.add(new MenuItem("목록", "/question/list"));
  //  ask.add(new MenuItem("상세보기", "/question/detail"));
  //  ask.add(new MenuItem("변경",Menu.ENABLE_MEMBER,"/question/update"));
  //  ask.add(new MenuItem("삭제",Menu.ENABLE_MEMBER, "/question/delete"));
  //
  //  MenuGroup personalMyPage = new MenuGroup("마이페이지", Menu.ENABLE_MEMBER);
  //  mainMenuGroup.add(personalMyPage);
  //
  //  MenuGroup myProfile = new MenuGroup("회원정보");
  //  personalMyPage.add(myProfile);
  //
  //  myProfile.add(new MenuItem("내 정보", "/auth/displayUserInfo"));
  //  myProfile.add(new MenuItem("내 정보 수정", "/auth/changeUserInfo"));
  //
  //  MenuGroup myVolunteer = new MenuGroup("나의 봉사",Menu.ENABLE_MEMBER);
  //  personalMyPage.add(myVolunteer);
  //  //
  //  myVolunteer.add(new Menu("나의 봉사신청서 확인") {
  //    @Override
  //    public void execute() {
  //      personalVolRequestHandler.applyList(); 
  //    }});
  //  myVolunteer.add(new Menu("승인된 봉사내역") {
  //    @Override
  //    public void execute() {
  //      personalVolRequestHandler.appliedList(); 
  //    }});    
  //  myVolunteer.add(new Menu("찜한봉사") {
  //    @Override
  //    public void execute() {
  //      //        personalVolRequestHandler.showVolBookmark(); 
  //    }});    
  //
  //    MenuGroup myBoard = new MenuGroup("나의 게시글");
  //    personalMyPage.add(myBoard);
  //
  //    MenuGroup myBoardList = new MenuGroup("목록");
  //    myBoard.add(myBoardList);
  //
  //    MenuGroup myBoardDetail = new MenuGroup("상세보기");
  //    myBoard.add(myBoardDetail);
  //
  //    myBoardDetail.add(new Menu("수정") {
  //      @Override
  //      public void execute() {
  //        boardHandler.checkUpdate(); 
  //      }});
  //    myBoardDetail.add(new Menu("삭제") {
  //      @Override
  //      public void execute() {
  //        boardHandler.checkDelete(); 
  //      }});    
  //
  //    MenuGroup myPoint = new MenuGroup("나의 포인트");
  //    personalMyPage.add(myPoint);
  //    //
  //    myPoint.add(new Menu("1. 나의포인트확인") {
  //      @Override
  //      public void execute() {
  //        myPointHandler.showMyPointList(); 
  //      }});    
  //    //
  //    MenuGroup myDonation = new MenuGroup("나의 모금함");
  //    personalMyPage.add(myDonation);
  //    //
  //    myDonation.add(new Menu("1. 나의기부내역") {
  //      @Override
  //      public void execute() {
  //        myDonationHandler.showMyTotalDonation(); 
  //      }});    
  //    //
  //    MenuGroup organizationApprove = new MenuGroup("기관 승인 신청");
  //    personalMyPage.add(organizationApprove);

  //    organizationApprove.add(new Menu("승인 요청하기") {
  //      @Override
  //      public void execute() {
  //        boardHandler.okSubmit(); 
  //      }});  
  //
  //    organizationApprove.add(new Menu("승인 현황보기") {
  //      @Override
  //      public void execute() {
  //        boardHandler.detail(); 
  //      }});   
  //
  //  personalMyPage.add(new MenuItem("탈퇴", Menu.ENABLE_MEMBER, "/MyPage/delete"));
  //
  //
  //////////////////////////////////////////////////////////////////////////////////////////////////////////    

  //  MenuGroup adminMenu = new MenuGroup("관리자",  Menu.ENABLE_ADMIN);
  //  mainMenuGroup.add(adminMenu);
  //
  //  MenuGroup memberMenu = new MenuGroup("회원정보 관리");
  //  adminMenu.add(memberMenu);
  //  //
  //  memberMenu.add(new MenuItem("회원목록", "/join/list"));
  //  memberMenu.add(new MenuItem("가입회원 상세보기", "/join/detail"));
  //  memberMenu.add(new MenuItem("회원추방","/adminMember/list"));
  //
  //  MenuGroup donationMenu = new MenuGroup("모금함 관리");
  //  adminMenu.add(donationMenu);
  //
  //  donationMenu.add(new Menu("모금함 개설 신청내역 목록") {
  //    @Override
  //    public void execute() {
  //      donationBoardHandler.applyDonationList(); 
  //    }});
  //  donationMenu.add(new Menu("모금함 개설 신청내역 상세보기") {
  //    @Override
  //    public void execute() {
  //      donationBoardHandler.applyDonationdetail(); 
  //    }});
  //
  //
  //  MenuGroup volunteerMenu = new MenuGroup("봉사활동 관리");
  //  adminMenu.add(volunteerMenu);
  //
  //  volunteerMenu.add(new Menu("개인봉사신청내역") {
  //    @Override
  //    public void execute() {
  //      personalVolRequestHandler.applyList(); 
  //    }});
  //  volunteerMenu.add(new Menu("기관봉사신청내역") {
  //    @Override
  //    public void execute() {
  //      orgVolRequestHandler.applyList(); 
  //    }});
  //  volunteerMenu.add(new Menu("개인봉사승인하기") {
  //    @Override
  //    public void execute() {
  //      personalVolRequestHandler.acceptApply(); 
  //    }});
  //  volunteerMenu.add(new Menu("기관봉사승인하기") {
  //    @Override
  //    public void execute() {
  //      orgVolRequestHandler.acceptApply(); 
  //    }});
  //  volunteerMenu.add(new Menu("개인봉사반려하기") {
  //    @Override
  //    public void execute() {
  //      personalVolRequestHandler.rejectApply(); 
  //    }});
  //  volunteerMenu.add(new Menu("기관봉사반려하기") {
  //    @Override
  //    public void execute() {
  //      orgVolRequestHandler.rejectApply(); 
  //    }});
  //
  //  MenuGroup noticeMenu = new MenuGroup("공지사항 관리");
  //  adminMenu.add(noticeMenu);
  //
  //  noticeMenu.add(new MenuItem("공지사항 등록","/adminNotice/add"));
  //  noticeMenu.add(new MenuItem("공지사항 목록","/adminNotice/list"));
  //  noticeMenu.add(new MenuItem("공지사항 상세보기","/adminNotice/detail"));
  //  noticeMenu.add(new MenuItem("공지사항 변경","/adminNotice/update"));
  //  noticeMenu.add(new MenuItem("공지사항 삭제","/adminNotice/delete"));
  //
  //  MenuGroup askInfo = new MenuGroup("문의사항 관리");
  //  adminMenu.add(askInfo);
  //
  //  askInfo.add(new MenuItem("문의사항 등록","/adminQuestion/add"));
  //  askInfo.add(new MenuItem("문의사항 목록","/adminQuestion/add"));
  //  askInfo.add(new MenuItem("문의사항 상세보기","/adminQuestion/add"));
  //  askInfo.add(new MenuItem("문의사항 변경","/adminQuestion/add"));
  //  askInfo.add(new MenuItem("문의사항 삭제","/adminQuestion/add"));
  //
  //  MenuGroup challengeInfo = new MenuGroup("챌린지 관리");
  //  adminMenu.add(challengeInfo);
  //
  //  challengeInfo.add(new MenuItem("챌린지 등록","/adminChallenge/add"));
  //  challengeInfo.add(new MenuItem("챌린지 목록","/adminChallenge/add"));
  //  challengeInfo.add(new MenuItem("챌린지 상세보기","/adminChallenge/add"));
  //  challengeInfo.add(new MenuItem("챌린지 변경","/adminChallenge/add"));
  //  challengeInfo.add(new MenuItem("챌린지 삭제","/adminChallenge/add"));
  //
  //  MenuGroup approveInfo = new MenuGroup("기관 승인");
  //  adminMenu.add(approveInfo);
  //
  //  approveInfo.add(new MenuItem("기관승인신청 목록","/adminChallenge/list"));
  //  approveInfo.add(new MenuItem("기관승인신청 내용","/adminChallenge/detail"));
  //  approveInfo.add(new MenuItem("기관승인신청 변경","/adminChallenge/update"));
  //  approveInfo.add(new MenuItem("기관승인신청 삭제","/adminChallenge/delete"));

  //return mainMenuGroup;
  //}
}


