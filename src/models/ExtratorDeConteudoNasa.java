package models;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import exceptions.TipoDeConteudoInvalidoException;

public class ExtratorDeConteudoNasa implements ExtratorDeConteudo{

    @Override
    public List<Conteudo> extraiConteudos(String json, String url) throws TipoDeConteudoInvalidoException, IOException {

        if(!(url.equals(LeitorProperties.lePropertie("url.nasa")))) {
            throw new TipoDeConteudoInvalidoException("Tipo Json incompativel com o tipo de conteudo");
        }

        var jParser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = jParser.parse(json);
        
        return listaDeAtributos.stream()
                        .map((Map<String, String> atributos) -> new Conteudo(atributos.get("title"), atributos.get("url"), "Nasa"))
                        .toList();
    }
}
