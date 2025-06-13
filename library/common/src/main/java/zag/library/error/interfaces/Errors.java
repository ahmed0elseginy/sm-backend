package zag.library.error.interfaces;

import zag.library.common.interfaces.Domains;

public interface Errors<T extends Enum<T> & Errors<T, D>, D extends Enum<D> & Domains<D>> {
    Domains<D> domain();

    String code();

    String defaultMessage();

    String name();

    default String label() {
        return this.name();
    }

    default String getFullMessage() {
        return "[" + domain() + "-" + code() + "] [" + label() + "]: " + defaultMessage();
    }

    default T getValueOf(String name) {
        return Enum.valueOf((Class<T>) this.getClass(), name);
    }
}
