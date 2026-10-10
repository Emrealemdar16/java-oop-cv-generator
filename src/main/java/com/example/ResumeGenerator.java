package com.example;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.FileOutputStream;
import java.nio.file.Paths;

public class ResumeGenerator {
    
    public void createPdf(Person person, String outputFileName) {
        Document document = new Document();
        
        try {
            document.setMargins(50, 50, 50, 50); 
            
            PdfWriter.getInstance(document, new FileOutputStream(outputFileName));
            document.open();

            BaseColor primaryBlue = new BaseColor(44, 62, 80); 
            BaseColor darkGray = new BaseColor(85, 85, 85);

            String windowsDirectory = System.getenv().getOrDefault("WINDIR", "C:\\Windows");
            String fontPath = Paths.get(windowsDirectory, "Fonts", "arial.ttf").toString();
            BaseFont unicodeFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

            Font nameFont = new Font(unicodeFont, 26, Font.BOLD, primaryBlue);
            Font contactFont = new Font(unicodeFont, 11, Font.NORMAL, darkGray);
            Font sectionFont = new Font(unicodeFont, 16, Font.BOLD, primaryBlue);
            Font experienceFont = new Font(unicodeFont, 12, Font.NORMAL, BaseColor.BLACK);

          
            PdfPTable headerTable = new PdfPTable(2);
            headerTable.setWidthPercentage(100); 
            headerTable.setWidths(new float[]{3f, 1f});

            PdfPCell infoCell = new PdfPCell();
            infoCell.setBorder(Rectangle.NO_BORDER);
            infoCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            
           
            Paragraph namePara = new Paragraph(person.getName(), nameFont);
            namePara.setSpacingAfter(10f); 
            infoCell.addElement(namePara);
            
            infoCell.addElement(new Paragraph("E-posta: " + person.getEmail(), contactFont));
            infoCell.addElement(new Paragraph("Telefon: " + person.getPhone(), contactFont));
            infoCell.addElement(new Paragraph("LinkedIn: linkedin.com/in/emrealemdar", contactFont));
            
            headerTable.addCell(infoCell);

            PdfPCell photoCell = new PdfPCell();
            photoCell.setBorder(Rectangle.NO_BORDER);
            photoCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            
            try {
                Image photo = Image.getInstance(person.getPhotoPath());
                photo.scaleToFit(90, 110); 
                photo.setAlignment(Element.ALIGN_RIGHT);
                photoCell.addElement(photo);
            } catch (Exception e) {
                Paragraph noPhoto = new Paragraph("[Fotograf Bulunamadi]", contactFont);
                noPhoto.setAlignment(Element.ALIGN_RIGHT);
                photoCell.addElement(noPhoto);
            }
            headerTable.addCell(photoCell);
            document.add(headerTable);

           
            Paragraph spaceBeforeLine = new Paragraph(" ");
            spaceBeforeLine.setSpacingAfter(5f); 
            document.add(spaceBeforeLine); 
            
            LineSeparator ls = new LineSeparator();
            ls.setLineColor(BaseColor.LIGHT_GRAY);
            document.add(new Chunk(ls));
            
            Paragraph spaceAfterLine = new Paragraph(" ");
            spaceAfterLine.setSpacingAfter(15f); 
            document.add(spaceAfterLine);

          
            Paragraph expTitle = new Paragraph("İŞ DENEYİMLERİ", sectionFont);
            expTitle.setSpacingAfter(15f); 
            document.add(expTitle);

            for (String exp : person.getExperiences()) {
                String[] parts = exp.split("\n");
                
                Paragraph jobTitle = new Paragraph("• " + parts[0].trim(), experienceFont);
                jobTitle.setSpacingBefore(10f); 
                document.add(jobTitle);
                
                if (parts.length > 1) {
                    Paragraph jobDesc = new Paragraph(parts[1].trim(), experienceFont);
                    jobDesc.setIndentationLeft(15f);
                    jobDesc.setSpacingAfter(5f); 
                    document.add(jobDesc);
                }
            }

            System.out.println("PDF basariyla olusturuldu: " + outputFileName);

        } catch (Exception e) {
            System.err.println("PDF olusturulurken bir hata olustu: " + e.getMessage());
        } finally {
            document.close();
        }
    }
}