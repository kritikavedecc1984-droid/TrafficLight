package TrafficLight;

// Главный класс для демонстрации
public class Main {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ ПОЛИМОРФИЗМА СВЕТОФОРОВ ===\n");

        // Полиморфизм: создаем массив разных типов светофоров
        AbstractTrafficLight[] trafficLights = new AbstractTrafficLight[3];

        // Обычный автомобильный светофор
        trafficLights[0] = new TrafficLight("GREEN", 20);

        // Пешеходный светофор
        trafficLights[1] = new PedestrianTrafficLight();

        // Адаптивный светофор
        trafficLights[2] = new AdaptiveTrafficLight(8);

        System.out.println("\n=== ТЕСТИРОВАНИЕ РАЗНЫХ СВЕТОФОРОВ ===\n");

        // Демонстрация работы каждого светофора
        for (int i = 0; i < trafficLights.length; i++) {
            System.out.println("\n--- Светофор " + (i + 1) + " (" + trafficLights[i].getClass().getSimpleName() + ") ---");
            trafficLights[i].printState();

            // Специфическое поведение для каждого типа
            if (trafficLights[i] instanceof PedestrianTrafficLight) {
                ((PedestrianTrafficLight) trafficLights[i]).pressButton();
            } else if (trafficLights[i] instanceof AdaptiveTrafficLight) {
                ((AdaptiveTrafficLight) trafficLights[i]).adjustBasedOnTraffic(15);
            }

            // Общие методы через полиморфизм
            trafficLights[i].tick();
            trafficLights[i].printState();
        }

        System.out.println("\n=== АВАРИЙНЫЙ РЕЖИМ ДЛЯ ВСЕХ СВЕТОФОРОВ ===\n");

        // Демонстрация аварийного режима для всех светофоров
        for (AbstractTrafficLight light : trafficLights) {
            System.out.println("\n" + light.getClass().getSimpleName() + ":");
            light.emergencyMode();
            light.printState();
        }

        System.out.println("\n=== РАБОТА С АДАПТИВНЫМ СВЕТОФОРОМ ===\n");

        // Более детальная работа с адаптивным светофором
        AdaptiveTrafficLight adaptiveLight = new AdaptiveTrafficLight(5);
        adaptiveLight.printState();

        // Симулируем разную загруженность
        adaptiveLight.adjustBasedOnTraffic(2); // Мало машин
        adaptiveLight.changeColor("GREEN", 30);
        adaptiveLight.printState();

        adaptiveLight.adjustBasedOnTraffic(12); // Много машин
        adaptiveLight.printState();

        // Отключаем датчики
        adaptiveLight.setSensorActive(false);
        adaptiveLight.adjustBasedOnTraffic(20); // Не должно влиять
    }
}
