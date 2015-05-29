/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FortyNinerZone;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author priyanka
 */
public class PanelDB {
    
    public static List<Panel> getPanelList() {
        List<Panel> panelList = new ArrayList();
        panelList.add(new Panel(1, "Shopping Portal", "ShoppingCatalog.jsp", "shoppingdiv"));
        panelList.add(new Panel(2, "Job Portal", "jobPortal.jsp", "jobdiv"));
        panelList.add(new Panel(3, "Book Price Comparator", "bookprice-home.jsp", "bookdiv"));
        panelList.add(new Panel(4, "News", "AdminNews.jsp", "newsdiv"));
        panelList.add(new Panel(5, "Events", "AdminEvent.jsp", "eventdiv"));
        panelList.add(new Panel(6, "Profile Directory", "profile-home.jsp", "profilediv"));
        return panelList;
    }
}
