package com.aladdin.common.core.utils;

import com.aladdin.common.core.exception.BusinessException;
import com.aladdin.common.core.exception.GlobalErrorCode;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Excel导入导出工具
 *
 * @author cles
 * @date 2026/05/06
 */
public class ExcelUtil {

    /**
     * 导出Excel
     */
    public static <T> void export(HttpServletResponse response, String filename,
                                   LinkedHashMap<String, String> headers,
                                   List<T> dataList, ExcelRowConverter<T> converter) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Sheet1");

            Row headerRow = sheet.createRow(0);
            int colIndex = 0;
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                Cell cell = headerRow.createCell(colIndex++);
                cell.setCellValue(entry.getValue());
                CellStyle style = workbook.createCellStyle();
                Font font = workbook.createFont();
                font.setBold(true);
                style.setFont(font);
                cell.setCellStyle(style);
            }

            for (int i = 0; i < dataList.size(); i++) {
                Row row = sheet.createRow(i + 1);
                Map<String, Object> rowData = converter.convert(dataList.get(i));
                colIndex = 0;
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    Object value = rowData.get(entry.getKey());
                    Cell cell = row.createCell(colIndex++);
                    if (value != null) {
                        cell.setCellValue(value.toString());
                    }
                }
            }

            for (int i = 0; i < headers.size(); i++) {
                sheet.autoSizeColumn(i);
            }

            setResponseHeader(response, filename + ".xlsx");
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            throw new BusinessException(GlobalErrorCode.INTERNAL_ERROR, "导出Excel失败");
        }
    }

    /**
     * 导入Excel
     */
    public static List<Map<String, Object>> importExcel(InputStream inputStream, String filename) {
        try {
            Workbook workbook;
            if (filename.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(inputStream);
            } else if (filename.endsWith(".xls")) {
                workbook = new HSSFWorkbook(inputStream);
            } else {
                throw new BusinessException(GlobalErrorCode.BAD_REQUEST, "不支持的文件格式");
            }

            Sheet sheet = workbook.getSheetAt(0);
            Row headerRow = sheet.getRow(0);
            List<String> headerList = new ArrayList<>();
            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                headerList.add(getCellValue(headerRow.getCell(i)));
            }

            List<Map<String, Object>> result = new ArrayList<>();
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) {
                    continue;
                }
                Map<String, Object> rowData = new LinkedHashMap<>();
                for (int j = 0; j < headerList.size(); j++) {
                    Cell cell = row.getCell(j);
                    rowData.put(headerList.get(j), getCellValue(cell));
                }
                result.add(rowData);
            }
            workbook.close();
            return result;
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            throw new BusinessException(GlobalErrorCode.INTERNAL_ERROR, "导入Excel失败");
        }
    }

    private static String getCellValue(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                }
                double num = cell.getNumericCellValue();
                if (num == (long) num) {
                    return String.valueOf((long) num);
                }
                return String.valueOf(num);
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }

    private static void setResponseHeader(HttpServletResponse response, String filename) throws UnsupportedEncodingException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
    }

    @FunctionalInterface
    public interface ExcelRowConverter<T> {
        Map<String, Object> convert(T data);
    }
}
