package Model;

public class Status implements Comparable<Status>{
    private int id;
    private String nome;

    public Status(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    

    @Override
    public int compareTo(Status conta) {
        if(this.id<conta.getId()){
            return -1;
        }else{
            return 1;
        }
    }

    @Override
    public String toString() {
        return nome;
    }

    

}
