package o2o.utils;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2019-01-02 21:22
 * description
 */
public class PathUtil {
    private static String seperator = System.getProperty("file.separator");
    public static String getImgBasePath(){
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")){
            basePath = "D:/Work/SchoolPlant/src/main/webapp/resources/img/";
        }else {
            basePath="";
        }
        basePath = basePath.replace("/",seperator);
        return basePath;
    }

    public static String getShopImagePath(long shopId){

        String imagePath = ""+shopId+"/";
        return imagePath.replace("/",seperator);
    }
}
