public class Hamming {

    String leftStrand;
    String rightStrand;
    public Hamming(String leftStrand, String rightStrand) {
        if(leftStrand== null || rightStrand== null || leftStrand.length() != rightStrand.length()){
            throw new IllegalArgumentException("strands must be of equal length");
        }
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
    }

    public int getHammingDistance() {
        int hammingDistance = 0;
        for(int i = 0; i < leftStrand.length(); i++){
            if(leftStrand.charAt(i) != rightStrand.charAt(i)){
                hammingDistance++;
            }
        }
        return hammingDistance;
    }
}
