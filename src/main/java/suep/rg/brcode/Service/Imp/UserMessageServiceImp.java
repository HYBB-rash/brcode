package suep.rg.brcode.Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suep.rg.brcode.Dao.PaperMessageDao;
import suep.rg.brcode.Dao.UserDao;
import suep.rg.brcode.Dao.UserMessageDao;
import suep.rg.brcode.Entity.PaperMessage;
import suep.rg.brcode.Entity.User;
import suep.rg.brcode.Entity.UserMessage;
import suep.rg.brcode.Entity.send.VueBaseMessage;
import suep.rg.brcode.Service.UserMessageService;
import suep.rg.brcode.Utils.LoadUtils;

import java.io.IOException;

@Service
public class UserMessageServiceImp implements UserMessageService {

    @Autowired
    UserMessageDao userMessageDao;
    @Autowired
    UserDao userDao;
    @Autowired
    PaperMessageDao paperMessageDao;

    @Override
    public byte[] getUserIcon(Integer userId) throws IOException {
        UserMessage userMessageById = userMessageDao.findUserMessageById(userId);
        return LoadUtils.load(userMessageById.getIcon());
    }

    @Override
    public String getUsername(Integer userId) {
        User user = userDao.findUserById(userId);
        return user.getUsername();
    }

    @Override
    public Integer getUserId(Integer paperId) {
        PaperMessage paperMessage = paperMessageDao.findPaperMessageByPaperId(paperId);
        return paperMessage.getUserId();
    }

    @Override
    public VueBaseMessage getUserBaseMessage(Integer userId) {
        User user = userDao.findUserById(userId);
        UserMessage userMessage = userMessageDao.findUserMessageById(userId);
        return LoadUtils.load(user, userMessage);
    }

    @Override
    public String getUserInstruction(Integer userId) {
        return userMessageDao.findUserMessageById(userId).getInstruction();
    }
}
