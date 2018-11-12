package TDEPOO;

import java.util.ArrayList;
import java.util.Scanner;

public class gameController {
    /*
    gameController terá um método que cria um montro aleatório e um item aleatório na criação de fases do main
    Criar um menu
    */

    // Atributos
    private ArrayList<Fase> fases;
    private Player player;

    // Construtor

    // Métodos
    public void gameplayLoop(){
        player.updatePlayer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------VOCÊ PODE--------");
        System.out.println("1 - Batalhar");
        System.out.println("2 - Abrir menu");
        System.out.println("-------------------------");

        System.out.print("Seu comando: ");
        switch (scanner.nextInt()){
            case 2:
                this.abrirMenu();
                break;
            default:
                System.out.println("Número inválido, tente novamente");
        }
    }

    public void abrirMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println  ("-----------MENU----------");
        System.out.println  ("1 - Mostrar atributos");
        System.out.println  ("2 - Itens equipados");
        System.out.println  ("3 - Inventário");
        System.out.println  ("-------------------------");

        System.out.print("Seu comando: ");
        switch (scanner.nextInt()){
            case 1:
                this.player.mostrarAtributos();
                break;
            case 2:
                this.player.mostrarItens();
                break;
            case 3:
                this.player.mostrarInventario();
                break;
            default:
                System.out.println("Número inválido, tente novamente");
        }
    }

    // Get e Set
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
