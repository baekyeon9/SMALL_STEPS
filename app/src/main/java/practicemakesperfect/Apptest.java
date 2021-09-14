package com.share.ftp;



import static com.share.menu.Menu.ACCESS_ADMIN;
import static com.share.menu.Menu.ACCESS_LOGOUT;
import static com.share.menu.Menu.ACCESS_MEMBER;
import static com.share.menu.Menu.ACCESS_ORG;
import static com.share.menu.Menu.ACCESS_PERSONAL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.share.ftp.domain.admin.ChallengeDTO;
import com.share.ftp.domain.admin.NoticeDTO;
import com.share.ftp.domain.admin.QuestionDTO;
import com.share.ftp.domain.join.JoinDTO;
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
import com.share.ftp.handler.personal.support.QuestionDeleteHandler;
import com.share.ftp.handler.personal.support.QuestionDetailHandler;
import com.share.ftp.handler.personal.support.QuestionListHandler;
import com.share.ftp.handler.personal.support.QuestionUpdateHandler;
import com.share.ftp.handler.personal.volunteer.VolRequestPersonalAcceptApplyHandler;
import com.share.ftp.handler.personal.volunteer.VolRequestPersonalAppliedListHandler;
import com.share.ftp.handler.personal.volunteer.VolRequestPersonalApplyCompleteListHandler;
import com.share.ftp.handler.personal.volunteer.VolRequestPersonalApplyHandler;
import com.share.ftp.handler.personal.volunteer.VolRequestPersonalApplyListHandler;
import com.share.ftp.handler.personal.volunteer.VolRequestPersonalBookmarkHandler;
import com.share.ftp.handler.personal.volunteer.VolRequestPersonalRejectApplyHandler;
import com.share.ftp.handler.personal.volunteer.VolRequestPersonalRejectedListHandler;
import com.share.ftp.handler.personal.volunteer.VolRequestTotalApprovedListHandler;
import com.share.ftp.handler.personal.volunteerOrg.VolRequestOrgAcceptApplyHandler;
import com.share.ftp.handler.personal.volunteerOrg.VolRequestOrgAppliedListHandler;
import com.share.ftp.handler.personal.volunteerOrg.VolRequestOrgApplyCompleteListHandler;
import com.share.ftp.handler.personal.volunteerOrg.VolRequestOrgApplyHandler;
import com.share.ftp.handler.personal.volunteerOrg.VolRequestOrgApplyListHandler;
import com.share.ftp.handler.personal.volunteerOrg.VolRequestOrgRejectApplyHandler;
import com.share.ftp.handler.personal.volunteerOrg.VolRequestOrgRejectedListHandler;
import com.share.menu.Menu;
import com.share.menu.MenuGroup;
import com.share.util.Prompt;

public class App {

  // 회원가입 도메인(값)
  List<JoinDTO> joinDTOList = new ArrayList<>();

  // 함께해요 도메인(값)
  List<VolListDTO> volListDTOList = new ArrayList<>();

  // 개인, 기관 공통 도메인
  //    List<GeneralRequestDTO> generalRequestDTOList = new ArrayList<>();
  //  List<GeneralRequestDTO> personalRequestApplyDTOList = new ArrayList<>();
  //  List<GeneralRequestDTO> personalRequestRejectDTOList = new ArrayList<>();
  //  List<GeneralRequestDTO> orgRequestDTOApplyList = new ArrayList<>();
  //  List<GeneralRequestDTO> orgRequestDTORejectList = new ArrayList<>();

  // 개인 봉사신청 관련 도메인
  List<PersonalRequestDTO> personalRequestDTOList = new ArrayList<>();
  List<PersonalRequestDTO> personalRequestApplyDTOList = new ArrayList<>();
  List<PersonalRequestDTO> personalRequestRejectDTOList = new ArrayList<>();

