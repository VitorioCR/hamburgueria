package hamburgueria;

/** [ABSTRACT FACTORY] Produto concreto — embalagem biodegradável vegana. */
public class EmbalagemVegana implements Embalagem {
    @Override
    public String getTipo() { return "Embalagem biodegradável vegana"; }
}
