import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
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
        String url = props.getProperty("prop.url");
        /*
         * Pegar somente os dados interesantes para a aplicação
         * extrair os seguintes dados (titulo, poster, avaliação).
         */

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        ExtratorDeConteudo extrator = new ExtratorDeConteudo();
        List<Conteudo> listaDeConteudos = extrator.extraiConteudos(json);
        /*
         * exibir e manipular os dados na aplicação
         */
        GeradorDeStickers gerador = new GeradorDeStickers();

        for (Conteudo conteudo : listaDeConteudos) {

            /*
             * Gerando stickers para cada um dos filmes da lista
             */
            String urlImagem = conteudo.getUrlImagem();
            InputStream inputStream = new URL(urlImagem).openStream();

            String tituloFilme = conteudo.getTitulo();

            gerador.geraSticker(inputStream, tituloFilme);

            /*
             * Printando as principais informações do filme
             */

            System.out.println("Título: " + conteudo.getTitulo());
            // System.out.println("Poster: " + conteudo.get("image"));
            // System.out.println("\u001b[1m\u001b[45m" + "Classificação: " +
            // conteudo.get("imDbRating") + "\u001b[m");
            // double classificacao = Double.parseDouble(conteudo.get("imDbRating"));
            // int numeroDeEstrelas = (int) classificacao;
            // for(int i = 1; i <= numeroDeEstrelas; i++) {
            // System.out.print("⭐");
            // }
            System.out.println();
        }
    }
}
