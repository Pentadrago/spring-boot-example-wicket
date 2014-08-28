package spring.boot.example.wicket;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * This class is needed for deployment on an application server.
 * It is the counterpart of the main method in WicketWebApplication.
 *
 * @author Stefan Kloe
 */
public class WarInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WicketWebApplication.class);
    }

}
