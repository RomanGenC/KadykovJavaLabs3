import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

// Model: Task
class Task {
    private final String title;
    private final int duration;
    private int timeSpent;

    public Task(String title, int duration) {
        this.title = title;
        this.duration = duration;
        this.timeSpent = 0;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public int getTimeSpent() {
        return timeSpent;
    }

    public void addTime(int minutes) {
        if (timeSpent + minutes <= duration) {
            timeSpent += minutes;
        } else {
            timeSpent = duration;
        }
    }

    public boolean isCompleted() {
        return timeSpent >= duration;
    }
}

// ViewModel: TaskViewModel
class TaskViewModel {
    private final Task task;
    private final PropertyChangeSupport support;

    public TaskViewModel(Task task) {
        this.task = task;
        this.support = new PropertyChangeSupport(this);
    }

    public String getTitle() {
        return task.getTitle();
    }

    public int getDuration() {
        return task.getDuration();
    }

    public int getTimeSpent() {
        return task.getTimeSpent();
    }

    public int getProgress() {
        return (int) ((task.getTimeSpent() / (double) task.getDuration()) * 100);
    }

    public boolean isCompleted() {
        return task.isCompleted();
    }

    public void addTime(int minutes) {
        int oldProgress = getProgress();
        task.addTime(minutes);
        support.firePropertyChange("прогресс", oldProgress, getProgress());
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}

// View: ConsoleView
class ConsoleView {
    public void displayTask(TaskViewModel viewModel) {
        System.out.println("Задача: " + viewModel.getTitle());
        System.out.println("Прогресс: " + viewModel.getProgress() + "%");
        System.out.println(viewModel.isCompleted() ? "Статес: Завершена" : "Статус: Выполняется");
        System.out.println();
    }
}

public class Lab7Task3 {
    public static void main(String[] args) {
        // Create a task
        Task task = new Task("Выполнение MVVM Assignment", 120);
        TaskViewModel viewModel = new TaskViewModel(task);
        ConsoleView view = new ConsoleView();

        viewModel.addPropertyChangeListener(event -> {
            if ("прогресс".equals(event.getPropertyName())) {
                view.displayTask(viewModel);
            }
        });

        view.displayTask(viewModel);
        viewModel.addTime(30);
        viewModel.addTime(50);
        viewModel.addTime(40);
    }
}
