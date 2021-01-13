package suep.rg.brcode.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import suep.rg.brcode.Entity.User;
import suep.rg.brcode.Result.Result;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/api")
public interface LoginController {

    public Result login(@RequestBody User user, HttpSession session);
    public Result logout();
    public Result regis(@RequestBody User user);
    public String authentication();
}
