# faces
使用face++ API 和javaCV实现的人脸识别

运行环境IDEA2019.2.4+JDK1.8+MacOS10.15

运行时还需要导入一个**fastjson** jar包

由于线程的原因，macOS不能直接使用IDEA运行项目，我是在IDEA 编译后使用命令行运行的。windows系统应该可以直接在IDE中启动。
#####     使用步骤
0.在face++申请APIkey和API secret
1.预先配置一张用来匹配的照片
` //此处的gsy5.jpg和PthotoTest中的照片路径应该是一致的
        File localfile = new File("/Users/gsy/Pictures/gsy5.jpg");
        //用来进行匹配的图片路径
        File file = new File("/Users/gsy/Pictures/2018-12-23 下午9.31 拍摄的照片.jpg");`
 2.windows系统直接启动，mac用户运行build.sh启动 
      ![截屏2019-11-20下午5.42.43](https://github.com/GongShengyue/faces/blob/master/%E6%88%AA%E5%B1%8F2019-11-20%E4%B8%8B%E5%8D%885.42.43.png)
3.输出匹配可信度confidence

##### 相关
* 拍照系统使用javaCV+openCV
* 人脸识别系统使用face++ 的api（可免费使用）
* 本系统使用在线版API，需要网络连接
