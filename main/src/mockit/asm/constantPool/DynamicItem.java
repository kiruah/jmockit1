package mockit.asm.constantPool;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

import mockit.asm.jvmConstants.ConstantPoolTypes;
import mockit.asm.util.DynamicConstHandle;

public final class DynamicItem extends TypeOrMemberItem {
    
    @Nonnegative
    private int bsmIndex;
    
    public DynamicItem(@Nonnegative int index) {
        
        super(index);
    }
    
    DynamicItem(@Nonnegative int index, @Nonnull DynamicItem item) {
        
        super(index, item);
        bsmIndex = item.bsmIndex;
    }
    
    /**
    * Sets the type, name, desc, and index of the constant or invoke dynamic item.
    *
    * @param type  one of {@link ConstantPoolTypes#INDY} or {@link ConstantPoolTypes#CONDY}, for invoke or constant dynamic, respectively
    * @param name  the item name
    * @param desc  the item type descriptor
    * @param index zero based index into the class attribute "BootstrapMethods".
    */
    public void set(int type, @Nonnull String name, @Nonnull String desc, @Nonnegative int index) {
        
        super.type = type;
        bsmIndex = index;
        setValuesAndHashcode(name, desc, index);
    }
    
    /**
    * Sets the type, name, desc, and index of the constant or invoke dynamic item.
    *
    * @param dch DynamicConstHandle
    */
    public void set(@Nonnull DynamicConstHandle dch) {
        
        super.type = dch.type;
        setValuesAndHashcode(dch.name, dch.desc, dch.bsmIndex);
    }
    
    @Override
    boolean isEqualTo(@Nonnull Item item) {
        
        DynamicItem other = (DynamicItem) item;
        return other.bsmIndex == bsmIndex && isEqualTo(other);
    }
}
