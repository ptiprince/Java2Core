package Lesson1;

public class Course {
    private int height;

    public Course(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public void overcomeCourse(CanCourse jumper){
        jumper.jump(height);
    }
}

