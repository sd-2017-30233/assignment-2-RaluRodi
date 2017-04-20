package bookstore;

public class CsvReportFactory extends ReportFactory{
	
	public Report buildFile()
    {
        CsvReport report=new CsvReport();
        return report;
    }

}
