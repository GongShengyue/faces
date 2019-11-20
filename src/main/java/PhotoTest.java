import org.bytedeco.javacv.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber.Exception;

import org.bytedeco.javacpp.opencv_core;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import static org.bytedeco.javacpp.opencv_core.cvReleaseImage;


/**
 * 调用本地摄像头窗口视频
 * @author eguid
 * @version 2016年6月13日
 * @see
 * @since  javacv1.2
 */

public class PhotoTest {

    private static int width,height;
    static BufferedImage bImage;
    private static String fileName = "/Users/gsy/Pictures/gsy5.jpg";

    public static void catchPhoto() throws Exception, InterruptedException {
        OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(0);
        grabber.start();   //开始获取摄像头数据
        CanvasFrame canvas = new CanvasFrame("摄像头");//新建一个窗口
        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setAlwaysOnTop(true);

        while (true) {
            if (!canvas.isDisplayable()) {//窗口是否关闭
                grabber.stop();//停止抓取
                canvas.dispose();
//                System.exit(2);//退出
                return;
                
            }
//            canvas.showImage(grabber.grab());//获取摄像头图像并放到窗口上显示， 这里的Frame frame=grabber.grab(); frame是一帧视频图像
            OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();//转换器
            Frame frame = grabber.grab();
            doExecuteFrame(frame,fileName);
            opencv_core.IplImage grabbedImage = converter.convertToIplImage(frame);
            width = grabbedImage.width();
            height = grabbedImage.height();
            bImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            //显示器监控当前图像
            Graphics2D bGraphics = bImage.createGraphics();
            canvas.setCanvasSize(width, height);
            canvas.showImage(frame);

            bGraphics.drawImage(iplToBufImgData(grabbedImage), null, 0, 0);
            Thread.sleep(500);

        }
    }

    private static BufferedImage iplToBufImgData(opencv_core.IplImage mat) {
        if (mat.height() > 0 && mat.width() > 0) {
            BufferedImage image = new BufferedImage(mat.width(), mat.height(), BufferedImage.TYPE_3BYTE_BGR);
            WritableRaster raster = image.getRaster();
            DataBufferByte dataBuffer = (DataBufferByte) raster.getDataBuffer();
            byte[] data = dataBuffer.getData();
            mat.getByteBuffer().get(data);
            return image;
        }
        return null;
    }

    private static void doExecuteFrame(Frame f,String targetFileName){
        if(null == f||null == f.image){
            return ;
        }
        Java2DFrameConverter converter = new Java2DFrameConverter();
        targetFileName = targetFileName.replace("mp4","jpg");
        System.out.println("targetFileName"+targetFileName);
        String imageMat = "jpg";
        String fileName = targetFileName;
        BufferedImage bi = converter.getBufferedImage(f);
        File output = new File(fileName);
        try{
            ImageIO.write(bi,imageMat,output);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
