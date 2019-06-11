package origin.com.libraryhttp.http.simple.offer.java.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zc on 2019/6/11
 */
public class PairTest {

    public static void main(String[] args) {

    }

    private void test(){
        List<? extends Animal> animals = new ArrayList<>();
//        animals.add(new Animal()); ERROR
//        animals.add(new Dog()); ERROR
    }
}

class Animal{

    public void shot(){

    }
}

class Dog extends Animal{

}
