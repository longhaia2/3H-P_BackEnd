package tiengnhatmienphi.com.japanese.Helper;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import tiengnhatmienphi.com.japanese.Entity.Question;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelHelper {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {"Id","Term","Level","Content","Ans_A","Ans_B","Ans_C","Ans_D","Ans_Correct"};
    static String SHEET = "Tutorials";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<Question> excelToTutorials(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(SHEET);

            if (sheet == null) {
                throw new IllegalArgumentException("No sheet exists with name " + SHEET);
            }
            Iterator<Row> rows = sheet.iterator();

            List<Question> questions = new ArrayList<Question>();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                Question question = new Question();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    switch (cellIdx) {
                        case 0:
                            question.setId((int) currentCell.getNumericCellValue());
                            break;

                        case 1:
                            question.setTerm(currentCell.getStringCellValue());
                            break;

                        case 2:
                            question.setLevel(currentCell.getStringCellValue());
                            break;

                        case 3:
                            question.setContent(currentCell.getStringCellValue());
                            break;
                        case 4:
                            question.setAnsA(currentCell.getStringCellValue());
                            break;

                        case 5:
                            question.setAnsB(currentCell.getStringCellValue());
                            break;

                        case 6:
                            question.setAnsC(currentCell.getStringCellValue());
                            break;
                        case 7:
                            question.setAnsD(currentCell.getStringCellValue());
                            break;

                        case 8:
                            question.setAnsCorrect(currentCell.getStringCellValue());
                            break;

                        default:
                            break;
                    }

                    cellIdx++;
                }

                questions.add(question);
            }

            workbook.close();

            return questions;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }
}