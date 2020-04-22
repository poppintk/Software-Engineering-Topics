package observable;

public class WeatherDataDisplay implements Observer,Idisplay {
    private Subject subject;
    private float temperature;
    private float humidity;

    public WeatherDataDisplay(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(float temp, float humi, float press) {
        this.temperature = temp;
        this.humidity = humi;
        display();
    }
}
