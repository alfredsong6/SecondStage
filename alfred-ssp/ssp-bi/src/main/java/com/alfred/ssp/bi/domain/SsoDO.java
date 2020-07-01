package com.alfred.ssp.bi.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: songqiang
 * @Description :
 * @Date : Create in 2020/7/1 17:57
 * @Modified :
 **/
@Component
@ConfigurationProperties("cdmis.sso")
public class SsoDO {

    //@Value("cdmis.sso.appcode")
    private String appcode;

    //@Value("cdmis.sso.secretcode")
    private String secretcode;

    public String getAppcode() {
        return appcode;
    }

    public void setAppcode(String appcode) {
        this.appcode = appcode;
    }

    public String getSecretcode() {
        return secretcode;
    }

    public void setSecretcode(String secretcode) {
        this.secretcode = secretcode;
    }
}
