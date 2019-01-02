package o2o.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2018-12-29 10:02
 * description
 */
public class WechatAuth {
    private Long wechatAhthId;
    private String openId;
    private Date createTime;
    private PersonInfo personInfo;

    public Long getWechatAhthId() {
        return wechatAhthId;
    }

    public void setWechatAhthId(Long wechatAhthId) {
        this.wechatAhthId = wechatAhthId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
