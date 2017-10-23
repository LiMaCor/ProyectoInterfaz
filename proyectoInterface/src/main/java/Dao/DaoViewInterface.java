package Dao;

import java.util.ArrayList;

/**
 *
 * @author Julián
 * @param <GenericBeanImplementation>
 */

public interface DaoViewInterface<GenericBeanImplementation> {
 
    public Long getcount() throws Exception;
 
    public ArrayList<GenericBeanImplementation> getpage(int intRegsPerPag, int intPage) throws Exception;
 
}
