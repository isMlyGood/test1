package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Controller
public class ControllerTest {
    @RequestMapping(value = "/success",method = RequestMethod.GET)
    public String getTest(){
        System.out.println("测试1");
        return "test";
    }
    @RequestMapping(value = "/success",method = RequestMethod.POST)
    public String postTest(){
        System.out.println("测试2");
        return "test";
    }

    @RequestMapping(value = "/active",method = RequestMethod.POST)
    public String postTest(@RequestParam(value = "username") String name, HttpSession httpSession){
        String id = httpSession.getId();
        System.out.println(id);
        return "test";
    }

    @RequestMapping(value = "/modelandview",method = RequestMethod.POST)
    public ModelAndView modelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username","测试");
        modelAndView.setViewName("test");
        return modelAndView;
    }
}
