package origin.com.libraryhttp.http.simple.offer.java.generic.code;

/**
 * @author Cay Horstmann
 * @version 1.01 2012-01-26
 */
public class PairTest3 {
    public static void main(String[] args) {
        Manager ceo = new Manager("Gus Greedy", 800000, 2003, 12, 15);
        Manager cfo = new Manager("Sid Sneaky", 600000, 2003, 12, 15);

        ceo.setBonus(1000000);
        cfo.setBonus(500000);

        //？ 和 extends 的理解 Employee  是Manager的父类
        Pair<Manager> buddies = new Pair<>(ceo, cfo);
        printBuddies(buddies);


        //？ 和 super 的理解 Employee  是Manager的父类
        Pair<Employee> result = new Pair<>();
        Manager[] managers = {ceo, cfo};
        minmaxBonus(managers, result);

        //总结：
        // extends 可以get 但是set不可以
        // super 可以set 但是不可以get


        System.out.println("first: " + result.getFirst().getName()
                + ", second: " + result.getSecond().getName());
        maxminBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName()
                + ", second: " + result.getSecond().getName());
    }

    public static void printBuddies(Pair<? extends Employee> p) {
        Employee first = p.getFirst();
        Employee second = p.getSecond();

        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }

    public static void minmaxBonus(Manager[] a, Pair<? super Manager> result) {
        if (a.length == 0) return;
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.getBonus() > a[i].getBonus()) min = a[i];
            if (max.getBonus() < a[i].getBonus()) max = a[i];
        }
        result.setFirst(min);
        result.setSecond(max);


    }

    public static void maxminBonus(Manager[] a, Pair<? super Manager> result) {
        minmaxBonus(a, result);
        PairAlg.swapHelper(result); // OK--swapHelper captures wildcard type
    }
}

class PairAlg {
    public static boolean hasNulls(Pair<?> p) {
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void swap(Pair<?> p) {
        swapHelper(p);
    }

    public static <T> void swapHelper(Pair<T> p) {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}


