package models;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClienteHttp {
    
    public String buscaDados(String url) {

        try {        
        /*
         * Fazer uma conexão HTTP e buscar os TOP 250 filmes do IMDb
         */
        
        // a palavra reservada var foi implementada a partir do Java 10, ele
        // auto-detecta o tipo da variável sem precisar declará-la explicitamente.
        var client = HttpClient.newHttpClient(); // método stático do HttpClient que retorna uma nova instância do
                                                 // HttpClient
        var request = HttpRequest.newBuilder(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body(); // retorna aquele arquivo .JSON em formato de String;
        
        return body;
        
        } catch(IOException | InterruptedException e) {
            System.out.println(e);
        }
        return null;
    }
}
