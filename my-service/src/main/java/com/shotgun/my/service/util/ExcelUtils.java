/*
package com.shotgun.my.web.util;

import com.yunyihenkey.common.annotation.Export;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

*/
/**
 * @Author SunQ
 * @Date 2018/5/9 0009 9:35
 *//*

public class ExcelUtils<T> {

	private static final Logger logger = LoggerFactory.getLogger(ExcelUtils.class);

	*/
/** 行高 *//*

	private static final int ROW_HEOGHT = 25;

	Class<T> clazz;

	public ExcelUtils(Class<T> clazz) {
		this.clazz = clazz;
	}


	*/
/**
	 * 导入Excel
	 * @author SunQ
	 * @Date 18:18 2019/1/10
	 * @Param [sheetName, input]
	 * @return java.util.List<T>
	 *//*

	public List<T> importExcel(String sheetName, InputStream input) throws Exception {
		int maxCol = 0;
		List<T> list = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(input);
        Sheet sheet = null;

        if (sheetName!=null && !"".equals(sheetName.trim())) {
            // 如果指定sheet名,则取指定sheet中的内容.
            sheet = workbook.getSheet(sheetName);
        } else {
            // 如果传入的sheet名不存在则默认指向第1个sheet.
            sheet = workbook.getSheetAt(0);
        }
        int rows = sheet.getPhysicalNumberOfRows();
        if (rows > 0) {// 有数据时才处理
            // Field[] allFields = clazz.getDeclaredFields();// 得到类的所有field.
            List<Field> allFields = getMappedFiled(clazz, null);

            // 定义一个map用于存放列的序号和field.
            Map<Integer, Field> fieldsMap = new HashMap<>(allFields.size());
            for (Field field : allFields) {
                // 将有注解的field存放到map中.
                if (field.isAnnotationPresent(Export.class)) {
                    Export attr = field.getAnnotation(Export.class);
                    int col = attr.index();// 获得列号
                    maxCol = Math.max(col, maxCol) + 1;
                    // 设置类的私有字段属性可访问.
                    field.setAccessible(true);
                    fieldsMap.put(col, field);
                }
            }
            for (int i = 1; i < rows; i++) {
                // 从第2行开始取数据,默认第一行是表头.
                Row row = sheet.getRow(i);
                // int cellNum = row.getPhysicalNumberOfCells();
                // int cellNum = row.getLastCellNum();
                int cellNum = maxCol;
                T entity = null;
                for (int j = 0; j < cellNum; j++) {
                    Cell cell = row.getCell(j);
                    if (cell == null) {
                        continue;
                    }
                    int cellType = cell.getCellType();
                    String c = "";
                    if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {
                        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                        c = cell.getStringCellValue();
                    } else if (cellType == HSSFCell.CELL_TYPE_BOOLEAN) {
                        c = String.valueOf(cell.getBooleanCellValue());
                    } else {
                        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                        c = cell.getStringCellValue();
                    }
                    if (null == c || "".equals(c)) {
                        continue;
                    }
                    // 如果不存在实例则新建.
                    entity = entity == null ? clazz.newInstance() : entity;
                    // System.out.println(cells[j].getContents());
                    // 从map中得到对应列的field.
                    Field field = fieldsMap.get(j);
                    if (field == null) {
                        continue;
                    }
                    // 取得类型,并根据对象类型设置值.
                    Class<?> fieldType = field.getType();
                    if (String.class == fieldType) {
                        field.set(entity, c);
                    } else if (Integer.TYPE == fieldType || Integer.class == fieldType) {
                        field.set(entity, Integer.parseInt(c));
                    } else if (Long.TYPE == fieldType || Long.class == fieldType) {
                        field.set(entity, Long.valueOf(c));
                    } else if (Float.TYPE == fieldType || Float.class == fieldType) {
                        field.set(entity, Float.valueOf(c));
                    } else if (Short.TYPE == fieldType || Short.class == fieldType) {
                        field.set(entity, Short.valueOf(c));
                    } else if (Double.TYPE == fieldType || Double.class == fieldType) {
                        field.set(entity, Double.valueOf(c));
                    } else if (Character.TYPE == fieldType) {
                        if (c != null && c.length() > 0) {
                            field.set(entity, Character.valueOf(c.charAt(0)));
                        }
                    }

                }
                if (entity != null) {
                    list.add(entity);
                }
            }
        }
		return list;
	}

	*/
