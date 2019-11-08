package com.my.common.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @date : 2018/4/16 不用在每个类中使用 LogManager.getLogger(xxx.class) 的方式了 直接使用
 *       LogManager.getLogger(),或者用LogUtils.getLogger 使用以上方法,或自动获取当前调用者的类名
 *       instead of  @Log4j2 注解
 */
public class LogUtils {

	/**
	 * 返回一个调用这的名称的Logger
	 * 
	 * @return The Logger for the calling class.
	 * @throws UnsupportedOperationException if the calling class cannot be
	 *                                       determined.
	 */
	public static Logger getLogger() {
		return LogManager.getLogger();
	}

}
