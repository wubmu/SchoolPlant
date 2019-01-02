package o2o.service;

import o2o.model.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2019-01-01 11:13
 * description
 */
public class AreaServiceTest extends BaseTest{
    @Autowired
    private AreaService areaService;
    @Test
    public void getAreaList() {
        List<Area> areas = areaService.getAreaList();
        assertEquals("东区",areas.get(0).getAreaName());
    }
}