package Model;

import interfaces.AtividadeFactory;

public class TarefaFactory implements AtividadeFactory {
    @Override
    public Atividade createAtividade(String titulo, String dataconclusao, String prioridade, String status, String descricao, Categoria categoria) {
        return new Tarefa(titulo, dataconclusao, prioridade, status, descricao, categoria);
    }

    @Override
    public Atividade createAtividade(String nomecategoria, String dataconclusao, String prioridade, String descricaocategoria, String status) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}