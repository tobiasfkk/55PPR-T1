package Controller;

import Comando.Command;
import Comando.SetVisibilityCommand;
import DAO.AtividadeDAO;
import DAO.CategoriaDAO;
import DAO.ObservadorDAO;
import Exception.CampoVazioException;
import Model.Categoria;
import Model.Logger;
import Model.Status;
import Model.Tarefa;
import Model.TarefaFactory;
import Model.ValidacaoDecorator;
import Observado.Observado;
import Observador.Observador;
import View.ViewCriarTarefa;
import interfaces.AtividadeFactory;
import interfaces.TarefaDecorator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControladorViewCriarTarefa extends Observado{
    private ViewCriarTarefa viewCadastrarTarefa = new ViewCriarTarefa();
    private CategoriaDAO categoriaDAO = new CategoriaDAO();
    private Logger log = Logger.getInstance();
    private Command cadastrarTarefaCommand;
    
    public ControladorViewCriarTarefa() {
        valoresCampoPrioridade();
        valoresCampoCategoria();
        valoresCampoStatus();
        adicionarAcao();
        cadastrarTarefaCommand = new SetVisibilityCommand(viewCadastrarTarefa);
        cadastrarTarefaCommand.execute();
//        abrirTela();
    }
    
//    public void abrirTela(){
//        viewCadastrarTarefa.exibir();
//    }
    
    public void fecharTela(){
        viewCadastrarTarefa.fechar();
    }
    
    public void adicionarAcao(){
        viewCadastrarTarefa.adicionarAcaoBotaoCadastrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    salvar();
                } catch (CampoVazioException ex) {
                    viewCadastrarTarefa.exibirMensagem(ex.getMessage());
                }
            }
        });
    }
    
    public void salvar()throws CampoVazioException{
        if((viewCadastrarTarefa.getTitulo().isEmpty())||(viewCadastrarTarefa.getDataConclusao().equals("  /  /  "))){
            throw new CampoVazioException("TÍTULO E DATA DE CONCLUSÃO NÃO PODEM ESTAR VAZIOS!");
        }else{
            AtividadeFactory tarefaFactory = new TarefaFactory();
            Tarefa tarefa = (Tarefa) tarefaFactory.createAtividade(viewCadastrarTarefa.getTitulo(), viewCadastrarTarefa.getDataConclusao(), viewCadastrarTarefa.getPrioridade(), viewCadastrarTarefa.getStatus(), viewCadastrarTarefa.getDescricao(), viewCadastrarTarefa.getCategoria());
            viewCadastrarTarefa.enviarImagem();
            tarefa.setAnexo(viewCadastrarTarefa.getAnexo());
            AtividadeDAO tarefaDAO = new AtividadeDAO();
            tarefaDAO.gravar(tarefa);
            notificarObservadores();
            log.log("Tarefa foi inserida com sucesso!" + "Titulo: "+viewCadastrarTarefa.getTitulo().toString() );
            log.exibirLogs();
            viewCadastrarTarefa.limparCampos();
            viewCadastrarTarefa.exibirMensagem("TAREFA CADASTRADA COM SUCESSO!");
            tarefa.operacao();
            TarefaDecorator tarefaComValidacao = new ValidacaoDecorator(tarefa);
            tarefaComValidacao.operacao();
            fecharTela();
        }
    }

    public void valoresCampoPrioridade(){
        Map<String, String> prioridadeCombo = new HashMap<String, String>();

        prioridadeCombo.put("Baixa","Baixa");
        prioridadeCombo.put("Media","Média");
        prioridadeCombo.put("Alta","Alta");
        prioridadeCombo.put("Critico","Crítico");
        
        for(String key : prioridadeCombo.keySet()){
            viewCadastrarTarefa.CampoPrioridade(prioridadeCombo.get(key));
        }
    }
    
    public void valoresCampoCategoria(){
        for (Categoria categoria : categoriaDAO.buscarTodosCategorias()) {
            viewCadastrarTarefa.CampoCategoria(categoria);
        }
    }
    
    public void valoresCampoStatus(){
        Status naoConcluido = new Status(2,"Não Concluído");
        Status concluido = new Status(1,"Concluido");
        
        List<Status> listaStatus = new ArrayList();
        
        listaStatus.add(concluido);
        listaStatus.add(naoConcluido);
        
        Collections.sort(listaStatus);   

        for(Status status : listaStatus){
            viewCadastrarTarefa.CampoStatus(status.getNome());
        }
    }
}
