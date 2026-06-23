package hamburgueria;

/** [ABSTRACT FACTORY] Produto concreto — embalagem clássica de papelão. */
public class EmbalagemClassica implements Embalagem {
    @Override
    public String getTipo() { return "Caixa de papelão clássica"; }
}
