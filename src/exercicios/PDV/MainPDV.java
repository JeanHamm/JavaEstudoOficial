package exercicios.PDV;

import java.util.Scanner;

public class MainPDV {
    public static void main(String[] args) {

        //Bulding
        Scanner leitor1 = new Scanner(System.in);
        Scanner leitor2 = new Scanner(System.in);
        Scanner leitor3 = new Scanner(System.in);

        Textos text = new Textos();
        Transacao transacao = new Transacao();



        boolean central = true;



        //MENU
        while (central == true){

            text.linhas("MENU");

            System.out.printf("1 - Venda\n2 - Produtos\n3 - Ultimas vendas\n4 - Relatorio de vendas\n0 - Sair\n\nESCOLHA: ");
            int escolha = leitor1.nextInt();


            switch (escolha) {
                case 0:
                    central = false;
                    break;
                case 1:
                    // VENDAS

                    boolean centralVendas = true;
                    while (centralVendas == true) {
                        text.linhas("VENDA");

                        //Validador se há na lista
                        if (transacao.getCatalogo().size() == 0) {
                            System.out.println("nan - Nenhum");
                        } else {
                            // Mostra toda a lista
                            int i = -1;
                            for (Produtos produto : transacao.getCatalogo()) {
                                i++;
                                System.out.println(i + " : " + produto.getDescricao() + " - R$" + produto.getValor());
                            }
                        }

                        // Escolha
                        System.out.printf("\n1 - Comprar\n0 - Voltar para o Menu\n\nEscolha: ");
                        escolha = leitor1.nextInt();

                        //Valida escolha para sair
                        if (escolha == 0) {
                            centralVendas = false;
                        }

                        while (escolha == 1) {
                            if (escolha == 1) {
                                text.linhas("VENDENDO");

                                int i = -1;
                                for (Produtos produto : transacao.getCatalogo()) {
                                    i++;
                                    System.out.println(i + " : " + produto.getDescricao() + " - R$" + produto.getValor());
                                }

                                System.out.printf("\nNumero do produto: ");
                                int numeroDoProduto = leitor3.nextInt();
                                System.out.printf("Quantidade do produto: ");
                                int quantidadeDeProduto = leitor2.nextInt();

                                int b = 0;
                                for(Produtos produtos: transacao.getCatalogo()){
                                    if (b == numeroDoProduto){
                                        transacao.vendendo(produtos, quantidadeDeProduto);
                                    }
                                    b++;
                                }
                            } else {
                                // Saida do menu
                                centralVendas = false;
                            }
                            if (escolha == 1){
                                // Escolha
                                System.out.printf("\n1 - Nova venda\n0 - Voltar para o vendas\n\nEscolha: ");
                                escolha = leitor1.nextInt();
                            }

                        }

                    }


                    break;
                case 2:
                        //PRODUTOS
                        boolean centralProdutos = true;
                        while (centralProdutos == true){
                            text.linhas("Produtos");

                            //Validador se há na lista
                        if (transacao.getCatalogo().size() == 0){
                            System.out.println("nan - Nenhum");
                        }else{

                            // Mostra toda a lista
                            int i =-1;
                            for(Produtos produto: transacao.getCatalogo()) {
                                i++;
                                System.out.println(i + " : " + produto.getDescricao() + " - R$" + produto.getValor());
                                }
                            }

                            // Escolha
                            System.out.printf("\n1 - Cadastrar produtos\n0 - Voltar para o Menu\n\nEscolha: ");
                            escolha = leitor1.nextInt();

                            //Valida escolha para sair
                            if (escolha == 0){
                                centralProdutos = false;
                            }

                            // Valida para Criador do produto
                            while (escolha == 1) {
                                if (escolha == 1) {
                                    text.linhas("Cadastro");

                                    System.out.printf("\nNome do produto: ");
                                    String descricao = leitor3.nextLine();
                                    System.out.printf("Valor do produto: ");
                                    double valor = leitor2.nextDouble();

                                    Produtos produtos = new Produtos(descricao, valor);
                                    transacao.adicionaProdutoLista(produtos);
                                } else {
                                    // Saida do menu
                                    centralProdutos = false;
                                }
                                if (escolha == 1){
                                    // Escolha
                                    System.out.printf("\n1 - Cadastrar mais produtos\n0 - Voltar para o Produtos\n\nEscolha: ");
                                    escolha = leitor1.nextInt();
                                }

                            }

                        }

                    break;
                case 3:
                    boolean centralHistorico = true;
                    while (centralHistorico == true){
                        text.linhas("Historico");
                        System.out.println("\n");
                        //Mostra Vendas
                        for (Produtos produtos: transacao.getHistorico()){
                            text.miniLinhas(produtos.getDescricao());
                            System.out.println("Valor individual: R$" + produtos.getValor() + "\nQuantidade: " +  produtos.getQuantidadeVendida() + "\nValor total: R$" + produtos.getQuantidadeTotalValor());
                        }
                        text.miniLinhas("Resumo");
                        System.out.println("\nTotal de vendas: " + transacao.getQuantidadeTotalDeTransacao()+ "\nValor total: R$" + transacao.getValorTotalDeTransacao());
                        // Escolha
                        System.out.printf("\n0 - Voltar para o Menu\n\nEscolha: ");
                        escolha = leitor1.nextInt();

                        //Valida escolha para sair
                        if (escolha == 0){
                            centralHistorico = false;
                        }
                    }


                    break;
                case 4:
                        boolean centralRelatorioDeVendas = true;
                        while (centralRelatorioDeVendas == true){
                            int i =-1;
                            for(Produtos produtos: transacao.getCatalogo()) {
                                text.miniLinhas(produtos.getDescricao());
                                System.out.println("Valor individual: R$" + produtos.getValor() + "\nQuantidade: " +  produtos.getQuantidadeVendida() + "\nValor total: R$" + produtos.getQuantidadeTotalValor());
                            }
                            text.miniLinhas("Resumo");
                            System.out.println("\nTotal de vendas: " + transacao.getQuantidadeTotalDeTransacao()+ "\nValor total: R$" + transacao.getValorTotalDeTransacao());
                            // Escolha
                            System.out.printf("\n0 - Voltar para o Menu\n\nEscolha: ");
                            escolha = leitor1.nextInt();

                            //Valida escolha para sair
                            if (escolha == 0){
                                centralRelatorioDeVendas = false;
                            }
                            break;
                        }


            }

        }


    }
}


