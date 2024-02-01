package Model;

public class Tarefa extends Atividade {
    
    private static int contador = 1;
    private int numerotarefa;
    private String anexo; 
    private Categoria categoria;
   
    public Tarefa(String titulo, String dataconclusao, String prioridade, String status, String descricao, Categoria categoria) {
        super(titulo, dataconclusao, prioridade, status, descricao);
        this.categoria = categoria;
        this.numerotarefa = contador;
        contador++; 
    }
    
    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Tarefa.contador = contador;
    }

    public int getNumerotarefa() {
        return numerotarefa;
    }

    public void setNumerotarefa(int numerotarefa) {
        this.numerotarefa = numerotarefa;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

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
    
    public String getDataconclusao() {
        return dataconclusao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    @Override
    protected String formatInformacoesEspecificas() {
        // informações específicas da Tarefa
        return " - " + datahoracriacao + " - " + prioridade + " - " + status;
    }
}