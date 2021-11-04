package io.github.haykam821.modhider.mixin;

import java.util.Collection;

import com.terraformersmc.modmenu.ModMenu;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import io.github.haykam821.modhider.ClientMain;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;

@Mixin(value = ModMenu.class, remap = false)
public class ModMenuMixin {
	@Redirect(method = "onInitializeClient", at = @At(value = "INVOKE", target = "Lnet/fabricmc/loader/api/FabricLoader;getAllMods()Ljava/util/Collection;"))
	private Collection<ModContainer> hideInitialMods(FabricLoader loader) {
		return ClientMain.hideMods(loader.getAllMods());
	}
}