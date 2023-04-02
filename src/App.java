import java.io.InputStream;
import java.net.URL;
import java.util.List;

import models.ClienteHttp;
import models.Conteudo;
import models.ExtratorDeConteudo;
import models.ExtratorDeConteudoNasa;
import models.ExtratorDeConteudoIMDB;
import models.GeradorDeStickers;
import models.LeitorProperties;

public class App {
    public static void main(String[] args) throws Exception {

        String url = LeitorProperties.lePropertie("url.nasa");
        /*
         * Pegar somente os dados interesantes para a aplicação
         * extrair os seguintes dados (titulo, poster, avaliação).
         */

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        ExtratorDeConteudo extrator = new ExtratorDeConteudoNasa();
        List<Conteudo> listaDeConteudos = extrator.extraiConteudos(json, url);
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

            gerador.geraSticker(inputStream, conteudo.getTitulo(), conteudo.getDiretorioDeDestino());

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
