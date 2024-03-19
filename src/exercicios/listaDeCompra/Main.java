package exercicios.listaDeCompra;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("------------ SEJA BEM VINDO! ------------");
        Scanner leitor = new Scanner(System.in);
        Scanner leitor2 = new Scanner(System.in);


        System.out.printf("Limite do cartão: R$");
        double limiteCard = leitor.nextDouble();
        CartaoDeCredito card = new CartaoDeCredito(limiteCard);

        boolean sair = true;

        while (sair == true){
            System.out.println("\n------------ SHOPPING ------------");
            System.out.println("Limite: R$" + card.getSaldo() + "\n");
            System.out.printf("Nome do produto: ");
            String nameProduto = leitor2.nextLine();
            System.out.printf("Valor: ");
            double valorProduto = leitor.nextDouble();

            Compras compra = new Compras(valorProduto, nameProduto);

            sair = card.comprando(compra);

            if(sair == true)
            {System.out.printf("\n0 - Encerrar\n1 - Nova Compra\nReposta: ");
            int retorno = leitor.nextInt();
            if(retorno != 1){
                System.out.println("Numero invalido!");
                sair = false;
            }}
        }

        System.out.println("\n------------ COMPRAS FEITAS ------------");
        for(Compras comprei: card.getExtrato()){
            comprei.imprime();
        }
        System.out.println("\nLimite utilizado: R$" + (card.getLimite() - card.getSaldo()));
        System.out.println("Limite restante: R$" + card.getSaldo());
        System.out.println("\n\nSistema finalizado");




    }
}