package suep.rg.brcode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import suep.rg.brcode.Entity.send.VuePaper;
import suep.rg.brcode.Service.EditPaperService;

@SpringBootTest
public class EditPaperServiceTests {

    @Autowired
    EditPaperService editPaperService;

    @Test
    void testGetPaperContent() {
        System.out.println(editPaperService.getPaperContent(2, 2));
    }

    @Test
    void saveNewPaper() {
        VuePaper paper = new VuePaper();
        paper.setTitle("demo");
        paper.setContent("demodmeodemodemodmoe");
        System.out.println(editPaperService.savePaper(paper, 2));
    }

    @Test
    void savePaper() {
        VuePaper paperContent = editPaperService.getPaperContent(2, 8);
        paperContent.setContent("hahahahaha");
        System.out.println(editPaperService.savePaper(paperContent, 2));
    }
}
