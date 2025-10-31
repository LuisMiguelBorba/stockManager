import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Estoque {

    private int totalEstoque = 0;

    Estoque(){
        totalEstoque = lerDados();

    }

    public void entrada(String data, String nome, int quantidade ){
        totalEstoque += quantidade;
        String linha = data+","+ nome+"," + quantidade+"\n";
        salvar("registro",linha);
        salvarTotal(totalEstoque);
    }

    public void saida(String data, String nome, int quantidade){
        totalEstoque -= quantidade;
        String linha = data+","+nome+", -"+quantidade+"\n";
        salvar("registro",linha);
        salvarTotal(totalEstoque);
    }

    public void salvarTotal(int totalEstoque){
        try {
            FileWriter arquivo = new FileWriter("totalEstoque.txt",false);
            arquivo.write(String.valueOf(totalEstoque));
            arquivo.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void salvar(String file, String linha){
        try {
            FileWriter arquivo =  new FileWriter("estoque.csv",true);
            arquivo.write(linha);
            arquivo.close();
            System.out.println("dados salvos");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int lerDados() {

        int numero = 0;
        try {
            File arquivo = new File("totalEstoque.txt");
            Scanner leitor = new Scanner(arquivo);

            if (leitor.hasNextInt()) {
                numero = leitor.nextInt();
                System.out.println("numero lido");

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return numero;
    }

    public void mostrar(){
        System.out.println("o total em estoque é de: "+totalEstoque);
    }

    public void mostrarRegistro(){

        try {
            File arquivo = new File("estoque.csv");
            Scanner input = new Scanner(arquivo);

            System.out.println("=== REGISTRO ===");
            while (input.hasNextLine()){
                String linha =  input.nextLine();
                String[] dados =  linha.split(",");

                String data = dados[0];
                String nome = dados[1];
                int quantidade = Integer.parseInt(dados[2].trim());

                System.out.printf("DATA: %s | NOME: %s | QUANTIDADE: %d%n",data,nome,quantidade);
            }
            input.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void editarEstoqueManualmente(int quantidade){
        totalEstoque = quantidade;
        System.out.println("estoque atualizado com sucesso!");
        salvarTotal(totalEstoque);
    }

}