/**
	 * 对list数据源将其里面的数据导入到excel表单
	 *
	 * @Param [lists, sheetNames, output]
	 * @return boolean
	 *//*

	public boolean exportExcel(List<T>[] lists, String[] sheetNames, OutputStream output) {
		if (lists.length != sheetNames.length) {
			System.out.println("数组长度不一致");
			return false;
		}

		// 产生工作薄对象
		HSSFWorkbook workbook = new HSSFWorkbook();
		try {
			for (int ii = 0; ii < lists.length; ii++) {
				List<T> list = lists[ii];
				String sheetName = sheetNames[ii];

				List<Field> fields = getMappedFiled(clazz, null);

				// 产生工作表对象
				HSSFSheet sheet = workbook.createSheet();

				workbook.setSheetName(ii, sheetName);

				HSSFRow row;
				// 产生单元格
				HSSFCell cell;
				HSSFCellStyle style = workbook.createCellStyle();
				style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
				style.setFillBackgroundColor(HSSFColor.GREY_40_PERCENT.index);
				// 居中
				style.setAlignment(HorizontalAlignment.CENTER);

				// 产生一行
				row = sheet.createRow(0);
				// 写入各个字段的列头名称
				for (int i = 0; i < fields.size(); i++) {
					Field field = fields.get(i);
					Export attr = field.getAnnotation(Export.class);
					// 获得列号
					int col = attr.index();
					// 创建列
					cell = row.createCell(col);
					row.setHeight((short) (ROW_HEOGHT * 20));
					// 设置列中写入内容为String类型
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					// 写入列名
					cell.setCellValue(attr.title());
					cell.setCellStyle(style);
					// 设置列宽度
					sheet.setColumnWidth(col, attr.width() * 256);
				}

				// 遍历对象的属性，判断是否存在列为多行
				boolean isMultiline = false;
				for (Field field : fields) {
					// 设置实体类私有属性可访问
					field.setAccessible(true);
					Export attr = field.getAnnotation(Export.class);
					if (attr.isMultiline()) {
						isMultiline = true;
						break;
					}
				}

				int startNo = 0;
				int endNo = list.size();
				int rowNo = 0;
				// 写入各条记录,每条记录对应excel表中的一行
				for (int i = startNo; i < endNo; i++) {
					row = sheet.createRow(rowNo + 1);
					row.setHeight((short) (ROW_HEOGHT * 20));
					// 得到导出对象.
					T vo = list.get(i);

					// 获取列的行数
					int rowSize = 1;
					if (isMultiline) {
						bgm: for (Field field : fields) {
							// 设置实体类私有属性可访问
							field.setAccessible(true);
							Export attr = field.getAnnotation(Export.class);
							if (attr.isMultiline()) {
								String str = String.valueOf(field.get(vo));
								rowSize = str.split(",").length;
								break bgm;
							}
						}
					}

					for (int j = 0; j < fields.size(); j++) {
						// 获得field.
						Field field = fields.get(j);
						// 设置实体类私有属性可访问
						field.setAccessible(true);
						field.getType();
						Export attr = field.getAnnotation(Export.class);

						// 列是否多行
						if (attr.isMultiline()) {
							String str = String.valueOf(field.get(vo));
							String[] strArray = str.split(",");
							for (int irow = 0; irow < strArray.length; irow++) {
								HSSFRow cellRow = sheet.getRow(rowNo + 1 + irow);
								if (null == cellRow) {
									cellRow = sheet.createRow(rowNo + 1 + irow);
								}
								cellRow.setHeight((short) (ROW_HEOGHT * 20));
								// 创建cell
								HSSFCell cell2 = cellRow.createCell(attr.index());
								cell2.setCellType(HSSFCell.CELL_TYPE_STRING);
								cell2.setCellValue(strArray[irow]);
							}
						} else {
							// 创建cell
							cell = row.createCell(attr.index());
							cell.setCellType(HSSFCell.CELL_TYPE_STRING);
							if (rowSize > 1) {
								// 合并单元格
								// 起始行, 终止行, 起始列, 终止列
								CellRangeAddress cra = new CellRangeAddress(rowNo + 1, rowNo + rowSize, attr.index(),
										attr.index());
								sheet.addMergedRegion(cra);
							}
							// 对不同类型的数据进行处理
							if (field.getType() == Date.class) {
								// 如果数据存在就填入,不存在填入空格.
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								cell.setCellValue(field.get(vo) == null ? "" : sdf.format(field.get(vo)));
							} else {
								// 如果数据存在就填入,不存在填入空格.
								cell.setCellValue(field.get(vo) == null ? "" : String.valueOf(field.get(vo)));
							}
						}
					}
					rowNo += rowSize;
				}
			}
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage(), e);
		}

		try {
			output.flush();
			workbook.write(output);
			output.close();
			return true;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			System.out.println("Output inputStream closed ");
			return false;
		}
	}

	*/
