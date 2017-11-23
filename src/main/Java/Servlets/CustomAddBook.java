package Servlets;

import Entities.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;
import java.sql.Date;


@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
public class CustomAddBook extends Custom {

    public Book addBook(HttpServletRequest req) throws IOException, ServletException {
        Book book = new Book();
        book.setAddedDate(Date.valueOf((get(req, "addeddate"))));
        book.setAuthor(get(req, "author"));
        book.setBookId(get(req, "bookid"));
        book.setBookName(get(req, "bname"));
        book.setCategory(get(req, "category"));
        book.setShelfNo(get(req, "shelfno"));
        book.setColumNo(get(req, "column"));
        book.setEdition(get(req, "edition"));
        book.setIsbn(get(req, "isbn"));
        book.setRowNo(get(req, "row"));
        book.setPrice(Float.parseFloat(get(req, "price")));
        book.setAvailable("yes");
        String image_url = getImage(req);
        book.setPhoto(image_url);
        return book;
    }


    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");

        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    private String getImage(HttpServletRequest req) throws IOException, ServletException {
        Part filePart = req.getPart("photo");
        String photo = "";
        String path = "D:\\JavaProjects\\LibraryManagementSystem\\src\\main\\webapp\\images";
        File file = new File(path);
        file.mkdir();

        String fileName = getFileName(filePart);

        OutputStream outputStream = null;

        InputStream filecontent = null;
        try {
            outputStream = new FileOutputStream(new File(path + File.separator
                    + fileName));

            filecontent = filePart.getInputStream();


            int read = 0;
            final byte[] bytes = new byte[1024];

            while ((read = filecontent.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);

                photo = path + "\\" + fileName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return photo;
    }

}



