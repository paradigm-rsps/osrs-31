package osrs.cache;

import osrs.Buffer;
import osrs.ObjectDefinition;
import osrs.AnimationDefinition;
import osrs.VarpDefinition;

public class Definitions {
    public static AnimationDefinition getAnimation(int id) {
        AnimationDefinition animationDefinition = (AnimationDefinition) AnimationDefinition.SequenceDefinition_cached.method3474(id);
        if (animationDefinition != null) {
            return animationDefinition;
        } else {
            byte[] var2 = AnimationDefinition.SequenceDefinition_archive.method3204(12, id);
            animationDefinition = new AnimationDefinition();
            if (var2 != null) {
                animationDefinition.method752(new Buffer(var2));
            }

            animationDefinition.method742();
            AnimationDefinition.SequenceDefinition_cached.method3473(animationDefinition, id);
            return animationDefinition;
        }
    }

    public static ObjectDefinition getObject(int id) {
        ObjectDefinition objectDefinition = (ObjectDefinition) ObjectDefinition.ObjectDefinition_cached.method3474(id);
        if (objectDefinition != null) {
            return objectDefinition;
        } else {
            byte[] var2 = ObjectDefinition.ObjectDefinition_archive.method3204(6, id);
            objectDefinition = new ObjectDefinition();
            objectDefinition.id = id;
            if (var2 != null) {
                objectDefinition.method659(new Buffer(var2));
            }

            objectDefinition.method660();
            if (objectDefinition.isSolid) {
                objectDefinition.interactType = 0;
                objectDefinition.boolean1 = false;
            }

            ObjectDefinition.ObjectDefinition_cached.method3473(objectDefinition, id);
            return objectDefinition;
        }
    }

    public static VarpDefinition getVarp(int id) {
        VarpDefinition varpDefinition = (VarpDefinition) VarpDefinition.VarpDefinition_cached.method3474(id);
        if (varpDefinition != null) {
            return varpDefinition;
        } else {
            byte[] var2 = VarpDefinition.VarpDefinition_archive.method3204(16, id);
            varpDefinition = new VarpDefinition();
            if (var2 != null) {
                varpDefinition.method924(new Buffer(var2));
            }

            VarpDefinition.VarpDefinition_cached.method3473(varpDefinition, id);
            return varpDefinition;
        }
    }
}
