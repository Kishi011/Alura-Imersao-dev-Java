import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoIMDB implements ExtratorDeConteudo{
     
    @Override
    public List<Conteudo> extraiConteudos(String json) {
        
        var jParser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = jParser.parse(json);
        
        List<Conteudo> conteudos = new ArrayList<>();
        
        // populando a lista de conteúdos

        listaDeAtributos.forEach(atributo -> conteudos.add(new Conteudo(atributo.get("fullTitle"), atributo.get("image"), "IMDB")));

        return conteudos;
    }
}
