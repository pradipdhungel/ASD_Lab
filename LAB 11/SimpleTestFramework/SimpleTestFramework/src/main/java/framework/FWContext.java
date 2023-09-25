package framework;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

public class FWContext {

    private static List<Object> objectMap = new ArrayList<>();
    private static List<Object> serviceMap = new ArrayList<>();

    public FWContext() {
        try {
            // find and instantiate all classes annotated with the @TestClass annotation
            Reflections reflections = new Reflections("");
            Set<Class<?>> types = reflections.getTypesAnnotatedWith(TestClass.class);
            for (Class<?> implementationClass : types) {
                objectMap.add((Object) implementationClass.newInstance());
            }

            Set<Class<?>> serviceTypes = reflections.getTypesAnnotatedWith(Service.class);
            for (Class<?> implementationClass : serviceTypes) {
                serviceMap.add((Object) implementationClass.newInstance());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        performDI();
    }

    private void performDI() {
        try {
            for (Object theTestClass : objectMap) {
                for (Field field : theTestClass.getClass().getDeclaredFields()) {
                    if (field.isAnnotationPresent(Inject.class)) {
                        Class<?> theFieldType = field.getType();
                        Object instance = getBeanOfType(theFieldType);
                        field.setAccessible(true);
                        field.set(theTestClass, instance);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Object getBeanOfType(Class interfaceClasses) {
        Object service = null;
        try {
            for (Object theTestClass : serviceMap) {
                Class<?>[] interfaces = theTestClass.getClass().getInterfaces();
                for (Class<?> theInterface : interfaces) {
                    if (theInterface.getName().contentEquals(interfaceClasses.getName())) service = theTestClass;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return service;
    }

    public void start() {
        try {
            for (Object theTestClass : objectMap) {
                // find all methods annotated with the @Test annotation
                Method beforeMethod = null;
                for (Method method : theTestClass.getClass().getDeclaredMethods()) {
                    if (method.isAnnotationPresent(Before.class)) {
                        beforeMethod = method;
                    }
                }
                for (Method method : theTestClass.getClass().getDeclaredMethods()) {
                    if (method.isAnnotationPresent(Test.class)) {
                        if (beforeMethod != null) beforeMethod.invoke(theTestClass);
                        method.invoke(theTestClass);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
