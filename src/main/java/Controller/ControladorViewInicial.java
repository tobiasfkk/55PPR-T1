package Controller;

import View.ViewInicial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorViewInicial {
    
    private ViewInicial viewInicial = new ViewInicial();;

    public ControladorViewInicial() {
        exibir();
        adicionarAcao();
    }
    
    public void adicionarAcao(){
        viewInicial.adicionarAcaoBotao(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirMenu();
            }
        });
    }
   
    public void abrirMenu() {     
        ControladorViewMenu controladorViewMenu = new ControladorViewMenu();
//        ControladorViewListaTarefa controladorViewListaTarefa = new ControladorViewListaTarefa();
//        controladorViewListaTarefa.abrirTela();
//        ControladorViewCriarTarefa controladorViewCriarTarefa = new ControladorViewCriarTarefa();
//        controladorViewCriarTarefa.adicionarObservador(controladorViewListaTarefa);
//        controladorViewCriarTarefa.fecharTela();
        fechar();
    }
    
    public void exibir(){
        viewInicial.abrirTela();
    }
    
    public void fechar(){
        viewInicial.fechar();
    }
}
