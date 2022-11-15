import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class GameSession {
    //Creating Arraylist to store objects of type Location
    public HashMap<String, Double> allScores = new HashMap<>();
    ArrayList<Location> locations = new ArrayList<>();
    ArrayList<String> information = new ArrayList<>();
    int amountOfLocations;
    //Initialising a Scanner, so we can use the players input
    Scanner playerInput = new Scanner(System.in);
    Player player;
    ScoreSystem scoreSystem = new ScoreSystem();
    StopWatch stopWatch = new StopWatch();
    String name;
    double score = 0;
    long timeSpent;
    static boolean isCorrect = false;
    static boolean itemNotInInventory = false;
    static boolean gameEnd = false;

    public void getName() {
        System.out.println("Velkommen til World of Skovbrand! Venligst indtast dit navn: ");
        name = playerInput.nextLine();
        System.out.println("Hej " + name + " klar til at spille?");
    }

    public void mainMenu() {
        System.out.println("""
                Vælg enten:\s
                1: Information\s
                2: Spørgsmål""");
        Scanner input = new Scanner(System.in);
        String response = input.nextLine();
        if (response.equals("1")) {
            getInformation();
        } else if (response.equals("2")) {
            startGame();
        } else {
            System.out.println("Tak for at du ville spille");
        }
    }

    public void getInformation() {
        //Adding information to the information arraylist.
        information.add("Information 1");
        information.add("Information 2");
        information.add("Information 3");
        information.add("Information 4");
        information.add("Information 5");
        information.add("Information 6");

        System.out.println(information.get(0));
        System.out.println(information.get(1));
        System.out.println(information.get(2));
        System.out.println(information.get(3));
        System.out.println(information.get(4));
        System.out.println(information.get(5));
        System.out.println("""
                \nFor at gå tilbage til hovedmenuen skriv:\s
                Hovedmenu""");

        Scanner input = new Scanner(System.in);
        try {
            switch (input.nextLine()) {
                case "1" -> {
                    System.out.println(information.get(0));
                    System.out.println("Tryk 'enter' for at går tilbage til information");
                    Scanner enterkey = new Scanner(System.in);
                    String waitingForEnter = enterkey.nextLine();
                    getInformation();
                }
                case "2" -> {
                    System.out.println(information.get(1));
                    System.out.println("Tryk 'enter' for at går tilbage til information");
                    Scanner enterkey = new Scanner(System.in);
                    String waitingForEnter = enterkey.nextLine();
                    getInformation();
                }
                case "3" -> {
                    System.out.println(information.get(2));
                    System.out.println("Tryk 'enter' for at går tilbage til information");
                    Scanner enterkey = new Scanner(System.in);
                    String waitingForEnter = enterkey.nextLine();
                    getInformation();
                }
                case "4" -> {
                    System.out.println(information.get(3));
                    System.out.println("Tryk 'enter' for at går tilbage til information");
                    Scanner enterkey = new Scanner(System.in);
                    String waitingForEnter = enterkey.nextLine();
                    getInformation();
                }
                case "5" -> {
                    System.out.println(information.get(4));
                    System.out.println("Tryk 'enter' for at går tilbage til information");
                    Scanner enterkey = new Scanner(System.in);
                    String waitingForEnter = enterkey.nextLine();
                    getInformation();
                }
                case "6" -> {
                    System.out.println(information.get(5));
                    System.out.println("Tryk 'enter' for at går tilbage til information");
                    Scanner enterkey = new Scanner(System.in);
                    String waitingForEnter = enterkey.nextLine();
                    getInformation();
                }
                case "Hovedmenu" -> mainMenu();
                default -> {
                    System.out.println("Type an accepted key");
                    getInformation();
                }
            }
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Type an accepted number");
            getInformation();
        }
    }

    public void startGame() {
        //Adding all the locations to the arraylist
        locations.add(new Africa());
        locations.add(new USA());
        locations.add(new Brazil());
        locations.add(new Indonesia());
        locations.add(new Australia());
        locations.add(new Portugal());
        locations.add(new Greece());

        player = new Player(name, score);
        amountOfLocations = locations.size();
        for(int i = 0; i < amountOfLocations; i++) {
            ChooseCountry();
            System.out.println("Din score er " + player.score);
            System.out.print("Dine samlede genstande: \n" + player.playerInventory + "\n");
            forestFire();
        }
        allScores.put(player.name, player.score);
        // Saving the players progress.
        try {
            PrintWriter pw = new PrintWriter(new FileWriter("/Users/noah_bay/Desktop/World_Of_Skovbrand", true));
            pw.println("The players name was " + player.name + "\n" +
                    "The score for " + player.name + " was " + player.score + "\n");
            pw.close();
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }

    // Function that prints out all the scores of all the players, in a HashMap.
    public void getAllScores() {
        System.out.println("\n" + allScores);
    }

    // Function that prints out the highest score
    public void getHighScore() {
        System.out.println("Den højeste score var: " + Collections.max(allScores.values()));
    }

    // Function that saves the players progress.
    public void saveGame() {

    }

    // Function that randomly starts a forest fire in the game.
    public void forestFire() {
        if (player.score > 0 && player.playerInventory.size() > 0) {
            Random random = new Random();
            if (random.nextInt(2) == 1) {
                System.out.print("""
                        En menneskeskabt er startet et sted i verden.\s
                        Skriv navnet på en af dine genstande som du vil bruge til at slukke skovbranden med.
                        """);
                Scanner itemInput = new Scanner(System.in);
                String chosenItem = itemInput.nextLine();
                player.playerInventory.remove(chosenItem);
                System.out.print("Den menneskeskabte skovbrand er blevet slukket.\n");
            }
        } else if (player.score > 0) {
            System.out.print("""
                    En menneskeskabt skovbrand er startet et sted i verden.\s
                    Du har ingen genstande i din inventar til at slukke skovbranden med, spillet er ovre.
                    """);
            player.score -= 500;
        }
    }

    //Separate method to ask the player what location he wants to go to
    public void ChooseCountry()
    {
        int locationNumber = 0;
        int countLocations = 0;

        System.out.println("Vælg venligt et land: ");
        for (Location l: locations)
        {
            countLocations++;
            System.out.print(countLocations + ": ");
            System.out.println(l.getLocationName());
        }

        String answer = playerInput.nextLine();
        try
        {
            switch (answer)
            {
                case "1" ->{
                    locations.get(0).askQuestion();
                }
                case "2" ->{
                    locations.get(1).askQuestion();
                }
                case "3" ->{
                    locations.get(2).askQuestion();
                }
                case "4" ->{
                    locations.get(3).askQuestion();
                }
                case "5" ->{
                    locations.get(4).askQuestion();
                }
                case "6" ->{
                    locations.get(5).askQuestion();
                }
                case "7" ->{
                    locations.get(6).askQuestion();
                }
                default -> {
                    System.out.println("Skriv venlist et nummer fra listen");
                    ChooseCountry();}
            }
            locationNumber = Integer.parseInt(answer) - 1;
            if (isCorrect){
                player.playerInventory.add(locations.get(locationNumber).addItem());
                timeSpent = locations.get(locationNumber).getTimePassed();
                player.score += scoreSystem.addPoints(timeSpent, stopWatch.getMaxTime());
                isCorrect = false;
            }
            locations.remove(locationNumber);

        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Vælg venligst et andet nummer");
            ChooseCountry();
        }
    }
}