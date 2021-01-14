package suep.rg.brcode.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import suep.rg.brcode.Result.Result;

@Controller
@RequestMapping(value = "/api")
public interface PageCountController {

    public Result getPaperCount();
    public Result getPaperCount(Integer userId);
}
