package com.ore.oreplant.config;

import com.ore.oreplant.OrePlant;
import com.ore.oreplant.Seeds;
import com.ore.oreplant.generator.TreeGenerators;
import com.ore.oreplant.generator.TreeNatureGenerator;
import com.ore.oreplant.plants.tree.Sapling;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.function.DoubleSupplier;

@Config(modid = OrePlant.MODID)
public class Configuration {

    public static FlowerConfig flower = new FlowerConfig();
    public static ReedConfig reed = new ReedConfig();
    public static TreeConfig tree = new TreeConfig();
    public static VillageConfig village = new VillageConfig();

    public static void fromBytes(ByteBuf buf) {
        flower.fromBytes(buf);
        reed.fromBytes(buf);
        tree.fromBytes(buf);
        village.fromBytes(buf);
    }
    public static void toBytes(ByteBuf buf) {
        flower.toBytes(buf);
        reed.toBytes(buf);
        tree.toBytes(buf);
        village.toBytes(buf);
    }
    public static void reload(MessageContext context) {
        flower.reload(context);
        reed.reload(context);
        tree.reload(context);
        village.reload(context);
    }

    @net.minecraftforge.common.config.Config.LangKey("config.oreplant.flower")
    public static class FlowerConfig {

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.flower.generate")
        public boolean generate = true;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.flower.coal.probability")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double coalProbability = 0.003;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.flower.coal.count")
        @net.minecraftforge.common.config.Config.RangeInt(min = 0, max = 256)
        public int coalCount = 10;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.flower.iron.probability")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double ironProbability = 0.002;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.flower.iron.count")
        @net.minecraftforge.common.config.Config.RangeInt(min = 0, max = 256)
        public int ironCount = 7;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.flower.redstone.probability")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double redstoneProbability = 0.001;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.flower.redstone.count")
        @net.minecraftforge.common.config.Config.RangeInt(min = 0, max = 256)
        public int redstoneCount = 5;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.flower.gold.probability")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double goldProbability = 0.001;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.flower.gold.count")
        @net.minecraftforge.common.config.Config.RangeInt(min = 0, max = 256)
        public int goldCount = 5;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.flower.quartz.probability")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double quartzProbability = 0.001;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.flower.quartz.count")
        @net.minecraftforge.common.config.Config.RangeInt(min = 0, max = 256)
        public int quartzCount = 5;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.flower.obsidian.probability")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double obsidianProbability = 0.001;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.flower.obsidian.count")
        @net.minecraftforge.common.config.Config.RangeInt(min = 0, max = 256)
        public int obsidianCount = 5;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.flower.glowstone.probability")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double glowstoneProbability = 0.001;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.flower.glowstone.count")
        @net.minecraftforge.common.config.Config.RangeInt(min = 0, max = 256)
        public int glowstoneCount = 5;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.flower.lapis.probability")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double lapisProbability = 0.0005;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.flower.lapis.count")
        @net.minecraftforge.common.config.Config.RangeInt(min = 0, max = 256)
        public int lapisCount = 3;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.flower.diamond.probability")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double diamondProbability = 0.0001;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.flower.diamond.count")
        @net.minecraftforge.common.config.Config.RangeInt(min = 0, max = 256)
        public int diamondCount = 1;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.flower.emerald.probability")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double emeraldProbability = 0.0001;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.flower.emerald.count")
        @net.minecraftforge.common.config.Config.RangeInt(min = 0, max = 256)
        public int emeraldCount = 1;

        public void fromBytes(ByteBuf buf) {
            generate = buf.readBoolean();
            coalProbability = buf.readDouble();
            coalCount = buf.readInt();
            ironProbability = buf.readDouble();
            ironCount = buf.readInt();
            redstoneProbability = buf.readDouble();
            redstoneCount = buf.readInt();
            goldProbability = buf.readDouble();
            goldCount = buf.readInt();
            quartzProbability = buf.readDouble();
            quartzCount = buf.readInt();
            obsidianProbability = buf.readDouble();
            obsidianCount = buf.readInt();
            glowstoneProbability = buf.readDouble();
            glowstoneCount = buf.readInt();
            lapisProbability = buf.readDouble();
            lapisCount = buf.readInt();
            diamondProbability = buf.readDouble();
            diamondCount = buf.readInt();
            emeraldProbability = buf.readDouble();
            emeraldCount = buf.readInt();
        }

        public void toBytes(ByteBuf buf) {
            buf.writeBoolean(generate);
            buf.writeDouble(coalProbability);
            buf.writeInt(coalCount);
            buf.writeDouble(ironProbability);
            buf.writeInt(ironCount);
            buf.writeDouble(redstoneProbability);
            buf.writeInt(redstoneCount);
            buf.writeDouble(goldProbability);
            buf.writeInt(goldCount);
            buf.writeDouble(quartzProbability);
            buf.writeInt(quartzCount);
            buf.writeDouble(obsidianProbability);
            buf.writeInt(obsidianCount);
            buf.writeDouble(glowstoneProbability);
            buf.writeInt(glowstoneCount);
            buf.writeDouble(lapisProbability);
            buf.writeInt(lapisCount);
            buf.writeDouble(diamondProbability);
            buf.writeInt(diamondCount);
            buf.writeDouble(emeraldProbability);
            buf.writeInt(emeraldCount);
        }

        public void reload(MessageContext context) {}
    }

    @net.minecraftforge.common.config.Config.LangKey("config.oreplant.reed")
    public static class ReedConfig {
        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.reed.generate")
        public boolean generate = true;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.reed.coal")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double coal = 0.03;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.reed.iron")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double iron = 0.02;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.reed.redstone")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double redstone = 0.01;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.reed.gold")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double gold = 0.01;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.reed.quartz")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double quartz = 0.01;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.reed.obsidian")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double obsidian = 0.01;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.reed.glowstone")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double glowstone = 0.01;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.reed.lapis")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double lapis = 0.005;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.reed.diamond")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double diamond = 0.001;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.reed.emerald")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double emerald = 0.001;

        public void fromBytes(ByteBuf buf) {
            generate = buf.readBoolean();
            coal = buf.readDouble();
            iron = buf.readDouble();
            redstone = buf.readDouble();
            gold = buf.readDouble();
            quartz = buf.readDouble();
            obsidian = buf.readDouble();
            glowstone = buf.readDouble();
            lapis = buf.readDouble();
            diamond = buf.readDouble();
            emerald = buf.readDouble();
        }

        public void toBytes(ByteBuf buf) {
            buf.writeBoolean(generate);
            buf.writeDouble(coal);
            buf.writeDouble(iron);
            buf.writeDouble(redstone);
            buf.writeDouble(gold);
            buf.writeDouble(quartz);
            buf.writeDouble(obsidian);
            buf.writeDouble(glowstone);
            buf.writeDouble(lapis);
            buf.writeDouble(diamond);
            buf.writeDouble(emerald);
        }

        public void reload(MessageContext context) { }
    }

    @net.minecraftforge.common.config.Config.LangKey("config.oreplant.tree")
    public static class TreeConfig {
        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.tree.generate")
        public boolean generate = true;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.tree.coal")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double coal = 0.003;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.tree.iron")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double iron = 0.002;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.tree.redstone")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double redstone = 0.001;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.tree.gold")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double gold = 0.001;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.tree.quartz")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double quartz = 0.001;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.tree.obsidian")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double obsidian = 0.001;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.tree.glowstone")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double glowstone = 0.001;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.tree.lapis")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double lapis = 0.0005;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.tree.diamond")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double diamond = 0.0001;

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.tree.emerald")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double emerald = 0.0001;

        public void toBytes(ByteBuf buf) {
            buf.writeBoolean(generate);
            buf.writeDouble(coal);
            buf.writeDouble(diamond);
            buf.writeDouble(emerald);
            buf.writeDouble(glowstone);
            buf.writeDouble(gold);
            buf.writeDouble(iron);
            buf.writeDouble(lapis);
            buf.writeDouble(obsidian);
            buf.writeDouble(quartz);
            buf.writeDouble(redstone);
        }

        public void fromBytes(ByteBuf buf) {
            generate = buf.readBoolean();
            coal = buf.readDouble();
            diamond = buf.readDouble();
            emerald = buf.readDouble();
            glowstone = buf.readDouble();
            gold = buf.readDouble();
            iron = buf.readDouble();
            lapis = buf.readDouble();
            obsidian = buf.readDouble();
            quartz = buf.readDouble();
            redstone = buf.readDouble();
        }

        public void reload(@SuppressWarnings("unused") MessageContext context) {
            setDecorator(Seeds.saplingCoal, () -> Configuration.tree.coal);
            setDecorator(Seeds.saplingDiamond, () -> Configuration.tree.diamond);
            setDecorator(Seeds.saplingEmerald, () -> Configuration.tree.emerald);
            setDecorator(Seeds.saplingGlowstone, () -> Configuration.tree.glowstone);
            setDecorator(Seeds.saplingGold, () -> Configuration.tree.gold);
            setDecorator(Seeds.saplingIron, () -> Configuration.tree.iron);
            setDecorator(Seeds.saplingLapis, () -> Configuration.tree.lapis);
            setDecorator(Seeds.saplingObsidian, () -> Configuration.tree.obsidian);
            setDecorator(Seeds.saplingQuartz, () -> Configuration.tree.quartz);
            setDecorator(Seeds.saplingRedstone, () -> Configuration.tree.redstone);
        }

        public void setDecorator(Sapling sapling, DoubleSupplier probabilityGetter) {
            TreeGenerators generators = sapling.getGenerators();
            generators.setCanGenerator(Configuration.tree.generate);
            generators.setDecorator(new TreeNatureGenerator(generators.wood, generators.leaf, probabilityGetter));
        }
    }

    @net.minecraftforge.common.config.Config.LangKey("config.oreplant.village")
    public static class VillageConfig {

        @net.minecraftforge.common.config.Config.LangKey("config.oreplant.village.probability")
        @net.minecraftforge.common.config.Config.RangeDouble(min = 0, max = 1)
        public double probability = 0.003;

        public void fromBytes(ByteBuf buf) {
            probability = buf.readDouble();
        }
        public void toBytes(ByteBuf buf) {
            buf.writeDouble(probability);
        }

        public void reload(MessageContext buf) {}
    }
}
