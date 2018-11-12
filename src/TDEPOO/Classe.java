package TDEPOO;

public class Classe {
    // Atributos
    private String nomeClasse;

    private Item itemDeDefesaInicial;   // Item de defesa inicial para o player
    private Item itemDeAtaqueInicial;   // Item de ataque inicial para o player

    private int forcaAddC;              // Força adicional nos atributos do player
    private int inteligenciaAddC;       // Inteligencia adicinal nos atributos do player
    private int destrezaAddC;           // Destreza adicional nos atributos do player
    private int vitalidadeAddC;         // Vitalidade adicional nos atributos do player

    private int tipoDeArma;             // Determina o tipo de arma ultilizada (1 - Arco, 2 - Espada, 3 - Cajado)
    private boolean podeUsarArco;       // Determina se a classe pode ultilizar um arco
    private boolean podeUsarEspada;     // Determina se a classe pode ultilizar uma espada
    private boolean podeUsarCajado;     // Determina se a classe pode ultilizar um cajado

    // Construtor
    public Classe(String nomeClasse, Item itemDeDefesaInicial, Item itemDeAtaqueInicial, int forcaAddC, int inteligenciaAddC, int destrezaAddC, int vitalidadeAddC, int tipoDeArma) {
        this.nomeClasse = nomeClasse;
        this.itemDeDefesaInicial = itemDeDefesaInicial;
        this.itemDeAtaqueInicial = itemDeAtaqueInicial;
        this.forcaAddC = forcaAddC;
        this.inteligenciaAddC = inteligenciaAddC;
        this.destrezaAddC = destrezaAddC;
        this.vitalidadeAddC = vitalidadeAddC;
        this.tipoDeArma = tipoDeArma;                   // Decide que tipo de arma o player poderá ultilizar
        switch (tipoDeArma) {
            case 1:
                this.podeUsarArco = true;
                this.podeUsarEspada = false;
                this.podeUsarCajado = false;
                break;
            case 2:
                this.podeUsarArco = false;
                this.podeUsarEspada = true;
                this.podeUsarCajado = false;
                break;
            case 3:
                this.podeUsarArco = false;
                this.podeUsarEspada = false;
                this.podeUsarCajado = true;
                break;
        }
    }

    // Métodos

    // Get e Set
    public String getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public Item getItemDeDefesaInicial() {
        return itemDeDefesaInicial;
    }

    public void setItemDeDefesaInicial(Item itemDeDefesaInicial) {
        this.itemDeDefesaInicial = itemDeDefesaInicial;
    }

    public Item getItemDeAtaqueInicial() {
        return itemDeAtaqueInicial;
    }

    public void setItemDeAtaqueInicial(Item itemDeAtaqueInicial) {
        this.itemDeAtaqueInicial = itemDeAtaqueInicial;
    }

    public int getForcaAddC() {
        return forcaAddC;
    }

    public void setForcaAddC(int forcaAddC) {
        this.forcaAddC = forcaAddC;
    }

    public int getInteligenciaAddC() {
        return inteligenciaAddC;
    }

    public void setInteligenciaAddC(int inteligenciaAddC) {
        this.inteligenciaAddC = inteligenciaAddC;
    }

    public int getDestrezaAddC() {
        return destrezaAddC;
    }

    public void setDestrezaAddC(int destrezaAddC) {
        this.destrezaAddC = destrezaAddC;
    }

    public int getVitalidadeAddC() {
        return vitalidadeAddC;
    }

    public void setVitalidadeAddC(int vitalidadeAddC) {
        this.vitalidadeAddC = vitalidadeAddC;
    }

    public int getTipoDeArma() {
        return tipoDeArma;
    }

    public void setTipoDeArma(int tipoDeArma) {
        this.tipoDeArma = tipoDeArma;
    }

    public boolean isPodeUsarArco() {
        return podeUsarArco;
    }

    public void setPodeUsarArco(boolean podeUsarArco) {
        this.podeUsarArco = podeUsarArco;
    }

    public boolean isPodeUsarEspada() {
        return podeUsarEspada;
    }

    public void setPodeUsarEspada(boolean podeUsarEspada) {
        this.podeUsarEspada = podeUsarEspada;
    }

    public boolean isPodeUsarCajado() {
        return podeUsarCajado;
    }

    public void setPodeUsarCajado(boolean podeUsarCajado) {
        this.podeUsarCajado = podeUsarCajado;
    }
}
