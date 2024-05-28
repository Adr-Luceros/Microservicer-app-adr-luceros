package com.api.viaje_service.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class RecepcionService {
    public static List<Map<String, Object>> convertExcelRow(MultipartFile file) {
        try {
            XSSFWorkbook workbok = new XSSFWorkbook(file.getInputStream());
            int sheetIndex = workbok.getActiveSheetIndex();
            XSSFSheet sheetToProcess = workbok.getSheetAt(sheetIndex);
            List<String> headers = new ArrayList<>();

            Iterator<Row> rows = sheetToProcess.rowIterator();

            rows.next().forEach(h -> headers.add(h.toString()));

            List<Map<String, Object>> rowsResult = new ArrayList<>();

            rows.forEachRemaining(row -> {
                Map<String, Object> rowMap = new LinkedHashMap<>();
                for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
                    rowMap.put(headers.get(i), row.getCell(i).toString().trim());
                }
                rowsResult.add(rowMap);
            });

            workbok.close();

            return rowsResult;

        } catch (Exception e) {
            throw new RuntimeException("Error occurred while parsing Excel file: " + e.getMessage());
        }
    }
}
