package suep.rg.brcode.Service;

import org.springframework.stereotype.Service;
import suep.rg.brcode.Entity.send.VueBaseMessage;

import java.io.IOException;

@Service
public interface UserMessageService {

    /**
     * 根据userId返回图像，加载成二进制流
     * 例子：
     * public byte[] getImage() throws IOException {
     *         File file = new File("D:/test.jpg");
     *         FileInputStream inputStream = new FileInputStream(file);
     *         byte[] bytes = new byte[inputStream.available()];
     *         inputStream.read(bytes, 0, inputStream.available());
     *         return bytes;
     *     }
     * @param userId 用户ID
     * @return 二进制数组
     */
    public byte[] getUserIcon(Integer userId) throws IOException;

    /**
     * 根据用户ID返回用户的姓名
     * @param userId 用户ID
     * @return string，用户的名字即可
     */
    public String getUsername(Integer userId);

    /**
     * 根据文章的ID找到用户的ID
     * @param paperId 文章ID
     * @return Integer 用户的ID即可
     */
    public Integer getUserId(Integer paperId);

    /**
     * 根据userID返回user的基础信息
     * @param userId 用户id
     * @return 根据VueBaseMessage打包
     */
    public VueBaseMessage getUserBaseMessage(Integer userId);

    /**
     * 根据userId找到user的instruction介绍
     * @param userId 用户ID
     * @return String即可，instruction的内容
     */
    public String getUserInstruction(Integer userId);
}
