package com.xbdframework.boot.autoconfigure.enjoy;

import java.util.List;
import javax.servlet.Servlet;

import com.jfinal.template.ext.spring.JFinalViewResolver;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * {@code Enjoy}模板引擎自动化配置
 *
 * @author 刘明磊
 * @since 1.0.0
 */
@ConditionalOnWebApplication
@ConditionalOnClass({ Servlet.class })
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
public class EnjoyServletWebConfiguration extends AbstractEnjoyConfiguration {

	private final List<JFinalViewResolverCustomizer> jFinalViewResolverCustomizers;

	protected EnjoyServletWebConfiguration(EnjoyProperties enjoyProperties,
			ObjectProvider<List<JFinalViewResolverCustomizer>> viewResolverCustomizers) {
		super(enjoyProperties);
		this.jFinalViewResolverCustomizers = viewResolverCustomizers.getIfAvailable();
	}

	@Bean
	@ConditionalOnMissingBean(JFinalViewResolver.class)
	@ConditionalOnProperty(name = "spring.enjoy.enabled", matchIfMissing = true)
	public JFinalViewResolver jFinalViewResolver() {
		JFinalViewResolver jFinalViewResolver = new JFinalViewResolver();

		// 通用配置
		this.getProperties().applyToViewResolver(jFinalViewResolver);

		// enjoy特殊配置
		applyProperties(jFinalViewResolver);

		// 个性化配置
		customize(jFinalViewResolver);

		return jFinalViewResolver;
	}

	private void customize(JFinalViewResolver jFinalViewResolver) {
		if (this.jFinalViewResolverCustomizers != null) {
			for (JFinalViewResolverCustomizer viewResolverCustomizer : this.jFinalViewResolverCustomizers) {
				viewResolverCustomizer.customize(jFinalViewResolver);
			}
		}
	}

}
