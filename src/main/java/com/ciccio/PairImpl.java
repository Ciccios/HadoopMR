package com.ciccio;

public class PairImpl<T1, T2> implements Pair<T1, T2> {

    public PairImpl(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    T1 first;
    T2 second;

    @Override
    public T1 getFirst() {
        return first;
    }

    public void setFirst(T1 first) {
        this.first = first;
    }

    @Override
    public T2 getSecond() {
        return second;
    }

    public void setSecond(T2 second) {
        this.second = second;
    }

}
