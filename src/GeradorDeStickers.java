import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GeradorDeStickers {

    public static File criaNovaImagem() throws IOException {
        File diretorio = new File("D:\\Vini\\Alura\\Java-ImersaoDev\\ConsumindoAPIStickers\\saida");
        diretorio.mkdir();
        File novoArquivoDeImagem = new File(diretorio, "filme.png");
        novoArquivoDeImagem.createNewFile();

        return novoArquivoDeImagem;
    }

    public void geraSticker() throws IOException {
        /*
         * Fazer a leitura da imagem
         */
        BufferedImage imagemOriginal = ImageIO.read(new File("imagens/filme.jpg"));

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

        /*
         * Escrever a imagem nova em um arquivo
         */
        File novoArquivoDeImagem = criaNovaImagem();
        ImageIO.write(novaImagem, "png", novoArquivoDeImagem);
    }

    public static void main(String[] args) throws IOException {
        var gerador = new GeradorDeStickers();
        gerador.geraSticker();
    }
}
