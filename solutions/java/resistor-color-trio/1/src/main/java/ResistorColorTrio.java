class ResistorColorTrio {
    String label(String[] colors) {
        String result = findFirstTwoDigits(colors);
        int powerPrefixUnit = 0;
        for (int i = 0; i < colorCode(colors[2]); i++) {
            result+="0";
        }

        while(result.length()>3) {
            if(result.endsWith("000")) {
                powerPrefixUnit++;
                result = result.substring(0, result.length()-3);
            }
        }

        result+= " "+prefixUnit(powerPrefixUnit)+"ohms";
        return result;
    }

    String findFirstTwoDigits(String[] colors) {
        return String.valueOf(colorCode(colors[0])*10 + colorCode(colors[1]));
    }

    String prefixUnit(int powerPrefixCounter){
        String result = "";
        if(powerPrefixCounter == 1){
            result+="kilo";
        }
        else if(powerPrefixCounter == 2){
            result+="mega";
        }
        else if(powerPrefixCounter == 3){
            result ="giga";
        }
        else if(powerPrefixCounter == 4){
            result+="tera";
        }
        return result;
    }

    int colorCode(String color) {
        String[] colors = colors();
        for(int i = 0; i < colors.length; i++) {
            if(color.equals(colors[i])) {return i;}
        }
        return 0;
    }

    String[] colors() {
        return new String[]{"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
    }
}
