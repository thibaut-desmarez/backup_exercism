import java.util.ArrayList;
import java.util.List;

class Series {

    String series;
    Series(String string) {
        if(string == null || string.isBlank()){
            throw new IllegalArgumentException("series cannot be empty");
        }
        this.series = string;
    }

    List<String> slices(int num) {
        if(num > series.length()) {
            throw new IllegalArgumentException("slice length cannot be greater than series length");
        }
        if(num <= 0) {
            throw new IllegalArgumentException("slice length cannot be negative or zero");
        }
        List<String> slices = new ArrayList<>();
        int start = 0;
        while(start+num <= series.length()) {
            slices.add(series.substring(start, start + num));
            start++;
        }
        return slices;
    }
}
