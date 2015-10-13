package uk.co.stevewellington.shoppinglist;

import com.google.inject.servlet.GuiceFilter;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import javax.servlet.DispatcherType;

import static java.util.EnumSet.allOf;

class JettyLauncher {

    static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
        handler.addFilter(GuiceFilter.class, "/*", allOf(DispatcherType.class));
        handler.addEventListener(new MyGuiceServletConfig());
        server.setHandler(handler);
        server.start();
        server.join();
    }
    
}
