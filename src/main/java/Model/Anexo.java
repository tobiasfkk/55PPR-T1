package Model;

import java.io.File;

public class Anexo {
    private String nomeAnexo;
    private String extAnexo;
    private int numeroTarefa;
    private File anexo;

    private static Anexo instance;  // A instância deve ser static

    private Anexo(String nomeAnexo, String extAnexo, int numeroTarefa, File anexo) {
        this.nomeAnexo = nomeAnexo;
        this.extAnexo = extAnexo;
        this.numeroTarefa = numeroTarefa;
        this.anexo = anexo;
    }

    public static synchronized Anexo getInstance(String nomeAnexo, String extAnexo, int numeroTarefa, File anexo) {
        if (instance == null) {
            instance = new Anexo(nomeAnexo, extAnexo, numeroTarefa, anexo);
        }
        return instance;
    }

    public File getAnexo() {
        return anexo;
    }

    public void setAnexo(File anexo) {
        this.anexo = anexo;
    }

    public String getNomeAnexo() {
        return nomeAnexo;
    }

    public String getExtAnexo() {
        return extAnexo;
    }

    public int getNumeroTarefa() {
        return numeroTarefa;
    }

    public void setNomeAnexo(String nomeAnexo) {
        this.nomeAnexo = nomeAnexo;
    }

    public void setExtAnexo(String extAnexo) {
        this.extAnexo = extAnexo;
    }

    public void setNumeroTarefa(int numeroTarefa) {
        this.numeroTarefa = numeroTarefa;
    }
    
    
}
