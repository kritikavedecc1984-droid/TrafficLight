package TrafficLight;

// Класс обычного светофора для автомобилей
public class TrafficLight extends AbstractTrafficLight {

    public TrafficLight() {
        super("RED", 30);
        System.out.println("Создан новый автомобильный светофор. Цвет по умолчанию: " + currentColor);
    }

    public TrafficLight(String initialColor, int initialTimer) {
        super(initialColor, initialTimer);
        System.out.println("Создан новый автомобильный светофор. Цвет: " + currentColor + ", таймер: " + timer + " сек.");
    }

    @Override
    protected void autoChangeColor() {
        switch (currentColor) {
            case "RED":
                changeColor("GREEN", 45);
                break;
            case "GREEN":
                changeColor("YELLOW", 5);
                break;
            case "YELLOW":
                changeColor("RED", 30);
                break;
        }
        System.out.println("Автоматическая смена цвета автомобильного светофора!");
    }
}