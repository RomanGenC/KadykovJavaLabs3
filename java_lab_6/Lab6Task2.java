interface Enemy {
    void attack();
}

class Zombie implements Enemy {
    @Override
    public void attack() {
        System.out.println("Зомби атакует медленно, но верно!");
    }
}

class Skeleton implements Enemy {
    @Override
    public void attack() {
        System.out.println("Скелеты атакуют на дальние дистанции засчет лука!");
    }
}

class EnemyFactory {
    public Enemy createEnemy(String type) {
        if (type.equalsIgnoreCase("зомби")) {
            return new Zombie();
        } else if (type.equalsIgnoreCase("скелет")) {
            return new Skeleton();
        }
        throw new IllegalArgumentException("Неизвестный враг: " + type);
    }
}

public class Lab6Task2 {
    public static void main(String[] args) {
        EnemyFactory factory = new EnemyFactory();

        Enemy zombie = factory.createEnemy("зомби");
        zombie.attack();

        Enemy skeleton = factory.createEnemy("скелет");
        skeleton.attack();

        try {
            Enemy unknown = factory.createEnemy("вампир");
            unknown.attack();
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
