package exercicios.listaDeCompra;

import java.util.ArrayList;
import java.util.List;

public class CartaoDeCredito {
    private double limite;
    private double saldo;
    private List<Compras> extrato;

    public CartaoDeCredito(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.extrato = new ArrayList<>();
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public List<Compras> getExtrato() {
        return extrato;
    }

    public boolean comprando(Compras compras) {
        if (this.saldo >= compras.getValor()){
            saldo -= compras.getValor();
            this.extrato.add(compras);
            return true;
        }else {
            System.out.println("Você não tem limite\nLimite: R$" + this.limite);
            return false;
        }
    }
}
