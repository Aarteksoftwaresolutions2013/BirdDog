package com.birddog.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.birddog.util.ConstantURL;
import com.birddog.util.IConstant;

/**
 * @author Aartek, 04/03/2016, AppConfig file package scan
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = IConstant.BASE_PACKAGE)
@EnableTransactionManagement
@Import(SecurityConfiguration.class)
@PropertySource(IConstant.PROPERTY_SOURCE)
@EnableScheduling
public class AppConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler(ConstantURL.RESOURCE_HANDLER).addResourceLocations(ConstantURL.RESOURCE_LOCATION);

	}

	@Bean(name = IConstant.MULTIPART_RESOLVER)
	public CommonsMultipartResolver getCommonsMultipartResolver() {

		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(IConstant.MULTIPART_MAX_UPLOAD_SIZE);
		multipartResolver.setMaxInMemorySize(IConstant.MULTIPART_MAX_IN_MEMORY_SIZE);

		return multipartResolver;
	}

	@Bean
	public MessageSource messageSource() {

		ResourceBundleMessageSource resourceMessage = new ResourceBundleMessageSource();
		resourceMessage.setBasename(IConstant.MESSAGE);

		return resourceMessage;
	}

	/**
	 * Resolves views selected for rendering by @Controllers to tiles resources
	 * in the Apache TilesConfigurer bean
	 */
	@Bean
	public TilesViewResolver getTilesViewResolver() {

		TilesViewResolver tilesViewResolver = new TilesViewResolver();
		tilesViewResolver.setViewClass(TilesView.class);

		return tilesViewResolver;
	}

	/**
	 * Configures Apache tiles definitions bean used by Apache TilesViewResolver
	 * to resolve views selected for rendering by @Controllers
	 */
	@Bean
	public TilesConfigurer getTilesConfigure() {

		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setCheckRefresh(true);
		tilesConfigurer.setDefinitionsFactoryClass(TilesDefinitionsConfig.class);
		TilesDefinitionsConfig.addDefinitions();

		return tilesConfigurer;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(new LoggingInterceptor()).addPathPatterns("/**").excludePathPatterns(ConstantURL.HOME_URL)
				.excludePathPatterns(ConstantURL.BIRDDOG_REGISTRATION_URL).excludePathPatterns(ConstantURL.SAVE_BIRDDOG_REGISTRATION_URL)
				.excludePathPatterns(ConstantURL.LOGIN_URL).excludePathPatterns(ConstantURL.BIRDDOG_LOGIN_URL).excludePathPatterns(ConstantURL.LEAD_URL)
				.excludePathPatterns(ConstantURL.SAVE_WS_LEAD_URL).excludePathPatterns(ConstantURL.BIRDDOG_PROFILE_WS_URL)
				.excludePathPatterns(ConstantURL.UPDATE_BIRDDOG_PROFILE_WS_URL).excludePathPatterns(ConstantURL.STATE_URL).excludePathPatterns(ConstantURL.GET_COUNTY_BY_STATE_URL)
				.excludePathPatterns(ConstantURL.GET_CITY_BY_COUNTY_URL).excludePathPatterns(ConstantURL.SHOW_FORGOT_PASSWORD_PAGE_URL)
				.excludePathPatterns(ConstantURL.FORGOT_PASSWORD).excludePathPatterns(ConstantURL.BIRDDOG_FORGOT_PASSWORD_WS)
				.excludePathPatterns(ConstantURL.BIRDDOG_WS_CHANGE_PASSWORD).excludePathPatterns(ConstantURL.BIRDDOG_ADDCOMMENT_WS_URL)
				.excludePathPatterns(ConstantURL.BIRDDOG_WS_CHANGE_PASSWORD).excludePathPatterns(ConstantURL.BIRDDOG_ADDCOMMENT_WS_URL)
				.excludePathPatterns(ConstantURL.UPDATE_LEAD_DETAIL_WS).excludePathPatterns(ConstantURL.BIRDDOG_GET_COMMENT_WS_URL).excludePathPatterns(ConstantURL.VERIFY_USER_EMAILID)
				.excludePathPatterns(ConstantURL.GET_ALL_COMMENT_WS_URL).excludePathPatterns(ConstantURL.GET_MESSAGE_WS_URL).excludePathPatterns(ConstantURL.DELETE_LEAD_DETAIL_WS)
				.excludePathPatterns(ConstantURL.SEARCH_LEAD_DATE_WISE_WS).excludePathPatterns(ConstantURL.VIEW_ALL_BIRDDOG_TUTORIAL_WS).excludePathPatterns(ConstantURL.VIEW_SINGLE_LEAD_WS)
				.excludePathPatterns(ConstantURL.VIEW_SUPER_ADMIN_TUTORIAL_FOR_BIRDDOG_WS).excludePathPatterns(ConstantURL.VIEW_SINGLE_SUPER_ADMIN_TUTORIAL_FOR_BIRDDOG_WS);

	}
	
}