import java.lang.reflect.Field;

public class JsonSerializer {
    public static String toJson(Object obj) {

        StringBuilder json = new StringBuilder();
        json.append("{");
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        boolean first = true;

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);
                String jsonName = annotation.name();
                try {
                    Object value = field.get(obj);
                    if (!first) {
                        json.append(", ");
                    }
                    json.append("\"").append(jsonName).append("\": ");
                    json.append(String.valueOf(value));
                    first = false;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        json.append("}");
        return json.toString();
    }
} 