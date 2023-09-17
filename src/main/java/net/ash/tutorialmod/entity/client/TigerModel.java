package net.ash.tutorialmod.entity.client;

import net.ash.tutorialmod.TutorialMod;
import net.ash.tutorialmod.entity.custom.TigerEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.loading.object.BakedAnimations;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class TigerModel extends GeoModel<TigerEntity> {
    /**
     * Returns the resource path for the {@link BakedGeoModel} (model json file) to render based on the provided animatable
     *
     * @param animatable
     */
    @Override
    public ResourceLocation getModelResource(TigerEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "geo/tiger.geo.json");
    }

    /**
     * Returns the resource path for the texture file to render based on the provided animatable
     *
     * @param animatable
     */
    @Override
    public ResourceLocation getTextureResource(TigerEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/tiger.png");
    }

    /**
     * Returns the resourcepath for the {@link BakedAnimations} (animation json file) to use for animations based on the provided animatable
     *
     * @param animatable
     */
    @Override
    public ResourceLocation getAnimationResource(TigerEntity animatable) {
        return new ResourceLocation(TutorialMod.MOD_ID, "animations/tiger.animation.json");
    }

    @Override
    public void setCustomAnimations(TigerEntity animatable, long instanceId, AnimationState<TigerEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
