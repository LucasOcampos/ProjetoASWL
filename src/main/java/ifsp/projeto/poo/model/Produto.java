package ifsp.projeto.poo.model;

public class Produto {

    private String codigoBarra;
    private String nome;   
    private Double precoCusto;
    private Double precoVenda;
    private Integer quantidadeEstoque;
    private String categoria;

    public Produto() {
    }

    public Produto(String codigoBarra, String nome, Double precoCusto, Double precoVenda, Integer quantidadeEstoque,
            String categoria) {
        this.codigoBarra = codigoBarra;
        this.nome = nome;    
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
    }  
    
    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCodigoBarra() {
        return codigoBarra;
    }
    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }
    public Double getPrecoCusto() {
        return precoCusto;
    }
    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }
    public Double getPrecoVenda() {
        return precoVenda;
    }
    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }    
}