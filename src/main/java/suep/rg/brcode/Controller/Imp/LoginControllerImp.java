package suep.rg.brcode.Controller.Imp;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;
import suep.rg.brcode.Controller.LoginController;
import suep.rg.brcode.Entity.User;
import suep.rg.brcode.Result.Result;
import suep.rg.brcode.Result.ResultFactory;
import suep.rg.brcode.Service.UserService;

import javax.servlet.http.HttpSession;

@Controller
public class LoginControllerImp implements LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "/login")
    @ResponseBody
    @Override
    public Result login(User user, HttpSession session) {
        String username = user.getUsername();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, user.getPassword());
        usernamePasswordToken.setRememberMe(true);
        try {
            subject.login(usernamePasswordToken);
            int id = userService.getUserId(user.getUsername());
            session.setAttribute("user", id);
            System.out.println(id);
            return ResultFactory.buildSuccessResult(id);
        }catch (AuthenticationException e) {
            String message = "账号密码错误";
            return ResultFactory.buildFailResult(message);
        }
    }

    @CrossOrigin
    @PostMapping(value = "/logout")
    @ResponseBody
    @Override
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        String message = "logout success";
        return ResultFactory.buildSuccessResult(message);
    }

    @CrossOrigin
    @PostMapping(value = "/regis")
    @ResponseBody
    @Override
    public Result regis(User user) {
        String Username = user.getUsername();
        String Password = user.getPassword();
        Username = HtmlUtils.htmlEscape(Username);
        user.setUsername(Username);

        boolean exit = userService.isExist(Username);
        if (exit) {
            String message = "用户名已被使用";
            return ResultFactory.buildFailResult(message);
        }

        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        String encodePassword = new SimpleHash("md5", Password, salt, times).toString();
        user.setSalt(salt);
        user.setPassword(encodePassword);
        userService.add(user);

        return ResultFactory.buildSuccessResult(user);
    }

    @CrossOrigin
    @PostMapping(value = "/authentication")
    @ResponseBody
    @Override
    public String authentication() {
        return "success";
    }
}
