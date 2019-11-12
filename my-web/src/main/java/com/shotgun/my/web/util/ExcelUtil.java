package com.shotgun.my.web.util;/*
package com.shotgun.my.web.util;

import com.yunyihenkey.common.utils.DateUtil;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

*/
/**
 * @desc
 * @author wulm
 * @date 2018年7月4日 下午3:06:01
 * @version 1.0.0
 *//*

public class ExcelUtil {

	*/
/** 读取行回调（线性安全，可使用static作为静态变量） *//*

	public interface RowCallBack<E> {
		*/
/** 回调设置对象属性值 *//*

		E setBeanDate(Row row);
	}

	private static final Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

	*/
/**
	 * @desc 将数据写入到Excel
	 * @auth wulm
	 * @date 2018年7月4日 下午5:39:38
	 * @param os
	 *            输出流
	 * @param dataList
	 *            数据
	 *//*

	public static void exportAndCloseByList(OutputStream os, List<List<Object>> dataList) {
		exportAndCloseByList(os, null, dataList);
	}

	*/
/**
	 *
	 * @desc 将数据写入到Excel
	 * @auth wulm
	 * @date 2018年7月5日 下午2:18:22
	 * @param os
	 *            输出流
	 * @param headers
	 *            头部
	 * @param dataList
	 *            数据
	 *//*

	public static void exportAndCloseByList(OutputStream os, List<List<Object>> headers, List<List<Object>> dataList) {

		Workbook wb;
		if (dataList != null && dataList.size() > 10000) {
			wb = newWorkbook2007xlsxBigData();
		} else {
			wb = newWorkbook2007xlsx();
		}
		// 创建表格
		Sheet createSheet = wb.createSheet();
		// 设置数据
		exportByList(createSheet, headers, dataList);

		try {
			// 写入文件并关闭流
			IOUtils.writeAndClose(wb, os);
		} catch (IOException e) {
			logger.error("Excel文件写入失败!!!!!!!!!!!!!!!!!!!!!!!!!!!Excel文件写入失败!!!!!!!!!!!!!!!!!!!!!!!!!!!", e);
			throw new RuntimeException("Excel文件写入失败!!!!!!!!!!!!!!!!!!!!!!!!!!!请检查!!!!");
		}
	}

	public static void exportAndCloseByMap(OutputStream os, List<List<Object>> headers,
			List<Map<String, Object>> dataMapList) {

		Workbook wb;
		if (dataMapList != null && dataMapList.size() > 10000) {
			wb = newWorkbook2007xlsxBigData();
		} else {
			wb = newWorkbook2007xlsx();
		}
		// 创建表格
		Sheet createSheet = wb.createSheet();
		// 设置数据
		exportByMap(createSheet, headers, dataMapList);

		try {
			// 写入文件并关闭流
			IOUtils.writeAndClose(wb, os);
		} catch (IOException e) {
			logger.error("Excel文件写入失败!!!!!!!!!!!!!!!!!!!!!!!!!!!Excel文件写入失败!!!!!!!!!!!!!!!!!!!!!!!!!!!", e);
			throw new RuntimeException("Excel文件写入失败!!!!!!!!!!!!!!!!!!!!!!!!!!!请检查!!!!");
		}
	}

	*/
/**
	 * @desc 将数据写入到Excel
	 * @auth wulm
	 * @date 2018年7月4日 下午5:39:38
	 * @param os
	 *            输出流
	 * @param dataList
	 *            数据
	 *//*

	public static void exportAndCloseByMap(OutputStream os, List<Map<String, Object>> dataMapList) {
		List<List<Object>> headers = new ArrayList<>();
		// 默认使用表头作为头部
		if (dataMapList != null && !dataMapList.isEmpty()) {
			headers.add(new ArrayList<>(dataMapList.get(0).keySet()));
		}

		exportAndCloseByMap(os, headers, dataMapList);
	}

	*/
/**
	 * @desc Excel内容追加，在最后一行进行追加数据
	 * @auth wulm
	 * @date 2018年7月4日 下午4:18:11
	 * @param sheet
	 *            表格
	 * @param dataList
	 *            数据
	 *//*

	public static void exportAppendDataByList(Sheet sheet, List<List<Object>> dataList) {
		// 设置表数据
		setDataByList(sheet, sheet.getLastRowNum() + 1, dataList);
	}

	*/
