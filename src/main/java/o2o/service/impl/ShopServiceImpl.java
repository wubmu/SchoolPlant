package o2o.service.impl;

import o2o.dao.ShopDao;
import o2o.dto.ShopExecution;
import o2o.enums.ShopStateEnum;
import o2o.exception.ShopOperationException;
import o2o.model.Shop;
import o2o.service.ShopService;
import o2o.utils.ImageUtil;
import o2o.utils.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2019-01-07 21:12
 * description
 */
@Service("shopService")
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Transactional
    public ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg) {
        //空值判断
        if (shop == null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP_INFO);
        }try {
            //给店铺信息赋初始值
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());

            //添加店铺信息
            int effectNum = shopDao.insertShop(shop);
            if (effectNum <= 0)
                //事物回滚
                throw new ShopOperationException("店铺创建失败");
            else {
                if (shopImg!=null){
                    //存储图片
                    try {
                        addShopImg(shop,shopImg);
                    }catch (Exception e){
                        throw new ShopOperationException("addShopImg error:"+e.getMessage());
                    }
                    //跟新店铺的图片地址
                    effectNum = shopDao.updateShop(shop);
                    if (effectNum <=0 ){
                        throw new ShopOperationException("更新图片地址失败");
                    }

                }
            }
        }catch (Exception e ){
            throw new ShopOperationException("addShop error:"+e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }

    private void addShopImg(Shop shop, CommonsMultipartFile shopImg) {
    String dest = PathUtil.getShopImagePath(shop.getShopId());
    String shopImgAddr = ImageUtil.generateThumbnail(shopImg,dest);
    shop.setShopImg(shopImgAddr);
    }
}
