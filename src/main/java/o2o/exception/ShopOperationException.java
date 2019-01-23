package o2o.exception;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 吴亚斌
 * create : 2019-01-09 15:36
 * description
 */
public class ShopOperationException extends RuntimeException{


    private static final long serialVersionUID = 1743458308754341076L;

    public ShopOperationException(String msg){
        super(msg);
    }
}
