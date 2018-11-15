package TDEPOO;

public class Main {

    public static void main(String[] args) {

        /*
        double numero;

        for (int i = 0; i < 10; i++) {
            numero = Math.random()*100;
            System.out.println((int)numero);
            if((int) numero < 9){
                System.out.println("Você desviou");
            }
        }
        */

        // Itens
            // Arma
            Item itemA1 = new Item("Espada", "uma espada pequena", 3, 2, 5, 0, 0, 0, 0, 25, 0);
            Item drop2 = new Item("Espada Melhor", "Espada de madeira enfeitiçada, tétano+3", 3, 2, 10, 0, 0, 0,0, 40, 0);
            // Defesa
            Item itemD1 = new Item("Escudo", "um escudo pequeno", 2, 0, 0, 0, 0, 0, 0, 0, 20);
            Item drop3 = new Item("Armadura Brilhante", "Armadura nova", 1,0,0,0,0,25,0,0,5);
            // Armadura
            Item itemAr1 = new Item("Roupa", "uma roupa leve", 1, 0, 0, 0, 5, 0, 0, 0, 0);
            // Poção
            Item pocao1 = new Item("Poção de rocambole", "uma poção de vida", 4, 0, 0, 0, 0, 0, 150, 0, 0);
            Item drop1 = new Item("Poção de Vida", "uma poção de vida", 4, 0, 0, 0, 0, 0, 50, 0,0);

        // Monstros
            // Primeira fase
            Monstro monstro11 = new Monstro(false, "orc", null, null, 50, 5, 5, 3);
            Monstro monstro12 = new Monstro(false, "orc", null, null, 50, 5, 5, 4);
            Monstro boss1 = new Monstro(true, "Robertão", drop1, "o rei dos orcs", 75, 5, 5, 3);

            // Segunda fase
            Monstro monstro21 = new Monstro(false, "goblin", null, null, 75, 7, 7, 2);
            Monstro monstro22 = new Monstro(false, "goblin", null, null, 75, 7, 7, 2);
            Monstro boss2 = new Monstro(true, "Jorgin", drop2, "o rei dos goblins", 100, 7, 7, 2);

            // Terceira fase
            Monstro monstro31 = new Monstro(false, "troll", null, null, 100, 10,10, 1);
            Monstro monstro32 = new Monstro(false, "troll", null, null, 100, 10,10 , 1);
            Monstro boss3 = new Monstro(true, "Gilberto", drop3, "o rei dos trolls", 125, 12,12, 1);

        // Classes
        Classe  classe1 = new Classe("Guerreiro", itemD1, itemA1, itemAr1, 10, 4, 4, 5, 2);

        // Player
        Player player1 = new Player("Roberto", classe1);

        // Fase
        Fase fase1 = new Fase("Caverna");
        Fase fase2 = new Fase("Floresta");
        Fase fase3 = new Fase("Cu de judas");

        // Game Controller
        gameController gc1 = new gameController(player1);

        // Adição final
        fase1.addMonstros(monstro11);
        fase1.addMonstros(monstro12);
        fase1.addMonstros(boss1);

        fase2.addMonstros(monstro21);
        fase2.addMonstros(monstro22);
        fase2.addMonstros(boss2);

        fase3.addMonstros(monstro31);
        fase3.addMonstros(monstro32);
        fase3.addMonstros(boss3);

        gc1.addFases(fase1);
        gc1.addFases(fase2);
        gc1.addFases(fase3);

        while(true){
            gc1.gameplayLoop();
        }

    }
}
