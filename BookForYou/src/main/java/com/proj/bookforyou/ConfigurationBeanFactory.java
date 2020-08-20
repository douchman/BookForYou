package com.proj.bookforyou;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.proj.bookforyou.Recommend.service.ITendsAnalysis;
import com.proj.bookforyou.Recommend.service.TendsAnalysis;

@Configuration
public class ConfigurationBeanFactory {

	@Bean
	public ITendsAnalysis tendsAnlysis() {
		return new TendsAnalysis();
	}
}
