import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Scanner input = new Scanner(System.in);

        String data,nome;
        int quantidade;

        while (true){
            System.out.println(" ");
            System.out.println("0 - entrada");
            System.out.println("1 - saida");
            System.out.println("2 - mostrar");
            System.out.println("3 - sair");
            System.out.println("4 - registro");
            System.out.println("5 - editar estoque");
            System.out.println(" ");
            System.out.println("digite sua opcao: ");
            int acao = input.nextInt();
            switch (acao){

                case 0: //entrada
                    data = input.next();
                    nome = input.next();
                    quantidade = input.nextInt();
                    estoque.entrada(data,nome,quantidade);
                    break;
                case 1: //saida
                    data = input.next();
                    nome = input.next();
                    quantidade = input.nextInt();

                    estoque.saida(data,nome,quantidade);
                    break;

                case 2:
                    estoque.mostrar();
                    break;
                case 3:
                    return;

                case 4:
                    estoque.mostrarRegistro();
                    break;
                case 5:
                    quantidade = input.nextInt();
                    estoque.editarEstoqueManualmente(quantidade);
            }
        }
    }
}