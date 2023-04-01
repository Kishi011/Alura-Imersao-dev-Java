public class Conteudo {
    private final String titulo;
    private final String urlImagem;

    /**
     * @param titulo
     * @param urlImagem
     */
    public Conteudo(String titulo, String urlImagem) {
        this.titulo = titulo;
        this.urlImagem = urlImagem;
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
}
