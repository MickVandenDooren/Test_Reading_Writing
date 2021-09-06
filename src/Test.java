import java.io.*;
import java.nio.file.Path;
import java.nio.file.Files;

public class Test {

    public static void main(String[] args) {


        /*
        1. Maak een Path die verwijst naar de volgende relatieve paden(de ***** vervang je door jouw naam.):
        “../../From*****ToPearl/message.txt” en “../../From*****ToPearl/animal.txt”
        */

        Path pathMessage = Path.of("../../FromMickToPearl/message.txt");
        Path pathAnimal = Path.of("../../FromMickToPearl/animal.txt");

        /*
        2. Zorg ervoor dat je die folder en files aanmaakt via de Files klasse,
        en gebruik methodes die kijken of de files en folder bestaan
        */

        try {
            if (Files.isDirectory(pathMessage.getParent())) {
                System.out.println("Existing directory [../../FromMickToPearl/]");
            } else {
                Files.createDirectories(pathMessage.getParent());
                System.out.println("Directory created [../../FromMickToPearl/]");
            }

            if (Files.exists(pathMessage)) {
                System.out.println("Existing file [../../FromMickToPearl/message.txt]");
            } else {
                Files.createFile(pathMessage);
                System.out.println("File created [../../FromMickToPearl/message.txt]");
            }

            if (Files.exists(pathAnimal)) {
                System.out.println("Existing file [../../FromMickToPearl/animal.txt]");
            } else {
                Files.createFile(pathAnimal);
                System.out.println("File created [../../FromMickToPearl/animal.txt]");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        3. Schrijf een leuke persoonlijke tekst in de file ”message.txt”,
        misschien een leuke mop, of een leuk feitje. Lees het dan uit. FileReader en FileWriter!!!
        Buffered is ok.
        */

        try {
            FileWriter fileWriter = new FileWriter(String.valueOf(pathMessage));
            fileWriter.write("--------------------------------------------"+"\n");
            fileWriter.write("My dog pooped in the elevator the other day, " + "\n" + "he took that shit to a whole other level.");
            fileWriter.write("\n"+ "--------------------------------------------");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(pathMessage)))){
            String Output;
            while ((Output = reader.readLine())!=null){
                System.out.println(Output);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        5. Sla het dier op in “animal.txt”, en lees het uit.
         */

        Dog favouriteDog = new Dog("Indy", false);

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathAnimal.toString()))) {
            objectOutputStream.writeObject(favouriteDog);
            System.out.println("Dog " + favouriteDog.getName() + " has been saved in " + pathAnimal);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(pathAnimal.toString()))) {
            String stream = inputStream.readObject().toString();
            System.out.println(stream);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }


    }

}