package hamburgueria;

/** [COMMAND] Interface comando — encapsula uma ação de cozinha como objeto. */
public interface ComandoCozinha {
    void executar();
    void desfazer();
}
