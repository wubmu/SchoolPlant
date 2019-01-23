package o2o.dao;

import o2o.model.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2019-01-15 12:58
 * description
 */
public interface ShopCategoryDao {
    /**
     *查询店铺类别
     * @param shopCategory
     * @return
     */
    List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategory);
}
