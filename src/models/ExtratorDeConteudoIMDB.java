package models;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import exceptions.TipoDeConteudoInvalidoException;

public class ExtratorDeConteudoIMDB implements ExtratorDeConteudo{
     
    @Override
    public List<Conteudo> extraiConteudos(String json, String url) throws TipoDeConteudoInvalidoException, IOException {
        
        if(!(url.equals(LeitorProperties.lePropertie("url.imdb")))) {
            throw new TipoDeConteudoInvalidoException("Tipo Json incompativel com o tipo de conteudo");
        }

        var jParser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = jParser.parse(json);

        // populando a lista de conteúdos
        return listaDeAtributos.stream()
                        .map((Map<String, String> atributos) -> new Conteudo(atributos.get("fullTitle"), atributos.get("image"), "IMDB"))
                        .toList();
    }
}
