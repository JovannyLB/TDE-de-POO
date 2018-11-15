package TDEPOO;

public class Monstro {
    // Atributos
    private boolean boss; // Definirá se o boss é um boss ou não
    private String raca;  // Raça
    private Item drop;    // Item dropável do monstro             ---->             [if(!= boss){ drop = null}]
    private String lore;  // Descrição/Lore somente existente se o monstro for Boss [if(!= boss){ lore = null}]

        // Atributos de combate
    private int vida;     // Vida do monstro
    private int ataque;   // Dano Fisico do monstro
    private int defesa;   // Defesa do monstro

    // Construtor
    public Monstro(boolean boss, String raca, Item drop, String lore, int vida, int ataque, int defesa) {
        this.boss = boss;
        this.raca = raca;
        this.drop = drop;
        this.lore = lore;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;

        if (boss == false) {

        }


    }

    // Métodos

    // Get e Set

    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Item getDrop() {
        return drop;
    }

    public void setDrop(Item drop) {
        this.drop = drop;
    }

    public String getLore() {
        return lore;
    }

    public void setLore(String lore) {
        this.lore = lore;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
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
