import java.util.Arrays;

class SqueakyClean {
    static String clean(String identifier) {
        String result = "";
        StringBuilder tmp = new StringBuilder();
        result = identifier.replaceAll(" ","_");

        String[] kebabSeparated = result.split("-");
        tmp.append(kebabSeparated[0]);
        for(int i = 1; i < kebabSeparated.length; i++) {
            tmp.append(kebabSeparated[i].substring(0, 1).toUpperCase()).append(kebabSeparated[i].substring(1));
        }
        result = tmp.toString();

        result = result.replaceAll("4","a")
                .replaceAll("3","e")
                .replaceAll("0","o")
                .replaceAll("1","l")
                .replaceAll("7","t")
                .replaceAll("[^a-zA-Z_]","");

        return result;
    }
}
