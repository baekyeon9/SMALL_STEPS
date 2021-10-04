package practicemakesperfect.practiceappclient.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import com.share.ftp.Prompt;

//역할
//- 다른 메뉴를 포함하는 컨테이너 역할을 수행한다.
//

public class MenuGroup extends Menu{

  // 메뉴의 bread crumb 목록 보관
  // 모든 메뉴가 공유할 객체이기 때문에 스태틱 멤버로 선언한다.

  static Stack<Menu> breadCrumb = new Stack<>();

  ArrayList<Menu> childs = new ArrayList<>();

  boolean disablePrevMenu;
  String prevMenuTitle = "이전 메뉴";

  // 메뉴 목록을 출력할 때 출력여부를 결정할 객체를 보관한다.
  MenuFilter menuFilter;



  // 이전으로 이동시키는 메뉴를 표현하기 위해 만든 클래스
  private static class PrevMenu extends Menu {
    public PrevMenu() {
      super("");
    }

    @Override
    public void execute() {

    }
  }

  static PrevMenu prevMenu = new PrevMenu();

  public MenuGroup(String title) {
    super(title);
  }

  public MenuGroup (String title, int accessScope) {
    super(title, accessScope);
  }

  public MenuGroup (String title, boolean discablePrevMenu) {
    super(title);
    this.disablePrevMenu = discablePrevMenu;
  }

  public MenuGroup (String title, boolean discablePrevMenu, int accessScope) {
    super(title, accessScope);
    this.disablePrevMenu = discablePrevMenu;
  }

  public void setPrevMenuTitle(String prevMenuTitle) {
    this.prevMenuTitle = prevMenuTitle;
  }

  public void sestMenuFilter(MenuFilter menuFilter) {
    this.menuFilter = menuFilter;
  }

  // MenuGroup이 포함하는 하위 Menu를 다룰 수 있도록 메서드를 정의한다.
  public void add (Menu child) {
    childs.add(child) ; 
  }

  // 배열에 들어있는 Menu객체를 찾아 제거한다.

  public Menu remove(Menu child) {
    if(childs.remove(child))
      return child;
    return null;
  }

  @Override
  public void execute() {

    // 현재 실행하는 메뉴를 스택에 보관한다.
    breadCrumb.push(this);

    while (true) {
      printBreadCrumbMenuTitle();
      List<Menu> menuList = getMenuList();
      printMenuList(menuList);

      try {
        Menu menu = selectMenu(menuList);
        if (menu == null) {
          System.out.println("무효한 메뉴 번호입니다.");
          continue;
        }
        if (menu instanceof PrevMenu) {
          breadCrumb.pop();
          return;
        }

        menu.execute();
      } catch (Exception e) {
        System.out.println("--------------------------------------------------------------");
        System.out.printf("오류 발생: %s\n", e.getClass().getName());
        e.printStackTrace();
        System.out.println("--------------------------------------------------------------");
      }
    }
  }

  private String getBreadCrumb() {
    String path = "";

    for (int i = 0; i < breadCrumb.size(); i++) {
      if (path.length() > 0) {
        path += " / ";
      }
      Menu menu = breadCrumb.get(i);
      path += menu.title;
    }
    return path;
  }

  // 출력될 메뉴 목록 준비
  // 왜?
  // - 메뉴 출력 속도를 빠르게 하기 위함.
  // - 메뉴를 출력할 때 출력할 메뉴와 출력하지 말아야할 메뉴를 구분하는 시간을 줄인다.

  private List<Menu> getMenuList() {
    ArrayList<Menu> menuList = new ArrayList<>();
    for (Menu menu : childs) {
      if (menuFilter != null && !menuFilter.accept(menu)) {
        // 메뉴 필터가 있을 때, 그 메뉴 필터에서 승인하지 않는다면
        // 출력할 메뉴에 포함시키지 않는다.
        continue;
      }
      menuList.add(menu);

    }
    return menuList;
  }

  private void printBreadCrumbMenuTitle() {
    System.out.printf("\n[%s]\n", getBreadCrumb());
  }  

  private void printMenuList(List<Menu> menuList) {
    int i = 1;
    for (Menu menu : menuList) {
      System.out.printf("%d. %-20s\n", i++, menu.title);
    }

    if (!disablePrevMenu) {
      System.out.printf("0. %s\n", this.prevMenuTitle);

    }
  }

  private Menu selectMenu(List<Menu> menuList) {
    int menuNo = Prompt.inputInt("선택> ");

    if (menuNo <  0 || menuNo > menuList.size()) {
      return null;
    }

    if (menuNo == 0 && !disablePrevMenu) {
      return prevMenu;
    }

    return menuList.get(menuNo -1);
  }

}