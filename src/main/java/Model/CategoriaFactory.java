package Model;

import interfaces.AtividadeFactory;

public class CategoriaFactory implements AtividadeFactory {
    @Override
    public Atividade createAtividade(String titulo, String dataconclusao, String prioridade, String status, String descricao, Categoria categoria) {
        return null;
    }
}
