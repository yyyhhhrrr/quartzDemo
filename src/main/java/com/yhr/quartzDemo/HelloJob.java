package com.yhr.quartzDemo;

import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @BelongsProject: quartzDemo
 * @BelongsPackage: com.yhr.quartzDemo
 * @Author: yang
 * @CreateTime: 2019-03-29 11:40
 * @Description: ${Description}
 */
public class HelloJob implements Job {
//    private String message;
//    private Float FloatJobValue;
//    private Double DoubleJobValue;
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public Float getFloatJobValue() {
//        return FloatJobValue;
//    }
//
//    public void setFloatJobValue(Float floatJobValue) {
//        FloatJobValue = floatJobValue;
//    }
//
//    public Double getDoubleJobValue() {
//        return DoubleJobValue;
//    }
//
//    public void setDoubleJobValue(Double doubleJobValue) {
//        DoubleJobValue = doubleJobValue;
//    }

    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date date=new Date();
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("current time is:"+sf.format(date));
        //编写具体业务逻辑
//        JobKey jobKey=jobExecutionContext.getJobDetail().getKey();
//        System.out.println("my name and group:"+jobKey.getName()+":"+jobKey.getGroup());
//        TriggerKey triggerKey=jobExecutionContext.getTrigger().getKey();
//        System.out.println("my trigger and group:"+triggerKey.getName()+":"+triggerKey.getGroup());

        /**
         * 第一种通过JobDataMap获取
         */
//        JobDataMap jobDataMap=jobExecutionContext.getJobDetail().getJobDataMap();
//        JobDataMap tjobDataMap=jobExecutionContext.getTrigger().getJobDataMap();
//
//        String jobMsg=jobDataMap.getString("message");
//        Float jobFloatValue=jobDataMap.getFloatValue("FloatJobValue");
//        String triggerMsg=tjobDataMap.getString("message");
//        Double triggerDoubleValue=tjobDataMap.getDoubleValue("DoubleTriggerValue");
//        System.out.println("jobMsg:"+jobMsg);
//        System.out.println("jobFloatValue:"+jobFloatValue);
//        System.out.println("triggerMsg:"+triggerMsg);
//        System.out.println("triggerDoubleValue:"+triggerDoubleValue);

//        JobDataMap jobDataMap=jobExecutionContext.getMergedJobDataMap(); //使用合并datamap的时候 如果key相同 trigger会覆盖jobdetail的值
//        String msg=jobDataMap.getString("message");
//        Float jobFloatValue=jobDataMap.getFloatValue("FloatJobValue");
//        Double triggerDoubleValue=jobDataMap.getDoubleValue("DoubleTriggerValue");
//        System.out.println("jobMsg:"+msg);
//        System.out.println("jobFloatValue:"+jobFloatValue);
//        System.out.println("triggerDoubleValue:"+triggerDoubleValue);

        /**
         * 第二种 通过job的setter方法
         */
//        System.out.println("jobMsg:"+message);
//        System.out.println("jobFloatValue:"+FloatJobValue);
//        System.out.println("jobDoubleValue:"+DoubleJobValue);

        /**
         * trigger 设置时间
         */
//          Trigger currentTrigger =jobExecutionContext.getTrigger();
//          System.out.println("start time is:"+sf.format(currentTrigger.getStartTime()));
//          System.out.println("end time is:"+sf.format(currentTrigger.getEndTime()));
//          JobKey jobKey=currentTrigger.getJobKey();
//          System.out.println("jobkey info---"+"jobName"+jobKey.getName()+"jobGroup"+jobKey.getGroup());

        System.out.println("hello");




    }
}
