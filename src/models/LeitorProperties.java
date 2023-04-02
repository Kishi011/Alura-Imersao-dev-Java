package models;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LeitorProperties {
    
    public static String lePropertie(String propertie) {
        try {
            /*
            * Criando um arquivo .properties separado para guardar a url do Json,
            * isso oculta dados sensiveis dentro do nosso codigo.
            */
            Properties props = new Properties();
            InputStream file = new FileInputStream("configuracoes.properties");
            props.load(file); // carrega o arquivo .properties na variavel.

            return props.getProperty(propertie);
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