/**
	 *
	 * @desc 对Excel内容追加，在最后一行进行追加数据
	 * @auth josnow
	 * @date 2017年4月19日 上午9:40:16
	 * @param sheet
	 *            表
	 * @param dataMapList
	 *            数据，建议使用LinkedHashMap
	 * @param onSetCellValue
	 *//*

	public static void exportAppendDataByMap(Sheet sheet, List<Map<String, Object>> dataMapList) {
		// 追加表数据
		setDataByMap(sheet, sheet.getLastRowNum() + 1, dataMapList);
	}

	*/
/**
	 * @desc 将数据写入Excel
	 * @auth wulm
	 * @date 2018年7月4日 下午3:44:32
	 * @param sheet
	 *            表格
	 * @param dataList
	 *            数据
	 *//*

	public static void exportByList(Sheet sheet, List<List<Object>> dataList) {
		exportByList(sheet, null, dataList);
	}

	*/
/**
	 * @desc 将数据写入Excel
	 * @auth wulm
	 * @date 2018年7月4日 下午3:40:38
	 * @param sheet
	 *            表格
	 * @param headers
	 *            标题，可以为多行标题
	 * @param dataList
	 *            数据
	 *//*

	public static void exportByList(Sheet sheet, List<List<Object>> headers, List<List<Object>> dataList) {
		if (headers != null && !headers.isEmpty()) {
			// 设置表头
			// setSheetHeader(sheet, headers);
			setDataByList(sheet, 0, headers);
			// 设置表数据
			setDataByList(sheet, headers.size(), dataList);
		} else {
			// 设置表数据
			setDataByList(sheet, 0, dataList);
		}
	}

	*/
/**
	 *
	 * @desc 往Excel文件里写入数据
	 * @auth josnow
	 * @date 2017年4月19日 上午9:40:42
	 * @param sheet
	 *            表
	 * @param headers
	 *            表头
	 * @param dataMapList
	 *            数据，建议使用LinkedHashMap
	 *//*

	public static void exportByMap(Sheet sheet, List<List<Object>> headers, List<Map<String, Object>> dataMapList) {
		if (headers != null && !headers.isEmpty()) {
			// 设置表头
			setDataByList(sheet, 0, headers);
			// 设置表数据
			setDataByMap(sheet, headers.size(), dataMapList);
		} else {
			// 设置表数据
			setDataByMap(sheet, 0, dataMapList);
		}
	}

	*/
/**
	 *
	 * @desc 将数据写入Excel
	 * @auth wulm
	 * @date 2018年7月5日 下午3:45:09
	 * @param sheet
	 *            表格
	 * @param dataMapList
	 *            数据（默认使用表头作为头部）
	 *//*

	public static void exportByMap(Sheet sheet, List<Map<String, Object>> dataMapList) {
		List<List<Object>> headers = new ArrayList<>();
		// 默认使用表头作为头部
		if (dataMapList != null && !dataMapList.isEmpty()) {
			headers.add(new ArrayList<>(dataMapList.get(0).keySet()));
		}
		exportByMap(sheet, headers, dataMapList);
	}

	*/
/** 从cell读取字符串 *//*

	public static String getStringCellValue(Cell cell) {
		if (cell != null) {
			return cell.getStringCellValue();
		} else {
			return null;
		}
	}

	*/
/**
	 *
	 * @desc 从Excel文件中导入到实体类中,默认从第二行开始读取
	 * @auth wulm
	 * @date 2018年7月4日 下午7:10:39
	 * @param inputStream
	 *            输入流
	 * @param c
	 *            接收对象的类
	 * @param rowCallBack
	 *            回调
	 * @return 结果
	 *//*

	public static <E> List<E> importToBean(InputStream inputStream, RowCallBack<E> rowCallBack) throws IOException {
		// 默认使用第二行开始读取
		return importToBean(inputStream, rowCallBack, 1);
	}

	*/
/**
	 *
	 * @desc
	 * @auth wulm
	 * @date 2018年7月4日 下午7:11:38
	 * @param inputStream
	 *            输入流
	 * @param c
	 *            接收对象的类
	 * @param rowCallBack
	 *            回调
	 * @param startRow
	 *            开始读取行
	 * @return 结果
	 *//*

	public static <E> List<E> importToBean(InputStream inputStream, RowCallBack<E> rowCallBack, int startRow)
			throws IOException {
		Assert.notNull(inputStream, "输入流不能为空");
		Assert.notNull(rowCallBack, "转换类不能为空");
		Assert.isTrue(startRow>=1,"开始行不能小于1");//1表示从第二行开始

		ArrayList<E> resultList = new ArrayList<>();

		// // 获取接口类型s
		// Type[] interfacesTypes =
		// ClassUtils.getGenericInterfaces(rowCallBack.getClass());
		// // 获取接口泛型类
		// Type[] genericType2 = ClassUtils.getActualTypeArguments((ParameterizedType)
		// interfacesTypes[0]);
		// // 泛型类
		//
		// Class<E> classE = (Class<E>) genericType2[0];

		Workbook wb = newWorkbookUseTemplate(inputStream);
		// 使用第一个sheet表格作为导入
		Sheet sheetAt0 = wb.getSheetAt(0);

		// getLastRowNum 如果sheet中一行数据都没有则返回-1，只有第一行有数据则返回0，最后有数据的行是第n行则返回 n-1；
		for (int i = startRow; i <= sheetAt0.getLastRowNum(); i++) {
			Row row = sheetAt0.getRow(i);
			// E newE = classE.newInstance();
			// 回调设置对象属性值
			resultList.add(rowCallBack.setBeanDate(row));
		}
		// 关闭流
		wb.close();
		return resultList;
	}

	public static void main*/
