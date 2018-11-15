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
    private boolean inGame = true;
    private Fase fase1;

    // Construtor

    // Métodos
    public void gameplayLoop(){
        player.updatePlayer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("VOCÊ PODE----------------");
        System.out.println("1 - Batalhar");
        System.out.println("2 - Abrir menu");
        System.out.println("-------------------------");
        System.out.println("Hp:" + player.getVidaAtual() + " / Atk:" + player.getAtaque() + " / Def:" + player.getDefesa());
        System.out.println("-------------------------");

        System.out.print("Seu comando: ");
        switch (scanner.nextInt()){
            case 1:

            case 2:{
                this.abrirMenu();
                break;
                }
            default:
                System.out.println("Número inválido, tente novamente");
        }
        System.out.println();
    }

    public void abrirMenu(){
        inGame = false;
        while(inGame == false) {

            Scanner scanner = new Scanner(System.in);
            System.out.println  ("-----------MENU----------");
            System.out.println  ("1 - Mostrar atributos");
            System.out.println  ("2 - Itens equipados");
            System.out.println  ("3 - Inventário");
            System.out.println  ("4 - Voltar ao jogo");
            System.out.println  ("-------------------------");

            System.out.print("Seu comando: ");
            switch (scanner.nextInt()) {
                case 1:
                    this.player.mostrarAtributos();
                    System.out.println();
                    break;
                case 2:
                    this.player.mostrarItens();
                    System.out.println();
                    break;
                case 3:
                    this.player.mostrarInventario();
                    System.out.println();
                    break;
                case 4:
                    inGame = true;
                    System.out.println();
                    break;
                default:
                    System.out.println("Número inválido, tente novamente");
            }
        }
    }

    public void batalhar(){

    }

    // Get e Set
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<Fase> getFases() {
        return fases;
    }

    public void addFases(Fase fase) {
        this.fases.add(fase);
    }
}
