package CS113;

import Interfaces.ListIteratorInterface;
import Interfaces.MapInterface;

import java.util.ArrayList;

public class MapRL<K,V> implements MapInterface<K, V> {

    class Entry<K, V> implements MapInterface.Entry<K, V>{
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return value;
        }
    }

    final int BUCKET_COUNT = 8;

    LinkedListRL<Entry<K,V>>[] buckets = new LinkedListRL[BUCKET_COUNT];
    int count = 0;
    int capacityFactor = 0;

    public MapRL(){
        for(int i = 0; i < buckets.length; i++){
            buckets[i] = new LinkedListRL<>();
        }
        capacityFactor = (int)((double) buckets.length * .75);
        String[] names = {"Noah", "Noah", "Derek", "Kyle", "Rafail", "Frankie", "KC", "Katanu", "ProfessorHorton"};
        for(String name : names){
            long hashCode = Integer.toUnsignedLong(name.hashCode());
            System.out.println(name + " " + hashCode + " modulated hash " + hashCode % buckets.length);
        }
    }


    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for(LinkedListRL<Entry<K, V>> bucket : buckets){
            ListIteratorInterface<Entry<K, V>> iterator = bucket.iterator();
            while(iterator.hasNext()){
                if(iterator.next().getValue().equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

    public int getHash(K key){
        return (key.hashCode());
    }

    @Override
    public V get(K key) {
        int index = getHash(key);
        LinkedListRL<Entry<K,V>> bucket = buckets[index];
        ListIteratorInterface<Entry<K,V>> iterator = bucket.iterator();

        while(iterator.hasNext()){
            Entry<K, V> entry = iterator.next();
            if(entry.key == key){
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        // convert the key to hash
        int index = getHash(key);
        LinkedListRL<Entry<K,V>> bucket = buckets[index];
        ListIteratorInterface<Entry<K,V>> iterator = bucket.iterator();

        while(iterator.hasNext()){
            Entry<K, V> entry = iterator.next();
            if(entry.key == key){
                entry.setValue(value);
                return value;
            }
        }
        bucket.addLast(new Entry<>(key, value));
        count++;
        if(count > capacityFactor){
            rehash();
        }
        return value;
    }

    @Override
    public V remove(K key) {
        int index = getHash(key);
        LinkedListRL<Entry<K,V>> bucket = buckets[index];
        ListIteratorInterface<Entry<K,V>> iterator = bucket.iterator();

        while(iterator.hasNext()){
            Entry<K, V> entry = iterator.next();
            if(entry.key == key){
                V temp = entry.getValue();
                iterator.remove();
                count--;
                return temp;
            }
        }
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public ArrayList<K> keySet() {
        ArrayList<K> returnValue = new ArrayList<>();

        for(LinkedListRL<Entry<K, V>> bucket : buckets) {
            ListIteratorInterface<Entry<K, V>> iterator = bucket.iterator();
            while (iterator.hasNext()) {
                returnValue.add(iterator.next().getKey());
            }
        }
        return returnValue;
    }

    void rehash(){

        LinkedListRL<Entry<K, V>>[] newBuckets = buckets;
        buckets = new LinkedListRL[buckets.length * 2];
        for(int i = 0; i < buckets.length; i++){
            buckets[i] = new LinkedListRL<>();
        }
        capacityFactor = (int)((double) buckets.length * 0.75);
        for(LinkedListRL<Entry<K, V>> bucket : buckets){
            ListIteratorInterface<Entry<K,V>> iterator = bucket.iterator();
            while(iterator.hasNext()){
                Entry<K,V> temp = iterator.next();
                int index = getHash(temp.getKey());
                LinkedListRL<Entry<K, V>> newBucket = buckets[index];
                newBucket.addLast(temp);
            }
        }
    }

    @Override
    public ArrayList<V> values() {
        ArrayList<V> returnValue = new ArrayList<>();

        for(LinkedListRL<Entry<K, V>> bucket : buckets) {
            ListIteratorInterface<Entry<K, V>> iterator = bucket.iterator();
            while (iterator.hasNext()) {
                returnValue.add(iterator.next().getValue());
            }
        }
        return returnValue;
    }
}
