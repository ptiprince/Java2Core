package Lesson1;

public class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = food;
    }
    public boolean decreaseFood(int amount){
        if (amount<=food) {
            food -= amount;
            System.out.printf("Bowl [Food: %d ]\n", food);
            return true;
        } else return false;
    }
    public void info(){
        System.out.printf("Bowl [Food: %d ]\n", food);
    }
}
