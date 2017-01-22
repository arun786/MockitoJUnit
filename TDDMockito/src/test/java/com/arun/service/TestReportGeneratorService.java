package com.arun.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.Calendar;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.arun.bean.ReportEntity;
import com.arun.report.ReportGenerator;

public class TestReportGeneratorService {

	@Mock
	private ReportGenerator reportGeneratorMock;
	@InjectMocks
	private ReportGeneratorService reportGeneratorService;
	@Captor
	private ArgumentCaptor<ReportEntity> reportCaptor;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void TestgenerateReport() {
		DateTime startDate = new DateTime(2016, 11, 30, 10, 5);
		DateTime endDate = new DateTime(9999, 12, 31, 10, 5);
		String content = "Report Content";
		reportGeneratorService.GenerateReport(startDate, endDate, content.getBytes());
		verify(reportGeneratorMock).reportGenerator(reportCaptor.capture());
		ReportEntity report = reportCaptor.getValue();
		assertEquals(2016, report.getStartDate().getYear());
		assertEquals(11, report.getStartDate().getMonthOfYear());
		assertEquals(30, report.getStartDate().getDayOfMonth());

	}
}
