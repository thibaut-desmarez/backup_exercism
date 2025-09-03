class ReverseString {
    String reverse(String inputString) {
        StringBuilder result = new StringBuilder();
        if(inputString != null && !inputString.isBlank()){
            for (int i = inputString.length()-1; i >= 0; i--) {
                result.append(inputString.charAt(i));
            }
        }
        return result.toString();
    }
}
