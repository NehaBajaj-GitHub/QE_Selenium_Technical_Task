package com.selenium.common;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class for reading data from Excel files.
 */
public class ExcelReader {

    /**
     * Reads data from a specified sheet in an Excel file and returns it as a list of maps.
     * Each map represents a row with column headers as keys and cell values as values.
     *
     * @param excelFilePath The path to the Excel file.
     * @param sheetName     The name of the sheet to read.
     * @return List of maps, each representing a row in the sheet.
     * @throws InvalidFormatException If the format of the file is invalid.
     * @throws IOException           If an I/O error occurs.
     */
    public List<Map<String, String>> getData(String excelFilePath, String sheetName)
            throws InvalidFormatException, IOException {
        Sheet sheet = getSheetByName(excelFilePath, sheetName);
        return readSheet(sheet);
    }

    private Sheet getSheetByName(String excelFilePath, String sheetName) throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(new File(excelFilePath));
        return workbook.getSheet(sheetName);
    }

    private List<Map<String, String>> readSheet(Sheet sheet) {
        List<Map<String, String>> excelRows = new ArrayList<>();
        int headerRowNumber = getHeaderRowNumber(sheet);
        if (headerRowNumber != -1) {
            Row headerRow = sheet.getRow(headerRowNumber);
            for (Row row : sheet) {
                if (row.getRowNum() > headerRowNumber) { // Skip header row
                    Map<String, String> rowData = readRow(headerRow, row);
                    excelRows.add(rowData);
                }
            }
        }
        return excelRows;
    }

    private Map<String, String> readRow(Row headerRow, Row dataRow) {
        LinkedHashMap<String, String> rowData = new LinkedHashMap<>();
        dataRow.forEach(cell -> {
            int columnIndex = cell.getColumnIndex();
            Cell headerCell = headerRow.getCell(columnIndex);
            String key = getCellValueAsString(headerCell);
            String value = getCellValueAsString(cell);
            rowData.put(key, value);
        });
        return rowData;
    }

    private String getCellValueAsString(Cell cell) {
        switch (cell.getCellType()) {
            case STRING: return cell.getStringCellValue();
            case NUMERIC: return NumberToTextConverter.toText(cell.getNumericCellValue());
            case BOOLEAN: return Boolean.toString(cell.getBooleanCellValue());
            case ERROR: return Byte.toString(cell.getErrorCellValue());
            default: return "";
        }
    }

    private int getHeaderRowNumber(Sheet sheet) {
        for (Row row : sheet) {
            if (isRowHeader(row)) {
                return row.getRowNum();
            }
        }
        return -1;
    }

    private boolean isRowHeader(Row row) {
        for (Cell cell : row) {
            if (cell.getCellType() == CellType.STRING) {
                return true; // Assumes a header row contains at least one string cell
            }
        }
        return false;
    }
}
