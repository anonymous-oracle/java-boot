class Movie {
    private String name;

    public Movie(String name) {
        this.name = name;
    }

    public String plot() {
        return "No plot here";
    }
}

class Jaws extends Movie {
    public Jaws() {
        super("Jaws");
    }

    public String plot() {
        return "A shark eats a lot of people";
    }
}

class IndependenceDay extends Movie {
    public IndependenceDay() {
        super("Independence Day");
    }

    public String plot() {
        return "Aliens invade planet Earth to do butt stuff on human";
    }
}

class MazeRunner extends Movie {
    public MazeRunner() {
        super("Maze Runner");
    }

    @Override
    public String plot() {
        return "Kids try and escape a maze";
    }
}

class Forgetable extends Movie {
    public Forgetable() {
        super("Forgetable");
    }

    // no plot method to emphasize the Polymorphism concept
    // if .plot() is called, then the plot method in the super class will be used
}

public class App {
    public static void main(String[] args) throws Exception {
        for (int i = 0; i <= 15; i++) {
            System.out.println(randoMovie().plot());
        }
    }

    public static Movie randoMovie() {
        int randomNumber = (int) (Math.random() * 4) + 1;
        System.out.println("Random number generated is: " + randomNumber);
        switch (randomNumber) {
        case 1:
            return new Jaws();
        case 2:
            return new IndependenceDay();
        case 3:
            return new MazeRunner();
        case 4:
            return new Forgetable();

        }
        return null;
    }
}
