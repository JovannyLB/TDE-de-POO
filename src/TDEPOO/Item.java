package TDEPOO;

public class Item {
    // Atributos
        // Atributos base
    private String nomeItem;
    private String descricaoItem;

        // Atributos de tipo de item
    private int tipoItem;           // Determina o tipo de item (1 - Armadura, 2 - Defesa, 3 - Ataque, 4 - Poção);
    private boolean itemDeArmadura; // Um item passivo que o player equipara para se cobrir
    private boolean itemDeDefesa;   // Um item passivo que o player equipara para se defender
    private boolean itemDeAtaque;   // Um item passivo que o player equipara para atacar
    private boolean itemPocao;      // Um item ativo que o jogador usará para se recuperar, o mesmo será destruido no processo

        // Atributos de tipo de item de ataque
    private int tipoItemAtaque;     // Determina o tipo de item de ataque (1 - Arco, 2 - Espada, 3 - Cajado)
    private boolean itemArco;
    private boolean itemEspada;
    private boolean itemCajado;

        // Atributos de atributos
    private int forcaAddI;          // Força adicional nos atributos do player referindo a um item magico/encantado
    private int inteligenciaAddI;   // Inteligencia adicinal nos atributos do player referindo a um item magico/encantado
    private int destrezaAddI;       // Destreza adicional nos atributos do player referindo a um um item magico/encantado
    private int vitalidadeAddI;     // Vitalidade adicional nos atributos do player referindo a um item magico/encantado

        // Atributos de combate
    private int vidaAddI;           // Vida recuperada referindo a uma poção
    private int ataqueAddI;         // Ataque adicional referindo a um item de ataque
    private int defesaAddI;         // Defesa adicional referindo a um item de defesa

        // Atributos de durabilidade
    private int durabilidadeTotal;       // Determina a "vida" do item antes do mesmo ser destruido, mostra o total
    private int durabilidadeAtual;       // Determina a "vida" do item antes do mesmo ser destruido, mostra o atual

    // Construtor
    public Item(String nomeItem, String descricaoItem, int tipoItem, int tipoItemAtaque, int forcaAddI, int inteligenciaAddI, int destrezaAddI, int vitalidadeAddI, int vidaAddI, int ataqueAddI, int defesaAddI) {
        this.nomeItem = nomeItem;
        this.descricaoItem = descricaoItem;
        this.tipoItem = tipoItem;
        switch (tipoItem) {
            case 1:
                this.itemDeArmadura = true;
                this.itemDeDefesa = false;
                this.itemDeAtaque = false;
                this.itemPocao = false;
                break;
            case 2:
                this.itemDeArmadura = false;
                this.itemDeDefesa = true;
                this.itemDeAtaque = false;
                this.itemPocao = false;
                break;
            case 3:
                this.itemDeArmadura = false;
                this.itemDeDefesa = false;
                this.itemDeAtaque = true;
                this.itemPocao = false;
                break;
            case 4:
                this.itemDeArmadura = false;
                this.itemDeDefesa = false;
                this.itemDeAtaque = false;
                this.itemPocao = true;
                break;
        }
        this.tipoItemAtaque = tipoItemAtaque;
        if (this.itemDeAtaque) {
            switch (tipoItemAtaque) {
                case 0:
                    this.itemArco = false;
                    this.itemEspada = false;
                    this.itemCajado = false;
                    break;
                case 1:
                    this.itemArco = true;
                    this.itemEspada = false;
                    this.itemCajado = false;
                    break;
                case 2:
                    this.itemArco = false;
                    this.itemEspada = true;
                    this.itemCajado = false;
                    break;
                case 3:
                    this.itemArco = false;
                    this.itemEspada = false;
                    this.itemCajado = true;
                    break;
            }
        }
        this.forcaAddI = forcaAddI;
        this.inteligenciaAddI = inteligenciaAddI;
        this.destrezaAddI = destrezaAddI;
        this.vitalidadeAddI = vitalidadeAddI;
        this.vidaAddI = vidaAddI;
        this.ataqueAddI = ataqueAddI;
        this.defesaAddI = defesaAddI;
        this.durabilidadeTotal = 150;
        this.durabilidadeAtual = durabilidadeTotal;
    }

