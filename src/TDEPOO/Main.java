package TDEPOO;

public class Main {

    public static void main(String[] args) {

        int numero;

        for (int i = 0; i < 10; i++) {
            numero = (int) (Math.random()*1000);
            while (numero < 10){
                numero = (int) (Math.random()*20);
            }
            System.out.println(numero);
        }
    }
}
