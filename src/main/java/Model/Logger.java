package Model;

import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author joao.parro
 */
public class Logger {
    private static Logger instance;
    private List<String> logMessages;

    // Construtor privado para evitar instanciação direta
    private Logger() {
        logMessages = new ArrayList<>();
    }

    // Método para obter a instância única da classe
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Método para adicionar uma mensagem ao log
    public void log(String message) {
        String formattedMessage = "[" + java.time.LocalDateTime.now() + "] " + message;
        logMessages.add(formattedMessage);
       
    }

    // Método para obter todas as mensagens de log
    public List<String> getLogMessages() {
        return new ArrayList<>(logMessages);
    }
    
    public void exibirLogs() {
        System.out.println("### Exibindo Logs ###");
        for (String log : logMessages) {
            System.out.println(log);
        }
        System.out.println("### Fim dos Logs ###");
    }
    
}
