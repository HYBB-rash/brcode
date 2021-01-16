package suep.rg.brcode.Controller.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import suep.rg.brcode.Controller.EditPaperController;
import suep.rg.brcode.Entity.rev.UserIdAndPaperId;
import suep.rg.brcode.Entity.send.VuePaper;
import suep.rg.brcode.Result.Result;
import suep.rg.brcode.Result.ResultFactory;
import suep.rg.brcode.Service.EditPaperService;

@Controller
public class EditPaperControllerImp implements EditPaperController {

    @Autowired
    EditPaperService editPaperService;

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/GetPaperContent")
    @Override
    public Result getPaperContent(@RequestBody UserIdAndPaperId id) {
        VuePaper paper = editPaperService.getPaperContent(id.getUserId(), id.getPaperId());
        return ResultFactory.buildSuccessResult(paper);
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/SavePaperContent/{userId}")
    @Override
    public Result savePaper(@RequestBody VuePaper paper, @PathVariable Integer userId) {
        Boolean savePaper = editPaperService.savePaper(paper, userId);
        return ResultFactory.buildSuccessResult(savePaper);
    }

    @CrossOrigin
    @ResponseBody
    @PostMapping(value = "/SavePaperContentAndSend/{userId}")
    @Override
    public Result savePaperAndSend(@RequestBody VuePaper paper, @PathVariable Integer userId) {
        Boolean savePaperAndSent = editPaperService.savePaperAndSent(paper, userId);
        return ResultFactory.buildSuccessResult(savePaperAndSent);
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "/Delete/paper/{paperId}")
    public Result deletePaper(@PathVariable Integer paperId) {
        Boolean deletePaper = editPaperService.deletePaper(paperId);
        return ResultFactory.buildSuccessResult(deletePaper);
    }
}
