package spring.boot.example.wicket;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import spring.boot.example.wicket.components.Homepage;
import spring.boot.example.wicket.components.MountedPage;
import spring.boot.example.wicket.services.TextService;

/**
 * The web application class also serves as spring boot starting point by using
 * spring boot's EnableAutoConfiguration annotation and providing the main
 * method.
 * 
 * @author kloe
 *
 */
@Component
@EnableAutoConfiguration
@ComponentScan
public class WicketWebApplication extends WebApplication {

	private final static Logger logger = LoggerFactory
			.getLogger(WicketWebApplication.class);

	@Autowired
	private TextService exampleService;

	/**
	 * <p>
	 * spring boot main method
	 * </p>
	 * in here the spring context is started and the wicket components are made
	 * spring awareby activating the SpringComponentInjector
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication
				.run(WicketWebApplication.class, args);
		WicketWebApplication wicketWebApplication = (WicketWebApplication) applicationContext
				.getBean("wicketWebApplication");
		wicketWebApplication.getComponentInstantiationListeners().add(
				new SpringComponentInjector(wicketWebApplication,
						applicationContext));
	}

	@Override
	public Class<? extends Page> getHomePage() {
		return Homepage.class;
	}

	@Override
	protected void init() {
		super.init();
		mountPage("/mounted.html", MountedPage.class);
		logger.info(exampleService.getText());
	}

}
