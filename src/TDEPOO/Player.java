package TDEPOO;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    // Atributos
        // Atributos base
    private String nomePlayer;          // Guarda o nome do jogador
    private int idadePlayer;            // Guarda a idade do jogador
    private int level;                  // Autoexplicativo

        // Atributos itens
    private ArrayList<Item> inventario; // Contém os itens carregados pelo player
    private Item itemArmadura;          // Contém o item de armadura que o player atualmente está usando
    private Item itemAtaque;            // Contém o item de ataque que o player atualmente está usando
    private Item itemDefesa;            // Contém o item de defesa que o player atualmente está usando

        // Classe
    private ArrayList<Classe> classes;  // Lista de classes
    private Classe classe;              // Determina os atributos adicionais do player

        // Atributos de atributos
    private int forca;                  // Dano fisico
    private int inteligencia;           // Dano magico
    private int destreza;               // Chance de desviar dos ataques
    private int vitalidade;             // Aumenta a vida do jogador
    private int totalBonusF;            // Bonus de força adicionada pelos itens
    private int totalBonusI;            // Bonus de inteligencia adicionada pelos itens
    private int totalBonusD;            // Bonus de destreza adicionada pelos itens
    private int totalBonusV;            // Bonus de vitalidade adicionada pelos itens
    private int totalBonusA;            // Bonus de ataque adicionado pelos itens
    private int totalBonusDef;          // Bonus de defesa adicionada pelos itens

        // Atributos de vida
    private int vidaTotal;              // Contém a vida total do player
    private int vidaAtual;              // Contém a vida atual do player

        // Atributos de combate
    private int ataque;                 // Dano que o player causará no inimigo caso ataque
    private int defesa;                 // Dano removido do ataque do inimigo caso jogador defenda

    // Construtor
    public Player() {
        boolean criado = false;
        while(!criado) {                                    // Cria o personagem
            try {
                Scanner scanner = new Scanner(System.in);
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Criação de personagem:");
                System.out.print("Escreva seu nome: ");
                this.nomePlayer = scanner.nextLine();
                System.out.print("Escreva sua idade: ");
                this.idadePlayer = scanner1.nextInt();
                criado = true;
            } catch (InputMismatchException e) {
                System.out.println("Idade incompatível, tente novamente...");
            }
        }
        this.inventario = new ArrayList<>();                // Cria o array de inventário
        this.vidaTotal = 100 + (vitalidade * 10);           // Atribui o bonus de vitalidade a vida genérica do player
        this.vidaAtual = vidaTotal;                         // A vida inicial é igual a vida total
        this.totalBonusF = 0;
        this.totalBonusI = 0;
        this.totalBonusD = 0;
        this.totalBonusV = 0;
        this.totalBonusA = 0;
        this.totalBonusDef = 0;
        this.classes = new ArrayList<>();
        this.level = 1;
    }

    // Métodos
        // Métodos de gameplay
    public void updatePlayer() {    // Atualiza os atributos

        // Escolha de classe e adição dos bonus
        while (this.classe == null) {
            System.out.println("Classes: ");
            try {
                for (int i = 0; i < this.classes.size(); i++) {
                    System.out.println((i + 1) + " - " + this.classes.get(i).getNomeClasse());
                }
            } catch (NullPointerException e){
                System.out.println("Nenhuma classe existente...");
                System.exit(1);
            }
            System.out.print("Escolha sua classe: ");
            boolean classeEscolhida = false;
            while (!classeEscolhida) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    this.classe = this.classes.get(scanner.nextInt() - 1);
                    classeEscolhida = true;
                } catch (InputMismatchException | IndexOutOfBoundsException e) {
                    System.out.println("Classe inexistente, tente novamente...");
                    System.out.print("Escolha sua classe: ");
                }
            }
            this.itemAtaque = classe.getItemDeAtaqueInicial();  // Atribui o item inicial da classe ao item de player
            this.itemDefesa = classe.getItemDeDefesaInicial();  // ||
            this.itemArmadura = classe.getItemDeArmaduraInicial();// ||
            this.forca = classe.getForcaAddC();                 // Atribui o atributo da classe ao player
            this.inteligencia = classe.getInteligenciaAddC();   // ||
            this.destreza = classe.getDestrezaAddC();           // ||
            this.vitalidade = classe.getVitalidadeAddC();       // ||
            this.ataque = itemAtaque.getAtaqueAddI() + forca;   // Atribui o ataque do item de ataque mais o bonus de força
            this.defesa = itemDefesa.getDefesaAddI();           // Atribui a defesa do item
            this.vidaTotal = 100 + (this.vitalidade * 10);      // Atribui o bonus de vida
            this.vidaAtual = this.vidaTotal;                    // Atribui a vida atual a vida total para começar o jogo com vida maxima
        }

        // Reseta os bonus
        this.totalBonusF = 0;
        this.totalBonusI = 0;
        this.totalBonusD = 0;
        this.totalBonusV = 0;
        this.totalBonusA = 0;
        this.totalBonusDef = 0;

        // Cria o total de bonus de força
        try {
            this.totalBonusF += itemAtaque.getForcaAddI();
        } catch (NullPointerException e){ }
        try {
            this.totalBonusF += itemDefesa.getForcaAddI();
        } catch (NullPointerException e){ }
        try {
            this.totalBonusF += itemArmadura.getForcaAddI();
        } catch (NullPointerException e){ }

        // Cria o total de bonus de inteligencia
        try {
            this.totalBonusI += itemAtaque.getInteligenciaAddI();
        } catch (NullPointerException e){ }
        try {
            this.totalBonusI += itemDefesa.getInteligenciaAddI();
        } catch (NullPointerException e){ }
        try {
            this.totalBonusI += itemArmadura.getInteligenciaAddI();
        } catch (NullPointerException e){ }

        // Cria o total de bonus de destreza
        try {
            this.totalBonusD += itemAtaque.getDestrezaAddI();
        } catch (NullPointerException e){ }
        try {
            this.totalBonusD += itemDefesa.getDestrezaAddI();
        } catch (NullPointerException e){ }
        try {
            this.totalBonusD += itemArmadura.getDestrezaAddI();
        } catch (NullPointerException e){ }

        // Cria o bonus de vitalidade
        try {
            this.totalBonusV += itemAtaque.getVitalidadeAddI();
        } catch (NullPointerException e){ }
        try {
            this.totalBonusV += itemDefesa.getVitalidadeAddI();
        } catch (NullPointerException e){ }
        try {
            this.totalBonusV += itemArmadura.getVitalidadeAddI();
        } catch (NullPointerException e){ }

        // Adiciona os bonus de atributos
        this.forca = classe.getForcaAddC() + this.totalBonusF;
        this.inteligencia = classe.getInteligenciaAddC() + this.totalBonusI;
        this.destreza = classe.getDestrezaAddC() + this.totalBonusD;
        this.vitalidade = classe.getVitalidadeAddC() + this.totalBonusV;

        // Atualiza a vida total
        this.vidaTotal = 100 + (this.vitalidade * 10);

        // Cria o bonus de ataque
        try {
            this.totalBonusA += itemAtaque.getAtaqueAddI();
        } catch (NullPointerException e){ }
        try {
            this.totalBonusA += itemArmadura.getAtaqueAddI();
        } catch (NullPointerException e){ }

        // Criar o bonus de defesa
        try {
            this.totalBonusDef += itemDefesa.getDefesaAddI();
        } catch (NullPointerException e){ }
        try {
            this.totalBonusDef += itemArmadura.getDefesaAddI();
        } catch (NullPointerException e){ }

        // Adiciona os bonus de combate
        this.ataque = this.totalBonusA + this.forca;
        this.defesa = this.totalBonusDef;

        // Checa se o jogador está vivo ou morto
        if(this.vidaAtual <= 0){
            System.out.println("Você morreu");
            System.exit(0);
        }
    }

    public boolean guardarPocao(Item pocaoParaGuardar) {   // Guarda poções no inventário do player
        if (this.inventario.size() < 2) {
            if (pocaoParaGuardar.isItemPocao()) {
                this.addInventario(pocaoParaGuardar);
                System.out.println("Você guarda a " + pocaoParaGuardar.getNomeItem() + "!");
                return true;
            } else {
                System.out.println("Você só pode carregar poções!");
                return false;
            }
        } else {
            System.out.println("Seu inventário está cheio!");
            return false;
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

    public boolean equiparItem(Item itemParaEquipar){  // Equipa um item
        boolean sucesso;
        if (itemParaEquipar.isItemDeArmadura()) {
            if (this.itemArmadura == null) {
                this.itemArmadura = itemParaEquipar;
                System.out.println("Você equipa " + itemParaEquipar.getNomeItem() + "!");
                return true;
            } else {
                System.out.println("Você já tem uma armadura equipada...");
                return false;
            }
        }  else if (itemParaEquipar.isItemDeAtaque()){  // 1 - Arco, 2 - Espada, 3 - Cajado
            if (itemParaEquipar.isItemArco() && this.classe.isPodeUsarArco()) {
                if (this.itemAtaque == null) {
                    this.itemAtaque = itemParaEquipar;
                    System.out.println("Você equipa " + itemParaEquipar.getNomeItem() + "!");
                    return true;
                } else {
                    System.out.println("Você já está segurando um item de ataque...");
                    return false;
                }
            } else if (itemParaEquipar.isItemEspada() && this.classe.isPodeUsarEspada()) {
                if (this.itemAtaque == null) {
                    this.itemAtaque = itemParaEquipar;
                    System.out.println("Você equipa " + itemParaEquipar.getNomeItem() + "!");
                    return true;
                } else {
                    System.out.println("Você já está segurando um item de ataque...");
                }
            } else if (itemParaEquipar.isItemCajado() && this.classe.isPodeUsarCajado()) {
                if (this.itemAtaque == null) {
                    this.itemAtaque = itemParaEquipar;
                    System.out.println("Você equipa " + itemParaEquipar.getNomeItem() + "!");
                    return true;
                } else {
                    System.out.println("Você já está segurando um item de ataque...");
                }
            } else {
                System.out.println("Você não tem proficiência com esta arma...");
            }
        } else if (itemParaEquipar.isItemDeDefesa()){
            if (this.itemDefesa == null){
                this.itemDefesa = itemParaEquipar;
                System.out.println("Você equipa " + itemParaEquipar.getNomeItem() + "!");
                return true;
            } else {
                System.out.println("Você já está segurando um item de defesa...");
                return false;
            }
        } else {
            System.out.println("Esse item não pode ser equipado...");
            return false;
        }
        return false;
    }

    public void desequiparItem(int itemParaDesequipar){ // Desesquipa um item
        try {
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
                    if (this.itemAtaque == null) {
                        System.out.println("Você já não tem um item de ataque...");
                    } else {
                        this.itemAtaque = null;
                        System.out.println("Você larga seu item de ataque!");
                    }
                    break;
            }
        } catch (InputMismatchException e){
            System.out.println("Caractere inválido, tente novamente...");
        }
    }

        // Métodos para os menus
    public void mostrarAtributos(){ // Imprime os seus atributos
        System.out.println("ATRIBUTOS----------------");
        System.out.println("Nome:           " + this.getNomePlayer());
        System.out.println("Idade:          " + this.getIdadePlayer());
        System.out.println("Level:          " + this.getLevel());
        System.out.println("Classe:         " + this.getClasse().getNomeClasse());
        System.out.println("Vida:           " + this.getVidaAtual() + "/" + getVidaTotal());
        System.out.println("Força:          " + this.getForca());
        System.out.println("Inteligência:   " + this.getInteligencia());
        System.out.println("Destreza:       " + this.getDestreza());
        System.out.println("Vitalidade:     " + this.getVitalidade());
        System.out.println("Poder de ataque:" + this.getAtaque());
        System.out.println("Poder de defesa:" + this.getDefesa());
        System.out.println("-------------------------");
    }

    public void mostrarItens(){ // Imprime os itens equipados pelo player
        Scanner scanner = new Scanner(System.in);
        System.out.println("ITENS EQUIPADOS----------");
        try {
            System.out.println("Armadura:           " + this.getItemArmadura().getNomeItem() + ", " + this.getItemArmadura().getDescricaoItem());
        } catch (NullPointerException e){
            System.out.println("Armadura:           Vazio");
        }
        try {
            System.out.println("Item de ataque:     " + this.getItemAtaque().getNomeItem() + ", " + this.getItemAtaque().getDescricaoItem());
        } catch (NullPointerException e){
            System.out.println("Item de ataque:     Vazio");
        }
        try {
            System.out.println("Item de defesa:     " + this.getItemDefesa().getNomeItem() + ", " + this.getItemDefesa().getDescricaoItem());
        } catch (NullPointerException e){
            System.out.println("Item de defesa:     Vazio");
        }
        System.out.println("VOCÊ PODE----------------");
        System.out.println("1 - Desequipar item");
        System.out.println("2 - Voltar");
        System.out.println("-------------------------");

        System.out.print("Seu comando: ");
        if (scanner.nextInt() == 1){
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("VOCÊ PODE----------------");
            System.out.println("1 - Desequipar item de armadura");
            System.out.println("2 - Desequipar item de ataque");
            System.out.println("3 - Desequipar item de defesa");
            System.out.println("4 - Voltar");
            System.out.println("-------------------------");

            System.out.print("Seu comando: ");
            try {
                switch (scanner1.nextInt()) {
                    case 1:
                        this.desequiparItem(1);
                        break;
                    case 2:
                        this.desequiparItem(3);
                        break;
                    case 3:
                        this.desequiparItem(2);
                        break;
                    case 4:
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

    public void mostrarInventario(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("INVENTÁRIO---------------");
        try {
            System.out.println("Poção 1: " + this.inventario.get(0).getNomeItem());
        } catch (IndexOutOfBoundsException e){
            System.out.println("Poção 1: Vazio");
        }
        try {
            System.out.println("Poção 2: " + this.inventario.get(1).getNomeItem());
        } catch (IndexOutOfBoundsException e){
            System.out.println("Poção 2: Vazio");
        }
        System.out.println("VOCÊ PODE----------------");
        System.out.println("1 - Usar poção");
        System.out.println("2 - Voltar");
        System.out.println("-------------------------");
        System.out.print("Seu comando: ");

        try {
            if (scanner.nextInt() == 1) {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("VOCÊ PODE----------------");
                System.out.println("1 - Usar a poção 1");
                System.out.println("2 - Usar a poção 2");
                System.out.println("3 - Voltar");
                System.out.println("-------------------------");
                System.out.print("Seu comando: ");
                if (scanner1.nextInt() == 1) {
                    try {
                        System.out.println("Você toma a " + this.getInventario().get(0).getNomeItem() + "!");
                        this.usarPocao(1);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Não existe uma poção ai...");
                    }
                } else if (scanner1.nextInt() == 2) {
                    try {
                        System.out.println("Você toma a " + this.getInventario().get(1).getNomeItem() + "!");
                        this.usarPocao(2);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Não existe uma poção ai...");
                    }
                } else {
                    System.out.println("Número inválido, tente novamente...");
                }
            } else {
                System.out.println("Número inválido, tente novamente...");
            }
        } catch (InputMismatchException e){
            System.out.println("Caractere inválido, tente novamente...");

        }
    }

    // Get e Set
    public String getNomePlayer() {
        return nomePlayer;
    }

    public void setNomePlayer(String nomePlayer) {
        this.nomePlayer = nomePlayer;
    }

    public void setInventario(ArrayList<Item> inventario) {
        this.inventario = inventario;
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

    public int getTotalBonusF() {
        return totalBonusF;
    }

    public void setTotalBonusF(int totalBonusF) {
        this.totalBonusF = totalBonusF;
    }

    public int getTotalBonusI() {
        return totalBonusI;
    }

    public void setTotalBonusI(int totalBonusI) {
        this.totalBonusI = totalBonusI;
    }

    public int getTotalBonusD() {
        return totalBonusD;
    }

    public void setTotalBonusD(int totalBonusD) {
        this.totalBonusD = totalBonusD;
    }

    public int getTotalBonusV() {
        return totalBonusV;
    }

    public void setTotalBonusV(int totalBonusV) {
        this.totalBonusV = totalBonusV;
    }

    public int getTotalBonusA() {
        return totalBonusA;
    }

    public void setTotalBonusA(int totalBonusA) {
        this.totalBonusA = totalBonusA;
    }

    public int getTotalBonusDef() {
        return totalBonusDef;
    }

    public void setTotalBonusDef(int totalBonusDef) {
        this.totalBonusDef = totalBonusDef;
    }

    public int getIdadePlayer() {
        return idadePlayer;
    }

    public void setIdadePlayer(int idadePlayer) {
        this.idadePlayer = idadePlayer;
    }

    public ArrayList<Classe> getClasses() {
        return classes;
    }

    public void addClasses(Classe classes) {
        this.classes.add(classes);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
