package zag.library.session.api.service;

import zag.library.session.api.model.interfaces.RequestContextKeys;

import java.util.Map;

public interface RequestContext {
    void put(RequestContextKeys<?> key, String value);

    void put(RequestContextKeys<?> key, Object value);

    String get(RequestContextKeys<?> key);

    <T> T get(RequestContextKeys<?> key, Class<T> clazz);

    void remove(RequestContextKeys<?> key);

    Boolean containsKey(RequestContextKeys<?> key);

    Map<String, String> getAllValues();

    void pushInStack(RequestContextKeys<?> key, String value);

    String popFromStack(RequestContextKeys<?> key);

    String getTopFromStack(RequestContextKeys<?> key);
}