    // Métodos

    // Get e Set
    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public String getDescricaoItem() {
        return descricaoItem;
    }

    public void setDescricaoItem(String descricaoItem) {
        this.descricaoItem = descricaoItem;
    }

    public int getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(int tipoItem) {
        this.tipoItem = tipoItem;
    }

    public boolean isItemDeArmadura() {
        return itemDeArmadura;
    }

    public void setItemDeArmadura(boolean itemDeArmadura) {
        this.itemDeArmadura = itemDeArmadura;
    }

    public boolean isItemDeDefesa() {
        return itemDeDefesa;
    }

    public void setItemDeDefesa(boolean itemDeDefesa) {
        this.itemDeDefesa = itemDeDefesa;
    }

    public boolean isItemDeAtaque() {
        return itemDeAtaque;
    }

    public void setItemDeAtaque(boolean itemDeAtaque) {
        this.itemDeAtaque = itemDeAtaque;
    }

    public boolean isItemPocao() {
        return itemPocao;
    }

    public void setItemPocao(boolean itemPocao) {
        this.itemPocao = itemPocao;
    }

    public int getTipoItemAtaque() {
        return tipoItemAtaque;
    }

    public void setTipoItemAtaque(int tipoItemAtaque) {
        this.tipoItemAtaque = tipoItemAtaque;
    }

    public boolean isItemArco() {
        return itemArco;
    }

    public void setItemArco(boolean itemArco) {
        this.itemArco = itemArco;
    }

    public boolean isItemEspada() {
        return itemEspada;
    }

    public void setItemEspada(boolean itemEspada) {
        this.itemEspada = itemEspada;
    }

    public boolean isItemCajado() {
        return itemCajado;
    }

    public void setItemCajado(boolean itemCajado) {
        this.itemCajado = itemCajado;
    }

    public int getForcaAddI() {
        return forcaAddI;
    }

    public void setForcaAddI(int forcaAddI) {
        this.forcaAddI = forcaAddI;
    }

    public int getInteligenciaAddI() {
        return inteligenciaAddI;
    }

    public void setInteligenciaAddI(int inteligenciaAddI) {
        this.inteligenciaAddI = inteligenciaAddI;
    }

    public int getDestrezaAddI() {
        return destrezaAddI;
    }

    public void setDestrezaAddI(int destrezaAddI) {
        this.destrezaAddI = destrezaAddI;
    }

    public int getVitalidadeAddI() {
        return vitalidadeAddI;
    }

    public void setVitalidadeAddI(int vitalidadeAddI) {
        this.vitalidadeAddI = vitalidadeAddI;
    }

    public int getVidaAddI() {
        return vidaAddI;
    }

    public void setVidaAddI(int vidaAddI) {
        this.vidaAddI = vidaAddI;
    }

    public int getAtaqueAddI() {
        return ataqueAddI;
    }

    public void setAtaqueAddI(int ataqueAddI) {
        this.ataqueAddI = ataqueAddI;
    }

    public int getDefesaAddI() {
        return defesaAddI;
    }

    public void setDefesaAddI(int defesaAddI) {
        this.defesaAddI = defesaAddI;
    }

    public int getDurabilidadeTotal() {
        return durabilidadeTotal;
    }

    public void setDurabilidadeTotal(int durabilidadeTotal) {
        this.durabilidadeTotal = durabilidadeTotal;
    }

    public int getDurabilidadeAtual() {
        return durabilidadeAtual;
    }

    public void setDurabilidadeAtual(int durabilidadeAtual) {
        this.durabilidadeAtual = durabilidadeAtual;
    }
}
