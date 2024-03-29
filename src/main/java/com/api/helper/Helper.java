package com.api.helper;
//package info.java.file;

import com.api.entity.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helper {

    //check that file is excel type or not
    @SuppressWarnings("checkstyle:FinalParameters")
    public static boolean checkExcelFormat(MultipartFile file) {

    String contentType = file.getContentType();
    return contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        //("application/vnd.malformations-office document.spreadsheet.sheet");

    }

    //convert excel into list of products
    @SuppressWarnings
            ({"checkstyle:MissingJavadocMethod", "checkstyle:LeftCurly"})
    public static List<Product> convertExcelToListOfProduct(InputStream is) {
        List<Product> list = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(is);

            int count = workbook.getNumberOfSheets();
System.out.println(count);


            XSSFSheet sheet = workbook.getSheetAt( 0);

            int rowNumber = 0;


            for (Row row : sheet) {
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;

                }

                Iterator<Cell> cells = row.iterator();

                int cid = 0;
                Product p = new Product();


                while (cells.hasNext()) {
                    Cell cell = cells.next();

                    switch (cid) {
                        case 0:
                            p.setProductId((int) cell.getNumericCellValue());
                            break;

                        case 1:
                            p.setProductName(cell.getStringCellValue());
                            break;

                        case 2:
                            p.setProductDesc(cell.getStringCellValue());
                            break;

                        case 3:
                            p.setProductPrice((double)cell.getNumericCellValue());
                            break;
                        default:
                            break;

                    }

                    cid++;
                }

                list.add(p);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


}
