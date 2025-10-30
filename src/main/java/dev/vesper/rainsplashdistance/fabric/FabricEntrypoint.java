package dev.vesper.rainsplashdistance.fabric;

//? fabric {
import dev.vesper.rainsplashdistance.ModTemplate;
import net.fabricmc.api.ModInitializer;

public class FabricEntrypoint implements ModInitializer {

    @Override
    public void onInitialize() {
        ModTemplate.init();
    }

}
//?}