import java.util.*;

public class DialingCodes {

    private Map<Integer, String> codes = new HashMap<>();

    public Map<Integer, String> getCodes() {
        return this.codes;
    }

    public void setDialingCode(Integer code, String country) {
        this.codes.put(code, country);
    }

    public String getCountry(Integer code) {
       return this.codes.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        if(!this.codes.containsKey(code) && !this.codes.containsValue(country)) {
            setDialingCode(code, country);
        }
    }

    public Integer findDialingCode(String country) {
        for (Map.Entry<Integer, String> codes : this.codes.entrySet()) {
            if (codes.getValue().equals(country)) {
                return codes.getKey();
            }
        }
        return null;
    }

    public void updateCountryDialingCode(Integer code, String country) {
        this.codes.remove(this.findDialingCode(country));
        this.codes.put(code, country);
    }
}
