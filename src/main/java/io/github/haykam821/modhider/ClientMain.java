package io.github.haykam821.modhider;

import java.util.Collection;
import java.util.stream.Collectors;

import com.terraformersmc.modmenu.util.mod.Mod;

import io.github.haykam821.modhider.config.ModHiderConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.ModContainer;

public class ClientMain implements ClientModInitializer {
	private static final ModHiderConfig CONFIG = AutoConfig.register(ModHiderConfig.class, GsonConfigSerializer::new).getConfig();

	@Override
	public void onInitializeClient() {
		return;
	}

	public static ModHiderConfig getConfig() {
		return CONFIG;
	}

	public static Collection<ModContainer> hideMods(Collection<ModContainer> mods) {
		return mods.stream().filter(ClientMain::isShown).collect(Collectors.toSet());
	}

	public static boolean isHidden(ModContainer mod) {
		return CONFIG.hiddenMods.contains(mod.getMetadata().getId());
	}

	public static boolean isShown(ModContainer mod) {
		return !ClientMain.isHidden(mod);
	}

	public static boolean isHidden(Mod mod) {
		return CONFIG.hiddenMods.contains(mod.getId());
	}

	public static boolean isShown(Mod mod) {
		return !ClientMain.isHidden(mod);
	}
}