package com.xbdframework.boot.autoconfigure.enjoy;

import org.springframework.boot.autoconfigure.template.AbstractTemplateViewResolverProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Enjoy模板属性配置
 *
 * @author 刘明磊
 * @since 1.0.0
 */
@ConfigurationProperties(prefix = "spring.enjoy")
public class EnjoyProperties extends AbstractTemplateViewResolverProperties {

	public static final String DEFAULT_TEMPLATE_LOADER_PATH = "/templates/";

	public static final String DEFAULT_PREFIX = "";

	public static final String DEFAULT_SUFFIX = ".html";

	private boolean devMode = false;

	private String templateLoaderPath = DEFAULT_TEMPLATE_LOADER_PATH;

	private boolean sessionInView = false;

	private boolean createSession = true;

	protected EnjoyProperties() {
		super(DEFAULT_PREFIX, DEFAULT_SUFFIX);
	}

	public boolean isDevMode() {
		return this.devMode;
	}

	public void setDevMode(boolean devMode) {
		this.devMode = devMode;
	}

	public String getTemplateLoaderPath() {
		return templateLoaderPath;
	}

	public void setTemplateLoaderPath(String templateLoaderPath) {
		this.templateLoaderPath = templateLoaderPath;
	}

	public boolean isSessionInView() {
		return this.sessionInView;
	}

	public void setSessionInView(boolean sessionInView) {
		this.sessionInView = sessionInView;
	}

	public boolean isCreateSession() {
		return this.createSession;
	}

	public void setCreateSession(boolean createSession) {
		this.createSession = createSession;
	}

}
