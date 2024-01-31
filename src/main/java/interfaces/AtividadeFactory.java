package interfaces;

import Model.Atividade;
import Model.Categoria;

public interface AtividadeFactory {
    Atividade createAtividade(String nomecategoria, String dataconclusao, String prioridade, String descricaocategoria, String status);
    Atividade createAtividade(String titulo, String dataconclusao, String prioridade, String status, String descricao, Categoria categoria);
}