/* List *//*
(String[] args) throws Exception {
		List<List<Object>> h = new ArrayList<>();

		List<List<Object>> dataList = new ArrayList<>();
		List<Object> l = new ArrayList<>();
		l.add("序号");
		l.add("姓名");
		l.add("年龄");
		h.add(l);

		List<Object> l2 = new ArrayList<>();
		l2.add("1");
		l2.add("张三");
		l2.add("20");
		dataList.add(l2);

		List<Object> l3 = new ArrayList<>();
		l3.add("2");
		l3.add("李四");
		l3.add("19");
		dataList.add(l3);

		FileOutputStream out = new FileOutputStream("D:/777.xlsx");

		exportAndCloseByList(out, h, dataList);

	}

	public static void mainMap(String[] args) throws Exception {
		// map测试

		List<Map<String, Object>> dataMapList = new ArrayList<>();

		Map<String, Object> map1 = new LinkedHashMap<>();
		map1.put("序号", 1);
		map1.put("姓名", "张三");
		map1.put("出生日期", "2010-01-01");
		dataMapList.add(map1);

		Map<String, Object> map2 = new LinkedHashMap<>();
		map2.put("序号", 2);
		map2.put("姓名", "李四");
		map2.put("出生日期", "2010-02-01");
		dataMapList.add(map2);

		Map<String, Object> map3 = new LinkedHashMap<>();
		map3.put("序号", 5);
		map3.put("姓名", "王五");
		map3.put("出生日期", "2010-05-01");
		dataMapList.add(map3);

		// FileInputStream fis = new FileInputStream("D:/666.xlsx");
		FileOutputStream out = new FileOutputStream("D:/777.xlsx");
		//
		// Workbook wb = newWorkbookUseTemplate(fis);
		// Sheet createSheet = wb.getSheetAt(0);
		// setData(createSheet, dataList);
		//
		// IOUtils.writeAndClose(wb, out);

		exportAndCloseByMap(out, dataMapList);

		// importExcel(t)
	}

	*/
/**
	 * @desc 创建Workbook
	 * @auth wulm
	 * @date 2018年7月4日 下午5:03:09
	 * @return
	 *//*

	public static Workbook newWorkbook2007xlsx() {
		return new XSSFWorkbook();
	}

	*/
/**
	 *
	 * @desc 创建Workbook，应对大数据导出
	 * @auth wulm
	 * @date 2018年7月4日 下午5:06:47
	 * @return
	 *//*

	public static Workbook newWorkbook2007xlsxBigData() {
		// 每1000条数据刷新到硬盘缓存
		return new SXSSFWorkbook(1000);
	}

	*/
/**
	 * @desc 创建Workbook 使用模板 (也可以用于编辑excel)
	 * @auth wulm
	 * @date 2018年7月4日 下午5:05:37
	 * @param inputStream
	 *            模板
	 * @return
	 *//*

	public static Workbook newWorkbookUseTemplate(InputStream inputStream) {
		try {
			return WorkbookFactory.create(inputStream);
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			logger.error("读取模板失败!!!!!!!!!!!!!!!!!!!读取模板失败!!!!!!!!!!!!!!!!!!!", e);
			throw new RuntimeException("读取模板失败!!!!!!!!!!!!!!!!!!!请检查!!!!");
		}
	}

	*/
