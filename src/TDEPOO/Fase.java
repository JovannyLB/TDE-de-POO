package TDEPOO;

import java.util.ArrayList;

public class Fase {
    // Atributos
    private String local;                 // Guarda o local da fase
    private ArrayList<Monstro> monstros;  // Array de monstros comuns(2) e o boss(1)
    private boolean primeiraVez;          // Guarda a informação se é a primeira vez que o jogador está na fase, referenciar método gameplayloop
    private ArrayList<Item> loot;         // Guarda todos os itens dropados pelos monstros nessa fase

    // Construtor
    public Fase(String local) {
        this.local = local;
        this.monstros = new ArrayList<>();
        this.loot = new ArrayList<>();
        this.primeiraVez = true;
    }

    // Get e Set
    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public ArrayList<Monstro> getMonstros() {
        return monstros;
    }

    public void addMonstros(Monstro monstro) {
        this.monstros.add(monstro);
    }

    public boolean isPrimeiraVez() {
        return primeiraVez;
    }

    public void setPrimeiraVez(boolean primeiraVez) {
        this.primeiraVez = primeiraVez;
    }

    public ArrayList<Item> getLoot() {
        return loot;
    }

    public void addLoot(Item loot) {
        this.loot.add(loot);
    }

}
