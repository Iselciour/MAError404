package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import model.Obj;

@WebServlet("/Cart")
public class Cart extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Boolean existing = true;
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        
        List<Obj> item = (List<Obj>) session.getAttribute("item");
        
        if (item == null) {
            item = new ArrayList<>();
            session.setAttribute("item", item);
        }
        
        String addItem = request.getParameter("item");
        if (addItem != null && !addItem.trim().equals("")) {
            for(Obj items:item){
                if(items.getName().equals(addItem)){
                    items.setAv(items.getAv()+1);
                    existing = false;
                    break;
                }
            }
            if (existing) {
                Obj itemm = new Obj(addItem);
                itemm.setAv(1);
                item.add(itemm);
            }
        }
        try ( PrintWriter out = response.getWriter()) {
            out.print("<h1>Shopping Cart Wishlist</h1>");
            out.print("<br>");
            for (Obj itemm: item) {
            out.print("<li>"+itemm.getName()+ "  "+ itemm.getAv()+"</li>");
            }
            
            out.print("<br>");
            out.print("<a href='/shoppingCart'>Return to Main Menu</a>");
        }
    }
}