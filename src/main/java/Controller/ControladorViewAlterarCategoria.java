package Controller;

import DAO.CategoriaDAO;
import Exception.CampoVazioException;
import Model.Categoria;
import View.ViewAlterarCategoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorViewAlterarCategoria {
    
    private ViewAlterarCategoria viewAlterarCategoria = new ViewAlterarCategoria();
    private CategoriaDAO repositorioCategoria = new CategoriaDAO();

    public ControladorViewAlterarCategoria() {
        carregarComboCategoria();
        valoresCampoStatus();
        adicionarAcao();
        abrirTela();
    }
    
    public void abrirTela(){
        viewAlterarCategoria.exibir();
    }
    
    public void fecharTela(){
        viewAlterarCategoria.fechar();
    }
    
    public void adicionarAcao(){
        viewAlterarCategoria.adicionarAcaoBotaoSalvar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    salvar();
                } catch (CampoVazioException ex) {
                    viewAlterarCategoria.exibirMensagem(ex.getMessage());
                }
            }
        });
        viewAlterarCategoria.adicionarAcaoBotaoDeletar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletar();
            }
        });
        viewAlterarCategoria.adicionarAcaoComboCategoria(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComboCategoria();
            }
        });   
    }
    
    public void salvar() throws CampoVazioException{
        if(viewAlterarCategoria.getCategoriaNome().isEmpty()||viewAlterarCategoria.getCategoriaDescricao().isEmpty()){
            throw new CampoVazioException("NOME E DESCRICÃO NÃO PODEM ESTAR VAZIOS!");
        }else{
            Categoria SelectedItem = (Categoria) viewAlterarCategoria.getComboCategoria();
            repositorioCategoria.editar(SelectedItem.getNumeroCategoria(), viewAlterarCategoria.getCategoriaNome(), viewAlterarCategoria.getCategoriaDescricao(), viewAlterarCategoria.getCategoriaSituacao());
            viewAlterarCategoria.limparCampos();
            viewAlterarCategoria.exibirMensagem("CATEGORIA SALVA COM SUCESSO!");
            ComboCategoria();
            fecharTela();
        }
    }
    
    public void deletar(){
        Categoria SelectedItem = (Categoria) viewAlterarCategoria.getComboCategoria();        
        repositorioCategoria.remover(SelectedItem);
        viewAlterarCategoria.exibirMensagem("CATEGORIA DELETADA COM SUCESSO!");
        fecharTela();
    }
    
    public void ComboCategoria(){
        Categoria SelectedItem = viewAlterarCategoria.getComboCategoria();
        viewAlterarCategoria.setCategoriaNome(SelectedItem.getNomeCategoria());
        viewAlterarCategoria.setCategoriaDescricao(SelectedItem.getDescricaoCategoria());
        viewAlterarCategoria.setCategoriaSituacao(SelectedItem.getStatus());
        
    }
    
    public void carregarComboCategoria(){
        for (Categoria categoria : repositorioCategoria.buscarTodosCategorias()) {
            viewAlterarCategoria.ComboCategoria(categoria);
        }
    }
    
    public void valoresCampoStatus(){
            
        viewAlterarCategoria.CampoStatus("Ativo");
        viewAlterarCategoria.CampoStatus("Inativo");

    }

}
    