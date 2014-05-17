package spring.boot.example.wicket;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.boot.example.wicket.components.Homepage;
import spring.boot.example.wicket.components.MountedPage;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class WicketWebApplication extends WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WicketWebApplication.class, args);
	}

	@Override
	public Class<? extends Page> getHomePage() {
		return Homepage.class;
	}

	@Override
	protected void init() {
		super.init();
		mountPage("/mounted.html", MountedPage.class);
	}

}
