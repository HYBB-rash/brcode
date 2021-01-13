package suep.rg.brcode.Service;

import org.springframework.stereotype.Service;
import suep.rg.brcode.Entity.User;

@Service
public interface UserService {

    public boolean isExist(String username);
    public User get(String username, String password);
    public User getByName(String username);
    public void add(User user);
    public int getUserId(String username);

}
