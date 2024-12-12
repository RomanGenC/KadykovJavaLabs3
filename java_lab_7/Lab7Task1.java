import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Weapon {
    private String name;
    private int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return name + " (Урон: " + damage + ")";
    }
}

// Model (WeaponStore)
class WeaponStore {
    private final List<Weapon> weapons = new ArrayList<>();

    public List<Weapon> getWeapons() {
        return new ArrayList<>(weapons);
    }

    public void addWeapon(Weapon weapon) {
        weapons.add(weapon);
    }

    public void removeWeapon(Weapon weapon) {
        weapons.remove(weapon);
    }
}

// View
class WeaponStoreView {
    public void displayWeapons(List<Weapon> weapons) {
        System.out.println("Достуное оружие:");
        if (weapons.isEmpty()) {
            System.out.println("Нет доступного оружия.");
        } else {
            for (int i = 0; i < weapons.size(); i++) {
                System.out.println((i + 1) + ". " + weapons.get(i));
            }
        }
        System.out.println();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}

// Controller
class WeaponStoreController {
    private final WeaponStore model;
    private final WeaponStoreView view;

    public WeaponStoreController(WeaponStore model, WeaponStoreView view) {
        this.model = model;
        this.view = view;
    }

    public void addWeapon(String name, int damage) {
        Weapon weapon = new Weapon(name, damage);
        model.addWeapon(weapon);
        view.displayMessage("Оружие добавлено: " + weapon);
    }

    public void removeWeapon(int index) {
        List<Weapon> weapons = model.getWeapons();
        if (index >= 0 && index < weapons.size()) {
            Weapon removedWeapon = weapons.get(index);
            model.removeWeapon(removedWeapon);
            view.displayMessage("Оружие удалено: " + removedWeapon);
        } else {
            view.displayMessage("Недопустимый индекс оружия.");
        }
    }

    public void displayWeapons() {
        view.displayWeapons(model.getWeapons());
    }
}

// Main Class
public class Lab7Task1 {
    public static void main(String[] args) {
        WeaponStore model = new WeaponStore();
        WeaponStoreView view = new WeaponStoreView();
        WeaponStoreController controller = new WeaponStoreController(model, view);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Добавить оружие");
            System.out.println("2. Удалить оружие");
            System.out.println("3. Отобразить оружие");
            System.out.println("4. Выйти");
            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите название оружия: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите урон оружия: ");
                    int damage = scanner.nextInt();
                    controller.addWeapon(name, damage);
                    break;
                case 2:
                    controller.displayWeapons();
                    System.out.print("Введите индекс оружия для удаления: ");
                    int index = scanner.nextInt() - 1;
                    controller.removeWeapon(index);
                    break;
                case 3:
                    controller.displayWeapons();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Недоппустимая опция. Попробуйте снова.");
            }
        }

        scanner.close();
    }
}
