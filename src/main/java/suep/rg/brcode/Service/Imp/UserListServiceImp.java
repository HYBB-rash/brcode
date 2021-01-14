package suep.rg.brcode.Service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import suep.rg.brcode.Dao.UserDao;
import suep.rg.brcode.Dao.UserMessageDao;
import suep.rg.brcode.Entity.User;
import suep.rg.brcode.Entity.UserMessage;
import suep.rg.brcode.Entity.send.VueUserItem;
import suep.rg.brcode.Service.UserListService;
import suep.rg.brcode.Utils.LoadUtils;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserListServiceImp implements UserListService {

    @Autowired
    UserDao userDao;
    @Autowired
    UserMessageDao userMessageDao;

    private Page<UserMessage> getUserList(Integer index, Integer size, String order) {
        Pageable pageable = PageRequest.of(index, size, Sort.by(order).descending());
        return userMessageDao.findAll(pageable);
    }

    private List<VueUserItem> load(Page<UserMessage> userMessages) {
        List<VueUserItem> list = new LinkedList<>();
        for (UserMessage userMessage : userMessages) {
            User user = userDao.findUserById(userMessage.getId());
            VueUserItem vueUserItem = LoadUtils.pick(user, userMessage);
            list.add(vueUserItem);
        }
        return list;
    }

    @Override
    public List<VueUserItem> getUserListSortByLove(Integer index, Integer size) {
        Page<UserMessage> love = getUserList(index, size, "love");
        return load(love);
    }

    @Override
    public List<VueUserItem> getUserListSortByWatch(Integer index, Integer size) {
        Page<UserMessage> watch = getUserList(index, size, "watch");
        return load(watch);
    }
}
