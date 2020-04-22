package observable;

public interface Subject {

    void removeObserver(Observer o);

    void registerObserver(Observer o);

    void notifyObservers();
}
