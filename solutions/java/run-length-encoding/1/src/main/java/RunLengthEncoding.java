class RunLengthEncoding {

    String encode(String data) {
        StringBuilder result = new StringBuilder();
        if(data.length() < 1) {return "";}
        char lastChar = data.charAt(0);
        int counter = 0;
        for(int c = 0; c < data.length(); c++) {
            if(data.charAt(c) == lastChar) {
                counter++;
            }
            else {
                if (counter > 1) {
                    result.append(counter).append(lastChar);
                } else {
                    result.append(lastChar);
                }
                lastChar = data.charAt(c);
                counter = 1;
            }
        }
        if (counter > 1) {
            result.append(counter).append(lastChar);
        } else {
            result.append(lastChar);
        }
        return result.toString();
    }

    String decode(String data) {
        StringBuilder result = new StringBuilder();
        int duplicate = 1;
        for(int c = 0; c < data.length(); c++) {
            if(Character.isDigit(data.charAt(c))) {
                if(Character.isDigit(data.charAt(c+1))){
                    duplicate= Integer.parseInt(data.substring(c,c+2));
                    c++;
                }
                else{
                    duplicate= Integer.parseInt(String.valueOf(data.charAt(c)));
                }
            }
            else{
                for(int i = 0; i < duplicate; i++){
                    result.append(data.charAt(c));
                }
                duplicate=1;
            }
        }
        return result.toString();
    }
}