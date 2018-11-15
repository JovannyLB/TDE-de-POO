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

    // Atributos boolean armas            // Tipo de arma (1 - Espada, 2 - Porrete, 3 - Machado, 4 - Lança, 5 - Adaga)
    private int tipoArma;
    private String nomeArma;

    // Construtor
    public Monstro(boolean boss, String raca, Item drop, String lore, int vida, int ataque, int defesa, int tipoArma) {
        this.boss = boss;
        this.raca = raca;
        this.drop = drop;
        this.lore = lore;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        switch (tipoArma){
            case 1:
                this.nomeArma = "uma espada";
                break;
            case 2:
                this.nomeArma = "um porrete";
                break;
            case 3:
                this.nomeArma = "um machado";
                break;
            case 4:
                this.nomeArma = "uma lança";
                break;
            case 5:
                this.nomeArma = "uma adaga";
                break;
        }
    }

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

    public int getTipoArma() {
        return tipoArma;
    }

    public void setTipoArma(int tipoArma) {
        this.tipoArma = tipoArma;
    }

    public String getNomeArma() {
        return nomeArma;
    }

    public void setNomeArma(String nomeArma) {
        this.nomeArma = nomeArma;
    }
}
