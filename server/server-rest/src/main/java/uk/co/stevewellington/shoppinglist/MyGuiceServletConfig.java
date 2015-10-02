package uk.co.stevewellington.shoppinglist;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

import static com.google.inject.Guice.createInjector;

public class MyGuiceServletConfig extends GuiceServletContextListener {
    @Override protected Injector getInjector() {
        return createInjector(new ApplicationServletModule());
    }
}
