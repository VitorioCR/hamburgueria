package hamburgueria;

/** [FACTORY METHOD] Fábrica que cria instâncias de IItemMenu via reflexão, desacoplando cliente da criação. */
public class ItemMenuFactory {

    public static IItemMenu obterItem(String tipo) {
        Class<?> classe = null;
        Object objeto = null;
        try {
            classe = Class.forName("hamburgueria.Item" + tipo);
            objeto = classe.getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException("Item de menu inexistente: " + tipo);
        }
        if (!(objeto instanceof IItemMenu)) {
            throw new IllegalArgumentException("Tipo de item inválido: " + tipo);
        }
        return (IItemMenu) objeto;
    }
}
