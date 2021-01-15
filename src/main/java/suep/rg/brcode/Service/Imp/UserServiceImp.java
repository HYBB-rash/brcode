package suep.rg.brcode.Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suep.rg.brcode.Dao.UserDao;
import suep.rg.brcode.Dao.UserMessageDao;
import suep.rg.brcode.Entity.User;
import suep.rg.brcode.Entity.UserMessage;
import suep.rg.brcode.Service.UserService;
import suep.rg.brcode.Utils.LoadUtils;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    UserMessageDao userMessageDao;

    @Override
    public boolean isExist(String username) {
        return null != getByName(username);
    }

    @Override
    public User get(String username, String password) {
        return userDao.getByUsernameAndPassword(username, password);
    }

    @Override
    public User getByName(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public void add(User user) {
        User save = userDao.save(user);
        UserMessage userMessage = LoadUtils.initUserMessage(save.getId());
        userMessageDao.save(userMessage);
    }

    @Override
    public int getUserId(String username) {
        User user = userDao.findByUsername(username);
        return user.getId();
    }
}
