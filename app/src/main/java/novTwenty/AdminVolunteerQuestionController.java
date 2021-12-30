package novTwenty;

import javax.servlet.ServletContext;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.share.ftp.dao.VolunteerDao;

@Controller
@RequestMapping("/admin/volunteer/question")
@SessionAttributes("loginUser")
public class AdminVolunteerQuestionController {

  private static final Logger logger = LogManager.getLogger(AdminVolunteerQuestionController.class);

  @Autowired SqlSessionFactory sqlSessionFactroy;
  @Autowired ServletContext sc;
  @Autowired VolunteerDao volunteerDao;

  @PostMapping("add")
  public ModelAndView add() {
    ModelAndView mv = new ModelAndView();
    return mv;
  }

  @GetMapping("list")
  public ModelAndView list() {
    ModelAndView mv = new ModelAndView();
    return mv;
  }

  @GetMapping("detail")
  public ModelAndView detail() {
    ModelAndView mv = new ModelAndView();
    return mv;
  }

  @GetMapping("update")
  public ModelAndView update() {
    ModelAndView mv = new ModelAndView();
    return mv;
  }

  @GetMapping("delete")
  public ModelAndView delete() {
    ModelAndView mv = new ModelAndView();
    return mv;
  }


}
