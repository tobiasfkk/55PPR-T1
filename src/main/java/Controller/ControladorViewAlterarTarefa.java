package Controller;

import DAO.CategoriaDAO;
import DAO.TarefaDAO;
import Exception.CampoVazioException;
import Model.Categoria;
import Model.Tarefa;
import Observado.Observado;
import View.ViewAlterarTarefa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ControladorViewAlterarTarefa extends Observado{
    private ViewAlterarTarefa ViewAlterarTarefa = new ViewAlterarTarefa();
    private TarefaDAO repositorioTarefa = new TarefaDAO();
    private CategoriaDAO repositorioCategoria = new CategoriaDAO();
    
    public ControladorViewAlterarTarefa() {
        carregarComboCategoria();
        carregarComboTarefa();
        valoresCampoStatus();
        valoresCampoPrioridade();
        adicionarAcao();
        ComboTarefa();
        abrirTela();
    }
    
    public void abrirTela(){
        ViewAlterarTarefa.exibir();
    }
    
    public void fecharTela(){
        ViewAlterarTarefa.fechar();
    }
    
    public void adicionarAcao(){
        ViewAlterarTarefa.adicionarAcaoBotaoSalvar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    salvar();
                } catch (CampoVazioException ex) {
                    ViewAlterarTarefa.exibirMensagem(ex.getMessage());
                }
            }
        });
        ViewAlterarTarefa.adicionarAcaoComboTarefa(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComboTarefa();
            }
        });
        ViewAlterarTarefa.adicionarAcaoBotaoDeletar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletar();
            }
        });
    }
    
    public void ComboTarefa(){
        Tarefa SelectedItem = ViewAlterarTarefa.getComboTarefa();
        ViewAlterarTarefa.setTarefaTitulo(SelectedItem.getTitulo());
        ViewAlterarTarefa.setTarefaPrioridade(SelectedItem.getPrioridade());
        ViewAlterarTarefa.setTarefaStatus(SelectedItem.getStatus());
        ViewAlterarTarefa.setTarefaDataConclusao(SelectedItem.getDataconclusao());
        ViewAlterarTarefa.setTarefaCategoria(SelectedItem.getCategoria());
        ViewAlterarTarefa.setTarefaDescricao(SelectedItem.getDescricao());
        ViewAlterarTarefa.setTarefaAnexo(SelectedItem.getAnexo());
    }
    
    public void salvar() throws CampoVazioException{
        if(ViewAlterarTarefa.getTarefaTitulo().isEmpty()){
            throw new CampoVazioException("TITULO NÃO PODE ESTAR VÁZIO!");
        }else{
            Tarefa SelectedItem = (Tarefa) ViewAlterarTarefa.getComboTarefa();
            
            repositorioTarefa.editar(SelectedItem.getNumerotarefa(), ViewAlterarTarefa.getTarefaTitulo(), ViewAlterarTarefa.getTarefaDataConclusao(), ViewAlterarTarefa.getTarefaPrioridade(), ViewAlterarTarefa.getTarefaStatus(), ViewAlterarTarefa.getTarefaDescricao(), ViewAlterarTarefa.getComboCategoria());
            ViewAlterarTarefa.enviarImagem();
            SelectedItem.setAnexo(ViewAlterarTarefa.getAnexo());
            notificarObservadores();
            ViewAlterarTarefa.limparCampos();
            ViewAlterarTarefa.exibirMensagem("TAREFA SALVA COM SUCESSO!");
            ComboTarefa();
        }
    }
    
    public void deletar(){
        Tarefa SelectedItem = (Tarefa) ViewAlterarTarefa.getComboTarefa();
        repositorioTarefa.remover(SelectedItem);    
        ViewAlterarTarefa.exibirMensagem("TAREFA DELETADA COM SUCESSO!");
        fecharTela();
    }
    
    public void carregarComboCategoria(){
        for (Categoria categoria : repositorioCategoria.buscarTodosCategorias()) {
            ViewAlterarTarefa.ComboCategoria(categoria);
        }
    }
    
    public void carregarComboTarefa(){
        for (Tarefa tarefa : repositorioTarefa.buscarTodasTarefas()) {
            ViewAlterarTarefa.ComboTarefa(tarefa);
        }
    }
    
    public void valoresCampoStatus(){
        ViewAlterarTarefa.CampoStatus("Não Concluído");
        ViewAlterarTarefa.CampoStatus("Concluído");
    }
    
    public void valoresCampoPrioridade(){
        Map<String, String> prioridadeCombo = new HashMap<String, String>();

        prioridadeCombo.put("Baixa","Baixa");
        prioridadeCombo.put("Media","Média");
        prioridadeCombo.put("Alta","Alta");
        prioridadeCombo.put("Critico","Crítico");
        
        for(String key : prioridadeCombo.keySet()){
            ViewAlterarTarefa.CampoPrioridade(prioridadeCombo.get(key));
        }
    }
    
}
