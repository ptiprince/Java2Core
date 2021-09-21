package Lesson1;

public class Teamdog extends Team implements CanCourse{
    public static int dogCount;
    private int tailLength;
    protected int appetite;
    protected boolean bellyful;

    public Teamdog(String name, String color, int age, int maxSwimDistance, int maxRunDistance, int maxJumpHeight, int tailLength, int appetite) {
        super(name, color, age, maxSwimDistance, maxRunDistance, maxJumpHeight, appetite);
        this.tailLength = tailLength;
        this.bellyful = false;
        dogCount++;
    }

    @Override
    public String toString() {
        return "Doggy " + getName() +
                " is wagging his tail. He is ready to swim " + maxSwimDistance +
                " feet and ready to run " + maxRunDistance +
                " feet. Don't forget to feed " + getName() + " after the race!";
    }

    @Override
    public void swim(int swimDistance) {
        if (maxSwimDistance == 0) {
            System.out.println(getName() + " can't swim!");
            return;
        }
        if (swimDistance == maxSwimDistance) {
            System.out.println(getName() + " successfully swam the distance");
        } else if  (swimDistance >= maxSwimDistance) {
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
            System.out.println("Dog " + getName() + " overcame barrier!");
            return height / maxJumpHeight;
        } else {
            System.out.println("Dog " + getName() + " was not able to overcome barrier...");
            return height / maxJumpHeight;
        }
    }
    @Override
    public void eat(Bowl bowl) {
        bowl.decreaseFood(appetite);
        bellyful = true;
        System.out.println(getName() + " ate from the bowl. It is " + bellyful + " that " + getName() + " is bellyful now.");
    }
    public void displayId(){
        System.out.println("Total number of dogs " + dogCount);
    }
}
