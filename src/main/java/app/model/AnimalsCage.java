package app.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AnimalsCage {

    private final Animal animal;
    private final Timer timer;

    // "уточняем" что животное - собака
    // связывает бин таймер с этим классом
    @Autowired
    public AnimalsCage(@Qualifier("dog") Animal animal, Timer timer) {
        this.animal = animal;
        this.timer = timer;
    }

    // в тестах такой метод зачем-то есть, добавил сюда
    public Timer getTimer() {
        return timer;
    }

    public void whatAnimalSay() {
        System.out.println("Say:");
        System.out.println(animal.toString());
        System.out.println("At:");
        //System.out.println(new Timer().getTime());
        // заменяем создание объекта на вызов связанного бина (надеюсь, я все правильно понял)
        System.out.println(timer.getTime());
        //метод, который вызывается из теста
        //System.out.println(getTimer().getTime());
        System.out.println("________________________");
    }
}
