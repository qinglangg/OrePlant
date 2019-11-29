package com.ore.oreplant.config;

import com.ore.oreplant.OrePlant;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.Set;

@SideOnly(Side.CLIENT)
public class OPConfigGui implements IModGuiFactory {
    @Override
    public void initialize(Minecraft minecraftInstance) {

    }

    @Override
    public boolean hasConfigGui() {
        return true;
    }

    @Override
    public GuiScreen createConfigGui(GuiScreen parentScreen) {
        ArrayList<IConfigElement> configs = new ArrayList<>();
        configs.add(ConfigElement.from(OPConfiguration.class));
        tryAddConfigPage("orereed", "com.ore.orereed.Config", configs);
        tryAddConfigPage("oretree", "com.ore.oretree.Config", configs);
        tryAddConfigPage("orevillage", "com.ore.orevillage.Config", configs);
        tryAddConfigPage("oreflower", "com.ore.oreflower.Config", configs);
        return new GuiConfig(parentScreen, configs, OrePlant.MODID, false, false,
                I18n.format("config.oreplant.title"),
                I18n.format("config.oreplant.subtitle"));
    }

    private void tryAddConfigPage(String mod, String className, ArrayList<IConfigElement> configs) {
        if (Loader.isModLoaded(mod)) {
            try {
                Class<?> confReed = Thread.currentThread().getContextClassLoader().loadClass(className);
                configs.add(ConfigElement.from(confReed));
            } catch(Exception ignore) {}
        }
    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null;
    }
}
