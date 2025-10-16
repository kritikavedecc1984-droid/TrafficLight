package TrafficLight;

// Абстрактный класс с общей логикой для всех светофоров
abstract class AbstractTrafficLight implements TrafficLightBase, EmergencyMode {
    protected String currentColor;
    protected int timer;

    protected AbstractTrafficLight(String initialColor, int initialTimer) {
        if (isValidColor(initialColor) && initialTimer > 0) {
            this.currentColor = initialColor.toUpperCase();
            this.timer = initialTimer;
        } else {
            this.currentColor = "RED";
            this.timer = 30;
        }
    }

    protected boolean isValidColor(String color) {
        if (color == null) return false;
        String upperColor = color.toUpperCase();
        return upperColor.equals("RED") ||  upperColor.equals("YELLOW") || upperColor.equals("GREEN");
    }

    @Override
    public void changeColor(String newColor, int newTimer) {
        if (isValidColor(newColor) && newTimer > 0) {
            this.currentColor = newColor.toUpperCase();
            this.timer = newTimer;
            System.out.println("Цвет светофора изменен на: " + currentColor);
        } else {
            System.out.println("Ошибка: неверный цвет или время. Допустимые цвета: RED, YELLOW, GREEN.");
        }
    }

    @Override
    public void printState() {
        System.out.println("Текущий цвет: " + currentColor + " | Осталось времени: " + timer + " сек.");
    }

    @Override
    public void tick() {
        if (timer > 0) {
            timer--;
            System.out.println("Таймер: " + timer + " сек.");

            if (timer == 0) {
                autoChangeColor();
            }
        }
    }

    @Override
    public void emergencyMode() {
        this.currentColor = "YELLOW";
        this.timer = 0;
        System.out.println("Включен желтый аварийный свет");
    }

    @Override
    public String getCurrentColor() {
        return currentColor;
    }

    @Override
    public int getTimer() {
        return timer;
    }

    protected abstract void autoChangeColor();
}