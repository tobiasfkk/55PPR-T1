package Controller;

import DAO.TarefaDAO;
import Model.Tarefa;
import Observador.Observador;
import View.ViewListaTarefa;
import java.util.List;

public class ControladorViewListaTarefa implements Observador {
    private ViewListaTarefa ViewListaTarefa = new ViewListaTarefa();
    private TarefaDAO repositorioTarefa = new TarefaDAO();
    
    public ControladorViewListaTarefa() {
        abrirTela();
    }
    
    public void abrirTela(){
        ViewListaTarefa.exibir();
    }
    
    public void fecharTela(){
        ViewListaTarefa.fechar();
    }

    @Override
    public void atualizarListaTarefas() {
        List<Tarefa> todasTarefas = repositorioTarefa.buscarTodasTarefas();
        ViewListaTarefa.addTarefa(todasTarefas);
    }
}
