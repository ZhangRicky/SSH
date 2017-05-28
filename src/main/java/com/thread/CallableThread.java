package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Callable实现有返回值的线程
 * @author Mark
 * 
 * 1,Callable接口类似于Runnable,两者都是为那些其实例可能被另一个线程执行的类设计的，方法可以有返回值，并且可以抛出异常，但是，Runnable不行
 * 2：Callable需要依赖FutureTask,用于接收运算结果，一个产生结果，一个拿到结果，FutrueTask是Futrue接口的实例，也可以用作闭锁
 *
 */
public class CallableThread implements Callable{

	@Override
	public Object call() throws Exception {
		int sum =0;
		for(int i=0;i<=100;i++){
			sum+=i;
		}
		return sum;
	}
	
	/**
	 * 测试线程传递值
	 * @author zhanggx
	 * @date
	 * @version 1.0
	 * @param args
	 */
	public static void main(String[] args) {
		CallableThread call = new CallableThread();
		//1,执行Callable方式，需要FutureTask实现类的支持，用于接收运算结果
		FutureTask<Object> result = new FutureTask<Object>(call);
		
		Thread th =new Thread(result);
		th.start();

		//2.接收线程运算后的结果
		try {
			Object sum =result.get();
			System.out.println(sum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
