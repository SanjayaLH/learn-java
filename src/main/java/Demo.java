import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        demoOne();
    }
    public static void demoOne() throws NoSuchFieldException, IllegalAccessException {
        List<String> names = new ArrayList<>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("b");
        names.add("d");
        names.add("e");
        names.add("f");
        names.add("g");
        names.add("h");
        names.add("i");
        names.add("l");
        System.out.println(names.size());
        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData = (Object[]) field.get(names);
        int capacity = elementData.length;

        System.out.println("Current capacity of the ArrayList: " + capacity);
        System.out.println(names.get(2));
    }
}
