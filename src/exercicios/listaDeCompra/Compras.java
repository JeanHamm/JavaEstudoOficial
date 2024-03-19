package exercicios.listaDeCompra;

public class Compras {
    private double valor;
    private String descricao;

    public Compras(double valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void imprime(){
        System.out.println(this.descricao + " - R$" + this.valor);
    }
}
