package com.arun.service;

import org.joda.time.DateTime;

import com.arun.bean.ReportEntity;
import com.arun.report.ReportGenerator;

public class ReportGeneratorService {

	private ReportGenerator reportGenerator;

	public void GenerateReport(DateTime startDate, DateTime endDate, byte[] content) {
		ReportEntity report = new ReportEntity();
		report.setContent(content);
		report.setStartDate(startDate);
		report.setEndDate(endDate);
		reportGenerator.reportGenerator(report);
	}

	public ReportGenerator getReportGenerator() {
		return reportGenerator;
	}

	public void setReportGenerator(ReportGenerator reportGenerator) {
		this.reportGenerator = reportGenerator;
	}
}
