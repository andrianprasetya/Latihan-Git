/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intefc;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Civilition
 */
public interface interfc {
      List getAll(String ID) throws SQLException;
      List getAll_pelanggan() throws SQLException;
    
}
