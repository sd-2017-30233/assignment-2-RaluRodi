package bookstore;

public class PdfReportFactory extends ReportFactory {
	
	public Report buildFile()
    {
        PdfReport report=new PdfReport();
        return report;
    }
}
