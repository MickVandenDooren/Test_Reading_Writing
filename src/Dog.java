import java.io.Serializable;

public class Dog implements Serializable {

        /*
        4.Maak dan een aparte nieuwe klasse van je lievelingsdier,
        geef die als variabele String name, en boolean edible. Maak een instantie van die klasse.
        */

        private String name;
        private boolean edible;

        public Dog(String name, boolean edible){
            this.name=name;
            this.edible=edible;
        }

        public String getName() {
        return name;
    }

        public void setName(String name) {
        this.name = name;
        }

        public boolean isEdible() {
        return edible;
    }

        public void setEdible(boolean edible) {
        this.edible = edible;
    }

        @Override
        public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", edible=" + edible +
                '}';
    }
}
