package State;

import Model.Categoria;

public class CategoriaAtiva extends CategoriaState {

    CategoriaAtiva(Categoria categoria) {
        super(categoria);
        categoria.setAtivo(true);
    }
    
    @Override
    public String ativa() {
         return "Categoria já está ativa!";
    }

    @Override
    public String inativa() {
        categoria.changeState(new CategoriaInativa(categoria));
        return "Categoria inativa!";
    }
    
}
