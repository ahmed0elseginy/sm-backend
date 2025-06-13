package zag.library.common.interfaces;

public interface Events<E extends Enum<E> & Events<E, D>, D extends Enum<D> & Domains<D>> {
    Integer id();

    Domains<D> domain();

    String name();

    default String label() {
        return this.name();
    }

    default E getValueOf(String name) {
        return Enum.valueOf((Class<E>) this.getClass(), name);
    }

}
