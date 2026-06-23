package hamburgueria;

import java.util.Arrays;
import java.util.List;

/** [TEMPLATE METHOD] Implementação concreta do template — preparo do wrap de frango. */
public class PrepararWrap extends PrepararLanche {

    @Override
    protected String aquecer() { return "Aquecendo a tortilha na frigideira"; }

    @Override
    protected String montarBase() {
        return "Montando base: tortilha de trigo integral + frango grelhado";
    }

    @Override
    protected List<String> adicionarIngredientesEspeciais() {
        return Arrays.asList(
                "Adicionando mix de folhas verdes",
                "Adicionando tomate cereja",
                "Adicionando cream cheese",
                "Enrolando o wrap firmemente"
        );
    }
}
