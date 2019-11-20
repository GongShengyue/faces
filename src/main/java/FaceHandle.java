import java.io.File;
import java.math.BigDecimal;

/**
 * @Authour:gsy
 * @Description: 人脸接口
 * @Date: 8:04 PM 2019/11/15
 */
public interface FaceHandle {

    /**
    * @description: 获取图片的token值
    * @params:
    * @return :String
    * @author :gongshengyue
    * @date 2019-11-15 20:05
    */
    String get_token(File file,String apiKey,String apiSecret);

    /**
    * @description: 获取图片比较的相似度
    * @params:
    * @return : double
    * @author :gongshengyue
    * @date 2019-11-15 20:08
    */
    BigDecimal get_ressemble(String apikey, String apiSecret, String tokenLocal, String tokenImg);



}
