package com.xbdframework.boot.autoconfigure.enjoy;

import com.jfinal.template.ext.spring.JFinalViewResolver;
import com.jfinal.template.source.ClassPathSourceFactory;

/**
 * Enjoy模板基础配置
 *
 * @author 刘明磊
 * @since 1.0.0
 */
public class AbstractEnjoyConfiguration {

	private final EnjoyProperties properties;

	protected AbstractEnjoyConfiguration(EnjoyProperties properties) {
		this.properties = properties;
	}

	public final EnjoyProperties getProperties() {
		return this.properties;
	}

	/**
	 * 处理{@code JFinal}特有的配置项
	 *
	 * @param jFinalViewResolver {@link JFinalViewResolver}
	 */
	protected void applyProperties(JFinalViewResolver jFinalViewResolver) {
		jFinalViewResolver.setDevMode(this.getProperties().isDevMode());
		jFinalViewResolver.setSourceFactory(new ClassPathSourceFactory());
		jFinalViewResolver
				.setBaseTemplatePath(this.getProperties().getTemplateLoaderPath());
		jFinalViewResolver.setSessionInView(this.getProperties().isSessionInView());
		jFinalViewResolver.setCreateSession(this.getProperties().isCreateSession());
	}

}
