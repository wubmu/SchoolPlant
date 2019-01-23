package o2o.utils;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2019-01-02 21:07
 * description
 */
public class ImageUtil {
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat  SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();
    public static String generateThumbnail(CommonsMultipartFile thumbnail, String targetAddr){
        String realFileName =getRandomFileName();
        String extension = getFileExtension(thumbnail);
        makeDirPath(targetAddr);

        String relativeAddr = targetAddr+realFileName+extension;

        File dest = new File(PathUtil.getImgBasePath()+relativeAddr);
        try {
            Thumbnails.of(thumbnail.getInputStream())//.watermark(Positions.BOTTOM_RIGHT,
            //ImageIO.read(new File(basePath + "/watermark.jpg")), 0.25f)
                    .size(200, 200)
                    .outputQuality(0.8f)
                    .toFile(dest);
        }catch (IOException e){
            e.printStackTrace();
        }
        return relativeAddr;

    }

    /**
     * 创建目标路径上的路径，以及路径上涉及到的文件/home/work/wyb/xxx.jpg
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath()+targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists())
            dirPath.mkdirs();


    }

    /**
     * 获取输入文件的扩展名
     * @param thumbnail
     * @return
     */
    private static String getFileExtension(CommonsMultipartFile thumbnail) {
        String originalFileName = thumbnail.getOriginalFilename();
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }

    /**
     * 生成随机文件名,当前年月日时分秒+5位随机数
     * @return
     */
    private static String getRandomFileName() {
        int randomNum = r.nextInt(89999)+10000;
        String nowTimeStr = SIMPLE_DATE_FORMAT.format(new Date());
        return nowTimeStr+randomNum;
    }

    public static void main(String[] args) throws IOException {
        //获得当前线程的绝对路径
        String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        Thumbnails.of(new File(""))
                .size(200, 200).watermark(Positions.BOTTOM_RIGHT,
                ImageIO.read(new File(basePath + "")), 0.25f).outputQuality(0.8f)
                .toFile("");
    }

}
