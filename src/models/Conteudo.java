package models;
public class Conteudo {
    private final String titulo;
    private final String urlImagem;
    private final String diretorioDeDestino;

    /**
     * @param titulo
     * @param urlImagem
     */
    public Conteudo(String titulo, String urlImagem, String diretorioDeDestino) {
        this.titulo = titulo;
        this.urlImagem = urlImagem;
        this.diretorioDeDestino = diretorioDeDestino;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @return the urlImagem
     */
    public String getUrlImagem() {
        return urlImagem;
    }

    /**
     * @return the tipoDeConteudo
     */
    public String getDiretorioDeDestino() {
        return diretorioDeDestino;
    }
}
