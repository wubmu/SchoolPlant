package o2o.controller.superadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import o2o.dto.ShopExecution;
import o2o.enums.ShopStateEnum;
import o2o.model.PersonInfo;
import o2o.model.Shop;
import o2o.service.ShopService;
import o2o.utils.CodeUtil;
import o2o.utils.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2019-01-09 19:47
 * description
 */
@Controller
@RequestMapping("/shopAdmin")
public class ShopManagementController {
    @Autowired
    private ShopService shopService;


    @RequestMapping(value = "/registerShop",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> registerShop(HttpServletRequest request){
        System.out.println("123123123123");
        System.out.println(request.getParameter("verifyCodeActual"));
        System.out.println(HttpServletRequestUtil.getString(request,"verifyCodeActual"));
        Map<String,Object> modelMap = new HashMap<String, Object>();
        if (!CodeUtil.checkVerifyCode(request)){
            modelMap.put("success",false);
            modelMap.put("errMsg","输入了错误的验证码");
            return modelMap;
        }
        String shopStr = HttpServletRequestUtil.getString(request,"shopStr");
        ObjectMapper mapper = new ObjectMapper();
        Shop shop =null;


        try {
            shop = mapper.readValue(shopStr,Shop.class);
            System.out.println(shop.toString());

        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.getMessage());
            return modelMap;
        }
        CommonsMultipartFile shopImg =null;
        CommonsMultipartResolver commonsMultipartResolver =
                new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断是否有文件流
        if (commonsMultipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg","上传图片不能为空");
            return modelMap;
        }

        //2注册店铺
        if(shop!=null&&shopImg!=null){
            PersonInfo owner = new PersonInfo();

            //session to do
            owner.setUserId(1L);
            shop.setOwnerId(owner);

            ShopExecution se = shopService.addShop(shop,shopImg);
            if (se.getState()==ShopStateEnum.CHECK.getState()) {
                modelMap.put("success", true);
            }else {
                modelMap.put("success",false);
                modelMap.put("errMsg",se.getStateInfo());
            }
            return modelMap;

        }else {
            modelMap.put("success",false);
            modelMap.put("errMsg","请输入店铺信息");
        }

        return modelMap;

    }


}
