import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class KindergartenGarden {

    String garden;
    HashMap<String, Integer> studentNumber = new HashMap<>();

    KindergartenGarden(String garden) {
        this.garden = garden;
        this.studentNumber.put("Alice",0);
        this.studentNumber.put("Bob",1);
        this.studentNumber.put("Charlie",2);
        this.studentNumber.put("David",3);
        this.studentNumber.put("Eve",4);
        this.studentNumber.put("Fred",5);
        this.studentNumber.put("Ginny",6);
        this.studentNumber.put("Harriet",7);
        this.studentNumber.put("Ileana",8);
        this.studentNumber.put("Joseph",9);
        this.studentNumber.put("Kincaid",10);
        this.studentNumber.put("Larry",11);

    }

    List<Plant> getPlantsOfStudent(String student) {
        String[] split = this.garden.split("\n");
        String firstRow =  split[0];
        String secondRow =  split[1];
        List<Plant> plants = new ArrayList<>();
        plants.add(Plant.getPlant(firstRow.charAt(this.studentNumber.get(student)*2)));
        plants.add(Plant.getPlant(firstRow.charAt(this.studentNumber.get(student)*2+1)));
        plants.add(Plant.getPlant(secondRow.charAt(this.studentNumber.get(student)*2)));
        plants.add(Plant.getPlant(secondRow.charAt(this.studentNumber.get(student)*2+1)));
        return  plants;
    }

}
