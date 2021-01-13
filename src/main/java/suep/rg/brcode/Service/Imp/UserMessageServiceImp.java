package suep.rg.brcode.Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suep.rg.brcode.Dao.UserMessageDao;
import suep.rg.brcode.Entity.send.VueBaseMessage;
import suep.rg.brcode.Service.UserMessageService;

@Service
public class UserMessageServiceImp implements UserMessageService {

    @Autowired
    UserMessageDao userMessageDao;

    @Override
    public byte[] getUserIcon(Integer userId) {

        return new byte[0];
    }

    @Override
    public String getUsername(Integer userId) {
        return null;
    }

    @Override
    public String getUserId(Integer paperId) {
        return null;
    }

    @Override
    public VueBaseMessage getUserBaseMessage(Integer userId) {
        return null;
    }

    @Override
    public String getUserInstruction(Integer userId) {
        return null;
    }
}
