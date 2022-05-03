package weathermenu;

import java.io.IOException;
import java.util.Locale;

public class Menu {

    public static void generalWeatherMenu() throws IOException {
        String[] listGeneralInformation = UsingURL.getGeneralInformation();
        System.out.println("----- \uD83C\uDF24 KÊNH DỰ BÁO THỜI TIẾT NING7140 \u26C5 -----\n" +
                "1." + listGeneralInformation[2].toUpperCase(Locale.ROOT) + " \u2601 \n" +
                "2.HIỂN THỊ MENU \uD83D\uDD1B \n" +
                "3.QUẢN LÝ TÀI KHOẢN \u2699 \n" +
                "0.ĐĂNG XUẤT \u21A9 \n" +
                "Nhấn lựa chọn của bạn");
    }

    public static void menuAreas() throws IOException {
        String[] listGeneralInformation = UsingURL.getRegionalForecasts();
        System.out.println("-----THỜI TIẾT VIỆT NAM-----\n" +
                "1.HÀ NỘI\n" +
                "2." + listGeneralInformation[1].toUpperCase(Locale.ROOT) + "\n" +
                "3." + listGeneralInformation[2].toUpperCase(Locale.ROOT) + "\n" +
                "4." + listGeneralInformation[3].toUpperCase(Locale.ROOT) + "\n" +
                "5." + listGeneralInformation[4].toUpperCase(Locale.ROOT) + "\n" +
                "6." + listGeneralInformation[5].toUpperCase(Locale.ROOT) + "\n" +
                "7." + listGeneralInformation[6].toUpperCase(Locale.ROOT) + "\n" +
                "8.XEM LẠI MENU\n" +
                "0.QUAY LẠI\n" +
                "Nhấn lựa chọn của bạn");
    }

    public static void nearByWeatherDisplay() {
        System.out.println("-----THỜI TIẾT HÀ NỘI-----\n" +
                "1.THỜI TIẾT HIỆN TẠI\n" +
                "2.DỰ BÁO THỜI TIẾT NGÀY HÔM NAY\n" +
                "3.DỰ BÁO THỜI TIẾT ĐÊM HÔM NAY\n" +
                "4.DỰ BÁO THỜI TIẾT 10 NGÀY TỚI\n" +
                "5.HIỂN THỊ MENU\n" +
                "0.QUAY LẠI \uD83D\uDD19 \n" +
                "Nhấn lựa chọn của bạn");
    }

    public static void weatherMenuForTheNext9Days() throws IOException {
        System.out.println("DỰ BÁO THỜI TIẾT 9 NGÀY TỚI\n" +
                "1." + dateAfterCutting(0) + "\n" +
                "2." + dateAfterCutting(1) + "\n" +
                "3." + dateAfterCutting(2) + "\n" +
                "4." + dateAfterCutting(3) + "\n" +
                "5." + dateAfterCutting(4) + "\n" +
                "6." + dateAfterCutting(5) + "\n" +
                "7." + dateAfterCutting(6) + "\n" +
                "8." + dateAfterCutting(7) + "\n" +
                "9." + dateAfterCutting(8) + "\n" +
                "10.Quay lại \uD83D\uDD19 \n" +
                "Bạn muốn xem ngày nào ?");
    }

    public static String dateAfterCutting(int index) throws IOException {
        String[] listForecastDate = UsingURL.getForecastDate();
        String dayCut = listForecastDate[index].replaceAll("(<)\\w{4}(>)", "");
        dayCut = dayCut.replaceAll("(</)\\w{4}(>)", "");
        return dayCut;
    }

    public static void AccountManagementMenu() {
        System.out.println("-----QUẢN LÝ TÀI KHOẢN-----\n" +
                "1.XEM THÔNG TIN CÁC TÀI KHOẢN CỦA BẠN\n" +
                "2.XÓA TÀI KHOẢN\n" +
                "3.ĐĂNG KÍ\n" +
                "0.THOÁT \uD83D\uDD19"
        );
    }
}
