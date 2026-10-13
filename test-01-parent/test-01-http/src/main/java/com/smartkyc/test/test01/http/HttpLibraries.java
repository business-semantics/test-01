package com.smartkyc.test.test01.http;

import java.time.Duration;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * HTTP, mail and servlet container libraries managed by test-01-bom.
 */
public final class HttpLibraries {

	/**
	 * One public type of every library this module depends on (the httpclient tests jar, kotlin-stdlib-common and
	 * apache-jstl contain no usable types).
	 */
	public static final List<Class<?>> USED = List.of(
			jakarta.mail.Session.class,
			org.apache.http.impl.client.HttpClients.class,
			org.apache.http.impl.client.cache.CachingHttpClients.class,
			org.apache.http.client.fluent.Request.class,
			org.apache.http.HttpHost.class,
			org.apache.http.entity.mime.MultipartEntityBuilder.class,
			org.apache.hc.client5.http.impl.classic.HttpClients.class,
			okhttp3.OkHttpClient.class,
			kotlin.Unit.class,
			kotlin.collections.jdk8.CollectionsJDK8Kt.class,
			okhttp3.logging.HttpLoggingInterceptor.class,
			jcifs.smb.SmbFile.class,
			com.fasterxml.jackson.jakarta.rs.json.PackageVersion.class,
			org.eclipse.jetty.server.Server.class,
			org.eclipse.jetty.webapp.WebAppContext.class,
			org.eclipse.jetty.util.StringUtil.class,
			org.eclipse.jetty.annotations.AnnotationConfiguration.class,
			org.eclipse.jetty.jsp.JettyJspServlet.class,
			org.eclipse.jetty.websocket.client.WebSocketClient.class,
			org.springframework.web.client.RestTemplate.class,
			org.springframework.web.servlet.ModelAndView.class);

	private HttpLibraries() {
	}

	public static OkHttpClient client(Duration timeout) {
		HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
		logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
		return new OkHttpClient.Builder().callTimeout(timeout).addInterceptor(logging).build();
	}
}
