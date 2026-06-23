package hamburgueria;

/**
 * [ABSTRACT FACTORY] Cliente da fábrica abstrata — usa FabricaAbstrata para montar
 * combos sem conhecer as classes concretas de embalagem e acompanhamento.
 */
public class Combo {
    private String nome;
    private FabricaAbstrata fabrica;

    public Combo(String nome, FabricaAbstrata fabrica) {
        this.nome = nome;
        this.fabrica = fabrica;
    }

    public String getNome() { return nome; }

    public Embalagem getEmbalagem() { return fabrica.createEmbalagem(); }

    public Acompanhamento getAcompanhamento() { return fabrica.createAcompanhamento(); }

    public String descrever() {
        return "Combo " + nome +
                " | Embalagem: " + getEmbalagem().getTipo() +
                " | Acompanhamento: " + getAcompanhamento().getNome();
    }
}
