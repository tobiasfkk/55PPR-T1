package interfaces;

import Observador.Observador;
import java.util.List;

public interface ObservadorInterface {
    public void gravar (Observador observador);
    public List<Observador> buscaTodosObservadores();
}
