package TDEPOO;

public class Main {

    public static void main(String[] args) {

        /*
        int numero;

        for (int i = 0; i < 10; i++) {
            numero = (int) (Math.random()*1000);
            while (numero < 10){
                numero = (int) (Math.random()*20);
            }
            System.out.println(numero);
        }
        */

        Item itemA1 = new Item("Espada", "uma espada pequena", 3, 2, 5, 0, 0, 0, 0, 25, 0);
        Item itemD1 = new Item("Escudo", "um escudo pequeno", 2, 0, 0, 0, 0, 0, 0, 0, 20);
        Item itemAr1 = new Item("Roupa", "uma roupa leve", 1, 0, 0, 0, 5, 0, 0, 0, 0);

        Item pocao1 = new Item("Poção de rocambole", "uma poção de vida", 4, 0, 0, 0, 0, 0, 50, 0, 0);

        Classe  classe1 = new Classe("Guerreiro", itemD1, itemA1, itemAr1, 10, 4, 4, 5, 2);

        Player player1 = new Player("Roberto", classe1);

        gameController gc1 = new gameController();

        gc1.setPlayer(player1);
        player1.guardarPocao(pocao1);
        player1.guardarPocao(pocao1);
        player1.setVidaAtual(50);
        player1.usarPocao(1);

        while(true){
            gc1.gameplayLoop();
        }

    }
}
