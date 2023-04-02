package models;
/*
 * Refatorando a Classe Conteudo em um Record
 * 
 * Record foi implementado definitivamente no Java a partir da versao 16. Geralmente sao implementados somente em classes para leitura de atributos.
 * 
 * Eles funcionam como uma classe com seus atributos e metodos get() sem o setters,
 * pois seu conteudo eh imutavel.
 * 
 * - Nao podem herdar de uma classe mae;
 * - Nao podem ser abstratas;
 * - Todos os seus atributos sao final, ou seja, nao podem ser reatribuidos;
 */

// sintaxe para declaracao de um record
public record Conteudo (String titulo, String urlImagem, String diretorioDeDestino){

    /*
     * Records podem ter mais de um construtor para instancia com diferentes atributos.
     * 
     * No entanto, eh necessario chamar o construtor padrao da classe passando os demais atributos como null.
     * 
     * Exemplo abaixo:
     */

    // public Conteudo(String titulo) {
    //     this(titulo, null, null);
    // }
}
