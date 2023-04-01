public class Conteudo {
    private final String titulo;
    private final String urlImagem;
    private final String tipoDeConteudo;

    /**
     * @param titulo
     * @param urlImagem
     */
    public Conteudo(String titulo, String urlImagem, String tipoDeConteudo) {
        this.titulo = titulo;
        this.urlImagem = urlImagem;
        this.tipoDeConteudo = tipoDeConteudo;
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
    public String getTipoDeConteudo() {
        return tipoDeConteudo;
    }
}
