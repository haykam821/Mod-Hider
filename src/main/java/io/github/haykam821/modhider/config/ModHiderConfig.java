package io.github.haykam821.modhider.config;

import java.util.ArrayList;
import java.util.List;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;

@Config(name = "modhider")
@Config.Gui.Background("minecraft:textures/block/end_stone.png")
public class ModHiderConfig implements ConfigData {
	@ConfigEntry.Gui.Tooltip(count = 2)
	public List<String> hiddenMods = new ArrayList<>();
}