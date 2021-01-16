package suep.rg.brcode.Controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import suep.rg.brcode.Entity.UserMessage;
import suep.rg.brcode.Result.Result;

@Controller
@RequestMapping(value = "/api")
public interface UserMessageController {

    /**
     * 根据userId返回图像，加载成二进制
     * @param userId 用户ID
     * @return 二进制数组
     */

    public Result getUserIcon(@PathVariable Integer userId);

    /**
     * 根据用户ID返回用户的姓名
     * @param userId 用户ID
     * @return string，用户的名字即可
     */

    public Result getUsername(@PathVariable Integer userId);

    /**
     * 根据文章的ID找到用户的ID
     * @param paperId 文章ID
     * @return Integer 用户的ID即可
     */

    public Result getUserId(@PathVariable Integer paperId);

    /**
     * 根据userID返回user的基础信息
     * @param userId 用户id
     * @return 根据VueBaseMessage打包
     */

    public Result getUserBaseMessage(@PathVariable Integer userId);

    /**
     * 根据userId找到user的instruction介绍
     * @param userId 用户ID
     * @return String即可，instruction的内容
     */

    public Result getUserInstruction(@PathVariable Integer userId);

    public Result getUserMessage(@PathVariable Integer userId);

    public Result saveUserMessage(@RequestBody UserMessage userMessage);
}
