package com.xbdframework.boot.autoconfigure.enjoy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.autoconfigure.template.PathBasedTemplateAvailabilityProvider;
import org.springframework.boot.autoconfigure.template.TemplateAvailabilityProvider;
import org.springframework.util.ResourceUtils;

/**
 * {@link TemplateAvailabilityProvider} that provides availability information for
 * Enjoy view templates.
 *
 * @author 刘明磊
 * @since 1.0.0
 */
public class EnjoyTemplateAvailabilityProvider extends PathBasedTemplateAvailabilityProvider {

	public EnjoyTemplateAvailabilityProvider() {
		super("com.jfinal.template.EngineConfig",
				EnjoyTemplateAvailabilityProperties.class, "spring.enjoy");
	}

	static final class EnjoyTemplateAvailabilityProperties
			extends PathBasedTemplateAvailabilityProvider.TemplateAvailabilityProperties {

		private List<String> templateLoaderPath = new ArrayList<>(
				Arrays.asList(ResourceUtils.CLASSPATH_URL_PREFIX
						+ EnjoyProperties.DEFAULT_TEMPLATE_LOADER_PATH));

		EnjoyTemplateAvailabilityProperties() {
			super(EnjoyProperties.DEFAULT_PREFIX, EnjoyProperties.DEFAULT_SUFFIX);
		}

		@Override
		protected List<String> getLoaderPath() {
			return this.templateLoaderPath;
		}

		public List<String> getTemplateLoaderPath() {
			return this.templateLoaderPath;
		}

		public void setTemplateLoaderPath(List<String> templateLoaderPath) {
			this.templateLoaderPath = templateLoaderPath;
		}

	}

}
