package org.dieschnittstelle.jee.esa.interceptors;

import java.util.HashMap;
import java.util.Map;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger; import org.slf4j.LoggerFactory;

@Interceptor
public class LoggingInterceptor {

	protected static Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);

	/*
	 * a map of loggers
	 */
	private Map<Class<?>, Logger> loggers = new HashMap<Class<?>, Logger>();

	/**
	 * obtain a logger
	 */
	private LoggerFactory.getLogger(Class<?> klass) {
		if (loggers.containsKey(klass))
			return loggers.get(klass);
		return createNewLogger(klass);
	}

	private synchronized Logger createNewLogger(Class<?> klass) {
		logger.info("createNewLogger(): class is: " + klass);

		Logger logger = LoggerFactory.getLogger(klass);
		loggers.put(klass, logger);

		return logger;
	}

	/**
	 * log a method invocation
	 * 
	 * @param context
	 * @return
	 * @throws Exception
	 */
	@AroundInvoke
	public Object logMethod(final InvocationContext context) throws Exception {

		StringBuffer buf = new StringBuffer();
		String prefix = context.getMethod().getName() + "()";

		/*
		 * log the input
		 */
		buf.append(prefix);
		buf.append(": invoke with arguments: (");

		for (int i = 0; i < context.getParameters().length; i++) {
			buf.append(context.getParameters()[i]);
			if (i < (context.getParameters().length - 1)) {
				buf.append(", ");
			}
		}
		buf.append(")");

		getLogger(context.getTarget().getClass()).info(buf.toString());

		/*
		 * execute the method
		 */
		Object result = context.proceed();

		/*
		 * log the output
		 */
		buf.setLength(0);
		buf.append(prefix);

		// check whether we have a void method
		if (context.getMethod().getReturnType() == Void.TYPE) {
			buf.append(": returned");
		} else {
			buf.append(": got return value: ");
			buf.append(result);
		}

		getLogger(context.getTarget().getClass()).info(buf.toString());

		return result;
	}

}
