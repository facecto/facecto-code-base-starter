package com.facecto.code.base.utils;

/**
 * @author Jon So
 * @author page https://cto.pub
 * @date 2021/6/25
 */
public class StringFormatUtils {
    /**
     * 中国手机号屏蔽中间四位
     * @param tel 11位屏蔽
     * @return
     */
    public static String getTel(String tel){
        if(tel.length()==11){
            return tel.substring(0,3) +"****" +tel.substring(7,11);
        }
        return tel;
    }

    /**
     * 中国身份证屏蔽中间位数
     * @param IdNo 18位和15位屏蔽
     * @return
     */
    public static String getIdNo(String IdNo){
        if(IdNo.length()==18){
            return IdNo.substring(0,4) +"****" +IdNo.substring(8,12) + "****"+IdNo.substring(16,18);
        }
        if(IdNo.length()==15){
            return IdNo.substring(0,4) +"**" +IdNo.substring(6,10) + "****"+IdNo.substring(14,15);
        }
        return IdNo;
    }
}
