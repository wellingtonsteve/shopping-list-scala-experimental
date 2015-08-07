package uk.co.stevewellington.shoppinglist;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.scalatra.servlet.ScalatraListener;

import static org.scalatra.servlet.ScalatraListener.LifeCycleKey;

public class JettyLauncher {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        WebAppContext context = new WebAppContext();
        context.setContextPath("/");
        context.setResourceBase("src/main/webapp");
        context.setInitParameter(LifeCycleKey(), "uk.co.stevewellington.shoppinglist.ScalatraBootstrap");
        context.addEventListener(new ScalatraListener());
        context.addServlet(RestServer.class, "/");
        server.setHandler(context);
        server.start();
        server.join();
    }
    
}
