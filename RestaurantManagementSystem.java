// Superclass Person
class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}

// Worker interface
interface Worker {
    void performDuties();
}

// Subclass Chef extending Person and implementing Worker
class Chef extends Person implements Worker {
    private String specialty;

    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is preparing " + specialty + " dishes.");
    }
}

// Subclass Waiter extending Person and implementing Worker
class Waiter extends Person implements Worker {
    private int experience;

    public Waiter(String name, int id, int experience) {
        super(name, id);
        this.experience = experience;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is serving customers with " + experience + " years of experience.");
    }
}

// Main class to demonstrate hybrid inheritance
public class RestaurantManagementSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Loveleen", 101, "Italian Cuisine");
        Waiter waiter = new Waiter("Yagyata", 202, 5);

        chef.displayInfo();
        chef.performDuties();

        System.out.println();

        waiter.displayInfo();
        waiter.performDuties();
    }
}
