package interfaces;

import Model.Atividade;
import Model.Categoria;

public interface AtividadeFactory {
    Atividade createAtividade(String titulo, String dataconclusao, String prioridade, String status, String descricao, Categoria categoria);
}
