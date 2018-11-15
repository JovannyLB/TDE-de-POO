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


        //Itens
        Item itemA1 = new Item("Espada", "uma espada pequena", 3, 2, 5, 0, 0, 0, 0, 25, 0);
        Item itemD1 = new Item("Escudo", "um escudo pequeno", 2, 0, 0, 0, 0, 0, 0, 0, 20);
        Item itemAr1 = new Item("Roupa", "uma roupa leve", 1, 0, 0, 0, 5, 0, 0, 0, 0);

        Item pocao1 = new Item("Poção de rocambole", "uma poção de vida", 4, 0, 0, 0, 0, 0, 50, 0, 0);

            //Drops
        Item drop1 = new Item("Poção de Vida", "uma poção de vida", 4, 0, 0, 0, 0, 0, 50, 0,0);
        Item drop2 = new Item("Espada Melhor", "Espada de madeira enfeitiçada, tétano+3", 3, 2, 10, 0, 0, 0,0, 40, 0);
        Item drop3 = new Item("Armadura Brilhante", "Armadura nova", 1,0,0,0,0,25,0,0,5);

        //Monstros

            //primeira fase

        Monstro monstro11 = new Monstro(false, "Orc", null, null, 50, 5, 5);
        Monstro monstro12 = new Monstro(false, "Orc", null, null, 50, 5, 5);
        Monstro boss1 = new Monstro(true, "Orc", drop1, "O rei dos Orcs", 75, 5, 5);

            //segunda fase

        Monstro monstro21 = new Monstro(false, "Goblin", null, null, 75, 7, 7);
        Monstro monstro22 = new Monstro(false, "Goblin", null, null, 75, 7, 7);
        Monstro boss2 = new Monstro(true, "Goblin", drop2, "O rei dos goblin", 100, 7, 7);

            //terceira fase

        Monstro monstro31 = new Monstro(false, "Troll", null, null, 100, 10,10);
        Monstro monstro32 = new Monstro(false, "Troll", null, null, 100, 10,10);
        Monstro boss3 = new Monstro(true, "Troll", drop3, "O rei dos Trolls", 125, 12,12);


        //Classes
        Classe  classe1 = new Classe("Guerreiro", itemD1, itemA1, itemAr1, 10, 4, 4, 5, 2);
        //Player
        Player player1 = new Player("Roberto", classe1);

        gameController gc1 = new gameController();

        gc1.setPlayer(player1);
        player1.guardarPocao(pocao1);
        player1.guardarPocao(pocao1);
        player1.guardarPocao(pocao1);   
        player1.setVidaAtual(50);
        player1.usarPocao(1);

        while(true){
            gc1.gameplayLoop();
        }

    }
}
