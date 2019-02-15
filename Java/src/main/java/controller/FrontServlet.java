package controller;

import database.DbConnection;
import general.StorageItem;
import items.Sword;
import repository.StorageItemRepository;

import javax.management.MXBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FrontServlet", urlPatterns = "/")
public class FrontServlet extends HttpServlet {


    private StorageItemRepository repository;

    @Override
    public void init(){
        repository = new StorageItemRepository();
    }

    //Displays all items from storage_item table
    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {

        List<StorageItem> storageItems = repository.getAll(DbConnection.getConnection());
        request.setAttribute("itemList",storageItems);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        StorageItem requestItem = new Sword();
        requestItem.setName(request.getParameter("itemName"));

        if(repository.create(requestItem,DbConnection.getConnection())) {
            response.setStatus(200);
        }
        else{
            response.setStatus(400);
        }

        response.sendRedirect("/");
    }
}
