import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;                                                                                                                          import java.util.Date;                                                                                                                                                                                                                                                                                                  public class Main {                                                                                                                                             public static void main(String[] args) throws IOException {
        int port = 80;
        String message = "Hello from Java HTTP Server! Current date: " + new Date();                                                                                                                                                                                                                                            HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", exchange -> {
            String response = message;
            exchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();                                                                                                                                             });                                                                                                                                                                                                                                                                                                                     System.out.println("Server running at http://localhost:" + port);
        server.start();
    }                                                                                                                                                       }            
