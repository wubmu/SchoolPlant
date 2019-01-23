package o2o.service.impl;

import o2o.dto.ShopExecution;
import o2o.enums.ShopStateEnum;
import o2o.model.Area;
import o2o.model.PersonInfo;
import o2o.model.Shop;
import o2o.model.ShopCategory;
import o2o.service.BaseTest;
import o2o.service.ShopService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import org.apache.http.entity.ContentType;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2019-01-09 15:46
 * description
 */
public class ShopServiceImplTest extends BaseTest {
    @Autowired
    private ShopService shopService;
    @Test
    public void addShop() {
        Shop shop   = new Shop();
        PersonInfo personInfo = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();

        personInfo.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setArea(area);
        shop.setParentCategory(shopCategory);
        shop.setShopName("测试的店铺2");
        shop.setOwnerId(personInfo);
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审查中");
        File shopImg = new File("D:\\makeMonery\\20190108\\1.PNG");



    }
}