/**
	 * @desc 替换表格数据
	 * @auth josnow
	 * @date 2017年6月9日 下午7:32:41
	 * @param sheet
	 * @param map
	 *//*

	public static void replaceData(Sheet sheet, Map<String, Object> map) {
		if (sheet == null || map == null || map.isEmpty()) {
			return;
		}
		int maxRowIndex = sheet.getLastRowNum();
		if (maxRowIndex < 0) {
			return;
		}
		for (int i = 0; i < maxRowIndex; i++) {
			Row row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			short lastCellIndex = row.getLastCellNum();
			if (lastCellIndex < 0) {
				continue;
			}
			for (short j = 0; j < lastCellIndex; j++) {
				Cell cell = row.getCell(j);
				if (cell == null || StringUtils.isEmpty(cell.toString())) {
					continue;
				}
				replaceCell(cell, map);
			}
		}

	}

	private static Cell getCellOrCreateOnNull(Row row, int j) {
		Cell cell = row.getCell(j);
		if (cell == null) {
			// 如果列不存在，则创建列
			cell = row.createCell(j);
		}
		return cell;
	}

	*/
/**
	 * @desc 替换单元格数据
	 * @auth wulm
	 * @date 2018年7月4日 下午3:33:06
	 * @param cell
	 * @param map
	 *//*

	private static void replaceCell(Cell cell, Map<String, Object> map) {
		for (Entry<String, Object> en : map.entrySet()) {
			String key = en.getKey();
			Object value = en.getValue();
			key = "${" + key + "}";

			String cellStr = cell.toString();
			if (cellStr.indexOf(key) > -1) {
				setCellValue(cell, cellStr.replace(key, value.toString()));
				break;
			}

		}
	}

	private static void setCellValue(Cell cell, Object cellValue) {
		if (cell == null || cellValue == null) {
			return;
		}
		if (cellValue instanceof String) {
			cell.setCellValue((String) cellValue);
		} else if (cellValue instanceof Double) {
			cell.setCellValue((Double) cellValue);
		} else if (cellValue instanceof Float) {
			cell.setCellValue((Float) cellValue);
		} else if (cellValue instanceof Integer) {
			cell.setCellValue((Integer) cellValue);
		} else if (cellValue instanceof Long) {
			cell.setCellValue((Long) cellValue);
		} else if (cellValue instanceof Date) {
			cell.setCellValue(DateUtil.format((Date) cellValue));
		} else if (cellValue instanceof Boolean) {
			cell.setCellValue((Boolean) cellValue);
		} else if (cellValue instanceof Byte) {
			cell.setCellValue((Byte) cellValue);
		} else if (cellValue instanceof Short) {
			cell.setCellValue((Short) cellValue);
		} else if (cellValue instanceof Calendar) {
			cell.setCellValue((Calendar) cellValue);
		} else if (cellValue instanceof RichTextString) {
			cell.setCellValue((RichTextString) cellValue);
		} else {
			cell.setCellValue(cellValue.toString());
		}
	}

	private static void setData(Sheet sheet, int startRowIndex, List<?> objectList) {
		Assert.notNull(sheet, "sheet表格不能为空");
		if (objectList == null || objectList.isEmpty()) {
			return;
		}

		// 注意：这里不能提取到for循环里面
		int rowIndex = startRowIndex;
		for (int i = 0; i < objectList.size(); i++) {

			Row row = sheet.getRow(rowIndex);
			if (row == null) {
				// 如果行不存在，则创建行
				row = sheet.createRow(rowIndex);
			}
			Object obj = objectList.get(i);
			if (obj instanceof List) {
				List<Object> cellList = (List<Object>) obj;

				if (cellList != null && !cellList.isEmpty()) {
					for (int j = 0; j < cellList.size(); j++) {
						Cell cell = getCellOrCreateOnNull(row, j);
						setCellValue(cell, cellList.get(j));
						// cell.setCellStyle(row.getRowStyle());
					}
				}
			} else if (obj instanceof Map) {
				Map<String, Object> cellMap = (Map<String, Object>) obj;

				if (cellMap != null && !cellMap.isEmpty()) {
					int j = 0;
					for (Object value : cellMap.values()) {
						Cell cell = getCellOrCreateOnNull(row, j);
						setCellValue(cell, value);
						// cell.setCellStyle(row.getRowStyle());
						j++;
					}
				}
			} else {
				throw new IllegalArgumentException("尚未开发！！！");
			}
			rowIndex++;
		}
	}

	*/
/**
	 * @desc 设置数据
	 * @auth wulm
	 * @date 2018年7月4日 下午4:25:04
	 * @param sheet
	 *            表格
	 * @param startRowIndex
	 *            开始行
	 * @param dataList
	 *            数据
	 *//*

	private static void setDataByList(Sheet sheet, int startRowIndex, List<List<Object>> dataList) {
		setData(sheet, startRowIndex, dataList);
	}

	private static void setDataByMap(Sheet sheet, int startRowIndex, List<Map<String, Object>> dataMapList) {
		setData(sheet, startRowIndex, dataMapList);
	}

}
*/
