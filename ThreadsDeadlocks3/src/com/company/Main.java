package com.company;

public class Main {

    public static void main(String[] args) {
        final PolitePerson p1 = new PolitePerson("Person-1");
        final PolitePerson p2 = new PolitePerson("Person-2");
        new Thread(new Runnable() {
            @Override
            public void run() {
                p1.sayHello(p2);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                p2.sayHello(p1);
            }
        }).start();
    }

    static class PolitePerson {
        private final String name;

        public PolitePerson(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void sayHello(PolitePerson person) {
            System.out.format("%s: %s" + " has said hello to me!\n", this.name, person.getName());
            person.sayHelloBack(this);
        }

        public synchronized void sayHelloBack(PolitePerson person) {
            System.out.format("%s: %s" + " has said hello back to me!\n", this.name, person.getName());
        }
    }
}
