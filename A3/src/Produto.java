/**
 * Classe de produto, é a classe que representa todos os produtos da empresa
 */
public class Produto {

    private String nome;
    private double preco;

    /**
     * Método usado para buscar valores da criação de objetos
     * @param nome parâmetro nome do tanque
     * @param preco parâmetro preço do tanque
     */
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    /**
     * Método usado para permitir o uso do valor em outras classes
     * @return Retorna o nome do objeto
     */
    public String nome() {
        return Produto.this.nome;
    }

    /**
     * Método usado para permitir o uso do valor em outras classes
     * @return Retorna o preço do objeto
     */
    public double preco() {
        return Produto.this.preco;
    }
}
