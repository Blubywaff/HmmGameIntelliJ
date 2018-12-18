public class NullTool extends Tool {
    public NullTool() {
        super();
        nullToolInit();
    }
    
    public void nullToolInit() {
        useType = null;
        mineFactor = 0;
        name = null;
    }
}