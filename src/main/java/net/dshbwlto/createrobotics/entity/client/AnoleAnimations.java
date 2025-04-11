package net.dshbwlto.createrobotics.entity.client;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class AnoleAnimations {
        public static final AnimationDefinition anole_walk = AnimationDefinition.Builder.withLength(2.0F).looping()
                .addAnimation("upper_body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(10.0F, -20.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(10.0F, 20.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(10.0F, -20.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(10.0F, 20.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-10.0F, -6.25F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.125F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(-10.0F, 12.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(-10.0F, -12.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(-10.0F, 12.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.875F, KeyframeAnimations.degreeVec(-10.0F, -12.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-10.0F, -6.25F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(30.0F, -12.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.125F, KeyframeAnimations.degreeVec(30.0F, -6.25F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(30.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(30.0F, 12.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(30.0F, -12.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(30.0F, 12.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(30.0F, -12.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legl", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-1.1793F, 6.3067F, 1.8038F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(9.5559F, 27.8448F, 29.0246F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-12.4509F, -17.3283F, 24.4828F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-1.1793F, 6.3067F, 1.8038F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(9.5559F, 27.8448F, 29.0246F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(-12.4509F, -17.3283F, 24.4828F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-1.1793F, 6.3067F, 1.8038F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("arml", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -7.5F, 25.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, -7.5F, 25.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(8.3156F, 9.9343F, -1.2505F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(15.4418F, 29.2339F, 22.5378F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(0.0F, -7.5F, 25.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(6.8098F, 7.745F, -1.1698F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(15.4418F, 29.2339F, 22.5378F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -7.5F, 25.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("armr", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-0.7185F, 10.6591F, -0.3207F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(15.4418F, -29.2339F, -22.5378F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-5.5708F, 15.9435F, -26.9787F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(4.2414F, -3.4821F, 0.0958F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(15.4418F, -29.2339F, -22.5378F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(-5.5708F, 15.9435F, -26.9787F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-0.7185F, 10.6591F, -0.3207F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legr", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 10.0F, -25.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(-14.8897F, 36.777F, -29.7652F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-2.936F, 13.8492F, 2.8408F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(14.7867F, -20.5613F, -27.3363F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(-14.8897F, 36.777F, -29.7652F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-2.936F, 13.8492F, 2.8408F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(14.7867F, -20.5613F, -27.3363F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 10.0F, -25.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(-12.5F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-12.5F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(-12.5F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(-12.5F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head_main", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, -10.31F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.125F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(10.0F, 15.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.875F, KeyframeAnimations.degreeVec(10.0F, -15.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(10.0F, 15.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.875F, KeyframeAnimations.degreeVec(10.0F, -15.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(10.0F, -10.31F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lower_body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(-2.5F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-2.5F, -0.62F, -2.66F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-2.5F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-2.5F, 0.66F, 2.67F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(-2.5F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-2.5F, -0.04F, -2.67F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(-2.5F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 2.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lower_body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(-0.25F, 0.25F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.25F, 0.25F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(-0.25F, 0.25F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(0.25F, 0.25F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("arml2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 35.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("armr2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -35.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("exhaust", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0833F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9167F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4167F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.875F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9167F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("jaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("chest", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.5F, 1.5F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legl2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -57.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legr2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 57.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .build();

        public static final AnimationDefinition anole_idle = AnimationDefinition.Builder.withLength(4.0F).looping()
                .addAnimation("lower_body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.5F, -2.5F, 2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-2.5F, 2.5F, 2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(-2.5F, -2.5F, 2.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lower_body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, 0.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("exhaust", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0833F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9167F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4167F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.875F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9167F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0833F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.125F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.3333F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.4167F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5417F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.6667F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7917F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.8333F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.9583F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.2083F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.2917F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.4167F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.4583F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.5F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.5833F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.625F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.7083F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.75F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.7917F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.9167F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.9583F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legl", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-1.1793F, 6.3067F, 21.8038F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(-1.18F, 6.31F, 21.8F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legl2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -72.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -85.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, -72.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legr", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 10.0F, -37.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 2.5F, -37.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 10.0F, -37.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legr2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 72.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 75.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 72.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-10.0F, -3.91F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-10.0F, -6.25F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(-10.0F, 8.75F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(-10.0F, -3.91F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(30.0F, -1.43F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(30.0F, -12.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.75F, KeyframeAnimations.degreeVec(30.0F, 22.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(30.0F, -1.43F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(4.0F, KeyframeAnimations.scaleVec(1.5F, 1.5F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("upper_body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(10.0F, -2.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(10.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-12.5F, 15.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head_main", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, -0.31F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(10.0F, -15.31F, -5.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(10.0F, -0.31F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("jaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.5F, 2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -0.5F, -2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.5F, 2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.5F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 0.5F, 2.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("chest", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.625F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.75F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("arml", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -7.5F, 25.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, -7.5F, 25.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("arml2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 35.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 42.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, 35.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("armr", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-0.7185F, 10.6591F, -30.3207F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(-0.72F, 10.66F, -30.32F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("armr2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -35.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(0.0F, -35.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .build();

        public static final AnimationDefinition anole_swim = AnimationDefinition.Builder.withLength(4.0F).looping()
                .addAnimation("lower_body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.0F, 7.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-5.0F, -7.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.degreeVec(-5.0F, -5.16F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-5.0F, 7.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(-5.0F, -7.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.25F, KeyframeAnimations.degreeVec(-5.0F, -5.16F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(-5.0F, 7.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lower_body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.25F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("exhaust", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0833F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9167F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4167F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.875F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9167F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0417F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0833F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.125F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.3333F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.4167F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5417F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.6667F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7917F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.8333F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.9583F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.2083F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.2917F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.4167F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.4583F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.5F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.5833F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.625F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.7083F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.75F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.7917F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.9167F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.9583F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legl", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(20.0F, -70.0F, -2.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legl2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -30.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legr", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(17.5F, 70.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legr2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 30.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.5F, 2.75F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.375F, KeyframeAnimations.degreeVec(2.5F, 7.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.degreeVec(2.5F, -7.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(2.5F, 2.75F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.375F, KeyframeAnimations.degreeVec(2.5F, 7.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.375F, KeyframeAnimations.degreeVec(2.5F, -7.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(2.5F, 2.75F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.5F, -2.75F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(2.5F, 7.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(2.5F, -7.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(2.5F, -2.75F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(2.5F, 7.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.625F, KeyframeAnimations.degreeVec(2.5F, -7.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(2.5F, -2.75F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("upper_body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(7.5F, 2.75F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.625F, KeyframeAnimations.degreeVec(7.5F, -7.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(7.5F, 7.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(7.5F, 2.75F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.625F, KeyframeAnimations.degreeVec(7.5F, -7.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.625F, KeyframeAnimations.degreeVec(7.5F, 7.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.degreeVec(7.5F, 2.75F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head_main", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("chest", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.125F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.25F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.4167F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.625F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.75F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(4.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("arml", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(62.5F, -70.0F, 30.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(62.5F, -70.0F, 30.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("arml2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 35.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 35.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("armr", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(62.5F, 70.0F, -30.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(62.5F, 70.0F, -30.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("armr2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -35.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -35.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.5F, 1.5F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .build();

        public static final AnimationDefinition anole_sit = AnimationDefinition.Builder.withLength(0.5F)
                .addAnimation("lower_body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.5F, -2.5F, 2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-2.5F, 20.0F, 2.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lower_body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(-1.0F, -0.75F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("exhaust", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0833F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legl", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-1.1793F, 6.3067F, 21.8038F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-1.18F, 28.81F, 4.3F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legl2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -72.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, -132.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legr", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 10.0F, -37.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, -47.5F, -15.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legr2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 72.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 152.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-10.0F, -3.91F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-2.5F, 26.09F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(30.0F, -1.43F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(10.0F, 51.07F, 10.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.5F, 1.5F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("upper_body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(10.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-17.5F, -20.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head_main", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, -0.31F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(10.0F, -25.31F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head_main", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, -0.25F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("jaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.5F, 2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("chest", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0417F, KeyframeAnimations.posVec(-0.1F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(-0.1F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(-0.1F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("arml", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -7.5F, 25.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 7.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("arml2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 35.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 137.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("armr", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-0.7185F, 10.6591F, -30.3207F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-5.72F, 45.66F, -20.32F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("armr2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -35.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, -137.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .build();

        public static final AnimationDefinition anole_stand = AnimationDefinition.Builder.withLength(0.5F)
                .addAnimation("lower_body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.5F, 20.0F, 2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-2.5F, -2.5F, 2.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lower_body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-1.0F, -0.75F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("exhaust", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0833F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legl", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-1.18F, 28.81F, 4.3F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-1.1793F, 6.3067F, 21.8038F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legl2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -132.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, -72.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legr", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -47.5F, -15.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 10.0F, -37.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legr2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 152.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 72.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.5F, 26.09F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-10.0F, -3.91F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, 51.07F, 10.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(30.0F, -1.43F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.5F, 1.5F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("upper_body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(10.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-17.5F, -20.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head_main", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, -25.31F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(10.0F, -0.31F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head_main", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.25F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("jaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.5F, 2.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("chest", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0417F, KeyframeAnimations.posVec(-0.1F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(-0.1F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(-0.1F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("arml", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 7.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, -7.5F, 25.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("arml2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 137.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 35.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("armr", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.72F, 45.66F, -20.32F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-0.7185F, 10.6591F, -30.3207F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("armr2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -137.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, -35.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .build();

        public static final AnimationDefinition anole_stay = AnimationDefinition.Builder.withLength(2.0F).looping()
                .addAnimation("lower_body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.5F, 20.0F, 2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-2.5F, 20.0F, 2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-2.5F, 20.0F, 2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-2.5F, 20.0F, 2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-2.5F, 20.0F, 2.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lower_body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-1.0F, -0.75F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(-1.0F, -0.75F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(-1.0F, -0.75F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(-1.0F, -0.75F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(-1.0F, -0.75F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("exhaust", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0833F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9167F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4167F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.8333F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.875F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9167F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legl", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-1.18F, 28.81F, 4.3F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-1.18F, 28.81F, 4.3F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-1.18F, 28.81F, 4.3F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-1.18F, 28.81F, 4.3F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-1.18F, 28.81F, 4.3F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legl2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -132.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, -132.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -132.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, -132.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -132.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legr", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -47.5F, -15.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, -47.5F, -15.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -47.5F, -15.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, -47.5F, -15.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -47.5F, -15.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legr2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 152.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 152.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 152.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 152.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 152.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.5F, 26.09F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-2.5F, 28.59F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-2.5F, 26.09F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, 52.32F, 10.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(10.0F, 51.07F, 10.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(10.0F, 53.57F, 10.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(10.0F, 52.32F, 10.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.5F, 1.5F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("upper_body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(10.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(10.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(10.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(10.0F, -25.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-17.5F, -20.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-17.5F, -20.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-17.5F, -20.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-17.5F, -20.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-17.5F, -20.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head_main", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, -25.31F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(10.0F, -25.31F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(10.0F, -25.31F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(10.0F, -25.31F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(10.0F, -25.31F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head_main", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.25F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, -0.25F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -0.25F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, -0.25F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, -0.25F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("jaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("chest", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9167F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4167F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5417F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.6667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9167F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("arml", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 7.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 7.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 7.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 7.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -25.0F, 7.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("arml2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 137.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 137.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 137.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 137.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 137.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("armr", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.72F, 45.66F, -20.32F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-5.72F, 45.66F, -20.32F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-5.72F, 45.66F, -20.32F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-5.72F, 45.66F, -20.32F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-5.72F, 45.66F, -20.32F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("armr2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -137.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, -137.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -137.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, -137.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -137.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .build();

        public static final AnimationDefinition anole_alert = AnimationDefinition.Builder.withLength(3.0F).looping()
                .addAnimation("lower_body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lower_body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 1.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0F, KeyframeAnimations.posVec(0.0F, 1.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("exhaust", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0833F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.8333F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.875F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0833F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.125F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.3333F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.4583F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5833F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.8333F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.875F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legl", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 55.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 55.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legl2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -75.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, -75.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legr", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -55.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -55.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legr2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 75.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 75.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.0F, 22.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-5.0F, -22.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-5.0F, 22.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-5.0F, -22.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(-5.0F, 22.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 27.69F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(0.0F, 57.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -57.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 27.69F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.degreeVec(0.0F, 57.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5F, KeyframeAnimations.degreeVec(0.0F, -57.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 27.69F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.5F, 1.5F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("upper_body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(-10.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head_main", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(82.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(75.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(82.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("chest", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.25F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7083F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.125F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.2083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.25F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.375F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.4583F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.7083F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.75F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.8333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.875F, KeyframeAnimations.posVec(0.0F, -0.1F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("arml", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -55.0F, 72.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, -52.5F, 72.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, -55.0F, 72.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("arml", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.1F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0F, KeyframeAnimations.posVec(0.0F, -0.1F, 0.1F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("armr", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 55.0F, -72.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 52.5F, -72.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0F, KeyframeAnimations.degreeVec(0.0F, 55.0F, -72.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("armr", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.1F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(3.0F, KeyframeAnimations.posVec(0.0F, -0.1F, 0.1F), AnimationChannel.Interpolations.LINEAR)
                ))
                .build();

        public static final AnimationDefinition anole_death = AnimationDefinition.Builder.withLength(2.25F)
                .addAnimation("lower_body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.5F, -2.5F, 2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-35.0F, -2.5F, 2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(-35.0F, -2.5F, 2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-2.5F, -2.5F, 2.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lower_body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 1.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 1.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("exhaust", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0833F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2083F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.375F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5417F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7917F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8333F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.875F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9167F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.1667F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2083F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.2917F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.375F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.4583F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5833F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legl", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-1.1793F, 6.3067F, 21.8038F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(18.51F, -21.19F, 23.21F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(-1.18F, 6.31F, 21.8F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(3.82F, 6.31F, -0.7F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legl2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -72.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -72.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, -72.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -72.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legr", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 10.0F, -37.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(18.51F, 21.19F, -23.21F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, 10.0F, -37.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -7.5F, -5.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legr2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 72.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 73.59F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, 72.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 55.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-10.0F, -3.91F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(10.63F, -3.91F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.7083F, KeyframeAnimations.degreeVec(32.5F, -3.91F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.875F, KeyframeAnimations.degreeVec(0.0F, -3.91F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(30.0F, -1.43F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(30.0F, -1.43F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(66.88F, -1.43F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.8333F, KeyframeAnimations.degreeVec(66.88F, -1.43F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -1.43F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.125F, KeyframeAnimations.degreeVec(2.55F, -1.43F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(0.0F, -1.43F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.5F, 1.5F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.scaleVec(1.5F, 1.5F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.scaleVec(1.5F, 1.5F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.scaleVec(1.5F, 1.5F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("upper_body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(22.5F, 5.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-32.5F, 5.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(-32.5F, 5.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(10.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0833F, KeyframeAnimations.degreeVec(7.5F, 5.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(10.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(-25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0833F, KeyframeAnimations.degreeVec(-14.22F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head_main", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, -0.31F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(63.89F, -0.31F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(-20.0F, -0.31F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(-20.0F, -0.31F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-5.0F, -12.81F, 60.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("jaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.5F, 2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.5F, 2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(37.5F, 0.5F, 2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(37.5F, 0.5F, 2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(37.5F, 0.5F, 2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(7.5F, 25.5F, -15.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0833F, KeyframeAnimations.degreeVec(7.78F, 22.35F, -16.3F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.1667F, KeyframeAnimations.degreeVec(7.66F, 21.23F, -15.73F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.25F, KeyframeAnimations.degreeVec(7.5F, 25.5F, -15.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("chest", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0417F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("arml", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -7.5F, 25.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.31F, -0.83F, 64.69F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.47F, -42.5F, 2.03F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.47F, -42.5F, 2.03F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-7.5F, -7.5F, -7.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("arml2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 35.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 14.06F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, 14.06F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 50.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("armr", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-0.7185F, 10.6591F, -30.3207F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(5.69F, -15.28F, -52.59F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(12.09F, -41.22F, -14.85F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(12.09F, -41.22F, -14.85F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-5.72F, -39.34F, 2.18F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("armr2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -35.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, -35.94F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.625F, KeyframeAnimations.degreeVec(0.0F, -35.94F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .build();

        public static final AnimationDefinition anole_dead = AnimationDefinition.Builder.withLength(0.0F)
                .addAnimation("lower_body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.5F, -2.5F, 2.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lower_body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("exhaust", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legl", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(3.82F, 6.31F, -0.7F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legl2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -72.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legr", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -7.5F, -5.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legr2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 55.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -3.91F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -1.43F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.5F, 1.5F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("upper_body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head_main", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.0F, -12.81F, 60.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("jaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(7.5F, 25.5F, -15.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("chest", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("arml", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-7.5F, -7.5F, -7.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("arml2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 50.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("armr", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.72F, -39.34F, 2.18F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("armr2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .build();

        public static final AnimationDefinition anole_revive = AnimationDefinition.Builder.withLength(0.75F)
                .addAnimation("lower_body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-2.5F, -2.5F, 2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-2.5F, -2.5F, 2.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lower_body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -1.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("exhaust", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.125F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1667F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3333F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4167F, KeyframeAnimations.posVec(0.0F, -0.0999F, 0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4583F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.625F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.6667F, KeyframeAnimations.posVec(0.0F, 0.0999F, -0.0044F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7083F, KeyframeAnimations.posVec(0.0F, 0.0044F, 0.0999F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legl", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(3.82F, 6.31F, -0.7F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-1.1793F, 6.3067F, 21.8038F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legl2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -72.5F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, -72.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legr", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -7.5F, -5.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 10.0F, -37.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("legr2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 55.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 72.5F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail1", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -3.91F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-10.0F, -3.91F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -1.43F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(30.0F, -1.43F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.1F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bone", new AnimationChannel(AnimationChannel.Targets.SCALE,
                        new Keyframe(0.0F, KeyframeAnimations.scaleVec(1.5F, 1.5F, 1.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.scaleVec(1.5F, 1.5F, 1.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("upper_body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(10.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(10.0F, 5.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head_main", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.0F, -12.81F, 60.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(10.0F, -0.31F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("jaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(7.5F, 25.5F, -15.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 0.5F, 2.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("chest", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("arml", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-7.5F, -7.5F, -7.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, -7.5F, 25.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("arml2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 50.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, 35.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("armr", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.72F, -39.34F, 2.18F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-0.7185F, 10.6591F, -30.3207F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("armr2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -20.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(0.0F, -35.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .build();
}