package TrafficLight;

public class TrafficLight {


    // Приватные поля - инкапсуляция
    private String currentColor;
    private int timer;

    //Конструктор по умолчанию
    public TrafficLight() {
        this.currentColor = "RED";
        this.timer = 30;
        System.out.println("Создан новый светофор. Цвет по умолчанию: " + currentColor);
    }


    // Конструктор с параметрами
    public TrafficLight(String initialColor, int initialTimer) {
        // Валидация входных данных
        if (isValidColor(initialColor) && initialTimer > 0) {
            this.currentColor = initialColor.toUpperCase();
            this.timer = initialTimer;
        } else {
            this.currentColor = "RED";
            this.timer = 30;
            System.out.println("Некорректные параметры. Установлены значения по умолчанию.");
        }
        System.out.println("Создан новый светофор. Цвет: " + currentColor + ", таймер: " + timer + " сек.");
    }

    // Метод для изменения цвета светофора
    public void changeColor(String newColor, int newTimer) {
        if (isValidColor(newColor) && newTimer > 0) {
            this.currentColor = newColor.toUpperCase();
            this.timer = newTimer;
            System.out.println("Цвет светофора изменен на: " + currentColor);
        } else {
            System.out.println("Ошибка: неверный цвет или время. Допустимые цвета: RED, YELLOW, GREEN.");
        }
    }

    // Метод для отображения текущего состояния
    public void printState() {
        System.out.println("Текущий цвет: " + currentColor + " | Осталось времени: " + timer + " сек.");
    }

    // Метод для имитации работы светофора (уменьшение таймера)
    public void tick() {
        if (timer > 0) {
            timer--;
            System.out.println("Таймер: " + timer + " сек.");

            // Если время истекло, автоматически переключаем цвет
            if (timer == 0) {
                autoChangeColor();
            }
        }
    }

    // Приватный метод для автоматической смены цвета
    public void autoChangeColor() {
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
        System.out.println("Автоматическая смена цвета!");
    }



    // Приватный метод для проверки корректности цвета
    private boolean isValidColor(String color) { //red
        if (color == null) return false;
        String upperColor = color.toUpperCase();//RED
        return upperColor.equals("RED")||
        upperColor.equals("YELLOW")||
    upperColor.equals("GREEN");
    }

    // Геттеры (только для чтения) - инкапсуляция
    public String getCurrentColor() {
        return currentColor;
    }

    public int getTimer() {
        return timer;
    }

    public void emergencyMode() {
        this.currentColor = "YELLOW";
        this.timer = 0;
        System.out.println("Включен желтый аварийный свет");

    }
    public void getNumberCar () {

    }

    // Сеттеры отсутствуют - нельзя напрямую менять состояние
}
