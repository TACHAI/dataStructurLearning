package avlTree;

import Map.Map;

/**
 * Created by @Author tachai
 * date 2018/10/23 21:49
 * GitHub https://github.com/TACHAI
 * Email 1206966083@qq.com
 */
public class AVLMap<K extends Comparable<K>,V> implements Map<K,V> {

    private AVLTree<K,V> avl;
    public AVLMap(){
        avl = new AVLTree<>();
    }

    @Override
    public void add(K k, V v) {
        avl.add(k,v);
    }

    @Override
    public V remove(K k) {
        return avl.remove(k);
    }

    @Override
    public boolean contains(K k) {
        return avl.contains(k);
    }

    @Override
    public V get(K k) {
        return avl.get(k);
    }

    @Override
    public void set(K k, V v) {
        avl.set(k,v);
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }
}
