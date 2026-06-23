package hamburgueria;

import java.util.ArrayList;
import java.util.List;

/** [TEMPLATE METHOD] Algoritmo esqueleto — define passos fixos e variáveis do preparo de lanches. */
public abstract class PrepararLanche {

    // Template Method — define o algoritmo de preparo (final: não pode ser sobrescrito)
    public final List<String> preparar() {
        List<String> passos = new ArrayList<>();
        passos.add(aquecer());
        passos.add(montarBase());
        passos.addAll(adicionarIngredientesEspeciais());
        passos.add(adicionarMolho());
        passos.add(finalizar());
        return passos;
    }

    // Passos comuns (concretos)
    protected String aquecer() { return "Aquecendo a chapa na temperatura ideal"; }
    protected String adicionarMolho() { return "Adicionando molho especial da casa"; }
    protected String finalizar() { return "Embalando e entregando para o cliente"; }

    // Hook methods — subclasses devem implementar
    protected abstract String montarBase();
    protected abstract List<String> adicionarIngredientesEspeciais();
}
