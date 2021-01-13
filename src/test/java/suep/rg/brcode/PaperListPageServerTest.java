package suep.rg.brcode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import suep.rg.brcode.Entity.send.VuePaperItem;
import suep.rg.brcode.Service.PaperListPageService;

import java.util.List;

@SpringBootTest
public class PaperListPageServerTest {

    @Autowired
    PaperListPageService paperListPageService;

    @Test
    void testGetPaperListSortByTime() {
        List<VuePaperItem> paperListSortByTime = paperListPageService.getPaperListSortByTime(1, 3);
        System.out.println(paperListSortByTime);
    }

    @Test
    void testGetPaperListSortByTimeAndUserId() {
        List<VuePaperItem> paperListSortByTime = paperListPageService.getPaperListSortByTime(2, 0, 3);
        System.out.println(paperListSortByTime);
    }
}
