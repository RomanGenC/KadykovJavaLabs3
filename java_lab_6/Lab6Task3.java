import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface Observer {
    void update(String stock, float price);
}

class StockSubscriber implements Observer {
    private String name;

    public StockSubscriber(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(String stock, float price) {
        System.out.println(name + " уведомлен: " + stock + " цена обновлена до " + price);
    }
}

class StockMarket {
    private final List<Observer> observers = new ArrayList<>();
    private final Map<String, Float> stocks = new HashMap<>();

    public void addStock(String stock) {
        if (!stocks.containsKey(stock)) {
            stocks.put(stock, 0.0f);
            System.out.println("Акция добавлена: " + stock);
        } else {
            System.out.println("Акция уже есть: " + stock);
        }
    }

    public void updateStock(String stock, float price) {
        if (stocks.containsKey(stock)) {
            stocks.put(stock, price);
            System.out.println("Цена на акцию " + stock + " обновлена до " + price);
            notifyObservers(stock, price);
        } else {
            System.out.println("Акция не найдена: " + stock);
        }
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
        System.out.println("Наблюдатель добавлен: " + ((StockSubscriber) observer).getName());
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("Наблюдатель удален: " + ((StockSubscriber) observer).getName());
    }

    private void notifyObservers(String stock, float price) {
        for (Observer observer : observers) {
            observer.update(stock, price);
        }
    }
}

public class Lab6Task3 {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        stockMarket.addStock("AAPL");
        stockMarket.addStock("GOOGL");
        stockMarket.addStock("AMZN");

        Observer subscriber1 = new StockSubscriber("Инвестр1");
        Observer subscriber2 = new StockSubscriber("Инвестр2");

        stockMarket.addObserver(subscriber1);
        stockMarket.addObserver(subscriber2);

        stockMarket.updateStock("AAPL", 150.25f);
        stockMarket.updateStock("GOOGL", 2800.75f);

        stockMarket.removeObserver(subscriber1);

        stockMarket.updateStock("AMZN", 3500.50f);
    }
}
