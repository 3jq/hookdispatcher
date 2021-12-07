package solutions.mephedrone.hookdispatcher;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author yoursleep
 * @since 08 November 2021
 */
public class EventDispatcher {
    private final Map<Object, List<Method>> registeredObjects;

    public EventDispatcher() { registeredObjects = new HashMap<>(); }

    public void register(@NotNull Object object) {
        if (registeredObjects.containsKey(object)) return;
        final List<Method> methods = new ArrayList<>();
        for (Method method : object.getClass().getMethods()) if (method.getAnnotation(Subscribe.class) != null && method.getParameterCount() == 1) methods.add(method);
        registeredObjects.put(object, methods);
    }

    public void unregister(@NotNull Object object) {
        registeredObjects.remove(object);
    }

    public void dispatch(@NotNull Object event) {
        for (Iterator<Map.Entry<Object, List<Method>>> it = registeredObjects.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Object, List<Method>> entry = it.next();
            for (Method method : entry.getValue()) {
                if (!method.getParameterTypes()[0].equals(event.getClass())) continue;

                try {
                    method.invoke(entry.getKey(), event);
                } catch (InvocationTargetException | IllegalAccessException e) {
                    System.out.println("Failed to dispatch event " + event.getClass().getSimpleName() + "!");
                    e.printStackTrace();
                }
            }
        }
    }
}
