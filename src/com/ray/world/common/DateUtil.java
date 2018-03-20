package com.ray.world.common;

import java.util.Date;

import com.ray.util.TimeUnit;
import com.ray.util.io.Out;

public class DateUtil {
    
    public static final byte SEC_1_DAY = 1; // 1s = 1��
    public static final byte SEC_7_DAY = 2; // 1s = 1��
    public static final byte SEC_X_DAY = 3; // 1s = 1Ѯ
    public static final byte SEC_A_MON = 4; // 1s = 1��
    
    public static int TIME_SPEED = SEC_A_MON;
    
    public static long getYears(Date date) {
        Date now = new Date();
        long diff = (now.getTime() - date.getTime()) / 1000;
        
        switch(TIME_SPEED) {
            case SEC_1_DAY : return diff/365;
            case SEC_7_DAY : return diff*7/365;
            case SEC_X_DAY : return diff*10/365;
        }
        return diff*30/365;
    }
    
    public static void main(String[] args) {
        DateUtil.TIME_SPEED = DateUtil.SEC_A_MON;
        
        Date t = new Date();
        
        TimeUnit.SECOND.sleep(70);
        
        Out.p(getYears(t));
        
    }
    
}
