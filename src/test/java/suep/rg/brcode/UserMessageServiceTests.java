package suep.rg.brcode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import suep.rg.brcode.Service.UserMessageService;

import java.io.IOException;

@SpringBootTest
public class UserMessageServiceTests {

    @Autowired
    UserMessageService userMessageService;

    @Test
    void testGetUserIcon() throws IOException {
        byte[] userIcon = userMessageService.getUserIcon(2);
        for (byte b : userIcon) System.out.println(b);
    }

    @Test
    void testGetUsername() {
        System.out.println(userMessageService.getUsername(2));
    }

    @Test
    void testGetUserId() {
        System.out.println(userMessageService.getUserId(3));
    }

    @Test
    void testGetUserBaseMessage() {
        System.out.println(userMessageService.getUserBaseMessage(2));
    }

    @Test
    void testGetUserInstruction() {
        System.out.println(userMessageService.getUserInstruction(2));
    }
}
