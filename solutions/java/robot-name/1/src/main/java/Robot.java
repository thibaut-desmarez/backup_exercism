import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class Robot {

    String name;
    static Set<String> names = new HashSet<>();

    Robot(){
        String firstLetter =  String.valueOf( (char) (Math.floor(Math.random()*26)+65));
        String secondLetter =  String.valueOf( (char) (Math.floor(Math.random()*26)+65));
        int number = (int)(Math.random()*999);
        this.name = firstLetter+secondLetter+number;
        if(!names.add(name)){
            firstLetter =  String.valueOf( (char) (Math.floor(Math.random()*26)+65));
            secondLetter =  String.valueOf( (char) (Math.floor(Math.random()*26)+65));
            number = (int)(Math.random()*999);
            this.name = firstLetter+secondLetter+number;
        }
    }
    String getName() {
        return this.name;
    }

    void reset() {
        String firstLetter =  String.valueOf( (char) (Math.round(Math.random()*26)+65));
        String secondLetter =  String.valueOf( (char) (Math.round(Math.random()*26)+65));
        int number = (int)(Math.random()*999);
        this.name = firstLetter+secondLetter+number;
    }
}