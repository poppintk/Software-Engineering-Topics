package observable;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressue;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i > 0) observers.remove(i);
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature,humidity,pressue);
        }
    }

    /**
     * 当从气象站得到更新观测指时，我们通知观察者
     */
    public void measurementsChanged(){
        notifyObservers();
    }


    /**
     *
     * @param temperature
     * @param humidity
     * @param pressure
     */
    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressue = pressure;
        measurementsChanged();
    }
}
