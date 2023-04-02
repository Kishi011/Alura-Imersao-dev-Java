package models;
import java.io.IOException;
import java.util.ArrayList;
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
        
        List<Conteudo> conteudos = new ArrayList<>();
        // populando a lista de conteúdos
        listaDeAtributos.forEach(atributo -> conteudos.add(new Conteudo(atributo.get("fullTitle"), atributo.get("image"), "IMDB")));

        return conteudos;        
    }
}
