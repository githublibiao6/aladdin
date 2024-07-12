package com.aladdin.mis.file.common;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试
 * @author cles
 */
public class WordToPDFConverter {


    public static void main(String[] args) throws IOException, InvalidFormatException {
        // 加载Word文档
        try {
            InputStream in = new FileInputStream("E:\\lb\\test\\123.docx");
            XWPFDocument document = new XWPFDocument(in);
            List<XWPFParagraph> list = document.getParagraphs();

            String outPath = "E:\\lb\\test\\456.pdf";
            // 创建PDF文档
            Document pdfDocument = new Document();
            PdfWriter pdfWriter = PdfWriter.getInstance(pdfDocument, new FileOutputStream(outPath));
            pdfDocument.open();
            // 遍历Word文档中的每一页
            for (XWPFParagraph paragraph : list) {
                System.err.println(paragraph.getText());
                pdfDocument.add(new Paragraph(paragraph.getText()));
            }
            pdfDocument.close();
            pdfWriter.close();
        }catch ( Exception e){
            e.printStackTrace();
        }
    }
}