import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Scanner input =  new Scanner(System.in);
        boolean cond = true;

        while (cond) {
            System.out.println("---escolha uma opcao---");
            System.out.println("0 - entrada");
            System.out.println("1 - saida");
            System.out.println("2 - estoque");
            System.out.println("3 - registro");
            System.out.println("4 - sair");
            System.out.println(" ");

            int action = input.nextInt();

            switch (action){
                case 0 -> {
                    String data = input.next();
                    String produtor = input.next();
                    int quantidade = input.nextInt();
                    estoque.entrada(data,produtor, quantidade);
                }
                case 1 ->{
                    String data = input.next();
                    String produtor = input.next();
                    int quantidade = input.nextInt();
                    estoque.saida(data, produtor, quantidade);
                }

                case 2 ->  System.out.println("total: "+estoque.getTotal());

                case 3 -> estoque.getRegistro();

                case 4 ->{
                    estoque.save(estoque.getTotal());
                    cond = false;
                    System.out.println("finalizado");
                }
                default -> System.out.println("opcao invalida");
            }
        }
    }
}