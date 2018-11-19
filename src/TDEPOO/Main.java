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
            // Itens iniciais
                // Guerreiro
                Item itemAIniG = new Item("Faca com tétano", "uma simples faca pequena, velha e suja, muito suja", 3, 2, 5, 0, 0, 0, 0, 5, 0);
                Item itemDIniG = new Item("Escudo rachado", "um escudo de madeira que vagamente lembra uma roda de carroça", 2, 0, 0, 0, 0, 0, 0, 0, 5);
                Item itemArIniG = new Item("Sunga de ferro", "não é aconselhável molhá-la", 1, 0, 0, 0, 5, 0, 0, 0, 0);
                // Mago
                Item itemAIniM = new Item("Varinha do iniciante", "provavelmente roubada, pode ser facilmente confundida com um graveto normal", 3, 3, 0, 5, 0, 0, 0, 10, 0);
                Item itemDIniM = new Item("Escudo rachado", "um escudo de madeira que vagamente lembra uma roda de carroça", 2, 0, 0, 0, 0, 0, 0, 0, 5);
                Item itemArIniM = new Item("Capa velha", "feita da cortina da vó de alguém", 1, 0, 0, 2, 2, 0, 0, 0, 0);
                // Arqueiro
                Item itemAIniA = new Item("Arco vagabundo", "pode ser feito por qualquer um que tenha um cérebro, um graveto e um barbante", 3, 1, 3, 0, 4, 0, 0, 8, 0);
                Item itemDIniA = new Item("Escudo rachado", "um escudo de madeira que vagamente lembra uma roda de carroça", 2, 0, 0, 0, 0, 0, 0, 0, 5);
                Item itemArIniA = new Item("Cuecão de couro", "55% polyester e o resto couro gaucho", 1, 0, 0, 0, 7, 0, 0, 0, 0);

            // Arma
            Item drop = new Item("Adaga puro sangue", "uma adaga que passou entre várias gerações. Era usada para pactos de lealdade á família.", 3, 2, 10, 0, 0, 0, 10, 15, 0);
            Item drop1 = new Item("Arco lignum vitae", "um arco feito com uma das madeiras mais nobres do mundo", 3, 1, 5, 0, 3, 1, 0, 20, 0);
            Item drop2 = new Item("Cajado encantado", "um cajado com uma aurá magica inigualável", 3, 3, 3, 8, 1, 1, 0, 20, 0);

            // Defesa
            Item drop5 = new Item("Buckler", "escudo pequeno, mas feito de ferro", 2, 0, 0, 0, 0, 2, 0, 0, 15);


            // Armadura
            Item drop4 = new Item("Armadura de ferro", "uma armadura basica, porém duradoura", 1, 0, 0, 0, 0, 5, 0, 0, 15);
            Item drop6 = new Item("Armadura real", "uma armadura feita para um rei", 1, 0, 4, 4, 4, 5, 0, 10, 25);

            // Poção
            Item drop3 = new Item("Poção de vida", "uma poção basica de vida", 4, 0, 0, 0, 0, 0, 50, 0, 0);


        // Monstros
            // Primeira fase
            Monstro monstro11 = new Monstro(false, "orc cinza", null, null, 30, 10, 5, 3);
            Monstro monstro12 = new Monstro(false, "orc verde", null, null, 40, 11, 5, 4);
            Monstro boss1 = new Monstro(true, "Buckmogo", drop3, "o rei dos orcs", 60, 15, 10, 2);

            // Segunda fase
            Monstro monstro21 = new Monstro(false, "troll com dois chifres", drop, null, 40, 11, 7, 5);
            Monstro monstro22 = new Monstro(false, "troll com um chifre", drop1, null, 50, 12, 7, 1);
            Monstro boss2 = new Monstro(true, "Zinjo", drop2, "o comandante dos trolls", 85, 15, 7, 3);

            // Terceira fase
            Monstro monstro31 = new Monstro(false, "goblin cabeludo", null, null, 50, 15,5, 4);
            Monstro monstro32 = new Monstro(false, "goblin careca", null, null, 55, 15,5 , 2);
            Monstro boss3 = new Monstro(true, "Hobgoblin", drop4, "um goblin gigante", 85, 20,10, 5);

            // Quarta fase
            Monstro monstro41 = new Monstro(false, "homem pequeno", drop3, null, 60, 15, 10, 3);
            Monstro monstro42 = new Monstro(false, "homem pobre", null, null, 65, 17, 14, 5);
            Monstro boss4 = new Monstro(true, "Soldado", drop5, "um soldado enquencreiro", 95, 25, 15, 2);

            // Quinta fase
            Monstro monstro51 = new Monstro(false, "soldado de bronze", null, null, 70, 20, 20, 3);
            Monstro monstro52 = new Monstro(false, "soldado de prata", null, null, 75, 22, 20, 1);
            Monstro boss5 = new Monstro(true, "Rei Gilberto I", drop6, "um rei grande e forte", 150, 30, 25, 4);

        // Classes
        Classe classe1 = new Classe("Guerreiro", itemDIniG, itemAIniG, itemArIniG, 8, 3, 3, 6, 2);
        Classe classe2 = new Classe("Mago", itemDIniM, itemAIniM, itemArIniM, 2, 8, 3, 3, 3);
        Classe classe3 = new Classe("Arqueiro", itemDIniA, itemAIniA, itemArIniA, 4, 3, 6, 0, 1);

        // Player
        Player player1 = new Player();

        // Fase
        Fase fase1 = new Fase("caverna");
        Fase fase2 = new Fase("floresta");
        Fase fase3 = new Fase("esgoto");
        Fase fase4 = new Fase("cidade");
        Fase fase5 = new Fase("castelo");

        // Game Controller
        gameController gc1 = new gameController(player1);

        // Adição final
        player1.addClasses(classe1);
        player1.addClasses(classe2);
        player1.addClasses(classe3);

        fase1.addMonstros(monstro11);
        fase1.addMonstros(monstro12);
        fase1.addMonstros(boss1);

        fase2.addMonstros(monstro21);
        fase2.addMonstros(monstro22);
        fase2.addMonstros(boss2);

        fase3.addMonstros(monstro31);
        fase3.addMonstros(monstro32);
        fase3.addMonstros(boss3);

        fase4.addMonstros(monstro41);
        fase4.addMonstros(monstro42);
        fase4.addMonstros(boss4);

        fase5.addMonstros(monstro51);
        fase5.addMonstros(monstro52);
        fase5.addMonstros(boss5);

        gc1.addFases(fase1);
        gc1.addFases(fase2);
        gc1.addFases(fase3);
        gc1.addFases(fase4);
        gc1.addFases(fase5);

        while(true){
            gc1.gameplayLoop();
        }

    }
}
