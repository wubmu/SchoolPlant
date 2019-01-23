package o2o.service;

import o2o.dto.ShopExecution;
import o2o.model.Shop;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2019-01-07 21:10
 * description
 */
@Component
public interface ShopService {

    ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg);
}
