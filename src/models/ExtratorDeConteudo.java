package models;
import java.io.IOException;
import java.util.List;

import exceptions.TipoDeConteudoInvalidoException;

public interface ExtratorDeConteudo {

    List<Conteudo> extraiConteudos(String json, String url) throws TipoDeConteudoInvalidoException, IOException;
}
