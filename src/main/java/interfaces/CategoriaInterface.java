package interfaces;

import Model.Categoria;
import State.CategoriaState;
import java.util.Date;
import java.util.List;
import java.util.Set;

 public interface CategoriaInterface{
    
    public void gravar(Categoria categoria);
    public void remover(Categoria categoria);
    public Categoria buscar(int numeroCategoria);
    public Set<Categoria> buscarTodosCategorias();
    public void editar(int numerocategoria, String nomecategoria, String descricaocategoria, CategoriaState status);
}