/**
	 * 对list数据源将其里面的数据导入到excel表单
	 *
	 * @param list
	 *
	 * @param sheetName
	 *            工作表的名称
	 * @param output
	 *            java输出流
	 *//*

	@SuppressWarnings("unchecked")
	public boolean exportExcel(List<T> list, String sheetName, OutputStream output) {
		// 此处 对类型进行转换
		List<T> ilist = new ArrayList<>();
		for (T t : list) {
			ilist.add(t);
		}
		List<T>[] lists = new ArrayList[1];
		lists[0] = ilist;

		String[] sheetNames = new String[1];
		sheetNames[0] = sheetName;

		return exportExcel(lists, sheetNames, output);
	}

	*/
/**
	 * 设置单元格上提示
	 *
	 * @param sheet
	 *            要设置的sheet.
	 * @param promptTitle
	 *            标题
	 * @param promptContent
	 *            内容
	 * @param firstRow
	 *            开始行
	 * @param endRow
	 *            结束行
	 * @param firstCol
	 *            开始列
	 * @param endCol
	 *            结束列
	 * @return 设置好的sheet.
	 *//*

	public static HSSFSheet setHSSFPrompt(HSSFSheet sheet, String promptTitle, String promptContent, int firstRow,
			int endRow, int firstCol, int endCol) {
		// 构造constraint对象
		DVConstraint constraint = DVConstraint.createCustomFormulaConstraint("DD1");
		// 四个参数分别是：起始行、终止行、起始列、终止列
		CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
		// 数据有效性对象
		HSSFDataValidation data_validation_view = new HSSFDataValidation(regions, constraint);
		data_validation_view.createPromptBox(promptTitle, promptContent);
		sheet.addValidationData(data_validation_view);
		return sheet;
	}

	*/
/**
	 * 设置某些列的值只能输入预制的数据,显示下拉框.
	 *
	 * @param sheet
	 *            要设置的sheet.
	 * @param textlist
	 *            下拉框显示的内容
	 * @param firstRow
	 *            开始行
	 * @param endRow
	 *            结束行
	 * @param firstCol
	 *            开始列
	 * @param endCol
	 *            结束列
	 * @return 设置好的sheet.
	 *//*

	public static HSSFSheet setHSSFValidation(HSSFSheet sheet, String[] textlist, int firstRow, int endRow,
			int firstCol, int endCol) {
		// 加载下拉列表内容
		DVConstraint constraint = DVConstraint.createExplicitListConstraint(textlist);
		// 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列
		CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
		// 数据有效性对象
		HSSFDataValidation data_validation_list = new HSSFDataValidation(regions, constraint);
		sheet.addValidationData(data_validation_list);
		return sheet;
	}

	*/
/**
	 * 得到实体类所有通过注解映射了数据表的字段
	 *
	 * @Param [clazz, fields]
	 * @return java.util.List<java.lang.reflect.Field>
	 *//*

	@SuppressWarnings("rawtypes")
	private List<Field> getMappedFiled(Class clazz, List<Field> fields) {
		if (fields == null) {
			fields = new ArrayList<>();
		}

		// 得到所有定义字段
		Field[] allFields = clazz.getDeclaredFields();
		// 得到所有field并存放到一个list中.
		for (Field field : allFields) {
			if (field.isAnnotationPresent(Export.class)) {
				fields.add(field);
			}
		}
		if (clazz.getSuperclass() != null && !clazz.getSuperclass().equals(Object.class)) {
			getMappedFiled(clazz.getSuperclass(), fields);
		}

		return fields;
	}
}
*/
