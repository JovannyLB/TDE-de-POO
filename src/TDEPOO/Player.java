package TDEPOO;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    // Atributos
    private String nomePlayer;
    private int levelPlayer;

    private ArrayList<Item> inventario; // Contém os itens carregados pelo player
    private Item itemArmadura;          // Contém o item de armadura que o player atualmente está usando
    private Item itemAtaque;            // Contém o item de ataque que o player atualmente está usando
    private Item itemDefesa;            // Contém o item de defesa que o player atualmente está usando

    private Classe classe;              // Determina os atributos adicionais do player

    private int forca;                  // Dano fisico
    private int inteligencia;           // Dano magico
    private int destreza;               // Chance de desviar dos ataques
    private int vitalidade;             // Aumenta a vida do jogador

    private int vidaTotal;              // Contém a vida total do player
    private int vidaAtual;              // Contém a vida atual do player

    private int ataque;                 // Dano que o player causará no inimigo caso ataque
    private int defesa;                 // Dano removido do ataque do inimigo caso jogador defenda

    // Construtor
    public Player(String nomePlayer, Classe classe) {
        this.nomePlayer = nomePlayer;
        this.classe = classe;
        this.inventario = new ArrayList<>();                // Cria o array de inventário
        this.itemArmadura = null;
        this.itemAtaque = classe.getItemDeAtaqueInicial();  // Atribui o item inicial da classe ao item de player
        this.itemDefesa = classe.getItemDeDefesaInicial();  // ||
        this.forca = classe.getForcaAddC();                 // Atribui o atributo da classe ao player
        this.inteligencia = classe.getInteligenciaAddC();   // ||
        this.destreza = classe.getDestrezaAddC();           // ||
        this.vitalidade = classe.getVitalidadeAddC();       // ||
        this.vidaTotal = 100 + (vitalidade * 10);           // Atribui o bonus de vitalidade a vida genérica do player
        this.vidaAtual = vidaTotal;                         // A vida inicial é igual a vida total
        this.ataque = itemAtaque.getAtaqueAddI() + forca;   // Atribui o ataque do item de ataque mais o bonus de força
        this.defesa = itemDefesa.getDefesaAddI();           // Atribui a defesa do item
    }

    // Métodos
    public void updatePlayer() {    // Atualiza os atributos
        this.forca = classe.getForcaAddC() + itemAtaque.getForcaAddI() + itemDefesa.getForcaAddI() + itemArmadura.getForcaAddI();
        this.inteligencia = classe.getInteligenciaAddC() + itemAtaque.getInteligenciaAddI() + itemDefesa.getInteligenciaAddI() + itemArmadura.getInteligenciaAddI();
        this.destreza = classe.getDestrezaAddC() + itemAtaque.getDestrezaAddI() + itemDefesa.getDestrezaAddI() + itemArmadura.getDestrezaAddI();
        this.vitalidade = classe.getVitalidadeAddC() + itemAtaque.getVitalidadeAddI() + itemDefesa.getVitalidadeAddI() + itemArmadura.getVitalidadeAddI();

        this.vidaTotal = 100 + (vitalidade * 10);
        this.ataque = itemAtaque.getAtaqueAddI() + itemArmadura.getAtaqueAddI() + forca;
        this.defesa = itemDefesa.getDefesaAddI() + itemArmadura.getDefesaAddI();
    }

    public void guardarPocao(Item pocaoParaGuardar) {   // Guarda poções no inventário do player
        if (this.inventario.size() == 2) {
            if (pocaoParaGuardar.isItemPocao()) {
                this.addInventario(pocaoParaGuardar);
            } else {
                System.out.println("Você só pode carregar poções!");
            }
        } else {
            System.out.println("Seu inventário está cheio!");
        }
    }

    public void usarPocao(int numeroPocaoParaUsar) {    // Usa uma poção do inventário do player
        if (numeroPocaoParaUsar > 0 && numeroPocaoParaUsar < 3) {
            if (this.vidaAtual < this.vidaTotal) {
                if ((this.vidaAtual + this.inventario.get(numeroPocaoParaUsar - 1).getVidaAddI()) > this.vidaTotal) {
                    this.vidaAtual = this.vidaTotal;
                    System.out.println("A poção recupera sua vida!");
                    this.inventario.remove(numeroPocaoParaUsar - 1);
                } else {
                    this.vidaAtual += this.inventario.get(numeroPocaoParaUsar - 1).getVidaAddI();
                    System.out.println("A poção recupera sua vida!");
                    this.inventario.remove(numeroPocaoParaUsar - 1);
                }
            } else {
                System.out.println("Sua vida já está cheia...");
            }
        } else {
            System.out.println("Não existe uma poção ai...");
        }
    }

    public void equiparItem(Item itemParaEquipar){  // Equipa um item
        if (itemParaEquipar.isItemDeArmadura()) {
            if (this.itemArmadura == null) {
                this.itemArmadura = itemParaEquipar;
            } else {
                System.out.println("Você já tem uma armadura equipada...");
            }
        }  else if (itemParaEquipar.isItemDeAtaque()){  // 1 - Arco, 2 - Espada, 3 - Cajado
            if (itemParaEquipar.isItemArco() && this.classe.isPodeUsarArco()) {
                if (this.itemAtaque == null) {
                    this.itemAtaque = itemParaEquipar;
                } else {
                    System.out.println("Você já está segurando um item de ataque...");
                }
            } else if (itemParaEquipar.isItemEspada() && this.classe.isPodeUsarEspada()) {
                if (this.itemAtaque == null) {
                    this.itemAtaque = itemParaEquipar;
                } else {
                    System.out.println("Você já está segurando um item de ataque...");
                }
            } else if (itemParaEquipar.isItemCajado() && this.classe.isPodeUsarCajado()) {
                if (this.itemAtaque == null) {
                    this.itemAtaque = itemParaEquipar;
                } else {
                    System.out.println("Você já está segurando um item de ataque...");
                }
            } else {
                System.out.println("Você não tem proficiência com esta arma...");
            }
        } else if (itemParaEquipar.isItemDeDefesa()){
            if (this.itemDefesa == null){
                this.itemDefesa = itemParaEquipar;
            } else {
                System.out.println("Você já está segurando um item de defesa...");
            }
        }
    }

    public void desequiparItem(int itemParaDesequipar){ // Desesquipa um item
        switch (itemParaDesequipar) {                   // 1 - Armadura, 2 - Defesa, 3 - Ataque
            case 1:
                if (this.itemArmadura == null) {
                    System.out.println("Você já está sem armadura...");
                } else {
                    this.itemArmadura = null;
                    System.out.println("Você tira sua armadura!");
                }
                break;
            case 2:
                if (this.itemDefesa == null) {
                    System.out.println("Você já não tem um item de defesa...");
                } else {
                    this.itemDefesa = null;
                    System.out.println("Você larga seu item de defesa!");
                }
                break;
            case 3:
                if (this.itemAtaque == null){
                    System.out.println("Você já não tem um item de ataque...");
                } else {
                    this.itemAtaque = null;
                    System.out.println("Você larga seu item de ataque!");
                }
                break;
        }
    }

    // Get e Set
    public String getNomePlayer() {
        return nomePlayer;
    }

    public void setNomePlayer(String nomePlayer) {
        this.nomePlayer = nomePlayer;
    }

    public int getLevelPlayer() {
        return levelPlayer;
    }

    public void setLevelPlayer(int levelPlayer) {
        this.levelPlayer = levelPlayer;
    }

    public ArrayList<Item> getInventario() {
        return inventario;
    }

    public void addInventario(Item novoItem) {
        this.inventario.add(novoItem);
    }

    public Item getItemArmadura() {
        return itemArmadura;
    }

    public void setItemArmadura(Item itemArmadura) {
        this.itemArmadura = itemArmadura;
    }

    public Item getItemAtaque() {
        return itemAtaque;
    }

    public void setItemAtaque(Item itemAtaque) {
        this.itemAtaque = itemAtaque;
    }

    public Item getItemDefesa() {
        return itemDefesa;
    }

    public void setItemDefesa(Item itemDefesa) {
        this.itemDefesa = itemDefesa;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getVitalidade() {
        return vitalidade;
    }

    public void setVitalidade(int vitalidade) {
        this.vitalidade = vitalidade;
    }

    public int getVidaTotal() {
        return vidaTotal;
    }

    public void setVidaTotal(int vidaTotal) {
        this.vidaTotal = vidaTotal;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
}
