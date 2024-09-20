// Desafio 3: Interface Notificacao
interface Notificacao {
    void enviarNotificacao();
}

// Classe base Tarefa
abstract class Tarefa {
    String descricao;

    Tarefa(String descricao) {
        this.descricao = descricao;
    }

    abstract int calcularDiasRestantes();

    void exibirDetalhes() {
        System.out.println("Descrição: " + descricao);
    }
}

// Desafio 1: Classe TarefaSemPrazo
class TarefaSemPrazo extends Tarefa {
    TarefaSemPrazo(String descricao) {
        super(descricao);
    }

    @Override
    int calcularDiasRestantes() {
        return -1; // Indica que a tarefa não tem prazo definido
    }

    @Override
    void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Tipo: Sem Prazo");
    }
}

// Classe TarefaComPrazoFlexivel
class TarefaComPrazoFlexivel extends Tarefa {
    int diasRestantes;

    TarefaComPrazoFlexivel(String descricao, int diasRestantes) {
        super(descricao);
        this.diasRestantes = diasRestantes;
    }

    @Override
    int calcularDiasRestantes() {
        return diasRestantes;
    }

    @Override
    void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Tipo: Prazo Flexível");
    }
}

// Classe TarefaUrgente
class TarefaUrgente extends Tarefa implements Notificacao {
    TarefaUrgente(String descricao) {
        super(descricao);
    }

    @Override
    int calcularDiasRestantes() {
        return 1; // Exemplo: sempre retorna 1 dia restante
    }

    @Override
    void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Tipo: Urgente");
    }

    @Override
    public void enviarNotificacao() {
        System.out.println("Notificação: Tarefa urgente - " + descricao);
    }
}

// Desafio 4: Classe TarefaComAlerta
class TarefaComAlerta extends Tarefa implements Notificacao {
    TarefaComAlerta(String descricao) {
        super(descricao);
        enviarNotificacao();
    }

    @Override
    int calcularDiasRestantes() {
        return 5; // Exemplo: retorna 5 dias restantes
    }

    @Override
    void exibirDetalhes() {
        super.exibirDetalhes();
        System.out.println("Tipo: Com Alerta");
    }

    @Override
    public void enviarNotificacao() {
        System.out.println("Alerta: Nova tarefa criada - " + descricao);
    }
}

// Classe principal para testar o código
public class Main {
    public static void main(String[] args) {
        Tarefa tarefa1 = new TarefaSemPrazo("Estudar Java");
        Tarefa tarefa2 = new TarefaUrgente("Entregar projeto");
        Tarefa tarefa3 = new TarefaComPrazoFlexivel("Ler livro", 10);
        Tarefa tarefa4 = new TarefaComAlerta("Reunião com cliente");

        Tarefa[] tarefas = {tarefa1, tarefa2, tarefa3, tarefa4};

        for (Tarefa tarefa : tarefas) {
            tarefa.exibirDetalhes();
            System.out.println("Dias restantes: " + tarefa.calcularDiasRestantes());
            System.out.println();
        }
    }
}
