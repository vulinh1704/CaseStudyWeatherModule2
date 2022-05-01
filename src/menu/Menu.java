package menu;

import java.io.IOException;

public class Menu {
    public static void nearbyWeatherDisplay() {
        System.out.println("1.THỜI TIẾT HIỆN TẠI\n" +
                "2.DỰ BÁO THỜI TIẾT NGÀY HÔM NAY\n" +
                "3.DỰ BÁO THỜI TIẾT ĐÊM HÔM NAY\n" +
                "4.DỰ BÁO THỜI TIẾT 10 NGÀY TỚI\n" +
                "5.HIỂN THỊ MENU\n" +
                "0.THOÁT\n" +
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
                "10.Quay lại\n" +
                "Bạn muốn xem ngày nào ?");
    }

    public static String dateAfterCutting(int index) throws IOException {
        String[] listForecastDate = UsingURL.getForecastDate();
        String dayCut = listForecastDate[index].replaceAll("(<)\\w{4}(>)", "");
        dayCut = dayCut.replaceAll("(</)\\w{4}(>)", "");
        return dayCut;
    }
}
