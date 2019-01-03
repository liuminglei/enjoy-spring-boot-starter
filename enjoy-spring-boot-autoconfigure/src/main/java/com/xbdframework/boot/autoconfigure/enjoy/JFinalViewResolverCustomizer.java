package com.xbdframework.boot.autoconfigure.enjoy;

import com.jfinal.template.ext.spring.JFinalViewResolver;

/**
 * Enjoy模板引擎应用个性化配置接口，用以覆盖默认配置项
 *
 * @author 刘明磊
 * @since 1.0.0
 */
public interface JFinalViewResolverCustomizer {

	/**
	 * 个性化配置
	 *
	 * @param jFinalViewResolver {@link JFinalViewResolver}
	 */
	void customize(JFinalViewResolver jFinalViewResolver);

}
