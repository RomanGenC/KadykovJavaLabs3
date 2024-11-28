import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

class SaveManager {
    private static SaveManager instance;
    private final Map<String, Object> gameData;

    private SaveManager() {
        gameData = new HashMap<>();
    }

    public static SaveManager getInstance() {
        if (instance == null) {
            instance = new SaveManager();
        }
        return instance;
    }

    public void saveGame(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            gameData.put("ВремяСохранения", LocalDateTime.now().toString());
            oos.writeObject(gameData);
            System.out.println("Прогресс игры сохранен в " + filename);
        } catch (IOException e) {
            System.err.println("Ошибка сохранения игры: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadGame(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Map<String, Object> loadedData = (Map<String, Object>) ois.readObject();
            gameData.clear();
            gameData.putAll(loadedData);
            System.out.println("Прогресс игры загружен из " + filename);
            System.out.println("Время последнего сохранения: " + gameData.get("ВремяСохранения"));
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при загрузке игры: " + e.getMessage());
        }
    }

    public Map<String, Object> getGameData() {
        return gameData;
    }

    public void updateGameData(String key, Object value) {
        gameData.put(key, value);
    }
}

public class Lab6Task1 {
    public static void main(String[] args) {
        SaveManager saveManager = SaveManager.getInstance();

        saveManager.updateGameData("здоровье", 100);
        saveManager.updateGameData("позиция", "x=10, y=20");
        saveManager.updateGameData("монеты", 250);

        saveManager.saveGame("gameProgress.dat");

        SaveManager loadedManager = SaveManager.getInstance();
        loadedManager.loadGame("gameProgress.dat");

        System.out.println("Загруженные данные: " + loadedManager.getGameData());
    }
}

