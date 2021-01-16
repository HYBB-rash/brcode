package suep.rg.brcode.Controller.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import suep.rg.brcode.Controller.UserMessageController;
import suep.rg.brcode.Dao.UserMessageDao;
import suep.rg.brcode.Entity.UserMessage;
import suep.rg.brcode.Entity.send.VueBaseMessage;
import suep.rg.brcode.Result.Result;
import suep.rg.brcode.Result.ResultFactory;
import suep.rg.brcode.Service.UserMessageService;

@Controller
public class UserMessageControllerImp implements UserMessageController {

    @Autowired
    UserMessageService userMessageService;

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/UserMessage/icon/{userId}")
    @Override
    public Result getUserIcon(@PathVariable Integer userId) {
        return ResultFactory.buildSuccessResult(userMessageService.getUserIcon(userId));
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/UserMessage/username/{userId}")
    @Override
    public Result getUsername(@PathVariable Integer userId) {
        String username = userMessageService.getUsername(userId);
        return ResultFactory.buildSuccessResult(username);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/UserMessage/{paperId}")
    @Override
    public Result getUserId(@PathVariable Integer paperId) {
        Integer userId = userMessageService.getUserId(paperId);
        return ResultFactory.buildSuccessResult(userId);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/UserMessage/base/{userId}")
    @Override
    public Result getUserBaseMessage(@PathVariable Integer userId) {
        VueBaseMessage userBaseMessage = userMessageService.getUserBaseMessage(userId);
        return ResultFactory.buildSuccessResult(userBaseMessage);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/UserMessage/instruction/{userId}")
    @Override
    public Result getUserInstruction(@PathVariable Integer userId) {
        String userInstruction = userMessageService.getUserInstruction(userId);
        return ResultFactory.buildSuccessResult(userInstruction);
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/UserMessage/edit/{userId}")
    @Override
    public Result getUserMessage(@PathVariable Integer userId) {
        UserMessage userMessage = userMessageService.getUserMessageByUserId(userId);
        return ResultFactory.buildSuccessResult(userMessage);
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/UserMessage/save")
    @Override
    public Result saveUserMessage(@RequestBody UserMessage userMessage) {
        Boolean result = userMessageService.saveUserMessage(userMessage);
        return ResultFactory.buildSuccessResult(result);
    }
}
