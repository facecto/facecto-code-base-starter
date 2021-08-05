package com.facecto.code.base.utils;

/**
 * @author Jon So
 * @author page https://cto.pub
 * @date 2021/6/25
 */
public class StringFormatUtils {
    /**
     * china telphone convert
     * example: 13912345678 to 139****5678
     * @param tel length
     * @return
     */
    public static String getTel(String tel){
        if(tel.length()==11){
            return tel.substring(0,3) +"****" +tel.substring(7,11);
        }
        return tel;
    }

    /**
     * china id convert
     * example: 350101202105201234 to 3501**2021****1234
     * @param IdNo length 18 or 15
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
