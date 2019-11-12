package com.shotgun.my.web.vo.helloController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Test {

    @Max(value = 10, message = "不能大于10")
    @Min(value = 1, message = "不能小于1")
    private Integer id;
    private String content;
    private Integer isValid;
    private Aa aa;
    private Boolean isOk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }

    public Aa getAa() {
        return aa;
    }

    public void setAa(Aa aa) {
        this.aa = aa;
    }

    public Boolean getOk() {
        return isOk;
    }

    public void setOk(Boolean ok) {
        isOk = ok;
    }

    public static class Aa {
        private String wocha;

        public String getWocha() {
            return wocha;
        }

        public void setWocha(String wocha) {
            this.wocha = wocha;
        }
    }
}