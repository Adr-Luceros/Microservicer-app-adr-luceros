package com.service.excel_service.Service;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.service.excel_service.Dto.RecepcionData;

@Service
public class RecepcionService {

    @Autowired
    AgruparService agruparService;

    public List<RecepcionData> convertExcelToData(MultipartFile file) {
        List<RecepcionData> dataList = new ArrayList<>();

        try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
            int sheetIndex = workbook.getActiveSheetIndex();
            XSSFSheet sheetToProcess = workbook.getSheetAt(sheetIndex);

            Iterator<Row> rowIterator = sheetToProcess.rowIterator();
            if (!rowIterator.hasNext()) {
                throw new RuntimeException("The Excel file is empty.");
            }

            Row headerRow = rowIterator.next();
            List<String> headers = new ArrayList<>();
            for (Cell cell : headerRow) {
                headers.add(cell.toString().trim());
            }

            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                RecepcionData data = new RecepcionData();

                for (int i = 0; i < headers.size(); i++) {
                    Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String cellValue = cell.toString().trim();

                    switch (headers.get(i)) {
                        case "Ruc":
                            data.setRuc(cellValue);
                            break;
                        case "RazonSocial":
                            data.setRazonSocial(cellValue);
                            break;
                        case "Placa":
                            data.setPlaca(cellValue.substring(0, 7));
                            int indexInit = cellValue.indexOf("[") + 1;
                            int indexEnd = cellValue.indexOf("]");
                            String[] pickingArr = cellValue.substring(indexInit, indexEnd).split("-");
                            List<Integer> pickings = new ArrayList<>();
                            for (String pick : pickingArr) {
                                if (pick != "")
                                    pickings.add(Integer.parseInt(pick));
                            }
                            data.setPicking(pickings);
                            break;
                        case "Almacen":
                            data.setAlmacen(cellValue);
                            break;
                        case "PsEx":
                            data.setPsEx(cellValue);
                            break;
                        case "Destinatario":
                            data.setDestinatario(cellValue);
                            break;
                        case "Tienda":
                            data.setTienda(cellValue);
                            break;
                        case "Distrito":
                            data.setDistrito(cellValue);
                            break;
                        case "Direccion":
                            data.setDireccion(cellValue);
                            break;
                        case "Vh":
                            try {
                                if (!cellValue.isEmpty()) {
                                    String[] times = cellValue.split("-");
                                    if (times.length != 0) {
                                        if (!times[0].isEmpty()) {
                                            String startTimeStr = normalizeTime(times[0]);
                                            Time horaInicio = Time
                                                    .valueOf(LocalTime.parse(startTimeStr, timeFormatter));
                                            data.setHoraInicio(horaInicio);
                                        }

                                        if (!times[1].isEmpty()) {
                                            String endTimeStr = normalizeTime(times[1]);
                                            Time horaFinal = Time.valueOf(LocalTime.parse(endTimeStr, timeFormatter));
                                            data.setHoraFinal(horaFinal);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                // TODO: handle exception
                                // data -> 08:00 -12:00-14:00 - 16:00
                                // data -> 8 am-9 am
                                // data -> 8:00 AM A 12:00 PM-13:00 PM A 16:00 PM
                            }
                            break;
                        case "Documentacion":
                            data.setDocumentacion(cellValue);
                            break;
                        case "Observaciones":
                            data.setObservaciones(cellValue);
                            break;
                        case "Canal":
                            data.setCanal(cellValue);
                            break;
                        case "Volumen":
                            data.setVolumen(Float.parseFloat(cellValue));
                            break;
                    }
                }
                dataList.add(data);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while parsing Excel file: " + e.getMessage(), e);
        }
        return dataList;
    }

    private String normalizeTime(String time) {
        time = time.trim().replace(" ", "");
        String[] times = time.split(":");

        int hora = Integer.parseInt(times[0]);

        if (times.length == 2) {
            int minuto = Integer.parseInt(times[1]);
            String newTime = "";

            if (hora > 9) {
                newTime = String.valueOf(hora);
            } else {
                newTime = "0" + hora;
            }

            if (minuto > 9) {
                newTime = newTime + ":" + minuto;
            } else {
                newTime = newTime + ":0" + minuto;
            }
            return newTime;

        }

        String newTime = "";
        if (hora > 9) {
            newTime = String.valueOf(hora);
        } else {
            newTime = "0" + hora;
        }

        return newTime + ":00";
    }

}
