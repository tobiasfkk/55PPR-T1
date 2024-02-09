# O sistema

O sistema é constituído pelo código refatorado do trabalho final da disciplina Programação 2, do terceiro semestre do curso de Engenharia de Software da UDESC - Universidade do Estado de Santa Catarina. Se resume em sistema de agenda onde o usuário, ao acessar o sistema, consegue fazer o gerenciamento de tarefas, a partir das tarefas nele adicionadas. É necessário manter categorias, sendo estas utilizadas para criação e manutenção das tarefas. A partir das categorias adicionadas, é possível adicionar tarefas, utilizando nelas, as categorias adicionadas anteriormente. Não é possível criar uma tarefa sem antes possuir uma categoria criada. O sistema é bem intuitivo e com mensagens de erro e advertência bem explicativas para maior facilidade e compreensão do usuário. O sistema não armazena os dados inseridos pelo usuário em um banco de dados, apenas guarda em memória local as informações durante a execução da aplicação, perdendo todos os dados inseridos após fechar a aplicação.

**Trabalho 1 da disciplina de Padrões de Projeto disponível no link:** 

    https://github.com/tobiasfkk/55PPR-T1

**Refatoração do trabalho da disciplina de Programação 2 disponível no link:**
    
    https://github.com/tobiasfkk/LembretesMVC

**Para rodar a aplicação, basta buildar a classe APP.java, caminho:**

    ...55PPR-T1\src\main\java\App\APP.java.

**Projeto Java com Java Swing.**

# Padrões implementados

    - MVC
    - Observer
    - Singleton
    - Template Method
    - Factory Method
    - Abstract Factory
    - Command
    - State
    - Visitor
    - Decorator
    - Composite

## MVC

O sistema é todo estruturado no padrão MVC, as principais classes do sistema foram separadas em pacotes Model, View e Controller. Algumas funcionalidades específicas foram desenvolvidas fora do MVC por uma questão de acessibilidade, como a inserção de imagem em uma tarefa, por exemplo, porém grande parte da estrutura do sistema segue este padrão. A utilização do MVC faz com que cada função fique bem definida, as classes bem separadas e melhora muito a manutenção e correção de erros.

## Observer

O padrão Observer foi adicionado para gerenciar uma lista de tarefas, onde, sempre que o usuário adicionar uma nova tarefa, uma janela onde estão amostradas todas as tarefas é atualizada. Esta janela é atualizada cada vez que uma tarefa é adicionada, alterada ou excluída. O observado é a classe `ControladorViewCriarTarefa.java` que estende a classe abstrata `Observado.java` e o observador é a classe `ControladorViewListaTarefa.java` que implementa a interface `Observador.java`. O padrão Observer se faz útil para atualizar imediatamente a janela que lista as tarefas `ViewListaTarefa.java`, facilitando a usabilidade para o usuário.

## Singleton

O padrão Singleton é utilizado na criação de tarefas `ControladorViewCriarTarefa.java`, durante a criação de uma nova tarefa uma instância única do Logger é adquirida e registra toda criação de tarefas em uma lista. Este padrão garante que seja criado apenas uma instância de Log e registrado todas as criações de tarefas nele. 
Este Logger fica registrado e é impresso no terminal toda vez que uma nova tarefa é adicionada.

## Template Method

O padrão Template Method é utilizado na classe `Tarefa.java` que estende a classe abstrata `Atividade.java`. Na classe abstrata `Atividade.java` são definidos alguns métodos que são utilizados na classe `Tarefa.java`. Este padrão foi implementado permitindo que, futuramente, outras classes estendam a classe abstrata `Atividade.java`, porém até o momento foi utilizado apenas para a classe `Tarefa.java`. A classe Tarefa.java utiliza alguns métodos idênticos a classe abstrata `Atividade.java` e também faz devidas alterações em outros.
Exemplo: na classe abstrata `Atividade.java`, o método `toString()` é declarado como abstrato, exigindo que as subclasses forneçam uma implementação específica desse método.
Utilizar o Template Method faz com que linhas de código sejam economizadas, considerando que é possível compartilhar uma lógica com várias partes do sistema, deixando o sistema mais fluido e leve, facilitando também a manutenção. No caso do sistema em questão, é utilizado apenas na classe `Tarefa.java`, porém futuramente poderá ser estendido para outras classes.

## Factory Method

O padrão Factory Method foi implementado nas classes `TarefaFactory.java` e `CategoriaFactory.java`, que implementam a interface `AtividadeFactory.java`. Desta forma, permite que as subclasses alterem o tipo do objeto que será criado, porém ambas implementam a interface `AtividadeFactory.java`. Desta forma serão criadas atividades, sendo elas tarefas ou categorias.
Na classe `ControladorViewCriarTarefa.java`, no método `salvar()`, é possível verificar a criação de uma atividade do tipo tarefa. Seguindo a seguinte lógica:

    AtividadeFactory tarefaFactory = new TarefaFactory();
    Tarefa tarefa = (Tarefa) tarefaFactory.createAtividade(parametros);
