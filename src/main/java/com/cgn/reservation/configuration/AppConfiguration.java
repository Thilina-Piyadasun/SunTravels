package com.cgn.reservation.configuration;


import com.cgn.reservation.beans.SearchResponseBean;
import com.cgn.reservation.service.Pricing;
import com.cgn.reservation.util.Converter;
import com.cgn.reservation.service.SearchDataRequest;
import com.cgn.reservation.service.SearchHotel;
import com.google.gson.Gson;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.cgn.reservation")
public class AppConfiguration extends WebMvcConfigurerAdapter
{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public SearchDataRequest searchDataRequest(){
		return new SearchDataRequest();
	}

	@Bean
	public SearchHotel searchHotel(){
		return new SearchHotel();
	}

	@Bean
	public Converter converter(){
		return new Converter();
	}

	@Bean
	public Pricing pricing(){
		return new Pricing();
	}
	@Bean
	public SearchResponseBean searchResponseBean(){
		return new SearchResponseBean();
	}
	@Bean
	public Gson gson(){
		return new Gson();
	}
}