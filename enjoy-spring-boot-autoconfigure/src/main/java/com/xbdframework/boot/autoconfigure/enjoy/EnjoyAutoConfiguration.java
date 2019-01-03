package com.xbdframework.boot.autoconfigure.enjoy;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.template.TemplateLocation;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.util.ResourceUtils;

/**
 * {@code Enjoy}模板引擎自动化配置
 * <p>默认开启模板路径检查，如不需要，可设置spring.enjoy.checkTemplateLocation=false关闭
 *
 * @author 刘明磊
 * @since 1.0.0
 */
@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass(com.jfinal.template.EngineConfig.class)
@EnableConfigurationProperties(EnjoyProperties.class)
@Import({ EnjoyServletWebConfiguration.class })
public class EnjoyAutoConfiguration {

	private final Logger logger = LoggerFactory.getLogger(EnjoyAutoConfiguration.class);

	private final ApplicationContext applicationContext;

	private final EnjoyProperties properties;

	public EnjoyAutoConfiguration(ApplicationContext applicationContext,
			EnjoyProperties properties) {
		this.applicationContext = applicationContext;
		this.properties = properties;
	}

	/**
	 * 模板路径检查
	 */
	@PostConstruct
	public void checkTemplateLocationExists() {
		if (this.logger.isWarnEnabled() && this.properties.isCheckTemplateLocation()) {
			TemplateLocation location = getLocation();
			if (!locationExists(location)) {
				this.logger.warn(
						"模板路径{}不存在，请注意设置！如不需要检查，请设置spring.enjoy.checkTemplateLocation=false",
						location);
			}
		}
	}

	private TemplateLocation getLocation() {
		return new TemplateLocation(ResourceUtils.CLASSPATH_URL_PREFIX
				+ this.properties.getTemplateLoaderPath());
	}

	private boolean locationExists(TemplateLocation location) {
		return location.exists(this.applicationContext);
	}

}