Desta forma será criada uma atividade do tipo tarefa, sendo um padrão muito útil para futuramente, se necessário, criar vários tipos de atividades. 
    
## Abstract Factory

O padrão Abstract Factory foi implementado para servir de suporte para exportação de relatórios em diferentes formatos. O padrão de criação fornece uma interface para criar famílias de objetos relacionados sem especificar as classes concretas, tendo diferentes formatos de relatórios. Cada formato de relatório possui suas próprias classes concretas para representar elementos específicos do relatório, como cabeçalho, corpo e rodapé. Foi definida a fábrica abstrata que é a interface `RelatorioFactory.java` que declara os métodos para criar cada parte do relatório:
    
    criarCabecalho(); 
    criarCorpo();
    criarRodape();

A partir disso é possível criar as fábricas concretas que são PDFRelatorioFactory.java e ExcelRelatorioFactory.java, ambas implementando RelatorioFactory.java sobrescrevendo cada método de forma específica. Também foram criadas interfaces Cabecalho.java, Corpo.java e Rodape.java, cada qual sendo implementada por uma classe para o formato PDF e outra para Excel. Desta forma é criada uma fábrica para cada formato de exportação, porém o solicitador não saberá que existem duas fábricas diferentes para cada formato, apenas solicitará uma exportação no formato desejado e será atendido.
A exportação de arquivos PDF e Excel fica armazenada no caminho:

    ...\src\main\java\arquivos\nome

## Command

O padrão Command foi utilizado para padronizar a abertura das janelas. Anteriormente se fazia necessário ter um comando do tipo setVisible(true) no corpo de cada View (tela). Com a implementação do padrão Command foram economizadas linhas de código, como as linhas 37, 40, 41 e 42 da classe  `ControladorViewCriarTarefa.java` por exemplo, que fazia a abertura da tela a partir do metodo exibir() da classe `ViewCriarTarefa.java` nas linhas 23, 24 e 25, que puderam ser comentadas pois a lógica já está feita na classe `SetVisibilityCommand.java` e pode ser utilizada em qualquer tela. Foi criada a interface `Command.java` possuindo apenas o comando `execute()` e a classe `SetVisibilityCommand.java` que faz a lógica de visibilidade. Com isso se faz necessário apenas instanciar a view (tela) e chamar o comando `execute()` que a janela será aberta. Desta forma é possível abrir qualquer tela do sistema, apenas com o comando `execute()`, economizando várias linhas de código que seriam necessárias no corpo de cada View.
O padrão Command foi utilizado para a abertura das telas:
Cadastro de categoria;
Visualizar categoria;
Criar tarefa;
Visualizar tarefa.
A lógica do padrão pode ser utilizada em outras telas e também para o fechamento delas, porém, no sistema em questão, foi utilizado apenas nas telas descritas acima.

## State

O padrão state foi utilizado para setar uma categoria como ativa ou inativa. Faz uso das classes `CategoriaAtiva.java` e `CategoriaInativa.java` que estendem a classe abstrata `CategoriaState.java`. A partir dessas classes se faz possível alterar o estado do objeto do tipo `Categoria.java`.

## Visitor

O padrão Visitor foi implementado para permitir a execução de operações específicas sobre instâncias da classe `Tarefa.java` sem a necessidade de modificar diretamente essa classe. A criação da interface `TarefaVisitor.java` com o método visit e a adaptação da classe `Tarefa.java` para implementar `ComponenteTarefa`, que estende `TarefaVisitor`, são passos fundamentais para habilitar a capacidade de aceitar visitors e executar operações de forma flexível.

## Decorator

O padrão Decorator é utilizado para estender o comportamento de objetos de forma flexível e modular. A classe `ValidacaoDecorator.java` atua como um decorador que adiciona funcionalidades de validação a uma tarefa existente, representada pela interface `ComponenteTarefa.java`. Ao utilizar o método `operacao()`, o decorador executa a operação original da tarefa e, em seguida, realiza uma validação específica. Se a validação for bem-sucedida, uma mensagem de sucesso é exibida; caso contrário, uma mensagem de falha é apresentada. Esse padrão permite a inclusão de novas características nas tarefas sem modificar suas classes diretamente, promovendo a extensibilidade e reusabilidade do código.

## Composite

O padrão Composite foi implementado como o gerenciamento de atividades para criar uma hierarquia de objetos que podem ser tratados de maneira uniforme. A classe Tarefa implementa a interface `ComponenteTarefa`, permitindo que objetos individuais e composições de tarefas sejam manipulados de forma consistente.
