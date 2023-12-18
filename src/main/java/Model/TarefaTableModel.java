package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TarefaTableModel extends AbstractTableModel {
    
    private List<Tarefa>tarefas;
    
    private String[] nomeColunas = {"Sequencial","Data Conclusao", "Título","Descricão", "Status",  "Prioridade", "Criado em"};
    private final int COLUNA_COD = 0;
    private final int COLUNA_DATACONCLUSAO = 1;
    private final int COLUNA_TITULO = 2;
    private final int COLUNA_DESCRICAO = 3;
    private final int COLUNA_STATUS = 4;
    private final int COLUNA_PRIORIDADE = 5;
    private final int COLUNA_DATACRIACAO = 6;
    
    public TarefaTableModel(List<Tarefa>tarefas){
        this.tarefas = tarefas;
    }
    
    @Override
    public int getRowCount() {
        return tarefas.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }
    
    @Override
    public String getColumnName(int index) {
        return nomeColunas[index];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tarefa tarefa = this.tarefas.get(rowIndex);
            switch(columnIndex){
                case COLUNA_COD:
                    return tarefa.getNumerotarefa();
                case COLUNA_DATACONCLUSAO:
                    return tarefa.getDataconclusao();
                case COLUNA_TITULO:
                    return tarefa.getTitulo();
                case COLUNA_DESCRICAO:
                    return tarefa.getDescricao();
                case COLUNA_STATUS:
                    return tarefa.getStatus();
                case COLUNA_PRIORIDADE:
                    return tarefa.getPrioridade();
                case COLUNA_DATACRIACAO:
                    return tarefa.getDatahoracriacao();
            }
            return null;
    }
    
}
