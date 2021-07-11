package ru.job4j.oop;

public class ReportUsage {

    public static void main(String[] args) {
        TextReport textReport = new TextReport();
        String text = textReport.generate("Report's name", "Report's body");
        System.out.println(text);
        System.out.println();
        HtmlReport htmlReport = new HtmlReport();
        String html = htmlReport.generate("Report's name", "Report's body");
        System.out.println(html);
        System.out.println();
        JSONReport jsonReport = new JSONReport();
        String json = jsonReport.generate("Report's name", "Report's body");
        System.out.println(json);
        System.out.println();
    }
}
