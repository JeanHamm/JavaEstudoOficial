package exercicios.PDV;

import java.util.ArrayList;
import java.util.List;

public class Transacao {
    private List<Produtos> catalogo;
    private List<Produtos> historico;
    private double valorTotalDeTransacao;
    private int quantidadeTotalDeTransacao;

    //Getter
    public List<Produtos> getCatalogo() {
        return catalogo;
    }

    public List<Produtos> getHistorico() {
        return historico;
    }

    public double getValorTotalDeTransacao() {
        return valorTotalDeTransacao;
    }

    public int getQuantidadeTotalDeTransacao() {
        return quantidadeTotalDeTransacao;
    }

    //builder
    public Transacao() {
        this.catalogo = new ArrayList<Produtos>();
        this.historico = new ArrayList<Produtos>();
    }



    // Methodo
    public void adicionaProdutoLista(Produtos produto){
        this.catalogo.add(produto);
    }
    public void adicionaProdutoHistorico(Produtos produto){
        this.historico.add(produto);
    }

    public void vendendo(Produtos produto, int quantidade){
        produto.novasVendas(quantidade);
        Produtos produtoDeVenda = new Produtos(produto.getDescricao(), produto.getValor());
        produtoDeVenda.novasVendas(quantidade);
        adicionaProdutoHistorico(produtoDeVenda);
        this.valorTotalDeTransacao += produto.getQuantidadeTotalValor();
        this.quantidadeTotalDeTransacao += produto.getQuantidadeVendida();
    }







}
