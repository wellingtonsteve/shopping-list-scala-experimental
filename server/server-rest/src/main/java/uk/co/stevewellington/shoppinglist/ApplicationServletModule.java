package uk.co.stevewellington.shoppinglist;

import com.google.inject.servlet.ServletModule;

public class ApplicationServletModule extends ServletModule {

    @Override protected void configureServlets() {
        serve("/*").with(RestServer.class);
    }
}
