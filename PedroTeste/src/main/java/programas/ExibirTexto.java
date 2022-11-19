package programas;


import java.util.Scanner;

public class ExibirTexto {

    public static void main(String[] args) {

    Scanner ler = new Scanner(System.in);

        String a, b;

        System.out.printf("Informe o primeiro texto: ");
        a = ler.nextLine(); // 3. entrada de dados (lendo um valor inteiro)

        System.out.printf("Informe o segundo texto.: ");
        b = ler.nextLine(); // 3. entrada de dados (lendo um valor inteiro)



       String valorTotal = a +" "+ b;

       System.out.println("Resultado");
       System.out.println(valorTotal);
    }

}
