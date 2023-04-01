import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
// import java.net.URL;

import javax.imageio.ImageIO;

public class GeradorDeStickers {

    private File criaNovaImagem(String nomeArquivo) throws IOException {
        File diretorio = new File("D:/Vini/Alura/Java-ImersaoDev/ConsumindoAPIStickers/saida");
        diretorio.mkdir(); // cria o diretório baseado no caminho dele
        File novoArquivoDeImagem = new File(diretorio, nomeArquivo + ".png");
        novoArquivoDeImagem.createNewFile(); // cria o arquivo

        return novoArquivoDeImagem;
    }

    public void geraSticker(InputStream inputStream, String nomeArquivo) throws IOException {
        /*
         * Fazer a leitura da imagem
         */
        //InputStream is = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg").openStream(); // abre um arquivo na internet e pelo método .openStream() retorna os bytes desse arquivo.
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        /*
         * Criar uma nova imagem com transparência e com tamanho novo
         */
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT); // cria uma nova imagem com o fundo transparente.

        /*
         * Copiar a imagem original para a nova imagem (em memória)
         */
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        /*
         * Escrever uma frase na nova imagem
         */
        // Configurando o texto
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 48)); // Define a fonte
        graphics.setColor(new Color(255, 0, 0)); // Define a cor
        graphics.drawString("IMERSÃO JAVA", 100, novaAltura - 100); //Desenha um texto nas coordenadas definidas

        /*
         * Escrever a imagem nova em um arquivo
         */
        File novoArquivoDeImagem = criaNovaImagem(nomeArquivo);
        ImageIO.write(novaImagem, "png", novoArquivoDeImagem);
    }
}
