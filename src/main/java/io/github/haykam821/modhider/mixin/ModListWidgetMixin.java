package io.github.haykam821.modhider.mixin;

import java.util.Collection;

import com.terraformersmc.modmenu.gui.widget.ModListWidget;
import com.terraformersmc.modmenu.util.mod.Mod;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import io.github.haykam821.modhider.ClientMain;

@Mixin(value = ModListWidget.class, remap = false)
public class ModListWidgetMixin {
	@ModifyVariable(method = "filter(Ljava/lang/String;ZZ)V", at = @At("STORE"), ordinal = 0)
	private Collection<Mod> hideFilterMods(Collection<Mod> mods) {
		mods.removeIf(ClientMain::isHidden);
		return mods;
	}
}