/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FortyNinerZone;

/**
 *
 * @author priyanka
 */
public class Panel {
    public int PanelId;
    public String PanelName;
    public String PanelURL;
    public String PanelDiv;

    public int getPanelId() {
        return PanelId;
    }

    public String getPanelName() {
        return PanelName;
    }

    public String getPanelURL() {
        return PanelURL;
    }

    public void setPanelId(int PanelId) {
        this.PanelId = PanelId;
    }

    public void setPanelName(String PanelName) {
        this.PanelName = PanelName;
    }

    public void setPanelURL(String PanelURL) {
        this.PanelURL = PanelURL;
    }

    public String getPanelDiv() {
        return PanelDiv;
    }

    public void setPanelDiv(String PanelDiv) {
        this.PanelDiv = PanelDiv;
    }   
    
    public Panel(int PanelId, String PanelName, String PanelURL, String PanelDiv) {
        this.PanelId = PanelId;
        this.PanelName = PanelName;
        this.PanelURL = PanelURL;
        this.PanelDiv = PanelDiv;
    }    
}
