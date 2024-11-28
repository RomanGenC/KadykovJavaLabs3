import java.util.HashMap;
import java.util.Map;

class GameEnemy {
    private String enemyType;
    private int healthPoints;

    public GameEnemy(String enemyType, int healthPoints) {
        this.enemyType = enemyType;
        this.healthPoints = healthPoints;
    }

    public void setPosition(int x, int y) {
        System.out.println(enemyType + " со здоровьем " + healthPoints + " появился (" + x + ", " + y + ")");
    }
}

class EnemyPool {
    private static final Map<String, GameEnemy> enemyPool = new HashMap<>();

    public static GameEnemy getEnemy(String enemyType) {
        GameEnemy enemy = enemyPool.get(enemyType);

        if (enemy == null) {
            int defaultHealth = switch (enemyType.toLowerCase()) {
                case "зомби" -> 100;
                case "скелет" -> 80;
                default -> 50;
            };
            enemy = new GameEnemy(enemyType, defaultHealth);
            enemyPool.put(enemyType, enemy);
            System.out.println("Создан новый враг: " + enemyType);
        }

        return enemy;
    }
}

public class Lab6Task5 {
    public static void main(String[] args) {
        GameEnemy zombie1 = EnemyPool.getEnemy("зомби");
        zombie1.setPosition(10, 20);

        GameEnemy zombie2 = EnemyPool.getEnemy("зомби");
        zombie2.setPosition(30, 40);

        GameEnemy skeleton1 = EnemyPool.getEnemy("скелет");
        skeleton1.setPosition(50, 60);

        GameEnemy skeleton2 = EnemyPool.getEnemy("скелет");
        skeleton2.setPosition(70, 80);
    }
}
