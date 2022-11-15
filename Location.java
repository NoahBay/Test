import java.util.*;

abstract class Location {
    //Abstract class which inherits all the other locations
    //Writing a Scanner here, which can be used in all the other subclasses
    Scanner input = new Scanner(System.in);
    Scanner enterKey = new Scanner(System.in);
    StopWatch stopWatch = new StopWatch();
    GameSession gameSession = new GameSession();
    public LinkedHashMap<String, String> questionAndAnswers = new LinkedHashMap<>();
    public ArrayList<String> questionsReceived = new ArrayList<>();
    public long timePassed;

    public double points;

    //To get the location name
    public abstract String getLocationName();
    //Calling the information for the player to read
    public abstract String getLocationInformation();

    //Collecting all the methods one place, so it's easier to be called in the "Game" class
    public void askQuestion() {
        setQuestionAndAnswers();
        System.out.println("\nDu valgte: " + getLocationName());
        System.out.println(getLocationInformation());
        getQuestionAndAnswer();
        if (gameSession.isCorrect == true) {
            timePassed = stopWatch.getElapsedTime();
        }
    }

    public void setQuestionAndAnswers() {
        questionAndAnswers.put("Skal man slukke sit ulovlige bål, når man er færdig med at bruge det?", "Ja");
        questionAndAnswers.put("Hvor mange procent af skovbrande er menneskeskabte? \n" +
                "1: 30-45%\n" +
                "2: 50-60%\n" +
                "3: 75-90%", "3");
        questionAndAnswers.put("Hvis en naturlig skovbrand starter, skal man så slukke den?", "Nej");
        questionAndAnswers.put("Hvor mange huse blev ødelagt af skovbrande i Australien i 2020\n" +
                "1: 1365\n" +
                "2: 2439\n" +
                "3: 3698", "2");
        questionAndAnswers.put("Hvor mange millioner hektar skov var der blevet brandt af i amazonas i 2020\n" +
                "1: 4.5 millioner\n" +
                "2: 5.1 millioner\n" +
                "3: 5.5 millioner", "3");
    }

    public void getQuestionAndAnswer() {
        Random random = new Random();
        int number = random.nextInt(questionAndAnswers.size());
        Set<String> keySet = questionAndAnswers.keySet();
        List<String> listKeys = new ArrayList<String>(keySet);
        String key = listKeys.get(number);
        questionsReceived.add(key);
        System.out.print("Tryk 'Enter' for at få spørgsmålet");
        String waitingForEnter = enterKey.nextLine();
        System.out.println(key);
        stopWatch.start();
        Object firstKey = questionAndAnswers.keySet().toArray()[number];
        Object valueForFirstKey = questionAndAnswers.get(firstKey);
        Scanner input = new Scanner(System.in);
        if (input.nextLine().equals(valueForFirstKey)) {
            gameSession.isCorrect = true;
            System.out.println("Korrekt!");
        } else if (!input.nextLine().equals(valueForFirstKey)) {
            System.out.println("Forkert!");
        }
    }

    public abstract String addItem(); // Adding the item from the room to the players inventory

    public long getTimePassed() {
        return timePassed;
    }
}