import java.util.LinkedList;
import java.util.Queue;

interface Command {
    void execute();
}

class StartRitual implements Command {
    @Override
    public void execute() {
        System.out.println("Ритуал начался. Подготовка территории...");
    }
}

class SummonMonster implements Command {
    private String monsterName;

    public SummonMonster(String monsterName) {
        this.monsterName = monsterName;
    }

    @Override
    public void execute() {
        System.out.println("Вызов монстра: " + monsterName);
    }
}

class FinishRitual implements Command {
    @Override
    public void execute() {
        System.out.println("Ритуал завершен. Энергия рассеивается.");
    }
}

class RitualExecutor {
    private Queue<Command> commandQueue = new LinkedList<>();

    public void addCommand(Command command) {
        commandQueue.add(command);
    }

    public void executeCommands() {
        while (!commandQueue.isEmpty()) {
            Command command = commandQueue.poll();
            command.execute();
        }
    }
}

public class Lab6Task4 {
    public static void main(String[] args) {
        RitualExecutor executor = new RitualExecutor();

        Command startRitual = new StartRitual();
        Command summonDragon = new SummonMonster("Дракон");
        Command summonGoblin = new SummonMonster("Гоблин");
        Command finishRitual = new FinishRitual();

        executor.addCommand(startRitual);
        executor.addCommand(summonDragon);
        executor.addCommand(summonGoblin);
        executor.addCommand(finishRitual);

        executor.executeCommands();
    }
}
