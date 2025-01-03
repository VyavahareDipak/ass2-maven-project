package com.example.automation;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class mainApplication {
    public static void main(String[] args) throws Exception {
        // Set up an embedded HTTP server
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        
        // Set up a handler for the login page
        server.createContext("/login", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {
                // Define the HTML content for the login page
                String response = "<!DOCTYPE html>" +
                        "<html lang='en'>" +
                        "<head>" +
                        "<meta charset='UTF-8'>" +
                        "<meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                        "<title>Login</title>" +
                        "</head>" +
                        "<body>" +
                        "<form>" +
                        "<label for='username'>Username:</label>" +
                        "<input type='text' id='username' name='username'><br>" +
                        "<label for='password'>Password:</label>" +
                        "<input type='password' id='password' name='password'><br>" +
                        "<button id='loginButton' type='submit'>Login</button>" +
                        "</form>" +
                        "</body>" +
                        "</html>";
                
                // Send the response to the browser
                exchange.sendResponseHeaders(200, response.getBytes().length);
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            }
        });

        // Start the server
        System.out.println("Starting server on http://localhost:8000/login");
        server.start();
    }
}
