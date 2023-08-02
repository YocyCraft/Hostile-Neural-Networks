package dev.shadowsoffire.hostilenetworks.curios;

import dev.shadowsoffire.hostilenetworks.Hostile;
import dev.shadowsoffire.hostilenetworks.HostileNetworks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.InterModComms;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;
import top.theillusivec4.curios.api.SlotTypeMessage;

public class CuriosCompat {

    public static void sendIMC() {
        InterModComms.sendTo("curios", SlotTypeMessage.REGISTER_TYPE, () -> new SlotTypeMessage.Builder("deep_learner").size(1).icon(new ResourceLocation(HostileNetworks.MODID, "item/empty_learner_slot")).build());
    }

    public static ItemStack getDeepLearner(Player player) {
        return CuriosApi.getCuriosHelper().findFirstCurio(player, Hostile.Items.DEEP_LEARNER.get()).map(SlotResult::stack).orElse(ItemStack.EMPTY);
    }
}
