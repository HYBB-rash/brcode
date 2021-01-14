package suep.rg.brcode.Service;

import org.springframework.stereotype.Service;
import suep.rg.brcode.Entity.send.VueUserItem;

import java.util.List;

@Service
public interface UserListService {

    public List<VueUserItem> getUserListSortByLove(Integer index, Integer size);
    public List<VueUserItem> getUserListSortByWatch(Integer index, Integer size);
}
