package Controller;

import Comando.Command;
import Comando.SetVisibilityCommand;
import DAO.CategoriaDAO;
import Exception.CampoVazioException;
import Model.Categoria;
import View.ViewCadastrarCategoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorViewCadastrarCategoria {
    
    private ViewCadastrarCategoria viewCadastrarCategoria = new ViewCadastrarCategoria();
    private Command cadastrarCategoriaCommand;
    
    public ControladorViewCadastrarCategoria() {
        valoresCampoStatus();
        cadastrarCategoriaCommand = new SetVisibilityCommand(viewCadastrarCategoria);
        cadastrarCategoriaCommand.execute();
        adicionarAcao();
    }
    
    public void fecharTela(){
        viewCadastrarCategoria.fechar();
    }
    
    public void adicionarAcao(){
        viewCadastrarCategoria.adicionarAcaoBotaoCadastrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    salvar();
                } catch (CampoVazioException ex) {
                    viewCadastrarCategoria.exibirMensagem(ex.getMessage());
                }
            }
        });
    }
    
    public void salvar() throws CampoVazioException{
        if(viewCadastrarCategoria.getNome().isEmpty()||viewCadastrarCategoria.getDescricao().isEmpty()){
            throw new CampoVazioException("NOME E CATEGORIA NÃO PODEM ESTAR VAZIOS!");
        }else{
            Categoria categoria = new Categoria(viewCadastrarCategoria.getNome(), viewCadastrarCategoria.getDescricao(), viewCadastrarCategoria.getSituacao());
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            categoriaDAO.gravar(categoria);
            viewCadastrarCategoria.limparCampos();
            viewCadastrarCategoria.exibirMensagem("CATEGORIA CADASTRADA COM SUCESSO!");
            fecharTela();
        }
    }
    
    public void valoresCampoStatus(){
            
        viewCadastrarCategoria.CampoStatus("Ativo");
        viewCadastrarCategoria.CampoStatus("Inativo");

    }
    
}
