package ch.hslu.oop.sw09;

/**
 *
 * @author boasm
 */
public class mainClass {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        /*
        final String nachname = "Meier";
        final String vorname = "Boas";
        Person person = new Person(1, nachname, vorname);
        Person person2 = new Person(1, nachname, vorname);
        var output = person.hashCode();
        var output2 = person2.hashCode();
        System.out.println(output);
        System.out.println(output2);

        //Naturally sortet collection
        Person nameArray[] = {
            new Person(1,"Heller", "Tobias"),
            new Person(1,"Wenk", "Silvan"),
            new Person(1,"Köppel", "Romeo"),
            new Person(1,"Meier", "Boas")
        };
        List<Person> students = Arrays.asList(nameArray);
        Collections.sort(students);
        System.out.println(students);


        //Sortet collection with comparator
        final PersonNameComparator comparator = new PersonNameComparator();

        final List<Person> students = new ArrayList<>();
        students.add(new Person(1,"Heller", "Tobias"));
        students.add(new Person(1,"Wenk", "Silvan"));
        students.add(new Person(1,"Köppel", "Romeo"));
        students.add(new Person(1,"Meier", "Boas"));

        Collections.sort(students, comparator);

        System.out.println(students);

        //SW08 Collection avergae
        final TemperaturVerlauf verlauf = new TemperaturVerlauf();
        final Set<Temperatur> history = new HashSet<>();
        System.out.println(verlauf.getAverage(history));

        Nitrogen nitrogen = new Nitrogen(0);
        nitrogen.calcAggregatsState();
        System.out.println(nitrogen.getAggregatsStateSwitch());

        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Bitte Temperatur eingeben ('exit' zum Beenden): ");
            input = scanner.next();
            if(input.matches("-?\\d+")){
               System.out.println(input);
            } else {
                System.out.println("Invalid input");
            }
            //float value = Float.valueOf(input);
        } while (!input.equals("exit"));
        System.out.println("Programm beendet.");
         */
        //ScannerTmperatur.setTempCWithScanner();
        ScannerTmperatur.setTempCWithScanner();

    }
}
