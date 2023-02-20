package com.til.algorithm.java.data_structure;

import java.util.LinkedList;

enum AnimalType {
    DOG,
    CAT
}

abstract class Animal {
    AnimalType type;
    String name;
    int order;

    public Animal(AnimalType type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String toString() {
        return order + ") type : " + type + ", name : " + name;
    }
}

class Dog extends Animal {

    Dog(String name) {
        super(AnimalType.DOG, name);
    }
}

class Cat extends Animal {

    Cat(String name) {
        super(AnimalType.CAT, name);
    }
}

class AnimalShelter {
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();
    int order;

    AnimalShelter() {
        order = 1;
    }

    void enqueue(Animal animal) {
        animal.setOrder(order);
        order++;
        if (animal.type == AnimalType.DOG) {
            dogs.addLast((Dog) animal);
        } else if (animal.type == AnimalType.CAT) {
            cats.addLast((Cat) animal);
        }
    }

    Animal dequeueDog() {
        return dogs.poll();
    }

    Animal dequeueCat() {
        return cats.poll();
    }

    Animal dequeue() {
        if (dogs.size() == 0 && cats.size() == 0) {
            return null;
        } else if (dogs.size() == 0) {
            return cats.poll();
        } else if (cats.size() == 0) {
            return dogs.poll();
        }
        Animal dog = dogs.peek();
        Animal cat = cats.peek();
        if (cat.order < dog.order) {
            return cats.poll();
        } else {
            return dogs.poll();
        }
    }
}

public class LinkedList_활용해_Queue_구현하기 {

    public static void main(String[] args) {
        Dog d1 = new Dog("d1");
        Dog d2 = new Dog("d2");
        Dog d3 = new Dog("d3");
        Cat c1 = new Cat("c1");
        Cat c2 = new Cat("c2");
        Cat c3 = new Cat("c3");

        AnimalShelter animalShelter = new AnimalShelter();
        animalShelter.enqueue(d1);
        animalShelter.enqueue(c1);
        animalShelter.enqueue(d2);
        animalShelter.enqueue(c2);
        animalShelter.enqueue(d3);
        animalShelter.enqueue(c3);

        System.out.println(animalShelter.dequeue());
        System.out.println(animalShelter.dequeue());
        System.out.println(animalShelter.dequeue());
        System.out.println(animalShelter.dequeue());
        System.out.println(animalShelter.dequeue());
        System.out.println(animalShelter.dequeue());
    }
}