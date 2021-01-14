package suep.rg.brcode.Controller.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import suep.rg.brcode.Controller.UserListController;
import suep.rg.brcode.Entity.send.VueUserItem;
import suep.rg.brcode.Result.Result;
import suep.rg.brcode.Result.ResultFactory;
import suep.rg.brcode.Service.UserListService;

import java.util.List;

@Controller
public class UserListControllerImp implements UserListController {

    @Autowired
    UserListService userListService;

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/UserList/watch")
    @Override
    public Result userListSortByWatch(Integer index, Integer size) {
        List<VueUserItem> userList = userListService.getUserListSortByWatch(index, size);
        return ResultFactory.buildSuccessResult(userList);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/UserList/love")
    @Override
    public Result userListSortByLove(Integer index, Integer size) {
        List<VueUserItem> userList = userListService.getUserListSortByLove(index, size);
        return ResultFactory.buildSuccessResult(userList);
    }
}
