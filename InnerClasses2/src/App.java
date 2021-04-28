import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");

    public static void main(String[] args) {
        // Gearbox bike = new Gearbox(6);
        // bike.addGear(1, 5.3);
        // bike.addGear(2, 10.6);
        // bike.addGear(3, 15.9);
        // bike.operateClutch(true);
        // bike.changeGear(1);
        // bike.operateClutch(false);
        // System.out.println(bike.wheelSpeed(1000));
        // bike.changeGear(2);
        // System.out.println(bike.wheelSpeed(3000));
        // bike.operateClutch(true);
        // bike.changeGear(3);
        // bike.operateClutch(false);
        // System.out.println(bike.wheelSpeed(6000));

        class ClickListener implements Button.OnClickListener {
            public ClickListener() {
                System.out.println("I have been attached");
            }

            @Override
            public void onClick(String title) {
                System.out.println(title + " was clicked");
            }
        }

        // btnPrint.setOnClickListener(new ClickListener());
        
        // // THIS SYNTAX IS USED FOR USING AN ANONYMOUS CLASS
        // btnPrint.setOnClickListener(new Button.OnClickListener(){
        //    @Override
        //    public void onClick(String title){
        //        System.out.println(title+" was clicked");
        //    }
        // });
        listen(); 
    }

    private static void listen() {
        boolean quit = false;
        while (!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
            case 0:
                quit = true;
                break;
            case 1:
                btnPrint.onClick();
                break;
            }
        }
    }
}
