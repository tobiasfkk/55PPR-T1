package Controller;

import Comando.Command;
import Comando.SetVisibilityCommand;
import DAO.CategoriaDAO;
import DAO.AtividadeDAO;
import Model.Categoria;
import Model.Tarefa;
import View.ViewAlterarCategoria;
import View.ViewCadastrarCategoria;
import View.ViewCriarTarefa;
import View.ViewMenu;
import interfaces.CategoriaInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import interfaces.AtividadeInterface;

public class ControladorViewMenu {
    
    private ViewMenu viewMenu = new ViewMenu();
    private Tarefa tarefa;
    ControladorViewListaTarefa controladorViewListaTarefa = new ControladorViewListaTarefa();
    ControladorViewCriarTarefa controladorViewCriarTarefa = new ControladorViewCriarTarefa();
        
    public ControladorViewMenu() {

        exibir();
        adicionarAcoes();
        controladorViewListaTarefa.abrirTela();
        controladorViewCriarTarefa.adicionarObservador(controladorViewListaTarefa);
        controladorViewCriarTarefa.fecharTela(); 
    }
    
    public void exibir(){
        viewMenu.abrirTela();
    }
      
    public void fechar(){
        controladorViewListaTarefa.fecharTela();
        viewMenu.fecharTela();   
    }
    
    public void cadastrarCategoria(){
        ControladorViewCadastrarCategoria controladorViewCadastrarCategoria = new ControladorViewCadastrarCategoria();
    }
    
    public void cadastrarTarefa(){
        CategoriaInterface repositorioCategoria = new CategoriaDAO();
        boolean entrou = false;
        for (Categoria categoria : repositorioCategoria.buscarTodosCategorias()) { 
            entrou = true;
            break;
        }
        if(entrou == false){
            viewMenu.exibirMensagem("NECESSÁRIO CADASTRAR PELO MENOS UMA CATEGORIA!");
        }else{
            ControladorViewCriarTarefa controladorViewCriarTarefa = new ControladorViewCriarTarefa();
        }
    }
    
    public void visualiazarCategoria(){
        CategoriaInterface repositorioCategoria = new CategoriaDAO();
        boolean entrou = false;
        for (Categoria categoria : repositorioCategoria.buscarTodosCategorias()) {
            entrou = true;
            break;
        }
        if(entrou == false){
            viewMenu.exibirMensagem("NECESSÁRIO CADASTRAR PELO MENOS UMA CATEGORIA!");
        }else{
            ControladorViewAlterarCategoria controladorViewAlterarCategoria = new ControladorViewAlterarCategoria();
        } 
    }
    
    public void visualiazarTarefa(){
        AtividadeInterface repositorioTarefa = new AtividadeDAO();
        boolean entrou = false;
        for (Tarefa tarefa : repositorioTarefa.buscarTodasTarefas()) {
            entrou = true;
            break;
        }
        if(entrou == false){
            viewMenu.exibirMensagem("NECESSÁRIO CADASTRAR PELO MENOS UMA TAREFA!");
        }else{
            ControladorViewAlterarTarefa controladorViewAlterarTarefa = new ControladorViewAlterarTarefa();
        }
    }

    
    public void adicionarAcoes(){
        
        viewMenu.adicionarAcaoBotaoCadastrarCategoria(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCategoria();
            }
        });
        
        viewMenu.adicionarAcaoBotaoCadastrarTarefa(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarTarefa();
            }
        });
        
        viewMenu.adicionarAcaoBotaoVisualizarCategoria(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualiazarCategoria();
            }
        });
        
        viewMenu.adicionarAcaoBotaoVisualizarTarefa(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualiazarTarefa();
            }
        });
        
        viewMenu.adicionarAcaoBotaoFechar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        }); 
    }
}
