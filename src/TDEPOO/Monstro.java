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

}
