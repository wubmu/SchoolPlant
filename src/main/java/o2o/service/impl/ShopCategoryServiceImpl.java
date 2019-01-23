package o2o.service.impl;

import o2o.dao.ShopCategoryDao;
import o2o.model.ShopCategory;
import o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2019-01-15 14:24
 * description
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Autowired
    private ShopCategoryDao dao;
    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategory) {
        return dao.queryShopCategory(shopCategory);
    }
}
