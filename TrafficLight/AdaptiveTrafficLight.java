package TrafficLight;

// Адаптивный светофор с учетом трафика
class AdaptiveTrafficLight extends AbstractTrafficLight implements Adaptive {
    private int carCount;
    private int maxCarThreshold;
    private boolean sensorActive;

    public AdaptiveTrafficLight() {
        super("RED", 30);
        this.maxCarThreshold = 10;
        this.sensorActive = true;
        System.out.println("Создан адаптивный светофор. Максимальный порог: " + maxCarThreshold + " автомобилей");
    }

    public AdaptiveTrafficLight(int maxCarThreshold) {
        super("RED", 30);
        this.maxCarThreshold = maxCarThreshold;
        this.sensorActive = true;
        System.out.println("Создан адаптивный светофор. Максимальный порог: " + maxCarThreshold + " автомобилей");
    }

    @Override
    public void adjustBasedOnTraffic(int carCount) {
        this.carCount = carCount;
        System.out.println("Обнаружено автомобилей: " + carCount);

        if (sensorActive) {
            if (carCount > maxCarThreshold && currentColor.equals("RED")) {
                // Много машин - быстрее переключаем на зеленый
                changeColor("GREEN", 60);
                System.out.println("Высокая загруженность! Увеличено время зеленого света.");
            } else if (carCount <= 3 && currentColor.equals("GREEN")) {
                // Мало машин - быстрее переключаем на красный
                if (timer > 10) {
                    timer = 10;
                    System.out.println("Низкая загруженность! Уменьшено время зеленого света.");
                }
            }
        }
    }

    @Override
    public int getCarCount() {
        return carCount;
    }

    @Override
    protected void autoChangeColor() {
        switch (currentColor) {
            case "RED":
                changeColor("GREEN", carCount > maxCarThreshold ? 60 : 30);
                break;
            case "GREEN":
                changeColor("YELLOW", 5);
                break;
            case "YELLOW":
                changeColor("RED", 30);
                break;
        }
        System.out.println("Адаптивная автоматическая смена цвета! Машин в очереди: " + carCount);
    }

    public void setSensorActive(boolean active) {
        this.sensorActive = active;
        System.out.println("Датчики трафика: " + (active ? "АКТИВНЫ" : "НЕАКТИВНЫ"));
    }

    @Override
    public void printState() {
        super.printState();
        System.out.println("Автомобилей обнаружено: " + carCount + ", порог: " + maxCarThreshold);
    }
}
