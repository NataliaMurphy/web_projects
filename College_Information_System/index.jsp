<%-- 
    Document   : index
    Created on : 15 Oct, 2014, 3:49:58 PM
    Author     : priyanka
--%>

<%@page import="FortyNinerZone.PanelDB"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="FortyNinerZone.Panel"%>
<%@include file="includes/header.jsp" %>
<%@include file="includes/site-navigation.jsp" %>
<script src="Scripts/jquery-1.11.1.min.js"></script>
<script src="Scripts/jquery-ui.min.js"></script>
<link rel="stylesheet" href="Scripts/jquery-ui.min.css">
<style>
    .column {
        width: 350px;
        float: left;
        height: 400px;
        margin-left: 20px;
        padding-right:20px; 

    }
    .portlet {
        margin: 0 1em 1em 0;
        padding: 0.3em;
        height:170px;
    }
    .portlet-header {
        padding: 0.2em 0.3em;
        margin-bottom: 0.5em;
        position: relative;
        background-color:#1F5C3D; 
        cursor: move;
    }
    .portlet-maximizer {
        position: absolute;
        top: 40%;
        right: 2px;
        margin-top: -8px;
        cursor: pointer;
    }
    .portlet-content {
        padding: 0.4em;
        height:120px;
        overflow:auto;
        background-position: 50% 50%;
        background-repeat: no-repeat;
    }
    .portlet-placeholder {
        border: 1px dotted black;
        margin: 0 1em 1em 0;
        height: 170px;
    }
    .maximg {
        height: 20px;
    }
</style>
<script>
    $(function () {
        $(".column").sortable({
            connectWith: ".column",
            handle: ".portlet-header",
            placeholder: "portlet-placeholder ui-corner-all",
            cancel: ".portlet-maximizer",
            over: function (evt, ui) {
                $(".column").css("height", "auto");
            }
        });

        $(".portlet")
                .addClass("ui-widget ui-widget-content ui-helper-clearfix ui-corner-all")
                .find(".portlet-header")
                .addClass("ui-widget-header ui-corner-all");
    });
    
    var panelArr = [];
    $(document).ready(function () {
        for(i = 0; i < panelArr.length ; i++) {
            loadPanelContent(panelArr[i].panelID, panelArr[i].panelURL);
        }
    });

    function loadPanelContent (panelID, contentURL) {
        var panelDivSelector = "#" + panelID;
        contentURL += "?v=widget";
        $.ajax({url: contentURL,
            beforeSend: function (xhr) {
                $(panelDivSelector).css("background-image", "url(images/ajax-loader.gif)");
            },
            success: function (result) {
                $(panelDivSelector).html(result);
                $(panelDivSelector).css("background-image", "");
            },
            error: function(xhr, status, err) {
                $(panelDivSelector).html(err);
                $(panelDivSelector).css("background-image", "");
            }
        });
    }

    function maximize(pageUrl) {
        window.open(pageUrl);
    }
</script>
<div id="content">

    <%
        List<Panel> panelList = PanelDB.getPanelList();
        for (int i = 0; i < panelList.size(); i++) {
            if (i % 2 == 0) {
    %>
    <div class="column">
        <%
            }
        %>
        <script>
            var p = {};
            p.panelID = "<%=panelList.get(i).PanelDiv%>";
            p.panelURL = "<%=panelList.get(i).PanelURL%>";
            panelArr.push(p);
        </script>
        <div class="portlet">
            <div class="portlet-header"><%=panelList.get(i).PanelName%>
                <span class="portlet-maximizer">
                    <img src="images/popout.gif" class="maximg" title="Maximize" 
                         onclick="maximize('<%=panelList.get(i).PanelURL%>')" />
                </span>
            </div>
            <div class="portlet-content" id="<%=panelList.get(i).PanelDiv%>">
                Loading...
            </div>
        </div>
        <%
            if ((i + 1) % 2 == 0) {
        %>
    </div>
    <%
            }
        }
    %>
</div>
<!--
    <div class="portlet">
        <div class="portlet-header">News</div>
        <div class="portlet-content">Lorem ipsum dolor sit amet, consectetuer adipiscing elit</div>
    </div> 

</div>  

<div class="column">

    <div class="portlet">
        <div class="portlet-header">Job Portal</div>
        <div class="portlet-content">Lorem ipsum dolor sit amet, consectetuer adipiscing elit</div>
    </div>

    <div class="portlet">
        <div class="portlet-header">Profile Directory</div>
        <div class="portlet-content">Lorem ipsum dolor sit amet, consectetuer adipiscing elit</div>
    </div>

</div>  
<div class="column">

    <div class="portlet">
        <div class="portlet-header">Book Price Comparator</div>
        <div class="portlet-content">Lorem ipsum dolor sit amet, consectetuer adipiscing elit</div>
    </div>
</div>

</div>-->
<%@include file="includes/footer.jsp" %>    