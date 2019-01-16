/*************************************************************************

This program is copyrighted. Please refer to COPYRIGHT.txt for the
copyright notice.

This file is part of JavaNNS.

JavaNNS is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; either version 2 of the License, or
(at your option) any later version.

JavaNNS is distributed in the hope that it will be useful,
WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with JavaNNS; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

*************************************************************************/


package javanns;

/*---------------------------- imports ---------------------------------------*/
import java.io.* ;
import java.util.* ;

import java.util.jar.*;
import javax.swing.* ;
import java.awt.* ;

// imports for NetTrainer:
import java.awt.event.*;

/*------------------------ class declaration ---------------------------------*/
/**
 * NetworkAccessory is the accessory panel in the network file save dialog
 */
class NetworkAccessory extends JPanel{
  JLabel label = new JLabel("Network name: ");
  JTextField textField = new JTextField(10);

  public NetworkAccessory( Network net ){
    textField.setText( net.getName() );
    add(label);
    add(textField);
    //setBorder( BorderFactory.createLoweredBevelBorder() );
  }

  public String getName(){
    String name = textField.getText();
    if( name.equals("") ) name = "unnamed";
    return name;
  }
}
