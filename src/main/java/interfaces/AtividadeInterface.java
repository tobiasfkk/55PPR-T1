package interfaces;

import Model.Categoria;
import Model.Tarefa;
import java.util.Date;
import java.util.List;

 public interface AtividadeInterface {
    
    public void gravar(Tarefa tarefa);
    public Tarefa buscar(Date data);
    public void remover(Tarefa tarefa);
    public void editar(int numerotarefa, String titulo, String dataconclusao, String prioridade, String status, String descricao, Categoria categoria);
    public List<Tarefa> buscarTodasTarefas();
}
