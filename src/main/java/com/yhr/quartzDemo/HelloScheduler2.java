package com.yhr.quartzDemo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @BelongsProject: quartzDemo
 * @BelongsPackage: com.yhr.quartzDemo
 * @Author: yang
 * @CreateTime: 2019-03-29 14:41
 * @Description: crontrigger 使用
 */
public class HelloScheduler2 {

    public static void main(String[] args) throws SchedulerException, InterruptedException {
        Date date=new Date();
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("current time is:"+sf.format(date));

        JobDetail jobDetail= JobBuilder.newJob(HelloJob.class)
                .withIdentity("myjob","job_group1")
                .build();


        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("mytrigger","trigger_group1")
                .startAt(date)
                .withSchedule(
                        CronScheduleBuilder
                                .cronSchedule("* * * * * ? *"))
                .build();



        SchedulerFactory schedulerFactory=new StdSchedulerFactory();

        Scheduler scheduler=schedulerFactory.getScheduler();
        scheduler.start();


        scheduler.scheduleJob(jobDetail,trigger);
        //schedualer 执行2s后自动挂起
        Thread.sleep(2000L);
        scheduler.standby();
        //schedualer 挂起3后 启动
        Thread.sleep(3000L);
        scheduler.start();

    }
}
