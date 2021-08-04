package com.facecto.code.base.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author Jon So
 * @author page https://cto.pub
 * @date 2021/5/01
 */
public class ConvertUtils {
    /**
     * 分转元
     *
     * @param fen 分
     * @return
     */
    public static BigDecimal fen2Yuan(Integer fen) {
        BigDecimal d = new BigDecimal(fen).divide(new BigDecimal(100));
        return d;
    }

    /**
     * 转换为字符串
     *
     * @param number
     * @return
     */
    private static String amount(BigDecimal number) {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(number);
    }

    /**
     * 分转元（返回字符串）
     *
     * @param fen
     * @return
     */
    public static String fen2YuanString(Integer fen) {
        return amount(fen2Yuan(fen));
    }

}
