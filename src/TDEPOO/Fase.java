package TDEPOO;

import java.util.ArrayList;

public class Fase {
    // Atributos
    private String local;
    private ArrayList<Monstro> monstros;  // Array de monstros comuns(2)
    private Monstro boss;                 // Boss da fase
    private String raca;                  // Raca dos monstros da fase
    private int wave = 1;                     // Variavel numero da rodada

    // Atributos boolean armas
    private boolean espada;
    private boolean porrete;
    private boolean machado;
    private boolean lanca;
    private boolean adaga;

    // Arrays de frases de acordo com arma
    private ArrayList<String> frasesEspada;
    private ArrayList<String> frasesPorrete;
    private ArrayList<String> frasesMachado;
    private ArrayList<String> frasesLanca;
    private ArrayList<String> frasesAdaga;

    // Construtor

    // Métodos
    public void updateFase (){
        switch(wave){
            case 1:
                System.out.println("Você vê um " + monstros.get(1).getRaca());
                break;
        }

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

    public Monstro getBoss() {
        return boss;
    }

    public void setBoss(Monstro boss) {
        this.boss = boss;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public boolean isEspada() {
        return espada;
    }

    public void setEspada(boolean espada) {
        this.espada = espada;
    }

    public boolean isPorrete() {
        return porrete;
    }

    public void setPorrete(boolean porrete) {
        this.porrete = porrete;
    }

    public boolean isMachado() {
        return machado;
    }

    public void setMachado(boolean machado) {
        this.machado = machado;
    }

    public boolean isLanca() {
        return lanca;
    }

    public void setLanca(boolean lanca) {
        this.lanca = lanca;
    }

    public boolean isAdaga() {
        return adaga;
    }

    public void setAdaga(boolean adaga) {
        this.adaga = adaga;
    }

    public ArrayList<String> getFrasesEspada() {
        return frasesEspada;
    }

    public void addFrasesEspada(String fraseEspada) {
        this.frasesEspada.add(fraseEspada);
    }

    public ArrayList<String> getFrasesPorrete() {
        return frasesPorrete;
    }

    public void setFrasesPorrete(String frasePorrete) {
        this.frasesPorrete.add(frasePorrete);
    }

    public ArrayList<String> getFrasesMachado() {
        return frasesMachado;
    }

    public void setFrasesMachado(String fraseMachado) {
        this.frasesMachado.add(fraseMachado);
    }

    public ArrayList<String> getFrasesLanca() {
        return frasesLanca;
    }

    public void setFrasesLanca(String fraseLanca) {
        this.frasesLanca.add(fraseLanca);
    }

    public ArrayList<String> getFrasesAdaga() {
        return frasesAdaga;
    }

    public void setFrasesAdaga(String fraseAdaga) {
        this.frasesAdaga.add(fraseAdaga);
    }
}
