package Lesson1;

public abstract class Team implements CanCourse{
    private static int animalsCount;
    private String name;
    private String color;
    private int age;
    protected int maxSwimDistance;
    protected int maxRunDistance;
    protected int maxJumpHeight;
    protected int appetite;
    protected boolean bellyful;


    public Team(String name, String color, int age, int maxSwimDistance, int maxRunDistance, int maxJumpHeight, int appetite) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.maxSwimDistance = maxSwimDistance;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.appetite = appetite;
        this.bellyful = false;
        animalsCount++;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static int getAnimalsCount() {
        return animalsCount;
    }

    public static void setAnimalsCount(int animalsCount) {
        Team.animalsCount = animalsCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public abstract String toString();

    public void setAge(int age) {
        if (age < 0 || age > 25){
            System.out.println("Age value is incorrect!");
        } else { this.age = age;}
    }

    public void info(){
        System.out.println(name + " is " + color + " and he is " + age + ". It is " + bellyful + " that he is bellyful.");
    }
    public abstract void swim(int swimDistance);
    public abstract void run(int runDistance);
    public abstract double jump(int height);
    public abstract void eat(Bowl bowl);
    public abstract void displayId();
}
