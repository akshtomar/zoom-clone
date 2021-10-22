package com.mountblue.zoom.controller;

import com.mountblue.zoom.entity.User;
import com.mountblue.zoom.service.LoginService;
import io.openvidu.java.client.OpenViduRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class LoginController {

    public static Map<String, MyUser> users = new ConcurrentHashMap<>();


    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService){
        this.loginService=loginService;
    }

    @RequestMapping(value = "/")
    public String logout(HttpSession httpSession) {
        List<User> userList=loginService.getListOfUsers();
        for(User user:userList){
            users.put(user.getEmail(),new MyUser(user.getEmail(),user.getPassword(),OpenViduRole.PUBLISHER));
        }
        if (checkUserLogged(httpSession)) {
            return "redirect:/dashboard";
        } else {
            httpSession.invalidate();
            return "index";
        }
    }

    @RequestMapping(value = "/dashboard", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(@RequestParam(name = "user", required = false) String user,
                        @RequestParam(name = "pass", required = false) String pass, Model model, HttpSession httpSession) {
        String userName = (String) httpSession.getAttribute("loggedUser");
        if (userName != null) {
            model.addAttribute("username", userName);
            return "dashboard";
        }

        if (login(user, pass)) {
            httpSession.setAttribute("loggedUser", user);
            model.addAttribute("username", user);
            return "dashboard";
        } else {
            httpSession.invalidate();
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(Model model, HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }

    private boolean login(String user, String pass) {
        return (user != null && pass != null && users.containsKey(user) && users.get(user).pass.equals(pass));
    }

    private boolean checkUserLogged(HttpSession httpSession) {
        return !(httpSession == null || httpSession.getAttribute("loggedUser") == null);
    }

    public class MyUser {
        String name;
        String pass;
        OpenViduRole role;

        public MyUser(String name, String pass, OpenViduRole role) {
            this.name = name;
            this.pass = pass;
            this.role = role;
        }
    }
}