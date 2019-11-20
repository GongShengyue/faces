import org.bytedeco.javacv.FrameGrabber;

import java.io.File;
import java.math.BigDecimal;
import java.util.Timer;

/**
 * @Authour:gsy
 * @Description:
 * @Date: 5:55 PM 2019/11/15
 */
public class test {

    public static void main(String[] args) throws FrameGrabber.Exception, InterruptedException {
        PhotoTest.catchPhoto();
        System.out.println("after catching");
        //此处的gsy5.jpg和PthotoTest中的照片路径应该是一致的
        File localfile = new File("/Users/gsy/Pictures/gsy5.jpg");
        //用来进行匹配的图片路径
        File file = new File("/Users/gsy/Pictures/2018-12-23 下午9.31 拍摄的照片.jpg");
        //存储在本地的token
        String apiKey = "V3wS_PI-ffa0NtEIDqbNqVa_UGQ7NvHl";
        String apiSecret = "--s7y8FvdapevSqWsNn2KyXmb5wzipI7";
        FaceHandleImpl faceHandle = new FaceHandleImpl();
        System.out.println("start!");
        TimerTaskTest taskTest = new TimerTaskTest();
        Timer timer = new Timer();
        timer.schedule(taskTest,0,500);
        String tokenLocal = faceHandle.get_token(localfile,apiKey,apiSecret);
        String imgToken = faceHandle.get_token(file,apiKey,apiSecret);
        BigDecimal confidence = faceHandle.get_ressemble(apiKey,apiSecret,tokenLocal,imgToken);
        timer.cancel();
        System.out.println("confidence = "+confidence);
        System.out.println("--------------------------->!");
        System.out.println("比较完毕！");

    }
}
