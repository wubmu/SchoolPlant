package o2o.service;

import o2o.model.Area;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2019-01-01 11:09
 * description
 */
@Component
public interface AreaService {

    List<Area> getAreaList();

}
