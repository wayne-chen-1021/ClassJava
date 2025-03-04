import com.example.*;
import com.example.utils.Utils;

class Data {
    String dataString;
    public Data(String s) {
        dataString = s;
    }
}

class Printer {
    public void rewrite(Data d) {
        d.dataString = "Hello to Java!";
    }
}

class DataTestDrive {
    public static void main(String[] args) {
        Data d = new Data("Hello from Java");
        Printer p = new Printer();
        p.rewrite(d); // 原先 Data d 的資料會被複寫
        System.out.println(d.dataString);

        /* 使用 package 範例 from ChatGPT
         * 文件位置: src/com/example/utils/Utils.java
         * src/com/example/Person.java
        */
        Person man = new Person("Wayne", 22);
        Utils.printPersonDetails(man);

        /* 使用 package 範例 from ClassJava
         * 文件位置: src/com/example/Cars.java
        */
        Car car1 = new Car("Toyota", 2018);
        System.out.println(car1.getBrand() + car1.getYear());
        car1.drive(100);

        Car car2 = new Car("Honda", 2020);
        System.out.println(car2.getBrand() + car2.getYear());
        car2.drive(200);

        Car car3 = new Car("Nissan", 2019);
        System.out.println("Total cars: " + Car.getTotalCars());

    }
    
}