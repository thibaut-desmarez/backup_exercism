import static java.lang.Math.pow;

class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        int tmp = 0;
        String string = String.valueOf(numberToCheck);
        for(int i = string.length() - 1; i >= 0; i--) {
            tmp += (int) pow(Integer.parseInt(String.valueOf(string.charAt(i))),string.length());
        }
        return tmp == numberToCheck;
    }

}
