package com.example.SalesIncentiveBackend;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.SalesIncentiveBackend.dto.SalesLineItemDto;
import com.example.SalesIncentiveBackend.model.Employee;
import com.example.SalesIncentiveBackend.model.Product;
import com.example.SalesIncentiveBackend.model.SalesLineItem;
import com.example.SalesIncentiveBackend.service.EmployeeService;
import com.example.SalesIncentiveBackend.service.ProductService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.hibernate.id.IntegralDataTypeHolder;
import org.springframework.web.multipart.MultipartFile;


public class CSVHelper {


    public static String TYPE = "text/csv";
    static String[] HEADERs = { "EmployeeId", "ProductId", "SoldDate", "SoldCost" };
    public static boolean hasCSVFormat(MultipartFile file) {
        if (TYPE.equals(file.getContentType())
                || file.getContentType().equals("application/vnd.ms-excel")) {
            return true;
        }

        return false;
    }

    public static List<SalesLineItemDto> csvToSalesLineItems(InputStream is) {

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<SalesLineItemDto> salesLineItemDtoList = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
            System.out.println("in line 53");

                SalesLineItemDto salesLineItemDto = new SalesLineItemDto();
                System.out.println("in line 56");
                salesLineItemDto.setEmpId(Integer.parseInt(csvRecord.get("EmployeeId")));
                System.out.println("in line 57");
                salesLineItemDto.setProductId(Integer.parseInt(csvRecord.get("ProductId")));
                System.out.println("in line 60");
                String start_dt = csvRecord.get("SoldDate");
                System.out.println("in line 60");
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("in line 60");
                Date date = (Date)formatter.parse(start_dt);
                System.out.println("in line 60");
                salesLineItemDto.setSoldDate(date);
                System.out.println("in line 60");
                System.out.println("in line 62");
                salesLineItemDto.setSoldCost(BigDecimal.valueOf(Long.parseLong(csvRecord.get("SoldCost"))));
                System.out.println("in line 64");

                System.out.println(salesLineItemDto.getEmpId());
                salesLineItemDtoList.add(salesLineItemDto);
            }

            return salesLineItemDtoList;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


}
