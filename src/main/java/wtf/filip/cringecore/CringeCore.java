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
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import wtf.filip.cringecore.command.CringeCommand;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Filip
 */
@SuppressWarnings("unused")
@Mod(modid = CringeCore.MOD_ID, name = CringeCore.MOD_NAME, version = CringeCore.MOD_VERSION)
public class CringeCore {

    public static final Logger logger = LogManager.getLogger("CringeCore");
    public static final String MOD_NAME = "CringeCore";
    public static final String MOD_ID = "cringecore";
    public static final String MOD_VERSION = "2.0";
    @Mod.Instance(MOD_ID)
    public static CringeCore INSTANCE;
    public static GuiScreen gui = null;

    public final HashMap<Class<?>, HashMap<Field, Property>> data = new HashMap<>();
    public final HashMap<Field, Property> properties = new HashMap<>();

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new CringeCommand());
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    public void post(FMLPostInitializationEvent event) {
        Reflection.getInstance().reflectSk1erMods();
        this.accessProperties();
    }

    private void accessProperties() {
        for (Map.Entry<Class<?>, Class<? extends Vigilant>> aClass : Reflection.getInstance().getData().entrySet()) {
            for (Field field : aClass.getValue().getDeclaredFields()) {
                field.setAccessible(true);
                Property props = Reflection.getInstance().getProperties(field);
                if (props == null) continue;
                this.properties.put(field, props);
                logger.info("Added {}", field);
            }
            this.data.put(aClass.getKey(), properties);
            this.properties.clear();
        }
    }

    @SubscribeEvent
    public void guiTick(TickEvent.ClientTickEvent event) {
        if (gui != null) {
            try {
                Minecraft.getMinecraft().displayGuiScreen(gui);
            } catch (Exception ignored) {
            }
            gui = null;
        }
    }
}
