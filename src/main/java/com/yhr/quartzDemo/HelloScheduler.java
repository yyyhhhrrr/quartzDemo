package com.yhr.quartzDemo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @BelongsProject: quartzDemo
 * @BelongsPackage: com.yhr.quartzDemo
 * @Author: yang
 * @CreateTime: 2019-03-29 13:13
 * @Description: ${Description}
 */
public class HelloScheduler {
    public static void main(String[] args) throws SchedulerException {

        Date date=new Date();
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("current time is:"+sf.format(date));


        //创建一个jobdetail实例 将该实例与HelloJob.class绑定
        JobDetail jobDetail= JobBuilder.newJob(HelloJob.class)
                .withIdentity("myjob","job_group1")
                .build();
//        //获取距离当前时间3秒后的时间
//        date.setTime(date.getTime()+3000);
//        //距离当前时间6秒后的时间
//        Date endDate=new Date();
//        endDate.setTime(endDate.getTime()+6000);

        //创建一个trigger实例，定义该job立即执行，并且每隔2s执行一次
//        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("mytrigger","trigger_group1")
//                .withSchedule(
//                        SimpleScheduleBuilder
//                                .simpleSchedule()
//                                .withIntervalInSeconds(2)
//                                .repeatForever())
//                .build();


        /**
         * simpleTrigger  第一个例子 获取距离当前时间4s之后执行 且执行一次
         */
        date.setTime(date.getTime()+4000);
//        SimpleTrigger trigger = (SimpleTrigger) TriggerBuilder.newTrigger().withIdentity("mytrigger","trigger_group1")
//                .startAt(date)
//                .build();

        /**
         * simpleTrigger 第二个例子 获取距离当前时间4s之后首次执行， 之后每隔2s执行一次
         */
        SimpleTrigger trigger = (SimpleTrigger) TriggerBuilder.newTrigger().withIdentity("mytrigger","trigger_group1")
                .startAt(date)
                .withSchedule(
                        SimpleScheduleBuilder
                                .simpleSchedule()
                                .withIntervalInSeconds(2)
                                .withRepeatCount(3)) //除了第一次 再执行3次
                .build();




        //创建scheduler实例
        SchedulerFactory schedulerFactory=new StdSchedulerFactory();

        Scheduler scheduler=schedulerFactory.getScheduler();
        scheduler.start();


        scheduler.scheduleJob(jobDetail,trigger);

    }
}
