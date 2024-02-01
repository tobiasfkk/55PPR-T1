package Model;

import interfaces.AtividadeFactory;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Categoria extends Atividade{
    
    private static int contador = 1;
    private int numerocategoria;
    private String nomecategoria;
    private String descricaocategoria; 
    private String datahoracriacao;
    private String status;
                  
    public Categoria(String nomecategoria, String dataconclusao, String prioridade, String status, String descricaocategoria) {
        super(nomecategoria, dataconclusao, prioridade, status, descricaocategoria);
        this.nomecategoria = nomecategoria;
        this.descricaocategoria = descricaocategoria;
        this.status = status;
        
        this.numerocategoria = contador;
        contador++;
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
        Date date = new Date(); 
        this.datahoracriacao  = dateFormat.format(date); 
    }

    public void setNumeroCategoria(int numerocategoria) {
        this.numerocategoria = numerocategoria;
    }

    public void setNomeCategoria(String nomecategoria) {
        this.nomecategoria = nomecategoria;
    }

    public void setDescricaoCategoria(String descricaocategoria) {
        this.descricaocategoria = descricaocategoria;
    }

    public void setDatahoracriacao(String datahoracriacao) {
        this.datahoracriacao = datahoracriacao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumeroCategoria() {
        return numerocategoria;
    }

    public String getNomeCategoria() {
        return nomecategoria;
    }

    public String getDescricaoCategoria() {
        return descricaocategoria;
    }

    public String getDatahoracriacao() {
        return datahoracriacao;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String formatInformacoesEspecificas() {
        return " - " + numerocategoria;
    }
    
}
