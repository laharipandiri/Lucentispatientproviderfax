package com.juno.qa.getandsetTestData;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;

import com.juno.qa.util.ExcelTestDataReader;
import com.juno.qa.util.TestUtil;
import com.juno.qa.util.Xls_Reader;

public class ProviderGroups_Supervisors_NotesTab {
	
	TestUtil testUtil;
	Xls_Reader reader = new Xls_Reader(testUtil.TESTDATA_SHEET_PATH);
	ExcelTestDataReader etd = new ExcelTestDataReader();

	public List<String> GetPGSupervisorsNotesTestData(String Key, int rowNum)
	{
		List<String> testData = new ArrayList<String>();
		String sheetname = "Regression";
		reader.getSheet(sheetname);
		Row row = Xls_Reader.sheet.getRow(rowNum);
		
		if(Key.equalsIgnoreCase(row.getCell(0).toString()))
		{
			testData.add(0, NumberToTextConverter.toText(row.getCell(1).getNumericCellValue()));//GPNPI
			testData.add(1, row.getCell(2).toString());//Fieldrequiredmsg
			testData.add(2, row.getCell(3).toString());//Callerdropdowndefault
			testData.add(3, row.getCell(4).toString());//Reasondropdowndefault
			testData.add(4, row.getCell(5).toString());//Caller
			testData.add(5, row.getCell(6).toString());//Reason
			testData.add(6, row.getCell(7).toString());//Notes
			testData.add(7, row.getCell(8).toString());//ReasonCol
			testData.add(8, row.getCell(9).toString());//NotesCol
			testData.add(9, row.getCell(10).toString());//CardLoadIDCol
			testData.add(10, row.getCell(11).toString());//OriginatedFromCol
			testData.add(11, row.getCell(12).toString());//CreatedByCol
			testData.add(12, row.getCell(13).toString());//CreatedDateCol
			testData.add(13, row.getCell(14).toString());//ModifiedByCol
			testData.add(14, row.getCell(15).toString());//ModifiedDateCol
			testData.add(15, row.getCell(16).toString());//ActionCol
			testData.add(16, row.getCell(17).toString());//NotesAddedMsg
			testData.add(17, row.getCell(18).toString());//UpdatedTextNotes
			testData.add(18, row.getCell(19).toString());//CallerDropdownUpdate
			testData.add(19, row.getCell(20).toString());//ReasonDropdownUpdate
			testData.add(20, row.getCell(21).toString());//NotesUpdatedMessage
			
			return testData;
		}
		
		return null;
	}
}
