package com.xbdframework.boot.autoconfigure.enjoy;

import org.springframework.boot.autoconfigure.template.TemplateAvailabilityProvider;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

/**
 * {@link TemplateAvailabilityProvider} that provides availability information for
 * Enjoy view templates.
 *
 * @author 刘明磊
 * @since 1.0.0
 */
public class EnjoyTemplateAvailabilityProvider implements TemplateAvailabilityProvider {

	@Override
	public boolean isTemplateAvailable(String view, Environment environment,
			ClassLoader classLoader, ResourceLoader resourceLoader) {
		if (ClassUtils.isPresent("com.jfinal.template.EngineConfig", classLoader)) {
			RelaxedPropertyResolver resolver = new RelaxedPropertyResolver(environment,
					"spring.enjoy.");
			String loaderPath = resolver.getProperty("template-loader-path",
					ResourceUtils.CLASSPATH_URL_PREFIX
							+ EnjoyProperties.DEFAULT_TEMPLATE_LOADER_PATH);
			String prefix = resolver.getProperty("prefix",
					EnjoyProperties.DEFAULT_PREFIX);
			String suffix = resolver.getProperty("suffix",
					EnjoyProperties.DEFAULT_SUFFIX);
			return resourceLoader.getResource(loaderPath + prefix + view + suffix)
					.exists();
		}
		return false;
	}

}
