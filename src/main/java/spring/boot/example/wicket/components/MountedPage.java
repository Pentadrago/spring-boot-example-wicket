package spring.boot.example.wicket.components;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.spring.injection.annot.SpringBean;

import spring.boot.example.wicket.WicketWebApplication;
import spring.boot.example.wicket.services.TextService;

/**
 * sample page to show mounting and spring integration
 *
 * @author Stefan Kloe
 *
 */
public class MountedPage extends WebPage {

    /* spring integration the wicket way */
    @SpringBean
    private TextService exampleService;

    public MountedPage() {
        add(new Label("title", "this is a mounted page"));
        add(new BookmarkablePageLink<String>("link", Homepage.class));
        /* showcase spring integration in wicket component */
        add(new Label("serviceText", exampleService.getText()));
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
        CssResourceReference cssResourceReference = new CssResourceReference(
                WicketWebApplication.class, "example.css");
        response.render(CssHeaderItem.forReference(cssResourceReference));
    }

}
