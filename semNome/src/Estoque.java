import java.io.*;
import java.util.Scanner;

public class Estoque {
    private int total = carregar();

    public void entrada(String data, String produtor, int quantidade){
        total+= quantidade;
        registro(data,produtor,quantidade,1);

    }

    public void saida(String data, String produtor, int quantidade){
        total-= quantidade;
        registro(data,produtor,quantidade,0);

    }

    public void save(int quantidade){

        try {
            FileWriter arquivo = new FileWriter("estoque.txt", true);
            PrintWriter gravar = new PrintWriter(arquivo);

            gravar.println(quantidade);
            gravar.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int carregar(){
        File arquivo = new File("estoque.txt");
        if (!arquivo.exists()) {
            return 0; // Se o arquivo não existir, começa em 0
        }

        try (Scanner leitor = new Scanner(arquivo)){
            int ultima = 0;
            while (leitor.hasNextInt()) {
                ultima = leitor.nextInt();
            }
            leitor.close();
            return ultima;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("erro em carregar dados");
        }
    }

    public void registro(String data,String produtor, int quantidade, int action ){
        try {
            FileWriter arquivo =  new FileWriter("registro.txt",true);
            PrintWriter gravar =  new PrintWriter(arquivo);

            if(action==1){
                gravar.println(data+","+produtor+","+quantidade);
            }else {
                gravar.println(data+",-"+produtor+","+quantidade);
            }

            gravar.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getTotal(){
        return total;
    }

    public void getRegistro() {

        try {
            File arquivo = new File("registro.txt");
            Scanner leitor = new Scanner(arquivo);

            System.out.println("lista de registro");
            System.out.println(" ");

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine();
                System.out.println(linha);
            }
            System.out.println(" ");
            leitor.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
