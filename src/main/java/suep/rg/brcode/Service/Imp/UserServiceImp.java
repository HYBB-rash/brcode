package suep.rg.brcode.Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import suep.rg.brcode.Dao.UserDao;
import suep.rg.brcode.Entity.User;
import suep.rg.brcode.Service.UserService;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserDao userDao;

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
        userDao.save(user);
    }

    @Override
    public int getUserId(String username) {
        return 0;
    }
}
