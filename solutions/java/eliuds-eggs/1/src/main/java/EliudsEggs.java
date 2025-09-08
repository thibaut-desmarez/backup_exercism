public class EliudsEggs {
    public int eggCount(int number) {
        int[] binary = new int[35];
        int id = 0;
        String result = "";

        while (number > 0) {
            binary[id++] = number % 2;
            number = number / 2;
        }

        for (int i = id - 1; i >= 0; i--) {
            result += (binary[i] + "");
        }
        return result.replaceAll("0","").length();
    }
}
