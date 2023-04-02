package models;
public enum API {
    IMDB_TOP_MOVIES(LeitorProperties.lePropertie("url.imdb"), new ExtratorDeConteudoIMDB()),
    NASA(LeitorProperties.lePropertie("url.nasa"), new ExtratorDeConteudoNasa());

    private String url;
    private ExtratorDeConteudo extractor;

    API(String url, ExtratorDeConteudo extractor) {
        this.url = url;
        this.extractor = extractor;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    public ExtratorDeConteudo getExtratorDeConteudo() {
        return extractor;
    }
}
