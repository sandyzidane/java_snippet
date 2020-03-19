package com.sandy.reflection;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UsingReflection {

    public static void main(String[] args) {
        UsingReflection ur = new UsingReflection();
        Arrays.stream(UsingReflection.class.getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(Demo.class))
                .forEach(method -> {
                    try {
                        System.out.println(String.format("method[name=%s] invoke", method.getName()));
                        method.invoke(ur);
                        System.out.println("--------------------");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }

    @Demo
    public void test_print_primitive_class() throws Exception {
        System.out.println(Integer.TYPE);
        System.out.println(int.class);
        System.out.println(Class.forName("java.lang.String"));
    }

    @Demo
    public void test_print_instanceof() {
        Class<String> cls = String.class;
        System.out.println("cls.isInstance ? " + cls.isInstance(20));
        System.out.println("cls.isInstance('hh') ? " + cls.isInstance(new String("hh")));
        System.out.println();
    }

    @Demo
    public void test_compile_at_runtime() {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        System.out.println(compiler.toString());
    }

    List<Map<String, Long>> f1 = new ArrayList<>();

    @Demo
    public void test_get_generic_type() throws Exception {
        Field f1 = UsingReflection.class.getDeclaredField("f1");
        Type type = f1.getGenericType();

        if (type instanceof ParameterizedType) {
            for (Type typeArg : ((ParameterizedType) type).getActualTypeArguments()) {
                System.out.println(typeArg);
            }
        }
    }

    @Demo
    public void test_java_lang_proxy() throws Exception {
        Class<?> proxyClass = Proxy.getProxyClass(this.getClass().getClassLoader(), HelloInterface.class);

        HelloInterface helloImpl = () -> System.out.println("hello invoke handler");
        InvocationHandler handler = (proxy, method, args) -> method.invoke(helloImpl, args);

        Object o = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{HelloInterface.class}, handler);

        ((HelloInterface) o).printHello();

        System.out.println(proxyClass.getCanonicalName());
        System.out.println(proxyClass.getName());
        System.out.println(proxyClass.getSimpleName());
        System.out.println(proxyClass.getTypeName());
        System.out.println();
        System.out.println(Arrays.stream(proxyClass.getInterfaces())
                                   .map(Class::getCanonicalName)
                                   .collect(Collectors.joining(",")));
        System.out.println(proxyClass.getSuperclass());
    }


}
