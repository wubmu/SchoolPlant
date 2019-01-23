package o2o.dao;

import o2o.model.Shop;
import o2o.model.ShopCategory;
import o2o.service.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2019-01-15 14:15
 * description
 */
public class ShopCategoryDaoTest extends BaseTest {
    @Autowired
    private ShopCategoryDao shopCategoryDao;
    @Test
    public void queryShopCategory() {
        ShopCategory shopCategory = new ShopCategory();
        ShopCategory parentShopCategory = new ShopCategory();
        parentShopCategory.setShopCategoryId(1L);
        shopCategory.setParent(parentShopCategory);
        List<ShopCategory> list = shopCategoryDao.queryShopCategory(shopCategory);
        System.out.println(list.size());
    }
}