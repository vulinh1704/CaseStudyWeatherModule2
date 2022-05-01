package menu;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsingURL {
    private static String getContentFrom(String link) throws IOException {
        URL url = new URL(link);
        Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
        scanner.useDelimiter("\\Z");
        String content = scanner.next();
        scanner.close();
        content = content.replaceAll("\\n", "");
        return content;
    }

    // lấy phụ đề dự báo
    public static String[] getUpdateTime() throws IOException {
        String content = getContentFrom("https://nchmf.gov.vn/Kttvsite/vi-VN/1/ha-noi-w28.html");
        Pattern p = Pattern.compile("</span>(.*: \\d{1,2}\\w{1}.*)</div>");
        Matcher m = p.matcher(content);
        String disPlay = "";
        while (m.find()) {
            disPlay += m.group(1) + "\n";
        }
        String[] listTimeUpdate = disPlay.split("\n");
        return listTimeUpdate;
    }

    // lấy thông tin dự báo hôm nay
    public static String[] getForecastInformation() throws IOException {
        String content = getContentFrom("https://nchmf.gov.vn/Kttvsite/vi-VN/1/ha-noi-w28.html");
        Pattern p = Pattern.compile(">: (.*?)</div>");
        Matcher m = p.matcher(content);
        String disPlay = "";
        while (m.find()) {
            disPlay += m.group(1) + "\n";
        }
        String[] listTheTemperature = disPlay.split("\n");
        return listTheTemperature;
    }

    // lấy ngày dự báo
    public static String[] getForecastDate() throws IOException {
        String content = getContentFrom("https://nchmf.gov.vn/Kttvsite/vi-VN/1/ha-noi-w28.html");
        Pattern p = Pattern.compile("=\"\\w{4}-\\w{2}\">(.*?)(</div>)");
        Matcher m = p.matcher(content);
        String disPlay = "";
        while (m.find()) {
            disPlay += m.group(1) + "\n";
        }
        String[] listForecastDate = disPlay.split("\n");
        return listForecastDate;
    }

    public static String[] getTheDayInformationFromURL() throws IOException {
        String content = getContentFrom("https://nchmf.gov.vn/Kttvsite/vi-VN/1/ha-noi-w28.html");
        Pattern p = Pattern.compile("=\"\\w{5}-\\w{4}\">(.*?)(</span>)");
        Matcher m = p.matcher(content);
        String disPlay = "";
        while (m.find()) {
            disPlay += m.group(1) + "\n";
        }
        String[] listLargeTemp = disPlay.split("\n");
        return listLargeTemp;
    }

    public static String[] getGeneralInformation() throws IOException {
        String content = getContentFrom("https://www.nchmf.gov.vn/kttv/");
        Pattern p = Pattern.compile("\\w\\d>(.*?)</\\w\\d>");
        Matcher m = p.matcher(content);
        String disPlay = "";
        while (m.find()) {
            disPlay += m.group(1) + "\n";
        }
        String[] listGeneralInformation = disPlay.split("\n");
        return listGeneralInformation;
    }

    public static void main(String[] args) throws IOException {
        String[] strings = getGeneralInformation();
        for (String s : strings) {
            System.out.print(s + "\n");
        }

    }


}
