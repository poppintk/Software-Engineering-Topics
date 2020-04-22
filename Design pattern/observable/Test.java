package observable;

public class Test {

    public static void main(String[] args){
        WeatherData weatherData = new WeatherData();
        WeatherDataDisplay weatherDataDisplay = new WeatherDataDisplay(weatherData);

        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(82,70,29.2f);
        weatherData.setMeasurements(78,90,29.2f);


        /**
         * Observer design pattern
         * 观察者模式： 定义另对象之间的一对多依赖， 这样依赖，当一个对象改变状态时， 它当所有依赖者都会收到通知并自动更新。
         */
        /**
         * 设计原则
         * 为了交互对象之间当松耦合设计而努力：
         * 改变主题（Subject） 或者观察者（Observer） 其中一方， 并不会影响另一方。因为2者是松耦合当，所以只要他们之间
         * 当接口仍被遵守，我们就可以自由地改变他们。
         */
    }



}

