package singleton;

import java.util.Objects;

public class DbConnection {

    private static Object object;
//    FIX for the below-mentioned issues - as volatile reads/write only from memory and skips cache
//    - (have before) - volatile variables do not allow ordering on set of instructions above and below them
//    private static volatile Object object;
    int memberVariable;

    private DbConnection(int memberVariable) {
        this.memberVariable = memberVariable;
    }

    public static Object getInstance() {
        if(Objects.isNull(object)) {
            synchronized (Object.class) {
                if(Objects.isNull(object)) {
                   object = new DbConnection(10);
//                    allocate memory for new DbConnection Object
//                    set object variable value to allocated memory
//                    initialize memberVariable
                }
            }
        }
        return object;
    }
}
/*

issues #1 -
    if at line 20, object variable get initialized before setting line 21, new thread can connect with wrong object
issues #2 -
    if the variable gets initialized and it's currently saved in L1 cache and the memory syncup is yet to happen.
    Meanwhile, another core's thread and search the data and then to memory. That will try to create another new object
*/
