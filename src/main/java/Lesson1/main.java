package Lesson1;
// I created 2 teams - Teamcat and Teamdog; 2 arrays for Teamcat and Teamdog; array for course.
// Cats and dogs has to overcome swimming distance, running distance and 3 courses.
// Implemented methods: setAge and check on validity; swim, rum, jump (for courses), feeding after race,
// counting of team members, information about team members on different stages.
public class main {
    public static void main(String[] args0) {
        Course[] courses ={ new Course(2), new Course(5), new Course(7)};
        Teamcat[] teamcats = new Teamcat[5];
        Teamcat teamcat1 = new Teamcat("Barsik", "White", 5, 0, 130, 2, 5);
        Teamcat teamcat2 = new Teamcat("Versace", "White", 6, 2, 200, 1, 5);
        Teamcat teamcat3 = new Teamcat("Simba", "Red", 3, 100, 600, 10, 50);
        Teamcat teamcat4 = new Teamcat("Nala", "Red", 3, 80, 580, 7, 45);
        Teamcat teamcat5 = new Teamcat("Mufasa", "Red", 7, 90, 350, 12,55);
        teamcats[0] = teamcat1;
        teamcats[1] = teamcat2;
        teamcats[2] = teamcat3;
        teamcats[3] = teamcat4;
        teamcats[4] = teamcat5;

        Teamdog[] teamdogs = new Teamdog[4];
        Teamdog teamdog1 = new Teamdog("Bobik", "Black", 2, 55, 200, 2, 3, 10);
        Teamdog teamdog2 = new Teamdog("Keiko", "Red", 3, 100, 600, 3, 2, 15);
        Teamdog teamdog3 = new Teamdog("Sky", "Black", 6, 110, 300, 6, 5, 20);
        Teamdog teamdog4 = new Teamdog("Snoopy", "Grey", 7, 30, 50, 3, 4,15);
        teamdogs[0] = teamdog1;
        teamdogs[1] = teamdog2;
        teamdogs[2] = teamdog3;
        teamdogs[3] = teamdog4;

        teamcat1.setAge(-1);
        System.out.println();
        for (Teamcat teamcat : teamcats){
            System.out.println(teamcat);
        }
        System.out.println();

        // for (int i = 0; i < teamcats.length; i++)
        double catTime=0;
        for (Teamcat teamcat : teamcats){
            teamcat.info();
            teamcat.swim(100);
            teamcat.run(500);
            for (Course course : courses) {
                catTime = catTime + teamcat.jump(course.getHeight());
            }
            System.out.println(teamcat.getName() + " course result is " + catTime);
                    System.out.println();
        }
        teamcats[4].displayId();
        System.out.println();

        for (int i = 0; i < teamdogs.length; i++) {
            System.out.println(teamdogs[i]);
        }
        System.out.println();
        double dogTime = 0;
        for (Teamdog teamdog : teamdogs){
            teamdog.info();
            teamdog.swim(100);
            teamdog.run(500);
            for (Course course : courses) {
                dogTime = dogTime + teamdog.jump(course.getHeight());
            }
            System.out.println(teamdog.getName() + "'s course result is"  + dogTime);
                    System.out.println();
        }
        teamdog2.displayId();
        System.out.println();
        Bowl bowl = new Bowl(100);
        bowl.info();
        System.out.println();
        for (int i = 0; i < teamcats.length; i++) {
            teamcats[i].eat(bowl);
        }
        System.out.println();
    }
}


