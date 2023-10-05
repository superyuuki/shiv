package shiv.impl;

import shiv.flexible.Initializer;
import shiv.IWith;
import shiv.initializer.ContainerOne;

//seriously don't look at this code
class WithImpl<T,A,B,C,D,E> implements IWith.None<T>, IWith.One<T,A>, IWith.Two<T,A,B>, IWith.Three<T,A,B,C>, IWith.Four<T,A,B,C,D>, IWith.Five<T,A,B,C,D,E> {

    final Class<T> t;

    final Class<A> a;
    final Class<B> b;
    final Class<C> c;
    final Class<D> d;
    final Class<E> e;

    public WithImpl(Class<T> t, Class<A> a, Class<B> b, Class<C> c, Class<D> d, Class<E> e) {
        this.t = t;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }

    @Override
    public void register(Initializer.None<T> init) {

    }

    @Override
    public void register(Initializer.One<T, A> init) {
        new ContainerOne<>(t, a, init);
    }

    @Override
    public void register(Initializer.Two<T, A, B> init) {

    }

    @Override
    public void register(Initializer.Three<T, A, B, C> init) {

    }

    @Override
    public void register(Initializer.Four<T, A, B, C, D> init) {

    }

    @Override
    public void register(Initializer.Five<T, A, B, C, D, E> init) {

    }


}
