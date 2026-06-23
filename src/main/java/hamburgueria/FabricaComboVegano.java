package hamburgueria;

/** [ABSTRACT FACTORY] Fábrica concreta — cria família de produtos para o combo vegano. */
public class FabricaComboVegano implements FabricaAbstrata {

    @Override
    public Embalagem createEmbalagem() { return new EmbalagemVegana(); }

    @Override
    public Acompanhamento createAcompanhamento() { return new AcompanhamentoSaladaVerde(); }
}
