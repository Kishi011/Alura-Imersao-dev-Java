import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudo {
    
    public List<Conteudo> extraiConteudos(String json) {
        
        var jParser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = jParser.parse(json);
        
        List<Conteudo> conteudos = new ArrayList<>();
        
        // populando a lista de conteúdos

        for(Map<String, String> atributos : listaDeAtributos) {
            conteudos.add(new Conteudo(atributos.get("fullTitle"), atributos.get("image")));
        }

        return conteudos;
    }
}
