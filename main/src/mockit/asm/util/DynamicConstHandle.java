package mockit.asm.util;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

public class DynamicConstHandle {
    
    @Nonnegative
    public final int type;
    
    @Nonnull
    public final String name;
    
    @Nonnull
    public final String desc;
    
    @Nonnegative
    public final int bsmIndex;
    
    public DynamicConstHandle(int type, String name, String desc, int bsmIndex) {
        
        this.type = type;
        this.name = name;
        this.desc = desc;
        this.bsmIndex = bsmIndex;
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if (obj == this) {
            return true;
        }
        
        if (!(obj instanceof DynamicConstHandle)) {
            return false;
        }
        
        DynamicConstHandle c = (DynamicConstHandle) obj;
        return this.type == c.type && this.name.equals(name) && this.desc.equals(desc);
    }
    
    @Override
    public int hashCode() {
        
        return type * name.hashCode() * desc.hashCode();
    }
}
