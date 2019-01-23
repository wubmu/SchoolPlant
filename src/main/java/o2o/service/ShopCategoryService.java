package o2o.service;

import o2o.model.ShopCategory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2019-01-15 14:22
 * description
 */
public interface ShopCategoryService {
    /**
     * 根据条件查询店铺信息
     * @param shopCategory
     * @return
     */
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategory);
}
