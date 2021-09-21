package Lesson1;

public class Teamcat extends Team implements CanCourse{
    public static int catCount;
    public int appetiteFull;

    public Teamcat(String name, String color, int age, int maxSwimDistance, int maxRunDistance, int maxJumpHeight, int appetite) {
        super(name, color, age, maxSwimDistance, maxRunDistance, maxJumpHeight, appetite);
        this.bellyful = false;
        catCount++;
    }

    @Override
    public String toString() {
        return "Kitty " + getName() +
                " is ready to swim " + maxSwimDistance +
                " feet and ready to run " + maxRunDistance +
                " feet. Don't forget to feed " + getName() + " after the race!";
    }

    @Override
    public void eat(Bowl bowl) {
        if (bowl.decreaseFood(appetite)) {
            bellyful = true;
            System.out.println(getName() + " ate from the bowl. It is " + bellyful + " that " + getName() + " is bellyful now.");
        } else System.out.println("There is not enough food in the bowl");
    }

    @Override
    public void swim(int swimDistance) {
        if (maxSwimDistance == 0) {
            System.out.println(getName() + " can't swim!");
            return;
        }
        if (swimDistance == maxSwimDistance) {
            System.out.println(getName() + " successfully swam the distance");
        } else if (swimDistance >= maxSwimDistance) {
            System.out.println(getName() + " swam only " + maxSwimDistance);
        } else {
            System.out.println(getName() + " can swim more");
        }
    }

    @Override
    public void run(int runDistance) {
        if (runDistance == maxRunDistance) {
            System.out.println(getName() + " successfully ran the distance");
        } else if (runDistance >= maxRunDistance) {
            System.out.println(getName() + " ran only " + maxRunDistance);
        } else
            System.out.println(getName() + " can run more!!");
    }

    @Override
    public double jump(int height) {
        if (maxJumpHeight >= height) {
            System.out.println("Cat " + getName() + " overcame barrier!");
            return height / maxJumpHeight;
        } else {
            System.out.println("Cat " + getName() + " was not able to overcome barrier...");
            return height / maxJumpHeight;
        }
    }

    public void displayId() {
        System.out.println("Total number of cats " + catCount);
    }
}