  // 기관 봉사신청 관련 도메인
  List<OrgRequestDTO> orgRequestDTOList = new ArrayList<>();
  List<OrgRequestDTO> orgRequestApplyDTOList = new ArrayList<>();
  List<OrgRequestDTO> orgRequestRejectDTOList = new ArrayList<>();

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
      super(title);
      this.menuId = menuId;
    }

    public MenuItem(String title, int accessScope, String menuId) {
      super(title, accessScope);
      this.menuId = menuId;
    }
    @Override
    public void execute() {
      Command command = commands.get(menuId);
      command.execute();
    }
  }


  public static void main(String[] args) {

    App app = new App(); 
    app.service();
  }

  public App() {
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
    commands.put("/volRequestPersonal/apply", new VolRequestPersonalApplyHandler(personalRequestDTOList,joinDTOList));
    commands.put("/volRequestPersonal/applyList", new VolRequestPersonalApplyListHandler(personalRequestDTOList));
    commands.put("/volRequestPersonal/applyCompleteList", new VolRequestPersonalApplyCompleteListHandler(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList));
    commands.put("/volRequestPersonal/acceptApply", new VolRequestPersonalAcceptApplyHandler(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList));
    commands.put("/volRequestPersonal/rejectApply", new VolRequestPersonalRejectApplyHandler(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList));
    commands.put("/volRequestPersonal/appliedList", new VolRequestPersonalAppliedListHandler(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList));
    commands.put("/volRequestPersonal/rejectedList", new VolRequestPersonalRejectedListHandler(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList));
    commands.put("/volRequestPersonal/bookmark", new VolRequestPersonalBookmarkHandler(personalRequestDTOList, personalRequestApplyDTOList, personalRequestRejectDTOList));
    commands.put("/volRequest/totalApprovedList", new VolRequestTotalApprovedListHandler(
        personalRequestDTOList, orgRequestDTOList,personalRequestApplyDTOList, personalRequestRejectDTOList,orgRequestApplyDTOList,orgRequestRejectDTOList));

    //함께해요 (기관) + 마이페이지
    commands.put("/volRequestOrg/apply", new VolRequestOrgApplyHandler(orgRequestDTOList,joinDTOList));
    commands.put("/volRequestOrg/applyList", new VolRequestOrgApplyListHandler(orgRequestDTOList));
    commands.put("/volRequestOrg/applyCompleteList", new VolRequestOrgApplyCompleteListHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));
    commands.put("/volRequestOrg/acceptApply", new VolRequestOrgAcceptApplyHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));
    commands.put("/volRequestOrg/rejectApply", new VolRequestOrgRejectApplyHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));
    commands.put("/volRequestOrg/appliedList", new VolRequestOrgAppliedListHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));
    commands.put("/volRequestOrg/rejectedList", new VolRequestOrgRejectedListHandler(orgRequestDTOList, orgRequestApplyDTOList, orgRequestRejectDTOList));

    // 소통해요 나눔이야기
    commands.put("/commBoard/add", new CommBoardAddHandler(commBoardDTOList));
    commands.put("/commBoard/list", new CommBoardListHandler(commBoardDTOList));
    commands.put("/commBoard/detail", new CommBoardDetailHandler(commBoardDTOList));
    commands.put("/commBoard/update", new CommBoardUpdateHandler(commBoardDTOList));
    commands.put("/commBoard/delete", new CommBoardDeleteHandler(commBoardDTOList));

    // 소통해요 나눔이야기 BEST
    commands.put("/commBest/list", new CommBestListHandler(commBoardDTOList));
    commands.put("/commBest/detail", new CommBestDetailHandler(commBoardDTOList));

    // 소통해요 한줄후기
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

    // 고객센터 공지사항 (개인+ 관리자)
    commands.put("/notice/add", new NoticeAddHandler(noticeDTOList));
    commands.put("/notice/list", new NoitceListHandler(noticeDTOList));
    commands.put("/notice/detail", new NoticeDetailHandler(noticeDTOList));
    commands.put("/notice/update", new NoticeUpdateHandler(noticeDTOList));
    commands.put("/notice/delete", new NoticeDeleteHandler(noticeDTOList));

    // 고객센터 문의사항
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

    // 관리자 회원정보 조회
    commands.put("/join/list", new JoinListHandler(joinDTOList)); // 관리자가 회원 목록을 조회
    commands.put("/join/detail", new JoinDetailHandler(joinDTOList)); // 가입회원 상세보기 (관리자연결)
    commands.put("/join/delete", new AdminMemberDeleteHandler());

    // 관리자 공지사항
    //    commands.put("/adminNotice/add", new AdminNoticeAddHandler(noticeDTOList));
    //    commands.put("/adminNotice/list", new AdminNoticeListHandler(noticeDTOList));
    //    commands.put("/adminNotice/detail", new AdminNoticeDetailHandler(noticeDTOList));
    //    commands.put("/adminNotice/update", new AdminNoticeUpdateHandler(noticeDTOList));
    //    commands.put("/adminNotice/delete", new AdminNoticeDeleteHandler(noticeDTOList));

    // 관리자 문의사항
    commands.put("/adminAsk/add", new AdminQuestionAddHandler(questionDTOList));
    commands.put("/adminAsk/list", new AdminQuestionListHandler(questionDTOList));
    commands.put("/adminAsk/detail", new AdminQuestionDetailHandler(questionDTOList));
    commands.put("/adminAsk/update", new AdminQuestionUpdateHandler(questionDTOList));
    commands.put("/adminAsk/delete", new AdminQuestionDeleteHandler(questionDTOList));

    // 관리자 챌린지
    commands.put("/adminChallenge/list", new AdminChallengeListHandler(challengeDTOList));
    commands.put("/adminChallenge/detail", new AdminChallengeDetailHandler(challengeDTOList));
    commands.put("/adminChallenge/update", new AdminChallengeUpdateHandler(challengeDTOList));
    commands.put("/adminChallenge/delete", new AdminChallengeDeleteHandler(challengeDTOList));

    // 관리자 기관승인


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
    mainMenuGroup.add(new MenuItem("로그인", ACCESS_LOGOUT, "/auth/login"));

    MenuGroup searchId = new MenuGroup("아이디찾기", ACCESS_LOGOUT);
    mainMenuGroup.add(searchId);

    searchId.add(new MenuItem("휴대폰번호로아이디찾기", ACCESS_LOGOUT, "/join/searchTelId"));
    searchId.add(new MenuItem("이메일로아이디찾기", ACCESS_LOGOUT, "/join/searchEmailId"));

    mainMenuGroup.add(new MenuItem("비밀번호찾기", ACCESS_LOGOUT, "/join/searchPassword"));
    mainMenuGroup.add(new MenuItem("회원가입", ACCESS_LOGOUT, "/join/add"));
    mainMenuGroup.add(new MenuItem("로그아웃", ACCESS_MEMBER, "/auth/logout"));

    // 함께해요
    mainMenuGroup.add(createDoVolMenu());

    // 소통해요
    MenuGroup CommunityMenu = new MenuGroup("소통해요");
    mainMenuGroup.add(CommunityMenu);

    CommunityMenu.add(createReviewMenu());      // 나눔이야기
    CommunityMenu.add(createBestReviewMenu());  // 나눔이야기BEST
    CommunityMenu.add(createShortReviewMenu()); // 한줄후기

    MenuGroup challengeMenu = new MenuGroup("챌린지");
    mainMenuGroup.add(challengeMenu);

    MenuGroup monthlyChallengeMenu = new MenuGroup("이달의 챌린지");
    challengeMenu.add(monthlyChallengeMenu);

    MenuGroup challengeListMenu = new MenuGroup("챌린지 목록");
    monthlyChallengeMenu.add(challengeListMenu);

    MenuGroup challengeDetailMenu = new MenuGroup("챌린지 상세보기");
    monthlyChallengeMenu.add(challengeDetailMenu); 

    challengeDetailMenu.add(createChallengeReviewMenu()); // 참여인증&댓글
    challengeDetailMenu.add(createChallengeQuestionMenu()); // 문의하기

    MenuGroup challengeParticipationMenu = new MenuGroup("참여하기");
    challengeDetailMenu.add(challengeParticipationMenu);

    MenuGroup challengeParticipationListMenu = new MenuGroup("참여자목록");
    challengeDetailMenu.add(challengeParticipationListMenu);

    challengeMenu.add(createMonthlyRankingMenu()); // 이달의 랭킹


    // 모금함
    MenuGroup DonationMenu = new MenuGroup("모금함");
    mainMenuGroup.add(DonationMenu);
    =======
        MenuGroup doVolMenu = new MenuGroup("함께해요");
    mainMenuGroup.add(doVolMenu); 


    doVolMenu.add(new MenuItem("개인봉사신청양식", ACCESS_PERSONAL, "/volRequestPersonal/apply"));
    doVolMenu.add(new MenuItem("기관봉사신청양식", ACCESS_ORG, "/volRequestOrg/apply")); 
    doVolMenu.add(new MenuItem("인증봉사리스트","/volRequestPersonal/totalApprovedList")); 
    doVolMenu.add(new MenuItem("인증봉사세부사항", ACCESS_MEMBER,"/volRequestPersonal/appliedList"));
    doVolMenu.add(new MenuItem("찜하기", ACCESS_MEMBER,"/volRequestPersonal/bookmark")); // 구현예정

    ////////////////////////////////////////////////////////////////////////////////////////////////
    >>>>>>> c86f356fd7204ec225289f45539cff031f5d1819

    DonationMenu.add(new MenuItem("전체 기부금 내역", "/donationRegister/totalMoney"));
    DonationMenu.add(new MenuItem("모금함 개설신청", Menu.ENABLE_ORG, "/donationBoard/apply"));
    DonationMenu.add(new MenuItem("모금함목록","/commBoard/list"));
    DonationMenu.add(createDonationDetailMenu()); // 모금함 상세보기

    // 고객센터
    MenuGroup supportMenu = new MenuGroup("고객센터");
    mainMenuGroup.add(supportMenu);

    <<<<<<< HEAD
    supportMenu.add(createNoticeMenu());      // 공지사항
    supportMenu.add(createAskMenu());         // 문의하기
    =======
        reviewMenu.add(new MenuItem("등록", ACCESS_MEMBER, "/commBoard/add"));
    reviewMenu.add(new MenuItem("목록","/commBoard/list"));
    reviewMenu.add(new MenuItem("상세보기","/commBoard/detail"));
    reviewMenu.add(new MenuItem("변경", ACCESS_MEMBER,"/commBoard/update"));
    reviewMenu.add(new MenuItem("삭제",ACCESS_MEMBER,"/commBoard/delete"));
    >>>>>>> c86f356fd7204ec225289f45539cff031f5d1819

    // 마이페이지
    MenuGroup MyPageMenu = new MenuGroup("마이페이지");
    mainMenuGroup.add(MyPageMenu);

    MyPageMenu.add(createMyProfileMenu());    // 회원정보
    MyPageMenu.add(createMyVolunteerMenu());  // 나의봉사
    MyPageMenu.add(createMyBoardMenu());      // 나의게시글
    MyPageMenu.add(createMyPointMenu());      // 나의포인트
    MyPageMenu.add(createMyDonationMenu());   // 나의모금함
    MyPageMenu.add(createOrgApprovewMenu());  // 기관승인신청
    MyPageMenu.add(new MenuItem("탈퇴", Menu.ENABLE_MEMBER, "/MyPage/delete")); // 탈퇴

    <<<<<<< HEAD

    // 관리자
    MenuGroup adminMenu = new MenuGroup("관리자",  Menu.ENABLE_ADMIN);
    mainMenuGroup.add(adminMenu);
    =======
        shortReviewMenu.add(new MenuItem("등록", ACCESS_MEMBER, "/commReview/add"));
    shortReviewMenu.add(new MenuItem("목록", "/commReview/list")); 
    shortReviewMenu.add(new MenuItem("수정", ACCESS_MEMBER, "/commReview/update")); 
    shortReviewMenu.add(new MenuItem("삭제", ACCESS_MEMBER, "/commReview/delete")); 

    ////////////////////////////////////////////////////////////////////////////////////////////////

    //    MenuGroup ChallengeMenu = new MenuGroup("챌린지");
    //    mainMenuGroup.add(ChallengeMenu);
    //
    //    MenuGroup MonthlyChallengeMenu = new MenuGroup("이달의 챌린지");
    //    ChallengeMenu.add(MonthlyChallengeMenu);
    //
    //    MenuGroup MonthlyChallengeDetailMenu = new MenuGroup("챌린지 목록");
    //    MonthlyChallengeMenu.add(MonthlyChallengeDetailMenu);
    //
    //    MenuGroup MonthlyChallengeDetail1Menu1 = new MenuGroup("상세보기");
    //    MonthlyChallengeDetailMenu.add(createChallengeReviewMenu());
    //
    //    MenuGroup MonthlyChallengeDetail2Menu = new MenuGroup("참여하기");
    //    MonthlyChallengeDetailMenu.add(MonthlyChallengeDetail2Menu);
    //
    //    MenuGroup MonthlyChallengeDetail3Menu = new MenuGroup("참여자목록");
    //    MonthlyChallengeDetailMenu.add(MonthlyChallengeDetail3Menu);
    //
    //    MonthlyChallengeDetailMenu.add(createChallengeQuestionMenu());
    //    ChallengeMenu.add(createMonthlyRankingMenu());



    //        MenuGroup MonthlyRankingMenu = new MenuGroup("이달의 랭킹");
    //        ChallengeMenu.add(MonthlyRankingMenu);
    //        MenuGroup MonthlyRankingList = new MenuGroup("이달의 랭킹보기");
    //        MonthlyRankingMenu.add(MonthlyRankingList);
    //        MenuGroup MyRankingMenu = new MenuGroup("나의 랭킹보기");
    //        MonthlyRankingMenu.add(MyRankingMenu);
    >>>>>>> c86f356fd7204ec225289f45539cff031f5d1819

    adminMenu.add(createAdminMemberMenu());      // 회원관리
    adminMenu.add(createAdminDonationMenu());    // 기부관리
    adminMenu.add(createAdminVolMenu());         // 봉사관리
    // adminMenu.add(createAdminNoticeMenu());      // 공지사항관리
    // 관리자 공지사항 관리 => 회원 createNoticeMenu 부분과 기능 겹침. 삭제 고려
    adminMenu.add(createAdminAskMenu());         // 문의사항관리
    adminMenu.add(createAdminChallengeMenu());   // 챌린지관리
    adminMenu.add(createAdminApproveInfoMenu()); // 기관승인관리

    return mainMenuGroup;

    <<<<<<< HEAD
  }


  /////////////////////////////////////////////////////////////////////////////////////////



  private Menu createDoVolMenu() {
    MenuGroup doVolMenu = new MenuGroup("함께해요");
    =======
        MenuGroup monthlyChallengeDetail = new MenuGroup("챌린지 상세보기");
    monthlyChallengeMenu.add(monthlyChallengeDetail);
    monthlyChallengeDetail.add(new MenuItem("상세정보", "/showChallenge/detail"));  //챌린지 상세정보(구현예정)

    monthlyChallengeDetail.add(new MenuItem("참여하기", ACCESS_MEMBER, "/challengeJoin/join"));  //챌린지 참여하기(구현예정)
    monthlyChallengeDetail.add(new MenuItem("참여자 목록", ACCESS_MEMBER, "/challengeJoin/list"));  //챌린지 참여자목록(구현예정)

    MenuGroup ChallengeReview = new MenuGroup("참여인증&댓글");
    monthlyChallengeDetail.add(ChallengeReview);
    ChallengeReview.add(new MenuItem("참여인증&댓글 등록", ACCESS_MEMBER, "/challengeReview/add"));
    ChallengeReview.add(new MenuItem("참여인증&댓글 목록", "/challengeReview/list"));
    ChallengeReview.add(new MenuItem("참여인증&댓글 상세보기", ACCESS_MEMBER,"/challengeReview/detail"));
    ChallengeReview.add(new MenuItem("참여인증&댓글 수정", ACCESS_MEMBER,"/challengeReview/update"));
    ChallengeReview.add(new MenuItem("참여인증&댓글 삭제", ACCESS_MEMBER,"/challengeReview/delete"));
    ChallengeReview.add(new MenuItem("참여인증&댓글 검색", "/challengeReview/search"));


    MenuGroup ChallengeQuestion = new MenuGroup("문의하기");
    monthlyChallengeDetail.add(ChallengeQuestion);
    ChallengeQuestion.add(new MenuItem("문의 등록", ACCESS_MEMBER, "/challengeQuestion/add"));
    ChallengeQuestion.add(new MenuItem("문의 목록",  "/challengeQuestion/list"));
    ChallengeQuestion.add(new MenuItem("문의 상세보기", ACCESS_MEMBER, "/challengeQuestion/detail"));
    ChallengeQuestion.add(new MenuItem("문의 수정", ACCESS_MEMBER, "/challengeQuestion/update"));
    ChallengeQuestion.add(new MenuItem("문의 삭제", ACCESS_MEMBER, "/challengeQuestion/delete"));
    ChallengeQuestion.add(new MenuItem("문의 검색",  "/challengeQuestion/search"));


    MenuGroup monthlyRankingMenu = new MenuGroup("이달의 랭킹");
    personalChallengeMenu.add(monthlyRankingMenu);
    monthlyRankingMenu.add(new MenuItem("이달의 랭킹보기", "/ranking/list"));  //전체랭킹(구현예정)
    monthlyRankingMenu.add(new MenuItem("나의 랭킹보기", ACCESS_MEMBER, "/myRanking/list"));  //나의랭킹(구현예정)

    ////////////////////////////////////////////////////////////////////////////////////////////////
    >>>>>>> c86f356fd7204ec225289f45539cff031f5d1819

    doVolMenu.add(new MenuItem("개인봉사신청양식", Menu.ENABLE_PERSONAL,"/volRequestPersonal/apply"));
    //    doVolMenu.add(new MenuItem("기관봉사신청양식", Menu.ENABLE_ORG)); // 구현예정
    doVolMenu.add(new MenuItem("인증봉사리스트","/volRequestPersonal/appliedList")); // 개인만됨
    doVolMenu.add(new MenuItem("인증봉사세부사항",Menu.ENABLE_MEMBER,"/volRequestPersonal/appliedList"));
    doVolMenu.add(new MenuItem("찜하기",Menu.ENABLE_MEMBER,"/volRequestPersonal/bookmark")); // 구현예정

    <<<<<<< HEAD
    return doVolMenu;
  }
  =======
      personalDonationMenu.add(new MenuItem("전체 기부금 내역", "/donationRegister/totalMoney"));
  personalDonationMenu.add(new MenuItem("모금함 개설신청", ACCESS_ORG, "/donationBoard/apply"));
  >>>>>>> c86f356fd7204ec225289f45539cff031f5d1819

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

      <<<<<<< HEAD
      bestReviewMenu.add(new MenuItem("목록",Menu.ENABLE_ALL, "/commBest/list"));
      bestReviewMenu.add(new MenuItem("상세보기",Menu.ENABLE_ALL,"/commBest/detail"));

      return bestReviewMenu;
    }
    =======
        donation.add(new MenuItem("기부하기", ACCESS_MEMBER, "/donationRegister/add"));
    donation.add(new MenuItem("참여내역", "/donationRegister/participation"));

    ////////////////////////////////////////////////////////////////////////////////////////////////
    >>>>>>> c86f356fd7204ec225289f45539cff031f5d1819

      private Menu createShortReviewMenu() {
        MenuGroup shortReviewMenu = new MenuGroup("한 줄 후기");

        shortReviewMenu.add(new MenuItem("등록", Menu.ENABLE_MEMBER, "/commReview/add"));
        shortReviewMenu.add(new MenuItem("목록", Menu.ENABLE_ALL, "/commReview/list")); 
        shortReviewMenu.add(new MenuItem("변경", Menu.ENABLE_MEMBER, "/commReview/update")); 
        shortReviewMenu.add(new MenuItem("삭제", Menu.ENABLE_MEMBER, "/commReview/delete")); 

        return shortReviewMenu;
      }

      <<<<<<< HEAD
      //  private Menu createChallengeReviewMenu() {
      //    MenuGroup ChallengeReview = new MenuGroup("참여인증&댓글");
      //    ChallengeReview.add(new MenuItem("참여인증&댓글 등록", ACCESS_MEMBER, "/challengeReview/add"));
      //    ChallengeReview.add(new MenuItem("참여인증&댓글 목록", "/challengeReview/list"));
      //    ChallengeReview.add(new MenuItem("참여인증&댓글 상세보기", ACCESS_MEMBER,"/challengeReview/detail"));
      //    ChallengeReview.add(new MenuItem("참여인증&댓글 수정", ACCESS_MEMBER,"/chal12lengeReview/update"));
      //    ChallengeReview.add(new MenuItem("참여인증&댓글 삭제", ACCESS_MEMBER,"/challengeReview/delete"));
      //    ChallengeReview.add(new MenuItem("참여인증&댓글 검색", "/challengeReview/search"));
      //
      //    return ChallengeReview;
      //  }

      //  private Menu createChallengeQuestionMenu() {
      //    MenuGroup ChallengeQuestion = new MenuGroup("문의하기");
      //    ChallengeQuestion.add(new MenuItem("문의 등록", ACCESS_MEMBER, "/challengeQuestion/add"));
      //    ChallengeQuestion.add(new MenuItem("문의 목록",  "/challengeQuestion/list"));
      //    ChallengeQuestion.add(new MenuItem("문의 상세보기", ACCESS_MEMBER,"/challengeQuestion/detail"));
      //    ChallengeQuestion.add(new MenuItem("문의 수정", ACCESS_MEMBER, "/challengeQuestion/update"));
      //    ChallengeQuestion.add(new MenuItem("문의 삭제", ACCESS_MEMBER, "/challengeQuestion/delete"));
      //    ChallengeQuestion.add(new MenuItem("문의 검색",  "/challengeQuestion/search"));
      //
      //    return ChallengeQuestion;
      //  }
      //
      //  private Menu createMonthlyRankingMenu() {
      //    MenuGroup monthlyRankingMenu = new MenuGroup("이달의 랭킹");
      //    monthlyRankingMenu.add(new MenuItem("이달의 랭킹보기", "/ranking/list"));  //전체랭킹(구현예정)
      //    monthlyRankingMenu.add(new MenuItem("나의 랭킹보기", ACCESS_MEMBER, "/myRanking/list"));  //나의랭킹(구현예정)
      //
      //    return monthlyRankingMenu;
      //  }
      //  
      private Menu createDonationDetailMenu() {
        MenuGroup doDonationMenu = new MenuGroup("모금함 상세보기");

        doDonationMenu.add(new MenuItem("기부하기", Menu.ENABLE_MEMBER, "/donationRegister/add"));
        doDonationMenu.add(new MenuItem("참여내역", "/donationRegister/participation"));
        return doDonationMenu;
      }

      private Menu createNoticeMenu() {
        MenuGroup notice = new MenuGroup("공지사항");
        notice.add(new MenuItem("등록", Menu.ENABLE_ADMIN,"/notice/add"));
        =======
            >>>>>>> c86f356fd7204ec225289f45539cff031f5d1819
      notice.add(new MenuItem("목록", "/notice/list"));
      notice.add(new MenuItem("상세보기", "/notice/detail"));
      notice.add(new MenuItem("변경", ACCESS_ADMIN,"/notice/update"));
      notice.add(new MenuItem("삭제", ACCESS_ADMIN, "/notice/delete"));

      return notice;
      }

      <<<<<<< HEAD
      private Menu createAskMenu() {
        MenuGroup ask = new MenuGroup("문의하기");
        ask.add(new MenuItem("등록", Menu.ENABLE_MEMBER,"/question/add"));
        ask.add(new MenuItem("목록", "/question/list"));
        ask.add(new MenuItem("상세보기", "/question/detail"));
        ask.add(new MenuItem("변경",Menu.ENABLE_MEMBER,"/question/update"));
        ask.add(new MenuItem("삭제",Menu.ENABLE_MEMBER, "/question/delete"));

        return ask;
      }
      =======
          ask.add(new MenuItem("등록", ACCESS_MEMBER,"/question/add"));
      ask.add(new MenuItem("목록", "/question/list"));
      ask.add(new MenuItem("상세보기", "/question/detail"));
      ask.add(new MenuItem("변경", ACCESS_MEMBER,"/question/update"));
      ask.add(new MenuItem("삭제", ACCESS_MEMBER, "/question/delete"));

      ////////////////////////////////////////////////////////////////////////////////////////////////

      MenuGroup personalMyPage = new MenuGroup("마이페이지", ACCESS_MEMBER);
      mainMenuGroup.add(personalMyPage);

      >>>>>>> c86f356fd7204ec225289f45539cff031f5d1819

      // 마이페이지

      private Menu createMyProfileMenu() {
        MenuGroup myProfile = new MenuGroup("회원정보", Menu.ENABLE_MEMBER);
        myProfile.add(new MenuItem("내 정보", "/auth/displayUserInfo"));
        myProfile.add(new MenuItem("내 정보 수정", "/auth/changeUserInfo"));

        return myProfile;
      }

      <<<<<<< HEAD
      private Menu createMyVolunteerMenu() {
        MenuGroup myVolunteer = new MenuGroup("나의 봉사",Menu.ENABLE_MEMBER);
        =======
            MenuGroup myVolunteer = new MenuGroup("나의 봉사");
        personalMyPage.add(myVolunteer);
        >>>>>>> c86f356fd7204ec225289f45539cff031f5d1819

      myVolunteer.add(new MenuItem("나의 봉사신청서 확인",ACCESS_PERSONAL,"/volRequestPersonal/applyCompleteList")); // 보완필요
      myVolunteer.add(new MenuItem("나의 봉사신청서 확인",ACCESS_ORG,"/volRequestOrg/applyCompleteList")); // 보완필요
      myVolunteer.add(new MenuItem("승인된 봉사내역",ACCESS_PERSONAL,"/volRequestPersonal/appliedList"));    
      myVolunteer.add(new MenuItem("승인된 봉사내역",ACCESS_ORG,"/volRequestOrg/appliedList"));    
      myVolunteer.add(new MenuItem("반려된 봉사내역",ACCESS_PERSONAL,"/volRequestPersonal/rejectedList"));    
      myVolunteer.add(new MenuItem("반려된 봉사내역",ACCESS_ORG,"/volRequestOrg/rejectedList"));    
      myVolunteer.add(new MenuItem("찜한봉사",ACCESS_MEMBER,"/volRequestPersonal/bookmark")); // 구현예정

      <<<<<<< HEAD
      return myVolunteer;
      }

      private Menu createMyBoardMenu() {
        =======
            MenuGroup myDonation = new MenuGroup("나의 모금함");
        personalMyPage.add(myDonation);
        myDonation.add(new MenuItem("나의 모금함 개설신청서 확인", ACCESS_ORG, "/donationBoard/applyCompleteList")); 
        //    myDonation.add(new MenuItem("나의 기부내역", Menu.ENABLE_MEMBER, "/donationRegister/list")); // 구현예정


        myVolunteer.add(new MenuItem("찜한봉사","/volRequestPersonal/bookmark")); // 구현예정    

        >>>>>>> c86f356fd7204ec225289f45539cff031f5d1819
      MenuGroup myBoard = new MenuGroup("나의 게시글"); // 구현예정
      myBoard.add(new MenuItem("나의게시글 목록","/MyBoard/list"));
      myBoard.add(new MenuItem("나의게시글 상세보기","/MyBoard/detail"));
      myBoard.add(new MenuItem("나의게시글 수정","/MyBoard/update"));
      myBoard.add(new MenuItem("나의게시글 삭제","/MyBoard/delete"));

      return myBoard;
      }

      private Menu createMyPointMenu() {
        MenuGroup myPoint = new MenuGroup("나의 포인트"); // 구현예정
        myPoint.add(new MenuItem("나의포인트확인","MyPoint/list"));

        return myPoint;
      }

      <<<<<<< HEAD
      private Menu createMyDonationMenu() {
        MenuGroup myDonation = new MenuGroup("나의 모금함"); 
        myDonation.add(new MenuItem("나의 모금함 개설신청서 확인", Menu.ENABLE_ORG, "/donationBoard/applyCompleteList")); 
        //    myDonation.add(new MenuItem("나의 기부내역", Menu.ENABLE_MEMBER, "/donationRegister/list")); // 구현예정

        return myDonation;
      }

      private Menu createOrgApprovewMenu() {
        MenuGroup orgpprove = new MenuGroup("기관 승인 신청");

        orgpprove.add(new MenuItem("승인 요청하기","/OrgMyVol/apply"));
        orgpprove.add(new MenuItem("승인 현황보기","/OrgMyVol/approve"));

        return orgpprove;
      }

      //////////////////////////////////////////////////////////////////////////////////////////////////////////    

      // 관리자

      private Menu createAdminMemberMenu() {
        MenuGroup adminMemberMenu = new MenuGroup("회원정보 관리");

        adminMemberMenu.add(new MenuItem("회원목록", "/join/list"));
        adminMemberMenu.add(new MenuItem("가입회원 상세보기", "/join/detail"));
        adminMemberMenu.add(new MenuItem("회원추방","/adminMember/list"));
        =======
            MenuGroup organizationApprove = new MenuGroup("기관 승인 신청");
        personalMyPage.add(organizationApprove);

        organizationApprove.add(new MenuItem("승인 요청하기","/OrgMyVol/apply"));
        organizationApprove.add(new MenuItem("승인 현황보기","/OrgMyVol/approve"));


        personalMyPage.add(new MenuItem("탈퇴", ACCESS_MEMBER, "/MyPage/delete"));

        //////////////////////////////////////////////////////////////////////////////////////////////// 

        MenuGroup adminMenu = new MenuGroup("관리자",  ACCESS_ADMIN);
        mainMenuGroup.add(adminMenu);
        >>>>>>> c86f356fd7204ec225289f45539cff031f5d1819

      return adminMemberMenu;
      }

      private Menu createAdminDonationMenu() {
        MenuGroup adminDonationMenu = new MenuGroup("모금함 관리");

        <<<<<<< HEAD
        adminDonationMenu.add(new MenuItem("모금함 개설 신청내역 목록", "/donationBoard/applyList"));
        adminDonationMenu.add(new MenuItem("모금함 개설 신청내역", "/donationBoard/applyList"));
        adminDonationMenu.add(new MenuItem("모금함 개설 신청내역 상세보기", "/donationBoard/applyDetail"));
        adminDonationMenu.add(new MenuItem("모금함 개설 승인하기", "/donationBoard/acceptApply"));
        adminDonationMenu.add(new MenuItem("모금함 개설 반려하기", "/donationBoard/rejectApply"));

        return adminDonationMenu;
      }

      private Menu createAdminVolMenu() {
        MenuGroup adminVolMenu = new MenuGroup("봉사활동 관리");
        =======
            MenuGroup volunteerMenu = new MenuGroup("봉사활동 관리");
        adminMenu.add(volunteerMenu);

        volunteerMenu.add(new MenuItem("개인봉사신청내역","/volRequestPersonal/applyList"));
        volunteerMenu.add(new MenuItem("기관봉사신청내역","/volRequestOrg/applyList")); 
        volunteerMenu.add(new MenuItem("개인봉사승인하기","/volRequestPersonal/acceptApply"));
        volunteerMenu.add(new MenuItem("기관봉사승인하기","/volOrgPersonal/acceptApply")); 
        volunteerMenu.add(new MenuItem("개인봉사반려하기","/volRequestPersonal/rejectApply"));
        volunteerMenu.add(new MenuItem("기관봉사반려하기","/volOrgPersonal/rejectApply"));
        >>>>>>> c86f356fd7204ec225289f45539cff031f5d1819

        adminVolMenu.add(new MenuItem("개인봉사신청내역","/volRequestPersonal/applyList"));
        adminVolMenu.add(new MenuItem("기관봉사신청내역","/volRequestPersonal/bookmark")); // 구현예정
        adminVolMenu.add(new MenuItem("개인봉사승인하기","/volRequestPersonal/acceptApply"));
        adminVolMenu.add(new MenuItem("기관봉사승인하기","/volRequestPersonal/bookmark")); // 구현예정
        adminVolMenu.add(new MenuItem("개인봉사반려하기","/volRequestPersonal/rejectApply"));
        adminVolMenu.add(new MenuItem("기관봉사반려하기","/volRequestPersonal/bookmark")); // 구현예정

        return adminVolMenu;
      }

      // 관리자 공지사항 관리 => 회원 createNoticeMenu 부분과 기능 겹침. 삭제 고려
      //  private Menu createAdminNoticeMenu() {
      //    MenuGroup adminNoticeMenu = new MenuGroup("공지사항 관리");
      //
      //    adminNoticeMenu.add(new MenuItem("공지사항 등록","/adminNotice/add"));
      //    adminNoticeMenu.add(new MenuItem("공지사항 목록","/adminNotice/list"));
      //    adminNoticeMenu.add(new MenuItem("공지사항 상세보기","/adminNotice/detail"));
      //    adminNoticeMenu.add(new MenuItem("공지사항 변경","/adminNotice/update"));
      //    adminNoticeMenu.add(new MenuItem("공지사항 삭제","/adminNotice/delete"));
      //
      //    return adminNoticeMenu;
      //}

      private Menu createAdminAskMenu() {
        MenuGroup adminAskInfo = new MenuGroup("문의사항 관리");

        adminAskInfo.add(new MenuItem("문의사항 등록","/adminAsk/add"));
        adminAskInfo.add(new MenuItem("문의사항 목록","/adminAsk/add"));
        adminAskInfo.add(new MenuItem("문의사항 상세보기","/adminAsk/add"));
        adminAskInfo.add(new MenuItem("문의사항 변경","/adminAsk/add"));
        adminAskInfo.add(new MenuItem("문의사항 삭제","/adminAsk/add"));

        return adminAskInfo;
      }

      private Menu createAdminChallengeMenu() {
        MenuGroup adminChallengeInfo = new MenuGroup("챌린지 관리");

        adminChallengeInfo.add(new MenuItem("챌린지 등록","/adminChallenge/add"));
        adminChallengeInfo.add(new MenuItem("챌린지 목록","/adminChallenge/add"));
        adminChallengeInfo.add(new MenuItem("챌린지 상세보기","/adminChallenge/add"));
        adminChallengeInfo.add(new MenuItem("챌린지 변경","/adminChallenge/add"));
        adminChallengeInfo.add(new MenuItem("챌린지 삭제","/adminChallenge/add"));

        return adminChallengeInfo;
      }

      private Menu createAdminApproveInfoMenu() {
        MenuGroup adminApproveInfo = new MenuGroup("기관 승인");

        adminApproveInfo.add(new MenuItem("기관승인신청 목록","/adminChallenge/list"));
        adminApproveInfo.add(new MenuItem("기관승인신청 내용","/adminChallenge/detail"));
        adminApproveInfo.add(new MenuItem("기관승인신청 변경","/adminChallenge/update"));
        adminApproveInfo.add(new MenuItem("기관승인신청 삭제","/adminChallenge/delete"));

        return adminApproveInfo;
      }

      //  private Menu createChallengeReviewMenu() {
      //    MenuGroup ChallengeReview = new MenuGroup("참여인증&댓글");
      //    ChallengeReview.add(new MenuItem("참여인증&댓글 등록", ACCESS_MEMBER, "/challengeReview/add"));
      //    ChallengeReview.add(new MenuItem("참여인증&댓글 목록", "/challengeReview/list"));
      //    ChallengeReview.add(new MenuItem("참여인증&댓글 상세보기", ACCESS_MEMBER,"/challengeReview/detail"));
      //    ChallengeReview.add(new MenuItem("참여인증&댓글 수정", ACCESS_MEMBER,"/chal12lengeReview/update"));
      //    ChallengeReview.add(new MenuItem("참여인증&댓글 삭제", ACCESS_MEMBER,"/challengeReview/delete"));
      //    ChallengeReview.add(new MenuItem("참여인증&댓글 검색", "/challengeReview/search"));
      //
      //    return ChallengeReview;
      //  }
      //
      //  private Menu createChallengeQuestionMenu() {
      //    MenuGroup ChallengeQuestion = new MenuGroup("문의하기");
      //    ChallengeQuestion.add(new MenuItem("문의 등록", ACCESS_MEMBER, "/challengeQuestion/add"));
      //    ChallengeQuestion.add(new MenuItem("문의 목록",  "/challengeQuestion/list"));
      //    ChallengeQuestion.add(new MenuItem("문의 상세보기", ACCESS_MEMBER,"/challengeQuestion/detail"));
      //    ChallengeQuestion.add(new MenuItem("문의 수정", ACCESS_MEMBER, "/challengeQuestion/update"));
      //    ChallengeQuestion.add(new MenuItem("문의 삭제", ACCESS_MEMBER, "/challengeQuestion/delete"));
      //    ChallengeQuestion.add(new MenuItem("문의 검색",  "/challengeQuestion/search"));
      //
      //    return ChallengeQuestion;
      //  }
      //
      //  private Menu createMonthlyRankingMenu() {
      //    MenuGroup monthlyRankingMenu = new MenuGroup("이달의 랭킹");
      //    monthlyRankingMenu.add(new MenuItem("이달의 랭킹보기", "/ranking/list"));  //전체랭킹(구현예정)
      //    monthlyRankingMenu.add(new MenuItem("나의 랭킹보기", ACCESS_MEMBER, "/myRanking/list"));  //나의랭킹(구현예정)
      //
      //    return monthlyRankingMenu;
      //  }
}


