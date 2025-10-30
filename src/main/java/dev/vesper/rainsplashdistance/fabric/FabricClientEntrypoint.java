package dev.vesper.rainsplashdistance.fabric;

//? fabric {
import dev.vesper.rainsplashdistance.ModTemplate;
import net.fabricmc.api.ClientModInitializer;

public class FabricClientEntrypoint implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModTemplate.LOG.info("Initializing {} Client", ModTemplate.MOD_ID);
    }

}
//?}