package DAO;

import Model.Categoria;
import Model.Tarefa;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import interfaces.AtividadeInterface;

public class AtividadeDAO implements AtividadeInterface{
    
    private static List<Tarefa>tarefas;

    public AtividadeDAO(){
        if(tarefas == null)
           tarefas = new ArrayList<>();
    }
    
   
    @Override
    public void gravar(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    @Override
    public Tarefa buscar(Date data) {
        for(Tarefa tarefa : tarefas){
            if (tarefa.getDatahoracriacao().equals(data))
                return tarefa;
        }
        return null;
    }
    
    @Override
    public List<Tarefa> buscarTodasTarefas() {
        return tarefas;
    }
    
    @Override
    public void editar(int numerotarefa, String titulo, String dataconclusao, String prioridade, String status, String descricao, Categoria categoria) {
         for(Tarefa tarefa : tarefas){
             if (tarefa.getNumerotarefa() == numerotarefa){

                tarefa.setTitulo(titulo);
                 tarefa.setDataconclusao(dataconclusao);
                 
                 tarefa.setPrioridade(prioridade);
                 tarefa.setDescricao(descricao);
                 tarefa.setStatus(status);
                 tarefa.setCategoria(categoria);
             }
         }
    }

    @Override
    public void remover(Tarefa tarefa) {
        tarefas.remove(tarefa);
    }

}