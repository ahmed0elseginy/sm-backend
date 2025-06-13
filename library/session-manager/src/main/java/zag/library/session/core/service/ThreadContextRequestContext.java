package zag.library.session.core.service;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.stereotype.Service;
import zag.library.session.api.model.interfaces.RequestContextKeys;
import zag.library.session.api.service.RequestContext;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ThreadContextRequestContext implements RequestContext {
    @Override
    public void put(RequestContextKeys<?> key, String value) {
        ThreadContext.put(key.label(), value);
    }

    @Override
    public void put(RequestContextKeys<?> key, Object value) {
        ThreadContext.put(key.label(), value.toString());
    }

    @Override
    public String get(RequestContextKeys<?> key) {
        return ThreadContext.get(key.label());
    }

    @Override
    public <T> T get(RequestContextKeys<?> key, Class<T> clazz) {
        if (clazz.equals(Integer.class)) {
            return (T) Integer.valueOf(ThreadContext.get(key.label()));
        } else if (clazz.equals(Long.class)) {
            return (T) Long.valueOf(ThreadContext.get(key.label()));
        } else if (clazz.equals(Double.class)) {
            return (T) Double.valueOf(ThreadContext.get(key.label()));
        } else if (clazz.equals(Float.class)) {
            return (T) Float.valueOf(ThreadContext.get(key.label()));
        } else if (clazz.equals(Boolean.class)) {
            return (T) Boolean.valueOf(ThreadContext.get(key.label()));
        }
        return (T) ThreadContext.get(key.label());
    }

    @Override
    public void remove(RequestContextKeys<?> key) {
        ThreadContext.remove(key.label());
    }

    @Override
    public Boolean containsKey(RequestContextKeys<?> key) {
        return ThreadContext.containsKey(key.label());
    }

    @Override
    public Map<String, String> getAllValues() {
        return ThreadContext.getContext();
    }

    @Override
    public void pushInStack(RequestContextKeys<?> key, String value) {
        String lastIndexKey = key + ".last.index";
        String lastIndexStr = ThreadContext.get(lastIndexKey);
        int nextIndex = 0;
        if (lastIndexStr != null)
            nextIndex = Integer.parseInt(lastIndexStr) + 1;

        ThreadContext.put(key + "[" + nextIndex + "]", value);
        ThreadContext.put(lastIndexKey, String.valueOf(nextIndex));
        ThreadContext.put(key.label(), value);
    }

    @Override
    public String popFromStack(RequestContextKeys<?> key) {
        String lastIndexKey = key + ".last.index";
        String lastIndexStr = ThreadContext.get(lastIndexKey);
        if (lastIndexStr != null) {
            int lastIndex = Integer.parseInt(lastIndexStr);
            String currentValue = ThreadContext.get(key + "[" + lastIndex + "]");
            ThreadContext.remove(key + "[" + lastIndex + "]");
            if (lastIndex != 0) {
                lastIndex--;
                ThreadContext.put(lastIndexKey, String.valueOf(lastIndex));
                String lastValue = ThreadContext.get(key + "[" + lastIndex + "]");
                ThreadContext.put(key.label(), lastValue);
            } else {
                ThreadContext.remove(lastIndexKey);
                ThreadContext.remove(key.label());
            }
            return currentValue;
        }
        return null;
    }

    @Override
    public String getTopFromStack(RequestContextKeys<?> key) {
        return ThreadContext.get(key.label());
    }
}
