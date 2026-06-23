package hamburgueria;

/** [ABSTRACT FACTORY] Fábrica concreta — cria família de produtos para o combo clássico. */
public class FabricaComboClassico implements FabricaAbstrata {

    @Override
    public Embalagem createEmbalagem() { return new EmbalagemClassica(); }

    @Override
    public Acompanhamento createAcompanhamento() { return new AcompanhamentoBatataFrita(); }
}
