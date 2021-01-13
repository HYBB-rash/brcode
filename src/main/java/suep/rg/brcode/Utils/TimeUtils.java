package suep.rg.brcode.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

    public static String getNowTime (){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return simpleDateFormat.format(date);
    }
}
