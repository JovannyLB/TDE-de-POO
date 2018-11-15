package TDEPOO;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class gameController {
    // Atributos
    private ArrayList<Fase> fases;  // Segura as fases do jogo
    private Player player;          // Segura o player
    private boolean inGame = true;  // Variavel usada para os menus

    // Construtor
    public gameController(Player player) {
        this.fases = new ArrayList<>();
        this.player = player;
    }

    // Métodos
    public void gameplayLoop() {
        player.updatePlayer();  // Chama o updatee do jogador
        Scanner scanner = new Scanner(System.in);

        if(this.fases.get(0).isPrimeiraVez()){  // Checa se é a primeira vez que o jogador está entrando na fase, se sim, fala o local
            System.out.println("Você entra em " + this.fases.get(0).getLocal().toLowerCase() + "!");
            this.fases.get(0).setPrimeiraVez(false);
        }

        // Remove os monstros se eles morrerem, seus drops vão para o array de loot e se for um boss a fase acaba
        if (this.fases.get(0).getMonstros().get(0).getVida() <= 0 && !this.fases.get(0).getMonstros().get(0).isBoss()) {
            System.out.println("Você matou o " + this.fases.get(0).getMonstros().get(0).getRaca() + "!");
            if(this.fases.get(0).getMonstros().get(0).getDrop() != null){   // Se o drop for nulo ele não será adicionado ao array de loot
                this.fases.get(0).getLoot().add(this.fases.get(0).getMonstros().get(0).getDrop());
            }
            System.out.println("Logo após a morte do " + this.fases.get(0).getMonstros().get(0).getRaca() + " você logo vê outro ser se aproximando!");
            this.fases.get(0).getMonstros().remove(0);  // Remove o monstro da fase
        } else if (this.fases.get(0).getMonstros().get(0).getVida() <= 0) {
            System.out.println("Você matou " + this.fases.get(0).getMonstros().get(0).getRaca() + ", " + this.fases.get(0).getMonstros().get(0).getLore() + "!");
            if(this.fases.get(0).getMonstros().get(0).getDrop() != null){   // Se o drop for nulo ele não será adicionado ao array de loot
                this.fases.get(0).getLoot().add(this.fases.get(0).getMonstros().get(0).getDrop());
            }            mostrarLoot();
            System.out.println("Você então sai da " + this.fases.get(0).getLocal() + ", e vai para sua próxima aventura!");
            this.fases.get(0).getMonstros().remove(0);  // Remove o monstro da fase
            this.fases.remove(0);   // Remove a fase do jogo
            System.out.println("Você subiu de level!");
            this.player.setLevel(this.player.getLevel() + 1);
            this.player.setVidaAtual(this.player.getVidaTotal());
            try {
                if (this.fases.get(0).isPrimeiraVez()) {  // Checa se é a primeira vez que o jogador está entrando na fase, se sim, fala o local
                    System.out.println("Você entra em " + this.fases.get(0).getLocal().toLowerCase() + "!");
                    this.fases.get(0).setPrimeiraVez(false);
                }
            } catch (IndexOutOfBoundsException e) {}
        }

        // Pega o monstro atual da fase atual e mostra para o jogador
        try {
            if (!this.fases.get(0).getMonstros().get(0).isBoss()) { // Mensagem impressa se o monstro a frente for comum
                System.out.println("Você vê um " + this.fases.get(0).getMonstros().get(0).getRaca() + ", ele está segurando " + this.fases.get(0).getMonstros().get(0).getNomeArma() + "!");
                System.out.println("Ele tem um poder de ataque de " + this.fases.get(0).getMonstros().get(0).getAtaque() + ", e um poder de defesa de " + this.fases.get(0).getMonstros().get(0).getDefesa() + "!");
            } else {    // Mensagem impressa se o monstro a frente for um boss
                System.out.println("Você vê " + this.fases.get(0).getMonstros().get(0).getRaca() + ", " + this.fases.get(0).getMonstros().get(0).getLore() + ", ele está segurando " + this.fases.get(0).getMonstros().get(0).getNomeArma() + "!");
                System.out.println("Ele tem um poder de ataque de " + this.fases.get(0).getMonstros().get(0).getAtaque() + ", e um poder de defesa de " + this.fases.get(0).getMonstros().get(0).getDefesa() + "!");
            }
        } catch (IndexOutOfBoundsException e){  // Condição de vitória, nenhuma fase restante
            System.out.println("Em busca da sua próxima aventura você percebe que já conquistou toda e cada uma delas!");
            System.out.println("Você venceu!");
            System.exit(0);
        }

        // Menu principal
        System.out.println("VOCÊ PODE----------------");
        System.out.println("1 - Batalhar");
        System.out.println("2 - Abrir menu");
        System.out.println("3 - Checar saque");
        System.out.println("-------------------------");
        System.out.println("Hp:" + player.getVidaAtual() + " / Atk:" + player.getAtaque() + " / Def:" + player.getDefesa());
        System.out.println("-------------------------");

        System.out.print("Seu comando: ");
        try {
            switch (scanner.nextInt()) {
                case 1:
                    this.batalha();
                    break;
                case 2: {
                    this.abrirMenu();
                    break;
                }
                case 3: {
                    this.mostrarLoot();
                    break;
                }
                default:
                    System.out.println("Número inválido, tente novamente...");
                    break;
            }
        } catch (InputMismatchException e){
            System.out.println("Caractere inválido, tente novamente...");
        }
    }

    public void abrirMenu() {
        inGame = false;
        while (!inGame) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("MENU---------------------");
            System.out.println("1 - Mostrar atributos");
            System.out.println("2 - Itens equipados");
            System.out.println("3 - Inventário");
            System.out.println("4 - Voltar ao jogo");
            System.out.println("-------------------------");

            System.out.print("Seu comando: ");
            try {
                switch (scanner.nextInt()) {
                    case 1:
                        this.player.mostrarAtributos();
                        break;
                    case 2:
                        this.player.mostrarItens();
                        break;
                    case 3:
                        this.player.mostrarInventario();
                        break;
                    case 4:
                        inGame = true;
                        break;
                    default:
                        System.out.println("Número inválido, tente novamente...");
                        break;
                }
            } catch (InputMismatchException e){
                System.out.println("Caractere inválido, tente novamente...");
            }
        }
    }

    public void mostrarLoot(){  // Imprime todos itens dropados pelos monstros
        inGame = false;
        while (!inGame) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("VOCÊ VÊ------------------");
            if (!this.fases.get(0).getLoot().isEmpty()) {   // Checa se realmente tem algum item no chão ou está vazio
                for (int i = 0; i < this.fases.get(0).getLoot().size(); i++) {
                    System.out.println((i + 1) + " - " + this.fases.get(0).getLoot().get(i).getNomeItem() + ", " + this.fases.get(0).getLoot().get(i).getDescricaoItem());
                }
            } else { System.out.println("Nada...");}
            System.out.println("VOCÊ PODE----------------");
            System.out.println("1 - Equipar item");
            System.out.println("2 - Guardar poção");
            System.out.println("3 - Abrir menu");
            System.out.println("4 - Voltar ao jogo");
            System.out.println("-------------------------");

            System.out.print("Seu comando: ");
            try {
                switch (scanner.nextInt()) {
                    case 1:
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.print("Número do item a ser equipado: ");
                        try {
                            int itemEquipar = scanner1.nextInt() - 1;
                            if (this.player.equiparItem(this.fases.get(0).getLoot().get(itemEquipar))) {
                                this.fases.get(0).getLoot().remove(itemEquipar);
                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Número inválido...");
                        }
                        break;
                    case 2:
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.print("Número do item a ser guardado: ");
                        try {
                            int itemGuardar = scanner2.nextInt() - 1;
                            if (this.player.guardarPocao(this.fases.get(0).getLoot().get(itemGuardar))) {
                                this.fases.get(0).getLoot().remove(itemGuardar);
                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Número inválido...");
                        }
                        break;
                    case 3:
                        Scanner scanner3 = new Scanner(System.in);
                        System.out.println("VOCÊ PODE----------------");
                        System.out.println("1 - Desequipar item");
                        System.out.println("2 - Usar poção");
                        System.out.println("3 - Voltar");
                        System.out.println("-------------------------");

                        System.out.print("Seu comando: ");
                        try {
                            switch (scanner3.nextInt()) {
                                case 1:
                                    this.player.mostrarItens();
                                    break;
                                case 2:
                                    this.player.mostrarInventario();
                                    break;
                                case 3:
                                    break;
                                default:
                                    System.out.println("Número inválido, tente novamente...");
                            }
                        } catch (InputMismatchException e){
                            System.out.println("Caractere inválido, tente novamente...");
                        }
                        break;
                    case 4:
                        inGame = true;
                        break;
                    default:
                        System.out.println("Número inválido, tente novamente...");
                }
            } catch (InputMismatchException e){
                System.out.println("Caractere inválido, tente novamente...");
            }
        }
    }

    public void batalha(){  // É encarregado das batalhas
        inGame = false;
        System.out.println("Você engaja o " + this.fases.get(0).getMonstros().get(0).getRaca() + " em batalha!");
        while (!inGame) {
            if (this.fases.get(0).getMonstros().get(0).getVida() <= 0){ // Checa se o monstro está vivo ou não
                inGame = true;
                break;
            }
            double chanceDesvio = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.println("VOCÊ PODE----------------");
            System.out.println("1 - Atacar");
            System.out.println("2 - Defender");
            System.out.println("3 - Abrir o inventário");
            System.out.println("PLAYER-------------------");
            System.out.println("Hp:" + player.getVidaAtual() + " / Atk:" + player.getAtaque() + " / Def:" + player.getDefesa());
            System.out.println("INIMIGO------------------");
            System.out.println("Hp:" + this.fases.get(0).getMonstros().get(0).getVida() + " / Atk:" + this.fases.get(0).getMonstros().get(0).getAtaque() + " / Def:" + this.fases.get(0).getMonstros().get(0).getDefesa());
            System.out.println("-------------------------");
            System.out.print("Seu comando: ");
            try {
                switch (scanner.nextInt()) {
                    case 1: // O jogador ataca, o dano que o inimigo recebera será cortado pela porcetagem da defesa, exemplo: se o inimigo tiver 5 de defesa, ele recebera 5% a menos de dano (dano - ((defesa / 100) * dano)
                        System.out.println("Você ataca o " + this.fases.get(0).getMonstros().get(0).getRaca() + " com " + this.player.getItemAtaque().getNomeItem().toLowerCase() + "!");
                        System.out.println("O " + this.fases.get(0).getMonstros().get(0).getRaca() + " perde " + (this.player.getAtaque() - (((double) this.fases.get(0).getMonstros().get(0).getDefesa() / 100) * this.player.getAtaque())) + " de vida!");
                        this.fases.get(0).getMonstros().get(0).setVida((int) (this.fases.get(0).getMonstros().get(0).getVida() - this.player.getAtaque() - (((double) this.fases.get(0).getMonstros().get(0).getDefesa() / 100) * this.player.getAtaque())));
                        if (this.fases.get(0).getMonstros().get(0).getVida() <= 0) {
                            inGame = true;
                            break;
                        }
                        System.out.println("O " + this.fases.get(0).getMonstros().get(0).getRaca() + " te ataca!");
                        chanceDesvio = (Math.random() * 100); // Calcula se o personagem ira desviar do ataque ou não, a chance de desvio é 1:1 com a destreza do personagem
                        if (chanceDesvio < this.player.getDestreza()) {
                            System.out.println("Você desvia do ataque!");
                        } else {
                            System.out.println("Ele dá " + this.fases.get(0).getMonstros().get(0).getAtaque() + " de dano em você!");
                            this.player.setVidaAtual(this.player.getVidaAtual() - this.fases.get(0).getMonstros().get(0).getAtaque());
                        }
                        if (this.player.getVidaAtual() <= 0) {
                            inGame = true;
                            break;
                        }
                        break;
                    case 2: // A defesa do personagem funciona igualmente a do monstro, dita acima
                        System.out.println("Você se prepara para se defeder usando " + this.player.getItemDefesa().getNomeItem().toLowerCase());
                        System.out.println("O " + this.fases.get(0).getMonstros().get(0).getRaca() + " te ataca!");
                        System.out.println("Ele dá " + (this.fases.get(0).getMonstros().get(0).getAtaque() - (((double) this.player.getDefesa() / 100) * this.fases.get(0).getMonstros().get(0).getAtaque())) + " de dano em você!");
                        System.out.println("Você defendeu " + ((double) this.player.getDefesa() / 100) * this.fases.get(0).getMonstros().get(0).getAtaque() + " do dano total!");
                        this.player.setVidaAtual((int) (this.player.getVidaAtual() - this.fases.get(0).getMonstros().get(0).getAtaque() - (((double) this.player.getDefesa() / 100) * this.fases.get(0).getMonstros().get(0).getAtaque())));
                        if (this.player.getVidaAtual() <= 0) {
                            inGame = true;
                            break;
                        }
                        break;
                    case 3:
                        this.player.mostrarInventario();
                        break;
                    default:
                        System.out.println("Número inválido, tente novamente...");
                }
            } catch (InputMismatchException e){
                System.out.println("Caractere inválido, tente novamente...");
            }
        }
    }

    // Get e Set
    public ArrayList<Fase> getFases() {
        return fases;
    }

    public void addFases(Fase fase) {
        this.fases.add(fase);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

}
