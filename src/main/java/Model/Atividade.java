package Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Atividade {   
    
    protected String titulo;
    protected String datahoracriacao;
    protected String dataconclusao;
    protected String prioridade;
    protected String status;
    protected String descricao;

    public Atividade(String titulo, String dataconclusao, String prioridade, String status, String descricao){
        this.titulo = titulo;
        this.dataconclusao = dataconclusao;
        this.prioridade = prioridade;
        this.status = status;
        this.descricao = descricao;
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
        Date date = new Date(); 
        this.datahoracriacao  = dateFormat.format(date); 
    }
    
//    public abstract String toString();
    
    public final String toString() {
        StringBuilder result = new StringBuilder();
        result.append(formatInformacoesComuns()); // Método comum a todas as atividades
        result.append(formatInformacoesEspecificas()); // Método específico a cada atividade
        return result.toString();
    }
    
    // Método comum a todas as atividades
    private String formatInformacoesComuns() {
        return " --> " + titulo + " - " + descricao;
    }
    
    protected abstract String formatInformacoesEspecificas();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDatahoracriacao() {
        return datahoracriacao;
    }

    public void setDatahoracriacao(String datahoracriacao) {
        this.datahoracriacao = datahoracriacao;
    }

    public String getDataconclusao() {
        return dataconclusao;
    }

    public void setDataconclusao(String dataconclusao) {
        this.dataconclusao = dataconclusao;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
    
    
    
    
    