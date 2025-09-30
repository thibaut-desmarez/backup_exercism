import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

class Flattener {

    List<Object> flatten(List<?> list) {
        return recursiveFlatten(list);
    }

    private static List<Object> recursiveFlatten(Object object) {
        List<Object> list = new ArrayList<>();
        if (object instanceof Iterable) {
            for (Object element : (Iterable<?>) object) {
                if(element != null){
                    list.addAll(recursiveFlatten(element));
                }
            }
        }
        else {
            list.add(object);
        }
        return list;
    }
}