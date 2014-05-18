package spring.boot.example.wicket;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.boot.example.wicket.components.Homepage;
import spring.boot.example.wicket.components.MountedPage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebInitializer.class,
		WicketWebApplication.class })
public class WicketWebApplicationTest {

	@Autowired
	private TestService testService;

	@Test
	public void testApplication() {
		WicketTester wicketTester = testService.getWicketTester();
		wicketTester.startPage(Homepage.class);
		wicketTester.assertRenderedPage(Homepage.class);
	}

	@Test
	public void testMountedPage() {
		WicketTester wicketTester = testService.getWicketTester();
		wicketTester.startPage(MountedPage.class);
		wicketTester.assertRenderedPage(MountedPage.class);
	}

}
