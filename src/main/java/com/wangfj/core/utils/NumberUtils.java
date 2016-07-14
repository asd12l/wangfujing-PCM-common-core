/**
 * @Probject Name: common-core
 * @Path: com.bailian.core.utilsNumberUtils.java
 * @Create By fanshunqing
 * @Create In 2014年10月22日 下午6:48:12
 *
 */
package com.wangfj.core.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

/**
 * @Class Name NumberUtils
 * @Author fanshunqing
 * @Create In 2014年10月22日
 */
public class NumberUtils {
  public static boolean isNumeric(String str) {
    Pattern pattern = Pattern.compile("[0-9]*");
    return pattern.matcher(str).matches();
  }

  /**
   * 字符串转换成bigdecimal
   * 
   * @Methods Name stringToBigDecimal
   * @Create In 2016年3月22日 By kongqf
   * @param str
   * @return BigDecimal
   */
  public static BigDecimal stringToBigDecimal(String str) {
    BigDecimal bd = new BigDecimal("0.00");
    try {
      bd = new BigDecimal(str);

    } catch (Exception e) {
      e.printStackTrace();
    }
    return bd;
  }

  public static String decimalFormat2(BigDecimal number) {
    DecimalFormat df = new DecimalFormat("#.00");
    return df.format(number);
  }
}
