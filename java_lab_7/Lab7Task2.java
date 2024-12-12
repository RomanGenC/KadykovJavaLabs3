import java.util.Scanner;

// Model (UserProfile)
class UserProfile {
    private String name;
    private String email;
    private int age;

    public UserProfile(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}

// View Interface
interface UserProfileView {
    void displayUserProfile(String userProfile);
    void showUpdateSuccess(String message);
    void showError(String message);
}

// View Implementation
class ConsoleUserProfileView implements UserProfileView {
    @Override
    public void displayUserProfile(String userProfile) {
        System.out.println("Профиль пользователя: " + userProfile);
    }

    @Override
    public void showUpdateSuccess(String message) {
        System.out.println("Успешно: " + message);
    }

    @Override
    public void showError(String message) {
        System.out.println("Ошибка: " + message);
    }
}

// Presenter
class UserProfilePresenter {
    private final UserProfile model;
    private final UserProfileView view;

    public UserProfilePresenter(UserProfile model, UserProfileView view) {
        this.model = model;
        this.view = view;
    }

    public void updateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            view.showError("Имя не может быть пустым.");
            return;
        }
        model.setName(name);
        view.showUpdateSuccess("Имя обновлено до: " + name);
    }

    public void updateEmail(String email) {
        if (email == null || !email.contains("@")) {
            view.showError("Неверный формат почты.");
            return;
        }
        model.setEmail(email);
        view.showUpdateSuccess("Email updated to: " + email);
    }

    public void updateAge(int age) {
        if (age <= 0) {
            view.showError("Возраст должен быть положительным числом.");
            return;
        }
        model.setAge(age);
        view.showUpdateSuccess("Возраст обновлен до: " + age);
    }

    public void displayUserProfile() {
        view.displayUserProfile(model.toString());
    }
}

public class Lab7Task2 {
    public static void main(String[] args) {
        UserProfile model = new UserProfile("Роман Кадыков", "roman.kadykov@example.com", 20);
        UserProfileView view = new ConsoleUserProfileView();
        UserProfilePresenter presenter = new UserProfilePresenter(model, view);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Отображение профиля");
            System.out.println("2. Обновление имени");
            System.out.println("3. Обновление почты");
            System.out.println("4. Обновление возраста");
            System.out.println("5. Выход");
            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    presenter.displayUserProfile();
                    break;
                case 2:
                    System.out.print("Введите новое имя: ");
                    String name = scanner.nextLine();
                    presenter.updateName(name);
                    break;
                case 3:
                    System.out.print("Введите новую почту: ");
                    String email = scanner.nextLine();
                    presenter.updateEmail(email);
                    break;
                case 4:
                    System.out.print("Введите новый возраст: ");
                    int age = scanner.nextInt();
                    presenter.updateAge(age);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Попробуйте снова.");
            }
        }

        scanner.close();
    }
}
