package br.com.devlab;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author rafael.fonseca
 */
public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static final int PORT = 8080;

    public static void main(String[] args) {
        HttpServer server = new HttpServer(PORT);
        try {
            server.start();
        } catch (Exception e) {
            logger.error("Failed to start application", e);
        }
    }

    public static class HttpServer {

        private final ServletContextHandler context;
        private final Server server;

        public HttpServer(int port) {
            context = new ServletContextHandler();
            context.setContextPath("/");

            server = new Server(port);
            server.setHandler(context);

            addServlets();
        }

        private void addServlets() {
            ResourceConfig config = new ResourceConfig();
            config.packages("br.com.devlab");
            config.register(new AppBinder());

            ServletHolder jerseyServlet = new ServletHolder(new ServletContainer(config));
            jerseyServlet.setInitOrder(0);

            context.addServlet(jerseyServlet, "/*");
        }

        private void start() throws Exception {
            try {
                server.start();
                server.join();
            } finally {
                server.destroy();
            }
        }

    }

}
