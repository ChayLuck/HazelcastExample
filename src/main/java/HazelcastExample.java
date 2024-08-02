import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import java.util.Random;
public class HazelcastExample {
    public static void main(String[] args) {
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        IMap<Integer, Integer> map = hz.getMap("randomNumbers");
        Random random = new Random();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            map.put(i, random.nextInt());
        }
        long end = System.currentTimeMillis();
        System.out.println("Time for putting 20,000 numbers: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            map.get(random.nextInt(20000));
        }
        end = System.currentTimeMillis();
        System.out.println("Time for getting 20,000 numbers: " + (end - start) + " ms");

        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            map.put(i, random.nextInt());
        }
        long end2 = System.currentTimeMillis();
        System.out.println("Time for putting 100,000 numbers: " + (end - start) + " ms");

        start2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            map.get(random.nextInt(100000));
        }
        end2 = System.currentTimeMillis();
        System.out.println("Time for getting 100,000 numbers: " + (end - start) + " ms");

        hz.shutdown();
    }
}
