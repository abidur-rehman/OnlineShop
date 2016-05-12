package shop.co.uk.configuration;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;


@Configuration
@ComponentScan(basePackages = "shop.co.uk", excludeFilters = @Filter({Controller.class, Configuration.class}))
public class TestApplicationConfig implements ApplicationContextAware {
	@SuppressWarnings("unused")
	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

}
