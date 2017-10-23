package Dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 *
 * @author Julián
 * @param <GenericBeanImplementation>
 */

public interface DaoViewInterface<GenericBeanImplementation> {
 
    public Long getcount() throws Exception;
 
    public ArrayList<GenericBeanImplementation> getpage(int intRegsPerPag, int intPage, LinkedHashMap<String,String> hmOrder) throws Exception;
 
}
