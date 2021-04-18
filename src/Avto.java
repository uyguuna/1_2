import java.util.*;
/*
– организовать поиск по регистрационному номеру, исправление одного из
полей и вывод полной информации об автомобиле после редактирования.*/

public class Avto {
  String model;
  String nomer;
  int god;
  int cena;
  public void printAvto() {
        System.out.println(this.model + " " + this.nomer + " " + this.god + " " + this.cena);
    }
}
class AvtoInfo {
    static Scanner sc;
    public static Avto[] fillArray(int count) {
        Avto[] avtos = new Avto[count];
        for (int i = 0; i < count; i++) {
            avtos[i] = new Avto();
            System.out.println("Введите модель: ");
            avtos[i].model = sc.nextLine();
            System.out.println("Введите номер: ");
            avtos[i].nomer = sc.nextLine();
            System.out.println("Введите год: ");
            avtos[i].god = sc.nextInt();
            System.out.println("Введите цену: ");
            avtos[i].cena = sc.nextInt();
            sc.nextLine();
        }
        return avtos;
    }
    public static void printAvtos(Avto[] avtos){
        for (int i = 0; i < avtos.length; i++){
            avtos[i].printAvto();
        }
    }
    public static Avto findDesh(Avto[] avtos){
        int min = avtos[0].cena;
        int indexMin = 0;
        for (int i = 0; i < avtos.length; i++){
            if(avtos[i].cena>min){
                avtos[i].cena = min;
                indexMin = i;
            }
        }
        return avtos[indexMin];
    }
    public static void sortGod(Avto[] avtos){
        boolean sorted = false;
        int rab;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < avtos.length-1; i++) {
                if (avtos[i].god > avtos[i+1].god) {
                    sorted = false;
                    rab = avtos[i].god;
                    avtos[i].god = avtos[i+1].god;
                    avtos[i+1].god = rab;
                }
            }
        }
    }
    public static int findAvto(Avto[] avtos, String nomer){
        int index = -1;
        for (int i = 0; i<avtos.length; i++){
            if(nomer.equals(avtos[i].nomer)){
                index = i;
            }
        }
        return index;
    }


    public static void editAvto(Avto avto){
        System.out.println("Изменение поля:");
        System.out.println("model, nomer, god, cena");
        String editQuery = sc.nextLine();
        switch (editQuery){
            case "model": {
                System.out.println("Модель:");
                String newModel = sc.nextLine();
                avto.model = newModel;
                break;
            }
            case "nomer": {
                System.out.println("Номер:");
                String newNomer = sc.nextLine();
                avto.model = newNomer;
                break;
            }
            case "god": {
                System.out.println("Год:");
                String newGod = sc.nextLine();
                avto.model = newGod;
                break;
            }
            case "cena": {
                System.out.println("Цена:");
                String newCena = sc.nextLine();
                avto.model = newCena;
                break;
            }
            default: {
                System.out.println("Ошибка");
            }
        }

    }
    public static void main(String[] args){
        Avto avto = new Avto();

        sc = new Scanner(System.in);
        System.out.println("Введите Модель: ");
        int count = sc.nextInt();
        sc.nextLine();
        Avto[] avtos = fillArray(count);
        printAvtos(avtos);
        Avto avtoB = findDesh(avtos);
        System.out.println("Самая дешевая машина:");
        avtoB.printAvto();

        System.out.println("Сортировка массива:");
        sortGod(avtos);
        printAvtos(avtos);

        System.out.println("Введите искомое имя:");
        String nomerFind = sc.nextLine();
        int indexF = findAvto(avtos, nomerFind);
        if (indexF != -1){
            System.out.println("Такой номер есть");
            System.out.println(avtos[indexF]);
            editAvto(avtos[indexF]);
        } else{
            System.out.println("Ошибка");
        }
        printAvtos(avtos);
    }
}
