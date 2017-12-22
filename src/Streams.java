import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class Streams<T> {
    private final List<T> collection;

    private Streams(List<T> collection){
        this.collection = collection;
    }

    public static <T> Streams<T> of(List<T> list) {
        List<T> collection = new ArrayList<>();
        collection.addAll(list);
        return new Streams<>(collection);
    }


    public Streams<T> filter(Predicate<? super T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : collection) {
            if(predicate.test(t)) result.add(t);
        }
        return Streams.of(result);
    }


    public <R> Streams<R> transform(Function<? super T, ? extends R> fun) {
        List<R> result = new ArrayList<>();
        for (T t : collection) {
            result.add(fun.apply(t));
        }
        return Streams.of(result);
    }


    public <K, V> Map<K,V> toMap(Function<? super T, ? extends K> fun1, Function<? super T, ? extends V> fun2) {
        Map<K,V> result = new HashMap<>();
        for (T t : collection) {
            result.put(fun1.apply(t), fun2.apply(t));
        }
        return result;
    }

}