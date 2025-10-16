package TrafficLight;

// Класс светофора для пешеходного перехода
class PedestrianTrafficLight extends AbstractTrafficLight {
    private boolean isButtonPressed;

    public PedestrianTrafficLight() {
        super("RED", 0);
        System.out.println("Создан новый пешеходный светофор. Цвет по умолчанию: " + currentColor);
    }

    public void pressButton() {
        this.isButtonPressed = true;
        System.out.println("Кнопка нажата! Светофор переключится на зеленый в следующем цикле.");
    }

    @Override
    protected void autoChangeColor() {
        if (isButtonPressed && currentColor.equals("RED")) {
            changeColor("GREEN", 15);
            isButtonPressed = false;
            System.out.println("Пешеходам разрешено переходить дорогу!");
        } else {
            changeColor("RED", 0);
            System.out.println("Пешеходам запрещено переходить дорогу!");
        }
    }

    @Override
    public void printState() {
        super.printState();
        System.out.println("Кнопка нажата: " + (isButtonPressed ? "ДА" : "НЕТ"));
    }
}