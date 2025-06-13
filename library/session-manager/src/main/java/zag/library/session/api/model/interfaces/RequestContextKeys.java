package zag.library.session.api.model.interfaces;

public interface RequestContextKeys<T extends Enum<T> & RequestContextKeys<T>> {
    String title();

    String name();

    default String label() {
        return this.name();
    }

    default T getValueOf(String name) {
        return Enum.valueOf((Class<T>) this.getClass(), name);
    }
}
