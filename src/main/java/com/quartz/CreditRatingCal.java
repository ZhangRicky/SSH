package com.quartz;

import org.springframework.stereotype.Service;

/**
 * task运行的具体任务实现
 * @author Mark
 *
 */
@Service("creditRatingCal")
public class CreditRatingCal {
	
	public void calTheRatingOverTime(){
		System.out.println("这是定时执行的任务");
	}
}
