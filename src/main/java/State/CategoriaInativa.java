package State;

import Model.Categoria;

public class CategoriaInativa extends CategoriaState {
    
    CategoriaInativa(Categoria categoria) {
        super(categoria);
        categoria.setAtivo(false);
    }

    @Override
    public String ativa() {
        categoria.changeState(new CategoriaAtiva(categoria));
        return "Categoria ativa!";
    }

    @Override
    public String inativa() {
        return "Categoria já está Inativa!";
    }
    
}
