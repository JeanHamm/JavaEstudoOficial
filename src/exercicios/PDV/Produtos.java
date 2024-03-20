package exercicios.PDV;

public class Produtos {
    private String descricao;
    private double valor;
    private int quantidadeVendida;

    private double quantidadeTotalValor;


    //Builder
    public Produtos(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
        this.quantidadeTotalValor = 0;
        this.quantidadeVendida = 0;
    }

    //getters
    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public double getQuantidadeTotalValor() {
        return quantidadeTotalValor;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void novasVendas(int quantidade){
        this.quantidadeVendida += quantidade;
        this.quantidadeTotalValor = quantidadeVendida * valor;
    }


}
