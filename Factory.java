package bookstore;

public class Factory {
	
	    public Report getReport(String s)
	    {
	            if(s==null)
	                return null;
	            if(s.equalsIgnoreCase("PDF"))
	            {
	                PdfReportFactory f=new PdfReportFactory();
	                return f.buildFile();
	            }
	            if(s.equalsIgnoreCase("CSV"))
	            {
	                CsvReportFactory f=new CsvReportFactory();
	                return f.buildFile();
	            }
	            return null;
	    }
	}

