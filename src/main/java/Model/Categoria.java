package Model;

import State.CategoriaAtivaState;
import State.CategoriaInativaState;
import State.CategoriaState;
import interfaces.AtividadeFactory;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Categoria {
    
    private static int contador = 1;
    private int numerocategoria;
    private String nomecategoria;
    private String descricaocategoria; 
    private String datahoracriacao;
    private CategoriaState status;

    public Categoria(String nomecategoria, String descricaocategoria, String status) {
        this.nomecategoria = nomecategoria;
        this.descricaocategoria = descricaocategoria;
        this.status = new CategoriaAtivaState();
        
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

    public void setStatus(CategoriaState status) {
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

    public CategoriaState getStatus() {
        return status;
    }
    
//    public void ativar() {
//        // Altera para o estado Ativo
//        setStatus(new CategoriaAtivaState());
//    }
//
//    public void desativar() {
//        // Altera para o estado Inativo
//        setStatus(new CategoriaInativaState());
//    }

    public void realizarOperacao() {
        // Delega a operação para o estado atual
        status.executarComportamento(this);
    }

    @Override
    public String toString() {
        return numerocategoria + " - " + nomecategoria + " - " + descricaocategoria;
    }
}
