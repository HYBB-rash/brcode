package suep.rg.brcode.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import suep.rg.brcode.Entity.rev.IPV4;
import suep.rg.brcode.Result.Result;

@Controller
@RequestMapping(value = "/api")
public interface ClickPaperController {

    /**
     * 用户点击文章，服务器返回文章的内容，记录下IP地址已经浏览
     * @param paperId 文章的ID
     * @param ipv4 点击的人的IP地址
     * @return 文章内容的打包,结构是VuePaper
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/paper/{paperId}", method = RequestMethod.POST)
    public Result watchPaper(@PathVariable Integer paperId, @RequestBody IPV4 ipv4);


    /**
     * 发送一个paperId，获取点赞数
     * @param paperId 文章的ID
     * @return 一个数字，文章的点赞数即可
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/paper/love/{paperId}", method = RequestMethod.GET)
    public Result getLove(@PathVariable Integer paperId);

    /**
     * 发送用户的ID，发送文章的ID，确认这个用户有没有给这个用户点赞
     * @param paperId 文章的ID
     * @param userId 用户的ID
     * @return 一个bool值，true是点赞了，false是没点赞
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/paper/love/{paperId}/{userId}", method = RequestMethod.GET)
    public Result ensureHaveLove(@PathVariable Integer paperId, @PathVariable Integer userId);

    /**
     * 点赞该文章，通过用户的ID和文章的ID
     * @param paperId 文章的ID
     * @param userId 用户的ID
     * @return 一个bool值，true是点赞成功了，false是没点赞成功
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/paper/love/like/{paperId}/{userId}")
    public Result loveThisPaper(@PathVariable Integer paperId, @PathVariable Integer userId);

    /**
     * 返回该文章的所有评论
     * @param paperId 文章的ID
     * @return 根据VueComment进行打包
     */
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/paper/comment/{paperId}")
    public Result getPaperComment(@PathVariable Integer paperId);
}
