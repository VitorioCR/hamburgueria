package hamburgueria;

/** [ABSTRACT FACTORY] Interface da fábrica abstrata — define família de produtos relacionados. */
public interface FabricaAbstrata {
    Embalagem createEmbalagem();
    Acompanhamento createAcompanhamento();
}
