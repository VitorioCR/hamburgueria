package hamburgueria;

import java.util.Arrays;
import java.util.List;

/** [TEMPLATE METHOD] Implementação concreta do template — preparo do hambúrguer artesanal. */
public class PrepararHamburguer extends PrepararLanche {

    @Override
    protected String montarBase() {
        return "Montando base: pão brioche + hambúrguer bovino 180g";
    }

    @Override
    protected List<String> adicionarIngredientesEspeciais() {
        return Arrays.asList(
                "Adicionando queijo cheddar derretido",
                "Adicionando alface americana",
                "Adicionando tomate fatiado",
                "Adicionando cebola caramelizada"
        );
    }
}
