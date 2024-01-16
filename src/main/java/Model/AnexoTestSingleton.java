package Model;

import java.io.File;

public class AnexoTestSingleton {

    public static void main(String[] args) {
        testAnexoSingleton();
    }

    private static void testAnexoSingleton() {
        Anexo anexo1 = Anexo.getInstance("nome1", "extensao1", 123, new File("arquivo1.txt"));
        Anexo anexo2 = Anexo.getInstance("nome2", "extensao2", 456, new File("arquivo2.txt"));

        // Agora, compare os atributos individuais para garantir que são iguais.
        if (anexo1.getNomeAnexo().equals(anexo2.getNomeAnexo()) &&
            anexo1.getExtAnexo().equals(anexo2.getExtAnexo()) &&
            anexo1.getNumeroTarefa() == anexo2.getNumeroTarefa() &&
            anexo1.getAnexo().equals(anexo2.getAnexo())) {
            System.out.println(anexo1.toString() + '-' + anexo2.toString());
            System.out.println("Teste Passou: Singleton está funcionando corretamente");
        } else {
            System.out.println("Teste Falhou: Singleton não está funcionando corretamente");
        }
    }
}
