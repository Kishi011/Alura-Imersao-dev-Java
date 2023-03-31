import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class App {
    public static void main(String[] args) throws Exception {
        /*
         * Criando um arquivo .properties separado para guardar a url do Json,
         * isso oculta dados sensiveis dentro do nosso codigo.
         */
        Properties props = new Properties();
        InputStream file = new FileInputStream("configuracoes.properties");
        props.load(file); // carrega o arquivo .properties na variavel.
        /*
         * Fazer uma conexão HTTP e buscar os TOP 250 filmes do IMDb
         */
        String url = props.getProperty("prop.url"); // pega o valor contido dentro da propriedade com o nome passado na funcao
        // a palavra reservada var foi implementada a partir do Java 10, ele
        // auto-detecta o tipo da variável sem precisar declará-la explicitamente.
        var client = HttpClient.newHttpClient(); // método stático do HttpClient que retorna uma nova instância do
                                                 // HttpClient
        var request = HttpRequest.newBuilder(URI.create(url))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body(); // retorna aquele arquivo .JSON em formato de String;

        /*
         * Pegar somente os dados interesantes para a aplicação
         * extrair os seguintes dados (titulo, poster, avaliação).
         */

        var jParser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = jParser.parse(body);

        /*
         * exibir e manipular os dados na aplicação
         */

        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println("Título: " + filme.get("title"));
            System.out.println("Poster: " + filme.get("image"));
            System.out.println("\u001b[1m\u001b[45m" + "Classificação: " + filme.get("imDbRating") + "\u001b[m");
            double classificacao = Double.parseDouble(filme.get("imDbRating"));
            int numeroDeEstrelas = (int) classificacao;
            for(int i = 1; i <= numeroDeEstrelas; i++) {
                System.out.print("⭐");
            }   
            System.out.println("\n");
        }
    }
}
