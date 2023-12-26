package DAO;

import Observador.Observador;
import interfaces.ObservadorInterface;
import java.util.ArrayList;
import java.util.List;

public class ObservadorDAO implements ObservadorInterface{
     private static List<Observador>observadores;

     public ObservadorDAO(){
        if(observadores == null)
           observadores = new ArrayList<>();
    }
     
    @Override
    public void gravar(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public List<Observador> buscaTodosObservadores() {
        return observadores;
    }
}
