package spring.boot.example.wicket.components;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.resource.CssResourceReference;

import spring.boot.example.wicket.WicketWebApplication;

public class MountedPage extends WebPage {

	public MountedPage() {
		add(new Label("title", "this is a mounted page"));
		add(new BookmarkablePageLink<String>("link", Homepage.class));
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		CssResourceReference cssResourceReference = new CssResourceReference(
				WicketWebApplication.class, "example.css");
		response.render(CssHeaderItem.forReference(cssResourceReference));
	}

}
