import java.util.HashSet;
import java.util.Random;

/**
 * Created by julia on 12.12.2016.
 * @author Julia Savicheva
 */
public class RandomCounter {
    HashSet <Integer> set;
    int count;
    int time;

    public RandomCounter() {
        set = new HashSet<>();
        count = 0;
    }

    public int generateRandomNumber() {
        int randomNumber = getRandomNumber(0, 99);
        if (this.set.add(randomNumber)) {
            System.out.println(randomNumber);
            this.count++;
        }
        return randomNumber;
    }

    public int getCount() {
        return this.count;
    }

    public void incrementTime() {
        time++;
    }

    public int getTime() {
        return this.time;
    }

    private int getRandomNumber(int minimum, int maximum) {
        Random rn = new Random();
        int randomNum =  minimum + rn.nextInt(maximum - minimum + 1);
        return randomNum;

    }
}
