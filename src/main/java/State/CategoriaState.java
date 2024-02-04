package State;

import Model.Categoria;

public abstract class CategoriaState {
    Categoria categoria;
    
    CategoriaState(Categoria categoria) {
        this.categoria = categoria;
    }

    public abstract String ativa();
    public abstract String inativa();
    
}
