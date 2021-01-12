package suep.rg.brcode.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import suep.rg.brcode.Entity.rev.UserIdAndPaperId;
import suep.rg.brcode.Entity.send.VueEditPaper;
import suep.rg.brcode.Result.Result;

@Controller
public interface EditPaperController {

    /**
     * 用户点击修改文章时，根据用户ID和文章ID查出文章内容发送回去
     * @param id 包含用户的ID和文章的ID
     * @return 根据VueEditPaper结构打包发送
     */
    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/GetPaperContent")
    public Result getPaperContent(@RequestBody UserIdAndPaperId id);

    /**
     * 用户提交文章，后端将文章信息保存下来
     * @param paper VueEditPaper结构有啥就是啥
     * @return 返回一个成功信息即可
     */
    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/SavePaperContent")
    public Result savePaper(@RequestBody VueEditPaper paper);

    /**
     * 用户提交文章，后端将文章信息保存下来，并且文章状态更新为已发布
     * @param paper VueEditPaper结构有啥就是啥
     * @return 返回一个成功信息即可
     */
    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/SavePaperContentAndSend")
    public Result savaPaperAndSend(@RequestBody VueEditPaper paper);
}
