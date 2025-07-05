@DeprecatedEx(message = "Используйте NewClass вместо этого класса")
class OldClass {
    @DeprecatedEx(message = "Используйте newMethod() вместо этого метода")
    public void oldMethod() {
        System.out.println("Старый метод");
    }

    public void newMethod() {
        System.out.println("Новый метод");
    }
}
