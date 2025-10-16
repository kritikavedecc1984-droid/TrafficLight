package TrafficLight;

interface TrafficLightBase {
    void changeColor(String newColor, int newTimer);
    void printState();
    void tick();
    String getCurrentColor();
    int getTimer();
}
