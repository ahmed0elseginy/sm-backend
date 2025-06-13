package zag.library.common.interfaces;

public interface Domains<D extends Enum<D> & Domains<D>> {
    Integer id();
    String destination();
    String name();

    default String label() {
        return this.name();
    }

    default D getValueOf(String name) {
        return Enum.valueOf((Class<D>) this.getClass(), name);
    }

}
