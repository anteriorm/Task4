import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        //1
        Printable printable = () -> System.out.println("Работает!!!");
        printable.print();

        //2
        System.out.println();
        Predicate<String> notNull = str -> str != null;

        Predicate<String> notEmpty = str -> !str.isEmpty();

        Predicate<String> notNullAndNotEmpty = notNull.and(notEmpty);

        String s1 = null;
        String s2 = "";
        String s3 = "Работает";

        System.out.println(notNullAndNotEmpty.test(s1));
        System.out.println(notNullAndNotEmpty.test(s2));
        System.out.println(notNullAndNotEmpty.test(s3));

        //3
        System.out.println();
        Predicate<String> checkString = str ->
                str != null &&
                        (str.startsWith("J") || str.startsWith("N")) &&
                        str.endsWith("A");

        String s4 = "JAVA";
        String s5 = "NINA";
        String s6 = "PANDA";

        System.out.println(checkString.test(s4));
        System.out.println(checkString.test(s5));
        System.out.println(checkString.test(s6));

        //4
        System.out.println();
        Consumer<HeavyBox> shipBox = box ->
                System.out.println("Отгрузили ящик с весом " + box.getWeight());

        Consumer<HeavyBox> sendBox = box ->
                System.out.println("Отправляем ящик с весом " + box.getWeight());

        Consumer<HeavyBox> processBox = shipBox.andThen(sendBox);

        HeavyBox box = new HeavyBox(1500);
        processBox.accept(box);

        //5
        System.out.println();

        Function<Integer, String> checkNumber = n -> {
            if (n > 0) return "Положительное число";
            else if (n < 0) return "Отрицательное число";
            else return "Ноль";
        };

        System.out.println(checkNumber.apply(10));
        System.out.println(checkNumber.apply(-5));
        System.out.println(checkNumber.apply(0));

        //6
        System.out.println();

        Supplier<Integer> randomSupplier = () -> new Random().nextInt(11);

        System.out.println(randomSupplier.get());
        System.out.println(randomSupplier.get());
        System.out.println(randomSupplier.get());

        //2.1
        System.out.println();

        DeprecatedExProcessor.process(OldClass.class);

        //2.2
        System.out.println();

        Person person = new Person("Иван", 25, "12345");
        String json = JsonSerializer.toJson(person);
        System.out.println(json);
    }
}