package suep.rg.brcode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import suep.rg.brcode.Entity.rev.IPV4;
import suep.rg.brcode.Entity.send.VueComment;
import suep.rg.brcode.Entity.send.VuePaper;
import suep.rg.brcode.Service.ClickPaperService;

import java.util.List;

@SpringBootTest
class BrcodeApplicationTests {

    @Autowired
    ClickPaperService clickPaperService;

    @Test
    void contextLoads() {
        IPV4 ipv4 = new IPV4();
        ipv4.setIp("127.0.0.1");
        clickPaperService.recordWatch(ipv4, 2);
    }

    @Test
    void textGetPaper() {
        VuePaper paper = clickPaperService.getPaper(2);
        System.out.println(paper);
    }

    @Test
    void testGetLoveCount() {
        Integer loveCount = clickPaperService.getLoveCount(2);
        System.out.println(loveCount);
    }

    @Test
    void testEnsureHaveLove() {
        Boolean haveLove = clickPaperService.ensureHaveLove(2, 3);
        System.out.println(haveLove);
    }

    @Test
    void testLoveThisPaper() {
        Boolean aBoolean = clickPaperService.loveThisPaper(2, 3);
        System.out.println(aBoolean);
    }

    @Test
    void testGetPaperComments() {
        List<VueComment> paperComments = clickPaperService.getPaperComments(2);
        System.out.println(paperComments);
    }
}
