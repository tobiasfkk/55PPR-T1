package Observado;

import DAO.ObservadorDAO;
import Observador.Observador;
import java.util.ArrayList;
import java.util.List;

public abstract class Observado {
    private ObservadorDAO observadorDAO = new ObservadorDAO();
     
    public void adicionarObservador(Observador observador) {
        observadorDAO.gravar(observador);
    }
    
    public void notificarObservadores() {
        for (Observador observador : observadorDAO.buscaTodosObservadores()) {
            observador.atualizarListaTarefas();
        }
    }
}
