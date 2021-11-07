package solutions.mephedrone.hookdispatcher;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yoursleep
 * @since 08 November 2021
 */
public class EventDispatcher {
    private final List<Object> registeredObjects;

    public EventDispatcher() { registeredObjects = new ArrayList<>(); }

    public void register(@NotNull Object object) { if (!registeredObjects.contains(object)) registeredObjects.add(object); }

    public void unregister(@NotNull Object object) { if (registeredObjects.contains(object)) registeredObjects.remove(object); }

    public void dispatch(@NotNull Object event) {
        for (Object object : registeredObjects) {
            for (Method method : object.getClass().getMethods()) {
                if (
                        method.getAnnotation(Subscribe.class) != null
                        && method.getParameterCount() == 1
                        && method.getParameterTypes()[0].equals(event.getClass())
                ) {
                    try {
                        method.invoke(object, event);
                    } catch (InvocationTargetException | IllegalAccessException e) {
                        System.out.println("Failed to dispatch event " + event.getClass().getSimpleName() + "!");
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}