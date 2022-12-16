package hu.masterfield.util;

import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;

import java.util.LinkedList;
import java.util.List;

public class ReportGalen {

    public static void reportUpdate(LayoutReport layoutReport) {
        try {
            List<GalenTestInfo> tests = new LinkedList<>();
            GalenTestInfo test = GalenTestInfo.fromString("SauceDemo products page check");
            test.getReport().layout(layoutReport, "Verify products layout");
            tests.add(test);
            new HtmlReportBuilder().build(tests, "target/galen-html-reports");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
