package Model;

import interfaces.AtividadeFactory;

public class CategoriaFactory implements AtividadeFactory { 

    @Override
    public Atividade createAtividade(String nomecategoria, String dataconclusao, String prioridade, String descricaocategoria, String status) {
        return new Categoria(nomecategoria, dataconclusao, prioridade, status, descricaocategoria);
    }

    @Override
    public Atividade createAtividade(String titulo, String dataconclusao, String prioridade, String status, String descricao, Categoria categoria) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
