/*
 * MIT License
 *
 * Copyright (c) 2020 Filip Technologies
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package wtf.filip.cringecore;

import club.sk1er.vigilance.Vigilant;
import club.sk1er.vigilance.data.Property;
import net.minecraftforge.fml.common.Mod;
import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * @author Filip
 */
public class Reflection {
    private static Reflection instance;
    private final HashMap<Class<?>, Class<? extends Vigilant>> data = new HashMap<>();

    private Reflection() {
    }

    public static Reflection getInstance() {
        if (instance == null) {
            instance = new Reflection();
        }
        return instance;
    }

    public HashMap<Class<?>, Class<? extends Vigilant>> getData() {
        return data;
    }

    @SuppressWarnings("unchecked")
    public void reflectSk1erMods() {
        Reflections reflections = new Reflections("club.sk1er");
        Class<?>[] classes = reflections.getTypesAnnotatedWith(Mod.class).toArray(new Class<?>[0]);
        Class<? extends Vigilant>[] configClass =
            (Class<? extends Vigilant>[]) reflections.getSubTypesOf(Vigilant.class).toArray(new Class<?>[0]);

        for (int i = 0; i < classes.length; i++) {
            this.data.put(classes[i], configClass[i]);
        }
    }

    public Property getProperties(Field field) {
        return field.getAnnotation(Property.class);
    }

    public String getModName(Class<?> clazz) {
        Mod mod = clazz.getAnnotation(Mod.class);
        return mod.name();
    }
}
