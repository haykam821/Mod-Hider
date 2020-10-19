package io.github.haykam821.modhider;

import java.util.Collection;
import java.util.stream.Collectors;

import io.github.haykam821.modhider.config.ModHiderConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
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
		return mods.stream().filter(mod -> {
			return !CONFIG.hiddenMods.contains(mod.getMetadata().getId());
		}).collect(Collectors.toSet());
	}
}