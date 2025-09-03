class ResistorColorDuo {
    int value(String[] colors) {
        return colorCode(colors[0])*10 + colorCode(colors[1]);
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
