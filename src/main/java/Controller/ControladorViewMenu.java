package Controller;

import Model.Tarefa;
import View.ViewMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorViewMenu {
    
    private ViewMenu viewMenu = new ViewMenu();
    private Tarefa tarefa;

    public ControladorViewMenu() {
        exibir();
        adicionarAcoes();                
    }
    
    public void exibir(){
        viewMenu.abrirTela();
    }
      
    public void fechar(){
        viewMenu.fecharTela();
    }
    
    public void cadastrarCategoria(){
        ControladorViewCadastrarCategoria controladorViewCadastrarCategoria = new ControladorViewCadastrarCategoria();
    }
    
    public void cadastrarTarefa(){
        ControladorViewCriarTarefa controladorViewCriarTarefa = new ControladorViewCriarTarefa();
    }
    
    public void visualiazarCategoria(){
        ControladorViewAlterarCategoria controladorViewAlterarCategoria = new ControladorViewAlterarCategoria();
    }
    
    public void visualiazarTarefa(){
       ControladorViewAlterarTarefa controladorViewAlterarTarefa = new ControladorViewAlterarTarefa();
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
