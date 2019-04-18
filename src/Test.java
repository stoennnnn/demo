package src;

/**
 * Created by 26725 on 2019/3/27.
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * ClassName：src.Test <br>
 * Description：(用一句话描述这个类或者接口表示什么)<br>
 * Copyright © 2019/4/3 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 26725 <br>
 * date 2019/4/3 17:18<br>
 * @version v1.0 <br>
 */
public class Test {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        calendar.setTime(new Date());
//        String currentDate = format.format(new Date());
//        if (currentDate.equals("")||currentDate.equals(""))
//        int year = Calendar.;

        calendar.add(Calendar.MONTH, -3);
//        calendar.add(Calendar.DATE, -5);
        Date time = calendar.getTime();
        String beforeDate = format.format(time);
        System.out.println(beforeDate);
//        int year = calendar.YEAR;
//        int month = calendar.MONTH;
//        int dayOfMonth = calendar.DAY_OF_MONTH;
//        System.out.println(year+"/"+month+"/"+dayOfMonth);
    }


}
