package o2o.dao;

import o2o.model.Area;
import o2o.model.PersonInfo;
import o2o.model.Shop;
import o2o.model.ShopCategory;
import o2o.service.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sun.security.provider.SHA;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2019-01-01 13:27
 * description
 */
public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao dao;
    @Test
    public void insertShop() {
        Shop shop   = new Shop();
        PersonInfo personInfo = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();

        personInfo.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setArea(area);
        shop.setParentCategory(shopCategory);
        shop.setShopName("测试的店铺");
        shop.setOwnerId(personInfo);
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审查中");
        int i = dao.insertShop(shop);

    }
}