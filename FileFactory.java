package bookstore;

public class FileFactory {
	
	   public Report getReport(String reportType){
	      if(reportType == null){
	         return null;
	      }		
	      if(reportType.equalsIgnoreCase("PDF")){
	         return new PdfReport();
	         
	      } else if(reportType.equalsIgnoreCase("CSV")){
	         return new CsvReport();

	   }
	      return null;
	   }
}
