package com.test.Tool;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class InsertByExcel {

  //默认单元格内容为数字时格式
  private static DecimalFormat df = new DecimalFormat("0");
  // 默认单元格格式化日期字符串
  private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  // 格式化数字
  private static DecimalFormat nf = new DecimalFormat("0.00");

  public static ArrayList<ArrayList<Object>> readExcel(File file) throws IOException {
    if (file == null) {
      return null;
    }
    if (file.getName().endsWith("xlsx")) {
      //处理ecxel2007
      return readExcel2013(file);
    } else {
      //处理ecxel2013
      return readExcel2003(file);
    }
  }

  /*
   * @return 将返回结果存储在ArrayList内，存储结构与二位数组类似
   * lists.get(0).get(0)表示过去Excel中0行0列单元格
   */
  public static ArrayList<ArrayList<Object>> readExcel2003(File file) throws IOException {
    FileInputStream fileInputStream = null;
    try {
      ArrayList<ArrayList<Object>> rowList = new ArrayList<ArrayList<Object>>();
      ArrayList<Object> colList;
      fileInputStream = new FileInputStream(file);
      HSSFWorkbook wb = new HSSFWorkbook(fileInputStream);
      HSSFSheet sheet = wb.getSheetAt(0);
      HSSFRow row;
      HSSFCell cell;
      Object value;
      for (int i = sheet.getFirstRowNum(), rowCount = 0; rowCount < sheet.getPhysicalNumberOfRows();
          i++) {
        row = sheet.getRow(i);
        colList = new ArrayList<Object>();
        if (row == null) {
          //当读取行为空时
          if (i != sheet.getPhysicalNumberOfRows()) {//判断是否是最后一行
            rowList.add(colList);
          }
          continue;
        } else {
          rowCount++;
        }
        for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
          cell = row.getCell(j);
          if (cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
            //当该单元格为空
            if (j != row.getLastCellNum()) {//判断是否是该行中最后一个单元格
              colList.add("");
            }
            continue;
          }
          switch (cell.getCellType()) {
            case XSSFCell.CELL_TYPE_STRING:

              value = cell.getStringCellValue();
              break;
            case XSSFCell.CELL_TYPE_NUMERIC:
              if ("@".equals(cell.getCellStyle().getDataFormatString())) {
                value = df.format(cell.getNumericCellValue());
              } else if ("General".equals(cell.getCellStyle()
                  .getDataFormatString())) {
                value = nf.format(cell.getNumericCellValue());
              } else {
                value = sdf.format(HSSFDateUtil.getJavaDate(cell
                    .getNumericCellValue()));
              }
              break;
            case XSSFCell.CELL_TYPE_BOOLEAN:
              value = Boolean.valueOf(cell.getBooleanCellValue());
              break;
            case XSSFCell.CELL_TYPE_BLANK:
              value = "";
              break;
            default:
              value = cell.toString();
          }// end switch
          colList.add(value);
        }//end for j
        rowList.add(colList);
      }//end for i

      return rowList;
    } catch (Exception e) {
      return null;
    } finally {
      fileInputStream.close();
    }
  }

  public static ArrayList<ArrayList<Object>> readExcel2013(File file) throws IOException {
    FileInputStream fileInputStream = null;
    try {
      ArrayList<ArrayList<Object>> rowList = new ArrayList<ArrayList<Object>>();
      ArrayList<Object> colList;
      fileInputStream = new FileInputStream(file);
      XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
      XSSFSheet sheet = wb.getSheetAt(0);
      XSSFRow row;
      XSSFCell cell;
      Object value;
      for (int i = sheet.getFirstRowNum(), rowCount = 0; rowCount < sheet.getPhysicalNumberOfRows();
          i++) {
        row = sheet.getRow(i);
        colList = new ArrayList<Object>();
        if (row == null) {
          //当读取行为空时
          if (i != sheet.getPhysicalNumberOfRows()) {//判断是否是最后一行
            rowList.add(colList);
          }
          continue;
        } else {
          rowCount++;
        }
        for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
          cell = row.getCell(j);
          if (cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
            //当该单元格为空
            if (j != row.getLastCellNum()) {//判断是否是该行中最后一个单元格
              colList.add("");
            }
            continue;
          }
          switch (cell.getCellType()) {
            case XSSFCell.CELL_TYPE_STRING:

              value = cell.getStringCellValue();
              break;
            case XSSFCell.CELL_TYPE_NUMERIC:
              if ("@".equals(cell.getCellStyle().getDataFormatString())) {
                value = df.format(cell.getNumericCellValue());
              } else if ("General".equals(cell.getCellStyle()
                  .getDataFormatString())) {
                value = nf.format(cell.getNumericCellValue());
              } else {
                value = sdf.format(HSSFDateUtil.getJavaDate(cell
                    .getNumericCellValue()));
              }

              break;
            case XSSFCell.CELL_TYPE_BOOLEAN:

              value = Boolean.valueOf(cell.getBooleanCellValue());
              break;
            case XSSFCell.CELL_TYPE_BLANK:

              value = "";
              break;
            default:

              value = cell.toString();
          }// end switch
          colList.add(value);
        }//end for j
        rowList.add(colList);
      }//end for i

      return rowList;
    } catch (Exception e) {
      System.out.println("exception");
      return null;
    } finally {
      fileInputStream.close();
    }
  }
}
